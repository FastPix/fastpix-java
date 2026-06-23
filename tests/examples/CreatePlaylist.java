// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.*;
import io.fastpix.sdk.models.operations.CreateAPlaylistResponse;
import io.fastpix.sdk.utils.JSON;

public class CreatePlaylist {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("1b92c0d6-5548-4642-b13e-4bb7d77dbaf4")
                    .password("ff32012b-ec02-40ca-b0d4-711d81537e73")
                    .build())
            .build();

        CreatePlaylistRequest req = CreatePlaylistRequestSmart.builder()
                .name("playlist name")
                .referenceId("a7")
                .type(CreatePlaylistRequestSmartType.SMART)
                .playOrder(PlaylistOrder.CREATED_DATE_ASC)
                .metadata(Metadata.builder()
                    .createdDate(DateRange.builder()
                        .startDate("2026-06-23") // Example 2024-11-11
                        .endDate("2026-06-24") // Example 2024-11-11
                        .build())
                    .updatedDate(DateRange.builder()
                        .startDate("2026-06-23") //Example 2024-11-11
                        .endDate("2026-06-24") //Example 2024-12-12
                        .build())
                    .build())
                .description("your-playlist-description")
                .limit(20L)
                .build();

        CreateAPlaylistResponse res = sdk.playlists().create()
                .request(req)
                .call();

        if (res.playlistCreatedResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.playlistCreatedResponse().get()));
        }
    }
}