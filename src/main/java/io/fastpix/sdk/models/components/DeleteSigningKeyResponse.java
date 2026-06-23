package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import java.util.Optional;
import io.fastpix.sdk.utils.Utils;


public class DeleteSigningKeyResponse {
    /**
     * Shows the request status. Returns true for success and false for failure.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("success")
    private Boolean success;

    /**
     * Additional response details (e.g. a human-readable confirmation message).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("data")
    private Data data;

    @JsonCreator
    public DeleteSigningKeyResponse(
            @JsonProperty("success") @Nullable Boolean success,
            @JsonProperty("data") @Nullable Data data) {
        this.success = success;
        this.data = data;
    }

    public DeleteSigningKeyResponse() {
        this(null, null);
    }

    /**
     * Shows the request status. Returns true for success and false for failure.
     */
    public Optional<Boolean> success() {
        return Optional.ofNullable(this.success);
    }

    /**
     * Additional response details (e.g. a human-readable confirmation message).
     */
    public Optional<Data> data() {
        return Optional.ofNullable(this.data);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Shows the request status. Returns true for success and false for failure.
     */
    public DeleteSigningKeyResponse withSuccess(@Nullable Boolean success) {
        this.success = success;
        return this;
    }


    /**
     * Additional response details (e.g. a human-readable confirmation message).
     */
    public DeleteSigningKeyResponse withData(@Nullable Data data) {
        this.data = data;
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
        DeleteSigningKeyResponse other = (DeleteSigningKeyResponse) o;
        return
            Utils.enhancedDeepEquals(this.success, other.success) &&
            Utils.enhancedDeepEquals(this.data, other.data);
    }

    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            success, data);
    }

    @Override
    public String toString() {
        return Utils.toString(DeleteSigningKeyResponse.class,
                "success", success,
                "data", data);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private Boolean success;

        private Data data;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Shows the request status. Returns true for success and false for failure.
         */
        public Builder success(@Nullable Boolean success) {
            this.success = success;
            return this;
        }

        /**
         * Additional response details (e.g. a human-readable confirmation message).
         */
        public Builder data(@Nullable Data data) {
            this.data = data;
            return this;
        }

        public DeleteSigningKeyResponse build() {
            return new DeleteSigningKeyResponse(
                success, data);
        }

    }

    /**
     * Additional response details returned when a signing key is deleted.
     */
    public static class Data {
        /**
         * A human-readable confirmation message.
         */
        @JsonInclude(Include.NON_ABSENT)
        @JsonProperty("message")
        private String message;

        @JsonCreator
        public Data(
                @JsonProperty("message") @Nullable String message) {
            this.message = message;
        }

        public Data() {
            this(null);
        }

        /**
         * A human-readable confirmation message.
         */
        public Optional<String> message() {
            return Optional.ofNullable(this.message);
        }

        public Data withMessage(@Nullable String message) {
            this.message = message;
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
            Data other = (Data) o;
            return
                Utils.enhancedDeepEquals(this.message, other.message);
        }

        @Override
        public int hashCode() {
            return Utils.enhancedHash(message);
        }

        @Override
        public String toString() {
            return Utils.toString(Data.class,
                    "message", message);
        }
    }
}
