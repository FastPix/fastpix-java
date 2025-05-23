/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.fastpix.sdk.utils.SpeakeasyMetadata;
import io.fastpix.sdk.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

public class CreateMediaPlaybackIdRequest {

    /**
     * When creating the media, FastPix assigns a universally unique identifier with a maximum length of 255 characters.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=mediaId")
    private String mediaId;

    /**
     * Request body for creating playback id for an media
     */
    @SpeakeasyMetadata("request:mediaType=application/json")
    private Optional<? extends CreateMediaPlaybackIdRequestBody> requestBody;

    @JsonCreator
    public CreateMediaPlaybackIdRequest(
            String mediaId,
            Optional<? extends CreateMediaPlaybackIdRequestBody> requestBody) {
        Utils.checkNotNull(mediaId, "mediaId");
        Utils.checkNotNull(requestBody, "requestBody");
        this.mediaId = mediaId;
        this.requestBody = requestBody;
    }
    
    public CreateMediaPlaybackIdRequest(
            String mediaId) {
        this(mediaId, Optional.empty());
    }

    /**
     * When creating the media, FastPix assigns a universally unique identifier with a maximum length of 255 characters.
     */
    @JsonIgnore
    public String mediaId() {
        return mediaId;
    }

    /**
     * Request body for creating playback id for an media
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateMediaPlaybackIdRequestBody> requestBody() {
        return (Optional<CreateMediaPlaybackIdRequestBody>) requestBody;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * When creating the media, FastPix assigns a universally unique identifier with a maximum length of 255 characters.
     */
    public CreateMediaPlaybackIdRequest withMediaId(String mediaId) {
        Utils.checkNotNull(mediaId, "mediaId");
        this.mediaId = mediaId;
        return this;
    }

    /**
     * Request body for creating playback id for an media
     */
    public CreateMediaPlaybackIdRequest withRequestBody(CreateMediaPlaybackIdRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.ofNullable(requestBody);
        return this;
    }

    /**
     * Request body for creating playback id for an media
     */
    public CreateMediaPlaybackIdRequest withRequestBody(Optional<? extends CreateMediaPlaybackIdRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
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
        CreateMediaPlaybackIdRequest other = (CreateMediaPlaybackIdRequest) o;
        return 
            Objects.deepEquals(this.mediaId, other.mediaId) &&
            Objects.deepEquals(this.requestBody, other.requestBody);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            mediaId,
            requestBody);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateMediaPlaybackIdRequest.class,
                "mediaId", mediaId,
                "requestBody", requestBody);
    }
    
    public final static class Builder {
 
        private String mediaId;
 
        private Optional<? extends CreateMediaPlaybackIdRequestBody> requestBody = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * When creating the media, FastPix assigns a universally unique identifier with a maximum length of 255 characters.
         */
        public Builder mediaId(String mediaId) {
            Utils.checkNotNull(mediaId, "mediaId");
            this.mediaId = mediaId;
            return this;
        }

        /**
         * Request body for creating playback id for an media
         */
        public Builder requestBody(CreateMediaPlaybackIdRequestBody requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = Optional.ofNullable(requestBody);
            return this;
        }

        /**
         * Request body for creating playback id for an media
         */
        public Builder requestBody(Optional<? extends CreateMediaPlaybackIdRequestBody> requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = requestBody;
            return this;
        }
        
        public CreateMediaPlaybackIdRequest build() {
            return new CreateMediaPlaybackIdRequest(
                mediaId,
                requestBody);
        }
    }
}
