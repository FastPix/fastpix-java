package io.fastpix.sdk.models.operations.async;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.net.http.HttpResponse;
import java.util.Optional;
import io.fastpix.sdk.models.components.DefaultError;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsResponseBody;
import io.fastpix.sdk.utils.AsyncResponse;
import io.fastpix.sdk.utils.Blob;
import io.fastpix.sdk.utils.Utils;


public class UpdateLiveStreamDomainRestrictionsResponse implements AsyncResponse {

    private static final String CONTENT_TYPE = "contentType";
    private static final String RAW_RESPONSE = "rawResponse";
    /**
     * HTTP response content type for this operation
     */
    private String contentType;

    /**
     * HTTP response status code for this operation
     */
    private int statusCode;

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    private HttpResponse<Blob> rawResponse;

    /**
     * Successfully updated domain restrictions
     */
    private UpdateLiveStreamDomainRestrictionsResponseBody object;

    /**
     * See the range of possible <a href="https://fastpix.com/docs/error-codes/error-codes">error</a>
     * responses and their status codes.
     */
    private DefaultError defaultError;

    @JsonCreator
    public UpdateLiveStreamDomainRestrictionsResponse(
            @Nonnull String contentType,
            int statusCode,
            @Nonnull HttpResponse<Blob> rawResponse,
            @Nullable UpdateLiveStreamDomainRestrictionsResponseBody object,
            @Nullable DefaultError defaultError) {
        this.contentType = Optional.ofNullable(contentType)
            .orElseThrow(() -> new IllegalArgumentException("contentType cannot be null"));
        this.statusCode = statusCode;
        this.rawResponse = Optional.ofNullable(rawResponse)
            .orElseThrow(() -> new IllegalArgumentException("rawResponse cannot be null"));
        this.object = object;
        this.defaultError = defaultError;
    }
    
    public UpdateLiveStreamDomainRestrictionsResponse(
            @Nonnull String contentType,
            int statusCode,
            @Nonnull HttpResponse<Blob> rawResponse) {
        this(contentType, statusCode, rawResponse,
            null, null);
    }

    /**
     * HTTP response content type for this operation
     */
    public String contentType() {
        return this.contentType;
    }

    /**
     * HTTP response status code for this operation
     */
    public int statusCode() {
        return this.statusCode;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public HttpResponse<Blob> rawResponse() {
        return this.rawResponse;
    }

    /**
     * Successfully updated domain restrictions
     */
    public Optional<UpdateLiveStreamDomainRestrictionsResponseBody> object() {
        return Optional.ofNullable(this.object);
    }

    /**
     * See the range of possible <a href="https://fastpix.com/docs/error-codes/error-codes">error</a>
     * responses and their status codes.
     */
    public Optional<DefaultError> defaultError() {
        return Optional.ofNullable(this.defaultError);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * HTTP response content type for this operation
     */
    public UpdateLiveStreamDomainRestrictionsResponse withContentType(@Nonnull String contentType) {
        this.contentType = Utils.checkNotNull(contentType, CONTENT_TYPE);
        return this;
    }


    /**
     * HTTP response status code for this operation
     */
    public UpdateLiveStreamDomainRestrictionsResponse withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }


    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public UpdateLiveStreamDomainRestrictionsResponse withRawResponse(@Nonnull HttpResponse<Blob> rawResponse) {
        this.rawResponse = Utils.checkNotNull(rawResponse, RAW_RESPONSE);
        return this;
    }


    /**
     * Successfully updated domain restrictions
     */
    public UpdateLiveStreamDomainRestrictionsResponse withObject(@Nullable UpdateLiveStreamDomainRestrictionsResponseBody object) {
        this.object = object;
        return this;
    }


    /**
     * See the range of possible <a href="https://fastpix.com/docs/error-codes/error-codes">error</a>
     * responses and their status codes.
     */
    public UpdateLiveStreamDomainRestrictionsResponse withDefaultError(@Nullable DefaultError defaultError) {
        this.defaultError = defaultError;
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
        UpdateLiveStreamDomainRestrictionsResponse other = (UpdateLiveStreamDomainRestrictionsResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.object, other.object) &&
            Utils.enhancedDeepEquals(this.defaultError, other.defaultError);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            object, defaultError);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateLiveStreamDomainRestrictionsResponse.class,
                CONTENT_TYPE, contentType,
                "statusCode", statusCode,
                RAW_RESPONSE, rawResponse,
                "object", object,
                "defaultError", defaultError);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String contentType;

        private int statusCode;

        private HttpResponse<Blob> rawResponse;

        private UpdateLiveStreamDomainRestrictionsResponseBody object;

        private DefaultError defaultError;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * HTTP response content type for this operation
         */
        public Builder contentType(@Nonnull String contentType) {
            this.contentType = Utils.checkNotNull(contentType, CONTENT_TYPE);
            return this;
        }

        /**
         * HTTP response status code for this operation
         */
        public Builder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        /**
         * Raw HTTP response; suitable for custom response parsing
         */
        public Builder rawResponse(@Nonnull HttpResponse<Blob> rawResponse) {
            this.rawResponse = Utils.checkNotNull(rawResponse, RAW_RESPONSE);
            return this;
        }

        /**
         * Successfully updated domain restrictions
         */
        public Builder object(@Nullable UpdateLiveStreamDomainRestrictionsResponseBody object) {
            this.object = object;
            return this;
        }

        /**
         * See the range of possible <a href="https://fastpix.com/docs/error-codes/error-codes">error</a>
         * responses and their status codes.
         */
        public Builder defaultError(@Nullable DefaultError defaultError) {
            this.defaultError = defaultError;
            return this;
        }

        public UpdateLiveStreamDomainRestrictionsResponse build() {
            return new UpdateLiveStreamDomainRestrictionsResponse(
                contentType, statusCode, rawResponse,
                object, defaultError);
        }

    }
}
