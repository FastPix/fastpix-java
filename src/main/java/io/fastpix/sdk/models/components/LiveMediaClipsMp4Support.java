package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import java.util.Optional;
import io.fastpix.sdk.utils.Utils;

/**
 * LiveMediaClipsMp4Support
 *
 * <p>One downloadable MP4 rendition generated for the media, along with its generation status.
 */
public class LiveMediaClipsMp4Support {
    /**
     * The MP4 rendition type. `capped_4k` is a downloadable MP4 video capped at 4K resolution,
     * `audioOnly` is a downloadable m4a audio-only file.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("type")
    private LiveMediaClipsMp4SupportType type;

    /**
     * Generation status of this MP4 rendition.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("status")
    private LiveMediaClipsMp4SupportStatus status;

    /**
     * Pixel height of the rendition. Omitted for the `audioOnly` type.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("height")
    private Long height;

    /**
     * Pixel width of the rendition. Omitted for the `audioOnly` type.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("width")
    private Long width;

    /**
     * File extension of the downloadable rendition.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("ext")
    private LiveMediaClipsMp4SupportExt ext;

    @JsonCreator
    public LiveMediaClipsMp4Support(
            @JsonProperty("type") @Nullable LiveMediaClipsMp4SupportType type,
            @JsonProperty("status") @Nullable LiveMediaClipsMp4SupportStatus status,
            @JsonProperty("height") @Nullable Long height,
            @JsonProperty("width") @Nullable Long width,
            @JsonProperty("ext") @Nullable LiveMediaClipsMp4SupportExt ext) {
        this.type = type;
        this.status = status;
        this.height = height;
        this.width = width;
        this.ext = ext;
    }

    public LiveMediaClipsMp4Support() {
        this(null, null, null,
            null, null);
    }

    /**
     * The MP4 rendition type. `capped_4k` is a downloadable MP4 video capped at 4K resolution,
     * `audioOnly` is a downloadable m4a audio-only file.
     */
    public Optional<LiveMediaClipsMp4SupportType> type() {
        return Optional.ofNullable(this.type);
    }

    /**
     * Generation status of this MP4 rendition.
     */
    public Optional<LiveMediaClipsMp4SupportStatus> status() {
        return Optional.ofNullable(this.status);
    }

    /**
     * Pixel height of the rendition. Omitted for the `audioOnly` type.
     */
    public Optional<Long> height() {
        return Optional.ofNullable(this.height);
    }

    /**
     * Pixel width of the rendition. Omitted for the `audioOnly` type.
     */
    public Optional<Long> width() {
        return Optional.ofNullable(this.width);
    }

    /**
     * File extension of the downloadable rendition.
     */
    public Optional<LiveMediaClipsMp4SupportExt> ext() {
        return Optional.ofNullable(this.ext);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The MP4 rendition type. `capped_4k` is a downloadable MP4 video capped at 4K resolution,
     * `audioOnly` is a downloadable m4a audio-only file.
     */
    public LiveMediaClipsMp4Support withType(@Nullable LiveMediaClipsMp4SupportType type) {
        this.type = type;
        return this;
    }


    /**
     * Generation status of this MP4 rendition.
     */
    public LiveMediaClipsMp4Support withStatus(@Nullable LiveMediaClipsMp4SupportStatus status) {
        this.status = status;
        return this;
    }


    /**
     * Pixel height of the rendition. Omitted for the `audioOnly` type.
     */
    public LiveMediaClipsMp4Support withHeight(@Nullable Long height) {
        this.height = height;
        return this;
    }


    /**
     * Pixel width of the rendition. Omitted for the `audioOnly` type.
     */
    public LiveMediaClipsMp4Support withWidth(@Nullable Long width) {
        this.width = width;
        return this;
    }


    /**
     * File extension of the downloadable rendition.
     */
    public LiveMediaClipsMp4Support withExt(@Nullable LiveMediaClipsMp4SupportExt ext) {
        this.ext = ext;
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
        LiveMediaClipsMp4Support other = (LiveMediaClipsMp4Support) o;
        return
            Utils.enhancedDeepEquals(this.type, other.type) &&
            Utils.enhancedDeepEquals(this.status, other.status) &&
            Utils.enhancedDeepEquals(this.height, other.height) &&
            Utils.enhancedDeepEquals(this.width, other.width) &&
            Utils.enhancedDeepEquals(this.ext, other.ext);
    }

    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            type, status, height,
            width, ext);
    }

    @Override
    public String toString() {
        return Utils.toString(LiveMediaClipsMp4Support.class,
                "type", type,
                "status", status,
                "height", height,
                "width", width,
                "ext", ext);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private LiveMediaClipsMp4SupportType type;

        private LiveMediaClipsMp4SupportStatus status;

        private Long height;

        private Long width;

        private LiveMediaClipsMp4SupportExt ext;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * The MP4 rendition type. `capped_4k` is a downloadable MP4 video capped at 4K resolution,
         * `audioOnly` is a downloadable m4a audio-only file.
         */
        public Builder type(@Nullable LiveMediaClipsMp4SupportType type) {
            this.type = type;
            return this;
        }

        /**
         * Generation status of this MP4 rendition.
         */
        public Builder status(@Nullable LiveMediaClipsMp4SupportStatus status) {
            this.status = status;
            return this;
        }

        /**
         * Pixel height of the rendition. Omitted for the `audioOnly` type.
         */
        public Builder height(@Nullable Long height) {
            this.height = height;
            return this;
        }

        /**
         * Pixel width of the rendition. Omitted for the `audioOnly` type.
         */
        public Builder width(@Nullable Long width) {
            this.width = width;
            return this;
        }

        /**
         * File extension of the downloadable rendition.
         */
        public Builder ext(@Nullable LiveMediaClipsMp4SupportExt ext) {
            this.ext = ext;
            return this;
        }

        public LiveMediaClipsMp4Support build() {
            return new LiveMediaClipsMp4Support(
                type, status, height,
                width, ext);
        }
    }
}
