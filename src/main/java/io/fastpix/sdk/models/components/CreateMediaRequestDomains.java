/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fastpix.sdk.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CreateMediaRequestDomains {

    /**
     * Specifies the default access policy for domains. 
     * If set to `allow`, all domains are allowed access unless otherwise specified in the `deny` lists. 
     * If set to `deny`, all domains are denied access unless otherwise specified in the `allow` lists.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("defaultPolicy")
    private Optional<? extends CreateMediaRequestDomainsDefaultPolicy> defaultPolicy;

    /**
     * A list of domain names or patterns that are explicitly allowed access. 
     * This list is only effective when the `defaultPolicy` is set to `deny`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("allow")
    private Optional<? extends List<String>> allow;

    /**
     * A list of domain names or patterns that are explicitly denied access. 
     * This list is only effective when the `defaultPolicy` is set to `allow`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("deny")
    private Optional<? extends List<String>> deny;

    @JsonCreator
    public CreateMediaRequestDomains(
            @JsonProperty("defaultPolicy") Optional<? extends CreateMediaRequestDomainsDefaultPolicy> defaultPolicy,
            @JsonProperty("allow") Optional<? extends List<String>> allow,
            @JsonProperty("deny") Optional<? extends List<String>> deny) {
        Utils.checkNotNull(defaultPolicy, "defaultPolicy");
        Utils.checkNotNull(allow, "allow");
        Utils.checkNotNull(deny, "deny");
        this.defaultPolicy = defaultPolicy;
        this.allow = allow;
        this.deny = deny;
    }
    
    public CreateMediaRequestDomains() {
        this(Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * Specifies the default access policy for domains. 
     * If set to `allow`, all domains are allowed access unless otherwise specified in the `deny` lists. 
     * If set to `deny`, all domains are denied access unless otherwise specified in the `allow` lists.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateMediaRequestDomainsDefaultPolicy> defaultPolicy() {
        return (Optional<CreateMediaRequestDomainsDefaultPolicy>) defaultPolicy;
    }

    /**
     * A list of domain names or patterns that are explicitly allowed access. 
     * This list is only effective when the `defaultPolicy` is set to `deny`.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<String>> allow() {
        return (Optional<List<String>>) allow;
    }

    /**
     * A list of domain names or patterns that are explicitly denied access. 
     * This list is only effective when the `defaultPolicy` is set to `allow`.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<String>> deny() {
        return (Optional<List<String>>) deny;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Specifies the default access policy for domains. 
     * If set to `allow`, all domains are allowed access unless otherwise specified in the `deny` lists. 
     * If set to `deny`, all domains are denied access unless otherwise specified in the `allow` lists.
     */
    public CreateMediaRequestDomains withDefaultPolicy(CreateMediaRequestDomainsDefaultPolicy defaultPolicy) {
        Utils.checkNotNull(defaultPolicy, "defaultPolicy");
        this.defaultPolicy = Optional.ofNullable(defaultPolicy);
        return this;
    }

    /**
     * Specifies the default access policy for domains. 
     * If set to `allow`, all domains are allowed access unless otherwise specified in the `deny` lists. 
     * If set to `deny`, all domains are denied access unless otherwise specified in the `allow` lists.
     */
    public CreateMediaRequestDomains withDefaultPolicy(Optional<? extends CreateMediaRequestDomainsDefaultPolicy> defaultPolicy) {
        Utils.checkNotNull(defaultPolicy, "defaultPolicy");
        this.defaultPolicy = defaultPolicy;
        return this;
    }

    /**
     * A list of domain names or patterns that are explicitly allowed access. 
     * This list is only effective when the `defaultPolicy` is set to `deny`.
     */
    public CreateMediaRequestDomains withAllow(List<String> allow) {
        Utils.checkNotNull(allow, "allow");
        this.allow = Optional.ofNullable(allow);
        return this;
    }

    /**
     * A list of domain names or patterns that are explicitly allowed access. 
     * This list is only effective when the `defaultPolicy` is set to `deny`.
     */
    public CreateMediaRequestDomains withAllow(Optional<? extends List<String>> allow) {
        Utils.checkNotNull(allow, "allow");
        this.allow = allow;
        return this;
    }

    /**
     * A list of domain names or patterns that are explicitly denied access. 
     * This list is only effective when the `defaultPolicy` is set to `allow`.
     */
    public CreateMediaRequestDomains withDeny(List<String> deny) {
        Utils.checkNotNull(deny, "deny");
        this.deny = Optional.ofNullable(deny);
        return this;
    }

    /**
     * A list of domain names or patterns that are explicitly denied access. 
     * This list is only effective when the `defaultPolicy` is set to `allow`.
     */
    public CreateMediaRequestDomains withDeny(Optional<? extends List<String>> deny) {
        Utils.checkNotNull(deny, "deny");
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
        CreateMediaRequestDomains other = (CreateMediaRequestDomains) o;
        return 
            Objects.deepEquals(this.defaultPolicy, other.defaultPolicy) &&
            Objects.deepEquals(this.allow, other.allow) &&
            Objects.deepEquals(this.deny, other.deny);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            defaultPolicy,
            allow,
            deny);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateMediaRequestDomains.class,
                "defaultPolicy", defaultPolicy,
                "allow", allow,
                "deny", deny);
    }
    
    public final static class Builder {
 
        private Optional<? extends CreateMediaRequestDomainsDefaultPolicy> defaultPolicy = Optional.empty();
 
        private Optional<? extends List<String>> allow = Optional.empty();
 
        private Optional<? extends List<String>> deny = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Specifies the default access policy for domains. 
         * If set to `allow`, all domains are allowed access unless otherwise specified in the `deny` lists. 
         * If set to `deny`, all domains are denied access unless otherwise specified in the `allow` lists.
         */
        public Builder defaultPolicy(CreateMediaRequestDomainsDefaultPolicy defaultPolicy) {
            Utils.checkNotNull(defaultPolicy, "defaultPolicy");
            this.defaultPolicy = Optional.ofNullable(defaultPolicy);
            return this;
        }

        /**
         * Specifies the default access policy for domains. 
         * If set to `allow`, all domains are allowed access unless otherwise specified in the `deny` lists. 
         * If set to `deny`, all domains are denied access unless otherwise specified in the `allow` lists.
         */
        public Builder defaultPolicy(Optional<? extends CreateMediaRequestDomainsDefaultPolicy> defaultPolicy) {
            Utils.checkNotNull(defaultPolicy, "defaultPolicy");
            this.defaultPolicy = defaultPolicy;
            return this;
        }

        /**
         * A list of domain names or patterns that are explicitly allowed access. 
         * This list is only effective when the `defaultPolicy` is set to `deny`.
         */
        public Builder allow(List<String> allow) {
            Utils.checkNotNull(allow, "allow");
            this.allow = Optional.ofNullable(allow);
            return this;
        }

        /**
         * A list of domain names or patterns that are explicitly allowed access. 
         * This list is only effective when the `defaultPolicy` is set to `deny`.
         */
        public Builder allow(Optional<? extends List<String>> allow) {
            Utils.checkNotNull(allow, "allow");
            this.allow = allow;
            return this;
        }

        /**
         * A list of domain names or patterns that are explicitly denied access. 
         * This list is only effective when the `defaultPolicy` is set to `allow`.
         */
        public Builder deny(List<String> deny) {
            Utils.checkNotNull(deny, "deny");
            this.deny = Optional.ofNullable(deny);
            return this;
        }

        /**
         * A list of domain names or patterns that are explicitly denied access. 
         * This list is only effective when the `defaultPolicy` is set to `allow`.
         */
        public Builder deny(Optional<? extends List<String>> deny) {
            Utils.checkNotNull(deny, "deny");
            this.deny = deny;
            return this;
        }
        
        public CreateMediaRequestDomains build() {
            return new CreateMediaRequestDomains(
                defaultPolicy,
                allow,
                deny);
        }
    }
}
