# LivePlayback

## Overview

### Available Operations

* [createPlaybackId](#createplaybackid) - Create a playbackId
* [deletePlaybackId](#deleteplaybackid) - Delete a playbackId

## createPlaybackId

Generates a new playback ID for the live stream, allowing viewers to access the stream through this ID. The playback ID can be shared with viewers for direct access to the live broadcast. 

  By calling this endpoint with the `streamId`, FastPix returns a unique `playbackId`, which can be used to stream the live content. 

  #### Example

  A media platform needs to distribute a unique playback ID to users for an exclusive live concert. The platform can also embed the stream on various partner websites.

### Example Usage

<!-- UsageSnippet language="java" operationID="create-playbackId-of-stream" method="post" path="/live/streams/{streamId}/playback-ids" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.PlaybackIdRequest;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.CreatePlaybackIdOfStreamResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        CreatePlaybackIdOfStreamResponse res = sdk.livePlayback().createPlaybackId()
                .streamId("your-stream-id")
                .body(PlaybackIdRequest.builder()
                    .build())
                .call();

        if (res.playbackIdSuccessResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                            | Type                                                                                 | Required                                                                             | Description                                                                          | Example                                                                              |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
| `streamId`                                                                           | *String*                                                                             | :heavy_check_mark:                                                                   | After creating a new live stream, FastPix assigns a unique identifier to the stream. | your-stream-id                                                                     |
| `body`                                                                               | [PlaybackIdRequest](../../models/components/PlaybackIdRequest.md)                    | :heavy_check_mark:                                                                   | N/A                                                                                  | {<br/>"accessPolicy": "public"<br/>}                                                 |

### Response

**[CreatePlaybackIdOfStreamResponse](../../models/operations/CreatePlaybackIdOfStreamResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deletePlaybackId

Deletes a previously created playback ID for a live stream.This prevents new viewers from accessing the stream using the playback ID, while current viewers can continue watching for a short period before the connection ends. FastPix deletes the ID and ensures the new playback request fails.

#### Example
A streaming service wants to prevent new users from joining a live stream that is nearing its end. The host can delete the playback ID to ensure no one can join the stream or replay it once it ends.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-playbackId-of-stream" method="delete" path="/live/streams/{streamId}/playback-ids" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.DeletePlaybackIdOfStreamResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        DeletePlaybackIdOfStreamResponse res = sdk.livePlayback().deletePlaybackId()
                .streamId("your-stream-id")
                .playbackId("your-playback-id")
                .call();

        if (res.liveStreamDeleteResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         | Example                                                                             |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `streamId`                                                                          | *String*                                                                            | :heavy_check_mark:                                                                  | Upon creating a new live stream, FastPix assigns a unique identifier to the stream. | your-stream-id                                                                      |
| `playbackId`                                                                        | *String*                                                                            | :heavy_check_mark:                                                                  | Unique identifier for the playbackId                                                | your-playback-id                                                                    |

### Response

**[DeletePlaybackIdOfStreamResponse](../../models/operations/DeletePlaybackIdOfStreamResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |