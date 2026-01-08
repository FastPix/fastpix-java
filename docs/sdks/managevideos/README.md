# ManageVideos

## Overview

### Available Operations

* [list](#list) - Get list of all media
* [get](#get) - Get a media by ID
* [addTrack](#addtrack) - Add audio / subtitle track
* [deleteTrack](#deletetrack) - Delete audio / subtitle track
* [generateSubtitles](#generatesubtitles) - Generate track subtitle
* [getSummary](#getsummary) - Get the summary of a video
* [updateSourceAccess](#updatesourceaccess) - Update the source access of a media by ID
* [getInputInfo](#getinputinfo) - Get info of media inputs

## list

This endpoint returns a list of all media files uploaded to FastPix within a specific workspace. Each media entry contains data such as the media `id`, `createdAt`, `status`, `type` and more. It allows you to retrieve an overview of your media assets, making it easier to manage and review them. 


#### How it works

Use the access token and secret key related to the workspace in the request header. When called, the API provides a paginated response containing all the media items in that specific workspace. This is helpful for retrieving a large volume of media and managing content in bulk. 



#### Example
If you manage a video platform and need to review all uploaded media in your library to ensure that outdated or low-quality content isn’t being served, you can use this endpoint to retrieve a complete list of media. You can then filter, sort, or update items as needed.


### Example Usage

<!-- UsageSnippet language="java" operationID="list-media" method="get" path="/on-demand" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.components.SortOrder;
import org.openapis.openapi.models.operations.ListMediaResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        ListMediaResponse res = sdk.manageVideos().list()
                .limit(20L)
                .offset(1L)
                .orderBy(SortOrder.DESC)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               | Example                                                                                   |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `limit`                                                                                   | *Optional\<Long>*                                                                         | :heavy_minus_sign:                                                                        | Limit specifies the maximum number of items to display per page.                          | 20                                                                                        |
| `offset`                                                                                  | *Optional\<Long>*                                                                         | :heavy_minus_sign:                                                                        | Offset determines the starting point for data retrieval within a paginated list.          | 1                                                                                         |
| `orderBy`                                                                                 | [Optional\<SortOrder>](../../models/components/SortOrder.md)                              | :heavy_minus_sign:                                                                        | The values in the list can be arranged in two ways: DESC (Descending) or ASC (Ascending). | desc                                                                                      |

### Response

**[ListMediaResponse](../../models/operations/ListMediaResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## get

By calling this endpoint, you can retrieve detailed information about a specific media item, including its current `status` and a `playbackId`. This is particularly useful for retrieving specific media details when managing large content libraries. 



#### How it works

1. Send a GET request to this endpoint. Use the `<mediaId>` you received after uploading the media file.

2. The response includes details about the media:
   - **status** – Indicates whether the media is still *Processing* or has transitioned to *Ready*.
   - **playbackId** – A unique identifier that allows you to stream the media once it is *Ready*.  
     You can construct the stream URL as follows:  
     `https://stream.fastpix.io/<playbackId>.m3u8`

#### Example

If your platform provides users with a dashboard to manage uploaded content, a user might want to check whether a video has finished processing and is ready for playback. You can use the media ID to retrieve the information from FastPix and display it in the user’s dashboard.


### Example Usage

<!-- UsageSnippet language="java" operationID="get-media" method="get" path="/on-demand/{mediaId}" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.GetMediaResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetMediaResponse res = sdk.manageVideos().get()
                .mediaId("your-media-id")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               | Example                                                                                   |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `mediaId`                                                                                 | *String*                                                                                  | :heavy_check_mark:                                                                        | The unique identifier assigned to the media when created. The value must be a valid UUID. | your-media-id                                                                             |

### Response

**[GetMediaResponse](../../models/operations/GetMediaResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## addTrack

This endpoint allows you to add an audio or subtitle track to an existing media file using its `mediaId`. You need to provide the track `url` along with its `type` (audio or subtitle), `languageName` and `languageCode` in the request payload.


#### How it works

1. Send a POST request to this endpoint, replacing `{mediaId}` with the media ID (`uploadId` or `id`).

2. Provide the necessary details in the request body.

3. Receive a response containing a unique track ID and the details of the newly added track.


#### Webhook events

1. After successfully adding a track, your system must receive the webhook event <a href="https://docs.fastpix.io/docs/transform-media-events#videomediatrackcreated">video.media.track.created</a>.

2. Once the track is processed and ready, you must receive the webhook event <a href="https://docs.fastpix.io/docs/transform-media-events#videomediatrackready">video.media.track.ready</a>.

3. Finally, an update event <a href="https://docs.fastpix.io/docs/media-events#videomediaupdated">video.media.updated</a> must notify your system about the media's updated status.


#### Example
Suppose you have a video uploaded to the FastPix platform, and you want to add an Italian audio track to it. By calling this API, you can attach an external audio file (https://static.fastpix.io/music-1.mp3) to the media file. Similarly, if you need to add subtitles in different languages, you can specify type: `subtitle` with the corresponding subtitle `url`, `languageCode` and `languageName`.

Related guides: <a href="https://docs.fastpix.io/docs/manage-subtitle-tracks">Add own subtitle tracks</a>, <a href="https://docs.fastpix.io/docs/manage-audio-tracks">Add own audio tracks</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="Add-media-track" method="post" path="/on-demand/{mediaId}/tracks" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.AddTrackRequest;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.AddMediaTrackRequestBody;
import org.openapis.openapi.models.operations.AddMediaTrackResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        AddMediaTrackResponse res = sdk.manageVideos().addTrack()
                .mediaId("your-media-id")
                .body(AddMediaTrackRequestBody.builder()
                    .tracks(AddTrackRequest.builder()
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

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               | Example                                                                                   |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `mediaId`                                                                                 | *String*                                                                                  | :heavy_check_mark:                                                                        | The unique identifier assigned to the media when created. The value must be a valid UUID. | your-media-id                                                                             |
| `body`                                                                                    | [AddMediaTrackRequestBody](../../models/operations/AddMediaTrackRequestBody.md)           | :heavy_check_mark:                                                                        | N/A                                                                                       |                                                                                           |

### Response

**[AddMediaTrackResponse](../../models/operations/AddMediaTrackResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteTrack

This endpoint allows you to delete an existing audio or subtitle track from a media file. Once deleted, the track must no longer be available for playback.


#### How it works


1. Send a DELETE request to this endpoint, replacing `{mediaId}` with the media ID, and `{trackId}` with the ID of the track you want to remove.

2. The track gets deleted from the media file, and you must receive a confirmation response.

#### Webhook events

1. After successfully deleting a track, your system must receive the webhook event **video.media.track.deleted**.

2. Once the media file is updated to reflect the track removal, a <a href="https://docs.fastpix.io/docs/media-events#videomediaupdated">video.media.updated</a> event must be triggered.


#### Example
Suppose you uploaded an audio track in Italian for a video but later realize it's incorrect or no longer needed. By calling this API, you can remove the specific track while keeping the rest of the media file unchanged. This is useful when:

  - A track was mistakenly added and needs to be removed.
  - The content owner requests the removal of a specific subtitle or audio track.
  - A new version of the track gets uploaded to replace the existing one.

Related guides: <a href="https://docs.fastpix.io/docs/manage-subtitle-tracks">Add own subtitle tracks</a>, <a href="https://docs.fastpix.io/docs/manage-audio-tracks">Add own audio tracks</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="delete-media-track" method="delete" path="/on-demand/{mediaId}/tracks/{trackId}" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.DeleteMediaTrackResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        DeleteMediaTrackResponse res = sdk.manageVideos().deleteTrack()
                .mediaId("your-media-id")
                .trackId("your-track-id")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               | Example                                                                                   |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `mediaId`                                                                                 | *String*                                                                                  | :heavy_check_mark:                                                                        | The unique identifier assigned to the media when created. The value must be a valid UUID. | your-media-id                                                                             |
| `trackId`                                                                                 | *String*                                                                                  | :heavy_check_mark:                                                                        | The unique identifier assigned to the media when created. The value must be a valid UUID. | your-track-id                                                                             |

### Response

**[DeleteMediaTrackResponse](../../models/operations/DeleteMediaTrackResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## generateSubtitles

This endpoint allows you to generate subtitles for an existing audio track in a media file. By calling this API, you can generate subtitles automatically using speech recognition

#### How it works

1. Send a `POST` request to this endpoint, replacing `{mediaId}` with the media ID and `{trackId}` with the track ID.

2. Provide the necessary details in the request body, including the languageName and languageCode.

3. You receive a response containing a unique subtitle track ID and its details.

#### Webhook Events

1. After the subtitle track is generated and ready, you receive the webhook event <a href="https://docs.fastpix.io/docs/transform-media-events#videomediasubtitlegeneratedready">video.media.subtitle.generated.ready</a>.

2. Finally the <a href="https://docs.fastpix.io/docs/media-events#videomediaupdated">video.media.updated</a> event notifies your system about the media’s updated status.

</br> Related guide: <a href="https://docs.fastpix.io/docs/add-auto-generated-subtitles-to-videos">Add auto-generated subtitles</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="Generate-subtitle-track" method="post" path="/on-demand/{mediaId}/tracks/{trackId}/generate-subtitles" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.components.TrackSubtitlesGenerateRequest;
import org.openapis.openapi.models.operations.GenerateSubtitleTrackResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GenerateSubtitleTrackResponse res = sdk.manageVideos().generateSubtitles()
                .mediaId("your-media-id")
                .trackId("your-track-id")
                .body(TrackSubtitlesGenerateRequest.builder()
                    .languageName("Italian")
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                    | Type                                                                                                         | Required                                                                                                     | Description                                                                                                  | Example                                                                                                      |
| ------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------ |
| `mediaId`                                                                                                    | *String*                                                                                                     | :heavy_check_mark:                                                                                           | The unique identifier assigned to the media when created. The value must be a valid UUID.                    | your-media-id                                                                                                 |
| `trackId`                                                                                                    | *String*                                                                                                     | :heavy_check_mark:                                                                                           | A universally unique identifier (UUID) assigned to the specific track for which subtitles must be generated. | your-track-id                                                                                                 |
| `body`                                                                                                       | [TrackSubtitlesGenerateRequest](../../models/components/TrackSubtitlesGenerateRequest.md)                    | :heavy_check_mark:                                                                                           | N/A                                                                                                          |                                                                                                              |

### Response

**[GenerateSubtitleTrackResponse](../../models/operations/GenerateSubtitleTrackResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getSummary

This endpoint returns the generated summary of a video.  

The summary is created using the **InVideo Summary** feature, which processes the video content and produces a textual summary.  

To use this endpoint, you must first generate the video summary using the Generate Video Summary endpoint. This endpoint can return the summary only after that process is complete. 

Typical use cases include:  
- Providing viewers with a quick preview of the video's main content.  
- Enabling search or recommendation systems to surface summarized insights.  
- Supporting accessibility and content discovery without requiring users to watch the full video.  

If the summary has not been generated or the feature is disabled for the requested media, the endpoint returns an error indicating that the summary is unavailable. 


### Example Usage

<!-- UsageSnippet language="java" operationID="get-media-summary" method="get" path="/on-demand/{mediaId}/summary" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.GetMediaSummaryResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetMediaSummaryResponse res = sdk.manageVideos().getSummary()
                .mediaId("your-media-id")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               | Example                                                                                   |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `mediaId`                                                                                 | *String*                                                                                  | :heavy_check_mark:                                                                        | The unique identifier assigned to the media when created. The value must be a valid UUID. | your-media-id                                                                             |

### Response

**[GetMediaSummaryResponse](../../models/operations/GetMediaSummaryResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateSourceAccess

This endpoint allows you to update the `sourceAccess` setting of an existing media file. The `sourceAccess` parameter determines whether the original media file is accessible or restricted. Setting this to `true` enables access to the media source, while setting it to `false` restricts access. 

#### How it works

1. Make a `PATCH` request to this endpoint, replacing `{mediaId}` with the ID of the media you want to update.

2. Include the updated `sourceAccess` parameter in the request body.

3. You receive a response confirming the update to the media’s source access status.
4. Webhook events: <a href="https://docs.fastpix.io/docs/transform-media-events#videomediasourceready">video.media.source.ready</a>, <a href="https://docs.fastpix.io/docs/transform-media-events#videomediasourcedeleted">video.media.source.deleted</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="updated-source-access" method="patch" path="/on-demand/{mediaId}/source-access" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.UpdatedSourceAccessRequestBody;
import org.openapis.openapi.models.operations.UpdatedSourceAccessResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdatedSourceAccessResponse res = sdk.manageVideos().updateSourceAccess()
                .mediaId("your-media-id")
                .body(UpdatedSourceAccessRequestBody.builder()
                    .sourceAccess(true)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                   | Type                                                                                        | Required                                                                                    | Description                                                                                 | Example                                                                                     |
| ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| `mediaId`                                                                                   | *String*                                                                                    | :heavy_check_mark:                                                                          | The unique identifier assigned to the media when created. The value must be a valid UUID.<br/> | your-media-id                                                                               |
| `body`                                                                                      | [UpdatedSourceAccessRequestBody](../../models/operations/UpdatedSourceAccessRequestBody.md) | :heavy_check_mark:                                                                          | N/A                                                                                         | {<br/>"sourceAccess": true<br/>}                                                            |

### Response

**[UpdatedSourceAccessResponse](../../models/operations/UpdatedSourceAccessResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getInputInfo

This endpoint lets you retrieve detailed information about the media inputs associated with a specific media item. You can use it to verify the media file’s input URL, track its creation status, and check its container format. You must provide the mediaId (either the uploadId or the id) to fetch this information.


#### How it works

Upon making a `GET` request with the mediaId, FastPix returns a response with: 

* The public storage input `url` of the uploaded media file. 

* Information about the media’s video and audio tracks, including whether they were successfully created.

* The container format of the uploaded media file (for example, MP4, MKV).

This endpoint is particularly useful for ensuring that all necessary tracks (video and audio) have been correctly associated with the media during the upload or media creation process.


### Example Usage

<!-- UsageSnippet language="java" operationID="retrieveMediaInputInfo" method="get" path="/on-demand/{mediaId}/input-info" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.RetrieveMediaInputInfoResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        RetrieveMediaInputInfoResponse res = sdk.manageVideos().getInputInfo()
                .mediaId("your-media-id")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               | Example                                                                                   |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `mediaId`                                                                                 | *String*                                                                                  | :heavy_check_mark:                                                                        | Pass the list of the input objects used to create the media, along with applied settings. | your-media-id                                                                             |

### Response

**[RetrieveMediaInputInfoResponse](../../models/operations/RetrieveMediaInputInfoResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |