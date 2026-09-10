package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.Nullable;
import java.util.Optional;
import io.fastpix.sdk.utils.LazySingletonValue;
import io.fastpix.sdk.utils.Utils;

/**
 * PlaybackSettings
 * 
 * <p>Displays the result of the playback settings.
 */
public class PlaybackSettings {
    /**
     * Basic access policy for media content
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("accessPolicy")
    private BasicAccessPolicy accessPolicy;

    /**
     * Domain and user-agent access restrictions applied to the playback ID.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("accessRestrictions")
    private PlaybackIdAccessRestrictions accessRestrictions;

    @JsonCreator
    public PlaybackSettings(
            @JsonProperty("accessPolicy") @Nullable BasicAccessPolicy accessPolicy,
            @JsonProperty("accessRestrictions") @Nullable PlaybackIdAccessRestrictions accessRestrictions) {
        this.accessPolicy = Optional.ofNullable(accessPolicy)
            .orElse(Builder._SINGLETON_VALUE_AccessPolicy.value());
        this.accessRestrictions = accessRestrictions;
    }
    
    public PlaybackSettings() {
        this(null, null);
    }

    /**
     * Basic access policy for media content
     */
    public Optional<BasicAccessPolicy> accessPolicy() {
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
     * Basic access policy for media content
     */
    public PlaybackSettings withAccessPolicy(@Nullable BasicAccessPolicy accessPolicy) {
        this.accessPolicy = accessPolicy;
        return this;
    }


    /**
     * Domain and user-agent access restrictions applied to the playback ID.
     */
    public PlaybackSettings withAccessRestrictions(@Nullable PlaybackIdAccessRestrictions accessRestrictions) {
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
        PlaybackSettings other = (PlaybackSettings) o;
        return 
            Utils.enhancedDeepEquals(this.accessPolicy, other.accessPolicy) &&
            Utils.enhancedDeepEquals(this.accessRestrictions, other.accessRestrictions);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            accessPolicy, accessRestrictions);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PlaybackSettings.class,
                "accessPolicy", accessPolicy,
                "accessRestrictions", accessRestrictions);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private BasicAccessPolicy accessPolicy;

        private PlaybackIdAccessRestrictions accessRestrictions;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Basic access policy for media content
         */
        public Builder accessPolicy(@Nullable BasicAccessPolicy accessPolicy) {
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

        public PlaybackSettings build() {
            return new PlaybackSettings(
                accessPolicy, accessRestrictions);
        }


        private static final LazySingletonValue<BasicAccessPolicy> _SINGLETON_VALUE_AccessPolicy =
                new LazySingletonValue<>(
                        "accessPolicy",
                        "\"public\"",
                        new TypeReference<BasicAccessPolicy>() {});
    }
}
