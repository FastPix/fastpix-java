/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.fastpix.sdk.models.components.LiveStreamResponseDTO;
import io.fastpix.sdk.utils.Response;
import io.fastpix.sdk.utils.Utils;
import java.io.InputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.Optional;

public class CreateNewStreamResponse implements Response {

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
     * Stream created successfully
     */
    private Optional<? extends LiveStreamResponseDTO> liveStreamResponseDTO;

    @JsonCreator
    public CreateNewStreamResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends LiveStreamResponseDTO> liveStreamResponseDTO) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(liveStreamResponseDTO, "liveStreamResponseDTO");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.liveStreamResponseDTO = liveStreamResponseDTO;
    }
    
    public CreateNewStreamResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse) {
        this(contentType, statusCode, rawResponse, Optional.empty());
    }

    /**
     * HTTP response content type for this operation
     */
    @JsonIgnore
    public String contentType() {
        return contentType;
    }

    /**
     * HTTP response status code for this operation
     */
    @JsonIgnore
    public int statusCode() {
        return statusCode;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    @JsonIgnore
    public HttpResponse<InputStream> rawResponse() {
        return rawResponse;
    }

    /**
     * Stream created successfully
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<LiveStreamResponseDTO> liveStreamResponseDTO() {
        return (Optional<LiveStreamResponseDTO>) liveStreamResponseDTO;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * HTTP response content type for this operation
     */
    public CreateNewStreamResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public CreateNewStreamResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public CreateNewStreamResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Stream created successfully
     */
    public CreateNewStreamResponse withLiveStreamResponseDTO(LiveStreamResponseDTO liveStreamResponseDTO) {
        Utils.checkNotNull(liveStreamResponseDTO, "liveStreamResponseDTO");
        this.liveStreamResponseDTO = Optional.ofNullable(liveStreamResponseDTO);
        return this;
    }

    /**
     * Stream created successfully
     */
    public CreateNewStreamResponse withLiveStreamResponseDTO(Optional<? extends LiveStreamResponseDTO> liveStreamResponseDTO) {
        Utils.checkNotNull(liveStreamResponseDTO, "liveStreamResponseDTO");
        this.liveStreamResponseDTO = liveStreamResponseDTO;
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
            Objects.deepEquals(this.contentType, other.contentType) &&
            Objects.deepEquals(this.statusCode, other.statusCode) &&
            Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            Objects.deepEquals(this.liveStreamResponseDTO, other.liveStreamResponseDTO);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            liveStreamResponseDTO);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateNewStreamResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "liveStreamResponseDTO", liveStreamResponseDTO);
    }
    
    public final static class Builder {
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends LiveStreamResponseDTO> liveStreamResponseDTO = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * HTTP response content type for this operation
         */
        public Builder contentType(String contentType) {
            Utils.checkNotNull(contentType, "contentType");
            this.contentType = contentType;
            return this;
        }

        /**
         * HTTP response status code for this operation
         */
        public Builder statusCode(int statusCode) {
            Utils.checkNotNull(statusCode, "statusCode");
            this.statusCode = statusCode;
            return this;
        }

        /**
         * Raw HTTP response; suitable for custom response parsing
         */
        public Builder rawResponse(HttpResponse<InputStream> rawResponse) {
            Utils.checkNotNull(rawResponse, "rawResponse");
            this.rawResponse = rawResponse;
            return this;
        }

        /**
         * Stream created successfully
         */
        public Builder liveStreamResponseDTO(LiveStreamResponseDTO liveStreamResponseDTO) {
            Utils.checkNotNull(liveStreamResponseDTO, "liveStreamResponseDTO");
            this.liveStreamResponseDTO = Optional.ofNullable(liveStreamResponseDTO);
            return this;
        }

        /**
         * Stream created successfully
         */
        public Builder liveStreamResponseDTO(Optional<? extends LiveStreamResponseDTO> liveStreamResponseDTO) {
            Utils.checkNotNull(liveStreamResponseDTO, "liveStreamResponseDTO");
            this.liveStreamResponseDTO = liveStreamResponseDTO;
            return this;
        }
        
        public CreateNewStreamResponse build() {
            return new CreateNewStreamResponse(
                contentType,
                statusCode,
                rawResponse,
                liveStreamResponseDTO);
        }
    }
}
