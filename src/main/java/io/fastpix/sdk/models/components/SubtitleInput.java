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

/**
 * SubtitleInput
 * 
 * <p>Generates subtitle files for audio/video files.
 */
public class SubtitleInput {

    private static final String PROP_TYPE = "type";
    private static final String PROP_URL = "url";
    private static final String PROP_LANGUAGE_NAME = "languageName";
    private static final String PROP_LANGUAGE_CODE = "languageCode";

    /**
     * Defines the type of input.
     */
    @JsonProperty(PROP_TYPE)
    private String type;

    /**
     * The direct URL of the subtitle file.
     */
    @JsonProperty(PROP_URL)
    private String url;

    /**
     * Name of the language in which the subtitles will be generated.
     */
    @JsonProperty(PROP_LANGUAGE_NAME)
    private String languageName;

    /**
     * Language code for content localization
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty(PROP_LANGUAGE_CODE)
    private LanguageCode languageCode;

    @JsonCreator
    public SubtitleInput(
            @JsonProperty(PROP_TYPE) @Nonnull String type,
            @JsonProperty(PROP_URL) @Nonnull String url,
            @JsonProperty(PROP_LANGUAGE_NAME) @Nonnull String languageName,
            @JsonProperty(PROP_LANGUAGE_CODE) @Nullable LanguageCode languageCode) {
        this.type = Optional.ofNullable(type)
            .orElseThrow(() -> new IllegalArgumentException("type cannot be null"));
        this.url = Optional.ofNullable(url)
            .orElseThrow(() -> new IllegalArgumentException("url cannot be null"));
        this.languageName = Optional.ofNullable(languageName)
            .orElseThrow(() -> new IllegalArgumentException("languageName cannot be null"));
        this.languageCode = Optional.ofNullable(languageCode)
            .orElse(Builder._SINGLETON_VALUE_LanguageCode.value());
    }
    
    public SubtitleInput(
            @Nonnull String type,
            @Nonnull String url,
            @Nonnull String languageName) {
        this(type, url, languageName,
            null);
    }

    /**
     * Defines the type of input.
     */
    public String type() {
        return this.type;
    }

    /**
     * The direct URL of the subtitle file.
     */
    public String url() {
        return this.url;
    }

    /**
     * Name of the language in which the subtitles will be generated.
     */
    public String languageName() {
        return this.languageName;
    }

    /**
     * Language code for content localization
     */
    public Optional<LanguageCode> languageCode() {
        return Optional.ofNullable(this.languageCode);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Defines the type of input.
     */
    public SubtitleInput withType(@Nonnull String type) {
        this.type = Utils.checkNotNull(type, PROP_TYPE);
        return this;
    }


    /**
     * The direct URL of the subtitle file.
     */
    public SubtitleInput withUrl(@Nonnull String url) {
        this.url = Utils.checkNotNull(url, PROP_URL);
        return this;
    }


    /**
     * Name of the language in which the subtitles will be generated.
     */
    public SubtitleInput withLanguageName(@Nonnull String languageName) {
        this.languageName = Utils.checkNotNull(languageName, PROP_LANGUAGE_NAME);
        return this;
    }


    /**
     * Language code for content localization
     */
    public SubtitleInput withLanguageCode(@Nullable LanguageCode languageCode) {
        this.languageCode = languageCode;
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
        SubtitleInput other = (SubtitleInput) o;
        return 
            Utils.enhancedDeepEquals(this.type, other.type) &&
            Utils.enhancedDeepEquals(this.url, other.url) &&
            Utils.enhancedDeepEquals(this.languageName, other.languageName) &&
            Utils.enhancedDeepEquals(this.languageCode, other.languageCode);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            type, url, languageName,
            languageCode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(SubtitleInput.class,
                PROP_TYPE, type,
                PROP_URL, url,
                PROP_LANGUAGE_NAME, languageName,
                PROP_LANGUAGE_CODE, languageCode);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String type;

        private String url;

        private String languageName;

        private LanguageCode languageCode;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Defines the type of input.
         */
        public Builder type(@Nonnull String type) {
            this.type = Utils.checkNotNull(type, PROP_TYPE);
            return this;
        }

        /**
         * The direct URL of the subtitle file.
         */
        public Builder url(@Nonnull String url) {
            this.url = Utils.checkNotNull(url, PROP_URL);
            return this;
        }

        /**
         * Name of the language in which the subtitles will be generated.
         */
        public Builder languageName(@Nonnull String languageName) {
            this.languageName = Utils.checkNotNull(languageName, PROP_LANGUAGE_NAME);
            return this;
        }

        /**
         * Language code for content localization
         */
        public Builder languageCode(@Nullable LanguageCode languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        public SubtitleInput build() {
            return new SubtitleInput(
                type, url, languageName,
                languageCode);
        }


        private static final LazySingletonValue<LanguageCode> _SINGLETON_VALUE_LanguageCode =
                new LazySingletonValue<>(
                        PROP_LANGUAGE_CODE,
                        "\"en-US\"",
                        new TypeReference<LanguageCode>() {});
    }
}
