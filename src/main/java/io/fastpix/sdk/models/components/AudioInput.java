package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import io.fastpix.sdk.utils.Utils;


public class AudioInput {

    private static final String SWAP_TRACK_URL = "swapTrackUrl";

    /**
     * Type of overlay (currently only supports "audio").
     */
    @JsonProperty("type")
    private AudioInputType type;

    /**
     * URL of the audio track to replace the existing audio in the video.
     */
    @JsonProperty(SWAP_TRACK_URL)
    private String swapTrackUrl;

    /**
     * List of additional audio tracks to overlay on the video.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("imposeTracks")
    private List<ImposeTrack> imposeTracks;

    @JsonCreator
    public AudioInput(
            @JsonProperty("type") @Nonnull AudioInputType type,
            @JsonProperty(SWAP_TRACK_URL) @Nonnull String swapTrackUrl,
            @JsonProperty("imposeTracks") @Nullable List<ImposeTrack> imposeTracks) {
        this.type = Optional.ofNullable(type)
            .orElseThrow(() -> new IllegalArgumentException("type cannot be null"));
        this.swapTrackUrl = Optional.ofNullable(swapTrackUrl)
            .orElseThrow(() -> new IllegalArgumentException("swapTrackUrl cannot be null"));
        this.imposeTracks = imposeTracks;
    }
    
    public AudioInput(
            @Nonnull AudioInputType type,
            @Nonnull String swapTrackUrl) {
        this(type, swapTrackUrl, null);
    }

    /**
     * Type of overlay (currently only supports "audio").
     */
    public AudioInputType type() {
        return this.type;
    }

    /**
     * URL of the audio track to replace the existing audio in the video.
     */
    public String swapTrackUrl() {
        return this.swapTrackUrl;
    }

    /**
     * List of additional audio tracks to overlay on the video.
     */
    public Optional<List<ImposeTrack>> imposeTracks() {
        return Optional.ofNullable(this.imposeTracks);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Type of overlay (currently only supports "audio").
     */
    public AudioInput withType(@Nonnull AudioInputType type) {
        this.type = Utils.checkNotNull(type, "type");
        return this;
    }


    /**
     * URL of the audio track to replace the existing audio in the video.
     */
    public AudioInput withSwapTrackUrl(@Nonnull String swapTrackUrl) {
        this.swapTrackUrl = Utils.checkNotNull(swapTrackUrl, SWAP_TRACK_URL);
        return this;
    }


    /**
     * List of additional audio tracks to overlay on the video.
     */
    public AudioInput withImposeTracks(@Nullable List<ImposeTrack> imposeTracks) {
        this.imposeTracks = imposeTracks;
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
        AudioInput other = (AudioInput) o;
        return 
            Utils.enhancedDeepEquals(this.type, other.type) &&
            Utils.enhancedDeepEquals(this.swapTrackUrl, other.swapTrackUrl) &&
            Utils.enhancedDeepEquals(this.imposeTracks, other.imposeTracks);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            type, swapTrackUrl, imposeTracks);
    }
    
    @Override
    public String toString() {
        return Utils.toString(AudioInput.class,
                "type", type,
                SWAP_TRACK_URL, swapTrackUrl,
                "imposeTracks", imposeTracks);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private AudioInputType type;

        private String swapTrackUrl;

        private List<ImposeTrack> imposeTracks;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Type of overlay (currently only supports "audio").
         */
        public Builder type(@Nonnull AudioInputType type) {
            this.type = Utils.checkNotNull(type, "type");
            return this;
        }

        /**
         * URL of the audio track to replace the existing audio in the video.
         */
        public Builder swapTrackUrl(@Nonnull String swapTrackUrl) {
            this.swapTrackUrl = Utils.checkNotNull(swapTrackUrl, SWAP_TRACK_URL);
            return this;
        }

        /**
         * List of additional audio tracks to overlay on the video.
         */
        public Builder imposeTracks(@Nullable List<ImposeTrack> imposeTracks) {
            this.imposeTracks = imposeTracks;
            return this;
        }

        public AudioInput build() {
            return new AudioInput(
                type, swapTrackUrl, imposeTracks);
        }

    }
}
