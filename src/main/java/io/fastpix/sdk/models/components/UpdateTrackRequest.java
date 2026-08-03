package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.Nullable;
import java.util.Optional;
import io.fastpix.sdk.utils.LazySingletonValue;
import io.fastpix.sdk.utils.Utils;

/**
 * UpdateTrackRequest
 *
 * <p>Contains details about the track being updated. The track's file ({@code url}) cannot be changed
 * — only its language and title.
 */
public class UpdateTrackRequest {
    /**
     * The BCP 47 language code representing the track’s language.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("languageCode")
    private String languageCode;

    /**
     * The full name of the language corresponding to the `languageCode`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("languageName")
    private String languageName;

    /**
     * Title of the track.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("title")
    private String title;

    @JsonCreator
    public UpdateTrackRequest(
            @JsonProperty("languageCode") @Nullable String languageCode,
            @JsonProperty("languageName") @Nullable String languageName,
            @JsonProperty("title") @Nullable String title) {
        this.languageCode = Optional.ofNullable(languageCode)
            .orElse(Builder._SINGLETON_VALUE_LanguageCode.value());
        this.languageName = Optional.ofNullable(languageName)
            .orElse(Builder._SINGLETON_VALUE_LanguageName.value());
        this.title = title;
    }

    public UpdateTrackRequest() {
        this(null, null, null);
    }

    /**
     * The BCP 47 language code representing the track’s language.
     */
    public Optional<String> languageCode() {
        return Optional.ofNullable(this.languageCode);
    }

    /**
     * The full name of the language corresponding to the `languageCode`.
     */
    public Optional<String> languageName() {
        return Optional.ofNullable(this.languageName);
    }

    /**
     * Title of the track.
     */
    public Optional<String> title() {
        return Optional.ofNullable(this.title);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The BCP 47 language code representing the track’s language.
     */
    public UpdateTrackRequest withLanguageCode(@Nullable String languageCode) {
        this.languageCode = languageCode;
        return this;
    }


    /**
     * The full name of the language corresponding to the `languageCode`.
     */
    public UpdateTrackRequest withLanguageName(@Nullable String languageName) {
        this.languageName = languageName;
        return this;
    }


    /**
     * Title of the track.
     */
    public UpdateTrackRequest withTitle(@Nullable String title) {
        this.title = title;
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
        UpdateTrackRequest other = (UpdateTrackRequest) o;
        return
            Utils.enhancedDeepEquals(this.languageCode, other.languageCode) &&
            Utils.enhancedDeepEquals(this.languageName, other.languageName) &&
            Utils.enhancedDeepEquals(this.title, other.title);
    }

    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            languageCode, languageName, title);
    }

    @Override
    public String toString() {
        return Utils.toString(UpdateTrackRequest.class,
                "languageCode", languageCode,
                "languageName", languageName,
                "title", title);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String languageCode;

        private String languageName;

        private String title;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * The BCP 47 language code representing the track’s language.
         */
        public Builder languageCode(@Nullable String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        /**
         * The full name of the language corresponding to the `languageCode`.
         */
        public Builder languageName(@Nullable String languageName) {
            this.languageName = languageName;
            return this;
        }

        /**
         * Title of the track.
         */
        public Builder title(@Nullable String title) {
            this.title = title;
            return this;
        }

        public UpdateTrackRequest build() {
            return new UpdateTrackRequest(
                languageCode, languageName, title);
        }


        private static final LazySingletonValue<String> _SINGLETON_VALUE_LanguageCode =
                new LazySingletonValue<>(
                        "languageCode",
                        "\"fr\"",
                        new TypeReference<String>() {});

        private static final LazySingletonValue<String> _SINGLETON_VALUE_LanguageName =
                new LazySingletonValue<>(
                        "languageName",
                        "\"French\"",
                        new TypeReference<String>() {});
    }
}
