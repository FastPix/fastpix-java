// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.List;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.UpdateUserAgentRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateUserAgentRestrictionsResponse;
import io.fastpix.sdk.utils.JSON;

public class UpdateUserAgentRestrictions {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        UpdateUserAgentRestrictionsResponse res = sdk.playback().updateUserAgentRestrictions()
                .mediaId("7f2964fc-e3ca-4567-867f-cacd242e2fce")
                .playbackId("92baf72f-350e-4fb7-8dee-2223cce906f1")
                .body(UpdateUserAgentRestrictionsRequestBody.builder()
                    .allow(List.of(
                        "Mozilla/55.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36"))
                    .deny(List.of(
                        "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/53745.36 (KHTML, like Gecko) Chrome/138.0.0.0 Mobile Safari/537.36"))
                    .build())
                .call();

        if (res.object().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.object().get()));
        }
    }
}