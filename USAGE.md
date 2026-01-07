<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import java.util.Map;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.operations.CreateMediaResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
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
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->