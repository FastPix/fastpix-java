// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.Map;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.*;
import io.fastpix.sdk.models.operations.CreateNewStreamResponse;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.utils.JSON;

public class CreateLiveStream {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        CreateLiveStreamRequest req = CreateLiveStreamRequest.builder()
                .playbackSettings(PlaybackSettings.builder()
                    .build())
                .inputMediaSettings(InputMediaSettings.builder()
                    .metadata(Map.ofEntries(
                        Map.entry("livestream_name", "fastpix_livestream")))
                    .build())
                .build();

        CreateNewStreamResponse res = sdk.streams().create()
                .request(req)
                .call();

        if (res.liveStreamResponseDTO().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.liveStreamResponseDTO().get()));
        }
    }
}