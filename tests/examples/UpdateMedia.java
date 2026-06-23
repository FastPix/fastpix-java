// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.Map;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.UpdatedMediaRequestBody;
import io.fastpix.sdk.models.operations.UpdatedMediaResponse;
import io.fastpix.sdk.utils.JSON;

public class UpdateMedia {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        UpdatedMediaResponse res = sdk.videos().updateMedia()
                .mediaId("1b92e705-a48d-4503-b5cf-3880770a941f")
                .body(UpdatedMediaRequestBody.builder()
                    .metadata(Map.ofEntries(
                        Map.entry("user", "fastpix_admin")))
                    .title("test title")
                    .build())
                .call();

        if (res.object().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.object().get()));
        }
    }
}