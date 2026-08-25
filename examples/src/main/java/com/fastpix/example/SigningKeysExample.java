package com.fastpix.example;

// Signing keys lifecycle: create a JWT signing key, list keys, fetch it by id,
// then delete it. Self-contained; the key created here is removed at the end.

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.CreateSigningKeyResponse;
import io.fastpix.sdk.utils.JSON;

public class SigningKeysExample {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username(System.getenv("FASTPIX_USERNAME"))
                    .password(System.getenv("FASTPIX_PASSWORD"))
                    .build())
            .build();

        ObjectMapper mapper = JSON.getMapper().enable(SerializationFeature.INDENT_OUTPUT);

        CreateSigningKeyResponse created = sdk.signingKeys().create().call();
        System.out.println("=== create signing key ===");
        System.out.println(mapper.writeValueAsString(created.createResponse().orElse(null)));

        String keyId = created.createResponse()
                .flatMap(r -> r.data())
                .flatMap(d -> d.id())
                .orElseThrow(() -> new IllegalStateException("No signing key id returned"));

        System.out.println("=== list signing keys ===");
        System.out.println(mapper.writeValueAsString(
                sdk.signingKeys().list().limit(10L).offset(1L).call()
                        .getAllSigningKeysResponse().orElse(null)));

        System.out.println("=== get signing key ===");
        System.out.println(mapper.writeValueAsString(
                sdk.signingKeys().getById().signingKeyId(keyId).call()
                        .getPublicPemUsingSigningKeyIdResponseDTO().orElse(null)));

        System.out.println("=== delete signing key ===");
        System.out.println(mapper.writeValueAsString(
                sdk.signingKeys().delete().signingKeyId(keyId).call()
                        .deleteSigningKeyResponse().orElse(null)));
    }
}
