// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.Map;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.SimulcastRequest;
import io.fastpix.sdk.models.operations.CreateSimulcastOfStreamResponse;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.utils.JSON;

public class CreateSimulcast {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        CreateSimulcastOfStreamResponse res = sdk.simulcastStream().create()
                .streamId("181dcf5c1a6c0c0f0cdfec668be2861f")
                .body(SimulcastRequest.builder()
                    .url("rtmp://hyd01.contribute.live-video.net/app/")
                    .streamKey("live_1012464221_DuM8W004MoZYNxQEZ0czODgfHCFBhk")
                    .metadata(Map.ofEntries(
                        Map.entry("livestream_name", "Tech-Connect Summit")))
                    .build())
                .call();

        if (res.simulcastResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.simulcastResponse().get()));
        }
    }
}