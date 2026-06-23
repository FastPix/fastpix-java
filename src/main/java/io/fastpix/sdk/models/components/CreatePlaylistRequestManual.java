package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.util.Optional;
import io.fastpix.sdk.utils.LazySingletonValue;
import io.fastpix.sdk.utils.Utils;


public class CreatePlaylistRequestManual implements CreatePlaylistRequest {

    private static final String PROP_NAME = "name";
    private static final String PROP_REFERENCE_ID = "referenceId";
    private static final String PROP_TYPE = "type";
    private static final String PROP_DESCRIPTION = "description";
    private static final String PROP_LIMIT = "limit";

    /**
     * Name of the playlist.
     */
    @JsonProperty(PROP_NAME)
    private String name;

    /**
     * Unique string value assigned by user to the playlist.
     */
    @JsonProperty(PROP_REFERENCE_ID)
    private String referenceId;

    /**
     * Manual playlist type (no `playOrder`).
     */
    @JsonProperty(PROP_TYPE)
    private CreatePlaylistRequestManualType type;

    /**
     * Description for a playlist (Optional).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty(PROP_DESCRIPTION)
    private String description;

    /**
     * Optional parameter to limit no. of media in a playlist.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty(PROP_LIMIT)
    private Long limit;

    @JsonCreator
    public CreatePlaylistRequestManual(
            @JsonProperty(PROP_NAME) @Nonnull String name,
            @JsonProperty(PROP_REFERENCE_ID) @Nonnull String referenceId,
            @JsonProperty(PROP_TYPE) @Nonnull CreatePlaylistRequestManualType type,
            @JsonProperty(PROP_DESCRIPTION) @Nullable String description,
            @JsonProperty(PROP_LIMIT) @Nullable Long limit) {
        this.name = Optional.ofNullable(name)
            .orElseThrow(() -> new IllegalArgumentException("name cannot be null"));
        this.referenceId = Optional.ofNullable(referenceId)
            .orElseThrow(() -> new IllegalArgumentException("referenceId cannot be null"));
        this.type = Optional.ofNullable(type)
            .orElseThrow(() -> new IllegalArgumentException("type cannot be null"));
        this.description = description;
        this.limit = Optional.ofNullable(limit)
            .orElse(Builder._SINGLETON_VALUE_Limit.value());
    }

    public CreatePlaylistRequestManual(
            @Nonnull String name,
            @Nonnull String referenceId,
            @Nonnull CreatePlaylistRequestManualType type) {
        this(name, referenceId, type,
            null, null);
    }

    /**
     * Name of the playlist.
     */
    public String name() {
        return this.name;
    }

    /**
     * Unique string value assigned by user to the playlist.
     */
    public String referenceId() {
        return this.referenceId;
    }

    /**
     * Manual playlist type (no `playOrder`).
     */
    @Override
    public String type() {
        return Utils.discriminatorToString(type);
    }

    /**
     * Description for a playlist (Optional).
     */
    public Optional<String> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * Optional parameter to limit no. of media in a playlist.
     */
    public Optional<Long> limit() {
        return Optional.ofNullable(this.limit);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Name of the playlist.
     */
    public CreatePlaylistRequestManual withName(@Nonnull String name) {
        this.name = Utils.checkNotNull(name, PROP_NAME);
        return this;
    }


    /**
     * Unique string value assigned by user to the playlist.
     */
    public CreatePlaylistRequestManual withReferenceId(@Nonnull String referenceId) {
        this.referenceId = Utils.checkNotNull(referenceId, PROP_REFERENCE_ID);
        return this;
    }


    /**
     * Manual playlist type (no `playOrder`).
     */
    public CreatePlaylistRequestManual withType(@Nonnull CreatePlaylistRequestManualType type) {
        this.type = Utils.checkNotNull(type, PROP_TYPE);
        return this;
    }


    /**
     * Description for a playlist (Optional).
     */
    public CreatePlaylistRequestManual withDescription(@Nullable String description) {
        this.description = description;
        return this;
    }


    /**
     * Optional parameter to limit no. of media in a playlist.
     */
    public CreatePlaylistRequestManual withLimit(@Nullable Long limit) {
        this.limit = limit;
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
        CreatePlaylistRequestManual other = (CreatePlaylistRequestManual) o;
        return
            Utils.enhancedDeepEquals(this.name, other.name) &&
            Utils.enhancedDeepEquals(this.referenceId, other.referenceId) &&
            Utils.enhancedDeepEquals(this.type, other.type) &&
            Utils.enhancedDeepEquals(this.description, other.description) &&
            Utils.enhancedDeepEquals(this.limit, other.limit);
    }

    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            name, referenceId, type,
            description, limit);
    }

    @Override
    public String toString() {
        return Utils.toString(CreatePlaylistRequestManual.class,
                PROP_NAME, name,
                PROP_REFERENCE_ID, referenceId,
                PROP_TYPE, type,
                PROP_DESCRIPTION, description,
                PROP_LIMIT, limit);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String name;

        private String referenceId;

        private CreatePlaylistRequestManualType type;

        private String description;

        private Long limit;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Name of the playlist.
         */
        public Builder name(@Nonnull String name) {
            this.name = Utils.checkNotNull(name, PROP_NAME);
            return this;
        }

        /**
         * Unique string value assigned by user to the playlist.
         */
        public Builder referenceId(@Nonnull String referenceId) {
            this.referenceId = Utils.checkNotNull(referenceId, PROP_REFERENCE_ID);
            return this;
        }

        /**
         * Manual playlist type (no `playOrder`).
         */
        public Builder type(@Nonnull CreatePlaylistRequestManualType type) {
            this.type = Utils.checkNotNull(type, PROP_TYPE);
            return this;
        }

        /**
         * Description for a playlist (Optional).
         */
        public Builder description(@Nullable String description) {
            this.description = description;
            return this;
        }

        /**
         * Optional parameter to limit no. of media in a playlist.
         */
        public Builder limit(@Nullable Long limit) {
            this.limit = limit;
            return this;
        }

        public CreatePlaylistRequestManual build() {
            return new CreatePlaylistRequestManual(
                name, referenceId, type,
                description, limit);
        }


        private static final LazySingletonValue<Long> _SINGLETON_VALUE_Limit =
                new LazySingletonValue<>(
                        PROP_LIMIT,
                        "1000",
                        new TypeReference<Long>() {});
    }
}
