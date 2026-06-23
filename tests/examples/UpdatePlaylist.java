// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.UpdatePlaylistRequest;
import io.fastpix.sdk.models.operations.UpdateAPlaylistResponse;
import io.fastpix.sdk.utils.JSON;

public class UpdatePlaylist {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        UpdateAPlaylistResponse res = sdk.playlists().update()
                .playlistId("e2cc08cf-5a01-452d-9f45-0df331aaeaf2")
                .body(UpdatePlaylistRequest.builder()
                    .name("updated name")
                    .description("updated description")
                    .build())
                .call();

        if (res.playlistCreatedResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.playlistCreatedResponse().get()));
        }
    }
}