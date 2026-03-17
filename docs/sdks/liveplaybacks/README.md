# LivePlaybacks

## Overview

### Available Operations

* [getPlaybackIdDetails](#getplaybackiddetails) - Get playbackId details

## getPlaybackIdDetails

Retrieves details for an existing playback ID. When you provide the playbackId returned from a previous stream or playback creation request, FastPix returns the associated playback information, including the access policy.

#### Example
A developer needs to confirm the access policy of the playback ID to ensure whether the stream is public or private for viewers.

> **Note:** In the examples below, `package hello.world;` is used for demonstration purposes. When creating your own Java files, ensure the package name matches your directory structure (e.g., if your file is at `src/main/java/com/example/MyApp.java`, use `package com.example;`).

### Example Usage

<!-- UsageSnippet language="java" operationID="get-live-stream-playback-id" method="get" path="/live/streams/{streamId}/playback-ids/{playbackId}" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.GetLiveStreamPlaybackIdResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetLiveStreamPlaybackIdResponse res = sdk.livePlaybacks().getPlaybackIdDetails()
                .streamId("your-stream-id")
                .playbackId("your-playback-id")
                .call();

        if (res.playbackIdSuccessResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.playbackIdSuccessResponse().get()));
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           | Example                                                                               |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `streamId`                                                                            | *String*                                                                              | :heavy_check_mark:                                                                    | After creating a new live stream, FastPix assigns a unique identifier to the stream.  | your-stream-id                                                      |
| `playbackId`                                                                          | *String*                                                                              | :heavy_check_mark:                                                                    | After creating a new playbackId, FastPix assigns a unique identifier to the playback. | your-playback-id                                                      |

### Response

**[GetLiveStreamPlaybackIdResponse](../../models/operations/GetLiveStreamPlaybackIdResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |