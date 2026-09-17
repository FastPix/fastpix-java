package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class UpdateLiveStreamDomainRestrictionsRequest {

    private static final String MEDIA_ID = "streamId";
    private static final String PLAYBACK_ID = "playbackId";
    private static final String BODY_NAME = "body";

    @FastpixMetadata("pathParam:style=simple,explode=false,name=streamId")
    private String streamId;


    @FastpixMetadata("pathParam:style=simple,explode=false,name=playbackId")
    private String playbackId;


    @FastpixMetadata("request:mediaType=application/json")
    private UpdateLiveStreamDomainRestrictionsRequestBody body;

    @JsonCreator
    public UpdateLiveStreamDomainRestrictionsRequest(
            @Nonnull String streamId,
            @Nonnull String playbackId,
            @Nonnull UpdateLiveStreamDomainRestrictionsRequestBody body) {
        this.streamId = Optional.ofNullable(streamId)
            .orElseThrow(() -> new IllegalArgumentException("streamId cannot be null"));
        this.playbackId = Optional.ofNullable(playbackId)
            .orElseThrow(() -> new IllegalArgumentException("playbackId cannot be null"));
        this.body = Optional.ofNullable(body)
            .orElseThrow(() -> new IllegalArgumentException("body cannot be null"));
    }

    public String streamId() {
        return this.streamId;
    }

    public String playbackId() {
        return this.playbackId;
    }

    public UpdateLiveStreamDomainRestrictionsRequestBody body() {
        return this.body;
    }

    public static Builder builder() {
        return new Builder();
    }


    public UpdateLiveStreamDomainRestrictionsRequest withStreamId(@Nonnull String streamId) {
        this.streamId = Utils.checkNotNull(streamId, MEDIA_ID);
        return this;
    }


    public UpdateLiveStreamDomainRestrictionsRequest withPlaybackId(@Nonnull String playbackId) {
        this.playbackId = Utils.checkNotNull(playbackId, PLAYBACK_ID);
        return this;
    }


    public UpdateLiveStreamDomainRestrictionsRequest withBody(@Nonnull UpdateLiveStreamDomainRestrictionsRequestBody body) {
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
        UpdateLiveStreamDomainRestrictionsRequest other = (UpdateLiveStreamDomainRestrictionsRequest) o;
        return 
            Utils.enhancedDeepEquals(this.streamId, other.streamId) &&
            Utils.enhancedDeepEquals(this.playbackId, other.playbackId) &&
            Utils.enhancedDeepEquals(this.body, other.body);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            streamId, playbackId, body);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateLiveStreamDomainRestrictionsRequest.class,
                MEDIA_ID, streamId,
                PLAYBACK_ID, playbackId,
                BODY_NAME, body);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String streamId;

        private String playbackId;

        private UpdateLiveStreamDomainRestrictionsRequestBody body;

        private Builder() {
          // force use of static builder() method
        }

        public Builder streamId(@Nonnull String streamId) {
            this.streamId = Utils.checkNotNull(streamId, MEDIA_ID);
            return this;
        }

        public Builder playbackId(@Nonnull String playbackId) {
            this.playbackId = Utils.checkNotNull(playbackId, PLAYBACK_ID);
            return this;
        }

        public Builder body(@Nonnull UpdateLiveStreamDomainRestrictionsRequestBody body) {
            this.body = Utils.checkNotNull(body, BODY_NAME);
            return this;
        }

        public UpdateLiveStreamDomainRestrictionsRequest build() {
            return new UpdateLiveStreamDomainRestrictionsRequest(
                streamId, playbackId, body);
        }

    }
}
