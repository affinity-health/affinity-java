package smoke;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/** The webhook verification example from README.md. Keep the two copies the same. */
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
