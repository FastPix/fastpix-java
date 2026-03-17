package com.fastpix.example;

import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.SortOrder;
import io.fastpix.sdk.models.operations.ListMediaResponse;
import io.fastpix.sdk.utils.JSON;

public class CreateMediaExample {

    public static void main(String[] args) throws Exception {

        // Get credentials from environment variables
        String accessToken = System.getenv("FASTPIX_ACCESS_TOKEN");
        String secretKey = System.getenv("FASTPIX_SECRET_KEY");
        
        if (accessToken == null || secretKey == null) {
            System.err.println("Error: FASTPIX_ACCESS_TOKEN and FASTPIX_SECRET_KEY environment variables must be set");
            System.exit(1);
        }

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username(accessToken)
                    .password(secretKey)
                    .build())
            .build();

        ListMediaResponse res = sdk.manageVideos().list()
                .limit(20L)
                .offset(1L)
                .orderBy(SortOrder.DESC)
                .call();

        if (res.object().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.object().get()));
        }
    }
}