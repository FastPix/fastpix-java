<!-- Start SDK Example Usage [usage] -->

> **Note:** In the examples below, `package hello.world;` is used for demonstration purposes. When creating your own Java files, ensure the package name matches your directory structure (e.g., if your file is at `src/main/java/com/example/MyApp.java`, use `package com.example;`).

```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.List;
import java.util.Map;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.*;
import io.fastpix.sdk.models.operations.CreateMediaResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
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