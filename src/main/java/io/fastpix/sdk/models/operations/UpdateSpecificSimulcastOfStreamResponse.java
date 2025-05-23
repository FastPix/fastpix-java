/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.fastpix.sdk.models.components.SimulcastUpdateResponse;
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

public class UpdateSpecificSimulcastOfStreamResponse implements Response {

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
    private Optional<? extends SimulcastUpdateResponse> simulcastUpdateResponse;

    @JsonCreator
    public UpdateSpecificSimulcastOfStreamResponse(
            String contentType,
            int statusCode,
            HttpResponse<InputStream> rawResponse,
            Optional<? extends SimulcastUpdateResponse> simulcastUpdateResponse) {
        Utils.checkNotNull(contentType, "contentType");
        Utils.checkNotNull(statusCode, "statusCode");
        Utils.checkNotNull(rawResponse, "rawResponse");
        Utils.checkNotNull(simulcastUpdateResponse, "simulcastUpdateResponse");
        this.contentType = contentType;
        this.statusCode = statusCode;
        this.rawResponse = rawResponse;
        this.simulcastUpdateResponse = simulcastUpdateResponse;
    }
    
    public UpdateSpecificSimulcastOfStreamResponse(
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
     * Stream's simulcast details fetched successfully
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<SimulcastUpdateResponse> simulcastUpdateResponse() {
        return (Optional<SimulcastUpdateResponse>) simulcastUpdateResponse;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * HTTP response content type for this operation
     */
    public UpdateSpecificSimulcastOfStreamResponse withContentType(String contentType) {
        Utils.checkNotNull(contentType, "contentType");
        this.contentType = contentType;
        return this;
    }

    /**
     * HTTP response status code for this operation
     */
    public UpdateSpecificSimulcastOfStreamResponse withStatusCode(int statusCode) {
        Utils.checkNotNull(statusCode, "statusCode");
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Raw HTTP response; suitable for custom response parsing
     */
    public UpdateSpecificSimulcastOfStreamResponse withRawResponse(HttpResponse<InputStream> rawResponse) {
        Utils.checkNotNull(rawResponse, "rawResponse");
        this.rawResponse = rawResponse;
        return this;
    }

    /**
     * Stream's simulcast details fetched successfully
     */
    public UpdateSpecificSimulcastOfStreamResponse withSimulcastUpdateResponse(SimulcastUpdateResponse simulcastUpdateResponse) {
        Utils.checkNotNull(simulcastUpdateResponse, "simulcastUpdateResponse");
        this.simulcastUpdateResponse = Optional.ofNullable(simulcastUpdateResponse);
        return this;
    }

    /**
     * Stream's simulcast details fetched successfully
     */
    public UpdateSpecificSimulcastOfStreamResponse withSimulcastUpdateResponse(Optional<? extends SimulcastUpdateResponse> simulcastUpdateResponse) {
        Utils.checkNotNull(simulcastUpdateResponse, "simulcastUpdateResponse");
        this.simulcastUpdateResponse = simulcastUpdateResponse;
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
            Objects.deepEquals(this.contentType, other.contentType) &&
            Objects.deepEquals(this.statusCode, other.statusCode) &&
            Objects.deepEquals(this.rawResponse, other.rawResponse) &&
            Objects.deepEquals(this.simulcastUpdateResponse, other.simulcastUpdateResponse);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            contentType,
            statusCode,
            rawResponse,
            simulcastUpdateResponse);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateSpecificSimulcastOfStreamResponse.class,
                "contentType", contentType,
                "statusCode", statusCode,
                "rawResponse", rawResponse,
                "simulcastUpdateResponse", simulcastUpdateResponse);
    }
    
    public final static class Builder {
 
        private String contentType;
 
        private Integer statusCode;
 
        private HttpResponse<InputStream> rawResponse;
 
        private Optional<? extends SimulcastUpdateResponse> simulcastUpdateResponse = Optional.empty();
        
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
         * Stream's simulcast details fetched successfully
         */
        public Builder simulcastUpdateResponse(SimulcastUpdateResponse simulcastUpdateResponse) {
            Utils.checkNotNull(simulcastUpdateResponse, "simulcastUpdateResponse");
            this.simulcastUpdateResponse = Optional.ofNullable(simulcastUpdateResponse);
            return this;
        }

        /**
         * Stream's simulcast details fetched successfully
         */
        public Builder simulcastUpdateResponse(Optional<? extends SimulcastUpdateResponse> simulcastUpdateResponse) {
            Utils.checkNotNull(simulcastUpdateResponse, "simulcastUpdateResponse");
            this.simulcastUpdateResponse = simulcastUpdateResponse;
            return this;
        }
        
        public UpdateSpecificSimulcastOfStreamResponse build() {
            return new UpdateSpecificSimulcastOfStreamResponse(
                contentType,
                statusCode,
                rawResponse,
                simulcastUpdateResponse);
        }
    }
}
