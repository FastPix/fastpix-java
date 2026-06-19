# Changelog

All notable changes to this project will be documented in this file.

---

## [1.0.3]

### Changed

- **SDK version bump: `1.0.2` → `1.0.3`.**
  A maintenance release focused on static-analysis (SonarQube) cleanup. It
  contains no functional, API, or behavioral changes and is fully backward
  compatible with `1.0.2`.

  Version identifiers updated:
  - `version` property in the build configuration — now `1.0.3`.
  - `SDK_VERSION` runtime constant and the installation documentation — now
    aligned with the package version `1.0.3`.

- **Static-analysis cleanup (non-behavioral).** Resolved a broad set of
  SonarQube findings across the SDK utilities, operations, and models:
  - **Exception specificity** — generic `RuntimeException` throws in the
    request-serialization path replaced with intent-revealing types
    (`IllegalStateException` for missing metadata, `IllegalArgumentException`
    for unsupported or invalid content). The thrown conditions are unchanged.
  - **Idiomatic cleanups** — `collection.size() > 0` replaced with
    `!collection.isEmpty()`; eligible lambdas replaced with method references;
    single-branch `switch` statements converted to `if` expressions; explicit
    `default` cases added.
  - **Code structure** — removed unused private methods, fields, imports, and
    redundant constructors; extracted duplicated string literals into named
    constants; merged collapsible conditionals; dropped redundant control flow.
  - **Contract alignment** — `FastpixException.withBody(...)` no longer
    annotates its parameter as `@Nullable`, matching the method's existing
    runtime contract (it already rejects `null` via `Utils.checkNotNull`).
  - **Intentional patterns documented** — deliberate uses of reflection-based
    field access, established serialization branching, and the SDK-controlled
    media-type regex annotated with targeted `@SuppressWarnings` and
    explanatory comments rather than restructuring proven code. The JSON
    content-type matching pattern is unchanged.

### Compatibility

- No changes to public types, method signatures, request/response models,
  default server URLs, hooks, or retry logic.
- No action required to upgrade beyond re-resolving the dependency.

---

## [1.0.2]

### ⚠️ Important — FastPix is migrating from `.io` to `.com`

FastPix hosts and documentation links are moving to the `.com` TLD. This release updates every reference the SDK ships:

| Old (`.io`) | New (`.com`) |
|---|---|
| `api.fastpix.io` | `api.fastpix.com` |
| `stream.fastpix.io` | `stream.fastpix.com` |
| `images.fastpix.io` | `images.fastpix.com` |
| `static.fastpix.io` | `static.fastpix.com` |
| `docs.fastpix.io/...` | `fastpix.com/docs/...` |

The `.io` hosts continue to serve traffic during the transition, but **they are slated for deprecation soon** — please update any hard-coded references in your application. We recommend upgrading to this release (or later).

What this means for users of `io.fastpix:sdk`:

- **If you rely on SDK defaults**, no code change is required. The default server URL is now `https://api.fastpix.com/v1/`, so bumping to `1.0.2` and re-resolving the dependency (`./gradlew build` / `mvn`) is enough.
- **If you have an explicit `serverURL` override** (e.g. `FastPixSDK.builder().serverURL("https://api.fastpix.io/v1/").build()`), change it to `https://api.fastpix.com/v1/`.
- **If you reference FastPix asset URLs directly** in your app (HLS playback URLs, image CDN), update those to the `.com` equivalents before `.io` is decommissioned.

### Fixed

- `manageVideos().list()` (`/on-demand`): tracks now include `frameRate` (on `VideoTrackForGetAll`), which was being silently dropped by the previous SDK build.
- `signingKeys().delete()` (`/iam/signing-keys/{signingKeyId}`): response now includes the optional `data.message` confirmation string the API returns (on `DeleteSigningKeyResponse`).

### Changed

- The `User-Agent` sent by the SDK no longer includes the code-generator version; it now reports `fastpix-sdk/java 1.0.2 ...`.

### Docs

- All README and per-service documentation links updated from `docs.fastpix.io/...` to the new `https://fastpix.com/docs/...` URL structure.

## [1.0.1]

### Added
- `ViewEventMapper` utility class (`io.fastpix.sdk.utils`) that maps a `Views` response into a flat JSON structure matching the FastPix API response format: `{ "success": true, "data": { ...all 122 fields..., "events": [...] } }`.
- `EventDeserializer` (inner class of `ViewEventMapper`) — a custom `JsonDeserializer<Event>` that correctly reads the API's abbreviated wire-format keys for player events (`"pt"` → `playerPlayheadTime`, `"e"` → `eventName`, `"vt"` → `viewerTime`, `"d"` → `eventDetails`), resolving silent null deserialization caused by the mismatch between the auto-generated `Event` model's snake_case `@JsonProperty` names and the API's actual wire format.
- `expandDetails()` method to expand abbreviated `eventDetails` field keys (`"host"` → `hostName`, `"br"` → `bitrate`, `"h"` → `height`, `"cd"` → `codec`, `"w"` → `width`, `"txt"` → `text`, `"u"` → `url`, `"err"` → `error`, `"t"` → `type`) with correct integer/double type handling.
- `registerEventDeserializer()` method on `ViewEventMapper` — registers the custom `Event` deserializer with the shared Jackson `ObjectMapper`.
- `numVal()` helper on `ViewEventMapper` — returns `Long` for whole-number doubles (e.g. `1.0` → `1`, `2550448.0` → `2550448`) to match the API's integer representation for integral-valued fields.
- `VideoViewDetailsExample` in `test-example` — demonstrates calling `sdk.views().getDetails()` and printing the event-mapped response via `ViewEventMapper.map(v)`.

### Changed
- `SDKHooks.initialize(Hooks)` now calls `ViewEventMapper.registerEventDeserializer()` during SDK construction (`FastPixSDK.builder().build()`), ensuring the custom `Event` deserializer is active before any API response is deserialized.
- `test-example/build.gradle` updated: `mainClass` changed to `VideoViewDetailsExample`, SDK dependency bumped to `1.0.1`.

### Fixed
- Player events (`events` array in `GetVideoViewDetails` response) were silently returning all-null fields due to a mismatch between the SDK `Event` model's `@JsonProperty` snake_case names and the API's abbreviated camelCase wire format. Fixed via a custom `EventDeserializer` registered at SDK initialization.
- `fps` field in `variantChanged` event details serialized as `24.0` (double) instead of `24` (integer) due to Java's ternary-operator long→double promotion when assigning to `Object`. Fixed by using explicit `if/else` with `Long.valueOf()`.
- Several numeric fields (`playbackScore`, `stabilityScore`, `renderQualityScore`, `averageBitrate`, `avgRequestLatency`, `bufferFrequency`, etc.) serialized with unnecessary `.0` suffix. Fixed by `numVal()` coercing whole-number doubles to `Long` before serialization.
- `playerSourceHeight` and `playerSourceWidth` were incorrectly keyed as `videoSourceHeight`/`videoSourceWidth` in the response map.
- Missing fields added to response map: `custom`, `propertyId`, `playerPoster`, `playerSourceDomain`.
- `eventDetails` no longer included in event entries when `null`, matching API behaviour.

---

## [1.0.0] 

**Major Version Release**


### Fixed
- Fixed missing request parameters in Java API method signatures.
- Improved Java type safety with accurate generic type parameters and Optional handling.
- Improved Maven/Gradle publishing configuration with consistent artifact naming and POM metadata.

## [0.1.1]

### Added
- Complete API coverage for Media, Live Streaming, Video Data, and Signing Keys
- Java 11+ support with comprehensive type safety
- Media upload, management, and processing capabilities
- Live streaming with simulcasting support
- Video analytics and performance tracking
- Cryptographic signing keys for secure authentication
- In-video AI processing features
- DRM configuration and management
- Playlist creation and management
- Comprehensive error handling with specific exception types
- Built-in retry mechanisms and timeout handling
- Asynchronous client support with CompletableFuture
- Reactive Streams integration for streaming operations
- Spring Boot auto-configuration and starter modules
- Custom HTTP client support with hooks
- SLF4j logging integration
- Full API specification compliance

### Changed
- Reorganized package structure for better maintainability
- Updated dependencies to modern Java libraries (Jackson, SLF4j, Reactive Streams)
- Improved API design with better error handling
- Enhanced documentation and examples
- Updated SDK version to 1.0.0
- Updated minimum Java version requirement to 11+ for better compatibility and performance

### Fixed
- Direct upload metadata handling
- Response object access patterns
- Type mismatches in method parameters
- Error handling for validation responses
- Improved error handling with specific exception types
- Fixed type annotation issues for better IDE support
- Ensured consistent API patterns across modules

---

## [0.0.1]

### Added
- Initial release of FastPix Java SDK
- Synchronous client support with Java HTTP Client
- Media API integration with upload, management, and processing
- Playback ID management for media files
- Media operations (list, get, update, delete)
- Direct upload support for video files
- Live stream API integration
- Live stream management (create, update, delete)
- Playback ID management for live streams
- Simulcast configuration for live streams
- HTTP Basic authentication support
- Server URL override support
- Comprehensive error handling and custom error classes
- Example usage and quick start documentation
- Maven and Gradle build support
- Jackson JSON serialization integration

---
