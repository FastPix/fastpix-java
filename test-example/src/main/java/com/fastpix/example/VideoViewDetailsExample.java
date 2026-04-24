package com.fastpix.example;

import java.lang.Exception;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.Views;
import io.fastpix.sdk.models.operations.GetVideoViewDetailsResponse;
import io.fastpix.sdk.utils.JSON;
import io.fastpix.sdk.utils.ViewEventMapper;

public class VideoViewDetailsExample {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetVideoViewDetailsResponse res = sdk.views().getDetails()
                .viewId("view-id")
                .call();

        if (res.object().isPresent()) {
            Views v = res.object().get().data().orElse(null);
            if (v != null) {
                ObjectMapper mapper = JSON.getMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                System.out.println(mapper.writeValueAsString(ViewEventMapper.map(v)));
            }
        }
    }
}
