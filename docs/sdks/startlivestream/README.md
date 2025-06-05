# StartLiveStream
(*startLiveStream()*)

## Overview

### Available Operations

* [createNewStream](#createnewstream) - Create a new stream

## createNewStream

Allows you to initiate a new RTMP or SRT live stream on FastPix. Upon creating a stream, FastPix generates a unique stream key and SRT secret, which can be used with any broadcasting software (like OBS) to connect to FastPix's RTMP or SRT servers. Users can configure the stream settings, including metadata (such as stream name and description), reconnect window (in case of disconnection), privacy options (public or private), and advanced features like enabling DVR mode.
Leverage SRT for live streaming in environments with unstable networks, taking advantage of its error correction and encryption features for a resilient and secure broadcast. 

<h4>How it works</h4> 

When a user sends a POST request to this endpoint, FastPix returns the stream details for both RTMP and SRT configurations. These keys and IDs from the stream details are essential for connecting the broadcasting software to FastPix’s servers and transmitting the live stream to viewers.
FastPix uses <a href=https://docs.fastpix.io/docs/webhooks-for-status#/>webhooks</a> to tell your application about things that happen in the background, outside of the API regular request flow. For instance, once the live stream is created, we’ll shoot a POST message to the address you give us with the webhook event <a href=https://docs.fastpix.io/docs/video-live_stream-created#/>video.live_stream.created</a>. Here’re <a href=https://docs.fastpix.io/docs/webhooks-for-status#/live-stream-related-events>other live stream event related</a> webhooks you would want to look for. 

**Use case:** A gaming content creator initiates a live stream through the API, specifying a 1080p resolution and public access. They receive the stream key, RTMP and SRT details in the response. Using the SRT connection, they broadcast a high-action gaming session with reduced latency, offering viewers a seamless experience. 


**Detailed example:** 
  Imagine a gaming platform that allows users to live stream gameplay directly from their dashboard. The API creates a new stream, provides the necessary stream key, and sets it to "private" so that only specific viewers can access it. 

### Example Usage

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

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [CreateLiveStreamRequest](../../models/shared/CreateLiveStreamRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[CreateNewStreamResponse](../../models/operations/CreateNewStreamResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UnauthorizedException      | 401                                      | application/json                         |
| models/errors/InvalidPermissionException | 403                                      | application/json                         |
| models/errors/ValidationErrorResponse    | 422                                      | application/json                         |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |