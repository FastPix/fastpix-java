/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.fastpix.sdk.utils.LazySingletonValue;
import io.fastpix.sdk.utils.Utils;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * GetCreateLiveStreamResponseDTO
 * 
 * <p>Displays the result of the request.
 */
public class GetCreateLiveStreamResponseDTO {

    /**
     * Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("streamId")
    private Optional<String> streamId;

    /**
     * A unique stream key is generated for streaming, allowing the user to start streaming on any third-party platform using this key.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("streamKey")
    private Optional<String> streamKey;

    /**
     * A secret used for securing the SRT stream. This ensures that only authorized users can access the stream.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("srtSecret")
    private Optional<String> srtSecret;

    /**
     * FastPix allows for a to trial the live stream for free. The duration of trial streams is five minutes. After five minutes of activity, the trial stream is turned off, and the recorded asset is removed after a day.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("trial")
    private Optional<Boolean> trial;

    /**
     * The current live stream status can be one of four values:Idle, Preparing, Active or Disabled.The Idle status signifies that there isn't a broadcast in progress.The preparing status indicates that the stream is getting prepared. while, the Active status indicates that a broadcast is currently in progress. The Disabled status means that no more RTMP streams can be published.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("status")
    private Optional<String> status;

    /**
     * Max resolution can be used to control the maximum resolution your media is encoded, stored, and streamed at.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("maxResolution")
    private Optional<String> maxResolution;

    /**
     * The maximum duration in seconds that a live stream can have before it ends the stream.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("maxDuration")
    private Optional<Long> maxDuration;

    /**
     * It is the moment when the stream was created Time the media was generated, defined as a localDateTime (UTC Time).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("createdAt")
    private Optional<OffsetDateTime> createdAt;

    /**
     * In case the software streaming the live, get disrupted for any reason and get disconnect from FastPix, the reconnect window specifies the waiting time span of FastPix will wait before ending the stream. Before starting the stream, you can set the reconnect window time set which is up to 1800 seconds.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("reconnectWindow")
    private Optional<Long> reconnectWindow;

    /**
     * When set to true, the livestream will be recorded and stored for later viewing purposes. If set to false, the livestream will not be recorded.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("enableRecording")
    private Optional<Boolean> enableRecording;

    /**
     * Determines whether the recorded stream should be publicly accessible or private in Live to VOD (Video on Demand).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("mediaPolicy")
    private Optional<String> mediaPolicy;

    /**
     * You can search for videos with specific key value pairs using metadata, when you tag a video in "key":"value"s pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have maximum of 255 characters and upto 10 entries are allowed.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("metadata")
    private Optional<? extends GetCreateLiveStreamResponseDTOMetadata> metadata;

    /**
     * A collection of Playback ID objects utilized for crafting HLS playback urls.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("playbackId")
    private Optional<? extends List<PlaybackIds>> playbackId;

    /**
     * This object contains the livestream playback response details for SRT Protocol.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("srtPlaybackResponse")
    private Optional<? extends GetCreateLiveStreamResponseDTOSrtPlaybackResponse> srtPlaybackResponse;

    @JsonCreator
    public GetCreateLiveStreamResponseDTO(
            @JsonProperty("streamId") Optional<String> streamId,
            @JsonProperty("streamKey") Optional<String> streamKey,
            @JsonProperty("srtSecret") Optional<String> srtSecret,
            @JsonProperty("trial") Optional<Boolean> trial,
            @JsonProperty("status") Optional<String> status,
            @JsonProperty("maxResolution") Optional<String> maxResolution,
            @JsonProperty("maxDuration") Optional<Long> maxDuration,
            @JsonProperty("createdAt") Optional<OffsetDateTime> createdAt,
            @JsonProperty("reconnectWindow") Optional<Long> reconnectWindow,
            @JsonProperty("enableRecording") Optional<Boolean> enableRecording,
            @JsonProperty("mediaPolicy") Optional<String> mediaPolicy,
            @JsonProperty("metadata") Optional<? extends GetCreateLiveStreamResponseDTOMetadata> metadata,
            @JsonProperty("playbackId") Optional<? extends List<PlaybackIds>> playbackId,
            @JsonProperty("srtPlaybackResponse") Optional<? extends GetCreateLiveStreamResponseDTOSrtPlaybackResponse> srtPlaybackResponse) {
        Utils.checkNotNull(streamId, "streamId");
        Utils.checkNotNull(streamKey, "streamKey");
        Utils.checkNotNull(srtSecret, "srtSecret");
        Utils.checkNotNull(trial, "trial");
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(maxResolution, "maxResolution");
        Utils.checkNotNull(maxDuration, "maxDuration");
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(reconnectWindow, "reconnectWindow");
        Utils.checkNotNull(enableRecording, "enableRecording");
        Utils.checkNotNull(mediaPolicy, "mediaPolicy");
        Utils.checkNotNull(metadata, "metadata");
        Utils.checkNotNull(playbackId, "playbackId");
        Utils.checkNotNull(srtPlaybackResponse, "srtPlaybackResponse");
        this.streamId = streamId;
        this.streamKey = streamKey;
        this.srtSecret = srtSecret;
        this.trial = trial;
        this.status = status;
        this.maxResolution = maxResolution;
        this.maxDuration = maxDuration;
        this.createdAt = createdAt;
        this.reconnectWindow = reconnectWindow;
        this.enableRecording = enableRecording;
        this.mediaPolicy = mediaPolicy;
        this.metadata = metadata;
        this.playbackId = playbackId;
        this.srtPlaybackResponse = srtPlaybackResponse;
    }
    
    public GetCreateLiveStreamResponseDTO() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    @JsonIgnore
    public Optional<String> streamId() {
        return streamId;
    }

    /**
     * A unique stream key is generated for streaming, allowing the user to start streaming on any third-party platform using this key.
     */
    @JsonIgnore
    public Optional<String> streamKey() {
        return streamKey;
    }

    /**
     * A secret used for securing the SRT stream. This ensures that only authorized users can access the stream.
     */
    @JsonIgnore
    public Optional<String> srtSecret() {
        return srtSecret;
    }

    /**
     * FastPix allows for a to trial the live stream for free. The duration of trial streams is five minutes. After five minutes of activity, the trial stream is turned off, and the recorded asset is removed after a day.
     */
    @JsonIgnore
    public Optional<Boolean> trial() {
        return trial;
    }

    /**
     * The current live stream status can be one of four values:Idle, Preparing, Active or Disabled.The Idle status signifies that there isn't a broadcast in progress.The preparing status indicates that the stream is getting prepared. while, the Active status indicates that a broadcast is currently in progress. The Disabled status means that no more RTMP streams can be published.
     */
    @JsonIgnore
    public Optional<String> status() {
        return status;
    }

    /**
     * Max resolution can be used to control the maximum resolution your media is encoded, stored, and streamed at.
     */
    @JsonIgnore
    public Optional<String> maxResolution() {
        return maxResolution;
    }

    /**
     * The maximum duration in seconds that a live stream can have before it ends the stream.
     */
    @JsonIgnore
    public Optional<Long> maxDuration() {
        return maxDuration;
    }

    /**
     * It is the moment when the stream was created Time the media was generated, defined as a localDateTime (UTC Time).
     */
    @JsonIgnore
    public Optional<OffsetDateTime> createdAt() {
        return createdAt;
    }

    /**
     * In case the software streaming the live, get disrupted for any reason and get disconnect from FastPix, the reconnect window specifies the waiting time span of FastPix will wait before ending the stream. Before starting the stream, you can set the reconnect window time set which is up to 1800 seconds.
     */
    @JsonIgnore
    public Optional<Long> reconnectWindow() {
        return reconnectWindow;
    }

    /**
     * When set to true, the livestream will be recorded and stored for later viewing purposes. If set to false, the livestream will not be recorded.
     */
    @JsonIgnore
    public Optional<Boolean> enableRecording() {
        return enableRecording;
    }

    /**
     * Determines whether the recorded stream should be publicly accessible or private in Live to VOD (Video on Demand).
     */
    @JsonIgnore
    public Optional<String> mediaPolicy() {
        return mediaPolicy;
    }

    /**
     * You can search for videos with specific key value pairs using metadata, when you tag a video in "key":"value"s pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have maximum of 255 characters and upto 10 entries are allowed.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetCreateLiveStreamResponseDTOMetadata> metadata() {
        return (Optional<GetCreateLiveStreamResponseDTOMetadata>) metadata;
    }

    /**
     * A collection of Playback ID objects utilized for crafting HLS playback urls.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<PlaybackIds>> playbackId() {
        return (Optional<List<PlaybackIds>>) playbackId;
    }

    /**
     * This object contains the livestream playback response details for SRT Protocol.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetCreateLiveStreamResponseDTOSrtPlaybackResponse> srtPlaybackResponse() {
        return (Optional<GetCreateLiveStreamResponseDTOSrtPlaybackResponse>) srtPlaybackResponse;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    public GetCreateLiveStreamResponseDTO withStreamId(String streamId) {
        Utils.checkNotNull(streamId, "streamId");
        this.streamId = Optional.ofNullable(streamId);
        return this;
    }

    /**
     * Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
     */
    public GetCreateLiveStreamResponseDTO withStreamId(Optional<String> streamId) {
        Utils.checkNotNull(streamId, "streamId");
        this.streamId = streamId;
        return this;
    }

    /**
     * A unique stream key is generated for streaming, allowing the user to start streaming on any third-party platform using this key.
     */
    public GetCreateLiveStreamResponseDTO withStreamKey(String streamKey) {
        Utils.checkNotNull(streamKey, "streamKey");
        this.streamKey = Optional.ofNullable(streamKey);
        return this;
    }

    /**
     * A unique stream key is generated for streaming, allowing the user to start streaming on any third-party platform using this key.
     */
    public GetCreateLiveStreamResponseDTO withStreamKey(Optional<String> streamKey) {
        Utils.checkNotNull(streamKey, "streamKey");
        this.streamKey = streamKey;
        return this;
    }

    /**
     * A secret used for securing the SRT stream. This ensures that only authorized users can access the stream.
     */
    public GetCreateLiveStreamResponseDTO withSrtSecret(String srtSecret) {
        Utils.checkNotNull(srtSecret, "srtSecret");
        this.srtSecret = Optional.ofNullable(srtSecret);
        return this;
    }

    /**
     * A secret used for securing the SRT stream. This ensures that only authorized users can access the stream.
     */
    public GetCreateLiveStreamResponseDTO withSrtSecret(Optional<String> srtSecret) {
        Utils.checkNotNull(srtSecret, "srtSecret");
        this.srtSecret = srtSecret;
        return this;
    }

    /**
     * FastPix allows for a to trial the live stream for free. The duration of trial streams is five minutes. After five minutes of activity, the trial stream is turned off, and the recorded asset is removed after a day.
     */
    public GetCreateLiveStreamResponseDTO withTrial(boolean trial) {
        Utils.checkNotNull(trial, "trial");
        this.trial = Optional.ofNullable(trial);
        return this;
    }

    /**
     * FastPix allows for a to trial the live stream for free. The duration of trial streams is five minutes. After five minutes of activity, the trial stream is turned off, and the recorded asset is removed after a day.
     */
    public GetCreateLiveStreamResponseDTO withTrial(Optional<Boolean> trial) {
        Utils.checkNotNull(trial, "trial");
        this.trial = trial;
        return this;
    }

    /**
     * The current live stream status can be one of four values:Idle, Preparing, Active or Disabled.The Idle status signifies that there isn't a broadcast in progress.The preparing status indicates that the stream is getting prepared. while, the Active status indicates that a broadcast is currently in progress. The Disabled status means that no more RTMP streams can be published.
     */
    public GetCreateLiveStreamResponseDTO withStatus(String status) {
        Utils.checkNotNull(status, "status");
        this.status = Optional.ofNullable(status);
        return this;
    }

    /**
     * The current live stream status can be one of four values:Idle, Preparing, Active or Disabled.The Idle status signifies that there isn't a broadcast in progress.The preparing status indicates that the stream is getting prepared. while, the Active status indicates that a broadcast is currently in progress. The Disabled status means that no more RTMP streams can be published.
     */
    public GetCreateLiveStreamResponseDTO withStatus(Optional<String> status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    /**
     * Max resolution can be used to control the maximum resolution your media is encoded, stored, and streamed at.
     */
    public GetCreateLiveStreamResponseDTO withMaxResolution(String maxResolution) {
        Utils.checkNotNull(maxResolution, "maxResolution");
        this.maxResolution = Optional.ofNullable(maxResolution);
        return this;
    }

    /**
     * Max resolution can be used to control the maximum resolution your media is encoded, stored, and streamed at.
     */
    public GetCreateLiveStreamResponseDTO withMaxResolution(Optional<String> maxResolution) {
        Utils.checkNotNull(maxResolution, "maxResolution");
        this.maxResolution = maxResolution;
        return this;
    }

    /**
     * The maximum duration in seconds that a live stream can have before it ends the stream.
     */
    public GetCreateLiveStreamResponseDTO withMaxDuration(long maxDuration) {
        Utils.checkNotNull(maxDuration, "maxDuration");
        this.maxDuration = Optional.ofNullable(maxDuration);
        return this;
    }

    /**
     * The maximum duration in seconds that a live stream can have before it ends the stream.
     */
    public GetCreateLiveStreamResponseDTO withMaxDuration(Optional<Long> maxDuration) {
        Utils.checkNotNull(maxDuration, "maxDuration");
        this.maxDuration = maxDuration;
        return this;
    }

    /**
     * It is the moment when the stream was created Time the media was generated, defined as a localDateTime (UTC Time).
     */
    public GetCreateLiveStreamResponseDTO withCreatedAt(OffsetDateTime createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = Optional.ofNullable(createdAt);
        return this;
    }

    /**
     * It is the moment when the stream was created Time the media was generated, defined as a localDateTime (UTC Time).
     */
    public GetCreateLiveStreamResponseDTO withCreatedAt(Optional<OffsetDateTime> createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * In case the software streaming the live, get disrupted for any reason and get disconnect from FastPix, the reconnect window specifies the waiting time span of FastPix will wait before ending the stream. Before starting the stream, you can set the reconnect window time set which is up to 1800 seconds.
     */
    public GetCreateLiveStreamResponseDTO withReconnectWindow(long reconnectWindow) {
        Utils.checkNotNull(reconnectWindow, "reconnectWindow");
        this.reconnectWindow = Optional.ofNullable(reconnectWindow);
        return this;
    }

    /**
     * In case the software streaming the live, get disrupted for any reason and get disconnect from FastPix, the reconnect window specifies the waiting time span of FastPix will wait before ending the stream. Before starting the stream, you can set the reconnect window time set which is up to 1800 seconds.
     */
    public GetCreateLiveStreamResponseDTO withReconnectWindow(Optional<Long> reconnectWindow) {
        Utils.checkNotNull(reconnectWindow, "reconnectWindow");
        this.reconnectWindow = reconnectWindow;
        return this;
    }

    /**
     * When set to true, the livestream will be recorded and stored for later viewing purposes. If set to false, the livestream will not be recorded.
     */
    public GetCreateLiveStreamResponseDTO withEnableRecording(boolean enableRecording) {
        Utils.checkNotNull(enableRecording, "enableRecording");
        this.enableRecording = Optional.ofNullable(enableRecording);
        return this;
    }

    /**
     * When set to true, the livestream will be recorded and stored for later viewing purposes. If set to false, the livestream will not be recorded.
     */
    public GetCreateLiveStreamResponseDTO withEnableRecording(Optional<Boolean> enableRecording) {
        Utils.checkNotNull(enableRecording, "enableRecording");
        this.enableRecording = enableRecording;
        return this;
    }

    /**
     * Determines whether the recorded stream should be publicly accessible or private in Live to VOD (Video on Demand).
     */
    public GetCreateLiveStreamResponseDTO withMediaPolicy(String mediaPolicy) {
        Utils.checkNotNull(mediaPolicy, "mediaPolicy");
        this.mediaPolicy = Optional.ofNullable(mediaPolicy);
        return this;
    }

    /**
     * Determines whether the recorded stream should be publicly accessible or private in Live to VOD (Video on Demand).
     */
    public GetCreateLiveStreamResponseDTO withMediaPolicy(Optional<String> mediaPolicy) {
        Utils.checkNotNull(mediaPolicy, "mediaPolicy");
        this.mediaPolicy = mediaPolicy;
        return this;
    }

    /**
     * You can search for videos with specific key value pairs using metadata, when you tag a video in "key":"value"s pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have maximum of 255 characters and upto 10 entries are allowed.
     */
    public GetCreateLiveStreamResponseDTO withMetadata(GetCreateLiveStreamResponseDTOMetadata metadata) {
        Utils.checkNotNull(metadata, "metadata");
        this.metadata = Optional.ofNullable(metadata);
        return this;
    }

    /**
     * You can search for videos with specific key value pairs using metadata, when you tag a video in "key":"value"s pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have maximum of 255 characters and upto 10 entries are allowed.
     */
    public GetCreateLiveStreamResponseDTO withMetadata(Optional<? extends GetCreateLiveStreamResponseDTOMetadata> metadata) {
        Utils.checkNotNull(metadata, "metadata");
        this.metadata = metadata;
        return this;
    }

    /**
     * A collection of Playback ID objects utilized for crafting HLS playback urls.
     */
    public GetCreateLiveStreamResponseDTO withPlaybackId(List<PlaybackIds> playbackId) {
        Utils.checkNotNull(playbackId, "playbackId");
        this.playbackId = Optional.ofNullable(playbackId);
        return this;
    }

    /**
     * A collection of Playback ID objects utilized for crafting HLS playback urls.
     */
    public GetCreateLiveStreamResponseDTO withPlaybackId(Optional<? extends List<PlaybackIds>> playbackId) {
        Utils.checkNotNull(playbackId, "playbackId");
        this.playbackId = playbackId;
        return this;
    }

    /**
     * This object contains the livestream playback response details for SRT Protocol.
     */
    public GetCreateLiveStreamResponseDTO withSrtPlaybackResponse(GetCreateLiveStreamResponseDTOSrtPlaybackResponse srtPlaybackResponse) {
        Utils.checkNotNull(srtPlaybackResponse, "srtPlaybackResponse");
        this.srtPlaybackResponse = Optional.ofNullable(srtPlaybackResponse);
        return this;
    }

    /**
     * This object contains the livestream playback response details for SRT Protocol.
     */
    public GetCreateLiveStreamResponseDTO withSrtPlaybackResponse(Optional<? extends GetCreateLiveStreamResponseDTOSrtPlaybackResponse> srtPlaybackResponse) {
        Utils.checkNotNull(srtPlaybackResponse, "srtPlaybackResponse");
        this.srtPlaybackResponse = srtPlaybackResponse;
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
        GetCreateLiveStreamResponseDTO other = (GetCreateLiveStreamResponseDTO) o;
        return 
            Objects.deepEquals(this.streamId, other.streamId) &&
            Objects.deepEquals(this.streamKey, other.streamKey) &&
            Objects.deepEquals(this.srtSecret, other.srtSecret) &&
            Objects.deepEquals(this.trial, other.trial) &&
            Objects.deepEquals(this.status, other.status) &&
            Objects.deepEquals(this.maxResolution, other.maxResolution) &&
            Objects.deepEquals(this.maxDuration, other.maxDuration) &&
            Objects.deepEquals(this.createdAt, other.createdAt) &&
            Objects.deepEquals(this.reconnectWindow, other.reconnectWindow) &&
            Objects.deepEquals(this.enableRecording, other.enableRecording) &&
            Objects.deepEquals(this.mediaPolicy, other.mediaPolicy) &&
            Objects.deepEquals(this.metadata, other.metadata) &&
            Objects.deepEquals(this.playbackId, other.playbackId) &&
            Objects.deepEquals(this.srtPlaybackResponse, other.srtPlaybackResponse);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            streamId,
            streamKey,
            srtSecret,
            trial,
            status,
            maxResolution,
            maxDuration,
            createdAt,
            reconnectWindow,
            enableRecording,
            mediaPolicy,
            metadata,
            playbackId,
            srtPlaybackResponse);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetCreateLiveStreamResponseDTO.class,
                "streamId", streamId,
                "streamKey", streamKey,
                "srtSecret", srtSecret,
                "trial", trial,
                "status", status,
                "maxResolution", maxResolution,
                "maxDuration", maxDuration,
                "createdAt", createdAt,
                "reconnectWindow", reconnectWindow,
                "enableRecording", enableRecording,
                "mediaPolicy", mediaPolicy,
                "metadata", metadata,
                "playbackId", playbackId,
                "srtPlaybackResponse", srtPlaybackResponse);
    }
    
    public final static class Builder {
 
        private Optional<String> streamId = Optional.empty();
 
        private Optional<String> streamKey = Optional.empty();
 
        private Optional<String> srtSecret = Optional.empty();
 
        private Optional<Boolean> trial = Optional.empty();
 
        private Optional<String> status = Optional.empty();
 
        private Optional<String> maxResolution = Optional.empty();
 
        private Optional<Long> maxDuration = Optional.empty();
 
        private Optional<OffsetDateTime> createdAt = Optional.empty();
 
        private Optional<Long> reconnectWindow;
 
        private Optional<Boolean> enableRecording = Optional.empty();
 
        private Optional<String> mediaPolicy = Optional.empty();
 
        private Optional<? extends GetCreateLiveStreamResponseDTOMetadata> metadata = Optional.empty();
 
        private Optional<? extends List<PlaybackIds>> playbackId = Optional.empty();
 
        private Optional<? extends GetCreateLiveStreamResponseDTOSrtPlaybackResponse> srtPlaybackResponse = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
         */
        public Builder streamId(String streamId) {
            Utils.checkNotNull(streamId, "streamId");
            this.streamId = Optional.ofNullable(streamId);
            return this;
        }

        /**
         * Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
         */
        public Builder streamId(Optional<String> streamId) {
            Utils.checkNotNull(streamId, "streamId");
            this.streamId = streamId;
            return this;
        }

        /**
         * A unique stream key is generated for streaming, allowing the user to start streaming on any third-party platform using this key.
         */
        public Builder streamKey(String streamKey) {
            Utils.checkNotNull(streamKey, "streamKey");
            this.streamKey = Optional.ofNullable(streamKey);
            return this;
        }

        /**
         * A unique stream key is generated for streaming, allowing the user to start streaming on any third-party platform using this key.
         */
        public Builder streamKey(Optional<String> streamKey) {
            Utils.checkNotNull(streamKey, "streamKey");
            this.streamKey = streamKey;
            return this;
        }

        /**
         * A secret used for securing the SRT stream. This ensures that only authorized users can access the stream.
         */
        public Builder srtSecret(String srtSecret) {
            Utils.checkNotNull(srtSecret, "srtSecret");
            this.srtSecret = Optional.ofNullable(srtSecret);
            return this;
        }

        /**
         * A secret used for securing the SRT stream. This ensures that only authorized users can access the stream.
         */
        public Builder srtSecret(Optional<String> srtSecret) {
            Utils.checkNotNull(srtSecret, "srtSecret");
            this.srtSecret = srtSecret;
            return this;
        }

        /**
         * FastPix allows for a to trial the live stream for free. The duration of trial streams is five minutes. After five minutes of activity, the trial stream is turned off, and the recorded asset is removed after a day.
         */
        public Builder trial(boolean trial) {
            Utils.checkNotNull(trial, "trial");
            this.trial = Optional.ofNullable(trial);
            return this;
        }

        /**
         * FastPix allows for a to trial the live stream for free. The duration of trial streams is five minutes. After five minutes of activity, the trial stream is turned off, and the recorded asset is removed after a day.
         */
        public Builder trial(Optional<Boolean> trial) {
            Utils.checkNotNull(trial, "trial");
            this.trial = trial;
            return this;
        }

        /**
         * The current live stream status can be one of four values:Idle, Preparing, Active or Disabled.The Idle status signifies that there isn't a broadcast in progress.The preparing status indicates that the stream is getting prepared. while, the Active status indicates that a broadcast is currently in progress. The Disabled status means that no more RTMP streams can be published.
         */
        public Builder status(String status) {
            Utils.checkNotNull(status, "status");
            this.status = Optional.ofNullable(status);
            return this;
        }

        /**
         * The current live stream status can be one of four values:Idle, Preparing, Active or Disabled.The Idle status signifies that there isn't a broadcast in progress.The preparing status indicates that the stream is getting prepared. while, the Active status indicates that a broadcast is currently in progress. The Disabled status means that no more RTMP streams can be published.
         */
        public Builder status(Optional<String> status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }

        /**
         * Max resolution can be used to control the maximum resolution your media is encoded, stored, and streamed at.
         */
        public Builder maxResolution(String maxResolution) {
            Utils.checkNotNull(maxResolution, "maxResolution");
            this.maxResolution = Optional.ofNullable(maxResolution);
            return this;
        }

        /**
         * Max resolution can be used to control the maximum resolution your media is encoded, stored, and streamed at.
         */
        public Builder maxResolution(Optional<String> maxResolution) {
            Utils.checkNotNull(maxResolution, "maxResolution");
            this.maxResolution = maxResolution;
            return this;
        }

        /**
         * The maximum duration in seconds that a live stream can have before it ends the stream.
         */
        public Builder maxDuration(long maxDuration) {
            Utils.checkNotNull(maxDuration, "maxDuration");
            this.maxDuration = Optional.ofNullable(maxDuration);
            return this;
        }

        /**
         * The maximum duration in seconds that a live stream can have before it ends the stream.
         */
        public Builder maxDuration(Optional<Long> maxDuration) {
            Utils.checkNotNull(maxDuration, "maxDuration");
            this.maxDuration = maxDuration;
            return this;
        }

        /**
         * It is the moment when the stream was created Time the media was generated, defined as a localDateTime (UTC Time).
         */
        public Builder createdAt(OffsetDateTime createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        /**
         * It is the moment when the stream was created Time the media was generated, defined as a localDateTime (UTC Time).
         */
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }

        /**
         * In case the software streaming the live, get disrupted for any reason and get disconnect from FastPix, the reconnect window specifies the waiting time span of FastPix will wait before ending the stream. Before starting the stream, you can set the reconnect window time set which is up to 1800 seconds.
         */
        public Builder reconnectWindow(long reconnectWindow) {
            Utils.checkNotNull(reconnectWindow, "reconnectWindow");
            this.reconnectWindow = Optional.ofNullable(reconnectWindow);
            return this;
        }

        /**
         * In case the software streaming the live, get disrupted for any reason and get disconnect from FastPix, the reconnect window specifies the waiting time span of FastPix will wait before ending the stream. Before starting the stream, you can set the reconnect window time set which is up to 1800 seconds.
         */
        public Builder reconnectWindow(Optional<Long> reconnectWindow) {
            Utils.checkNotNull(reconnectWindow, "reconnectWindow");
            this.reconnectWindow = reconnectWindow;
            return this;
        }

        /**
         * When set to true, the livestream will be recorded and stored for later viewing purposes. If set to false, the livestream will not be recorded.
         */
        public Builder enableRecording(boolean enableRecording) {
            Utils.checkNotNull(enableRecording, "enableRecording");
            this.enableRecording = Optional.ofNullable(enableRecording);
            return this;
        }

        /**
         * When set to true, the livestream will be recorded and stored for later viewing purposes. If set to false, the livestream will not be recorded.
         */
        public Builder enableRecording(Optional<Boolean> enableRecording) {
            Utils.checkNotNull(enableRecording, "enableRecording");
            this.enableRecording = enableRecording;
            return this;
        }

        /**
         * Determines whether the recorded stream should be publicly accessible or private in Live to VOD (Video on Demand).
         */
        public Builder mediaPolicy(String mediaPolicy) {
            Utils.checkNotNull(mediaPolicy, "mediaPolicy");
            this.mediaPolicy = Optional.ofNullable(mediaPolicy);
            return this;
        }

        /**
         * Determines whether the recorded stream should be publicly accessible or private in Live to VOD (Video on Demand).
         */
        public Builder mediaPolicy(Optional<String> mediaPolicy) {
            Utils.checkNotNull(mediaPolicy, "mediaPolicy");
            this.mediaPolicy = mediaPolicy;
            return this;
        }

        /**
         * You can search for videos with specific key value pairs using metadata, when you tag a video in "key":"value"s pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have maximum of 255 characters and upto 10 entries are allowed.
         */
        public Builder metadata(GetCreateLiveStreamResponseDTOMetadata metadata) {
            Utils.checkNotNull(metadata, "metadata");
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * You can search for videos with specific key value pairs using metadata, when you tag a video in "key":"value"s pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have maximum of 255 characters and upto 10 entries are allowed.
         */
        public Builder metadata(Optional<? extends GetCreateLiveStreamResponseDTOMetadata> metadata) {
            Utils.checkNotNull(metadata, "metadata");
            this.metadata = metadata;
            return this;
        }

        /**
         * A collection of Playback ID objects utilized for crafting HLS playback urls.
         */
        public Builder playbackId(List<PlaybackIds> playbackId) {
            Utils.checkNotNull(playbackId, "playbackId");
            this.playbackId = Optional.ofNullable(playbackId);
            return this;
        }

        /**
         * A collection of Playback ID objects utilized for crafting HLS playback urls.
         */
        public Builder playbackId(Optional<? extends List<PlaybackIds>> playbackId) {
            Utils.checkNotNull(playbackId, "playbackId");
            this.playbackId = playbackId;
            return this;
        }

        /**
         * This object contains the livestream playback response details for SRT Protocol.
         */
        public Builder srtPlaybackResponse(GetCreateLiveStreamResponseDTOSrtPlaybackResponse srtPlaybackResponse) {
            Utils.checkNotNull(srtPlaybackResponse, "srtPlaybackResponse");
            this.srtPlaybackResponse = Optional.ofNullable(srtPlaybackResponse);
            return this;
        }

        /**
         * This object contains the livestream playback response details for SRT Protocol.
         */
        public Builder srtPlaybackResponse(Optional<? extends GetCreateLiveStreamResponseDTOSrtPlaybackResponse> srtPlaybackResponse) {
            Utils.checkNotNull(srtPlaybackResponse, "srtPlaybackResponse");
            this.srtPlaybackResponse = srtPlaybackResponse;
            return this;
        }
        
        public GetCreateLiveStreamResponseDTO build() {
            if (reconnectWindow == null) {
                reconnectWindow = _SINGLETON_VALUE_ReconnectWindow.value();
            }
            return new GetCreateLiveStreamResponseDTO(
                streamId,
                streamKey,
                srtSecret,
                trial,
                status,
                maxResolution,
                maxDuration,
                createdAt,
                reconnectWindow,
                enableRecording,
                mediaPolicy,
                metadata,
                playbackId,
                srtPlaybackResponse);
        }

        private static final LazySingletonValue<Optional<Long>> _SINGLETON_VALUE_ReconnectWindow =
                new LazySingletonValue<>(
                        "reconnectWindow",
                        "60",
                        new TypeReference<Optional<Long>>() {});
    }
}
