package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class RetrieveMediaInputInfoRequest {

    private static final String MEDIA_ID = "mediaId";
    /**
     * Pass the list of the input objects used to create the media, along with applied settings.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=mediaId")
    private String mediaId;

    @JsonCreator
    public RetrieveMediaInputInfoRequest(
            @Nonnull String mediaId) {
        this.mediaId = Optional.ofNullable(mediaId)
            .orElseThrow(() -> new IllegalArgumentException("mediaId cannot be null"));
    }

    /**
     * Pass the list of the input objects used to create the media, along with applied settings.
     */
    public String mediaId() {
        return this.mediaId;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Pass the list of the input objects used to create the media, along with applied settings.
     */
    public RetrieveMediaInputInfoRequest withMediaId(@Nonnull String mediaId) {
        this.mediaId = Utils.checkNotNull(mediaId, MEDIA_ID);
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
        RetrieveMediaInputInfoRequest other = (RetrieveMediaInputInfoRequest) o;
        return 
            Utils.enhancedDeepEquals(this.mediaId, other.mediaId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            mediaId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(RetrieveMediaInputInfoRequest.class,
                MEDIA_ID, mediaId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String mediaId;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Pass the list of the input objects used to create the media, along with applied settings.
         */
        public Builder mediaId(@Nonnull String mediaId) {
            this.mediaId = Utils.checkNotNull(mediaId, MEDIA_ID);
            return this;
        }

        public RetrieveMediaInputInfoRequest build() {
            return new RetrieveMediaInputInfoRequest(
                mediaId);
        }

    }
}
