package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.models.components.TrackSubtitlesGenerateRequest;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class GenerateSubtitleTrackRequest {

    private static final String MEDIA_ID = "mediaId";
    private static final String TRACK_ID = "trackId";
    private static final String BODY_NAME = "body";
    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=mediaId")
    private String mediaId;

    /**
     * A universally unique identifier (UUID) assigned to the specific track for which subtitles must be
     * generated.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=trackId")
    private String trackId;


    @FastpixMetadata("request:mediaType=application/json")
    private TrackSubtitlesGenerateRequest body;

    @JsonCreator
    public GenerateSubtitleTrackRequest(
            @Nonnull String mediaId,
            @Nonnull String trackId,
            @Nonnull TrackSubtitlesGenerateRequest body) {
        this.mediaId = Optional.ofNullable(mediaId)
            .orElseThrow(() -> new IllegalArgumentException("mediaId cannot be null"));
        this.trackId = Optional.ofNullable(trackId)
            .orElseThrow(() -> new IllegalArgumentException("trackId cannot be null"));
        this.body = Optional.ofNullable(body)
            .orElseThrow(() -> new IllegalArgumentException("body cannot be null"));
    }

    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public String mediaId() {
        return this.mediaId;
    }

    /**
     * A universally unique identifier (UUID) assigned to the specific track for which subtitles must be
     * generated.
     */
    public String trackId() {
        return this.trackId;
    }

    public TrackSubtitlesGenerateRequest body() {
        return this.body;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public GenerateSubtitleTrackRequest withMediaId(@Nonnull String mediaId) {
        this.mediaId = Utils.checkNotNull(mediaId, MEDIA_ID);
        return this;
    }


    /**
     * A universally unique identifier (UUID) assigned to the specific track for which subtitles must be
     * generated.
     */
    public GenerateSubtitleTrackRequest withTrackId(@Nonnull String trackId) {
        this.trackId = Utils.checkNotNull(trackId, TRACK_ID);
        return this;
    }


    public GenerateSubtitleTrackRequest withBody(@Nonnull TrackSubtitlesGenerateRequest body) {
        this.body = Utils.checkNotNull(body, BODY_NAME);
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
        GenerateSubtitleTrackRequest other = (GenerateSubtitleTrackRequest) o;
        return 
            Utils.enhancedDeepEquals(this.mediaId, other.mediaId) &&
            Utils.enhancedDeepEquals(this.trackId, other.trackId) &&
            Utils.enhancedDeepEquals(this.body, other.body);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            mediaId, trackId, body);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GenerateSubtitleTrackRequest.class,
                MEDIA_ID, mediaId,
                TRACK_ID, trackId,
                BODY_NAME, body);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String mediaId;

        private String trackId;

        private TrackSubtitlesGenerateRequest body;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * The unique identifier assigned to the media when created. The value must be a valid UUID.
         */
        public Builder mediaId(@Nonnull String mediaId) {
            this.mediaId = Utils.checkNotNull(mediaId, MEDIA_ID);
            return this;
        }

        /**
         * A universally unique identifier (UUID) assigned to the specific track for which subtitles must be
         * generated.
         */
        public Builder trackId(@Nonnull String trackId) {
            this.trackId = Utils.checkNotNull(trackId, TRACK_ID);
            return this;
        }

        public Builder body(@Nonnull TrackSubtitlesGenerateRequest body) {
            this.body = Utils.checkNotNull(body, BODY_NAME);
            return this;
        }

        public GenerateSubtitleTrackRequest build() {
            return new GenerateSubtitleTrackRequest(
                mediaId, trackId, body);
        }

    }
}
