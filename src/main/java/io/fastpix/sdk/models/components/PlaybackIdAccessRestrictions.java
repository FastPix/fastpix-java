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
import java.util.Objects;
import java.util.Optional;

/**
 * PlaybackIdAccessRestrictions
 * 
 * <p>Controls access based on domains and user agents. Defines a default policy (either "allow" or "deny") and provides lists for explicitly allowed or denied domains and user agents.
 */
public class PlaybackIdAccessRestrictions {

    /**
     * Restrictions based on the originating domain of a request (e.g., whether requests from certain websites should be allowed or blocked).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("domains")
    private Optional<? extends PlaybackIdDomains> domains;

    /**
     * Restrictions based on the user agent (which is typically a string sent by browsers or bots identifying themselves).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("userAgents")
    private Optional<? extends PlaybackIdUserAgents> userAgents;

    @JsonCreator
    public PlaybackIdAccessRestrictions(
            @JsonProperty("domains") Optional<? extends PlaybackIdDomains> domains,
            @JsonProperty("userAgents") Optional<? extends PlaybackIdUserAgents> userAgents) {
        Utils.checkNotNull(domains, "domains");
        Utils.checkNotNull(userAgents, "userAgents");
        this.domains = domains;
        this.userAgents = userAgents;
    }
    
    public PlaybackIdAccessRestrictions() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * Restrictions based on the originating domain of a request (e.g., whether requests from certain websites should be allowed or blocked).
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<PlaybackIdDomains> domains() {
        return (Optional<PlaybackIdDomains>) domains;
    }

    /**
     * Restrictions based on the user agent (which is typically a string sent by browsers or bots identifying themselves).
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<PlaybackIdUserAgents> userAgents() {
        return (Optional<PlaybackIdUserAgents>) userAgents;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Restrictions based on the originating domain of a request (e.g., whether requests from certain websites should be allowed or blocked).
     */
    public PlaybackIdAccessRestrictions withDomains(PlaybackIdDomains domains) {
        Utils.checkNotNull(domains, "domains");
        this.domains = Optional.ofNullable(domains);
        return this;
    }

    /**
     * Restrictions based on the originating domain of a request (e.g., whether requests from certain websites should be allowed or blocked).
     */
    public PlaybackIdAccessRestrictions withDomains(Optional<? extends PlaybackIdDomains> domains) {
        Utils.checkNotNull(domains, "domains");
        this.domains = domains;
        return this;
    }

    /**
     * Restrictions based on the user agent (which is typically a string sent by browsers or bots identifying themselves).
     */
    public PlaybackIdAccessRestrictions withUserAgents(PlaybackIdUserAgents userAgents) {
        Utils.checkNotNull(userAgents, "userAgents");
        this.userAgents = Optional.ofNullable(userAgents);
        return this;
    }

    /**
     * Restrictions based on the user agent (which is typically a string sent by browsers or bots identifying themselves).
     */
    public PlaybackIdAccessRestrictions withUserAgents(Optional<? extends PlaybackIdUserAgents> userAgents) {
        Utils.checkNotNull(userAgents, "userAgents");
        this.userAgents = userAgents;
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
        PlaybackIdAccessRestrictions other = (PlaybackIdAccessRestrictions) o;
        return 
            Objects.deepEquals(this.domains, other.domains) &&
            Objects.deepEquals(this.userAgents, other.userAgents);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            domains,
            userAgents);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PlaybackIdAccessRestrictions.class,
                "domains", domains,
                "userAgents", userAgents);
    }
    
    public final static class Builder {
 
        private Optional<? extends PlaybackIdDomains> domains = Optional.empty();
 
        private Optional<? extends PlaybackIdUserAgents> userAgents = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Restrictions based on the originating domain of a request (e.g., whether requests from certain websites should be allowed or blocked).
         */
        public Builder domains(PlaybackIdDomains domains) {
            Utils.checkNotNull(domains, "domains");
            this.domains = Optional.ofNullable(domains);
            return this;
        }

        /**
         * Restrictions based on the originating domain of a request (e.g., whether requests from certain websites should be allowed or blocked).
         */
        public Builder domains(Optional<? extends PlaybackIdDomains> domains) {
            Utils.checkNotNull(domains, "domains");
            this.domains = domains;
            return this;
        }

        /**
         * Restrictions based on the user agent (which is typically a string sent by browsers or bots identifying themselves).
         */
        public Builder userAgents(PlaybackIdUserAgents userAgents) {
            Utils.checkNotNull(userAgents, "userAgents");
            this.userAgents = Optional.ofNullable(userAgents);
            return this;
        }

        /**
         * Restrictions based on the user agent (which is typically a string sent by browsers or bots identifying themselves).
         */
        public Builder userAgents(Optional<? extends PlaybackIdUserAgents> userAgents) {
            Utils.checkNotNull(userAgents, "userAgents");
            this.userAgents = userAgents;
            return this;
        }
        
        public PlaybackIdAccessRestrictions build() {
            return new PlaybackIdAccessRestrictions(
                domains,
                userAgents);
        }
    }
}
