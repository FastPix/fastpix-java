package com.fastpix.example;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.BasicAccessPolicy;
import io.fastpix.sdk.models.components.CreateLiveStreamRequest;
import io.fastpix.sdk.models.components.InputMediaSettings;
import io.fastpix.sdk.models.components.PatchLiveStreamRequest;
import io.fastpix.sdk.models.components.PlaybackIdRequest;
import io.fastpix.sdk.models.components.PlaybackSettings;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.utils.JSON;

/**
 * Live streaming lifecycle: create a live stream, give it a playback id, read
 * and update it, toggle its state, then delete it. New streams start enabled,
 * so this disables before re-enabling and cleans up the stream at the end.
 */
public class LiveStreamingExample {

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

        ObjectMapper mapper = JSON.getMapper().enable(SerializationFeature.INDENT_OUTPUT);

        // 1. Create a live stream.
        var stream = sdk.streams().create(CreateLiveStreamRequest.builder()
                .playbackSettings(PlaybackSettings.builder()
                        .accessPolicy(BasicAccessPolicy.PUBLIC)
                        .build())
                .inputMediaSettings(InputMediaSettings.builder()
                        .metadata(Map.of("livestream_name", "fastpix_livestream"))
                        .build())
                .build());
        System.out.println("=== create stream ===");
        System.out.println(mapper.writeValueAsString(stream.liveStreamResponseDTO().get()));
        String streamId = stream.liveStreamResponseDTO().get().data().get().streamId().orElseThrow();

        // 2. Give it a playback id.
        System.out.println("\n=== create playback id ===");
        System.out.println(mapper.writeValueAsString(sdk.livePlayback()
                .createPlaybackId(streamId, PlaybackIdRequest.builder()
                        .accessPolicy(BasicAccessPolicy.PUBLIC)
                        .build())
                .playbackIdSuccessResponse().get()));

        // 3. Read + update the stream.
        System.out.println("\n=== get stream ===");
        System.out.println(mapper.writeValueAsString(
                sdk.manageLiveStream().get(streamId).livestreamgetResponse().get()));

        System.out.println("\n=== update stream ===");
        System.out.println(mapper.writeValueAsString(sdk.manageLiveStream()
                .update(streamId, PatchLiveStreamRequest.builder()
                        .metadata(Map.of("livestream_name", "renamed_stream"))
                        .reconnectWindow(100L)
                        .build())
                .patchResponseDTO().get()));

        // 4. Toggle state. New streams start enabled, so disable first, then re-enable.
        System.out.println("\n=== disable stream ===");
        System.out.println(mapper.writeValueAsString(
                sdk.liveStream().disable(streamId).liveStreamDeleteResponse().get()));

        System.out.println("\n=== enable stream ===");
        System.out.println(mapper.writeValueAsString(
                sdk.liveStream().enable(streamId).liveStreamDeleteResponse().get()));

        System.out.println("\n=== complete stream ===");
        System.out.println(mapper.writeValueAsString(
                sdk.liveStream().complete(streamId).liveStreamDeleteResponse().get()));

        // 5. Delete it.
        System.out.println("\n=== delete stream ===");
        System.out.println(mapper.writeValueAsString(
                sdk.liveStream().delete(streamId).liveStreamDeleteResponse().get()));
    }
}
