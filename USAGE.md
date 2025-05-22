<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.*;
import io.fastpix.sdk.models.errors.*;
import io.fastpix.sdk.models.operations.CreateNewStreamResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UnauthorizedException, InvalidPermissionException, ValidationErrorResponse, Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("")
                    .password("")
                    .build())
            .build();

        CreateLiveStreamRequest req = CreateLiveStreamRequest.builder()
                .playbackSettings(PlaybackSettings.builder()
                    .build())
                .inputMediaSettings(InputMediaSettings.builder()
                    .build())
                .build();

        CreateNewStreamResponse res = sdk.startLiveStream().createNewStream()
                .request(req)
                .call();

        if (res.liveStreamResponseDTO().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->