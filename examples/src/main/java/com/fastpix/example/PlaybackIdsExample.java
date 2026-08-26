package com.fastpix.example;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.AccessPolicy;
import io.fastpix.sdk.models.operations.Resolution;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.CreateMediaPlaybackIdRequestBody;
import io.fastpix.sdk.models.operations.CreateMediaPlaybackIdResponse;
import io.fastpix.sdk.models.operations.UpdateDomainRestrictionsDefaultPolicy;
import io.fastpix.sdk.models.operations.UpdateDomainRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateUserAgentRestrictionsDefaultPolicy;
import io.fastpix.sdk.models.operations.UpdateUserAgentRestrictionsRequestBody;
import io.fastpix.sdk.utils.JSON;

/**
 * Playback IDs & access control: create a playback ID for a media, restrict
 * playback by domain and user agent, then delete the playback ID.
 */
public class PlaybackIdsExample {

    // A media in "Ready" status from your workspace. A just-created media is
    // rejected ("Media associated with the playbackId is yet to be processed"),
    // so point this at one that has finished processing.
    static final String MEDIA_ID = "REPLACE_WITH_A_READY_MEDIA_ID";

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

        // 1. Create a playback ID for the media.
        CreateMediaPlaybackIdResponse playback = sdk.playback().createId(MEDIA_ID,
                CreateMediaPlaybackIdRequestBody.builder()
                        .accessPolicy(AccessPolicy.PUBLIC)
                        .resolution(Resolution.ONE_THOUSAND_AND_EIGHTYP)
                        .build(),
                null);
        System.out.println("=== create playback id ===");
        System.out.println(mapper.writeValueAsString(playback.object().get()));
        String playbackId = playback.object().get().data().orElseThrow().id().orElseThrow();

        // 2. Restrict which domains and user agents may play it.
        System.out.println("\n=== domain restrictions ===");
        System.out.println(mapper.writeValueAsString(sdk.playback()
                .updateDomainRestrictions(MEDIA_ID, playbackId,
                        UpdateDomainRestrictionsRequestBody.builder()
                                .defaultPolicy(UpdateDomainRestrictionsDefaultPolicy.ALLOW)
                                .allow(List.of("yourdomain.com"))
                                .deny(List.of("blockeddomain.com"))
                                .build())
                .object().get()));

        System.out.println("\n=== user-agent restrictions ===");
        System.out.println(mapper.writeValueAsString(sdk.playback()
                .updateUserAgentRestrictions(MEDIA_ID, playbackId,
                        UpdateUserAgentRestrictionsRequestBody.builder()
                                .defaultPolicy(UpdateUserAgentRestrictionsDefaultPolicy.ALLOW)
                                .allow(List.of("Mozilla/5.0"))
                                .deny(List.of())
                                .build())
                .object().get()));

        // 3. Remove the playback ID.
        System.out.println("\n=== delete playback id ===");
        System.out.println(mapper.writeValueAsString(
                sdk.playback().deleteId(MEDIA_ID, playbackId).object().get()));
    }
}
