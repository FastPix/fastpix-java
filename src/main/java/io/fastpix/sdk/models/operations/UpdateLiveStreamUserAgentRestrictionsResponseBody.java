package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import java.util.Optional;
import io.fastpix.sdk.utils.Utils;

/**
 * UpdateLiveStreamUserAgentRestrictionsResponseBody
 * 
 * <p>Successfully updated user-agent restrictions
 */
public class UpdateLiveStreamUserAgentRestrictionsResponseBody {
    /**
     * Shows the request status. Returns true for success and false for failure.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("success")
    private Boolean success;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("data")
    private UpdateLiveStreamUserAgentRestrictionsData data;

    @JsonCreator
    public UpdateLiveStreamUserAgentRestrictionsResponseBody(
            @JsonProperty("success") @Nullable Boolean success,
            @JsonProperty("data") @Nullable UpdateLiveStreamUserAgentRestrictionsData data) {
        this.success = success;
        this.data = data;
    }
    
    public UpdateLiveStreamUserAgentRestrictionsResponseBody() {
        this(null, null);
    }

    /**
     * Shows the request status. Returns true for success and false for failure.
     */
    public Optional<Boolean> success() {
        return Optional.ofNullable(this.success);
    }

    public Optional<UpdateLiveStreamUserAgentRestrictionsData> data() {
        return Optional.ofNullable(this.data);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Shows the request status. Returns true for success and false for failure.
     */
    public UpdateLiveStreamUserAgentRestrictionsResponseBody withSuccess(@Nullable Boolean success) {
        this.success = success;
        return this;
    }


    public UpdateLiveStreamUserAgentRestrictionsResponseBody withData(@Nullable UpdateLiveStreamUserAgentRestrictionsData data) {
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
        UpdateLiveStreamUserAgentRestrictionsResponseBody other = (UpdateLiveStreamUserAgentRestrictionsResponseBody) o;
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
        return Utils.toString(UpdateLiveStreamUserAgentRestrictionsResponseBody.class,
                "success", success,
                "data", data);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private Boolean success;

        private UpdateLiveStreamUserAgentRestrictionsData data;

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

        public Builder data(@Nullable UpdateLiveStreamUserAgentRestrictionsData data) {
            this.data = data;
            return this;
        }

        public UpdateLiveStreamUserAgentRestrictionsResponseBody build() {
            return new UpdateLiveStreamUserAgentRestrictionsResponseBody(
                success, data);
        }

    }
}
