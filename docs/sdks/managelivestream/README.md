# ManageLiveStream

## Overview

### Available Operations

* [get](#get) - Get stream by ID
* [update](#update) - Update a stream

## get

This endpoint retrieves details about a specific live stream by its unique `streamId`. It includes data such as the stream’s `status` (idle, preparing, active, disabled), `metadata` (title, description), and more. 
#### Example

  Suppose a news agency is broadcasting a live event and wants to track the configurations set for the live stream while also checking the stream's status.


Related guide: <a href="https://docs.fastpix.io/docs/manage-streams">Manage streams</a>

> **Note:** In the examples below, `package hello.world;` is used for demonstration purposes. When creating your own Java files, ensure the package name matches your directory structure (e.g., if your file is at `src/main/java/com/example/MyApp.java`, use `package com.example;`).

### Example Usage

<!-- UsageSnippet language="java" operationID="get-live-stream-by-id" method="get" path="/live/streams/{streamId}" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.GetLiveStreamByIdResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetLiveStreamByIdResponse res = sdk.manageLiveStream().get()
                .streamId("your-stream-id")
                .call();

        if (res.livestreamgetResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.livestreamgetResponse().get()));
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         | Example                                                                             |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `streamId`                                                                          | *String*                                                                            | :heavy_check_mark:                                                                  | Upon creating a new live stream, FastPix assigns a unique identifier to the stream. | your-stream-id                                                    |

### Response

**[GetLiveStreamByIdResponse](../../models/operations/GetLiveStreamByIdResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## update

This endpoint allows you to modify the parameters of an existing live stream, such as its `metadata` (title, description) or the `reconnectWindow`. It’s useful for making changes to a stream that has already been created but not yet ended. After the live stream is disabled, you cannot update a stream. 


  The updated stream parameters and the `streamId` needs to be shared in the request, and FastPix returns the updated stream details. After the update, <a href="https://docs.fastpix.io/docs/live-events#videolive_streamupdated">video.live_stream.updated</a> webhook event notifies your system.

 #### Example

 A host realizes they need to extend the reconnect window for their live stream in case they lose connection temporarily during the event. Or suppose during a multi-day online conference, the event organizers need to update the stream title to reflect the next day"s session while keeping the same stream ID for continuity. 



  Related guide: <a href="https://docs.fastpix.io/docs/manage-streams">Manage streams</a>

### Example Usage

<!-- UsageSnippet language="java" operationID="update-live-stream" method="patch" path="/live/streams/{streamId}" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.Map;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.PatchLiveStreamRequest;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.UpdateLiveStreamResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateLiveStreamResponse res = sdk.manageLiveStream().update()
                .streamId("your-stream-id")
                .body(PatchLiveStreamRequest.builder()
                    .metadata(Map.ofEntries(
                        Map.entry("livestream_name", "Gaming_stream")))
                    .reconnectWindow(100L)
                    .build())
                .call();

        if (res.patchResponseDTO().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.patchResponseDTO().get()));
        }
    }
}
```

### Parameters

| Parameter                                                                            | Type                                                                                 | Required                                                                             | Description                                                                          | Example                                                                              |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `streamId`                                                                           | *String*                                                                             | :heavy_check_mark:                                                                   | After creating a new live stream, FastPix assigns a unique identifier to the stream. | your-stream-id                                                     |
| `body`                                                                               | [PatchLiveStreamRequest](../../models/components/PatchLiveStreamRequest.md)          | :heavy_check_mark:                                                                   | N/A                                                                                  | {<br/>"metadata": {<br/>"livestream_name": "your-livestream-name"<br/>},<br/>"reconnectWindow": 100<br/>} |

### Response

**[UpdateLiveStreamResponse](../../models/operations/UpdateLiveStreamResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |