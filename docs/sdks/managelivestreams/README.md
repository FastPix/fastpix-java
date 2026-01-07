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

### Example Usage

<!-- UsageSnippet language="java" operationID="get-live-stream-viewer-count-by-id" method="get" path="/live/streams/{streamId}/viewer-count" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.GetLiveStreamViewerCountByIdResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetLiveStreamViewerCountByIdResponse res = sdk.manageLiveStreams().getViewerCount()
                .streamId("61a264dcc447b63da6fb79ef925cd76d")
                .call();

        if (res.viewsCountResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                            | Type                                                                                 | Required                                                                             | Description                                                                          | Example                                                                              |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `streamId`                                                                           | *String*                                                                             | :heavy_check_mark:                                                                   | After creating a new live stream, FastPix assigns a unique identifier to the stream. | 61a264dcc447b63da6fb79ef925cd76d                                                     |

### Response

**[GetLiveStreamViewerCountByIdResponse](../../models/operations/GetLiveStreamViewerCountByIdResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |