package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.util.Optional;
import io.fastpix.sdk.models.components.DefaultError;
import io.fastpix.sdk.models.components.SimulcastUpdateResponse;
import io.fastpix.sdk.utils.Response;
import io.fastpix.sdk.utils.Utils;


public class UpdateSpecificSimulcastOfStreamResponse implements Response {

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
    private HttpResponse<InputStream> rawResponse;

    /**
     * Stream's simulcast details fetched successfully
     */
    private SimulcastUpdateResponse simulcastUpdateResponse;

    /**
     * See the range of possible <a href="https://fastpix.com/docs/error-codes/error-codes">error</a>
     * responses and their status codes.
     */
    private DefaultError defaultError;

    @JsonCreator
    public UpdateSpecificSimulcastOfStreamResponse(
            @Nonnull String contentType,
            int statusCode,
            @Nonnull HttpResponse<InputStream> rawResponse,
            @Nullable SimulcastUpdateResponse simulcastUpdateResponse,
            @Nullable DefaultError defaultError) {
        this.contentType = Optional.ofNullable(contentType)
            .orElseThrow(() -> new IllegalArgumentException("contentType cannot be null"));
        this.statusCode = statusCode;
        this.rawResponse = Optional.ofNullable(rawResponse)
            .orElseThrow(() -> new IllegalArgumentException("rawResponse cannot be null"));
        this.simulcastUpdateResponse = simulcastUpdateResponse;
        this.defaultError = defaultError;
    }
    
    public UpdateSpecificSimulcastOfStreamResponse(
            @Nonnull String contentType,
            int statusCode,
            @Nonnull HttpResponse<InputStream> rawResponse) {
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
    public HttpResponse<InputStream> rawResponse() {
        return this.rawResponse;
    }

    /**
     * Stream's simulcast details fetched successfully
     */
    public Optional<SimulcastUpdateResponse> simulcastUpdateResponse() {
        return Optional.ofNullable(this.simulcastUpdateResponse);
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
    public UpdateSpecificSimulcastOfStreamResponse withContentType(@Nonnull String contentType) {
        this.contentType = Utils.checkNotNull(contentType, CONTENT_TYPE);
        return this;
    }


    /**
     * HTTP response status code for this operation
     */
    public UpdateSpecificSimulcastOfStreamResponse withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }


    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public UpdateSpecificSimulcastOfStreamResponse withRawResponse(@Nonnull HttpResponse<InputStream> rawResponse) {
        this.rawResponse = Utils.checkNotNull(rawResponse, RAW_RESPONSE);
        return this;
    }


    /**
     * Stream's simulcast details fetched successfully
     */
    public UpdateSpecificSimulcastOfStreamResponse withSimulcastUpdateResponse(@Nullable SimulcastUpdateResponse simulcastUpdateResponse) {
        this.simulcastUpdateResponse = simulcastUpdateResponse;
        return this;
    }


    /**
     * See the range of possible <a href="https://fastpix.com/docs/error-codes/error-codes">error</a>
     * responses and their status codes.
     */
    public UpdateSpecificSimulcastOfStreamResponse withDefaultError(@Nullable DefaultError defaultError) {
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
        UpdateSpecificSimulcastOfStreamResponse other = (UpdateSpecificSimulcastOfStreamResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.simulcastUpdateResponse, other.simulcastUpdateResponse) &&
            Utils.enhancedDeepEquals(this.defaultError, other.defaultError);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            simulcastUpdateResponse, defaultError);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateSpecificSimulcastOfStreamResponse.class,
                CONTENT_TYPE, contentType,
                "statusCode", statusCode,
                RAW_RESPONSE, rawResponse,
                "simulcastUpdateResponse", simulcastUpdateResponse,
                "defaultError", defaultError);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String contentType;

        private int statusCode;

        private HttpResponse<InputStream> rawResponse;

        private SimulcastUpdateResponse simulcastUpdateResponse;

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
        public Builder rawResponse(@Nonnull HttpResponse<InputStream> rawResponse) {
            this.rawResponse = Utils.checkNotNull(rawResponse, RAW_RESPONSE);
            return this;
        }

        /**
         * Stream's simulcast details fetched successfully
         */
        public Builder simulcastUpdateResponse(@Nullable SimulcastUpdateResponse simulcastUpdateResponse) {
            this.simulcastUpdateResponse = simulcastUpdateResponse;
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

        public UpdateSpecificSimulcastOfStreamResponse build() {
            return new UpdateSpecificSimulcastOfStreamResponse(
                contentType, statusCode, rawResponse,
                simulcastUpdateResponse, defaultError);
        }

    }
}
