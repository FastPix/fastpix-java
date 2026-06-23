// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.Map;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.*;
import io.fastpix.sdk.utils.JSON;

public class UploadMedia {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        DirectUploadVideoMediaRequest req = DirectUploadVideoMediaRequest.builder()
                .pushMediaSettings(PushMediaSettings.builder()
                    .metadata(Map.ofEntries(
                        Map.entry("key1", "value1")))
                    .build())
                .build();

        DirectUploadVideoMediaResponse res = sdk.inputVideos().upload()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.object().get()));
        }
    }
}