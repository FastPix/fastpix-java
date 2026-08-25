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
                    .username(System.getenv("FASTPIX_USERNAME"))
                    .password(System.getenv("FASTPIX_PASSWORD"))
                    .build())
            .build();

        // Replace with a real view id from your workspace (Dashboard > Views).
        String viewId = "REPLACE_WITH_A_REAL_VIEW_ID";

        GetVideoViewDetailsResponse res = sdk.views().getDetails()
                .viewId(viewId)
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
