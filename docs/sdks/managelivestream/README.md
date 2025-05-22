# ManageLiveStream
(*manageLiveStream()*)

## Overview

### Available Operations

* [getAllStreams](#getallstreams) - Get all live streams
* [getLiveStreamById](#getlivestreambyid) - Get stream by ID
* [deleteLiveStream](#deletelivestream) - Delete a stream
* [updateLiveStream](#updatelivestream) - Update a stream

## getAllStreams

Retrieves a list of all live streams associated with the user’s account (workspace). It provides an overview of both current and past live streams, including details like streamId, title, status, and creation time. 

### Example Usage

```java
package hello.world;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.errors.*;
import io.fastpix.sdk.models.operations.GetAllStreamsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UnauthorizedException, InvalidPermissionException, ValidationErrorResponse, Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("")
                    .password("")
                    .build())
            .build();

        GetAllStreamsResponse res = sdk.manageLiveStream().getAllStreams()
                .call();

        if (res.getStreamsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                           | Type                                                                                                                                | Required                                                                                                                            | Description                                                                                                                         | Example                                                                                                                             |
| ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| `limit`                                                                                                                             | *Optional\<String>*                                                                                                                 | :heavy_minus_sign:                                                                                                                  | Limit specifies the maximum number of items to display per page.                                                                    | 20                                                                                                                                  |
| `offset`                                                                                                                            | *Optional\<String>*                                                                                                                 | :heavy_minus_sign:                                                                                                                  | Offset determines the starting point for data retrieval within a paginated list.                                                    | 1                                                                                                                                   |
| `orderBy`                                                                                                                           | [Optional\<GetAllStreamsOrderBy>](../../models/operations/GetAllStreamsOrderBy.md)                                                  | :heavy_minus_sign:                                                                                                                  | The list of value can be order in two ways DESC (Descending) or ASC (Ascending). In case not specified, by default it will be DESC. | desc                                                                                                                                |

### Response

**[GetAllStreamsResponse](../../models/operations/GetAllStreamsResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UnauthorizedException      | 401                                      | application/json                         |
| models/errors/InvalidPermissionException | 403                                      | application/json                         |
| models/errors/ValidationErrorResponse    | 422                                      | application/json                         |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## getLiveStreamById

This endpoint retrieves detailed information about a specific live stream by its unique streamId. It includes data such as the stream’s status (idle, preparing, active, disabled), metadata (title, description), and more. 

  **Practical example:** Suppose a news agency is broadcasting a live event and wants to track the configurations set for the live stream while also checking the stream's status.

### Example Usage

```java
package hello.world;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.errors.*;
import io.fastpix.sdk.models.operations.GetLiveStreamByIdResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UnauthorizedException, InvalidPermissionException, NotFoundError, ValidationErrorResponse, Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("")
                    .password("")
                    .build())
            .build();

        GetLiveStreamByIdResponse res = sdk.manageLiveStream().getLiveStreamById()
                .streamId("61a264dcc447b63da6fb79ef925cd76d")
                .call();

        if (res.livestreamgetResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                           | Type                                                                                | Required                                                                            | Description                                                                         | Example                                                                             |
| ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| `streamId`                                                                          | *String*                                                                            | :heavy_check_mark:                                                                  | Upon creating a new live stream, FastPix assigns a unique identifier to the stream. | 61a264dcc447b63da6fb79ef925cd76d                                                    |

### Response

**[GetLiveStreamByIdResponse](../../models/operations/GetLiveStreamByIdResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UnauthorizedException      | 401                                      | application/json                         |
| models/errors/InvalidPermissionException | 403                                      | application/json                         |
| models/errors/NotFoundError              | 404                                      | application/json                         |
| models/errors/ValidationErrorResponse    | 422                                      | application/json                         |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## deleteLiveStream

Permanently removes a specified live stream from the workspace. If the stream is still active, the encoder will be disconnected, and the ingestion will stop. This action cannot be undone, and any future playback attempts will fail. 

  By providing the streamId, the API will terminate any active connections to the stream and remove it from the list of available live streams. You can further look for video.live_stream.deleted webhook to notify your system about the status. 

  **Example:** For an online concert platform, a trial stream was mistakenly made public. The event manager deletes the stream before the concert begins to avoid confusion among viewers. 

### Example Usage

```java
package hello.world;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.errors.*;
import io.fastpix.sdk.models.operations.DeleteLiveStreamResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UnauthorizedException, InvalidPermissionException, NotFoundError, ValidationErrorResponse, Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("")
                    .password("")
                    .build())
            .build();

        DeleteLiveStreamResponse res = sdk.manageLiveStream().deleteLiveStream()
                .streamId("8717422d89288ad5958d4a86e9afe2a2")
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
| `streamId`                                                                          | *String*                                                                            | :heavy_check_mark:                                                                  | Upon creating a new live stream, FastPix assigns a unique identifier to the stream. | 8717422d89288ad5958d4a86e9afe2a2                                                    |

### Response

**[DeleteLiveStreamResponse](../../models/operations/DeleteLiveStreamResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UnauthorizedException      | 401                                      | application/json                         |
| models/errors/InvalidPermissionException | 403                                      | application/json                         |
| models/errors/NotFoundError              | 404                                      | application/json                         |
| models/errors/ValidationErrorResponse    | 422                                      | application/json                         |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## updateLiveStream

This endpoint allows users to modify the parameters of an existing live stream, such as its metadata (title, description) or the reconnect window. It’s useful for making changes to a stream that has already been created but not yet ended. Once the live stream is disabled, you cannot update a stream. 


  The updated stream parameters and the streamId needs to be shared in the request, and FastPix will return the updated stream details. Once updated, video.live_stream.updated webhook event notifies your system. 

  **Practical example:** A host realizes they need to extend the reconnect window for their live stream in case they lose connection temporarily during the event. Or suppose during a multi-day online conference, the event organizers need to update the stream title to reflect the next day's session while keeping the same stream ID for continuity. 

### Example Usage

```java
package hello.world;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.PatchLiveStreamRequest;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.errors.*;
import io.fastpix.sdk.models.operations.UpdateLiveStreamResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UnauthorizedException, InvalidPermissionException, NotFoundError, ValidationErrorResponse, Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("")
                    .password("")
                    .build())
            .build();

        UpdateLiveStreamResponse res = sdk.manageLiveStream().updateLiveStream()
                .streamId("91a264dcc447b63da6fb79ef925cd76d")
                .patchLiveStreamRequest(PatchLiveStreamRequest.builder()
                    .build())
                .call();

        if (res.patchResponseDTO().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            | Example                                                                                |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `streamId`                                                                             | *String*                                                                               | :heavy_check_mark:                                                                     | Upon creating a new live stream, FastPix assigns a unique identifier to the stream.    | 91a264dcc447b63da6fb79ef925cd76d                                                       |
| `patchLiveStreamRequest`                                                               | [Optional\<PatchLiveStreamRequest>](../../models/components/PatchLiveStreamRequest.md) | :heavy_minus_sign:                                                                     | N/A                                                                                    | {<br/>"metadata": {<br/>"livestream_name": "Gaming_stream"<br/>},<br/>"reconnectWindow": 100<br/>} |

### Response

**[UpdateLiveStreamResponse](../../models/operations/UpdateLiveStreamResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UnauthorizedException      | 401                                      | application/json                         |
| models/errors/InvalidPermissionException | 403                                      | application/json                         |
| models/errors/NotFoundError              | 404                                      | application/json                         |
| models/errors/ValidationErrorResponse    | 422                                      | application/json                         |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |