// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.Map;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.SimulcastUpdateRequest;
import io.fastpix.sdk.models.operations.UpdateSpecificSimulcastOfStreamResponse;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.utils.JSON;

public class UpdateSimulcast {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        UpdateSpecificSimulcastOfStreamResponse res = sdk.simulcasts().update()
                .streamId("181dcf5c1a6c0c0f0cdfec668be2861f")
                .simulcastId("70e6cf47b157f13129db74b0d21b50b5")
                .body(SimulcastUpdateRequest.builder()
                    .metadata(Map.ofEntries(
                        Map.entry("simulcast_name", "Tech today")))
                    .build())
                .call();

        if (res.simulcastUpdateResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.simulcastUpdateResponse().get()));
        }
    }
}