# InputVideo
(*inputVideo()*)

## Overview

### Available Operations

* [createMedia](#createmedia) - Create media from URL
* [directUploadVideoMedia](#directuploadvideomedia) - Upload media from device

## createMedia

This endpoint allows developers or users to create a new video or audio media in FastPix using a publicly accessible URL. FastPix will fetch the media from the provided URL, process it, and store it on the platform for use. 



#### Public URL requirement:


  The provided URL must be publicly accessible and should point to a video stored in one of the following supported formats: .m4v, .ogv, .mpeg, .mov, .3gp, .f4v, .rm, .ts, .wtv, .avi, .mp4, .wmv, .webm, .mts, .vob, .mxf, asf, m2ts 



#### Supported storage types:

The URL can originate from various cloud storage services or content delivery networks (CDNs) such as: 


* **Amazon S3:** URLs from Amazon's Simple Storage Service. 

* **Google Cloud Storage:** URLs from Google Cloud's storage solution. 

* **Azure Blob Storage:** URLs from Microsoft's Azure storage. 

* **Public CDNs:** URLs from public content delivery networks that host video files. 

Upon successful creation, the API returns an id that should be retained for future operations related to this media. 

#### How it works


1. Send a POST request to the /on-demand endpoint with the media URL (typically a video or audio file) and optional media settings. 

2. FastPix uploads the video from the provided URL to its storage. 

3. Receive a response containing the unique id for the newly created media item. 

4. Use the id in subsequent API calls, such as checking the status of the media with the **Get Media by ID** endpoint to determine when the media is ready for playback. 

FastPix uses webhooks to tell your application about things that happen in the background, outside of the API regular request flow. For instance, once the media file is created (but not yet processed or encoded), we’ll shoot a POST message to the address you give us with the webhook event video.media.created. 


Once processing is done you can look for the events video.media.ready and video.media.failed to see the status of your new media file.

#### Use case scenario


* **Use case:** A developer wants to integrate a user-generated content platform where users can upload links to their videos hosted on third-party platforms like AWS or Google Cloud Storage. This endpoint is used to create media directly from those URLs. 


* **Detailed example:** 
Say you’re building an online learning platform where instructors upload video URLs hosted on their private cloud servers. By providing the video URL to this endpoint, the platform processes and adds it to your media library, ready for playback. 


### Example Usage

```java
package hello.world;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.*;
import io.fastpix.sdk.models.errors.*;
import io.fastpix.sdk.models.operations.CreateMediaResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws BadRequestException, InvalidPermissionException, ForbiddenException, ValidationErrorResponse, Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("")
                    .password("")
                    .build())
            .build();

        CreateMediaRequest req = CreateMediaRequest.builder()
                .inputs(List.of(
                    Input.of(VideoInput.builder()
                        .type("video")
                        .url("https://static.fastpix.io/sample.mp4")
                        .build())))
                .accessPolicy(CreateMediaRequestAccessPolicy.PUBLIC)
                .build();

        CreateMediaResponse res = sdk.inputVideo().createMedia()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `request`                                                       | [CreateMediaRequest](../../models/shared/CreateMediaRequest.md) | :heavy_check_mark:                                              | The request object to use for the request.                      |

### Response

**[CreateMediaResponse](../../models/operations/CreateMediaResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/BadRequestException        | 400                                      | application/json                         |
| models/errors/InvalidPermissionException | 401                                      | application/json                         |
| models/errors/ForbiddenException         | 403                                      | application/json                         |
| models/errors/ValidationErrorResponse    | 422                                      | application/json                         |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## directUploadVideoMedia

This endpoint enables you to upload a video file directly from your local device to FastPix for processing, storage. When you invoke this API with your preferred media settings, the response returns an uploadId and a pre-signed URL, providing a streamlined experience for uploading.



#### How it works

1. Send a POST request to the /on-demand/uploads endpoint with optional media settings.  

2. The response includes an **uploadId** and a pre-signed URL for direct video file upload.

3. Upload your video file to the provided **URL** by making **PUT** request. The API accepts the media file from the device and uploads it to the FastPix platform. 

4. Once uploaded, the media undergoes processing and is assigned a unique ID for tracking. Retain this **uploadId** for any future operations related to this upload. 




After uploading, you can use the **Get Media by ID** endpoint to check the status of the uploaded media asset and see if it has transitioned to a "ready" status for playback. 

To notify your application about the status of this API request check for the webhooks for Upload related events.  


#### Use case scenario 

**Use case:** A social media platform allows users to upload video content directly from their phones or computers. This endpoint facilitates the upload process. For example, if you are developing a video-sharing app where users can upload short clips from their mobile devices, this endpoint enables them to select a video, upload it to the platform.


### Example Usage

```java
package hello.world;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.*;
import io.fastpix.sdk.models.errors.*;
import io.fastpix.sdk.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws BadRequestException, InvalidPermissionException, ForbiddenException, ValidationErrorResponse, Exception {

        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("")
                    .password("")
                    .build())
            .build();

        DirectUploadVideoMediaRequest req = DirectUploadVideoMediaRequest.builder()
                .corsOrigin("*")
                .pushMediaSettings(PushMediaSettings.builder()
                    .accessPolicy(DirectUploadVideoMediaAccessPolicy.PUBLIC)
                    .startTime(0)
                    .endTime(60)
                    .inputs(List.of(
                        Input.of(AudioInput.builder()
                            .type(AudioInputType.AUDIO)
                            .swapTrackUrl("https://file-examples.com/storage/fe0e9b723466913cf9611b7/2017/11/file_example_MP3_700KB.mp3")
                            .imposeTracks(List.of(
                                ImposeTrack.builder()
                                    .url("http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/fx/engine-2.ogg")
                                    .startTime(0L)
                                    .endTime(5L)
                                    .fadeInLevel(1L)
                                    .fadeOutLevel(4L)
                                    .build(),
                                ImposeTrack.builder()
                                    .url("http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/fx/engine-2.ogg")
                                    .startTime(0L)
                                    .endTime(5L)
                                    .fadeInLevel(1L)
                                    .fadeOutLevel(4L)
                                    .build(),
                                ImposeTrack.builder()
                                    .url("http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/fx/engine-2.ogg")
                                    .startTime(0L)
                                    .endTime(5L)
                                    .fadeInLevel(1L)
                                    .fadeOutLevel(4L)
                                    .build()))
                            .build())))
                    .subtitles(Subtitles.builder()
                        .languageName("english")
                        .languageCode(LanguageCode.EN)
                        .build())
                    .sourceAccess(true)
                    .mp4Support(Mp4Support.CAPPED4K)
                    .summary(Summary.builder()
                        .generate(true)
                        .build())
                    .chapters(true)
                    .namedEntities(true)
                    .moderation(Moderation.builder()
                        .type(Type.VIDEO)
                        .build())
                    .accessRestrictions(DirectUploadVideoMediaAccessRestrictions.builder()
                        .domains(DirectUploadVideoMediaDomains.builder()
                            .allow(List.of(
                                "example.com",
                                "trustedsite.org"))
                            .deny(List.of(
                                "malicioussite.io",
                                "spamdomain.net"))
                            .build())
                        .userAgents(DirectUploadVideoMediaUserAgents.builder()
                            .allow(List.of(
                                "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
                                "curl/7.68.0"))
                            .deny(List.of(
                                "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36",
                                "PostmanRuntime/7.29.0"))
                            .build())
                        .build())
                    .build())
                .build();

        DirectUploadVideoMediaResponse res = sdk.inputVideo().directUploadVideoMedia()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `request`                                                                                 | [DirectUploadVideoMediaRequest](../../models/operations/DirectUploadVideoMediaRequest.md) | :heavy_check_mark:                                                                        | The request object to use for the request.                                                |

### Response

**[DirectUploadVideoMediaResponse](../../models/operations/DirectUploadVideoMediaResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/BadRequestException        | 400                                      | application/json                         |
| models/errors/InvalidPermissionException | 401                                      | application/json                         |
| models/errors/ForbiddenException         | 403                                      | application/json                         |
| models/errors/ValidationErrorResponse    | 422                                      | application/json                         |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |