/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class DeleteMediaResponse implements Response {

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
     * Delete a video media
     */
    private Optional<? extends DeleteMediaResponseBody> object;

    @JsonCreator
    public DeleteMediaResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends DeleteMediaResponseBody> object) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(object, "object");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.object = object;
    }
    
    public DeleteMediaResponse(
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
     * Delete a video media
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<DeleteMediaResponseBody> object() {
        return (Optional<DeleteMediaResponseBody>) object;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * HTTP response content type for this operation
     */
    public DeleteMediaResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public DeleteMediaResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public DeleteMediaResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Delete a video media
     */
    public DeleteMediaResponse withObject(DeleteMediaResponseBody object) {
        Utils.checkNotNull(object, "object");
        this.object = Optional.ofNullable(object);
        return this;
    }

    /**
     * Delete a video media
     */
    public DeleteMediaResponse withObject(Optional<? extends DeleteMediaResponseBody> object) {
        Utils.checkNotNull(object, "object");
        this.object = object;
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
        DeleteMediaResponse other = (DeleteMediaResponse) o;
        return 
            Objects.deepEquals(this.contentType, other.contentType) &&
            Objects.deepEquals(this.statusCode, other.statusCode) &&
            Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            Objects.deepEquals(this.object, other.object);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            object);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DeleteMediaResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "object", object);
    }
    
    public final static class Builder {
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends DeleteMediaResponseBody> object = Optional.empty();
        
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
         * Delete a video media
         */
        public Builder object(DeleteMediaResponseBody object) {
            Utils.checkNotNull(object, "object");
            this.object = Optional.ofNullable(object);
            return this;
        }

        /**
         * Delete a video media
         */
        public Builder object(Optional<? extends DeleteMediaResponseBody> object) {
            Utils.checkNotNull(object, "object");
            this.object = object;
            return this;
        }
        
        public DeleteMediaResponse build() {
            return new DeleteMediaResponse(
                contentType,
                statusCode,
                rawResponse,
                object);
        }
    }
}
