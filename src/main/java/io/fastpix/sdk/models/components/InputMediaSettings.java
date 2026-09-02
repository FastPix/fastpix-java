package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.Nullable;
import java.util.Map;
import java.util.Optional;
import io.fastpix.sdk.utils.LazySingletonValue;
import io.fastpix.sdk.utils.Utils;

/**
 * InputMediaSettings
 * 
 * <p>Contains configuration details for input media settings.
 */
public class InputMediaSettings {
    /**
     * Defines the maximum resolution for encoding, storage, and playback of the live stream.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("maxResolution")
    private CreateLiveStreamRequestMaxResolution maxResolution;

    /**
     * Time period (in seconds) FastPix waits to reconnect before ending the stream when disconnected.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("reconnectWindow")
    private Long reconnectWindow;

    /**
     * Basic access policy for media content
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("mediaPolicy")
    private BasicAccessPolicy mediaPolicy;

    /**
     * Custom key–value pairs for tagging livestreams.
     * Allows up to 10 entries with a maximum of 255 characters each.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("metadata")
    private Map<String, String> metadata;

    /**
     * Enables DVR (Digital Video Recorder) functionality, allowing viewers to pause, rewind, and resume
     * live playback.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("enableDvrMode")
    private Boolean enableDvrMode;

    /**
     * Controls whether the livestream is recorded to a VOD asset (Live-to-VOD). Defaults to true.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("enableRecording")
    private Boolean enableRecording;

    @JsonCreator
    public InputMediaSettings(
            @JsonProperty("maxResolution") @Nullable CreateLiveStreamRequestMaxResolution maxResolution,
            @JsonProperty("reconnectWindow") @Nullable Long reconnectWindow,
            @JsonProperty("mediaPolicy") @Nullable BasicAccessPolicy mediaPolicy,
            @JsonProperty("metadata") @Nullable Map<String, String> metadata,
            @JsonProperty("enableDvrMode") @Nullable Boolean enableDvrMode,
            @JsonProperty("enableRecording") @Nullable Boolean enableRecording) {
        this.maxResolution = Optional.ofNullable(maxResolution)
            .orElse(Builder._SINGLETON_VALUE_MaxResolution.value());
        this.reconnectWindow = Optional.ofNullable(reconnectWindow)
            .orElse(Builder._SINGLETON_VALUE_ReconnectWindow.value());
        this.mediaPolicy = Optional.ofNullable(mediaPolicy)
            .orElse(Builder._SINGLETON_VALUE_MediaPolicy.value());
        this.metadata = metadata;
        this.enableDvrMode = enableDvrMode;
        this.enableRecording = enableRecording;
    }
    
    public InputMediaSettings() {
        this(null, null, null,
            null, null, null);
    }

    /**
     * Defines the maximum resolution for encoding, storage, and playback of the live stream.
     */
    public Optional<CreateLiveStreamRequestMaxResolution> maxResolution() {
        return Optional.ofNullable(this.maxResolution);
    }

    /**
     * Time period (in seconds) FastPix waits to reconnect before ending the stream when disconnected.
     */
    public Optional<Long> reconnectWindow() {
        return Optional.ofNullable(this.reconnectWindow);
    }

    /**
     * Basic access policy for media content
     */
    public Optional<BasicAccessPolicy> mediaPolicy() {
        return Optional.ofNullable(this.mediaPolicy);
    }

    /**
     * Custom key–value pairs for tagging livestreams.
     * Allows up to 10 entries with a maximum of 255 characters each.
     */
    public Optional<Map<String, String>> metadata() {
        return Optional.ofNullable(this.metadata);
    }

    /**
     * Enables DVR (Digital Video Recorder) functionality, allowing viewers to pause, rewind, and resume
     * live playback.
     */
    public Optional<Boolean> enableDvrMode() {
        return Optional.ofNullable(this.enableDvrMode);
    }

    /**
     * Controls whether the livestream is recorded to a VOD asset (Live-to-VOD). Defaults to true.
     */
    public Optional<Boolean> enableRecording() {
        return Optional.ofNullable(this.enableRecording);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Defines the maximum resolution for encoding, storage, and playback of the live stream.
     */
    public InputMediaSettings withMaxResolution(@Nullable CreateLiveStreamRequestMaxResolution maxResolution) {
        this.maxResolution = maxResolution;
        return this;
    }


    /**
     * Time period (in seconds) FastPix waits to reconnect before ending the stream when disconnected.
     */
    public InputMediaSettings withReconnectWindow(@Nullable Long reconnectWindow) {
        this.reconnectWindow = reconnectWindow;
        return this;
    }


    /**
     * Basic access policy for media content
     */
    public InputMediaSettings withMediaPolicy(@Nullable BasicAccessPolicy mediaPolicy) {
        this.mediaPolicy = mediaPolicy;
        return this;
    }


    /**
     * Custom key–value pairs for tagging livestreams.
     * Allows up to 10 entries with a maximum of 255 characters each.
     */
    public InputMediaSettings withMetadata(@Nullable Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }


    /**
     * Enables DVR (Digital Video Recorder) functionality, allowing viewers to pause, rewind, and resume
     * live playback.
     */
    public InputMediaSettings withEnableDvrMode(@Nullable Boolean enableDvrMode) {
        this.enableDvrMode = enableDvrMode;
        return this;
    }


    /**
     * Controls whether the livestream is recorded to a VOD asset (Live-to-VOD). Defaults to true.
     */
    public InputMediaSettings withEnableRecording(@Nullable Boolean enableRecording) {
        this.enableRecording = enableRecording;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InputMediaSettings other = (InputMediaSettings) o;
        return 
            Utils.enhancedDeepEquals(this.maxResolution, other.maxResolution) &&
            Utils.enhancedDeepEquals(this.reconnectWindow, other.reconnectWindow) &&
            Utils.enhancedDeepEquals(this.mediaPolicy, other.mediaPolicy) &&
            Utils.enhancedDeepEquals(this.metadata, other.metadata) &&
            Utils.enhancedDeepEquals(this.enableDvrMode, other.enableDvrMode) &&
            Utils.enhancedDeepEquals(this.enableRecording, other.enableRecording);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            maxResolution, reconnectWindow, mediaPolicy,
            metadata, enableDvrMode, enableRecording);
    }
    
    @Override
    public String toString() {
        return Utils.toString(InputMediaSettings.class,
                "maxResolution", maxResolution,
                "reconnectWindow", reconnectWindow,
                "mediaPolicy", mediaPolicy,
                "metadata", metadata,
                "enableDvrMode", enableDvrMode,
                "enableRecording", enableRecording);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private CreateLiveStreamRequestMaxResolution maxResolution;

        private Long reconnectWindow;

        private BasicAccessPolicy mediaPolicy;

        private Map<String, String> metadata;

        private Boolean enableDvrMode;

        private Boolean enableRecording;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Defines the maximum resolution for encoding, storage, and playback of the live stream.
         */
        public Builder maxResolution(@Nullable CreateLiveStreamRequestMaxResolution maxResolution) {
            this.maxResolution = maxResolution;
            return this;
        }

        /**
         * Time period (in seconds) FastPix waits to reconnect before ending the stream when disconnected.
         */
        public Builder reconnectWindow(@Nullable Long reconnectWindow) {
            this.reconnectWindow = reconnectWindow;
            return this;
        }

        /**
         * Basic access policy for media content
         */
        public Builder mediaPolicy(@Nullable BasicAccessPolicy mediaPolicy) {
            this.mediaPolicy = mediaPolicy;
            return this;
        }

        /**
         * Custom key–value pairs for tagging livestreams.
         * Allows up to 10 entries with a maximum of 255 characters each.
         */
        public Builder metadata(@Nullable Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Enables DVR (Digital Video Recorder) functionality, allowing viewers to pause, rewind, and resume
         * live playback.
         */
        public Builder enableDvrMode(@Nullable Boolean enableDvrMode) {
            this.enableDvrMode = enableDvrMode;
            return this;
        }

        /**
         * Controls whether the livestream is recorded to a VOD asset (Live-to-VOD). Defaults to true.
         */
        public Builder enableRecording(@Nullable Boolean enableRecording) {
            this.enableRecording = enableRecording;
            return this;
        }

        public InputMediaSettings build() {
            return new InputMediaSettings(
                maxResolution, reconnectWindow, mediaPolicy,
                metadata, enableDvrMode, enableRecording);
        }


        private static final LazySingletonValue<CreateLiveStreamRequestMaxResolution> _SINGLETON_VALUE_MaxResolution =
                new LazySingletonValue<>(
                        "maxResolution",
                        "\"1080p\"",
                        new TypeReference<CreateLiveStreamRequestMaxResolution>() {});

        private static final LazySingletonValue<Long> _SINGLETON_VALUE_ReconnectWindow =
                new LazySingletonValue<>(
                        "reconnectWindow",
                        "60",
                        new TypeReference<Long>() {});

        private static final LazySingletonValue<BasicAccessPolicy> _SINGLETON_VALUE_MediaPolicy =
                new LazySingletonValue<>(
                        "mediaPolicy",
                        "\"public\"",
                        new TypeReference<BasicAccessPolicy>() {});
    }
}
