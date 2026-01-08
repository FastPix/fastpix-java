# Playback

## Overview

Operations for video playback management

### Available Operations

* [createId](#createid) - Create a playback ID
* [list](#list) - Get all playback IDs details for a media
* [deleteId](#deleteid) - Delete a playback ID
* [get](#get) - Get a playback ID
* [updateDomainRestrictions](#updatedomainrestrictions) - Update domain restrictions for a playback ID
* [updateUserAgentRestrictions](#updateuseragentrestrictions) - Update user-agent restrictions for a playback ID

## createId

You can create a new playback ID for a specific media asset. If you have already retrieved an existing `playbackId` using the <a href="https://docs.fastpix.io/reference/get-media">Get Media by ID</a> endpoint for a media asset, you can use this endpoint to generate a new playback ID with a specified access policy. 



If you want to create a private playback ID for a media asset that already has a public playback ID, this endpoint also allows you to do so by specifying the desired access policy. 

#### How it works

1. Make a `POST` request to this endpoint, replacing `<mediaId>` with the `uploadId` or `id` of the media asset. 

2. Include the `accessPolicy` in the request body with `private` or `public` as the value. 

3. You receive a response containing the newly created playback ID with the specified access level.


#### Example
A video streaming service generates playback IDs for each media file when users request to view specific content. The video player then uses the playback ID to stream the video.


### Example Usage

<!-- UsageSnippet language="java" operationID="create-media-playback-id" method="post" path="/on-demand/{mediaId}/playback-ids" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.AccessPolicy;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.*;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        CreateMediaPlaybackIdResponse res = sdk.playback().createId()
                .mediaId("your-media-id")
                .body(CreateMediaPlaybackIdRequestBody.builder()
                    .accessPolicy(AccessPolicy.PUBLIC)
                    .drmConfigurationId("your-drm-configuration-id")
                    .resolution(Resolution.ONE_THOUSAND_AND_EIGHTYP)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                  | Type                                                                                                       | Required                                                                                                   | Description                                                                                                | Example                                                                                                    |
| ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `mediaId`                                                                                                  | *String*                                                                                                   | :heavy_check_mark:                                                                                         | The unique identifier assigned to the media when created. The value must be a valid UUID.                  | your-media-id                                                                                               |
| `body`                                                                                                     | [Optional\<CreateMediaPlaybackIdRequestBody>](../../models/operations/CreateMediaPlaybackIdRequestBody.md) | :heavy_minus_sign:                                                                                         | Request body for creating playback id for an media                                                         |                                                                                                            |

### Response

**[CreateMediaPlaybackIdResponse](../../models/operations/CreateMediaPlaybackIdResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## list

Retrieves all playback IDs associated with a given media asset, including each playback ID’s access policy and detailed access restrictions such as allowed or denied domains and user agents.

**How it works:**
1. Send a `GET` request to this endpoint with the target `mediaId`.
2. The response includes an array of playback ID records with their respective access controls.

**Use case:**
Useful for validating and managing playback permissions programmatically, reviewing restriction settings, or powering an access control dashboard.


### Example Usage

<!-- UsageSnippet language="java" operationID="list-playback-ids" method="get" path="/on-demand/{mediaId}/playback-ids" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.ListPlaybackIdsResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        ListPlaybackIdsResponse res = sdk.playback().list()
                .mediaId("your-media-id")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                            | Type                                 | Required                             | Description                          | Example                              |
| ------------------------------------ | ------------------------------------ | ------------------------------------ | ------------------------------------ | ------------------------------------ |
| `mediaId`                            | *String*                             | :heavy_check_mark:                   | N/A                                  | your-media-id                        |

### Response

**[ListPlaybackIdsResponse](../../models/operations/ListPlaybackIdsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteId

This endpoint deletes a specific playback ID associated with a media asset. Deleting a `playback ID` revokes access to the media content linked to that ID.


#### How it works

1. Make a `DELETE` request to this endpoint, replacing `<mediaId>` with the unique ID of the media asset from which you want to delete the playback ID. 

2. Include the `playbackId` you want to delete in the request body.

#### Example

Your platform offers limited-time access to premium content. When the subscription expires, you can revoke access to the content by deleting the associated playback ID, preventing users from streaming the video further.


### Example Usage

<!-- UsageSnippet language="java" operationID="delete-media-playback-id" method="delete" path="/on-demand/{mediaId}/playback-ids" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.DeleteMediaPlaybackIdResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        DeleteMediaPlaybackIdResponse res = sdk.playback().deleteId()
                .mediaId("your-media-id")
                .playbackId("your-playback-id")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           | Example                                                                                               |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `mediaId`                                                                                             | *String*                                                                                              | :heavy_check_mark:                                                                                    | The unique identifier assigned to the media when created. The value must be a valid UUID.             | your-media-id                                                                                         |
| `playbackId`                                                                                          | *String*                                                                                              | :heavy_check_mark:                                                                                    | Return the universal unique identifier for playbacks  which can contain a maximum of 255 characters.  | your-playback-id                                                                                      |

### Response

**[DeleteMediaPlaybackIdResponse](../../models/operations/DeleteMediaPlaybackIdResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## get

This endpoint retrieves details about a specific playback ID associated with a media asset. Use it to check the access policy for that specific playback ID, such as whether it is public or private.

**How it works:**
1. Make a GET request to the endpoint, replacing `{mediaId}` with the media ID and `{playbackId}` with the playback ID.
2. This request is useful for auditing or validation before granting playback access in your application.

**Example:**
A media platform might use this endpoint to verify if a playback ID is public or private before embedding the video in a frontend player or allowing access to a restricted group.


### Example Usage

<!-- UsageSnippet language="java" operationID="get-playback-id" method="get" path="/on-demand/{mediaId}/playback-ids/{playbackId}" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.GetPlaybackIdResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetPlaybackIdResponse res = sdk.playback().get()
                .mediaId("your-media-id")
                .playbackId("your-playback-id")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                            | Type                                 | Required                             | Description                          | Example                              |
| ------------------------------------ | ------------------------------------ | ------------------------------------ | ------------------------------------ | ------------------------------------ |
| `mediaId`                            | *String*                             | :heavy_check_mark:                   | N/A                                  | your-media-id                        |
| `playbackId`                         | *String*                             | :heavy_check_mark:                   | N/A                                  | your-playback-id                     |

### Response

**[GetPlaybackIdResponse](../../models/operations/GetPlaybackIdResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateDomainRestrictions

This endpoint updates domain-level restrictions for a specific playback ID associated with a media asset.
It allows you to restrict playback to specific domains or block known unauthorized domains.

**How it works:**
1. Make a `PATCH` request to this endpoint with your desired domain access configuration.
2. Set a default policy (`allow` or `deny`) and specify domain names in the `allow` or `deny` lists.
3. This is commonly used to restrict video playback to your website or approved client domains.

**Example:**
A streaming service can allow playback only from `example.com` and deny all others by setting: `"defaultPolicy": "deny"` and `"allow": ["example.com"]`.


### Example Usage

<!-- UsageSnippet language="java" operationID="update-domain-restrictions" method="patch" path="/on-demand/{mediaId}/playback-ids/{playbackId}/domains" -->
```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.UpdateDomainRestrictionsRequestBody;
import org.openapis.openapi.models.operations.UpdateDomainRestrictionsResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateDomainRestrictionsResponse res = sdk.playback().updateDomainRestrictions()
                .mediaId("your-media-id")
                .playbackId("your-playback-id")
                .body(UpdateDomainRestrictionsRequestBody.builder()
                    .allow(List.of(
                        "yourdomain.com",
                        "sampledomain.com"))
                    .deny(List.of(
                        "yourworkdomain.com"))
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           | Example                                                                                               |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `mediaId`                                                                                             | *String*                                                                                              | :heavy_check_mark:                                                                                    | N/A                                                                                                   | your-media-id                                                                                         |
| `playbackId`                                                                                          | *String*                                                                                              | :heavy_check_mark:                                                                                    | N/A                                                                                                   | your-playback-id                                                                                      |
| `body`                                                                                                | [UpdateDomainRestrictionsRequestBody](../../models/operations/UpdateDomainRestrictionsRequestBody.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   |                                                                                                       |

### Response

**[UpdateDomainRestrictionsResponse](../../models/operations/UpdateDomainRestrictionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateUserAgentRestrictions

This endpoint allows updating user-agent restrictions for a specific playback ID associated with a media asset. 
It can be used to allow or deny specific user-agents during playback request evaluation.

**How it works:**
1. Make a `PATCH` request to this endpoint with your desired user-agent access configuration.
2. Specify a default policy (`allow` or `deny`) and provide specific `allow` or `deny` lists.
3. Use this to restrict access to specific browsers, devices, or bots.

**Example:**
A developer may configure a playback ID to deny access from known scraping user-agents while allowing all others by default.


### Example Usage

<!-- UsageSnippet language="java" operationID="update-user-agent-restrictions" method="patch" path="/on-demand/{mediaId}/playback-ids/{playbackId}/user-agents" -->
```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.UpdateUserAgentRestrictionsRequestBody;
import org.openapis.openapi.models.operations.UpdateUserAgentRestrictionsResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateUserAgentRestrictionsResponse res = sdk.playback().updateUserAgentRestrictions()
                .mediaId("your-media-id")
                .playbackId("your-playback-id")
                .body(UpdateUserAgentRestrictionsRequestBody.builder()
                    .allow(List.of(
                        "Mozilla/55.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36"))
                    .deny(List.of(
                        "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/53745.36 (KHTML, like Gecko) Chrome/138.0.0.0 Mobile Safari/537.36"))
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                   | Type                                                                                                        | Required                                                                                                    | Description                                                                                                 | Example                                                                                                     |
| ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `mediaId`                                                                                                   | *String*                                                                                                    | :heavy_check_mark:                                                                                          | N/A                                                                                                         | your-media-id                                                                                               |
| `playbackId`                                                                                                | *String*                                                                                                    | :heavy_check_mark:                                                                                          | N/A                                                                                                         | your-playback-id                                                                                             |
| `body`                                                                                                      | [UpdateUserAgentRestrictionsRequestBody](../../models/operations/UpdateUserAgentRestrictionsRequestBody.md) | :heavy_check_mark:                                                                                          | N/A                                                                                                         |                                                                                                             |

### Response

**[UpdateUserAgentRestrictionsResponse](../../models/operations/UpdateUserAgentRestrictionsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |