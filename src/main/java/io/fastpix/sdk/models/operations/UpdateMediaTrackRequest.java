package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.models.components.UpdateTrackRequest;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class UpdateMediaTrackRequest {

    private static final String TRACK_ID = "trackId";
    private static final String MEDIA_ID = "mediaId";
    private static final String BODY_NAME = "body";
    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=trackId")
    private String trackId;

    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=mediaId")
    private String mediaId;


    @FastpixMetadata("request:mediaType=application/json")
    private UpdateTrackRequest body;

    @JsonCreator
    public UpdateMediaTrackRequest(
            @Nonnull String trackId,
            @Nonnull String mediaId,
            @Nonnull UpdateTrackRequest body) {
        this.trackId = Optional.ofNullable(trackId)
            .orElseThrow(() -> new IllegalArgumentException("trackId cannot be null"));
        this.mediaId = Optional.ofNullable(mediaId)
            .orElseThrow(() -> new IllegalArgumentException("mediaId cannot be null"));
        this.body = Optional.ofNullable(body)
            .orElseThrow(() -> new IllegalArgumentException("body cannot be null"));
    }

    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public String trackId() {
        return this.trackId;
    }

    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public String mediaId() {
        return this.mediaId;
    }

    public UpdateTrackRequest body() {
        return this.body;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public UpdateMediaTrackRequest withTrackId(@Nonnull String trackId) {
        this.trackId = Utils.checkNotNull(trackId, TRACK_ID);
        return this;
    }


    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public UpdateMediaTrackRequest withMediaId(@Nonnull String mediaId) {
        this.mediaId = Utils.checkNotNull(mediaId, MEDIA_ID);
        return this;
    }


    public UpdateMediaTrackRequest withBody(@Nonnull UpdateTrackRequest body) {
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
        UpdateMediaTrackRequest other = (UpdateMediaTrackRequest) o;
        return 
            Utils.enhancedDeepEquals(this.trackId, other.trackId) &&
            Utils.enhancedDeepEquals(this.mediaId, other.mediaId) &&
            Utils.enhancedDeepEquals(this.body, other.body);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            trackId, mediaId, body);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateMediaTrackRequest.class,
                TRACK_ID, trackId,
                MEDIA_ID, mediaId,
                BODY_NAME, body);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String trackId;

        private String mediaId;

        private UpdateTrackRequest body;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * The unique identifier assigned to the media when created. The value must be a valid UUID.
         */
        public Builder trackId(@Nonnull String trackId) {
            this.trackId = Utils.checkNotNull(trackId, TRACK_ID);
            return this;
        }

        /**
         * The unique identifier assigned to the media when created. The value must be a valid UUID.
         */
        public Builder mediaId(@Nonnull String mediaId) {
            this.mediaId = Utils.checkNotNull(mediaId, MEDIA_ID);
            return this;
        }

        public Builder body(@Nonnull UpdateTrackRequest body) {
            this.body = Utils.checkNotNull(body, BODY_NAME);
            return this;
        }

        public UpdateMediaTrackRequest build() {
            return new UpdateMediaTrackRequest(
                trackId, mediaId, body);
        }

    }
}
