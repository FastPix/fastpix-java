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


public class CreatePlaylistRequestSmart implements CreatePlaylistRequest {

    private static final String NAME_FIELD = "name";
    private static final String REFERENCE_ID_FIELD = "referenceId";
    private static final String TYPE_FIELD = "type";
    private static final String PLAY_ORDER_FIELD = "playOrder";
    private static final String METADATA_FIELD = "metadata";

    /**
     * Name of the playlist.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Unique string value assigned by user to the playlist.
     */
    @JsonProperty("referenceId")
    private String referenceId;

    /**
     * For a smart playlist metadata is required.
     */
    @JsonProperty("type")
    private CreatePlaylistRequestSmartType type;

    /**
     * Description for a playlist (Optional).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("description")
    private String description;

    /**
     * Determines the insertion order of media into playlist.
     */
    @JsonProperty("playOrder")
    private PlaylistOrder playOrder;

    /**
     * Optional parameter to limit no. of media in a playlist.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("limit")
    private Long limit;

    /**
     * Required when the playlist type is `smart`. Media created between `startDate` and `endDate` of
     * `createdDate` is added. Optionally, you can include media based on `updatedDate`.
     */
    @JsonProperty("metadata")
    private Metadata metadata;

    @JsonCreator
    public CreatePlaylistRequestSmart(
            @JsonProperty("name") @Nonnull String name,
            @JsonProperty("referenceId") @Nonnull String referenceId,
            @JsonProperty("type") @Nonnull CreatePlaylistRequestSmartType type,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("playOrder") @Nonnull PlaylistOrder playOrder,
            @JsonProperty("limit") @Nullable Long limit,
            @JsonProperty("metadata") @Nonnull Metadata metadata) {
        this.name = Optional.ofNullable(name)
            .orElseThrow(() -> new IllegalArgumentException("name cannot be null"));
        this.referenceId = Optional.ofNullable(referenceId)
            .orElseThrow(() -> new IllegalArgumentException("referenceId cannot be null"));
        this.type = Optional.ofNullable(type)
            .orElseThrow(() -> new IllegalArgumentException("type cannot be null"));
        this.description = description;
        this.playOrder = Optional.ofNullable(playOrder)
            .orElseThrow(() -> new IllegalArgumentException("playOrder cannot be null"));
        this.limit = Optional.ofNullable(limit)
            .orElse(Builder._SINGLETON_VALUE_Limit.value());
        this.metadata = Optional.ofNullable(metadata)
            .orElseThrow(() -> new IllegalArgumentException("metadata cannot be null"));
    }
    
    public CreatePlaylistRequestSmart(
            @Nonnull String name,
            @Nonnull String referenceId,
            @Nonnull CreatePlaylistRequestSmartType type,
            @Nonnull PlaylistOrder playOrder,
            @Nonnull Metadata metadata) {
        this(name, referenceId, type,
            null, playOrder, null,
            metadata);
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
     * For a smart playlist metadata is required.
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
     * Determines the insertion order of media into playlist.
     */
    public PlaylistOrder playOrder() {
        return this.playOrder;
    }

    /**
     * Optional parameter to limit no. of media in a playlist.
     */
    public Optional<Long> limit() {
        return Optional.ofNullable(this.limit);
    }

    /**
     * Required when the playlist type is `smart`. Media created between `startDate` and `endDate` of
     * `createdDate` is added. Optionally, you can include media based on `updatedDate`.
     */
    public Metadata metadata() {
        return this.metadata;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Name of the playlist.
     */
    public CreatePlaylistRequestSmart withName(@Nonnull String name) {
        this.name = Utils.checkNotNull(name, NAME_FIELD);
        return this;
    }


    /**
     * Unique string value assigned by user to the playlist.
     */
    public CreatePlaylistRequestSmart withReferenceId(@Nonnull String referenceId) {
        this.referenceId = Utils.checkNotNull(referenceId, REFERENCE_ID_FIELD);
        return this;
    }


    /**
     * For a smart playlist metadata is required.
     */
    public CreatePlaylistRequestSmart withType(@Nonnull CreatePlaylistRequestSmartType type) {
        this.type = Utils.checkNotNull(type, TYPE_FIELD);
        return this;
    }


    /**
     * Description for a playlist (Optional).
     */
    public CreatePlaylistRequestSmart withDescription(@Nullable String description) {
        this.description = description;
        return this;
    }


    /**
     * Determines the insertion order of media into playlist.
     */
    public CreatePlaylistRequestSmart withPlayOrder(@Nonnull PlaylistOrder playOrder) {
        this.playOrder = Utils.checkNotNull(playOrder, PLAY_ORDER_FIELD);
        return this;
    }


    /**
     * Optional parameter to limit no. of media in a playlist.
     */
    public CreatePlaylistRequestSmart withLimit(@Nullable Long limit) {
        this.limit = limit;
        return this;
    }


    /**
     * Required when the playlist type is `smart`. Media created between `startDate` and `endDate` of
     * `createdDate` is added. Optionally, you can include media based on `updatedDate`.
     */
    public CreatePlaylistRequestSmart withMetadata(@Nonnull Metadata metadata) {
        this.metadata = Utils.checkNotNull(metadata, METADATA_FIELD);
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
        CreatePlaylistRequestSmart other = (CreatePlaylistRequestSmart) o;
        return 
            Utils.enhancedDeepEquals(this.name, other.name) &&
            Utils.enhancedDeepEquals(this.referenceId, other.referenceId) &&
            Utils.enhancedDeepEquals(this.type, other.type) &&
            Utils.enhancedDeepEquals(this.description, other.description) &&
            Utils.enhancedDeepEquals(this.playOrder, other.playOrder) &&
            Utils.enhancedDeepEquals(this.limit, other.limit) &&
            Utils.enhancedDeepEquals(this.metadata, other.metadata);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            name, referenceId, type,
            description, playOrder, limit,
            metadata);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreatePlaylistRequestSmart.class,
                NAME_FIELD, name,
                REFERENCE_ID_FIELD, referenceId,
                TYPE_FIELD, type,
                "description", description,
                PLAY_ORDER_FIELD, playOrder,
                "limit", limit,
                METADATA_FIELD, metadata);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String name;

        private String referenceId;

        private CreatePlaylistRequestSmartType type;

        private String description;

        private PlaylistOrder playOrder;

        private Long limit;

        private Metadata metadata;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Name of the playlist.
         */
        public Builder name(@Nonnull String name) {
            this.name = Utils.checkNotNull(name, NAME_FIELD);
            return this;
        }

        /**
         * Unique string value assigned by user to the playlist.
         */
        public Builder referenceId(@Nonnull String referenceId) {
            this.referenceId = Utils.checkNotNull(referenceId, REFERENCE_ID_FIELD);
            return this;
        }

        /**
         * For a smart playlist metadata is required.
         */
        public Builder type(@Nonnull CreatePlaylistRequestSmartType type) {
            this.type = Utils.checkNotNull(type, TYPE_FIELD);
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
         * Determines the insertion order of media into playlist.
         */
        public Builder playOrder(@Nonnull PlaylistOrder playOrder) {
            this.playOrder = Utils.checkNotNull(playOrder, PLAY_ORDER_FIELD);
            return this;
        }

        /**
         * Optional parameter to limit no. of media in a playlist.
         */
        public Builder limit(@Nullable Long limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Required when the playlist type is `smart`. Media created between `startDate` and `endDate` of
         * `createdDate` is added. Optionally, you can include media based on `updatedDate`.
         */
        public Builder metadata(@Nonnull Metadata metadata) {
            this.metadata = Utils.checkNotNull(metadata, METADATA_FIELD);
            return this;
        }

        public CreatePlaylistRequestSmart build() {
            return new CreatePlaylistRequestSmart(
                name, referenceId, type,
                description, playOrder, limit,
                metadata);
        }


        private static final LazySingletonValue<Long> _SINGLETON_VALUE_Limit =
                new LazySingletonValue<>(
                        "limit",
                        "1000",
                        new TypeReference<Long>() {});
    }
}
