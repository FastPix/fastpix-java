package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.utils.Utils;


public class CreateLiveStreamRequest {

    private static final String PLAYBACK_SETTINGS = "playbackSettings";
    private static final String INPUT_MEDIA_SETTINGS = "inputMediaSettings";

    /**
     * Displays the result of the playback settings.
     */
    @JsonProperty(PLAYBACK_SETTINGS)
    private PlaybackSettings playbackSettings;

    /**
     * Contains configuration details for input media settings.
     */
    @JsonProperty(INPUT_MEDIA_SETTINGS)
    private InputMediaSettings inputMediaSettings;

    @JsonCreator
    public CreateLiveStreamRequest(
            @JsonProperty(PLAYBACK_SETTINGS) @Nonnull PlaybackSettings playbackSettings,
            @JsonProperty(INPUT_MEDIA_SETTINGS) @Nonnull InputMediaSettings inputMediaSettings) {
        this.playbackSettings = Optional.ofNullable(playbackSettings)
            .orElseThrow(() -> new IllegalArgumentException(PLAYBACK_SETTINGS + " cannot be null"));
        this.inputMediaSettings = Optional.ofNullable(inputMediaSettings)
            .orElseThrow(() -> new IllegalArgumentException(INPUT_MEDIA_SETTINGS + " cannot be null"));
    }

    /**
     * Displays the result of the playback settings.
     */
    public PlaybackSettings playbackSettings() {
        return this.playbackSettings;
    }

    /**
     * Contains configuration details for input media settings.
     */
    public InputMediaSettings inputMediaSettings() {
        return this.inputMediaSettings;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Displays the result of the playback settings.
     */
    public CreateLiveStreamRequest withPlaybackSettings(@Nonnull PlaybackSettings playbackSettings) {
        this.playbackSettings = Utils.checkNotNull(playbackSettings, PLAYBACK_SETTINGS);
        return this;
    }


    /**
     * Contains configuration details for input media settings.
     */
    public CreateLiveStreamRequest withInputMediaSettings(@Nonnull InputMediaSettings inputMediaSettings) {
        this.inputMediaSettings = Utils.checkNotNull(inputMediaSettings, INPUT_MEDIA_SETTINGS);
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
        CreateLiveStreamRequest other = (CreateLiveStreamRequest) o;
        return 
            Utils.enhancedDeepEquals(this.playbackSettings, other.playbackSettings) &&
            Utils.enhancedDeepEquals(this.inputMediaSettings, other.inputMediaSettings);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            playbackSettings, inputMediaSettings);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateLiveStreamRequest.class,
                PLAYBACK_SETTINGS, playbackSettings,
                INPUT_MEDIA_SETTINGS, inputMediaSettings);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private PlaybackSettings playbackSettings;

        private InputMediaSettings inputMediaSettings;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Displays the result of the playback settings.
         */
        public Builder playbackSettings(@Nonnull PlaybackSettings playbackSettings) {
            this.playbackSettings = Utils.checkNotNull(playbackSettings, PLAYBACK_SETTINGS);
            return this;
        }

        /**
         * Contains configuration details for input media settings.
         */
        public Builder inputMediaSettings(@Nonnull InputMediaSettings inputMediaSettings) {
            this.inputMediaSettings = Utils.checkNotNull(inputMediaSettings, INPUT_MEDIA_SETTINGS);
            return this;
        }

        public CreateLiveStreamRequest build() {
            return new CreateLiveStreamRequest(
                playbackSettings, inputMediaSettings);
        }

    }
}
