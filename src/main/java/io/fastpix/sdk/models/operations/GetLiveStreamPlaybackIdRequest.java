package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class GetLiveStreamPlaybackIdRequest {

    private static final String STREAM_ID = "streamId";
    private static final String PLAYBACK_ID = "playbackId";
    /**
     * After creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=streamId")
    private String streamId;

    /**
     * After creating a new playbackId, FastPix assigns a unique identifier to the playback.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=playbackId")
    private String playbackId;

    @JsonCreator
    public GetLiveStreamPlaybackIdRequest(
            @Nonnull String streamId,
            @Nonnull String playbackId) {
        this.streamId = Optional.ofNullable(streamId)
            .orElseThrow(() -> new IllegalArgumentException("streamId cannot be null"));
        this.playbackId = Optional.ofNullable(playbackId)
            .orElseThrow(() -> new IllegalArgumentException("playbackId cannot be null"));
    }

    /**
     * After creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    public String streamId() {
        return this.streamId;
    }

    /**
     * After creating a new playbackId, FastPix assigns a unique identifier to the playback.
     */
    public String playbackId() {
        return this.playbackId;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * After creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    public GetLiveStreamPlaybackIdRequest withStreamId(@Nonnull String streamId) {
        this.streamId = Utils.checkNotNull(streamId, STREAM_ID);
        return this;
    }


    /**
     * After creating a new playbackId, FastPix assigns a unique identifier to the playback.
     */
    public GetLiveStreamPlaybackIdRequest withPlaybackId(@Nonnull String playbackId) {
        this.playbackId = Utils.checkNotNull(playbackId, PLAYBACK_ID);
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
        GetLiveStreamPlaybackIdRequest other = (GetLiveStreamPlaybackIdRequest) o;
        return 
            Utils.enhancedDeepEquals(this.streamId, other.streamId) &&
            Utils.enhancedDeepEquals(this.playbackId, other.playbackId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            streamId, playbackId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetLiveStreamPlaybackIdRequest.class,
                STREAM_ID, streamId,
                PLAYBACK_ID, playbackId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String streamId;

        private String playbackId;

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

        /**
         * After creating a new playbackId, FastPix assigns a unique identifier to the playback.
         */
        public Builder playbackId(@Nonnull String playbackId) {
            this.playbackId = Utils.checkNotNull(playbackId, PLAYBACK_ID);
            return this;
        }

        public GetLiveStreamPlaybackIdRequest build() {
            return new GetLiveStreamPlaybackIdRequest(
                streamId, playbackId);
        }

    }
}
