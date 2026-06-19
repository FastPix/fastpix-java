package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class DeleteMediaTrackRequest {

    private static final String MEDIA_ID = "mediaId";
    private static final String TRACK_ID = "trackId";
    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=mediaId")
    private String mediaId;

    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=trackId")
    private String trackId;

    @JsonCreator
    public DeleteMediaTrackRequest(
            @Nonnull String mediaId,
            @Nonnull String trackId) {
        this.mediaId = Optional.ofNullable(mediaId)
            .orElseThrow(() -> new IllegalArgumentException("mediaId cannot be null"));
        this.trackId = Optional.ofNullable(trackId)
            .orElseThrow(() -> new IllegalArgumentException("trackId cannot be null"));
    }

    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public String mediaId() {
        return this.mediaId;
    }

    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public String trackId() {
        return this.trackId;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public DeleteMediaTrackRequest withMediaId(@Nonnull String mediaId) {
        this.mediaId = Utils.checkNotNull(mediaId, MEDIA_ID);
        return this;
    }


    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public DeleteMediaTrackRequest withTrackId(@Nonnull String trackId) {
        this.trackId = Utils.checkNotNull(trackId, TRACK_ID);
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
        DeleteMediaTrackRequest other = (DeleteMediaTrackRequest) o;
        return 
            Utils.enhancedDeepEquals(this.mediaId, other.mediaId) &&
            Utils.enhancedDeepEquals(this.trackId, other.trackId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            mediaId, trackId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DeleteMediaTrackRequest.class,
                MEDIA_ID, mediaId,
                TRACK_ID, trackId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String mediaId;

        private String trackId;

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
         * The unique identifier assigned to the media when created. The value must be a valid UUID.
         */
        public Builder trackId(@Nonnull String trackId) {
            this.trackId = Utils.checkNotNull(trackId, TRACK_ID);
            return this;
        }

        public DeleteMediaTrackRequest build() {
            return new DeleteMediaTrackRequest(
                mediaId, trackId);
        }

    }
}
