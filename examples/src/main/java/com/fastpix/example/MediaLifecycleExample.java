package com.fastpix.example;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.CreateMediaRequest;
import io.fastpix.sdk.models.components.CreateMediaRequestAccessPolicy;
import io.fastpix.sdk.models.components.CreateMediaRequestMaxResolution;
import io.fastpix.sdk.models.components.CreateMediaRequestMp4Support;
import io.fastpix.sdk.models.components.Input;
import io.fastpix.sdk.models.components.PullVideoInput;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.SortOrder;
import io.fastpix.sdk.models.operations.UpdatedMediaRequestBody;
import io.fastpix.sdk.models.operations.UpdatedSourceAccessRequestBody;
import io.fastpix.sdk.utils.JSON;

/**
 * Full media lifecycle: create media from a public URL (with MP4 renditions
 * enabled), get it, list the workspace, update its metadata, flip source access,
 * then delete it. The created media is cleaned up at the end.
 */
public class MediaLifecycleExample {

    // A publicly reachable sample video FastPix can pull and ingest.
    private static final String SAMPLE_URL =
            "https://static.fastpix.io/sample.mp4";

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

        // 1. Create media from a URL. MP4 renditions are enabled here, at create
        //    time — the one place mp4Support is set (updating it later is only
        //    allowed once the media has finished processing).
        var created = sdk.inputVideos().create()
                .request(CreateMediaRequest.builder()
                        .inputs(List.of(Input.of(PullVideoInput.builder()
                                .type("video")
                                .url(SAMPLE_URL)
                                .build())))
                        .metadata(Map.of("purpose", "lifecycle-example"))
                        .accessPolicy(CreateMediaRequestAccessPolicy.PUBLIC)
                        .maxResolution(CreateMediaRequestMaxResolution.ONE_THOUSAND_AND_EIGHTYP)
                        .mp4Support(CreateMediaRequestMp4Support.CAPPED4K)
                        .build())
                .call();

        String mediaId = created.createMediaSuccessResponse().get()
                .data().get().id().get();
        System.out.println("=== create media ===");
        System.out.println(mapper.writeValueAsString(created.createMediaSuccessResponse().get()));
        System.out.println("\nmediaId: " + mediaId);

        // 2. Get the media back by id.
        System.out.println("\n=== get media ===");
        System.out.println(mapper.writeValueAsString(
                sdk.manageVideos().get().mediaId(mediaId).call().object().get()));

        // 3. List media in the workspace, newest first.
        System.out.println("\n=== list media ===");
        System.out.println(mapper.writeValueAsString(sdk.manageVideos().list()
                .limit(10L).offset(1L).orderBy(SortOrder.DESC).call().object().get()));

        // 4. Update metadata / title.
        System.out.println("\n=== update media ===");
        System.out.println(mapper.writeValueAsString(sdk.videos().updateMedia()
                .mediaId(mediaId)
                .body(UpdatedMediaRequestBody.builder()
                        .title("Lifecycle example (updated)")
                        .metadata(Map.of("stage", "updated"))
                        .build())
                .call().object().get()));

        // 5. Toggle whether the original source file stays downloadable.
        System.out.println("\n=== update source access ===");
        System.out.println(mapper.writeValueAsString(sdk.manageVideos().updateSourceAccess()
                .mediaId(mediaId)
                .body(UpdatedSourceAccessRequestBody.builder()
                        .sourceAccess(true)
                        .build())
                .call().object().get()));

        // 6. Clean up: delete the media created above.
        System.out.println("\n=== delete media ===");
        System.out.println(mapper.writeValueAsString(
                sdk.videos().delete().mediaId(mediaId).call().object().get()));
    }
}
