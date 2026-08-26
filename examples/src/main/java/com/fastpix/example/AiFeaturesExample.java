package com.fastpix.example;

// In-video AI on a Ready media: enable summary, chapters, moderation and named
// entities, then read back the summary. Enabling these features is asynchronous
// (results arrive via video.media.ai.* webhooks), so the get-summary call may
// return pending or partial data until generation completes. No polling here.

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.MediaType;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.UpdateMediaChaptersRequestBody;
import io.fastpix.sdk.models.operations.UpdateMediaModerationModeration;
import io.fastpix.sdk.models.operations.UpdateMediaModerationRequestBody;
import io.fastpix.sdk.models.operations.UpdateMediaNamedEntitiesRequestBody;
import io.fastpix.sdk.models.operations.UpdateMediaSummaryRequestBody;
import io.fastpix.sdk.utils.JSON;

public class AiFeaturesExample {

    public static void main(String[] args) throws Exception {

        if (System.getenv("FASTPIX_USERNAME") == null || System.getenv("FASTPIX_PASSWORD") == null) {
            System.err.println("Set FASTPIX_USERNAME and FASTPIX_PASSWORD before running (see examples/README.md).");
            System.exit(1);
        }

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username(System.getenv("FASTPIX_USERNAME"))
                    .password(System.getenv("FASTPIX_PASSWORD"))
                    .build())
            .build();

        // A media in "Ready" status in your workspace (Dashboard > Media, or list media).
        String MEDIA_ID = "REPLACE_WITH_A_READY_MEDIA_ID";

        ObjectMapper mapper = JSON.getMapper().enable(SerializationFeature.INDENT_OUTPUT);

        System.out.println("=== summary ===");
        System.out.println(mapper.writeValueAsString(
                sdk.aiFeatures().updateMediaSummary()
                        .mediaId(MEDIA_ID)
                        .body(UpdateMediaSummaryRequestBody.builder()
                                .generate(true)
                                .summaryLength(100L)
                                .build())
                        .call()
                        .object().orElse(null)));

        System.out.println("=== chapters ===");
        System.out.println(mapper.writeValueAsString(
                sdk.videos().updateChapters()
                        .mediaId(MEDIA_ID)
                        .body(UpdateMediaChaptersRequestBody.builder()
                                .chapters(true)
                                .build())
                        .call()
                        .object().orElse(null)));

        System.out.println("=== moderation ===");
        System.out.println(mapper.writeValueAsString(
                sdk.inVideoAiFeatures().updateModeration()
                        .mediaId(MEDIA_ID)
                        .body(UpdateMediaModerationRequestBody.builder()
                                .moderation(UpdateMediaModerationModeration.builder()
                                        .type(MediaType.VIDEO)
                                        .build())
                                .build())
                        .call()
                        .object().orElse(null)));

        System.out.println("=== named entities ===");
        System.out.println(mapper.writeValueAsString(
                sdk.inVideoAiFeatures().generateNamedEntities()
                        .mediaId(MEDIA_ID)
                        .body(UpdateMediaNamedEntitiesRequestBody.builder()
                                .namedEntities(true)
                                .build())
                        .call()
                        .object().orElse(null)));

        System.out.println("=== get summary ===");
        System.out.println(mapper.writeValueAsString(
                sdk.manageVideos().getSummary()
                        .mediaId(MEDIA_ID)
                        .call()
                        .object().orElse(null)));
    }
}
