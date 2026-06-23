package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import java.util.Map;
import java.util.Optional;
import io.fastpix.sdk.utils.Utils;

/**
 * Subtitles
 * 
 * <p>Generates subtitle files for audio/video files.
 */
public class Subtitles {

    private static final String PROP_LANGUAGE_NAME = "languageName";
    private static final String PROP_METADATA = "metadata";
    private static final String PROP_LANGUAGE_CODE = "languageCode";

    /**
     * Name of the language in which the subtitles will be generated.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty(PROP_LANGUAGE_NAME)
    private String languageName;

    /**
     * You can search for videos with specific key value pairs using metadata, when you tag a video in
     * "key" : "value" pairs. Dynamic metadata allows you to define a key that allows any value pair. You
     * can have maximum of 255 characters and upto 10 entries are allowed.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty(PROP_METADATA)
    private Map<String, String> metadata;

    /**
     * Language codes are concise, standardized symbols that denote languages, utilizing either two or
     * three characters for identification. The language code must be compliant with the BCP 47 standard to
     * ensure compatibility. (for text only).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty(PROP_LANGUAGE_CODE)
    private CreateMediaRequestLanguageCode languageCode;

    @JsonCreator
    public Subtitles(
            @JsonProperty(PROP_LANGUAGE_NAME) @Nullable String languageName,
            @JsonProperty(PROP_METADATA) @Nullable Map<String, String> metadata,
            @JsonProperty(PROP_LANGUAGE_CODE) @Nullable CreateMediaRequestLanguageCode languageCode) {
        this.languageName = languageName;
        this.metadata = metadata;
        this.languageCode = languageCode;
    }
    
    public Subtitles() {
        this(null, null, null);
    }

    /**
     * Name of the language in which the subtitles will be generated.
     */
    public Optional<String> languageName() {
        return Optional.ofNullable(this.languageName);
    }

    /**
     * You can search for videos with specific key value pairs using metadata, when you tag a video in
     * "key" : "value" pairs. Dynamic metadata allows you to define a key that allows any value pair. You
     * can have maximum of 255 characters and upto 10 entries are allowed.
     */
    public Optional<Map<String, String>> metadata() {
        return Optional.ofNullable(this.metadata);
    }

    /**
     * Language codes are concise, standardized symbols that denote languages, utilizing either two or
     * three characters for identification. The language code must be compliant with the BCP 47 standard to
     * ensure compatibility. (for text only).
     */
    public Optional<CreateMediaRequestLanguageCode> languageCode() {
        return Optional.ofNullable(this.languageCode);
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Name of the language in which the subtitles will be generated.
     */
    public Subtitles withLanguageName(@Nullable String languageName) {
        this.languageName = languageName;
        return this;
    }


    /**
     * You can search for videos with specific key value pairs using metadata, when you tag a video in
     * "key" : "value" pairs. Dynamic metadata allows you to define a key that allows any value pair. You
     * can have maximum of 255 characters and upto 10 entries are allowed.
     */
    public Subtitles withMetadata(@Nullable Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }


    /**
     * Language codes are concise, standardized symbols that denote languages, utilizing either two or
     * three characters for identification. The language code must be compliant with the BCP 47 standard to
     * ensure compatibility. (for text only).
     */
    public Subtitles withLanguageCode(@Nullable CreateMediaRequestLanguageCode languageCode) {
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
        Subtitles other = (Subtitles) o;
        return 
            Utils.enhancedDeepEquals(this.languageName, other.languageName) &&
            Utils.enhancedDeepEquals(this.metadata, other.metadata) &&
            Utils.enhancedDeepEquals(this.languageCode, other.languageCode);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            languageName, metadata, languageCode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Subtitles.class,
                PROP_LANGUAGE_NAME, languageName,
                PROP_METADATA, metadata,
                PROP_LANGUAGE_CODE, languageCode);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String languageName;

        private Map<String, String> metadata;

        private CreateMediaRequestLanguageCode languageCode;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Name of the language in which the subtitles will be generated.
         */
        public Builder languageName(@Nullable String languageName) {
            this.languageName = languageName;
            return this;
        }

        /**
         * You can search for videos with specific key value pairs using metadata, when you tag a video in
         * "key" : "value" pairs. Dynamic metadata allows you to define a key that allows any value pair. You
         * can have maximum of 255 characters and upto 10 entries are allowed.
         */
        public Builder metadata(@Nullable Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Language codes are concise, standardized symbols that denote languages, utilizing either two or
         * three characters for identification. The language code must be compliant with the BCP 47 standard to
         * ensure compatibility. (for text only).
         */
        public Builder languageCode(@Nullable CreateMediaRequestLanguageCode languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        public Subtitles build() {
            return new Subtitles(
                languageName, metadata, languageCode);
        }

    }
}
