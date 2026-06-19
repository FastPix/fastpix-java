package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.models.components.AddTrackRequest;
import io.fastpix.sdk.utils.Utils;


public class AddMediaTrackRequestBody {

    private static final String PROP_TRACKS = "tracks";

    /**
     * Contains details about the track being added to the media file.
     */
    @JsonProperty(PROP_TRACKS)
    private AddTrackRequest tracks;

    @JsonCreator
    public AddMediaTrackRequestBody(
            @JsonProperty(PROP_TRACKS) @Nonnull AddTrackRequest tracks) {
        this.tracks = Optional.ofNullable(tracks)
            .orElseThrow(() -> new IllegalArgumentException("tracks cannot be null"));
    }

    /**
     * Contains details about the track being added to the media file.
     */
    public AddTrackRequest tracks() {
        return this.tracks;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Contains details about the track being added to the media file.
     */
    public AddMediaTrackRequestBody withTracks(@Nonnull AddTrackRequest tracks) {
        this.tracks = Utils.checkNotNull(tracks, PROP_TRACKS);
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
        AddMediaTrackRequestBody other = (AddMediaTrackRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.tracks, other.tracks);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            tracks);
    }
    
    @Override
    public String toString() {
        return Utils.toString(AddMediaTrackRequestBody.class,
                PROP_TRACKS, tracks);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private AddTrackRequest tracks;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Contains details about the track being added to the media file.
         */
        public Builder tracks(@Nonnull AddTrackRequest tracks) {
            this.tracks = Utils.checkNotNull(tracks, PROP_TRACKS);
            return this;
        }

        public AddMediaTrackRequestBody build() {
            return new AddMediaTrackRequestBody(
                tracks);
        }

    }
}
