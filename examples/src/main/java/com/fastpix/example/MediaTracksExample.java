package com.fastpix.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.AddTrackRequest;
import io.fastpix.sdk.models.components.AddTrackRequestType;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.AddMediaTrackRequestBody;
import io.fastpix.sdk.utils.JSON;

/**
 * Media tracks: attach an alternate audio track and a subtitle track to a ready
 * media. Adding a track is synchronous and returns immediately.
 *
 * Updating, deleting, or generating subtitles from a track requires the track to
 * finish processing first — listen for the `track.ready` webhook before those
 * calls (see the verify-webhook example for how to receive webhooks).
 */
public class MediaTracksExample {

    // A media in "Ready" status from your workspace (see MediaLifecycleExample).
    // A just-created media is still processing, so point this at a ready one.
    private static final String MEDIA_ID = "REPLACE_WITH_A_READY_MEDIA_ID";

    // Public sample assets to attach as tracks.
    private static final String AUDIO_URL = "https://static.fastpix.io/sample.m4a";
    private static final String SUBTITLE_URL = "https://static.fastpix.io/sample.vtt";

    public static void main(String[] args) throws Exception {
        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                        .username(System.getenv("FASTPIX_USERNAME"))
                        .password(System.getenv("FASTPIX_PASSWORD"))
                        .build())
                .build();

        ObjectMapper mapper = JSON.getMapper().enable(SerializationFeature.INDENT_OUTPUT);

        // Add an alternate (French) audio track.
        var audio = sdk.manageVideos().addTrack()
                .mediaId(MEDIA_ID)
                .body(AddMediaTrackRequestBody.builder()
                        .tracks(AddTrackRequest.builder()
                                .url(AUDIO_URL)
                                .type(AddTrackRequestType.AUDIO)
                                .languageCode("fr")
                                .languageName("French")
                                .build())
                        .build())
                .call();
        System.out.println("=== add audio track ===");
        System.out.println(mapper.writeValueAsString(audio.object().get()));

        // Add a (Spanish) subtitle track.
        var subtitle = sdk.manageVideos().addTrack()
                .mediaId(MEDIA_ID)
                .body(AddMediaTrackRequestBody.builder()
                        .tracks(AddTrackRequest.builder()
                                .url(SUBTITLE_URL)
                                .type(AddTrackRequestType.SUBTITLE)
                                .languageCode("es")
                                .languageName("Spanish")
                                .build())
                        .build())
                .call();
        System.out.println("\n=== add subtitle track ===");
        System.out.println(mapper.writeValueAsString(subtitle.object().get()));
    }
}
