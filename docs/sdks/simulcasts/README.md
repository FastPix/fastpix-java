# Simulcasts

## Overview

### Available Operations

* [update](#update) - Update a simulcast

## update

Updates the status of a specific simulcast linked to a parent live stream. You can enable or disable the simulcast at any time while the parent stream is active or idle. After the live stream is disabled, the simulcast can no longer be modified.

Webhook event: <a href="https://docs.fastpix.io/docs/live-events#videolive_streamsimulcast_targetupdated">video.live_stream.simulcast_target.updated</a>

#### Example
When a `PATCH` request is made to this endpoint, the API updates the status of the simulcast. This can be useful for pausing or resuming a simulcast on a particular platform without stopping the parent live stream.

### Example Usage

<!-- UsageSnippet language="java" operationID="update-specific-simulcast-of-stream" method="put" path="/live/streams/{streamId}/simulcast/{simulcastId}" -->
```java
package hello.world;

import java.lang.Exception;
import java.util.Map;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.components.SimulcastUpdateRequest;
import org.openapis.openapi.models.operations.UpdateSpecificSimulcastOfStreamResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateSpecificSimulcastOfStreamResponse res = sdk.simulcasts().update()
                .streamId("9714422d89287ad5758d4a86e9afe1a2")
                .simulcastId("8717422d89288ad5958d4a86e9afe2a2")
                .body(SimulcastUpdateRequest.builder()
                    .metadata(Map.ofEntries(
                        Map.entry("simulcast_name", "Tech today")))
                    .build())
                .call();

        if (res.simulcastUpdateResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                      | Type                                                                                                                           | Required                                                                                                                       | Description                                                                                                                    | Example                                                                                                                        |
| ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ |
| `streamId`                                                                                                                     | *String*                                                                                                                       | :heavy_check_mark:                                                                                                             | Upon creating a new live stream, FastPix assigns a unique identifier to the stream.                                            | 9714422d89287ad5758d4a86e9afe1a2                                                                                               |
| `simulcastId`                                                                                                                  | *String*                                                                                                                       | :heavy_check_mark:                                                                                                             | When you create the new simulcast, FastPix assign a universal unique identifier which can contain a maximum of 255 characters. | 8717422d89288ad5958d4a86e9afe2a2                                                                                               |
| `body`                                                                                                                         | [SimulcastUpdateRequest](../../models/components/SimulcastUpdateRequest.md)                                                    | :heavy_check_mark:                                                                                                             | N/A                                                                                                                            | {<br/>"isEnabled": true,<br/>"metadata": {<br/>"simulcast_name": "Tech today"<br/>}<br/>}                                      |

### Response

**[UpdateSpecificSimulcastOfStreamResponse](../../models/operations/UpdateSpecificSimulcastOfStreamResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |