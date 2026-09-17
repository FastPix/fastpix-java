package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import java.util.Optional;
import io.fastpix.sdk.utils.Utils;

/**
 * PlaybackIdResponse
 * 
 * <p>A collection of Playback ID objects utilized for crafting HLS playback urls.
 */
public class PlaybackIdResponse {
    /**
     * Unique identifier for the playbackId
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    private String id;

    /**
     * Determines if access to the streamed content is kept private or available to all.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("accessPolicy")
    private String accessPolicy;

    /**
     * Domain and user-agent access restrictions applied to the playback ID.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("accessRestrictions")
    private PlaybackIdAccessRestrictions accessRestrictions;

    @JsonCreator
    public PlaybackIdResponse(
            @JsonProperty("id") @Nullable String id,
            @JsonProperty("accessPolicy") @Nullable String accessPolicy,
            @JsonProperty("accessRestrictions") @Nullable PlaybackIdAccessRestrictions accessRestrictions) {
        this.id = id;
        this.accessPolicy = accessPolicy;
        this.accessRestrictions = accessRestrictions;
    }
    
    public PlaybackIdResponse() {
        this(null, null, null);
    }

    /**
     * Unique identifier for the playbackId
     */
    public Optional<String> id() {
        return Optional.ofNullable(this.id);
    }

    /**
     * Determines if access to the streamed content is kept private or available to all.
     */
    public Optional<String> accessPolicy() {
        return Optional.ofNullable(this.accessPolicy);
    }

    /**
     * Domain and user-agent access restrictions applied to the playback ID.
     */
    public Optional<PlaybackIdAccessRestrictions> accessRestrictions() {
        return Optional.ofNullable(this.accessRestrictions);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Unique identifier for the playbackId
     */
    public PlaybackIdResponse withId(@Nullable String id) {
        this.id = id;
        return this;
    }


    /**
     * Determines if access to the streamed content is kept private or available to all.
     */
    public PlaybackIdResponse withAccessPolicy(@Nullable String accessPolicy) {
        this.accessPolicy = accessPolicy;
        return this;
    }


    /**
     * Domain and user-agent access restrictions applied to the playback ID.
     */
    public PlaybackIdResponse withAccessRestrictions(@Nullable PlaybackIdAccessRestrictions accessRestrictions) {
        this.accessRestrictions = accessRestrictions;
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
        PlaybackIdResponse other = (PlaybackIdResponse) o;
        return 
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.accessPolicy, other.accessPolicy) &&
            Utils.enhancedDeepEquals(this.accessRestrictions, other.accessRestrictions);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            id, accessPolicy, accessRestrictions);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PlaybackIdResponse.class,
                "id", id,
                "accessPolicy", accessPolicy,
                "accessRestrictions", accessRestrictions);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String id;

        private String accessPolicy;

        private PlaybackIdAccessRestrictions accessRestrictions;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Unique identifier for the playbackId
         */
        public Builder id(@Nullable String id) {
            this.id = id;
            return this;
        }

        /**
         * Determines if access to the streamed content is kept private or available to all.
         */
        public Builder accessPolicy(@Nullable String accessPolicy) {
            this.accessPolicy = accessPolicy;
            return this;
        }

        /**
         * Domain and user-agent access restrictions applied to the playback ID.
         */
        public Builder accessRestrictions(@Nullable PlaybackIdAccessRestrictions accessRestrictions) {
            this.accessRestrictions = accessRestrictions;
            return this;
        }

        public PlaybackIdResponse build() {
            return new PlaybackIdResponse(
                id, accessPolicy, accessRestrictions);
        }

    }
}
