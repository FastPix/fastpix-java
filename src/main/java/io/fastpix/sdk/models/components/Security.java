package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.utils.HasSecurity;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class Security implements HasSecurity {

    private static final String USERNAME_NAME = "username";
    private static final String PASSWORD_NAME = "password";

    @FastpixMetadata("security:scheme=true,type=http,subtype=basic,name=username")
    private String username;


    @FastpixMetadata("security:scheme=true,type=http,subtype=basic,name=password")
    private String password;

    @JsonCreator
    public Security(
            @Nonnull String username,
            @Nonnull String password) {
        this.username = Optional.ofNullable(username)
            .orElseThrow(() -> new IllegalArgumentException("username cannot be null"));
        this.password = Optional.ofNullable(password)
            .orElseThrow(() -> new IllegalArgumentException("password cannot be null"));
    }

    public String username() {
        return this.username;
    }

    public String password() {
        return this.password;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Security withUsername(@Nonnull String username) {
        this.username = Utils.checkNotNull(username, USERNAME_NAME);
        return this;
    }


    public Security withPassword(@Nonnull String password) {
        this.password = Utils.checkNotNull(password, PASSWORD_NAME);
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
        Security other = (Security) o;
        return 
            Utils.enhancedDeepEquals(this.username, other.username) &&
            Utils.enhancedDeepEquals(this.password, other.password);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            username, password);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Security.class,
                USERNAME_NAME, username,
                PASSWORD_NAME, password);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String username;

        private String password;

        private Builder() {
          // force use of static builder() method
        }

        public Builder username(@Nonnull String username) {
            this.username = Utils.checkNotNull(username, USERNAME_NAME);
            return this;
        }

        public Builder password(@Nonnull String password) {
            this.password = Utils.checkNotNull(password, PASSWORD_NAME);
            return this;
        }

        public Security build() {
            return new Security(
                username, password);
        }

    }
}
