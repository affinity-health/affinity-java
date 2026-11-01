package smoke;

import com.affinity.api.AffinityClient;
import com.affinity.api.AffinityClientBuilder;
import com.affinity.api.core.AffinityClientApiException;
import com.affinity.api.core.pagination.SyncPagingIterable;
import com.affinity.api.errors.BadRequestError;
import com.affinity.api.errors.NotFoundError;
import com.affinity.api.errors.UnauthorizedError;
import com.affinity.api.errors.UnprocessableEntityError;
import com.affinity.api.resources.feedback.requests.CreateFeedbackRequest;
import com.affinity.api.resources.medications.requests.GetMedicationsRequest;
import com.affinity.api.resources.medications.requests.ListMedicationsRequest;
import com.affinity.api.resources.medications.types.GetMedicationsRequestExpandItem;
import com.affinity.api.resources.medications.types.GetMedicationsResponse;
import com.affinity.api.resources.orders.requests.CancelOrdersRequest;
import com.affinity.api.resources.orders.requests.ListOrdersRequest;
import com.affinity.api.resources.orders.requests.OrderInput;
import com.affinity.api.resources.orders.types.OrderInputShipping;
import com.affinity.api.resources.practices.requests.CreatePracticesRequest;
import com.affinity.api.resources.practices.requests.ListPracticesRequest;
import com.affinity.api.resources.practices.types.ListPracticesRequestSort;
import com.affinity.api.resources.practices.requests.UpdatePracticesRequest;
import com.affinity.api.resources.webhooks.requests.CreateWebhooksRequest;
import com.affinity.api.resources.webhooks.requests.ResendFailedWebhooksRequest;
import com.affinity.api.resources.webhooks.requests.UpdateWebhooksRequest;
import com.affinity.api.resources.webhooks.types.CreateWebhooksResponse;
import com.affinity.api.types.Account;
import com.affinity.api.types.AccountMode;
import com.affinity.api.types.AccountType;
import com.affinity.api.types.AddressInput;
import com.affinity.api.types.Medication;
import com.affinity.api.types.Order;
import com.affinity.api.types.PatientInput;
import com.affinity.api.types.PatientInputSex;
import com.affinity.api.types.Practice;
import com.affinity.api.types.PrescriberInput;
import com.affinity.api.types.PrescriptionInput;
import com.affinity.api.types.ProblemIssuesItem;
import com.affinity.api.types.WebhookEndpoint;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * Calls every operation of the SDK against a real Affinity API in Test mode. Run it from the
 * repository root with a platform Test key:
 *
 * <pre>
 * docker run --rm --env-file smoke.env -v "$PWD":/work -w /work gradle:8-jdk17 \
 *   ./gradlew --no-daemon -p tests run
 * </pre>
 *
 * It reads AFFINITY_API_KEY (must start with sk_test_), AFFINITY_BASE_URL (optional) and
 * AFFINITY_SMOKE_WEBHOOK_URL (optional; without it the webhook checks are skipped). It creates a
 * practice and a Test order (sent to the API's test pharmacy) and cancels every order it created.
 * Feedback is sent only as an invalid request, so no one is notified. The practice it creates
 * stays: the API has no way to remove a practice. Exits 1 when any check fails.
 */
public final class Smoke {
    private static final List<String> results = new ArrayList<>();
    private static int failures = 0;
    private static final List<String> orderIds = new ArrayList<>();
    private static final List<String> endpointIds = new ArrayList<>();

    private static String env(String name) {
        String value = System.getenv(name);
        return value == null || value.isEmpty() ? null : value;
    }

    private static final String key = env("AFFINITY_API_KEY") == null ? "" : env("AFFINITY_API_KEY");
    private static final String baseUrl = env("AFFINITY_BASE_URL");
    private static final String webhookUrl = env("AFFINITY_SMOKE_WEBHOOK_URL");

    private static AffinityClient client(String token) {
        AffinityClientBuilder builder = AffinityClient.builder().token(token).maxRetries(0);
        if (baseUrl != null) builder.url(baseUrl);
        return builder.build();
    }

    private static String describe(Throwable error) {
        if (error instanceof AffinityClientApiException) {
            AffinityClientApiException api = (AffinityClientApiException) error;
            return api.getClass().getSimpleName() + " " + api.statusCode();
        }
        String text = String.valueOf(error);
        return text.length() > 300 ? text.substring(0, 300) : text;
    }

    private static void pass(String name, String note) {
        results.add("PASS " + name + (note == null ? "" : " - " + note));
    }

    private static void fail(String name, String note) {
        failures++;
        results.add("FAIL " + name + (note == null ? "" : " - " + note));
    }

    interface Note<T> {
        String of(T value);
    }

    private static <T> T check(String name, Callable<T> work, Note<T> note) {
        try {
            T value = work.call();
            pass(name, note == null ? null : note.of(value));
            return value;
        } catch (Throwable error) {
            fail(name, describe(error));
            return null;
        }
    }

    interface Inspect<E> {
        /** Returns a problem, or null. */
        String of(E error);
    }

    /** A call that must throw {@code type}. */
    private static <E extends Throwable> void refused(
            String name, Class<E> type, Callable<?> work, Inspect<E> inspect) {
        Throwable error = null;
        try {
            work.call();
        } catch (Throwable e) {
            error = e;
        }
        String problem;
        if (error == null) problem = "succeeded";
        else if (!type.isInstance(error)) problem = "got " + describe(error);
        else problem = inspect == null ? null : inspect.of(type.cast(error));
        if (problem == null) pass(name, describe(error));
        else fail(name, problem);
    }

    private static String id() {
        return UUID.randomUUID().toString();
    }

    private static String shortId() {
        return id().substring(0, 8);
    }

    private static AddressInput address(String line1) {
        return AddressInput.builder()
                .line1(line1)
                .city("Austin")
                .state("TX")
                .postalCode("78701")
                .build();
    }

    private static OrderInput orderInput(Practice practice, Medication medication, int quantity) {
        PrescriptionInput._FinalStage prescription = PrescriptionInput.builder()
                .directions("SDK smoke test. TEST ONLY. DO NOT FILL.")
                .medicationId(medication.getId())
                .quantity(quantity)
                .refills(0);
        if (medication.getRequirements().contains("compoundingReason")
                && !medication.getCompoundingReasons().isEmpty())
            prescription.compoundingReason(medication.getCompoundingReasons().get(0));
        return OrderInput.builder()
                .idempotencyKey(id())
                .patient(PatientInput.builder()
                        .address(address("200 Congress Ave"))
                        .dateOfBirth("1988-04-02")
                        .email("sdk-smoke-" + shortId() + "@example.test")
                        .firstName("Test")
                        .sex(PatientInputSex.FEMALE)
                        .lastName("Smoke")
                        .phone("+15125550101")
                        .externalId("sdk-smoke-" + id())
                        .allergies(Collections.emptyList())
                        .build())
                .shipping(OrderInputShipping.builder()
                        .optionId(medication.getShippingOptions().get(0).getId())
                        .build())
                .signatureAttestation(true)
                .externalOrderId("sdk-smoke-" + shortId())
                .practiceId(practice.getId())
                .prescriber(PrescriberInput.builder()
                        .firstName("Sam")
                        .lastName("Lee")
                        .npi("1234567893")
                        .build())
                .addPrescriptions(prescription.build())
                .build();
    }

    /** Records an order a check meant to be refused, so the cleanup cancels it if the API accepted it. */
    private static Order created(Order order) {
        orderIds.add(order.getId());
        return order;
    }

    public static void main(String[] args) throws Exception {
        if (!key.startsWith("sk_test_")) {
            System.out.println("FAIL Set AFFINITY_API_KEY to a Test key (sk_test_...).");
            System.exit(1);
        }
        AffinityClient client = client(key);
        String label = "SDK smoke java " + Instant.now();
        try {
            run(client, label);
        } catch (Throwable error) {
            fail("stopped", describe(error));
        } finally {
            for (String orderId : orderIds) {
                try {
                    client.orders()
                            .cancel(orderId, CancelOrdersRequest.builder().idempotencyKey(id()).build());
                } catch (Throwable ignored) {
                    // Already cancelled, or the API refused; the order stays in Test mode.
                }
            }
            for (String endpointId : endpointIds) {
                try {
                    client.webhooks().remove(endpointId);
                } catch (Throwable ignored) {
                    // Reported by the failed check that left it.
                }
            }
        }
        webhookSignatureCheck();
        for (String result : results) System.out.println(result);
        System.out.println((results.size() - failures) + " of " + results.size() + " checks passed.");
        System.exit(failures > 0 ? 1 : 0);
    }

    private static void run(AffinityClient client, String label) throws Exception {
        Account account = check("account.get", () -> client.account().get(), a -> a.getType() + " " + a.getMode());
        if (account == null || !account.getMode().equals(AccountMode.TEST))
            throw new IllegalStateException("This smoke test runs only with a Test key.");
        if (!account.getType().equals(AccountType.PLATFORM))
            throw new IllegalStateException("Use a platform Test key: it creates a practice.");

        refused("a bad key raises UnauthorizedError", UnauthorizedError.class,
                () -> client("sk_test_not_a_key").account().get(), null);
        refused("feedback.create without a message raises BadRequestError", BadRequestError.class,
                () -> client.feedback()
                        .create(CreateFeedbackRequest.builder().idempotencyKey(id()).message("").build()),
                null);

        Practice practice = check("practices.create", () -> client.practices()
                .create(CreatePracticesRequest.builder()
                        .idempotencyKey(id())
                        .address(address("100 Congress Ave"))
                        .name(label)
                        .phone("+15125550100")
                        .build()), Practice::getId);
        if (practice == null) throw new IllegalStateException("No practice; stopping.");
        check("practices.get", () -> client.practices().get(practice.getId()), Practice::getName);
        check("practices.update", () -> client.practices()
                .update(practice.getId(), UpdatePracticesRequest.builder()
                        .idempotencyKey(id())
                        .name(label + " renamed")
                        .build()), Practice::getName);
        check("practices.list (every page, 1 per page)", () -> {
            List<String> ids = new ArrayList<>();
            for (Practice p : client.practices().list(ListPracticesRequest.builder().limit(1).build()))
                ids.add(p.getId());
            if (!ids.contains(practice.getId())) throw new IllegalStateException("the new practice is not listed");
            return ids.size();
        }, n -> n + " practices");
        check("practices.list sort created_desc (every page)", () -> {
            List<String> newest = new ArrayList<>();
            for (Practice p : client.practices().list(ListPracticesRequest.builder().limit(1)
                    .sort(ListPracticesRequestSort.CREATED_DESC).build()))
                newest.add(p.getId());
            List<String> oldest = new ArrayList<>();
            for (Practice p : client.practices().list(ListPracticesRequest.builder().limit(1)
                    .sort(ListPracticesRequestSort.CREATED).build()))
                oldest.add(p.getId());
            Collections.reverse(oldest);
            if (newest.isEmpty() || !newest.equals(oldest))
                throw new IllegalStateException("sort created_desc is not the reverse of sort created");
            return newest.size();
        }, n -> n + " practices");

        check("medications.list (one page)", () -> {
            SyncPagingIterable<Medication> page =
                    client.medications().list(ListMedicationsRequest.builder().limit(5).build());
            return page.getItems().size() + ", more: " + page.hasNext();
        }, s -> s);
        List<Medication> medications = check("medications.list (every page, 25 per page)", () -> {
            List<Medication> all = new ArrayList<>();
            for (Medication m : client.medications().list(ListMedicationsRequest.builder().limit(25).build()))
                all.add(m);
            HashSet<String> ids = new HashSet<>();
            for (Medication m : all)
                if (!ids.add(m.getId())) throw new IllegalStateException("a medication repeats across pages: " + m.getId());
            return all;
        }, all -> all.size() + " medications");
        Medication medication = null;
        if (medications != null) {
            for (Medication m : medications)
                if (!m.getColdChainRequired() && !m.getShippingOptions().isEmpty() && m.getRequirements().isEmpty()) {
                    medication = m;
                    break;
                }
            if (medication == null)
                for (Medication m : medications)
                    if (!m.getShippingOptions().isEmpty()) {
                        medication = m;
                        break;
                    }
        }
        if (medication == null) throw new IllegalStateException("No orderable medication in Test mode; stopping.");
        final Medication chosen = medication;
        check("medications.get", () -> client.medications().get(chosen.getId()),
                m -> m.getName() + " (" + m.getPharmacy().getName() + ")");
        check("medications.get expand=variants", () -> {
            GetMedicationsResponse m = client.medications().get(chosen.getId(), GetMedicationsRequest.builder()
                    .expand(GetMedicationsRequestExpandItem.VARIANTS)
                    .build());
            if (!m.getVariants().isPresent()) throw new IllegalStateException("no variants in the response");
            return m;
        }, m -> m.getVariants().get().size() + " variants");
        check("medications.list for a practice", () -> client.medications()
                .list(ListMedicationsRequest.builder().limit(5).practiceId(practice.getId()).build())
                .getItems()
                .size(), n -> n + "");

        int quantity = chosen.getQuantities().isEmpty() ? 1 : chosen.getQuantities().get(0);
        OrderInput input = orderInput(practice, chosen, quantity);
        Order order = check("orders.create", () -> client.orders().create(input),
                o -> o.getId() + " " + o.getStatus());
        if (order != null) orderIds.add(order.getId());
        check("orders.create again with the same key returns the same order", () -> {
            Order again = client.orders().create(input);
            if (order == null || !again.getId().equals(order.getId())) {
                orderIds.add(again.getId());
                throw new IllegalStateException("created a second order " + again.getId());
            }
            return again;
        }, o -> o.getId());
        int unaccepted = Collections.max(chosen.getQuantities().isEmpty()
                        ? Collections.singletonList(0)
                        : chosen.getQuantities()) + 1;
        refused("an unaccepted quantity raises UnprocessableEntityError with the field",
                UnprocessableEntityError.class,
                () -> created(client.orders().create(orderInput(practice, chosen, unaccepted))),
                e -> {
                    List<ProblemIssuesItem> issues = e.body().getIssues().orElse(Collections.emptyList());
                    for (ProblemIssuesItem issue : issues)
                        if ("prescriptions[0].quantity".equals(issue.getField())) return null;
                    return "issues " + issues;
                });
        if (order != null) {
            check("orders.get", () -> client.orders().get(order.getId()),
                    o -> o.getStatus() + ", " + o.getPrescriptions().size() + " prescription");
            check("orders.list by externalOrderId", () -> {
                List<Order> data = client.orders()
                        .list(ListOrdersRequest.builder()
                                .externalOrderId(input.getExternalOrderId().get())
                                .build())
                        .getItems();
                if (data.size() != 1 || !data.get(0).getId().equals(order.getId()))
                    throw new IllegalStateException("found " + data.size());
                return data.size();
            }, n -> n + " order");
            check("orders.list updatedAfter (milliseconds)", () -> client.orders()
                    .list(ListOrdersRequest.builder()
                            .updatedAfter(OffsetDateTime.ofInstant(
                                    Instant.ofEpochMilli(System.currentTimeMillis() - 3_600_000L), ZoneOffset.UTC))
                            .limit(5)
                            .build())
                    .getItems()
                    .size(), n -> n + "");
            check("orders.list updatedAfter (nanoseconds)", () -> client.orders()
                    .list(ListOrdersRequest.builder()
                            .updatedAfter(OffsetDateTime.parse("2026-01-01T00:00:00.123456789Z"))
                            .limit(5)
                            .build())
                    .getItems()
                    .size(), n -> n + "");
            check("orders.list (every page, 1 per page)", () -> {
                int n = 0;
                for (Order ignored : client.orders()
                        .list(ListOrdersRequest.builder().limit(1).practiceId(practice.getId()).build()))
                    n++;
                if (n != 1) throw new IllegalStateException(n + " orders for a practice with 1");
                return n;
            }, n -> n + "");
            check("orders.cancel", () -> client.orders()
                    .cancel(order.getId(), CancelOrdersRequest.builder().idempotencyKey(id()).build()),
                    o -> o.getStatus() + (o.getCancelRequestedAt().isPresent() ? ", waiting for the pharmacy" : ""));
        }
        refused("orders.get for an unknown order raises NotFoundError", NotFoundError.class,
                () -> client.orders().get("ord_01j2y8m6jcc9tt24af5pw9x1bc"), null);

        if (webhookUrl == null) {
            fail("webhooks", "AFFINITY_SMOKE_WEBHOOK_URL is not set");
            return;
        }
        String base = webhookUrl.endsWith("/") ? webhookUrl.substring(0, webhookUrl.length() - 1) : webhookUrl;
        CreateWebhooksResponse endpoint = check("webhooks.create", () -> client.webhooks()
                .create(CreateWebhooksRequest.builder().idempotencyKey(id()).url(base + "/" + id()).build()),
                CreateWebhooksResponse::getId);
        if (endpoint == null) return;
        endpointIds.add(endpoint.getId());
        check("webhooks.list (every page)", () -> {
            List<String> ids = new ArrayList<>();
            for (WebhookEndpoint e : client.webhooks().list()) ids.add(e.getId());
            if (!ids.contains(endpoint.getId())) throw new IllegalStateException("the new endpoint is not listed");
            return ids.size();
        }, n -> n + "");
        check("webhooks.update", () -> client.webhooks()
                .update(endpoint.getId(), UpdateWebhooksRequest.builder()
                        .idempotencyKey(id())
                        .url(base + "/" + id())
                        .build()), WebhookEndpoint::getId);
        check("webhooks.resendFailed", () -> client.webhooks()
                .resendFailed(endpoint.getId(), ResendFailedWebhooksRequest.builder().idempotencyKey(id()).build()),
                r -> "queued " + r.getQueued());
        check("webhooks.remove", () -> {
            client.webhooks().remove(endpoint.getId());
            endpointIds.remove(endpoint.getId());
            return "removed";
        }, s -> s);
    }

    /** The README's webhook verification against a signature computed with openssl at build time. */
    private static void webhookSignatureCheck() {
        check("webhook signature verification", () -> {
            String secret = "whsec_test_secret_for_unit_test";
            byte[] body = "{\"id\":\"evt_test\",\"type\":\"order.updated\"}".getBytes(StandardCharsets.UTF_8);
            String header = "t=1767225600,v1=63e141b4c41372f7caa7a29ed073a86ab8f648f69c58c3595f12b306800d3998";
            if (!WebhookSignature.verify(header, body, secret, 1767225600L))
                throw new IllegalStateException("a valid signature was rejected");
            byte[] tampered = "{\"id\":\"evt_test\",\"type\":\"order.created\"}".getBytes(StandardCharsets.UTF_8);
            if (WebhookSignature.verify(header, tampered, secret, 1767225600L))
                throw new IllegalStateException("a tampered body was accepted");
            return "valid accepted, tampered rejected";
        }, s -> s);
    }
}
