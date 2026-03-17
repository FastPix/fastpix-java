# Simulcasts

## Overview

### Available Operations

* [update](#update) - Update a simulcast

## update

Updates the status of a specific simulcast linked to a parent live stream. You can enable or disable the simulcast at any time while the parent stream is active or idle. After the live stream is disabled, the simulcast can no longer be modified.

Webhook event: <a href="https://docs.fastpix.io/docs/live-events#videolive_streamsimulcast_targetupdated">video.live_stream.simulcast_target.updated</a>

#### Example
When a `PATCH` request is made to this endpoint, the API updates the status of the simulcast. This can be useful for pausing or resuming a simulcast on a particular platform without stopping the parent live stream.

> **Note:** In the examples below, `package hello.world;` is used for demonstration purposes. When creating your own Java files, ensure the package name matches your directory structure (e.g., if your file is at `src/main/java/com/example/MyApp.java`, use `package com.example;`).

### Example Usage

<!-- UsageSnippet language="java" operationID="update-specific-simulcast-of-stream" method="put" path="/live/streams/{streamId}/simulcast/{simulcastId}" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.Map;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.SimulcastUpdateRequest;
import io.fastpix.sdk.models.operations.UpdateSpecificSimulcastOfStreamResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateSpecificSimulcastOfStreamResponse res = sdk.simulcasts().update()
                .streamId("your-stream-id")
                .simulcastId("your-simulcast-id")
                .body(SimulcastUpdateRequest.builder()
                    .metadata(Map.ofEntries(
                        Map.entry("simulcast_name", "Tech today")))
                    .build())
                .call();

        if (res.simulcastUpdateResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.simulcastUpdateResponse().get()));
        }
    }
}
```

### Parameters

| Parameter                                                                                                                      | Type                                                                                                                           | Required                                                                                                                       | Description                                                                                                                    | Example                                                                                                                        |
| ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ |
| `streamId`                                                                                                                     | *String*                                                                                                                       | :heavy_check_mark:                                                                                                             | Upon creating a new live stream, FastPix assigns a unique identifier to the stream.                                            | your-stream-id                                                                                               |
| `simulcastId`                                                                                                                  | *String*                                                                                                                       | :heavy_check_mark:                                                                                                             | When you create the new simulcast, FastPix assign a universal unique identifier which can contain a maximum of 255 characters. | your-simulcast-id                                                                                               |
| `body`                                                                                                                         | [SimulcastUpdateRequest](../../models/components/SimulcastUpdateRequest.md)                                                    | :heavy_check_mark:                                                                                                             | N/A                                                                                                                            | {<br/>"isEnabled": true,<br/>"metadata": {<br/>"simulcast_name": "your-simulcast-name"<br/>}<br/>}                                      |

### Response

**[UpdateSpecificSimulcastOfStreamResponse](../../models/operations/UpdateSpecificSimulcastOfStreamResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |