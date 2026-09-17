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


public class UpdateLiveStreamDomainRestrictionsRequestBody {
    /**
     * Specify the fallback behavior for domains that are not listed in the `allow` or `deny` lists.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("defaultPolicy")
    private UpdateLiveStreamDomainRestrictionsDefaultPolicy defaultPolicy;

    /**
     * List of domains explicitly allowed to play the media.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("allow")
    private List<String> allow;

    /**
     * List of domains explicitly denied from accessing the media.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("deny")
    private List<String> deny;

    @JsonCreator
    public UpdateLiveStreamDomainRestrictionsRequestBody(
            @JsonProperty("defaultPolicy") @Nullable UpdateLiveStreamDomainRestrictionsDefaultPolicy defaultPolicy,
            @JsonProperty("allow") @Nullable List<String> allow,
            @JsonProperty("deny") @Nullable List<String> deny) {
        this.defaultPolicy = Optional.ofNullable(defaultPolicy)
            .orElse(Builder._SINGLETON_VALUE_DefaultPolicy.value());
        this.allow = allow;
        this.deny = deny;
    }
    
    public UpdateLiveStreamDomainRestrictionsRequestBody() {
        this(null, null, null);
    }

    /**
     * Specify the fallback behavior for domains that are not listed in the `allow` or `deny` lists.
     */
    public Optional<UpdateLiveStreamDomainRestrictionsDefaultPolicy> defaultPolicy() {
        return Optional.ofNullable(this.defaultPolicy);
    }

    /**
     * List of domains explicitly allowed to play the media.
     */
    public Optional<List<String>> allow() {
        return Optional.ofNullable(this.allow);
    }

    /**
     * List of domains explicitly denied from accessing the media.
     */
    public Optional<List<String>> deny() {
        return Optional.ofNullable(this.deny);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Specify the fallback behavior for domains that are not listed in the `allow` or `deny` lists.
     */
    public UpdateLiveStreamDomainRestrictionsRequestBody withDefaultPolicy(@Nullable UpdateLiveStreamDomainRestrictionsDefaultPolicy defaultPolicy) {
        this.defaultPolicy = defaultPolicy;
        return this;
    }


    /**
     * List of domains explicitly allowed to play the media.
     */
    public UpdateLiveStreamDomainRestrictionsRequestBody withAllow(@Nullable List<String> allow) {
        this.allow = allow;
        return this;
    }


    /**
     * List of domains explicitly denied from accessing the media.
     */
    public UpdateLiveStreamDomainRestrictionsRequestBody withDeny(@Nullable List<String> deny) {
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
        UpdateLiveStreamDomainRestrictionsRequestBody other = (UpdateLiveStreamDomainRestrictionsRequestBody) o;
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
        return Utils.toString(UpdateLiveStreamDomainRestrictionsRequestBody.class,
                "defaultPolicy", defaultPolicy,
                "allow", allow,
                "deny", deny);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private UpdateLiveStreamDomainRestrictionsDefaultPolicy defaultPolicy;

        private List<String> allow;

        private List<String> deny;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Specify the fallback behavior for domains that are not listed in the `allow` or `deny` lists.
         */
        public Builder defaultPolicy(@Nullable UpdateLiveStreamDomainRestrictionsDefaultPolicy defaultPolicy) {
            this.defaultPolicy = defaultPolicy;
            return this;
        }

        /**
         * List of domains explicitly allowed to play the media.
         */
        public Builder allow(@Nullable List<String> allow) {
            this.allow = allow;
            return this;
        }

        /**
         * List of domains explicitly denied from accessing the media.
         */
        public Builder deny(@Nullable List<String> deny) {
            this.deny = deny;
            return this;
        }

        public UpdateLiveStreamDomainRestrictionsRequestBody build() {
            return new UpdateLiveStreamDomainRestrictionsRequestBody(
                defaultPolicy, allow, deny);
        }


        private static final LazySingletonValue<UpdateLiveStreamDomainRestrictionsDefaultPolicy> _SINGLETON_VALUE_DefaultPolicy =
                new LazySingletonValue<>(
                        "defaultPolicy",
                        "\"allow\"",
                        new TypeReference<UpdateLiveStreamDomainRestrictionsDefaultPolicy>() {});
    }
}
