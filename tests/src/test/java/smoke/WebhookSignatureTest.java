package smoke;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class WebhookSignatureTest {
    private static final String SECRET = "whsec_test_secret_for_unit_test";
    private static final byte[] BODY = "{\"id\":\"evt_test\",\"type\":\"order.updated\"}".getBytes(StandardCharsets.UTF_8);
    private static final long T = 1767225600L;
    // Computed independently:
    // printf '%s' '1767225600.{"id":"evt_test","type":"order.updated"}' \
    //   | openssl dgst -sha256 -hmac 'whsec_test_secret_for_unit_test'
    private static final String V1 = "63e141b4c41372f7caa7a29ed073a86ab8f648f69c58c3595f12b306800d3998";

    @Test
    void acceptsTheSignature() throws Exception {
        assertTrue(WebhookSignature.verify("t=" + T + ",v1=" + V1, BODY, SECRET, T + 10));
    }

    @Test
    void acceptsWhenAnyV1Matches() throws Exception {
        assertTrue(WebhookSignature.verify("t=" + T + ",v1=" + "0".repeat(64) + ",v1=" + V1, BODY, SECRET, T));
    }

    @Test
    void rejectsATamperedBody() throws Exception {
        byte[] tampered = "{\"id\":\"evt_test\",\"type\":\"order.updated \"}".getBytes(StandardCharsets.UTF_8);
        assertFalse(WebhookSignature.verify("t=" + T + ",v1=" + V1, tampered, SECRET, T));
    }

    @Test
    void rejectsAnotherSecret() throws Exception {
        assertFalse(WebhookSignature.verify("t=" + T + ",v1=" + V1, BODY, "whsec_other", T));
    }

    @Test
    void rejectsAnOldOrFutureTimestamp() throws Exception {
        assertFalse(WebhookSignature.verify("t=" + T + ",v1=" + V1, BODY, SECRET, T + 301));
        assertFalse(WebhookSignature.verify("t=" + T + ",v1=" + V1, BODY, SECRET, T - 301));
    }

    @Test
    void rejectsAMalformedHeader() throws Exception {
        assertFalse(WebhookSignature.verify(null, BODY, SECRET, T));
        assertFalse(WebhookSignature.verify("v1=" + V1, BODY, SECRET, T));
        assertFalse(WebhookSignature.verify("t=abc,v1=" + V1, BODY, SECRET, T));
    }
}
