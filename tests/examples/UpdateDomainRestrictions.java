// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.List;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.UpdateDomainRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateDomainRestrictionsResponse;
import io.fastpix.sdk.utils.JSON;

public class UpdateDomainRestrictions {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        UpdateDomainRestrictionsResponse res = sdk.playback().updateDomainRestrictions()
                .mediaId("7f2964fc-e3ca-4567-867f-cacd242e2fce")
                .playbackId("92baf72f-350e-4fb7-8dee-2223cce906f1")
                .body(UpdateDomainRestrictionsRequestBody.builder()
                    .allow(List.of(
                        "yourdomain.com",
                        "sampledomain.com"))
                    .deny(List.of(
                        "yourworkdomain.com"))
                    .build())
                .call();

        if (res.object().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.object().get()));
        }
    }
}