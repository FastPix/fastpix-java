// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.PlaybackIdRequest;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.CreatePlaybackIdOfStreamResponse;
import io.fastpix.sdk.utils.JSON;

public class CreateLivePlaybackId {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        CreatePlaybackIdOfStreamResponse res = sdk.livePlayback().createPlaybackId()
                .streamId("181dcf5c1a6c0c0f0cdfec668be2861f")
                .body(PlaybackIdRequest.builder()
                    .build())
                .call();

        if (res.playbackIdSuccessResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.playbackIdSuccessResponse().get()));
        }
    }
}