# Videos

## Overview

### Available Operations

* [listLiveClips](#listliveclips) - Get all clips of a live stream
* [updateMedia](#updatemedia) - Update a media by ID
* [delete](#delete) - Delete a media by ID
* [cancelUpload](#cancelupload) - Cancel ongoing upload
* [updateTrack](#updatetrack) - Update audio / subtitle track
* [updateChapters](#updatechapters) - Generate video chapters
* [updateMp4Support](#updatemp4support) - Update the mp4Support of a media by ID
* [listUploads](#listuploads) - Get all unused upload URLs
* [getMediaClips](#getmediaclips) - Get all clips of a media

## listLiveClips

Retrieves a list of all media clips generated from a specific livestream. Each media entry includes metadata such as the clip media IDs, and other relevant details. A media clip is a segmented portion of an original media file (source live stream). Clips are often created for various purposes such as previews, highlights, or customized edits.
#### How it works
1. Provide the livestreamId as a parameter when calling this endpoint.

2. The API returns a paginated list of media clips created from the specified livestream.

3. Pagination helps maintain performance and usability when handling large sets of media files, making it easier to organize and manage content in bulk.

#### Use case
Suppose you’re hosting a live gaming event and want to showcase key moments from the stream — such as top plays or final match highlights. You can use this endpoint to fetch all clips generated from that livestream, display them in your dashboard, or use them for post-event editing and sharing.


Related guide: <a href="https://docs.fastpix.io/docs/instant-live-clipping">Instant live clipping</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="list-live-clips" method="get" path="/on-demand/{livestreamId}/live-clips" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.components.SortOrder;
import org.openapis.openapi.models.operations.ListLiveClipsResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        ListLiveClipsResponse res = sdk.videos().listLiveClips()
                .livestreamId("your-livestream-id")
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
| `livestreamId`                                                                            | *String*                                                                                  | :heavy_check_mark:                                                                        | The stream Id is unique identifier assigned to the live stream.                           | your-livestream-id                                                                        |
| `limit`                                                                                   | *Optional\<Long>*                                                                         | :heavy_minus_sign:                                                                        | Limit specifies the maximum number of items to display per page.                          | 20                                                                                        |
| `offset`                                                                                  | *Optional\<Long>*                                                                         | :heavy_minus_sign:                                                                        | Offset determines the starting point for data retrieval within a paginated list.          | 1                                                                                         |
| `orderBy`                                                                                 | [Optional\<SortOrder>](../../models/components/SortOrder.md)                              | :heavy_minus_sign:                                                                        | The values in the list can be arranged in two ways: DESC (Descending) or ASC (Ascending). | desc                                                                                      |

### Response

**[ListLiveClipsResponse](../../models/operations/ListLiveClipsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateMedia

This endpoint allows you to update specific parameters of an existing media file. You can modify the key-value pairs of the metadata that were provided in the payload during the creation of media from a URL or when uploading the media directly from device. 


#### How it works

1. Make a PATCH request to this endpoint. Replace `<mediaId>` with the unique ID (`uploadId` or `id`) of the media you received after uploading to FastPix

2. Include the updated parameters in the request body.

3. The response returns the updated media data, confirming the changes. 

4. Monitor the <a href="https://docs.fastpix.io/docs/media-events#videomediaupdated">video.media.updated</a> webhook event to track the update status in your system.

#### Example
If a user uploads a video and later needs to change the title, add a new description, or update tags, you can use this endpoint to update the media metadata without re-uploading the entire video.


### Example Usage

<!-- UsageSnippet language="java" operationID="updated-media" method="patch" path="/on-demand/{mediaId}" -->
```java
package hello.world;

import java.lang.Exception;
import java.util.Map;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.UpdatedMediaRequestBody;
import org.openapis.openapi.models.operations.UpdatedMediaResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdatedMediaResponse res = sdk.videos().updateMedia()
                .mediaId("your-media-id")
                .body(UpdatedMediaRequestBody.builder()
                    .metadata(Map.ofEntries(
                        Map.entry("user", "fastpix_admin")))
                    .title("test title")
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
| `body`                                                                                    | [UpdatedMediaRequestBody](../../models/operations/UpdatedMediaRequestBody.md)             | :heavy_check_mark:                                                                        | N/A                                                                                       |                                                                                           |

### Response

**[UpdatedMediaResponse](../../models/operations/UpdatedMediaResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## delete

This endpoint allows you to permanently delete a a specific video or audio media file along with all associated data. If you wish to remove a media from FastPix storage, use this endpoint with the `mediaId` (either `uploadId` or `id`) received during the media's creation or upload. 


#### How it works


1. Send a DELETE request to this endpoint. Replace `<mediaId>` with the `uploadId` or the `id` of the media you want to delete. 

2. This action is irreversible. Make sure you no longer need the media before proceeding. Once deleted, the media can’t be retrieved or played back. 

3. Monitor the following webhook event: <a href="https://docs.fastpix.io/docs/media-events#videomediadeleted">video.media.deleted</a>

#### Example
A user on a video-sharing platform decides to remove an old video from their profile, or suppose you're running a content moderation system, and one of the videos uploaded by a user violates your platform's policies. Using this endpoint, the media is permanently deleted from your library, ensuring it's no longer accessible or viewable by other users.


### Example Usage

<!-- UsageSnippet language="java" operationID="delete-media" method="delete" path="/on-demand/{mediaId}" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.DeleteMediaResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        DeleteMediaResponse res = sdk.videos().delete()
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

**[DeleteMediaResponse](../../models/operations/DeleteMediaResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## cancelUpload

This endpoint allows you to cancel ongoing upload by its `uploadId`. Once cancelled, the upload is marked as cancelled. Use this if a user aborts an upload or if you want to programmatically stop an in-progress upload.

#### How it works

1. Make a PUT request to this endpoint, replacing `{uploadId}` with the unique upload ID received after starting the upload.
2. The response confirms the cancellation and provide the status of the upload.

#### Webhook Events

Once the upload is cancelled, you must receive the webhook event <a href="https://docs.fastpix.io/docs/media-events#videomediauploadcancelled">video.media.upload.cancelled</a>.

#### Example

Suppose a user starts uploading a large video file but decides to cancel before completion. By calling this API, you can immediately stop the upload and free up resources.


### Example Usage

<!-- UsageSnippet language="java" operationID="cancel-upload" method="put" path="/on-demand/upload/{uploadId}/cancel" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.CancelUploadResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        CancelUploadResponse res = sdk.videos().cancelUpload()
                .uploadId("your-upload-id")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                          | Type                                                                                                               | Required                                                                                                           | Description                                                                                                        | Example                                                                                                            |
| ------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------ |
| `uploadId`                                                                                                         | *String*                                                                                                           | :heavy_check_mark:                                                                                                 | When uploading the media, FastPix assigns a universally unique identifier with a maximum length of 255 characters. | your-upload-id                                                                                                   |

### Response

**[CancelUploadResponse](../../models/operations/CancelUploadResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateTrack

This endpoint allows you to update an existing audio or subtitle track associated with a media file. When updating a track, you must provide the new track `url`, `languageName`, and `languageCode`, ensuring all three parameters are included in the request.


#### How it works

1. Send a PATCH request to this endpoint, replacing `{mediaId}` with the media ID, and `{trackId}` with the ID of the track you want to update.

2. Provide the necessary details in the request body.

3. Receive a response confirming the track update.

#### Webhook Events

After updating a track, your system must receive webhook notifications:

1. After successfully updating a track, your system must receive the webhook event <a href="https://docs.fastpix.io/docs/transform-media-events#videomediatrackupdated">video.media.track.updated</a>.

2. Once the new track is processed and ready, you must receive the webhook event <a href="https://docs.fastpix.io/docs/transform-media-events#videomediatrackready">video.media.track.ready</a>.

3. Once the media file is updated with the new track details, a <a href="https://docs.fastpix.io/docs/media-events#videomediaupdated">video.media.updated</a> event must be triggered.


#### Example
Suppose you previously added a French subtitle track to a video but now need to update it with a different file. By calling this API, you can replace the existing subtitle file (.vtt) with a new one while keeping the same track ID. This is useful when:

  - The original track file has errors and needs correction.
  - You want to improve subtitle translations or replace an audio track with a better-quality version.

Related guides: <a href="https://docs.fastpix.io/docs/manage-subtitle-tracks">Add own subtitle tracks</a>, <a href="https://docs.fastpix.io/docs/manage-audio-tracks">Add own audio tracks</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="update-media-track" method="patch" path="/on-demand/{mediaId}/tracks/{trackId}" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.components.UpdateTrackRequest;
import org.openapis.openapi.models.operations.UpdateMediaTrackResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateMediaTrackResponse res = sdk.videos().updateTrack()
                .trackId("your-track-id")
                .mediaId("your-media-id")
                .body(UpdateTrackRequest.builder()
                    .languageName("french")
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
| `trackId`                                                                                 | *String*                                                                                  | :heavy_check_mark:                                                                        | The unique identifier assigned to the media when created. The value must be a valid UUID. | your-track-id                                                                             |
| `mediaId`                                                                                 | *String*                                                                                  | :heavy_check_mark:                                                                        | The unique identifier assigned to the media when created. The value must be a valid UUID. | your-media-id                                                                             |
| `body`                                                                                    | [UpdateTrackRequest](../../models/components/UpdateTrackRequest.md)                       | :heavy_check_mark:                                                                        | N/A                                                                                       |                                                                                           |

### Response

**[UpdateMediaTrackResponse](../../models/operations/UpdateMediaTrackResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateChapters

This endpoint enables you to generate chapters for an existing media file.

#### How it works
1. Make a `PATCH` request to this endpoint, replacing `<mediaId>` with the ID of the media for which you want to generate chapters.
2. Include the `chapters` parameter in the request body to enable.
3. The response contains the updated media data, confirming the changes made.

You can use the <a href="https://docs.fastpix.io/docs/ai-events#videomediaaichaptersready">video.mediaAI.chapters.ready</a> webhook event to track and notify about the chapters generation.

**Use case:** This is particularly useful when a user uploads a video and later decides to enable chapters without re-uploading the entire video.

Related guide: <a href="https://docs.fastpix.io/docs/generate-video-chapters">Video chapters</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="update-media-chapters" method="patch" path="/on-demand/{mediaId}/chapters" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.UpdateMediaChaptersRequestBody;
import org.openapis.openapi.models.operations.UpdateMediaChaptersResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdateMediaChaptersResponse res = sdk.videos().updateChapters()
                .mediaId("your-media-id")
                .body(UpdateMediaChaptersRequestBody.builder()
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
| `body`                                                                                      | [UpdateMediaChaptersRequestBody](../../models/operations/UpdateMediaChaptersRequestBody.md) | :heavy_check_mark:                                                                          | N/A                                                                                         | {<br/>"chapters": true<br/>}                                                                |

### Response

**[UpdateMediaChaptersResponse](../../models/operations/UpdateMediaChaptersResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateMp4Support

This endpoint allows you to update the `mp4Support` setting of an existing media file using its media ID. You can specify the MP4 support level, such as `none`, `capped_4k`, `audioOnly`, or a combination of `audioOnly`, `capped_4k`, in the request payload.

#### How it works

1. Send a PATCH request to this endpoint, replacing `{mediaId}` with the media ID.

2. Provide the desired `mp4Support` value in the request body.

3. You receive a response confirming the update, including the media’s updated MP4 support status.

#### MP4 Support Options

- `none` – MP4 support is disabled for this media.

- `capped_4k` – Generates MP4 renditions up to 4K resolution.

- `audioOnly` – Generates an M4A file that contains only the audio track.

- `audioOnly,capped_4k` – Generates both an audio-only M4A file and MP4 renditions up to 4K resolution.

#### Webhook events

- <a href="https://docs.fastpix.io/docs/transform-media-events#videomediamp4supportready">video.media.mp4Support.ready</a> – Triggered when the MP4 support setting is successfully updated.

#### Example
Suppose you have a video uploaded to the FastPix platform, and you want to allow users to download the video in MP4 format. By setting "mp4Support": "capped_4k", the system generates an MP4 rendition of the video up to 4K resolution, making it available for download through the stream URL(`https://stream.fastpix.io/{playbackId}/{capped-4k.mp4 | audio.m4a}`). If you want users to stream only the audio from the media file, you can set "mp4Support": "audioOnly". This provides an audio-only stream URL that allows users to listen to the media without video. By setting "mp4Support": "audioOnly,capped_4k", both options are enabled. Users can download the MP4 video and also stream just the audio version of the media. 


Related guide: <a href="https://docs.fastpix.io/docs/mp4-support-for-offline-viewing">Use MP4 support for offline viewing</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="updated-mp4Support" method="patch" path="/on-demand/{mediaId}/update-mp4Support" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.operations.UpdatedMp4SupportRequestBody;
import org.openapis.openapi.models.operations.UpdatedMp4SupportResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        UpdatedMp4SupportResponse res = sdk.videos().updateMp4Support()
                .mediaId("your-media-id")
                .body(UpdatedMp4SupportRequestBody.builder()
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `mediaId`                                                                                  | *String*                                                                                   | :heavy_check_mark:                                                                         | The unique identifier assigned to the media when created. The value must be a valid UUID.<br/> | your-media-id                                                                               |
| `body`                                                                                     | [UpdatedMp4SupportRequestBody](../../models/operations/UpdatedMp4SupportRequestBody.md)    | :heavy_check_mark:                                                                         | N/A                                                                                        | {<br/>"mp4Support": "capped_4k"<br/>}                                                      |

### Response

**[UpdatedMp4SupportResponse](../../models/operations/UpdatedMp4SupportResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## listUploads

This endpoint retrieves a paginated list of all unused upload signed URLs within your organization. It provides comprehensive metadata including upload IDs, creation dates, status, and URLs, helping you manage your media resources efficiently.

An unused upload URL is a signed URL that gets generated when an user initiates upload but never completed the upload process. This can happen due to reasons like network issues, manual cancellation of upload, browser/app crashes or session timeouts.These URLs remain in the system as "unused" since they were created but never resulted in a successful media file upload.

#### How it works

 - The endpoint returns metadata for all unused upload URLs in your organization's library.
 - Results are paginated to manage large datasets effectively.
 - Signed URLs expire after 24 hours from creation.
 - Each entry includes full metadata about the unused upload.



#### Example

A video management team at a media organization regularly uploads content but often forgets to delete or use unused uploads. These unused uploads have signed URLs that expire after 24 hours and need to be managed efficiently. By using this API, the team can retrieve metadata for all unused uploads, identify expired signed URLs, and decide whether to regenerate URLs, reuse the uploads, or delete them.


### Example Usage

<!-- UsageSnippet language="java" operationID="list-uploads" method="get" path="/on-demand/uploads" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.components.SortOrder;
import org.openapis.openapi.models.operations.ListUploadsResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        ListUploadsResponse res = sdk.videos().listUploads()
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

**[ListUploadsResponse](../../models/operations/ListUploadsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getMediaClips

This endpoint retrieves a list of all media clips associated with a given source media ID. It helps you organize and manage media efficiently by providing metadata such as clip media IDs and other relevant details.

A media clip is a segmented portion of an original media file (source media). Clips are often created for various purposes such as previews, highlights, or customized edits. This API allows you to fetch all such clips linked to a specific source media, making it easier to track and manage clips.


#### How it works

- The endpoint returns metadata for all media clips associated with the given `mediaId`.
- Results are paginated to efficiently handle large datasets.
- Each entry includes detailed metadata such as media `id`, `duration`, and `status`.
- Helps in organizing clips effectively by providing structured information.


#### Example

Imagine you’re managing a video editing platform where users upload full-length videos and create short clips for social media sharing. To keep track of all clips linked to a particular video, you call this API with the sourceMediaId. The response provides a list of all associated clips, allowing you to manage, edit, or repurpose them as needed.

Related guide: <a href="https://docs.fastpix.io/docs/create-clips-from-existing-media">Create clips from existing media</a>


### Example Usage

<!-- UsageSnippet language="java" operationID="get-media-clips" method="get" path="/on-demand/{mediaId}/media-clips" -->
```java
package hello.world;

import java.lang.Exception;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;
import org.openapis.openapi.models.components.SortOrder;
import org.openapis.openapi.models.operations.GetMediaClipsResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        GetMediaClipsResponse res = sdk.videos().getMediaClips()
                .mediaId("your-media-id")
                .offset(5L)
                .limit(20L)
                .orderBy(SortOrder.DESC)
                .call();

        if (res.mediaClipResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               | Example                                                                                   |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `mediaId`                                                                                 | *String*                                                                                  | :heavy_check_mark:                                                                        | The unique identifier assigned to the media when created. The value must be a valid UUID. | your-media-id                                                                             |
| `offset`                                                                                  | *Optional\<Long>*                                                                         | :heavy_minus_sign:                                                                        | Offset determines the starting point for data retrieval within a paginated list.          | 5                                                                                         |
| `limit`                                                                                   | *Optional\<Long>*                                                                         | :heavy_minus_sign:                                                                        | The number of media clips to retrieve per request.                                        | 20                                                                                        |
| `orderBy`                                                                                 | [Optional\<SortOrder>](../../models/components/SortOrder.md)                              | :heavy_minus_sign:                                                                        | The values in the list can be arranged in two ways DESC (Descending) or ASC (Ascending).  | desc                                                                                      |

### Response

**[GetMediaClipsResponse](../../models/operations/GetMediaClipsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |