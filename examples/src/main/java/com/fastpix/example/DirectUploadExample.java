package com.fastpix.example;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.DirectUpload;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.SortOrder;
import io.fastpix.sdk.models.operations.DirectUploadVideoMediaAccessPolicy;
import io.fastpix.sdk.models.operations.DirectUploadVideoMediaRequest;
import io.fastpix.sdk.models.operations.DirectUploadVideoMediaResponse;
import io.fastpix.sdk.models.operations.PushMediaSettings;
import io.fastpix.sdk.utils.JSON;

/**
 * Direct upload: mint a signed URL to push a local file, then list and cancel
 * pending uploads. The file is PUT straight to the returned URL, so the bytes
 * never pass through your own server.
 */
public class DirectUploadExample {

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

        // 1. Create a direct upload. corsOrigin "*" lets a browser PUT from any origin.
        DirectUploadVideoMediaResponse created = sdk.inputVideos().upload()
                .request(DirectUploadVideoMediaRequest.builder()
                        .corsOrigin("*")
                        .pushMediaSettings(PushMediaSettings.builder()
                                .accessPolicy(DirectUploadVideoMediaAccessPolicy.PUBLIC)
                                .metadata(Map.of("key1", "value1"))
                                .build())
                        .build())
                .call();

        DirectUpload upload = created.object().get().data();
        String uploadId = upload.uploadId().orElseThrow();
        String url = upload.url().orElseThrow();
        System.out.println("=== create upload ===");
        System.out.println(mapper.writeValueAsString(upload));

        // 2. Upload the file with a single HTTP PUT to the returned URL. This is
        //    enough for small files; for larger ones you'll usually want a
        //    resumable upload (chunked, with retries) — the same URL supports that too.
        //    e.g. curl -X PUT --upload-file video.mp4 \
        //           -H "Content-Type: application/octet-stream" "<url>"
        System.out.println("\nPUT your file to: " + url);

        // 3. List pending uploads, then cancel this one if it hasn't started.
        System.out.println("\n=== list uploads ===");
        System.out.println(mapper.writeValueAsString(sdk.videos().listUploads()
                .limit(20L).offset(1L).orderBy(SortOrder.DESC).call().object().get()));

        System.out.println("\n=== cancel upload ===");
        System.out.println(mapper.writeValueAsString(sdk.videos().cancelUpload(uploadId).object().get()));
    }
}
