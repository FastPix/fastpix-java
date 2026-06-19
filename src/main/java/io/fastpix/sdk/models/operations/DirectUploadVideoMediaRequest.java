package io.fastpix.sdk.models.operations;

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
 * DirectUploadVideoMediaRequest
 * 
 * <p>Request body for direct upload
 */
public class DirectUploadVideoMediaRequest {

    private static final String CORS_ORIGIN = "corsOrigin";
    private static final String PUSH_MEDIA_SETTINGS = "pushMediaSettings";
    /**
     * Upload media directly from a device using the URL name or enter "*" to allow all.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty(CORS_ORIGIN)
    private String corsOrigin;

    /**
     * Configuration settings for uploading and processing media on the FastPix platform.
     * These settings define how the uploaded video is handled, including access control, resolution, DRM,
     * and optional metadata.
     * For a complete explanation of how media uploads and processing work, refer to the
     * <a href="https://fastpix.com/docs/video-on-demand-api/overview">FastPix Video on Demand
     * Overview</a>.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty(PUSH_MEDIA_SETTINGS)
    private PushMediaSettings pushMediaSettings;

    @JsonCreator
    public DirectUploadVideoMediaRequest(
            @JsonProperty(CORS_ORIGIN) @Nullable String corsOrigin,
            @JsonProperty(PUSH_MEDIA_SETTINGS) @Nullable PushMediaSettings pushMediaSettings) {
        this.corsOrigin = Optional.ofNullable(corsOrigin)
            .orElse(Builder._SINGLETON_VALUE_CorsOrigin.value());
        this.pushMediaSettings = pushMediaSettings;
    }
    
    public DirectUploadVideoMediaRequest() {
        this(null, null);
    }

    /**
     * Upload media directly from a device using the URL name or enter "*" to allow all.
     */
    public Optional<String> corsOrigin() {
        return Optional.ofNullable(this.corsOrigin);
    }

    /**
     * Configuration settings for uploading and processing media on the FastPix platform.
     * These settings define how the uploaded video is handled, including access control, resolution, DRM,
     * and optional metadata.
     * For a complete explanation of how media uploads and processing work, refer to the
     * <a href="https://fastpix.com/docs/video-on-demand-api/overview">FastPix Video on Demand
     * Overview</a>.
     */
    public Optional<PushMediaSettings> pushMediaSettings() {
        return Optional.ofNullable(this.pushMediaSettings);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Upload media directly from a device using the URL name or enter "*" to allow all.
     */
    public DirectUploadVideoMediaRequest withCorsOrigin(@Nullable String corsOrigin) {
        this.corsOrigin = corsOrigin;
        return this;
    }


    /**
     * Configuration settings for uploading and processing media on the FastPix platform.
     * These settings define how the uploaded video is handled, including access control, resolution, DRM,
     * and optional metadata.
     * For a complete explanation of how media uploads and processing work, refer to the
     * <a href="https://fastpix.com/docs/video-on-demand-api/overview">FastPix Video on Demand
     * Overview</a>.
     */
    public DirectUploadVideoMediaRequest withPushMediaSettings(@Nullable PushMediaSettings pushMediaSettings) {
        this.pushMediaSettings = pushMediaSettings;
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
        DirectUploadVideoMediaRequest other = (DirectUploadVideoMediaRequest) o;
        return 
            Utils.enhancedDeepEquals(this.corsOrigin, other.corsOrigin) &&
            Utils.enhancedDeepEquals(this.pushMediaSettings, other.pushMediaSettings);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            corsOrigin, pushMediaSettings);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DirectUploadVideoMediaRequest.class,
                CORS_ORIGIN, corsOrigin,
                PUSH_MEDIA_SETTINGS, pushMediaSettings);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String corsOrigin;

        private PushMediaSettings pushMediaSettings;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Upload media directly from a device using the URL name or enter "*" to allow all.
         */
        public Builder corsOrigin(@Nullable String corsOrigin) {
            this.corsOrigin = corsOrigin;
            return this;
        }

        /**
         * Configuration settings for uploading and processing media on the FastPix platform.
         * These settings define how the uploaded video is handled, including access control, resolution, DRM,
         * and optional metadata.
         * For a complete explanation of how media uploads and processing work, refer to the
         * <a href="https://fastpix.com/docs/video-on-demand-api/overview">FastPix Video on Demand
         * Overview</a>.
         */
        public Builder pushMediaSettings(@Nullable PushMediaSettings pushMediaSettings) {
            this.pushMediaSettings = pushMediaSettings;
            return this;
        }

        public DirectUploadVideoMediaRequest build() {
            return new DirectUploadVideoMediaRequest(
                corsOrigin, pushMediaSettings);
        }


        private static final LazySingletonValue<String> _SINGLETON_VALUE_CorsOrigin =
                new LazySingletonValue<>(
                        CORS_ORIGIN,
                        "\"*\"",
                        new TypeReference<String>() {});
    }
}
