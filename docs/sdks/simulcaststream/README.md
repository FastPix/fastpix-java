# SimulcastStream
(*simulcastStream()*)

## Overview

### Available Operations

* [createSimulcastOfStream](#createsimulcastofstream) - Create a simulcast
* [deleteSimulcastOfStream](#deletesimulcastofstream) - Delete a simulcast
* [getSpecificSimulcastOfStream](#getspecificsimulcastofstream) - Get a specific simulcast of a stream
* [updateSpecificSimulcastOfStream](#updatespecificsimulcastofstream) - Update a specific simulcast of a stream

## createSimulcastOfStream

Lets you to create a simulcast for a parent live stream. A simulcast enables you to broadcast the live stream to multiple platforms simultaneously (e.g., YouTube, Facebook, or Twitch). This feature is useful for expanding your audience reach across different platforms. However, a simulcast can only be created when the parent live stream is in an idle state (i.e., not currently live or disabled). Additionally, only one simulcast target can be created per API call. 

  <h4>How it works</h4> 


  Upon calling this endpoint, you need to provide the parent streamId and the details of the simulcast target (platform and credentials). The system will generate a unique simulcastId, which can be used to manage the simulcast later. 



To notify your application about the status of simulcast related events check for the webhooks for simulcast target events. 

**Practical example:** An event manager sets up a live stream for a virtual conference and wants to simulcast the stream on YouTube and Facebook Live. They first create the primary live stream in FastPix, ensuring it's in the idle state. Then, they use the API to create a simulcast target for YouTube. 

### Example Usage

```java
package hello.world;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.SimulcastRequest;
import io.fastpix.sdk.models.errors.*;
import io.fastpix.sdk.models.operations.CreateSimulcastOfStreamResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws SimulcastUnavailableException, UnauthorizedException, InvalidPermissionException, NotFoundError, ValidationErrorResponse, Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("")
                    .password("")
                    .build())
            .build();

        CreateSimulcastOfStreamResponse res = sdk.simulcastStream().createSimulcastOfStream()
                .streamId("8717422d89288ad5958d4a86e9afe2a2")
                .simulcastRequest(SimulcastRequest.builder()
                    .url("rtmp://hyd01.contribute.live-video.net/app/")
                    .streamKey("live_1012464221_DuM8W004MoZYNxQEZ0czODgfHCFBhk")
                    .build())
                .call();

        if (res.simulcastResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                         | Type                                                                                                                                                                              | Required                                                                                                                                                                          | Description                                                                                                                                                                       | Example                                                                                                                                                                           |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `streamId`                                                                                                                                                                        | *String*                                                                                                                                                                          | :heavy_check_mark:                                                                                                                                                                | Upon creating a new live stream, FastPix assigns a unique identifier to the stream.                                                                                               | 8717422d89288ad5958d4a86e9afe2a2                                                                                                                                                  |
| `simulcastRequest`                                                                                                                                                                | [Optional\<SimulcastRequest>](../../models/components/SimulcastRequest.md)                                                                                                        | :heavy_minus_sign:                                                                                                                                                                | N/A                                                                                                                                                                               | {<br/>"url": "rtmp://hyd01.contribute.live-video.net/app/",<br/>"streamKey": "live_1012464221_DuM8W004MoZYNxQEZ0czODgfHCFBhk",<br/>"metadata": {<br/>"livestream_name": "Tech-Connect Summit"<br/>}<br/>} |

### Response

**[CreateSimulcastOfStreamResponse](../../models/operations/CreateSimulcastOfStreamResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/SimulcastUnavailableException | 400                                         | application/json                            |
| models/errors/UnauthorizedException         | 401                                         | application/json                            |
| models/errors/InvalidPermissionException    | 403                                         | application/json                            |
| models/errors/NotFoundError                 | 404                                         | application/json                            |
| models/errors/ValidationErrorResponse       | 422                                         | application/json                            |
| models/errors/APIException                  | 4XX, 5XX                                    | \*/\*                                       |

## deleteSimulcastOfStream

Allows you to delete a simulcast using its unique simulcastId, which was returned during the simulcast creation process. Deleting a simulcast stops the broadcast to the associated platform, but the parent stream will continue to run if it is live. This action is irreversible, and a new simulcast would need to be created if you want to resume streaming to the same platform. 

  **Use case:** A broadcaster needs to stop simulcasting to one platform due to technical difficulties while keeping the stream active on others. For example, a tech company is simulcasting a product launch on multiple platforms. Midway through the event, they decide to stop the simulcast on Facebook due to performance issues, but keep it running on YouTube. They call this API to delete the Facebook simulcast target. 

### Example Usage

```java
package hello.world;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.errors.*;
import io.fastpix.sdk.models.operations.DeleteSimulcastOfStreamResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UnauthorizedException, InvalidPermissionException, NotFoundErrorSimulcast, ValidationErrorResponse, Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("")
                    .password("")
                    .build())
            .build();

        DeleteSimulcastOfStreamResponse res = sdk.simulcastStream().deleteSimulcastOfStream()
                .streamId("8717422d89288ad5958d4a86e9afe2a2")
                .simulcastId("9217422d89288ad5958d4a86e9afe2a1")
                .call();

        if (res.simulcastdeleteResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                      | Type                                                                                                                           | Required                                                                                                                       | Description                                                                                                                    | Example                                                                                                                        |
| ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ |
| `streamId`                                                                                                                     | *String*                                                                                                                       | :heavy_check_mark:                                                                                                             | Upon creating a new live stream, FastPix assigns a unique identifier to the stream.                                            | 8717422d89288ad5958d4a86e9afe2a2                                                                                               |
| `simulcastId`                                                                                                                  | *String*                                                                                                                       | :heavy_check_mark:                                                                                                             | When you create the new simulcast, FastPix assign a universal unique identifier which can contain a maximum of 255 characters. | 9217422d89288ad5958d4a86e9afe2a1                                                                                               |

### Response

**[DeleteSimulcastOfStreamResponse](../../models/operations/DeleteSimulcastOfStreamResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UnauthorizedException      | 401                                      | application/json                         |
| models/errors/InvalidPermissionException | 403                                      | application/json                         |
| models/errors/NotFoundErrorSimulcast     | 404                                      | application/json                         |
| models/errors/ValidationErrorResponse    | 422                                      | application/json                         |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## getSpecificSimulcastOfStream

Retrieves the details of a specific simulcast associated with a parent live stream. By providing both the streamId of the parent stream and the simulcastId, FastPix returns detailed information about the simulcast, such as the stream URL, the status of the simulcast (active or idle), and metadata. 

  **Use case:** This endpoint can be used to verify the status of the simulcast on external platforms before the live stream begins. For instance, before starting a live gaming event, the organizer wants to ensure that the simulcast to Twitch is set up correctly. They retrieve the simulcast information to confirm that everything is properly configured. 

### Example Usage

```java
package hello.world;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.errors.*;
import io.fastpix.sdk.models.operations.GetSpecificSimulcastOfStreamResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UnauthorizedException, InvalidPermissionException, NotFoundErrorSimulcast, ValidationErrorResponse, Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("")
                    .password("")
                    .build())
            .build();

        GetSpecificSimulcastOfStreamResponse res = sdk.simulcastStream().getSpecificSimulcastOfStream()
                .streamId("8717422d89288ad5958d4a86e9afe2a2")
                .simulcastId("8717422d89288ad5958d4a86e9afe2a2")
                .call();

        if (res.simulcastResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                      | Type                                                                                                                           | Required                                                                                                                       | Description                                                                                                                    | Example                                                                                                                        |
| ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ |
| `streamId`                                                                                                                     | *String*                                                                                                                       | :heavy_check_mark:                                                                                                             | Upon creating a new live stream, FastPix assigns a unique identifier to the stream.                                            | 8717422d89288ad5958d4a86e9afe2a2                                                                                               |
| `simulcastId`                                                                                                                  | *String*                                                                                                                       | :heavy_check_mark:                                                                                                             | When you create the new simulcast, FastPix assign a universal unique identifier which can contain a maximum of 255 characters. | 8717422d89288ad5958d4a86e9afe2a2                                                                                               |

### Response

**[GetSpecificSimulcastOfStreamResponse](../../models/operations/GetSpecificSimulcastOfStreamResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UnauthorizedException      | 401                                      | application/json                         |
| models/errors/InvalidPermissionException | 403                                      | application/json                         |
| models/errors/NotFoundErrorSimulcast     | 404                                      | application/json                         |
| models/errors/ValidationErrorResponse    | 422                                      | application/json                         |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## updateSpecificSimulcastOfStream

Allows you to enable or disable a specific simulcast associated with a parent live stream. The status of the simulcast can be updated at any point, whether the live stream is active or idle. However, once the live stream is disabled, the simulcast can no longer be modified. 

  **Use case:** When a PATCH request is made to this endpoint, the API updates the status of the simulcast. This can be useful for pausing or resuming a simulcast on a particular platform without stopping the parent live stream. 

### Example Usage

```java
package hello.world;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.SimulcastUpdateRequest;
import io.fastpix.sdk.models.errors.*;
import io.fastpix.sdk.models.operations.UpdateSpecificSimulcastOfStreamResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UnauthorizedException, InvalidPermissionException, NotFoundErrorSimulcast, ValidationErrorResponse, Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("")
                    .password("")
                    .build())
            .build();

        UpdateSpecificSimulcastOfStreamResponse res = sdk.simulcastStream().updateSpecificSimulcastOfStream()
                .streamId("8717422d89288ad5958d4a86e9afe2a2")
                .simulcastId("8717422d89288ad5958d4a86e9afe2a2")
                .simulcastUpdateRequest(SimulcastUpdateRequest.builder()
                    .isEnabled(false)
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
| `streamId`                                                                                                                     | *String*                                                                                                                       | :heavy_check_mark:                                                                                                             | Upon creating a new live stream, FastPix assigns a unique identifier to the stream.                                            | 8717422d89288ad5958d4a86e9afe2a2                                                                                               |
| `simulcastId`                                                                                                                  | *String*                                                                                                                       | :heavy_check_mark:                                                                                                             | When you create the new simulcast, FastPix assign a universal unique identifier which can contain a maximum of 255 characters. | 8717422d89288ad5958d4a86e9afe2a2                                                                                               |
| `simulcastUpdateRequest`                                                                                                       | [Optional\<SimulcastUpdateRequest>](../../models/components/SimulcastUpdateRequest.md)                                         | :heavy_minus_sign:                                                                                                             | N/A                                                                                                                            | {<br/>"isEnabled": false,<br/>"metadata": {<br/>"simulcast_name": "Tech today"<br/>}<br/>}                                     |

### Response

**[UpdateSpecificSimulcastOfStreamResponse](../../models/operations/UpdateSpecificSimulcastOfStreamResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UnauthorizedException      | 401                                      | application/json                         |
| models/errors/InvalidPermissionException | 403                                      | application/json                         |
| models/errors/NotFoundErrorSimulcast     | 404                                      | application/json                         |
| models/errors/ValidationErrorResponse    | 422                                      | application/json                         |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |