// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.*;
import io.fastpix.sdk.models.operations.CreateMediaResponse;
import io.fastpix.sdk.utils.JSON;

public class CreateMedia {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        CreateMediaRequest req = CreateMediaRequest.builder()
                .inputs(List.of(
                    Input.of(PullVideoInput.builder()
                        .build())))
                .metadata(Map.ofEntries(
                    Map.entry("key1", "value1")))
                .build();

        CreateMediaResponse res = sdk.inputVideos().create()
                .request(req)
                .call();

        if (res.createMediaSuccessResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.createMediaSuccessResponse().get()));
        }
    }
}