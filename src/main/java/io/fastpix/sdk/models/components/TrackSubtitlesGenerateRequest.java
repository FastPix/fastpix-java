package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.Nullable;
import java.util.Map;
import java.util.Optional;
import io.fastpix.sdk.utils.LazySingletonValue;
import io.fastpix.sdk.utils.Utils;

/**
 * TrackSubtitlesGenerateRequest
 * 
 * <p>Contains details for generating subtitle tracks for a media file.
 */
public class TrackSubtitlesGenerateRequest {
    /**
     * The full name of the language used to generate the subtitles.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("languageName")
    private String languageName;

    /**
     * You can search for videos with specific key value pairs using metadata, when you tag a video in
     * "key" : "value" pairs. Dynamic metadata allows you to define a key that allows any value pair. You
     * can have maximum of 255 characters and upto 10 entries are allowed.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("metadata")
    private Map<String, String> metadata;

    /**
     * Language code for content localization
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("languageCode")
    private LanguageCode languageCode;

    /**
     * Title of the track.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("title")
    private String title;

    @JsonCreator
    public TrackSubtitlesGenerateRequest(
            @JsonProperty("languageName") @Nullable String languageName,
            @JsonProperty("metadata") @Nullable Map<String, String> metadata,
            @JsonProperty("languageCode") @Nullable LanguageCode languageCode,
            @JsonProperty("title") @Nullable String title) {
        this.languageName = Optional.ofNullable(languageName)
            .orElse(Builder._SINGLETON_VALUE_LanguageName.value());
        this.metadata = metadata;
        this.languageCode = Optional.ofNullable(languageCode)
            .orElse(Builder._SINGLETON_VALUE_LanguageCode.value());
        this.title = title;
    }
    
    public TrackSubtitlesGenerateRequest() {
        this(null, null, null, null);
    }

    /**
     * The full name of the language used to generate the subtitles.
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
     * Language code for content localization
     */
    public Optional<LanguageCode> languageCode() {
        return Optional.ofNullable(this.languageCode);
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
     * The full name of the language used to generate the subtitles.
     */
    public TrackSubtitlesGenerateRequest withLanguageName(@Nullable String languageName) {
        this.languageName = languageName;
        return this;
    }


    /**
     * You can search for videos with specific key value pairs using metadata, when you tag a video in
     * "key" : "value" pairs. Dynamic metadata allows you to define a key that allows any value pair. You
     * can have maximum of 255 characters and upto 10 entries are allowed.
     */
    public TrackSubtitlesGenerateRequest withMetadata(@Nullable Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }


    /**
     * Language code for content localization
     */
    public TrackSubtitlesGenerateRequest withLanguageCode(@Nullable LanguageCode languageCode) {
        this.languageCode = languageCode;
        return this;
    }


    /**
     * Title of the track.
     */
    public TrackSubtitlesGenerateRequest withTitle(@Nullable String title) {
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
        TrackSubtitlesGenerateRequest other = (TrackSubtitlesGenerateRequest) o;
        return 
            Utils.enhancedDeepEquals(this.languageName, other.languageName) &&
            Utils.enhancedDeepEquals(this.metadata, other.metadata) &&
            Utils.enhancedDeepEquals(this.languageCode, other.languageCode) &&
            Utils.enhancedDeepEquals(this.title, other.title);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            languageName, metadata, languageCode, title);
    }
    
    @Override
    public String toString() {
        return Utils.toString(TrackSubtitlesGenerateRequest.class,
                "languageName", languageName,
                "metadata", metadata,
                "languageCode", languageCode,
                "title", title);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String languageName;

        private Map<String, String> metadata;

        private LanguageCode languageCode;

        private String title;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * The full name of the language used to generate the subtitles.
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
         * Language code for content localization
         */
        public Builder languageCode(@Nullable LanguageCode languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        /**
         * Title of the track.
         */
        public Builder title(@Nullable String title) {
            this.title = title;
            return this;
        }

        public TrackSubtitlesGenerateRequest build() {
            return new TrackSubtitlesGenerateRequest(
                languageName, metadata, languageCode, title);
        }


        private static final LazySingletonValue<String> _SINGLETON_VALUE_LanguageName =
                new LazySingletonValue<>(
                        "languageName",
                        "\"English\"",
                        new TypeReference<String>() {});

        private static final LazySingletonValue<LanguageCode> _SINGLETON_VALUE_LanguageCode =
                new LazySingletonValue<>(
                        "languageCode",
                        "\"en-US\"",
                        new TypeReference<LanguageCode>() {});
    }
}
