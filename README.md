# FastPix Java SDK

A robust, type-safe Java SDK designed for seamless integration with the FastPix API platform.


## Introduction

The FastPix Java SDK simplifies integration with the FastPix platform. It provides a clean, type-safe interface for secure and efficient communication with the FastPix API, enabling easy management of media uploads, live streaming, on‑demand content, playlists, video analytics, and signing keys for secure access and token management. It is intended for use with Java 11 and above.

## Prerequisites

### Environment and Version Support

| Requirement | Version | Description |
|---|---:|---|
| Java | `11+` | Core runtime environment (JDK) |
| Maven/Gradle | `Latest` | Build tool and dependency management |
| Internet | `Required` | API communication and authentication |

> Pro Tip: We recommend using Java 17+ for optimal performance and the latest language features.

### Getting Started with FastPix

To get started with the FastPix Java SDK, ensure you have the following:

- The FastPix APIs are authenticated using a **Username** and a **Password**. You must generate these credentials to use the SDK.
- Follow the steps in the [Authentication with Basic Auth](https://docs.fastpix.io/docs/basic-authentication) guide to obtain your credentials.

### Environment Variables (Optional)

Configure your FastPix credentials using environment variables for enhanced security and convenience:

```bash
# Set your FastPix credentials
export FASTPIX_USERNAME="your-access-token"
export FASTPIX_PASSWORD="your-secret-key"
```

> Security Note: Never commit your credentials to version control. Use environment variables or secure credential management systems.

## Table of Contents

* [FastPix Java SDK](#fastpix-java-sdk)
  * [Setup](#setup)
  * [Example Usage](#example-usage)
  * [Asynchronous Support](#asynchronous-support)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Retries](#retries)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
  * [Custom HTTP Client](#custom-http-client)
  * [Debugging](#debugging)
  * [Development](#development)

## Setup

### Installation

Install the FastPix Java SDK using your preferred build tool:

#### Gradle

Add the dependency to your `build.gradle`:

```groovy
dependencies {
    implementation 'io.fastpix:sdk:1.0.0'
}
```

#### Maven

Add the dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.fastpix</groupId>
    <artifactId>sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Building from Source

After cloning the git repository to your file system, you can build the SDK artifact from source to the `build` directory by running:

**On Unix/Linux/macOS:**
```bash
./gradlew build
```

**On Windows:**
```bash
gradlew.bat build
```

If you wish to build from source and publish the SDK artifact to your local Maven repository, use:

**On Unix/Linux/macOS:**
```bash
./gradlew publishToMavenLocal -Pskip.signing
```

**On Windows:**
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```

### Initialization

Initialize the FastPix SDK with your credentials:

```java
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;

Fastpix sdk = Fastpix.builder()
    .security(Security.builder()
        .username("your-access-token")
        .password("your-secret-key")
        .build())
    .build();
```

Or using environment variables:

```java
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.Security;

Fastpix sdk = Fastpix.builder()
    .security(Security.builder()
        .username(System.getenv("FASTPIX_USERNAME")) // Your Access Token
        .password(System.getenv("FASTPIX_PASSWORD")) // Your Secret Key
        .build())
    .build();
```

## Example Usage

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import java.util.Map;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.operations.CreateMediaResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        CreateMediaRequest req = CreateMediaRequest.builder()
                .inputs(List.of(
                    Input.of(PullVideoInput.builder()
                        .url("https://static.fastpix.io/fp-sample-video.mp4")
                        .build())))
                .metadata(Map.ofEntries(
                    Map.entry("key1", "value1")))
                .build();

        CreateMediaResponse res = sdk.inputVideos().create()
                .request(req)
                .call();

        if (res.createMediaSuccessResponse().isPresent()) {
            // handle response
            System.out.println(res.createMediaSuccessResponse().get());
        }
    }
}
```

## Asynchronous Support

The SDK provides comprehensive asynchronous support using Java's [`CompletableFuture<T>`][comp-fut] and [Reactive Streams `Publisher<T>`][reactive-streams] APIs. This design makes no assumptions about your choice of reactive toolkit, allowing seamless integration with any reactive library.

<details>
<summary>Why Use Async?</summary>

Asynchronous operations provide several key benefits:

- **Non-blocking I/O**: Your threads stay free for other work while operations are in flight
- **Better resource utilization**: Handle more concurrent operations with fewer threads
- **Improved scalability**: Build highly responsive applications that can handle thousands of concurrent requests
- **Reactive integration**: Works seamlessly with reactive streams and backpressure handling

</details>

<details>
<summary>Reactive Library Integration</summary>

The SDK returns [Reactive Streams `Publisher<T>`][reactive-streams] instances for operations dealing with streams involving multiple I/O interactions. We use Reactive Streams instead of JDK Flow API to provide broader compatibility with the reactive ecosystem, as most reactive libraries natively support Reactive Streams.

**Why Reactive Streams over JDK Flow?**
- **Broader ecosystem compatibility**: Most reactive libraries (Project Reactor, RxJava, Akka Streams, etc.) natively support Reactive Streams
- **Industry standard**: Reactive Streams is the de facto standard for reactive programming in Java
- **Better interoperability**: Seamless integration without additional adapters for most use cases

**Integration with Popular Libraries:**
- **Project Reactor**: Use `Flux.from(publisher)` to convert to Reactor types
- **RxJava**: Use `Flowable.fromPublisher(publisher)` for RxJava integration
- **Akka Streams**: Use `Source.fromPublisher(publisher)` for Akka Streams integration
- **Vert.x**: Use `ReadStream.fromPublisher(vertx, publisher)` for Vert.x reactive streams
- **Mutiny**: Use `Multi.createFrom().publisher(publisher)` for Quarkus Mutiny integration

**For JDK Flow API Integration:**
If you need JDK Flow API compatibility (e.g., for Quarkus/Mutiny 2), you can use adapters:
```java
// Convert Reactive Streams Publisher to Flow Publisher
Flow.Publisher<T> flowPublisher = FlowAdapters.toFlowPublisher(reactiveStreamsPublisher);

// Convert Flow Publisher to Reactive Streams Publisher
Publisher<T> reactiveStreamsPublisher = FlowAdapters.toPublisher(flowPublisher);
```

For standard single-response operations, the SDK returns `CompletableFuture<T>` for straightforward async execution.

</details>

### Asynchronous Example

```java
package hello.world;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.openapis.openapi.AsyncFastpix;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.operations.async.CreateMediaResponse;

public class Application {

    public static void main(String[] args) {

        AsyncFastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build()
            .async();

        CreateMediaRequest req = CreateMediaRequest.builder()
                .inputs(List.of(
                    Input.of(PullVideoInput.builder()
                        .url("https://static.fastpix.io/fp-sample-video.mp4")
                        .build())))
                .metadata(Map.ofEntries(
                    Map.entry("key1", "value1")))
                .build();

        CompletableFuture<CreateMediaResponse> resFut = sdk.inputVideos().create()
                .request(req)
                .call();

        resFut.thenAccept(res -> {
            if (res.createMediaSuccessResponse().isPresent()) {
                // handle response
                System.out.println(res.createMediaSuccessResponse().get());
            }
        });
    }
}
```

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
[reactive-streams]: https://www.reactive-streams.org/

## Available Resources and Operations

Comprehensive Java SDK for FastPix platform integration with full API coverage.

### Media API

Upload, manage, and transform video content with comprehensive media management capabilities.

For detailed documentation, see [FastPix Video on Demand Overview](https://docs.fastpix.io/docs/video-on-demand-overview).

#### Input Video
- [Create from URL](docs/sdks/inputvideos/README.md#create) - Upload video content from external URL
- [Upload from Device](docs/sdks/inputvideos/README.md#upload) - Upload video files directly from device

#### Manage Videos
- [List All Media](docs/sdks/managevideos/README.md#list) - Retrieve complete list of all media files
- [Get Media by ID](docs/sdks/managevideos/README.md#get) - Get detailed information for specific media
- [Update Media](docs/sdks/videos/README.md#updatemedia) - Modify media metadata and settings
- [Delete Media](docs/sdks/videos/README.md#delete) - Remove media files from library
- [Cancel Upload](docs/sdks/videos/README.md#cancelupload) - Stop ongoing media upload process
- [Get Input Info](docs/sdks/managevideos/README.md#getinputinfo) - Retrieve detailed input information
- [List Uploads](docs/sdks/videos/README.md#listuploads) - Get all available upload URLs

#### Playback
- [Create Playback ID](docs/sdks/playback/README.md#createid) - Generate secure playback identifier
- [Delete Playback ID](docs/sdks/playback/README.md#deleteid) - Remove playback access
- [Get Playback ID](docs/sdks/playback/README.md#get) - Retrieve playback configuration details
- [List Playback IDs](docs/sdks/playback/README.md#list) - Get all playback IDs for a media
- [Update Domain Restrictions](docs/sdks/playback/README.md#updatedomainrestrictions) - Update domain restrictions for a playback ID
- [Update User-Agent Restrictions](docs/sdks/playback/README.md#updateuseragentrestrictions) - Update user-agent restrictions for a playback ID

#### Playlist
- [Create Playlist](docs/sdks/playlists/README.md#create) - Create new video playlist
- [List Playlists](docs/sdks/playlists/README.md#list) - Get all available playlists
- [Get Playlist](docs/sdks/playlists/README.md#get) - Retrieve specific playlist details
- [Update Playlist](docs/sdks/playlists/README.md#update) - Modify playlist settings and metadata
- [Delete Playlist](docs/sdks/playlists/README.md#delete) - Remove playlist from library
- [Add Media](docs/sdks/playlists/README.md#addmedia) - Add media items to playlist
- [Reorder Media](docs/sdks/playlist/README.md#updatemediaorder) - Change order of media in playlist
- [Remove Media](docs/sdks/playlist/README.md#removemedia) - Remove media from playlist

#### Signing Keys
- [Create Key](docs/sdks/signingkeys/README.md#create) - Generate new signing key pair
- [List Keys](docs/sdks/signingkeys/README.md#list) - Get all available signing keys
- [Delete Key](docs/sdks/signingkeys/README.md#delete) - Remove signing key from system
- [Get Key](docs/sdks/signingkeys/README.md#getbyid) - Retrieve specific signing key details

#### DRM Configurations
- [List DRM Configs](docs/sdks/drmconfigurations/README.md#list) - Get all DRM configuration options
- [Get DRM Config](docs/sdks/drmconfigurations/README.md#getbyid) - Retrieve specific DRM configuration

### Live API

Stream, manage, and transform live video content with real-time broadcasting capabilities.

For detailed documentation, see [FastPix Live Stream Overview](https://docs.fastpix.io/docs/live-stream-overview).

#### Start Live Stream
- [Create Stream](docs/sdks/streams/README.md#create) - Initialize new live streaming session with DVR mode support

#### Manage Live Stream
- [List Streams](docs/sdks/streams/README.md#list) - Retrieve all active live streams
- [Get Viewer Count](docs/sdks/managelivestreams/README.md#getviewercount) - Get real-time viewer statistics
- [Get Stream](docs/sdks/managelivestream/README.md#get) - Retrieve detailed stream information
- [Delete Stream](docs/sdks/livestream/README.md#delete) - Terminate and remove live stream
- [Update Stream](docs/sdks/managelivestream/README.md#update) - Modify stream settings and configuration
- [Enable Stream](docs/sdks/livestream/README.md#enable) - Activate live streaming
- [Disable Stream](docs/sdks/livestream/README.md#disable) - Pause live streaming
- [Complete Stream](docs/sdks/livestream/README.md#complete) - Finalize and archive stream

#### Live Playback
- [Create Playback ID](docs/sdks/liveplayback/README.md#createplaybackid) - Generate secure live playback access
- [Delete Playback ID](docs/sdks/liveplayback/README.md#deleteplaybackid) - Revoke live playback access
- [Get Playback ID](docs/sdks/liveplaybacks/README.md#getplaybackiddetails) - Retrieve live playback configuration

#### Simulcast Stream
- [Create Simulcast](docs/sdks/simulcaststream/README.md#create) - Set up multi-platform streaming
- [Delete Simulcast](docs/sdks/simulcaststreams/README.md#delete) - Remove simulcast configuration
- [Get Simulcast](docs/sdks/simulcaststreams/README.md#getspecific) - Retrieve simulcast settings
- [Update Simulcast](docs/sdks/simulcasts/README.md#update) - Modify simulcast parameters

### Video Data API

Monitor video performance and quality with comprehensive analytics and real-time metrics.

For detailed documentation, see [FastPix Video Data Overview](https://docs.fastpix.io/docs/video-data-overview).

#### Metrics
- [List Breakdown Values](docs/sdks/metrics/README.md#listbreakdown) - Get detailed breakdown of metrics by dimension
- [List Overall Values](docs/sdks/metrics/README.md#listoverallvalues) - Get aggregated metric values across all content
- [Get Timeseries Data](docs/sdks/metrics/README.md#gettimeseries) - Retrieve time-based metric trends and patterns
- [List Comparison Values](docs/sdks/metrics/README.md#listcomparison) - Compare metrics across different time periods

#### Views
- [List Video Views](docs/sdks/views/README.md#list) - Get comprehensive list of video viewing sessions
- [Get View Details](docs/sdks/views/README.md#getdetails) - Retrieve detailed information about specific video views
- [List Top Content](docs/sdks/views/README.md#listbytopcontent) - Find your most popular and engaging content
- [Get Concurrent Viewers](docs/sdks/metrics/README.md#listcomparison) - Monitor real-time viewer counts over time
- [Get Viewer Breakdown](docs/sdks/metrics/README.md#listbreakdown) - Analyze viewers by device, location, and other dimensions

#### Dimensions
- [List Dimensions](docs/sdks/dimensions/README.md#list) - Get available data dimensions for filtering and analysis
- [List Filter Values](docs/sdks/dimensions/README.md#listfiltervalues) - Get specific values for a particular dimension

#### Errors
- [List Errors](docs/sdks/errors/README.md#list) - Get playback errors and performance issues

### Transformations

Transform and enhance your video content with powerful AI and editing capabilities.

#### In-Video AI Features

Enhance video content with AI-powered features including moderation, summarization, and intelligent categorization.

- [Update Summary](docs/sdks/aifeatures/README.md#updatemediasummary) - Create AI-generated video summaries
- [Generate Chapters](docs/sdks/videos/README.md#updatechapters) - Automatically generate video chapter markers
- [Extract Entities](docs/sdks/invideoaifeatures/README.md#generatenamedentities) - Identify and extract named entities from content
- [Enable Moderation](docs/sdks/invideoaifeatures/README.md#updatemoderation) - Activate content moderation and safety checks

#### Media Clips

- [Get Media Clips](docs/sdks/videos/README.md#getmediaclips) - Retrieve all clips associated with a source media
- [List Live Clips](docs/sdks/videos/README.md#listliveclips) - Get all clips of a live stream

#### Subtitles

- [Generate Subtitles](docs/sdks/managevideos/README.md#generatesubtitles) - Create automatic subtitles for media

#### Media Tracks

- [Add Track](docs/sdks/managevideos/README.md#addtrack) - Add audio or subtitle tracks to media
- [Update Track](docs/sdks/videos/README.md#updatetrack) - Modify existing audio or subtitle tracks
- [Delete Track](docs/sdks/managevideos/README.md#deletetrack) - Remove audio or subtitle tracks

#### Access Control

- [Update Source Access](docs/sdks/managevideos/README.md#updatesourceaccess) - Control access permissions for media source

#### Format Support

- [Update MP4 Support](docs/sdks/videos/README.md#updatemp4support) - Configure MP4 download capabilities

#### Video Summary

- [Get Summary](docs/sdks/managevideos/README.md#getsummary) - Retrieve AI-generated video summary

<!-- End Available Resources and Operations [operations] -->

## Retries

Some of the endpoints in this SDK support retries. If you use the SDK without any configuration, it will fall back to the default retry strategy provided by the API. However, the default retry strategy can be overridden on a per-operation basis, or across the entire SDK.

To change the default retry strategy for a single API call, you can provide a `RetryConfig` object through the `retryConfig` builder method:

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.operations.CreateMediaResponse;
import org.openapis.openapi.utils.BackoffStrategy;
import org.openapis.openapi.utils.RetryConfig;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        CreateMediaRequest req = CreateMediaRequest.builder()
                .inputs(List.of(
                    Input.of(PullVideoInput.builder()
                        .url("https://static.fastpix.io/fp-sample-video.mp4")
                        .build())))
                .metadata(Map.ofEntries(
                    Map.entry("key1", "value1")))
                .build();

        CreateMediaResponse res = sdk.inputVideos().create()
                .request(req)
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(100L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
                .call();

        if (res.createMediaSuccessResponse().isPresent()) {
            // handle response
        }
    }
}
```

If you'd like to override the default retry strategy for all operations that support retries, you can provide a configuration at SDK initialization:

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.operations.CreateMediaResponse;
import org.openapis.openapi.utils.BackoffStrategy;
import org.openapis.openapi.utils.RetryConfig;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(100L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        CreateMediaRequest req = CreateMediaRequest.builder()
                .inputs(List.of(
                    Input.of(PullVideoInput.builder()
                        .url("https://static.fastpix.io/fp-sample-video.mp4")
                        .build())))
                .metadata(Map.ofEntries(
                    Map.entry("key1", "value1")))
                .build();

        CreateMediaResponse res = sdk.inputVideos().create()
                .request(req)
                .call();

        if (res.createMediaSuccessResponse().isPresent()) {
            // handle response
        }
    }
}
```

## Error Handling

[`FastpixException`](./src/main/java/models/errors/FastpixException.java) is the base class for all HTTP error responses. It has the following properties:

| Method           | Type                        | Description                                                              |
| ---------------- | --------------------------- | ------------------------------------------------------------------------ |
| `message()`      | `String`                    | Error message                                                            |
| `code()`         | `int`                       | HTTP response status code eg `404`                                       |
| `headers()`      | `Map<String, List<String>>` | HTTP response headers                                                    |
| `body()`         | `Optional<byte[]>`          | HTTP body as a byte array. Can be empty if no body is returned.         |
| `bodyAsString()` | `String`                    | HTTP body as a UTF-8 string. Can be empty string if no body is returned. |
| `rawResponse()`  | `HttpResponse<?>`           | Raw HTTP response (body already read and not available for re-read)      |

### Example

```java
package hello.world;

import java.io.UncheckedIOException;
import java.lang.Exception;
import java.util.*;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.errors.FastpixException;
import org.openapis.openapi.models.operations.CreateMediaResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();
        try {

            CreateMediaRequest req = CreateMediaRequest.builder()
                    .inputs(List.of(
                        Input.of(PullVideoInput.builder()
                            .url("https://static.fastpix.io/fp-sample-video.mp4")
                            .build())))
                    .metadata(Map.ofEntries(
                        Map.entry("key1", "value1")))
                    .build();

            CreateMediaResponse res = sdk.inputVideos().create()
                    .request(req)
                    .call();

            if (res.createMediaSuccessResponse().isPresent()) {
                // handle response
            }
        } catch (FastpixException ex) { // all SDK exceptions inherit from FastpixException

            // ex.toString() provides a detailed error message including
            // HTTP status code, headers, and error payload (if any)
            System.out.println(ex);

            // Base exception fields
            var rawResponse = ex.rawResponse();
            var headers = ex.headers();
            var contentType = headers.getOrDefault("Content-Type", List.of()).stream().findFirst();
            int statusCode = ex.code();
            Optional<byte[]> responseBody = ex.body();
            String bodyAsString = ex.bodyAsString();
        } catch (UncheckedIOException ex) {
            // handle IO error (connection, timeout, etc)
        }
    }
}
```

### Error Classes

**Primary error:**
* [`FastpixException`](./src/main/java/models/errors/FastpixException.java): The base class for HTTP error responses.

<details><summary>Less common errors</summary>

<br />

**Network errors:**
* `java.io.IOException` (always wrapped by `java.io.UncheckedIOException`). Commonly encountered subclasses of
`IOException` include `java.net.ConnectException`, `java.net.SocketTimeoutException`, `EOFException` (there are
many more subclasses in the JDK platform).

**Inherit from [`FastpixException`](./src/main/java/models/errors/FastpixException.java)**:

* Additional error classes may be defined for specific error scenarios.

</details>

## Server Selection

### Override Server URL Per-Client

The default server can be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:

```java
package hello.world;

import java.lang.Exception;
import java.util.List;
import java.util.Map;
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.models.components.*;
import org.openapis.openapi.models.operations.CreateMediaResponse;

public class Application {

    public static void main(String[] args) throws Exception {

        Fastpix sdk = Fastpix.builder()
                .serverURL("https://api.fastpix.io/v1/")
                .security(Security.builder()
                    .username("your-access-token")
                    .password("your-secret-key")
                    .build())
            .build();

        CreateMediaRequest req = CreateMediaRequest.builder()
                .inputs(List.of(
                    Input.of(PullVideoInput.builder()
                        .url("https://static.fastpix.io/fp-sample-video.mp4")
                        .build())))
                .metadata(Map.ofEntries(
                    Map.entry("key1", "value1")))
                .build();

        CreateMediaResponse res = sdk.inputVideos().create()
                .request(req)
                .call();

        if (res.createMediaSuccessResponse().isPresent()) {
            // handle response
        }
    }
}
```

## Custom HTTP Client

The Java SDK makes API calls using an `HTTPClient` that wraps the native
[HttpClient](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html). This
client provides the ability to attach hooks around the request lifecycle that can be used to modify the request or handle
errors and response.

The `HTTPClient` interface allows you to either use the default `FastpixHTTPClient` that comes with the SDK,
or provide your own custom implementation with customized configuration such as custom executors, SSL context,
connection pools, and other HTTP client settings.

The interface provides synchronous (`send`) methods and asynchronous (`sendAsync`) methods. The `sendAsync` method
is used to power the async SDK methods and returns a `CompletableFuture<HttpResponse<Blob>>` for non-blocking operations.

The following example shows how to add a custom header and handle errors:

```java
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.utils.HTTPClient;
import org.openapis.openapi.utils.FastpixHTTPClient;
import org.openapis.openapi.utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;

public class Application {
    public static void main(String[] args) {
        // Create a custom HTTP client with hooks
        HTTPClient httpClient = new HTTPClient() {
            private final HTTPClient defaultClient = new FastpixHTTPClient();
            
            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                // Add custom header and timeout using Utils.copy()
                HttpRequest modifiedRequest = Utils.copy(request)
                    .header("x-custom-header", "custom value")
                    .timeout(Duration.ofSeconds(30))
                    .build();
                    
                try {
                    HttpResponse<InputStream> response = defaultClient.send(modifiedRequest);
                    // Log successful response
                    System.out.println("Request successful: " + response.statusCode());
                    return response;
                } catch (Exception error) {
                    // Log error
                    System.err.println("Request failed: " + error.getMessage());
                    throw error;
                }
            }
        };

        Fastpix sdk = Fastpix.builder()
            .client(httpClient)
            .build();
    }
}
```

<details>
<summary>Custom HTTP Client Configuration</summary>

You can also provide a completely custom HTTP client with your own configuration:

```java
import org.openapis.openapi.Fastpix;
import org.openapis.openapi.utils.HTTPClient;
import org.openapis.openapi.utils.Blob;
import org.openapis.openapi.utils.ResponseWithBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        // Custom HTTP client with custom configuration
        HTTPClient customHttpClient = new HTTPClient() {
            private final HttpClient client = HttpClient.newBuilder()
                .executor(Executors.newFixedThreadPool(10))
                .connectTimeout(Duration.ofSeconds(30))
                // .sslContext(customSslContext) // Add custom SSL context if needed
                .build();

            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                return client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            }

            @Override
            public CompletableFuture<HttpResponse<Blob>> sendAsync(HttpRequest request) {
                // Convert response to HttpResponse<Blob> for async operations
                return client.sendAsync(request, HttpResponse.BodyHandlers.ofPublisher())
                    .thenApply(resp -> new ResponseWithBody<>(resp, Blob::from));
            }
        };

        Fastpix sdk = Fastpix.builder()
            .client(customHttpClient)
            .build();
    }
}
```

</details>

## Debugging

### Debug & Logging

#### SLF4j Logging

This SDK uses [SLF4j](https://www.slf4j.org/) for structured logging across HTTP requests, retries, pagination, streaming, and hooks. SLF4j provides comprehensive visibility into SDK operations.

**Log Levels:**
- **DEBUG**: High-level operations (HTTP requests/responses, retry attempts, page fetches, hook execution, stream lifecycle)
- **TRACE**: Detailed information (request/response bodies, backoff calculations, individual items processed)

**Configuration:**

Add your preferred SLF4j implementation to your project. For example, using Logback:

```gradle
dependencies {
    implementation 'ch.qos.logback:logback-classic:1.4.14'
}
```

Configure logging levels in your `logback.xml`:

```xml
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- SDK-wide logging -->
    <logger name="org.openapis.openapi" level="DEBUG"/>
    
    <!-- Component-specific logging -->
    <logger name="org.openapis.openapi.utils.FastpixHTTPClient" level="DEBUG"/>
    <logger name="org.openapis.openapi.utils.Retries" level="DEBUG"/>
    <logger name="org.openapis.openapi.utils.pagination" level="DEBUG"/>
    <logger name="org.openapis.openapi.utils.Hooks" level="TRACE"/>
    
    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>
```

**What Gets Logged:**
- **HTTP Client**: Request/response details, headers (with sensitive headers redacted), bodies (at TRACE level)
- **Retries**: Retry attempts, backoff delays, exhaustion, non-retryable exceptions
- **Pagination**: Page fetches, pagination state, errors
- **Streaming**: Stream initialization, item processing, closure
- **Hooks**: Hook execution counts, operation IDs, exceptions

#### Legacy Debug Logging

For backward compatibility, you can still use the legacy debug logging method:

```java
Fastpix sdk = Fastpix.builder()
    .enableHTTPDebugLogging(true)
    .build();
```

> [!WARNING]
> Beware that debug logging will reveal secrets, like API tokens in headers, in log messages printed to a console or files. It's recommended to use this feature only during local development and not in production.

Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-fastpix-user-agent=[fastpix-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```

**Note**: Authorization headers are redacted by default. You can specify additional redacted header names via `FastpixHTTPClient.setRedactedHeaders`.

**Note**: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `FastpixHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.

#### JDK HTTP Client Logging

Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this option does not log request/response bodies.

# Development

This Java SDK is programmatically generated from our API specifications. Any manual modifications to internal files will be overwritten during subsequent generation cycles.

We value community contributions and feedback. Feel free to submit pull requests or open issues with your suggestions, and we'll do our best to include them in future releases.

## Detailed Usage

For comprehensive understanding of each API's functionality, including detailed request and response specifications, parameter descriptions, and additional examples, please refer to the [FastPix API Reference](https://docs.fastpix.io/reference/signingkeys-overview).

The API reference offers complete documentation for all available endpoints and features, enabling developers to integrate and leverage FastPix APIs effectively.
