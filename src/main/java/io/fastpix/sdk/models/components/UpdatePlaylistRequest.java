package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.utils.Utils;


public class UpdatePlaylistRequest {

    private static final String NAME_FIELD = "name";
    private static final String DESCRIPTION_FIELD = "description";

    /**
     * New name to the playlist.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Updated description to the playlist.
     */
    @JsonProperty("description")
    private String description;

    @JsonCreator
    public UpdatePlaylistRequest(
            @JsonProperty("name") @Nonnull String name,
            @JsonProperty("description") @Nonnull String description) {
        this.name = Optional.ofNullable(name)
            .orElseThrow(() -> new IllegalArgumentException("name cannot be null"));
        this.description = Optional.ofNullable(description)
            .orElseThrow(() -> new IllegalArgumentException("description cannot be null"));
    }

    /**
     * New name to the playlist.
     */
    public String name() {
        return this.name;
    }

    /**
     * Updated description to the playlist.
     */
    public String description() {
        return this.description;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * New name to the playlist.
     */
    public UpdatePlaylistRequest withName(@Nonnull String name) {
        this.name = Utils.checkNotNull(name, NAME_FIELD);
        return this;
    }


    /**
     * Updated description to the playlist.
     */
    public UpdatePlaylistRequest withDescription(@Nonnull String description) {
        this.description = Utils.checkNotNull(description, DESCRIPTION_FIELD);
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
        UpdatePlaylistRequest other = (UpdatePlaylistRequest) o;
        return 
            Utils.enhancedDeepEquals(this.name, other.name) &&
            Utils.enhancedDeepEquals(this.description, other.description);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            name, description);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdatePlaylistRequest.class,
                NAME_FIELD, name,
                DESCRIPTION_FIELD, description);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String name;

        private String description;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * New name to the playlist.
         */
        public Builder name(@Nonnull String name) {
            this.name = Utils.checkNotNull(name, NAME_FIELD);
            return this;
        }

        /**
         * Updated description to the playlist.
         */
        public Builder description(@Nonnull String description) {
            this.description = Utils.checkNotNull(description, DESCRIPTION_FIELD);
            return this;
        }

        public UpdatePlaylistRequest build() {
            return new UpdatePlaylistRequest(
                name, description);
        }

    }
}
