# Changelog

All notable changes to this project will be documented in this file.

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
