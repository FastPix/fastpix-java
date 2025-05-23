/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.errors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fastpix.sdk.utils.Utils;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {

    /**
     * Demonstrates whether the request is successful or not.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("success")
    private Optional<Boolean> success;

    /**
     * Displays details about the reasons behind the request's failure.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("error")
    private Optional<? extends BadRequestError> error;

    @JsonCreator
    public BadRequestException(
            @JsonProperty("success") Optional<Boolean> success,
            @JsonProperty("error") Optional<? extends BadRequestError> error) {
        Utils.checkNotNull(success, "success");
        Utils.checkNotNull(error, "error");
        this.success = success;
        this.error = error;
    }
    
    public BadRequestException() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * Demonstrates whether the request is successful or not.
     */
    @JsonIgnore
    public Optional<Boolean> success() {
        return success;
    }

    /**
     * Displays details about the reasons behind the request's failure.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<BadRequestError> error() {
        return (Optional<BadRequestError>) error;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Demonstrates whether the request is successful or not.
     */
    public BadRequestException withSuccess(boolean success) {
        Utils.checkNotNull(success, "success");
        this.success = Optional.ofNullable(success);
        return this;
    }

    /**
     * Demonstrates whether the request is successful or not.
     */
    public BadRequestException withSuccess(Optional<Boolean> success) {
        Utils.checkNotNull(success, "success");
        this.success = success;
        return this;
    }

    /**
     * Displays details about the reasons behind the request's failure.
     */
    public BadRequestException withError(BadRequestError error) {
        Utils.checkNotNull(error, "error");
        this.error = Optional.ofNullable(error);
        return this;
    }

    /**
     * Displays details about the reasons behind the request's failure.
     */
    public BadRequestException withError(Optional<? extends BadRequestError> error) {
        Utils.checkNotNull(error, "error");
        this.error = error;
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
        BadRequestException other = (BadRequestException) o;
        return 
            Objects.deepEquals(this.success, other.success) &&
            Objects.deepEquals(this.error, other.error);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            success,
            error);
    }
    
    @Override
    public String toString() {
        return Utils.toString(BadRequestException.class,
                "success", success,
                "error", error);
    }
    
    public final static class Builder {
 
        private Optional<Boolean> success = Optional.empty();
 
        private Optional<? extends BadRequestError> error = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Demonstrates whether the request is successful or not.
         */
        public Builder success(boolean success) {
            Utils.checkNotNull(success, "success");
            this.success = Optional.ofNullable(success);
            return this;
        }

        /**
         * Demonstrates whether the request is successful or not.
         */
        public Builder success(Optional<Boolean> success) {
            Utils.checkNotNull(success, "success");
            this.success = success;
            return this;
        }

        /**
         * Displays details about the reasons behind the request's failure.
         */
        public Builder error(BadRequestError error) {
            Utils.checkNotNull(error, "error");
            this.error = Optional.ofNullable(error);
            return this;
        }

        /**
         * Displays details about the reasons behind the request's failure.
         */
        public Builder error(Optional<? extends BadRequestError> error) {
            Utils.checkNotNull(error, "error");
            this.error = error;
            return this;
        }
        
        public BadRequestException build() {
            return new BadRequestException(
                success,
                error);
        }
    }
}

