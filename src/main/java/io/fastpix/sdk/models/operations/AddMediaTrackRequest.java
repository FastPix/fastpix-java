package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class AddMediaTrackRequest {

    private static final String MEDIA_ID = "mediaId";
    private static final String BODY_NAME = "body";

    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=mediaId")
    private String mediaId;


    @FastpixMetadata("request:mediaType=application/json")
    private AddMediaTrackRequestBody body;

    @JsonCreator
    public AddMediaTrackRequest(
            @Nonnull String mediaId,
            @Nonnull AddMediaTrackRequestBody body) {
        this.mediaId = Optional.ofNullable(mediaId)
            .orElseThrow(() -> new IllegalArgumentException("mediaId cannot be null"));
        this.body = Optional.ofNullable(body)
            .orElseThrow(() -> new IllegalArgumentException("body cannot be null"));
    }

    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public String mediaId() {
        return this.mediaId;
    }

    public AddMediaTrackRequestBody body() {
        return this.body;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The unique identifier assigned to the media when created. The value must be a valid UUID.
     */
    public AddMediaTrackRequest withMediaId(@Nonnull String mediaId) {
        this.mediaId = Utils.checkNotNull(mediaId, MEDIA_ID);
        return this;
    }


    public AddMediaTrackRequest withBody(@Nonnull AddMediaTrackRequestBody body) {
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
        AddMediaTrackRequest other = (AddMediaTrackRequest) o;
        return 
            Utils.enhancedDeepEquals(this.mediaId, other.mediaId) &&
            Utils.enhancedDeepEquals(this.body, other.body);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            mediaId, body);
    }
    
    @Override
    public String toString() {
        return Utils.toString(AddMediaTrackRequest.class,
                MEDIA_ID, mediaId,
                BODY_NAME, body);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String mediaId;

        private AddMediaTrackRequestBody body;

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

        public Builder body(@Nonnull AddMediaTrackRequestBody body) {
            this.body = Utils.checkNotNull(body, BODY_NAME);
            return this;
        }

        public AddMediaTrackRequest build() {
            return new AddMediaTrackRequest(
                mediaId, body);
        }

    }
}
