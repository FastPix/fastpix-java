package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.models.components.UpdatePlaylistRequest;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class UpdateAPlaylistRequest {

    private static final String PLAYLIST_ID = "playlistId";
    private static final String BODY_NAME = "body";
    /**
     * The unique id of the playlist you want to retrieve.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=playlistId")
    private String playlistId;


    @FastpixMetadata("request:mediaType=application/json")
    private UpdatePlaylistRequest body;

    @JsonCreator
    public UpdateAPlaylistRequest(
            @Nonnull String playlistId,
            @Nonnull UpdatePlaylistRequest body) {
        this.playlistId = Optional.ofNullable(playlistId)
            .orElseThrow(() -> new IllegalArgumentException("playlistId cannot be null"));
        this.body = Optional.ofNullable(body)
            .orElseThrow(() -> new IllegalArgumentException("body cannot be null"));
    }

    /**
     * The unique id of the playlist you want to retrieve.
     */
    public String playlistId() {
        return this.playlistId;
    }

    public UpdatePlaylistRequest body() {
        return this.body;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The unique id of the playlist you want to retrieve.
     */
    public UpdateAPlaylistRequest withPlaylistId(@Nonnull String playlistId) {
        this.playlistId = Utils.checkNotNull(playlistId, PLAYLIST_ID);
        return this;
    }


    public UpdateAPlaylistRequest withBody(@Nonnull UpdatePlaylistRequest body) {
        this.body = Utils.checkNotNull(body, BODY_NAME);
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
        UpdateAPlaylistRequest other = (UpdateAPlaylistRequest) o;
        return 
            Utils.enhancedDeepEquals(this.playlistId, other.playlistId) &&
            Utils.enhancedDeepEquals(this.body, other.body);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            playlistId, body);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateAPlaylistRequest.class,
                PLAYLIST_ID, playlistId,
                BODY_NAME, body);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String playlistId;

        private UpdatePlaylistRequest body;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * The unique id of the playlist you want to retrieve.
         */
        public Builder playlistId(@Nonnull String playlistId) {
            this.playlistId = Utils.checkNotNull(playlistId, PLAYLIST_ID);
            return this;
        }

        public Builder body(@Nonnull UpdatePlaylistRequest body) {
            this.body = Utils.checkNotNull(body, BODY_NAME);
            return this;
        }

        public UpdateAPlaylistRequest build() {
            return new UpdateAPlaylistRequest(
                playlistId, body);
        }

    }
}
