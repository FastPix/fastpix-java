# LivePlayback

## Overview

### Available Operations

* [createPlaybackId](#createplaybackid) - Create a playbackId
* [deletePlaybackId](#deleteplaybackid) - Delete a playbackId
* [updateDomainRestrictions](#updatedomainrestrictions) - Update domain restrictions for a live playback ID
* [updateUserAgentRestrictions](#updateuseragentrestrictions) - Update user-agent restrictions for a live playback ID

## createPlaybackId

Generates a new playback ID for the live stream, allowing viewers to access the stream through this ID. The playback ID can be shared with viewers for direct access to the live broadcast. 

  By calling this endpoint with the `streamId`, FastPix returns a unique `playbackId`, which can be used to stream the live content. 

  #### Example

  A media platform needs to distribute a unique playback ID to users for an exclusive live concert. The platform can also embed the stream on various partner websites.

> **Note:** In the examples below, `package hello.world;` is used for demonstration purposes. When creating your own Java files, ensure the package name matches your directory structure (e.g., if your file is at `src/main/java/com/example/MyApp.java`, use `package com.example;`).

### Example Usage

<!-- UsageSnippet language="java" operationID="create-playbackId-of-stream" method="post" path="/live/streams/{streamId}/playback-ids" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.List;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.PlaybackIdAccessRestrictions;
import io.fastpix.sdk.models.components.PlaybackIdDomains;
import io.fastpix.sdk.models.components.PlaybackIdRequest;
import io.fastpix.sdk.models.components.PolicyAction;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.CreatePlaybackIdOfStreamResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        CreatePlaybackIdOfStreamResponse res = sdk.livePlayback().createPlaybackId()
                .streamId("your-stream-id")
                .body(PlaybackIdRequest.builder()
                    .accessRestrictions(PlaybackIdAccessRestrictions.builder()
                        .domains(PlaybackIdDomains.builder()
                            .defaultPolicy(PolicyAction.DENY)
                            .allow(List.of("example.com"))
                            .build())
                        .build())
                    .build())
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
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.DeletePlaybackIdOfStreamResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
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
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.liveStreamDeleteResponse().get()));
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

## updateDomainRestrictions

This endpoint updates domain-level restrictions for a specific playback ID associated with a live stream.
It allows you to restrict playback to specific domains or block known unauthorized domains.

**How it works:**
1. Make a `PATCH` request to this endpoint with your desired domain access configuration.
2. Set a default policy (`allow` or `deny`) and specify domain names in the `allow` or `deny` lists.
3. This is commonly used to restrict video playback to your website or approved client domains.

**Example:**
A streaming service can allow playback only from `example.com` and deny all others by setting: `"defaultPolicy": "deny"` and `"allow": ["example.com"]`.


### Example Usage

<!-- UsageSnippet language="java" operationID="update-live-stream-domain-restrictions" method="patch" path="/live/streams/{streamId}/playback-ids/{playbackId}/domains" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.List;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateLiveStreamDomainRestrictionsResponse res = sdk.livePlayback().updateDomainRestrictions()
                .streamId("your-stream-id")
                .playbackId("your-playback-id")
                .body(UpdateLiveStreamDomainRestrictionsRequestBody.builder()
                    .allow(List.of(
                        "yourdomain.com",
                        "sampledomain.com"))
                    .deny(List.of(
                        "yourworkdomain.com"))
                    .build())
                .call();

        if (res.object().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.object().get()));
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           | Example                                                                                               |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `streamId`                                                                                             | *String*                                                                                              | :heavy_check_mark:                                                                                    | N/A                                                                                                   | your-stream-id                                                                                         |
| `playbackId`                                                                                          | *String*                                                                                              | :heavy_check_mark:                                                                                    | N/A                                                                                                   | your-playback-id                                                                                      |
| `body`                                                                                                | [UpdateLiveStreamDomainRestrictionsRequestBody](../../models/operations/UpdateLiveStreamDomainRestrictionsRequestBody.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |                                                                                                       |

### Response

**[UpdateLiveStreamDomainRestrictionsResponse](../../models/operations/UpdateLiveStreamDomainRestrictionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateUserAgentRestrictions

This endpoint allows updating user-agent restrictions for a specific playback ID associated with a live stream. 
It can be used to allow or deny specific user-agents during playback request evaluation.

**How it works:**
1. Make a `PATCH` request to this endpoint with your desired user-agent access configuration.
2. Specify a default policy (`allow` or `deny`) and provide specific `allow` or `deny` lists.
3. Use this to restrict access to specific browsers, devices, or bots.

**Example:**
A developer may configure a playback ID to deny access from known scraping user-agents while allowing all others by default.


### Example Usage

<!-- UsageSnippet language="java" operationID="update-live-stream-user-agent-restrictions" method="patch" path="/live/streams/{streamId}/playback-ids/{playbackId}/user-agents" -->
```java
// Package declaration - adjust to match your project's directory structure
package hello.world;

// Import required classes from the FastPix SDK
import java.lang.Exception;
import java.util.List;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsResponse;
import io.fastpix.sdk.utils.JSON;

public class Application {

    public static void main(String[] args) throws Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateLiveStreamUserAgentRestrictionsResponse res = sdk.livePlayback().updateUserAgentRestrictions()
                .streamId("your-stream-id")
                .playbackId("your-playback-id")
                .body(UpdateLiveStreamUserAgentRestrictionsRequestBody.builder()
                    .allow(List.of(
                        "Mozilla/55.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36"))
                    .deny(List.of(
                        "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/53745.36 (KHTML, like Gecko) Chrome/138.0.0.0 Mobile Safari/537.36"))
                    .build())
                .call();

        if (res.object().isPresent()) {
            var mapper = JSON.getMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(res.object().get()));
        }
    }
}
```

### Parameters

| Parameter                                                                                                   | Type                                                                                                        | Required                                                                                                    | Description                                                                                                 | Example                                                                                                     |
| ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `streamId`                                                                                                   | *String*                                                                                                    | :heavy_check_mark:                                                                                          | N/A                                                                                                         | your-stream-id                                                                                               |
| `playbackId`                                                                                                | *String*                                                                                                    | :heavy_check_mark:                                                                                          | N/A                                                                                                         | your-playback-id                                                                                             |
| `body`                                                                                                      | [UpdateLiveStreamUserAgentRestrictionsRequestBody](../../models/operations/UpdateLiveStreamUserAgentRestrictionsRequestBody.md) | :heavy_check_mark:                                                                                          | N/A                                                                                                         |                                                                                                             |

### Response

**[UpdateLiveStreamUserAgentRestrictionsResponse](../../models/operations/UpdateLiveStreamUserAgentRestrictionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |
