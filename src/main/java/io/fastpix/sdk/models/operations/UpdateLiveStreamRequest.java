package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.models.components.PatchLiveStreamRequest;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class UpdateLiveStreamRequest {

    private static final String STREAM_ID = "streamId";
    private static final String BODY_NAME = "body";
    /**
     * After creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=streamId")
    private String streamId;


    @FastpixMetadata("request:mediaType=application/json")
    private PatchLiveStreamRequest body;

    @JsonCreator
    public UpdateLiveStreamRequest(
            @Nonnull String streamId,
            @Nonnull PatchLiveStreamRequest body) {
        this.streamId = Optional.ofNullable(streamId)
            .orElseThrow(() -> new IllegalArgumentException("streamId cannot be null"));
        this.body = Optional.ofNullable(body)
            .orElseThrow(() -> new IllegalArgumentException("body cannot be null"));
    }

    /**
     * After creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    public String streamId() {
        return this.streamId;
    }

    public PatchLiveStreamRequest body() {
        return this.body;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * After creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    public UpdateLiveStreamRequest withStreamId(@Nonnull String streamId) {
        this.streamId = Utils.checkNotNull(streamId, STREAM_ID);
        return this;
    }


    public UpdateLiveStreamRequest withBody(@Nonnull PatchLiveStreamRequest body) {
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
        UpdateLiveStreamRequest other = (UpdateLiveStreamRequest) o;
        return 
            Utils.enhancedDeepEquals(this.streamId, other.streamId) &&
            Utils.enhancedDeepEquals(this.body, other.body);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            streamId, body);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateLiveStreamRequest.class,
                STREAM_ID, streamId,
                BODY_NAME, body);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String streamId;

        private PatchLiveStreamRequest body;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * After creating a new live stream, FastPix assigns a unique identifier to the stream.
         */
        public Builder streamId(@Nonnull String streamId) {
            this.streamId = Utils.checkNotNull(streamId, STREAM_ID);
            return this;
        }

        public Builder body(@Nonnull PatchLiveStreamRequest body) {
            this.body = Utils.checkNotNull(body, BODY_NAME);
            return this;
        }

        public UpdateLiveStreamRequest build() {
            return new UpdateLiveStreamRequest(
                streamId, body);
        }

    }
}
