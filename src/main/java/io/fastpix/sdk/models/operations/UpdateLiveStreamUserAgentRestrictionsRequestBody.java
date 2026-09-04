package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import io.fastpix.sdk.utils.LazySingletonValue;
import io.fastpix.sdk.utils.Utils;


public class UpdateLiveStreamUserAgentRestrictionsRequestBody {
    /**
     * The default behavior when a user-agent is not listed in `allow` or `deny`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("defaultPolicy")
    private UpdateLiveStreamUserAgentRestrictionsDefaultPolicy defaultPolicy;

    /**
     * List of user-agent substrings explicitly allowed.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("allow")
    private List<String> allow;

    /**
     * List of user-agent substrings explicitly denied.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("deny")
    private List<String> deny;

    @JsonCreator
    public UpdateLiveStreamUserAgentRestrictionsRequestBody(
            @JsonProperty("defaultPolicy") @Nullable UpdateLiveStreamUserAgentRestrictionsDefaultPolicy defaultPolicy,
            @JsonProperty("allow") @Nullable List<String> allow,
            @JsonProperty("deny") @Nullable List<String> deny) {
        this.defaultPolicy = Optional.ofNullable(defaultPolicy)
            .orElse(Builder._SINGLETON_VALUE_DefaultPolicy.value());
        this.allow = allow;
        this.deny = deny;
    }
    
    public UpdateLiveStreamUserAgentRestrictionsRequestBody() {
        this(null, null, null);
    }

    /**
     * The default behavior when a user-agent is not listed in `allow` or `deny`.
     */
    public Optional<UpdateLiveStreamUserAgentRestrictionsDefaultPolicy> defaultPolicy() {
        return Optional.ofNullable(this.defaultPolicy);
    }

    /**
     * List of user-agent substrings explicitly allowed.
     */
    public Optional<List<String>> allow() {
        return Optional.ofNullable(this.allow);
    }

    /**
     * List of user-agent substrings explicitly denied.
     */
    public Optional<List<String>> deny() {
        return Optional.ofNullable(this.deny);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The default behavior when a user-agent is not listed in `allow` or `deny`.
     */
    public UpdateLiveStreamUserAgentRestrictionsRequestBody withDefaultPolicy(@Nullable UpdateLiveStreamUserAgentRestrictionsDefaultPolicy defaultPolicy) {
        this.defaultPolicy = defaultPolicy;
        return this;
    }


    /**
     * List of user-agent substrings explicitly allowed.
     */
    public UpdateLiveStreamUserAgentRestrictionsRequestBody withAllow(@Nullable List<String> allow) {
        this.allow = allow;
        return this;
    }


    /**
     * List of user-agent substrings explicitly denied.
     */
    public UpdateLiveStreamUserAgentRestrictionsRequestBody withDeny(@Nullable List<String> deny) {
        this.deny = deny;
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
        UpdateLiveStreamUserAgentRestrictionsRequestBody other = (UpdateLiveStreamUserAgentRestrictionsRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.defaultPolicy, other.defaultPolicy) &&
            Utils.enhancedDeepEquals(this.allow, other.allow) &&
            Utils.enhancedDeepEquals(this.deny, other.deny);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            defaultPolicy, allow, deny);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateLiveStreamUserAgentRestrictionsRequestBody.class,
                "defaultPolicy", defaultPolicy,
                "allow", allow,
                "deny", deny);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private UpdateLiveStreamUserAgentRestrictionsDefaultPolicy defaultPolicy;

        private List<String> allow;

        private List<String> deny;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * The default behavior when a user-agent is not listed in `allow` or `deny`.
         */
        public Builder defaultPolicy(@Nullable UpdateLiveStreamUserAgentRestrictionsDefaultPolicy defaultPolicy) {
            this.defaultPolicy = defaultPolicy;
            return this;
        }

        /**
         * List of user-agent substrings explicitly allowed.
         */
        public Builder allow(@Nullable List<String> allow) {
            this.allow = allow;
            return this;
        }

        /**
         * List of user-agent substrings explicitly denied.
         */
        public Builder deny(@Nullable List<String> deny) {
            this.deny = deny;
            return this;
        }

        public UpdateLiveStreamUserAgentRestrictionsRequestBody build() {
            return new UpdateLiveStreamUserAgentRestrictionsRequestBody(
                defaultPolicy, allow, deny);
        }


        private static final LazySingletonValue<UpdateLiveStreamUserAgentRestrictionsDefaultPolicy> _SINGLETON_VALUE_DefaultPolicy =
                new LazySingletonValue<>(
                        "defaultPolicy",
                        "\"allow\"",
                        new TypeReference<UpdateLiveStreamUserAgentRestrictionsDefaultPolicy>() {});
    }
}
