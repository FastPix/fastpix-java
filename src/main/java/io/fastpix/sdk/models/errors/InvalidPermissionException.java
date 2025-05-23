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
public class InvalidPermissionException extends RuntimeException {

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
    private Optional<? extends InvalidPermissionError> error;

    @JsonCreator
    public InvalidPermissionException(
            @JsonProperty("success") Optional<Boolean> success,
            @JsonProperty("error") Optional<? extends InvalidPermissionError> error) {
        Utils.checkNotNull(success, "success");
        Utils.checkNotNull(error, "error");
        this.success = success;
        this.error = error;
    }
    
    public InvalidPermissionException() {
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
    public Optional<InvalidPermissionError> error() {
        return (Optional<InvalidPermissionError>) error;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Demonstrates whether the request is successful or not.
     */
    public InvalidPermissionException withSuccess(boolean success) {
        Utils.checkNotNull(success, "success");
        this.success = Optional.ofNullable(success);
        return this;
    }

    /**
     * Demonstrates whether the request is successful or not.
     */
    public InvalidPermissionException withSuccess(Optional<Boolean> success) {
        Utils.checkNotNull(success, "success");
        this.success = success;
        return this;
    }

    /**
     * Displays details about the reasons behind the request's failure.
     */
    public InvalidPermissionException withError(InvalidPermissionError error) {
        Utils.checkNotNull(error, "error");
        this.error = Optional.ofNullable(error);
        return this;
    }

    /**
     * Displays details about the reasons behind the request's failure.
     */
    public InvalidPermissionException withError(Optional<? extends InvalidPermissionError> error) {
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
        InvalidPermissionException other = (InvalidPermissionException) o;
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
        return Utils.toString(InvalidPermissionException.class,
                "success", success,
                "error", error);
    }
    
    public final static class Builder {
 
        private Optional<Boolean> success = Optional.empty();
 
        private Optional<? extends InvalidPermissionError> error = Optional.empty();
        
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
        public Builder error(InvalidPermissionError error) {
            Utils.checkNotNull(error, "error");
            this.error = Optional.ofNullable(error);
            return this;
        }

        /**
         * Displays details about the reasons behind the request's failure.
         */
        public Builder error(Optional<? extends InvalidPermissionError> error) {
            Utils.checkNotNull(error, "error");
            this.error = error;
            return this;
        }
        
        public InvalidPermissionException build() {
            return new InvalidPermissionException(
                success,
                error);
        }
    }
}

