// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.List;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.MediaIdsRequest;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.ChangeMediaOrderInPlaylistResponse;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.utils.JSON;

public class UpdatePlaylistOrder {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        ChangeMediaOrderInPlaylistResponse res = sdk.playlist().updateMediaOrder()
                .playlistId("e2cc08cf-5a01-452d-9f45-0df331aaeaf2")
                .body(MediaIdsRequest.builder()
                    .mediaIds(List.of(
                       "a377377e-4c5c-4f05-9f47-0c5beebfe7b3",
                        "46e7a91c-bd1a-4291-88a8-8f44fcbc8c92",
                        "1b92e705-a48d-4503-b5cf-3880770a941f"))
                    .build())
                .call();

        if (res.playlistByIdResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.playlistByIdResponse().get()));
        }
    }
}