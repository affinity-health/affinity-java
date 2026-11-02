package smoke;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.affinity.api.AffinityClient;
import com.affinity.api.types.AllergyCategory;
import com.affinity.api.types.Order;
import com.affinity.api.types.OrderStatus;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * A response with a value or field this SDK does not know decodes without an error. The contract
 * keeps response objects and value lists open: a later API version can add a status, a category or
 * a field. The fixture has an unknown order, prescription and history status, an unknown allergy
 * category and an added field at the root and in nested objects.
 */
class OpenValuesTest {
    private HttpServer server;

    private static String fixture() throws IOException {
        try (InputStream in = OpenValuesTest.class.getResourceAsStream("/order-unknown-values.json")) {
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    private AffinityClient serve(String... bodies) throws IOException {
        Deque<String> replies = new ArrayDeque<>(Arrays.asList(bodies));
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/", exchange -> {
            String body = replies.poll();
            byte[] bytes = (body == null ? "{}" : body).getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(body == null ? 500 : 200, bytes.length);
            try (OutputStream out = exchange.getResponseBody()) {
                out.write(bytes);
            }
        });
        server.start();
        return AffinityClient.builder()
                .token("sk_test_synthetic")
                .url("http://127.0.0.1:" + server.getAddress().getPort())
                .maxRetries(0)
                .build();
    }

    @AfterEach
    void stop() {
        if (server != null) server.stop(0);
    }

    @Test
    void ordersGetKeepsUnknownValuesAndAddedFields() throws IOException {
        Order order = serve(fixture()).orders().get("ord_01j2y8m6jcc9tt24af5pw9x1bc");
        assertEquals("on_hold", order.getStatus().toString());
        assertEquals(OrderStatus.Value.UNKNOWN, order.getStatus().getEnumValue());
        assertEquals("on_hold", order.getPrescriptions().get(0).getStatus().toString());
        assertEquals(
                List.of("submitted", "on_hold"),
                order.getStatusHistory().stream()
                        .map(entry -> entry.getStatus().toString())
                        .collect(Collectors.toList()));
        assertEquals(AllergyCategory.DRUG, order.getPatient().getAllergies().get(0).getCategory());
        assertEquals(
                AllergyCategory.Value.UNKNOWN,
                order.getPatient().getAllergies().get(1).getCategory().getEnumValue());
        assertEquals("dust", order.getPatient().getAllergies().get(1).getCategory().toString());
        assertEquals(Map.of("nested", true), order.getAdditionalProperties().get("addedField"));
        assertEquals("patient", order.getPatient().getAdditionalProperties().get("addedField"));
        assertEquals(
                "medication",
                order.getPrescriptions().get(0).getMedication().getAdditionalProperties().get("addedField"));
    }

    @Test
    void ordersListIteratesUnknownValues() throws IOException {
        String order = fixture();
        String first = "{\"object\":\"list\",\"url\":\"/v1/orders\",\"data\":[" + order
                + "],\"hasMore\":true,\"nextCursor\":\"cursor-a\",\"addedField\":\"list\"}";
        String last = "{\"object\":\"list\",\"url\":\"/v1/orders\",\"data\":[" + order
                + "],\"hasMore\":false,\"nextCursor\":null}";
        List<String> statuses = new ArrayList<>();
        for (Order each : serve(first, last).orders().list()) statuses.add(each.getStatus().toString());
        assertEquals(List.of("on_hold", "on_hold"), statuses);
    }
}
