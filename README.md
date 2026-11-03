# Affinity Java SDK

Typed server-side client for the Affinity API. It is compiled for Java 8 and later and tested on
Java 17. It targets API version `2026-11-01` and sends it in `Affinity-Version` on every request.

Keep API keys on the server. Never put them in browser code, Android or other mobile applications,
or anything you ship to users.

## Install

Registry publishing is not done yet. Build version 0.8.0 from GitHub and install it in your local
Maven repository:

```sh
git clone --branch v0.8.0 https://github.com/affinity-health/affinity-java.git
cd affinity-java
./gradlew publishToMavenLocal
```

Then depend on `io.github.affinity-health:affinity-java:0.8.0` with `mavenLocal()` in your
repositories:

```groovy
repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation 'io.github.affinity-health:affinity-java:0.8.0'
}
```

For Maven, add the same coordinates (`groupId` `io.github.affinity-health`, `artifactId`
`affinity-java`, `version` `0.8.0`).

## Quickstart

Use a Test key (`sk_test_...`). Test orders go to a test pharmacy.

```java
import com.affinity.api.AffinityClient;
import com.affinity.api.types.Account;
import com.affinity.api.types.AccountMode;
import com.affinity.api.types.Medication;

public class Quickstart {
    public static void main(String[] args) {
        AffinityClient affinity = AffinityClient.builder()
                .token(System.getenv("AFFINITY_API_KEY"))
                .build();

        Account account = affinity.account().get();
        if (!account.getMode().equals(AccountMode.TEST)) throw new IllegalStateException("Use a Test key");

        for (Medication medication : affinity.medications().list()) {
            System.out.println(medication.getName() + " - " + medication.getPharmacy().getName());
        }
    }
}
```

The key sets the organization and the Test or Live mode.

## Key facts

- **Writes need an idempotency key.** Every create, update, cancel and resend request builder
  starts with `.idempotencyKey(...)`, sent as the `Idempotency-Key` header. Make one key per
  order, save it with the reviewed order before the first request, and reuse it to retry. The
  client's automatic retries send the same request, so they reuse the key. Sending the same order
  again with the same key returns the same order.

  ```java
  Order order = affinity.orders().create(OrderInput.builder()
          .idempotencyKey(savedKey)
          .patient(patient)
          .shipping(OrderInputShipping.builder().optionId(shippingOptionId).build())
          .signatureAttestation(true)
          .practiceId(practiceId)
          .prescriber(prescriber)
          .addPrescriptions(prescription)
          .build());
  ```

- **Lists iterate every page.** `list(...)` returns a `SyncPagingIterable`. A `for` loop over it
  reads each next page with the `startingAfter` cursor. `getItems()` is the first page only, and
  `hasNext()` tells if there are more.
- **Errors are typed.** Each documented status has its own exception in `com.affinity.api.errors`:
  `BadRequestError` (400), `UnauthorizedError` (401), `ForbiddenError` (403), `NotFoundError`
  (404), `ConflictError` (409), `UnprocessableEntityError` (422), `TooManyRequestsError` (429) and
  others. All extend `AffinityClientApiException`, with `statusCode()`, `body()` and `headers()`.
  `UnprocessableEntityError.body()` is a `Problem` whose `getIssues()` names each refused field:

  ```java
  try {
      affinity.orders().create(input);
  } catch (UnprocessableEntityError e) {
      for (ProblemIssuesItem issue : e.body().getIssues().orElse(Collections.emptyList())) {
          System.out.println(issue.getField() + ": " + issue.getMessage()); // prescriptions[0].quantity: ...
      }
  }
  ```

  Network failures throw `AffinityClientException`.
- **Defaults.** Base URL `https://api.affinityrx.com` (change it with `.url(...)`),
  `Affinity-Version` `2026-11-01`, 2 retries with exponential backoff for 408, 429 and 5xx
  responses (`Retry-After` is respected; change with `.maxRetries(...)`), and a 60-second timeout
  (`.timeout(seconds)`).
- **Raw responses.** `affinity.orders().withRawResponse().get(orderId)` returns the body
  (`body()`) and the response headers (`headers()`), for example `X-Request-Id`.

See [docs/reference.md](docs/reference.md) for every method, and https://docs.affinityrx.com for
the API.

## Verify webhooks

Fern does not generate webhook verification. Each delivery has an
`Affinity-Signature: t=<unix seconds>,v1=<hex>` header. The signature is HMAC-SHA256 of
`"<t>." + raw body bytes`, keyed with the endpoint secret (`whsec_...`), in lowercase hex. Use the
raw request body, before any JSON parsing. Compare in constant time against every `v1` value and
reject a timestamp more than 300 seconds from now. This code uses only the JDK:

```java
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class WebhookSignature {
    private WebhookSignature() {}

    /**
     * Returns true when {@code header} (the Affinity-Signature value) signs {@code rawBody} with
     * {@code secret} (the endpoint's whsec_ secret) and its timestamp is within 300 seconds of
     * {@code nowSeconds}.
     */
    public static boolean verify(String header, byte[] rawBody, String secret, long nowSeconds) throws Exception {
        if (header == null) return false;
        String timestamp = null;
        java.util.List<String> signatures = new java.util.ArrayList<>();
        for (String part : header.split(",")) {
            String[] pair = part.trim().split("=", 2);
            if (pair.length != 2) continue;
            if (pair[0].equals("t")) timestamp = pair[1];
            if (pair[0].equals("v1")) signatures.add(pair[1]);
        }
        if (timestamp == null || signatures.isEmpty()) return false;
        long t;
        try {
            t = Long.parseLong(timestamp);
        } catch (NumberFormatException e) {
            return false;
        }
        if (Math.abs(nowSeconds - t) > 300) return false;

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        mac.update((timestamp + ".").getBytes(StandardCharsets.UTF_8));
        byte[] digest = mac.doFinal(rawBody);
        StringBuilder hex = new StringBuilder();
        for (byte b : digest) hex.append(String.format("%02x", b));
        byte[] expected = hex.toString().getBytes(StandardCharsets.UTF_8);

        boolean valid = false;
        for (String signature : signatures) {
            // Constant-time compare; check every v1 value.
            valid |= MessageDigest.isEqual(expected, signature.getBytes(StandardCharsets.UTF_8));
        }
        return valid;
    }
}
```

Call it with `WebhookSignature.verify(header, rawBody, secret, System.currentTimeMillis() / 1000)`
and answer 400 when it returns false. The endpoint secret is in the `webhooks().create(...)`
response (`getSecret()`); store it like an API key. `tests/src/test/java/smoke/WebhookSignatureTest.java`
tests this code against a signature computed with `openssl dgst -sha256 -hmac` and against a
tampered body.

## Build and verify

[Fern](https://buildwithfern.com) generates the client (`src/`, `build.gradle`, `settings.gradle`,
the Gradle wrapper, `sample-app/` and `docs/reference.md`) from `spec/affinity.openapi.json`, the
committed Affinity API contract. It runs locally in Docker, with no Fern account.
[generation.json](generation.json) records the contract and generator versions.

All commands run from the repository root. They use the official `gradle:8-jdk17` image, so only
Docker is needed (plus Node and jq to regenerate):

```sh
# Build the jar and run Fern's unit tests (build/libs/affinity-java-0.8.0.jar)
docker run --rm -u "$(id -u):$(id -g)" -e GRADLE_USER_HOME=/tmp/gradle -v "$PWD":/work -w /work \
  gradle:8-jdk17 ./gradlew --no-daemon build

# Compile the smoke test and run the webhook signature test (no credentials)
docker run --rm -u "$(id -u):$(id -g)" -e GRADLE_USER_HOME=/tmp/gradle -v "$PWD":/work -w /work \
  gradle:8-jdk17 ./gradlew --no-daemon -p tests test installDist

# Regenerate after the contract changes, and check the committed code matches (needs Docker, Node, jq)
./scripts/generate.sh
./scripts/generate-check.sh

# Every operation against a real API, Test mode only. smoke.env holds AFFINITY_API_KEY (sk_test_...),
# AFFINITY_BASE_URL and AFFINITY_SMOKE_WEBHOOK_URL.
docker run --rm -u "$(id -u):$(id -g)" --env-file smoke.env -e GRADLE_USER_HOME=/tmp/gradle \
  -v "$PWD":/work -w /work gradle:8-jdk17 ./gradlew --no-daemon -q -p tests run
```

The smoke test (`tests/src/main/java/smoke/Smoke.java`) refuses a key that does not start with
`sk_test_`. It creates a Test practice and a Test order, cancels every order it creates and removes
every webhook endpoint it creates. The practice stays: the API cannot remove a practice. It prints
PASS or FAIL for each check and exits 1 on any failure.
