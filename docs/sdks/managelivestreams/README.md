# ManageLiveStreams

## Overview

### Available Operations

* [getViewerCount](#getviewercount) - Get stream views by ID

## getViewerCount

This endpoint retrieves the current number of viewers watching a specific live stream, identified by its unique `streamId`.

The viewer count is an **approximate value**, optimized for performance. It provides a near-real-time estimate of how many clients are actively watching the stream. This approach ensures high efficiency, especially when the stream is being watched at large scale across multiple devices or platforms.

#### Example

Suppose a content creator is hosting a live concert and wants to display the number of live viewers on their dashboard. This endpoint can be queried to show up-to-date viewer statistics.

Related guide: <a href="https://docs.fastpix.io/docs/manage-streams">Manage streams</a>

> **Note:** In the examples below, `package hello.world;` is used for demonstration purposes. When creating your own Java files, ensure the package name matches your directory structure (e.g., if your file is at `src/main/java/com/example/MyApp.java`, use `package com.example;`).

### Example Usage

<!-- UsageSnippet language="java" operationID="get-live-stream-viewer-count-by-id" method="get" path="/live/streams/{streamId}/viewer-count" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.GetLiveStreamViewerCountByIdResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetLiveStreamViewerCountByIdResponse res = sdk.manageLiveStreams().getViewerCount()
                .streamId("your-stream-id")
                .call();

        if (res.viewsCountResponse().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.viewsCountResponse().get()));
        }
    }
}
```

### Parameters

| Parameter                                                                            | Type                                                                                 | Required                                                                             | Description                                                                          | Example                                                                              |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `streamId`                                                                           | *String*                                                                             | :heavy_check_mark:                                                                   | After creating a new live stream, FastPix assigns a unique identifier to the stream. | your-stream-id                                                     |

### Response

**[GetLiveStreamViewerCountByIdResponse](../../models/operations/GetLiveStreamViewerCountByIdResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |