package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import java.util.Optional;
import io.fastpix.sdk.utils.Utils;

/**
 * VideoTrack
 * 
 * <p>A media consists of different media tracks, like video, audio, and subtitle, all combined.
 */
public class VideoTrack {
    /**
     * FastPix generates a unique identifier for each track.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    private String id;

    /**
     * Defines the type of input. This option is mandatory.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("type")
    private String type;

    /**
     * Track width denotes the range of widths applicable to a specific track. Currently, this setting can
     * be modified only for video tracks
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("width")
    private Long width;

    /**
     * Track height denotes the range of height applicable to a specific track. Currently, this setting can
     * be modified only for video tracks.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("height")
    private Long height;

    /**
     * Frame rate quantifies the speed at which frames are displayed per second. It represents the range of
     * frames available for a specific track. The indeterminable frame rate of the input file is indicated
     * by a value of -1.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("frameRate")
    private String frameRate;

    /**
     * Indicates the current state of the track. 'available' means the track has been processed
     * successfully and is ready to be used or played.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("status")
    private String status;

    /**
     * Title of the track.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("title")
    private String title;

    @JsonCreator
    public VideoTrack(
            @JsonProperty("id") @Nullable String id,
            @JsonProperty("type") @Nullable String type,
            @JsonProperty("width") @Nullable Long width,
            @JsonProperty("height") @Nullable Long height,
            @JsonProperty("frameRate") @Nullable String frameRate,
            @JsonProperty("status") @Nullable String status,
            @JsonProperty("title") @Nullable String title) {
        this.id = id;
        this.type = type;
        this.width = width;
        this.height = height;
        this.frameRate = frameRate;
        this.status = status;
        this.title = title;
    }
    
    public VideoTrack() {
        this(null, null, null,
            null, null, null, null);
    }

    /**
     * FastPix generates a unique identifier for each track.
     */
    public Optional<String> id() {
        return Optional.ofNullable(this.id);
    }

    /**
     * Defines the type of input. This option is mandatory.
     */
    public Optional<String> type() {
        return Optional.ofNullable(this.type);
    }

    /**
     * Track width denotes the range of widths applicable to a specific track. Currently, this setting can
     * be modified only for video tracks
     */
    public Optional<Long> width() {
        return Optional.ofNullable(this.width);
    }

    /**
     * Track height denotes the range of height applicable to a specific track. Currently, this setting can
     * be modified only for video tracks.
     */
    public Optional<Long> height() {
        return Optional.ofNullable(this.height);
    }

    /**
     * Frame rate quantifies the speed at which frames are displayed per second. It represents the range of
     * frames available for a specific track. The indeterminable frame rate of the input file is indicated
     * by a value of -1.
     */
    public Optional<String> frameRate() {
        return Optional.ofNullable(this.frameRate);
    }

    /**
     * Indicates the current state of the track. 'available' means the track has been processed
     * successfully and is ready to be used or played.
     */
    public Optional<String> status() {
        return Optional.ofNullable(this.status);
    }

    /**
     * Title of the track.
     */
    public Optional<String> title() {
        return Optional.ofNullable(this.title);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * FastPix generates a unique identifier for each track.
     */
    public VideoTrack withId(@Nullable String id) {
        this.id = id;
        return this;
    }


    /**
     * Defines the type of input. This option is mandatory.
     */
    public VideoTrack withType(@Nullable String type) {
        this.type = type;
        return this;
    }


    /**
     * Track width denotes the range of widths applicable to a specific track. Currently, this setting can
     * be modified only for video tracks
     */
    public VideoTrack withWidth(@Nullable Long width) {
        this.width = width;
        return this;
    }


    /**
     * Track height denotes the range of height applicable to a specific track. Currently, this setting can
     * be modified only for video tracks.
     */
    public VideoTrack withHeight(@Nullable Long height) {
        this.height = height;
        return this;
    }


    /**
     * Frame rate quantifies the speed at which frames are displayed per second. It represents the range of
     * frames available for a specific track. The indeterminable frame rate of the input file is indicated
     * by a value of -1.
     */
    public VideoTrack withFrameRate(@Nullable String frameRate) {
        this.frameRate = frameRate;
        return this;
    }


    /**
     * Indicates the current state of the track. 'available' means the track has been processed
     * successfully and is ready to be used or played.
     */
    public VideoTrack withStatus(@Nullable String status) {
        this.status = status;
        return this;
    }


    /**
     * Title of the track.
     */
    public VideoTrack withTitle(@Nullable String title) {
        this.title = title;
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
        VideoTrack other = (VideoTrack) o;
        return 
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.type, other.type) &&
            Utils.enhancedDeepEquals(this.width, other.width) &&
            Utils.enhancedDeepEquals(this.height, other.height) &&
            Utils.enhancedDeepEquals(this.frameRate, other.frameRate) &&
            Utils.enhancedDeepEquals(this.status, other.status) &&
            Utils.enhancedDeepEquals(this.title, other.title);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            id, type, width,
            height, frameRate, status, title);
    }
    
    @Override
    public String toString() {
        return Utils.toString(VideoTrack.class,
                "id", id,
                "type", type,
                "width", width,
                "height", height,
                "frameRate", frameRate,
                "status", status,
                "title", title);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String id;

        private String type;

        private Long width;

        private Long height;

        private String frameRate;

        private String status;

        private String title;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * FastPix generates a unique identifier for each track.
         */
        public Builder id(@Nullable String id) {
            this.id = id;
            return this;
        }

        /**
         * Defines the type of input. This option is mandatory.
         */
        public Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        /**
         * Track width denotes the range of widths applicable to a specific track. Currently, this setting can
         * be modified only for video tracks
         */
        public Builder width(@Nullable Long width) {
            this.width = width;
            return this;
        }

        /**
         * Track height denotes the range of height applicable to a specific track. Currently, this setting can
         * be modified only for video tracks.
         */
        public Builder height(@Nullable Long height) {
            this.height = height;
            return this;
        }

        /**
         * Frame rate quantifies the speed at which frames are displayed per second. It represents the range of
         * frames available for a specific track. The indeterminable frame rate of the input file is indicated
         * by a value of -1.
         */
        public Builder frameRate(@Nullable String frameRate) {
            this.frameRate = frameRate;
            return this;
        }

        /**
         * Indicates the current state of the track. 'available' means the track has been processed
         * successfully and is ready to be used or played.
         */
        public Builder status(@Nullable String status) {
            this.status = status;
            return this;
        }

        /**
         * Title of the track.
         */
        public Builder title(@Nullable String title) {
            this.title = title;
            return this;
        }

        public VideoTrack build() {
            return new VideoTrack(
                id, type, width,
                height, frameRate, status, title);
        }

    }
}
