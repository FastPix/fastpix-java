package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class GetPlaylistByIdRequest {

    private static final String PLAYLIST_ID = "playlistId";
    /**
     * The unique id of the playlist you want to retrieve.
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=playlistId")
    private String playlistId;

    @JsonCreator
    public GetPlaylistByIdRequest(
            @Nonnull String playlistId) {
        this.playlistId = Optional.ofNullable(playlistId)
            .orElseThrow(() -> new IllegalArgumentException("playlistId cannot be null"));
    }

    /**
     * The unique id of the playlist you want to retrieve.
     */
    public String playlistId() {
        return this.playlistId;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The unique id of the playlist you want to retrieve.
     */
    public GetPlaylistByIdRequest withPlaylistId(@Nonnull String playlistId) {
        this.playlistId = Utils.checkNotNull(playlistId, PLAYLIST_ID);
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
        GetPlaylistByIdRequest other = (GetPlaylistByIdRequest) o;
        return 
            Utils.enhancedDeepEquals(this.playlistId, other.playlistId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            playlistId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetPlaylistByIdRequest.class,
                PLAYLIST_ID, playlistId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String playlistId;

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

        public GetPlaylistByIdRequest build() {
            return new GetPlaylistByIdRequest(
                playlistId);
        }

    }
}
