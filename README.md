# FastPix Java SDK

Developer-friendly & type-safe Java SDK specifically designed to leverage the FastPix platform API.

# Introduction

The FastPix Java SDK simplifies integration with the FastPix platform. This SDK is designed for secure and efficient communication with the FastPix API, enabling easy management of media uploads, live streaming, and simulcasting.

# Key Features

- ## Media API
  - **Upload Media**: Upload media files seamlessly from URLs or devices
  - **Manage Media**: Perform operations such as listing, fetching, updating, and deleting media assets
  - **Playback IDs**: Generate and manage playback IDs for media access

- ## Live API
  - **Create & Manage Live Streams**: Create, list, update, and delete live streams effortlessly
  - **Control Stream Access**: Generate playback IDs for live streams to control and manage access
  - **Simulcast to Multiple Platforms**: Stream content to multiple platforms simultaneously

For detailed usage, refer to the [FastPix API Reference](https://docs.fastpix.io/reference).

# Prerequisites:
- JDK 11 or later
- FastPix API credentials (Access Token and Secret Key)

## Getting started with FastPix:

To get started with the **FastPix Java SDK**, ensure you have the following:

- The FastPix APIs are authenticated using an **Access Token** and a **Secret Key**. You must generate these credentials to use the SDK.

- Follow the steps in the [Authentication with Access Tokens](https://docs.fastpix.io/docs/basic-authentication) guide to obtain your credentials.

<!-- Start Table of Contents [toc] -->
## Table of Contents

<!-- $toc-max-depth=2 -->
* [FastPixSDK](#openapi)
  * [SDK Installation](#sdk-installation)
  * [Initialization](#initialization)
  * [SDK Example Usage](#sdk-example-usage)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
  * [Development](#development)
  * [Maturity](#maturity)
  * [Detailed Usage](#detailed-usage)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'io.fastpix:sdk:0.1.0'
```

Maven:
```xml
<dependency>
    <groupId>io.fastpix</groupId>
    <artifactId>sdk</artifactId>
    <version>0.1.0</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```

<!-- Start Initialization  -->
## Initialization

You can set the security parameters through the `security` builder method when initializing the SDK client instance. For example:

```java
FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                    .username("your-access-token-id")
                    .password("your-secret-key")
                    .build())
```
<!-- End Initialization  -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example

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
                    .username("your-access-token-id")
                    .password("your-secret-key")
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
<!-- End SDK Example Usage [usage] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>


### [inputVideo()](docs/sdks/inputvideo/README.md)

* [createMedia](docs/sdks/inputvideo/README.md#createmedia) - Create media from URL
* [directUploadVideoMedia](docs/sdks/inputvideo/README.md#directuploadvideomedia) - Upload media from device

### [manageLiveStream()](docs/sdks/managelivestream/README.md)

* [getAllStreams](docs/sdks/managelivestream/README.md#getallstreams) - Get all live streams
* [getLiveStreamById](docs/sdks/managelivestream/README.md#getlivestreambyid) - Get stream by ID
* [deleteLiveStream](docs/sdks/managelivestream/README.md#deletelivestream) - Delete a stream
* [updateLiveStream](docs/sdks/managelivestream/README.md#updatelivestream) - Update a stream

### [manageVideos()](docs/sdks/managevideos/README.md)

* [listMedia](docs/sdks/managevideos/README.md#listmedia) - Get list of all media
* [getMedia](docs/sdks/managevideos/README.md#getmedia) - Get a media by ID
* [updatedMedia](docs/sdks/managevideos/README.md#updatedmedia) - Update a media by ID
* [deleteMedia](docs/sdks/managevideos/README.md#deletemedia) - Delete a media by ID
* [retrieveMediaInputInfo](docs/sdks/managevideos/README.md#retrievemediainputinfo) - Get info of media inputs

### [playback()](docs/sdks/playback/README.md)

* [createPlaybackIdOfStream](docs/sdks/playback/README.md#createplaybackidofstream) - Create a playbackId
* [deletePlaybackIdOfStream](docs/sdks/playback/README.md#deleteplaybackidofstream) - Delete a playbackId
* [getLiveStreamPlaybackId](docs/sdks/playback/README.md#getlivestreamplaybackid) - Get stream's playbackId
* [createMediaPlaybackId](docs/sdks/playback/README.md#createmediaplaybackid) - Create a playback ID
* [deleteMediaPlaybackId](docs/sdks/playback/README.md#deletemediaplaybackid) - Delete a playback ID

### [simulcastStream()](docs/sdks/simulcaststream/README.md)

* [createSimulcastOfStream](docs/sdks/simulcaststream/README.md#createsimulcastofstream) - Create a simulcast
* [deleteSimulcastOfStream](docs/sdks/simulcaststream/README.md#deletesimulcastofstream) - Delete a simulcast
* [getSpecificSimulcastOfStream](docs/sdks/simulcaststream/README.md#getspecificsimulcastofstream) - Get a specific simulcast of a stream
* [updateSpecificSimulcastOfStream](docs/sdks/simulcaststream/README.md#updatespecificsimulcastofstream) - Update a specific simulcast of a stream

### [startLiveStream()](docs/sdks/startlivestream/README.md)

* [createNewStream](docs/sdks/startlivestream/README.md#createnewstream) - Create a new stream

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Error Handling [errors] -->
## Error Handling

All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/APIException` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `createNewStream` method throws the following exceptions:

| Error Type                               | Status Code | Content Type     |
| ---------------------------------------- | ----------- | ---------------- |
| models/errors/UnauthorizedException      | 401         | application/json |
| models/errors/InvalidPermissionException | 403         | application/json |
| models/errors/ValidationErrorResponse    | 422         | application/json |
| models/errors/APIException               | 4XX, 5XX    | \*/\*            |

### Example

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
                    .username("your-access-token-id")
                    .password("your-secret-key")
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
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Override Server URL Per-Client

The default server can be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
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
                .serverURL("https://v1.fastpix.io/live")
                .security(Security.builder()
                    .username("your-access-token-id")
                    .password("your-secret-key")
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
<!-- End Server Selection [server] -->

# Development

## Maturity

This SDK is currently in beta, and breaking changes may occur between versions even without a major version update. To avoid unexpected issues, we recommend pinning your dependency to a specific version. This ensures consistent behavior unless you intentionally update to a newer release.

## Detailed Usage

For a complete understanding of each API's functionality, including request and response details, parameter descriptions, and additional examples, please refer to the [FastPix API Reference](https://docs.fastpix.io/reference/signingkeys-overview).

The API reference provides comprehensive documentation for all available endpoints and features, ensuring developers can integrate and utilize FastPix APIs efficiently.
