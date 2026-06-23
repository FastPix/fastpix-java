package io.fastpix.sdk.models.operations.async;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.net.http.HttpResponse;
import java.util.Optional;
import io.fastpix.sdk.models.components.DefaultError;
import io.fastpix.sdk.models.components.LiveStreamResponseDTO;
import io.fastpix.sdk.utils.AsyncResponse;
import io.fastpix.sdk.utils.Blob;
import io.fastpix.sdk.utils.Utils;


public class CreateNewStreamResponse implements AsyncResponse {

    private static final String CONTENT_TYPE_FIELD = "contentType";
    private static final String RAW_RESPONSE_FIELD = "rawResponse";

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
     * Stream created successfully
     */
    private LiveStreamResponseDTO liveStreamResponseDTO;

    /**
     * See the range of possible <a href="https://fastpix.com/docs/error-codes/error-codes">error</a>
     * responses and their status codes.
     */
    private DefaultError defaultError;

    @JsonCreator
    public CreateNewStreamResponse(
            @Nonnull String contentType,
            int statusCode,
            @Nonnull HttpResponse<Blob> rawResponse,
            @Nullable LiveStreamResponseDTO liveStreamResponseDTO,
            @Nullable DefaultError defaultError) {
        this.contentType = Optional.ofNullable(contentType)
            .orElseThrow(() -> new IllegalArgumentException("contentType cannot be null"));
        this.statusCode = statusCode;
        this.rawResponse = Optional.ofNullable(rawResponse)
            .orElseThrow(() -> new IllegalArgumentException("rawResponse cannot be null"));
        this.liveStreamResponseDTO = liveStreamResponseDTO;
        this.defaultError = defaultError;
    }
    
    public CreateNewStreamResponse(
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
     * Stream created successfully
     */
    public Optional<LiveStreamResponseDTO> liveStreamResponseDTO() {
        return Optional.ofNullable(this.liveStreamResponseDTO);
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
    public CreateNewStreamResponse withContentType(@Nonnull String contentType) {
        this.contentType = Utils.checkNotNull(contentType, CONTENT_TYPE_FIELD);
        return this;
    }


    /**
     * HTTP response status code for this operation
     */
    public CreateNewStreamResponse withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }


    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public CreateNewStreamResponse withRawResponse(@Nonnull HttpResponse<Blob> rawResponse) {
        this.rawResponse = Utils.checkNotNull(rawResponse, RAW_RESPONSE_FIELD);
        return this;
    }


    /**
     * Stream created successfully
     */
    public CreateNewStreamResponse withLiveStreamResponseDTO(@Nullable LiveStreamResponseDTO liveStreamResponseDTO) {
        this.liveStreamResponseDTO = liveStreamResponseDTO;
        return this;
    }


    /**
     * See the range of possible <a href="https://fastpix.com/docs/error-codes/error-codes">error</a>
     * responses and their status codes.
     */
    public CreateNewStreamResponse withDefaultError(@Nullable DefaultError defaultError) {
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
        CreateNewStreamResponse other = (CreateNewStreamResponse) o;
        return 
            Utils.enhancedDeepEquals(this.contentType, other.contentType) &&
            Utils.enhancedDeepEquals(this.statusCode, other.statusCode) &&
            Utils.enhancedDeepEquals(this.rawResponse, other.rawResponse) &&
            Utils.enhancedDeepEquals(this.liveStreamResponseDTO, other.liveStreamResponseDTO) &&
            Utils.enhancedDeepEquals(this.defaultError, other.defaultError);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            contentType, statusCode, rawResponse,
            liveStreamResponseDTO, defaultError);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateNewStreamResponse.class,
                CONTENT_TYPE_FIELD, contentType,
                "statusCode", statusCode,
                RAW_RESPONSE_FIELD, rawResponse,
                "liveStreamResponseDTO", liveStreamResponseDTO,
                "defaultError", defaultError);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String contentType;

        private int statusCode;

        private HttpResponse<Blob> rawResponse;

        private LiveStreamResponseDTO liveStreamResponseDTO;

        private DefaultError defaultError;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * HTTP response content type for this operation
         */
        public Builder contentType(@Nonnull String contentType) {
            this.contentType = Utils.checkNotNull(contentType, CONTENT_TYPE_FIELD);
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
            this.rawResponse = Utils.checkNotNull(rawResponse, RAW_RESPONSE_FIELD);
            return this;
        }

        /**
         * Stream created successfully
         */
        public Builder liveStreamResponseDTO(@Nullable LiveStreamResponseDTO liveStreamResponseDTO) {
            this.liveStreamResponseDTO = liveStreamResponseDTO;
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

        public CreateNewStreamResponse build() {
            return new CreateNewStreamResponse(
                contentType, statusCode, rawResponse,
                liveStreamResponseDTO, defaultError);
        }

    }
}
