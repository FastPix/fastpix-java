package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import java.util.Optional;
import io.fastpix.sdk.utils.Utils;

/**
 * UpdateLiveStreamDomainRestrictionsResponseBody
 * 
 * <p>Successfully updated domain restrictions
 */
public class UpdateLiveStreamDomainRestrictionsResponseBody {
    /**
     * Shows the request status. Returns true for success and false for failure.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("success")
    private Boolean success;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("data")
    private UpdateLiveStreamDomainRestrictionsData data;

    @JsonCreator
    public UpdateLiveStreamDomainRestrictionsResponseBody(
            @JsonProperty("success") @Nullable Boolean success,
            @JsonProperty("data") @Nullable UpdateLiveStreamDomainRestrictionsData data) {
        this.success = success;
        this.data = data;
    }
    
    public UpdateLiveStreamDomainRestrictionsResponseBody() {
        this(null, null);
    }

    /**
     * Shows the request status. Returns true for success and false for failure.
     */
    public Optional<Boolean> success() {
        return Optional.ofNullable(this.success);
    }

    public Optional<UpdateLiveStreamDomainRestrictionsData> data() {
        return Optional.ofNullable(this.data);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Shows the request status. Returns true for success and false for failure.
     */
    public UpdateLiveStreamDomainRestrictionsResponseBody withSuccess(@Nullable Boolean success) {
        this.success = success;
        return this;
    }


    public UpdateLiveStreamDomainRestrictionsResponseBody withData(@Nullable UpdateLiveStreamDomainRestrictionsData data) {
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
        UpdateLiveStreamDomainRestrictionsResponseBody other = (UpdateLiveStreamDomainRestrictionsResponseBody) o;
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
        return Utils.toString(UpdateLiveStreamDomainRestrictionsResponseBody.class,
                "success", success,
                "data", data);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private Boolean success;

        private UpdateLiveStreamDomainRestrictionsData data;

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

        public Builder data(@Nullable UpdateLiveStreamDomainRestrictionsData data) {
            this.data = data;
            return this;
        }

        public UpdateLiveStreamDomainRestrictionsResponseBody build() {
            return new UpdateLiveStreamDomainRestrictionsResponseBody(
                success, data);
        }

    }
}
