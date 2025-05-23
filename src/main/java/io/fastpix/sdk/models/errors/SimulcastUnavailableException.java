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
public class SimulcastUnavailableException extends RuntimeException {

    /**
     * It demonstrates whether the request is successful or not.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("success")
    private Optional<Boolean> success;

    /**
     * Returns the problem that has occured.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("error")
    private Optional<? extends SimulcastUnavailableError> error;

    @JsonCreator
    public SimulcastUnavailableException(
            @JsonProperty("success") Optional<Boolean> success,
            @JsonProperty("error") Optional<? extends SimulcastUnavailableError> error) {
        Utils.checkNotNull(success, "success");
        Utils.checkNotNull(error, "error");
        this.success = success;
        this.error = error;
    }
    
    public SimulcastUnavailableException() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * It demonstrates whether the request is successful or not.
     */
    @JsonIgnore
    public Optional<Boolean> success() {
        return success;
    }

    /**
     * Returns the problem that has occured.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<SimulcastUnavailableError> error() {
        return (Optional<SimulcastUnavailableError>) error;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * It demonstrates whether the request is successful or not.
     */
    public SimulcastUnavailableException withSuccess(boolean success) {
        Utils.checkNotNull(success, "success");
        this.success = Optional.ofNullable(success);
        return this;
    }

    /**
     * It demonstrates whether the request is successful or not.
     */
    public SimulcastUnavailableException withSuccess(Optional<Boolean> success) {
        Utils.checkNotNull(success, "success");
        this.success = success;
        return this;
    }

    /**
     * Returns the problem that has occured.
     */
    public SimulcastUnavailableException withError(SimulcastUnavailableError error) {
        Utils.checkNotNull(error, "error");
        this.error = Optional.ofNullable(error);
        return this;
    }

    /**
     * Returns the problem that has occured.
     */
    public SimulcastUnavailableException withError(Optional<? extends SimulcastUnavailableError> error) {
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
        SimulcastUnavailableException other = (SimulcastUnavailableException) o;
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
        return Utils.toString(SimulcastUnavailableException.class,
                "success", success,
                "error", error);
    }
    
    public final static class Builder {
 
        private Optional<Boolean> success = Optional.empty();
 
        private Optional<? extends SimulcastUnavailableError> error = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * It demonstrates whether the request is successful or not.
         */
        public Builder success(boolean success) {
            Utils.checkNotNull(success, "success");
            this.success = Optional.ofNullable(success);
            return this;
        }

        /**
         * It demonstrates whether the request is successful or not.
         */
        public Builder success(Optional<Boolean> success) {
            Utils.checkNotNull(success, "success");
            this.success = success;
            return this;
        }

        /**
         * Returns the problem that has occured.
         */
        public Builder error(SimulcastUnavailableError error) {
            Utils.checkNotNull(error, "error");
            this.error = Optional.ofNullable(error);
            return this;
        }

        /**
         * Returns the problem that has occured.
         */
        public Builder error(Optional<? extends SimulcastUnavailableError> error) {
            Utils.checkNotNull(error, "error");
            this.error = error;
            return this;
        }
        
        public SimulcastUnavailableException build() {
            return new SimulcastUnavailableException(
                success,
                error);
        }
    }
}

