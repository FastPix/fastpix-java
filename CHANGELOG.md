# Changelog

All notable changes to this project will be documented in this file.

---

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
