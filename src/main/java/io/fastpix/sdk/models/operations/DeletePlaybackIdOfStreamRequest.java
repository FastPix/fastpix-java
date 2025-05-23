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
import java.util.Objects;

public class DeletePlaybackIdOfStreamRequest {

    /**
     * Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=streamId")
    private String streamId;

    /**
     * Unique identifier for the playbackId
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=playbackId")
    private String playbackId;

    @JsonCreator
    public DeletePlaybackIdOfStreamRequest(
            String streamId,
            String playbackId) {
        Utils.checkNotNull(streamId, "streamId");
        Utils.checkNotNull(playbackId, "playbackId");
        this.streamId = streamId;
        this.playbackId = playbackId;
    }

    /**
     * Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    @JsonIgnore
    public String streamId() {
        return streamId;
    }

    /**
     * Unique identifier for the playbackId
     */
    @JsonIgnore
    public String playbackId() {
        return playbackId;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    public DeletePlaybackIdOfStreamRequest withStreamId(String streamId) {
        Utils.checkNotNull(streamId, "streamId");
        this.streamId = streamId;
        return this;
    }

    /**
     * Unique identifier for the playbackId
     */
    public DeletePlaybackIdOfStreamRequest withPlaybackId(String playbackId) {
        Utils.checkNotNull(playbackId, "playbackId");
        this.playbackId = playbackId;
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
        DeletePlaybackIdOfStreamRequest other = (DeletePlaybackIdOfStreamRequest) o;
        return 
            Objects.deepEquals(this.streamId, other.streamId) &&
            Objects.deepEquals(this.playbackId, other.playbackId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            streamId,
            playbackId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DeletePlaybackIdOfStreamRequest.class,
                "streamId", streamId,
                "playbackId", playbackId);
    }
    
    public final static class Builder {
 
        private String streamId;
 
        private String playbackId;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
         */
        public Builder streamId(String streamId) {
            Utils.checkNotNull(streamId, "streamId");
            this.streamId = streamId;
            return this;
        }

        /**
         * Unique identifier for the playbackId
         */
        public Builder playbackId(String playbackId) {
            Utils.checkNotNull(playbackId, "playbackId");
            this.playbackId = playbackId;
            return this;
        }
        
        public DeletePlaybackIdOfStreamRequest build() {
            return new DeletePlaybackIdOfStreamRequest(
                streamId,
                playbackId);
        }
    }
}
