package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.util.Optional;
import io.fastpix.sdk.models.components.AccessPolicy;
import io.fastpix.sdk.utils.Utils;

/**
 * CreateMediaPlaybackIdRequestBody
 * 
 * <p>Request body for creating playback id for an media
 */
public class CreateMediaPlaybackIdRequestBody {

    private static final String ACCESS_POLICY_FIELD = "accessPolicy";

    /**
     * Access policy for media content
     */
    @JsonProperty("accessPolicy")
    private AccessPolicy accessPolicy;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("accessRestrictions")
    private CreateMediaPlaybackIdAccessRestrictions accessRestrictions;

    /**
     * DRM configuration ID (required if accessPolicy is "drm")
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("drmConfigurationId")
    private String drmConfigurationId;

    /**
     * The maximum resolution for the playback ID.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("resolution")
    private Resolution resolution;

    @JsonCreator
    public CreateMediaPlaybackIdRequestBody(
            @JsonProperty("accessPolicy") @Nonnull AccessPolicy accessPolicy,
            @JsonProperty("accessRestrictions") @Nullable CreateMediaPlaybackIdAccessRestrictions accessRestrictions,
            @JsonProperty("drmConfigurationId") @Nullable String drmConfigurationId,
            @JsonProperty("resolution") @Nullable Resolution resolution) {
        this.accessPolicy = Optional.ofNullable(accessPolicy)
            .orElseThrow(() -> new IllegalArgumentException("accessPolicy cannot be null"));
        this.accessRestrictions = accessRestrictions;
        this.drmConfigurationId = drmConfigurationId;
        this.resolution = resolution;
    }
    
    public CreateMediaPlaybackIdRequestBody(
            @Nonnull AccessPolicy accessPolicy) {
        this(accessPolicy, null, null,
            null);
    }

    /**
     * Access policy for media content
     */
    public AccessPolicy accessPolicy() {
        return this.accessPolicy;
    }

    public Optional<CreateMediaPlaybackIdAccessRestrictions> accessRestrictions() {
        return Optional.ofNullable(this.accessRestrictions);
    }

    /**
     * DRM configuration ID (required if accessPolicy is "drm")
     */
    public Optional<String> drmConfigurationId() {
        return Optional.ofNullable(this.drmConfigurationId);
    }

    /**
     * The maximum resolution for the playback ID.
     */
    public Optional<Resolution> resolution() {
        return Optional.ofNullable(this.resolution);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Access policy for media content
     */
    public CreateMediaPlaybackIdRequestBody withAccessPolicy(@Nonnull AccessPolicy accessPolicy) {
        this.accessPolicy = Utils.checkNotNull(accessPolicy, ACCESS_POLICY_FIELD);
        return this;
    }


    public CreateMediaPlaybackIdRequestBody withAccessRestrictions(@Nullable CreateMediaPlaybackIdAccessRestrictions accessRestrictions) {
        this.accessRestrictions = accessRestrictions;
        return this;
    }


    /**
     * DRM configuration ID (required if accessPolicy is "drm")
     */
    public CreateMediaPlaybackIdRequestBody withDrmConfigurationId(@Nullable String drmConfigurationId) {
        this.drmConfigurationId = drmConfigurationId;
        return this;
    }


    /**
     * The maximum resolution for the playback ID.
     */
    public CreateMediaPlaybackIdRequestBody withResolution(@Nullable Resolution resolution) {
        this.resolution = resolution;
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
        CreateMediaPlaybackIdRequestBody other = (CreateMediaPlaybackIdRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.accessPolicy, other.accessPolicy) &&
            Utils.enhancedDeepEquals(this.accessRestrictions, other.accessRestrictions) &&
            Utils.enhancedDeepEquals(this.drmConfigurationId, other.drmConfigurationId) &&
            Utils.enhancedDeepEquals(this.resolution, other.resolution);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            accessPolicy, accessRestrictions, drmConfigurationId,
            resolution);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateMediaPlaybackIdRequestBody.class,
                ACCESS_POLICY_FIELD, accessPolicy,
                "accessRestrictions", accessRestrictions,
                "drmConfigurationId", drmConfigurationId,
                "resolution", resolution);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private AccessPolicy accessPolicy;

        private CreateMediaPlaybackIdAccessRestrictions accessRestrictions;

        private String drmConfigurationId;

        private Resolution resolution;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Access policy for media content
         */
        public Builder accessPolicy(@Nonnull AccessPolicy accessPolicy) {
            this.accessPolicy = Utils.checkNotNull(accessPolicy, ACCESS_POLICY_FIELD);
            return this;
        }

        public Builder accessRestrictions(@Nullable CreateMediaPlaybackIdAccessRestrictions accessRestrictions) {
            this.accessRestrictions = accessRestrictions;
            return this;
        }

        /**
         * DRM configuration ID (required if accessPolicy is "drm")
         */
        public Builder drmConfigurationId(@Nullable String drmConfigurationId) {
            this.drmConfigurationId = drmConfigurationId;
            return this;
        }

        /**
         * The maximum resolution for the playback ID.
         */
        public Builder resolution(@Nullable Resolution resolution) {
            this.resolution = resolution;
            return this;
        }

        public CreateMediaPlaybackIdRequestBody build() {
            return new CreateMediaPlaybackIdRequestBody(
                accessPolicy, accessRestrictions, drmConfigurationId,
                resolution);
        }

    }
}
