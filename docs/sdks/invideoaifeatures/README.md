# InVideoAiFeatures

## Overview

### Available Operations

* [generateNamedEntities](#generatenamedentities) - Generate named entities
* [updateModeration](#updatemoderation) - Enable video moderation

## generateNamedEntities

This endpoint allows you to extract named entities from an existing media.
Named Entity Recognition (NER) is a fundamental natural language processing (NLP) technique that identifies and classifies key information (entities) in text into predefined categories. For instance:

  - Organizations (for example, "Microsoft", "United Nations")
  - Locations (for example, "Paris", "Mount Everest")
  - Product names (for example, "iPhone", "Coca-Cola")

#### How it works
1. Make a PATCH request to this endpoint, replacing `<mediaId>` with the ID of the media you want to extract named-entities.
2. Include the `namedEntities` parameter in the request body to enable.
3. Receive a response containing the updated media data, confirming the changes made.

You can use the <a href="https://docs.fastpix.io/docs/ai-events#videomediaainamedentitiesready">video.mediaAI.named-entities.ready</a> webhook event to track and notify about the named entities extraction.

**Use case:** If a user uploads a video and later decides to enable named entity extraction without re-uploading the entire video.

Related guide: <a href="https://docs.fastpix.io/docs/generate-named-entities">Named entities</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="update-media-named-entities" method="patch" path="/on-demand/{mediaId}/named-entities" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.UpdateMediaNamedEntitiesRequestBody;
import org.openapis.openapi.models.operations.UpdateMediaNamedEntitiesResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateMediaNamedEntitiesResponse res = sdk.inVideoAiFeatures().generateNamedEntities()
                .mediaId("your-media-id")
                .body(UpdateMediaNamedEntitiesRequestBody.builder()
                    .namedEntities(true)
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
| `mediaId`                                                                                             | *String*                                                                                              | :heavy_check_mark:                                                                                    | The unique identifier assigned to the media when created. The value must be a valid UUID.<br/>        | your-media-id                                                                                          |
| `body`                                                                                                | [UpdateMediaNamedEntitiesRequestBody](../../models/operations/UpdateMediaNamedEntitiesRequestBody.md) | :heavy_check_mark:                                                                                    | N/A                                                                                                   | {<br/>"namedEntities": true<br/>}                                                                     |

### Response

**[UpdateMediaNamedEntitiesResponse](../../models/operations/UpdateMediaNamedEntitiesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateModeration

This endpoint enables moderation features, such as NSFW and profanity filtering, to detect inappropriate content in existing media.

#### How it works
1. Make a `PATCH` request to this endpoint, replacing `<mediaId>` with the ID of the media you want to update.
2. Include the `moderation` object and provide the requried `type` parameter in the request body to specify the media type (for example, video/audio/av).
4. The response contains the updated media data, confirming the changes made.

You can use the <a href="https://docs.fastpix.io/docs/ai-events#videomediaaimoderationready">video.mediaAI.moderation.ready</a> webhook event to track and notify about the detected moderation results.

**Use case:** This is particularly useful when a user uploads a video and later decides to enable moderation detection without the need to re-upload it.

Related guide: <a href="https://docs.fastpix.io/docs/using-nsfw-and-profanity-filter-for-video-moderation">Moderate NSFW & Profanity</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="update-media-moderation" method="patch" path="/on-demand/{mediaId}/moderation" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.MediaType;
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

        UpdateMediaModerationResponse res = sdk.inVideoAiFeatures().updateModeration()
                .mediaId("your-media-id")
                .body(UpdateMediaModerationRequestBody.builder()
                    .moderation(UpdateMediaModerationModeration.builder()
                        .type(MediaType.VIDEO)
                        .build())
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                       | Type                                                                                            | Required                                                                                        | Description                                                                                     | Example                                                                                         |
| ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| `mediaId`                                                                                       | *String*                                                                                        | :heavy_check_mark:                                                                              | The unique identifier assigned to the media when created. The value must be a valid UUID.<br/>  | your-media-id                                                                                |
| `body`                                                                                          | [UpdateMediaModerationRequestBody](../../models/operations/UpdateMediaModerationRequestBody.md) | :heavy_check_mark:                                                                              | N/A                                                                                             | {<br/>"moderation": {<br/>"type": "video"<br/>}<br/>}                                           |

### Response

**[UpdateMediaModerationResponse](../../models/operations/UpdateMediaModerationResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |