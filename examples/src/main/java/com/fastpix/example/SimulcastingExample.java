package com.fastpix.example;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.BasicAccessPolicy;
import io.fastpix.sdk.models.components.CreateLiveStreamRequest;
import io.fastpix.sdk.models.components.InputMediaSettings;
import io.fastpix.sdk.models.components.PlaybackSettings;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.SimulcastRequest;
import io.fastpix.sdk.models.components.SimulcastUpdateRequest;
import io.fastpix.sdk.utils.JSON;

/**
 * Simulcasting: create a live stream, add a simulcast target (an external RTMP
 * destination such as YouTube or Twitch), update it, then remove the simulcast
 * and the stream.
 */
public class SimulcastingExample {

    // Point these at your own destination. The URL is the third-party RTMP
    // ingest endpoint and the key is its stream key.
    static final String SIMULCAST_URL = "rtmp://your-target/app";
    static final String SIMULCAST_KEY = "your-stream-key";

    public static void main(String[] args) throws Exception {
        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                        .username(System.getenv("FASTPIX_USERNAME"))
                        .password(System.getenv("FASTPIX_PASSWORD"))
                        .build())
                .build();

        ObjectMapper mapper = JSON.getMapper().enable(SerializationFeature.INDENT_OUTPUT);

        // 1. Create a stream to simulcast.
        var stream = sdk.streams().create(CreateLiveStreamRequest.builder()
                .playbackSettings(PlaybackSettings.builder()
                        .accessPolicy(BasicAccessPolicy.PUBLIC)
                        .build())
                .inputMediaSettings(InputMediaSettings.builder()
                        .metadata(Map.of("livestream_name", "fastpix_livestream"))
                        .build())
                .build());
        String streamId = stream.liveStreamResponseDTO().get().data().get().streamId().orElseThrow();
        System.out.println("=== create stream ===");
        System.out.println(mapper.writeValueAsString(stream.liveStreamResponseDTO().get()));

        // 2. Add a simulcast target (RTMP url + stream key of the destination).
        var simulcast = sdk.simulcastStream().create(streamId, SimulcastRequest.builder()
                .url(SIMULCAST_URL)
                .streamKey(SIMULCAST_KEY)
                .metadata(Map.of("livestream_name", "Tech-Connect Summit"))
                .build());
        System.out.println("\n=== create simulcast ===");
        System.out.println(mapper.writeValueAsString(simulcast.simulcastResponse().get()));
        String simulcastId = simulcast.simulcastResponse().get().data().get().simulcastId().orElseThrow();

        // 3. Update the simulcast (enable/disable, rename).
        System.out.println("\n=== update simulcast ===");
        System.out.println(mapper.writeValueAsString(sdk.simulcasts()
                .update(streamId, simulcastId, SimulcastUpdateRequest.builder()
                        .isEnabled(true)
                        .metadata(Map.of("simulcast_name", "Tech today"))
                        .build())
                .simulcastUpdateResponse().get()));

        // 4. Remove the simulcast, then the stream.
        System.out.println("\n=== delete simulcast ===");
        System.out.println(mapper.writeValueAsString(
                sdk.simulcastStreams().delete(streamId, simulcastId).simulcastdeleteResponse().get()));

        System.out.println("\n=== delete stream ===");
        System.out.println(mapper.writeValueAsString(
                sdk.liveStream().delete(streamId).liveStreamDeleteResponse().get()));
    }
}
