package com.fastpix.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.junit.jupiter.api.Test;

class VerifyWebhookExampleTest {

    // The signing secret is itself Base64 (matches how FastPix stores it).
    private static final String SECRET =
            Base64.getEncoder().encodeToString("test-signing-secret".getBytes(StandardCharsets.UTF_8));
    private static final byte[] BODY =
            "{\"type\":\"video.media.ready\",\"data\":{\"id\":\"abc-123\"}}".getBytes(StandardCharsets.UTF_8);

    private static String sign(byte[] body, String secret) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(Base64.getDecoder().decode(secret), "HmacSHA256"));
        return Base64.getEncoder().encodeToString(mac.doFinal(body));
    }

    @Test
    void validSignatureIsAccepted() throws Exception {
        assertTrue(VerifyWebhookExample.isValidSignature(BODY, sign(BODY, SECRET), SECRET));
    }

    @Test
    void wrongSignatureIsRejected() throws Exception {
        String bogus = Base64.getEncoder().encodeToString("not-the-signature".getBytes(StandardCharsets.UTF_8));
        assertFalse(VerifyWebhookExample.isValidSignature(BODY, bogus, SECRET));
    }

    @Test
    void tamperedBodyIsRejected() throws Exception {
        String sig = sign(BODY, SECRET);
        byte[] tampered = "{\"type\":\"video.media.ready\",\"data\":{\"id\":\"evil-999\"}}"
                .getBytes(StandardCharsets.UTF_8);
        assertFalse(VerifyWebhookExample.isValidSignature(tampered, sig, SECRET));
    }

    @Test
    void missingSecretOrSignatureIsRejected() throws Exception {
        assertFalse(VerifyWebhookExample.isValidSignature(BODY, sign(BODY, SECRET), null));
        assertFalse(VerifyWebhookExample.isValidSignature(BODY, null, SECRET));
    }
}
