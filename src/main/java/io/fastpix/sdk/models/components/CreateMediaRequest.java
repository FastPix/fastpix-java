/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.fastpix.sdk.utils.LazySingletonValue;
import io.fastpix.sdk.utils.Utils;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CreateMediaRequest {

    @JsonProperty("inputs")
    private List<Input> inputs;

    /**
     * You can search for videos with specific key-value pairs using metadata, when you tag a video in "key" : "value" pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have a maximum of 255 characters and up to 10 entries are allowed.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("metadata")
    private Optional<? extends CreateMediaRequestMetadata> metadata;

    /**
     * Generates subtitle files for audio/video files.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("subtitle")
    private Optional<? extends Subtitle> subtitle;

    /**
     * Determines whether access to the streamed content is kept private or available to all.
     */
    @JsonProperty("accessPolicy")
    private CreateMediaRequestAccessPolicy accessPolicy;

    /**
     * “capped_4k": Generates an mp4 video file up to 4k resolution "audioOnly": Generates an m4a audio file of the media file "audioOnly,capped_4k": Generates both video and audio media files for offline viewing
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("mp4Support")
    private Optional<? extends CreateMediaRequestMp4Support> mp4Support;

    /**
     * The sourceAccess parameter determines whether the original media file is accessible. Set to true to enable access or false to restrict it
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("sourceAccess")
    private Optional<Boolean> sourceAccess;

    /**
     * normalize volume of the audio track. This is available for pre-recorded content only.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("optimizeAudio")
    private Optional<Boolean> optimizeAudio;

    /**
     * The maximum resolution tier determines the highest quality your media will be available in.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("maxResolution")
    private Optional<? extends CreateMediaRequestMaxResolution> maxResolution;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("summary")
    private Optional<? extends Summary> summary;

    /**
     * Enable or disable the chapters feature for the media. Set to `true` to enable chapters or `false` to disable.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("chapters")
    private Optional<Boolean> chapters;

    /**
     * Enable or disable named entity extraction. Set to `true` to enable or `false` to disable.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("namedEntities")
    private Optional<Boolean> namedEntities;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("moderation")
    private Optional<? extends Moderation> moderation;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("accessRestrictions")
    private Optional<? extends CreateMediaRequestAccessRestrictions> accessRestrictions;

    @JsonCreator
    public CreateMediaRequest(
            @JsonProperty("inputs") List<Input> inputs,
            @JsonProperty("metadata") Optional<? extends CreateMediaRequestMetadata> metadata,
            @JsonProperty("subtitle") Optional<? extends Subtitle> subtitle,
            @JsonProperty("accessPolicy") CreateMediaRequestAccessPolicy accessPolicy,
            @JsonProperty("mp4Support") Optional<? extends CreateMediaRequestMp4Support> mp4Support,
            @JsonProperty("sourceAccess") Optional<Boolean> sourceAccess,
            @JsonProperty("optimizeAudio") Optional<Boolean> optimizeAudio,
            @JsonProperty("maxResolution") Optional<? extends CreateMediaRequestMaxResolution> maxResolution,
            @JsonProperty("summary") Optional<? extends Summary> summary,
            @JsonProperty("chapters") Optional<Boolean> chapters,
            @JsonProperty("namedEntities") Optional<Boolean> namedEntities,
            @JsonProperty("moderation") Optional<? extends Moderation> moderation,
            @JsonProperty("accessRestrictions") Optional<? extends CreateMediaRequestAccessRestrictions> accessRestrictions) {
        Utils.checkNotNull(inputs, "inputs");
        Utils.checkNotNull(metadata, "metadata");
        Utils.checkNotNull(subtitle, "subtitle");
        Utils.checkNotNull(accessPolicy, "accessPolicy");
        Utils.checkNotNull(mp4Support, "mp4Support");
        Utils.checkNotNull(sourceAccess, "sourceAccess");
        Utils.checkNotNull(optimizeAudio, "optimizeAudio");
        Utils.checkNotNull(maxResolution, "maxResolution");
        Utils.checkNotNull(summary, "summary");
        Utils.checkNotNull(chapters, "chapters");
        Utils.checkNotNull(namedEntities, "namedEntities");
        Utils.checkNotNull(moderation, "moderation");
        Utils.checkNotNull(accessRestrictions, "accessRestrictions");
        this.inputs = inputs;
        this.metadata = metadata;
        this.subtitle = subtitle;
        this.accessPolicy = accessPolicy;
        this.mp4Support = mp4Support;
        this.sourceAccess = sourceAccess;
        this.optimizeAudio = optimizeAudio;
        this.maxResolution = maxResolution;
        this.summary = summary;
        this.chapters = chapters;
        this.namedEntities = namedEntities;
        this.moderation = moderation;
        this.accessRestrictions = accessRestrictions;
    }
    
    public CreateMediaRequest(
            List<Input> inputs,
            CreateMediaRequestAccessPolicy accessPolicy) {
        this(inputs, Optional.empty(), Optional.empty(), accessPolicy, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    @JsonIgnore
    public List<Input> inputs() {
        return inputs;
    }

    /**
     * You can search for videos with specific key-value pairs using metadata, when you tag a video in "key" : "value" pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have a maximum of 255 characters and up to 10 entries are allowed.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateMediaRequestMetadata> metadata() {
        return (Optional<CreateMediaRequestMetadata>) metadata;
    }

    /**
     * Generates subtitle files for audio/video files.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Subtitle> subtitle() {
        return (Optional<Subtitle>) subtitle;
    }

    /**
     * Determines whether access to the streamed content is kept private or available to all.
     */
    @JsonIgnore
    public CreateMediaRequestAccessPolicy accessPolicy() {
        return accessPolicy;
    }

    /**
     * “capped_4k": Generates an mp4 video file up to 4k resolution "audioOnly": Generates an m4a audio file of the media file "audioOnly,capped_4k": Generates both video and audio media files for offline viewing
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateMediaRequestMp4Support> mp4Support() {
        return (Optional<CreateMediaRequestMp4Support>) mp4Support;
    }

    /**
     * The sourceAccess parameter determines whether the original media file is accessible. Set to true to enable access or false to restrict it
     */
    @JsonIgnore
    public Optional<Boolean> sourceAccess() {
        return sourceAccess;
    }

    /**
     * normalize volume of the audio track. This is available for pre-recorded content only.
     */
    @JsonIgnore
    public Optional<Boolean> optimizeAudio() {
        return optimizeAudio;
    }

    /**
     * The maximum resolution tier determines the highest quality your media will be available in.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateMediaRequestMaxResolution> maxResolution() {
        return (Optional<CreateMediaRequestMaxResolution>) maxResolution;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Summary> summary() {
        return (Optional<Summary>) summary;
    }

    /**
     * Enable or disable the chapters feature for the media. Set to `true` to enable chapters or `false` to disable.
     */
    @JsonIgnore
    public Optional<Boolean> chapters() {
        return chapters;
    }

    /**
     * Enable or disable named entity extraction. Set to `true` to enable or `false` to disable.
     */
    @JsonIgnore
    public Optional<Boolean> namedEntities() {
        return namedEntities;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Moderation> moderation() {
        return (Optional<Moderation>) moderation;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateMediaRequestAccessRestrictions> accessRestrictions() {
        return (Optional<CreateMediaRequestAccessRestrictions>) accessRestrictions;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public CreateMediaRequest withInputs(List<Input> inputs) {
        Utils.checkNotNull(inputs, "inputs");
        this.inputs = inputs;
        return this;
    }

    /**
     * You can search for videos with specific key-value pairs using metadata, when you tag a video in "key" : "value" pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have a maximum of 255 characters and up to 10 entries are allowed.
     */
    public CreateMediaRequest withMetadata(CreateMediaRequestMetadata metadata) {
        Utils.checkNotNull(metadata, "metadata");
        this.metadata = Optional.ofNullable(metadata);
        return this;
    }

    /**
     * You can search for videos with specific key-value pairs using metadata, when you tag a video in "key" : "value" pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have a maximum of 255 characters and up to 10 entries are allowed.
     */
    public CreateMediaRequest withMetadata(Optional<? extends CreateMediaRequestMetadata> metadata) {
        Utils.checkNotNull(metadata, "metadata");
        this.metadata = metadata;
        return this;
    }

    /**
     * Generates subtitle files for audio/video files.
     */
    public CreateMediaRequest withSubtitle(Subtitle subtitle) {
        Utils.checkNotNull(subtitle, "subtitle");
        this.subtitle = Optional.ofNullable(subtitle);
        return this;
    }

    /**
     * Generates subtitle files for audio/video files.
     */
    public CreateMediaRequest withSubtitle(Optional<? extends Subtitle> subtitle) {
        Utils.checkNotNull(subtitle, "subtitle");
        this.subtitle = subtitle;
        return this;
    }

    /**
     * Determines whether access to the streamed content is kept private or available to all.
     */
    public CreateMediaRequest withAccessPolicy(CreateMediaRequestAccessPolicy accessPolicy) {
        Utils.checkNotNull(accessPolicy, "accessPolicy");
        this.accessPolicy = accessPolicy;
        return this;
    }

    /**
     * “capped_4k": Generates an mp4 video file up to 4k resolution "audioOnly": Generates an m4a audio file of the media file "audioOnly,capped_4k": Generates both video and audio media files for offline viewing
     */
    public CreateMediaRequest withMp4Support(CreateMediaRequestMp4Support mp4Support) {
        Utils.checkNotNull(mp4Support, "mp4Support");
        this.mp4Support = Optional.ofNullable(mp4Support);
        return this;
    }

    /**
     * “capped_4k": Generates an mp4 video file up to 4k resolution "audioOnly": Generates an m4a audio file of the media file "audioOnly,capped_4k": Generates both video and audio media files for offline viewing
     */
    public CreateMediaRequest withMp4Support(Optional<? extends CreateMediaRequestMp4Support> mp4Support) {
        Utils.checkNotNull(mp4Support, "mp4Support");
        this.mp4Support = mp4Support;
        return this;
    }

    /**
     * The sourceAccess parameter determines whether the original media file is accessible. Set to true to enable access or false to restrict it
     */
    public CreateMediaRequest withSourceAccess(boolean sourceAccess) {
        Utils.checkNotNull(sourceAccess, "sourceAccess");
        this.sourceAccess = Optional.ofNullable(sourceAccess);
        return this;
    }

    /**
     * The sourceAccess parameter determines whether the original media file is accessible. Set to true to enable access or false to restrict it
     */
    public CreateMediaRequest withSourceAccess(Optional<Boolean> sourceAccess) {
        Utils.checkNotNull(sourceAccess, "sourceAccess");
        this.sourceAccess = sourceAccess;
        return this;
    }

    /**
     * normalize volume of the audio track. This is available for pre-recorded content only.
     */
    public CreateMediaRequest withOptimizeAudio(boolean optimizeAudio) {
        Utils.checkNotNull(optimizeAudio, "optimizeAudio");
        this.optimizeAudio = Optional.ofNullable(optimizeAudio);
        return this;
    }

    /**
     * normalize volume of the audio track. This is available for pre-recorded content only.
     */
    public CreateMediaRequest withOptimizeAudio(Optional<Boolean> optimizeAudio) {
        Utils.checkNotNull(optimizeAudio, "optimizeAudio");
        this.optimizeAudio = optimizeAudio;
        return this;
    }

    /**
     * The maximum resolution tier determines the highest quality your media will be available in.
     */
    public CreateMediaRequest withMaxResolution(CreateMediaRequestMaxResolution maxResolution) {
        Utils.checkNotNull(maxResolution, "maxResolution");
        this.maxResolution = Optional.ofNullable(maxResolution);
        return this;
    }

    /**
     * The maximum resolution tier determines the highest quality your media will be available in.
     */
    public CreateMediaRequest withMaxResolution(Optional<? extends CreateMediaRequestMaxResolution> maxResolution) {
        Utils.checkNotNull(maxResolution, "maxResolution");
        this.maxResolution = maxResolution;
        return this;
    }

    public CreateMediaRequest withSummary(Summary summary) {
        Utils.checkNotNull(summary, "summary");
        this.summary = Optional.ofNullable(summary);
        return this;
    }

    public CreateMediaRequest withSummary(Optional<? extends Summary> summary) {
        Utils.checkNotNull(summary, "summary");
        this.summary = summary;
        return this;
    }

    /**
     * Enable or disable the chapters feature for the media. Set to `true` to enable chapters or `false` to disable.
     */
    public CreateMediaRequest withChapters(boolean chapters) {
        Utils.checkNotNull(chapters, "chapters");
        this.chapters = Optional.ofNullable(chapters);
        return this;
    }

    /**
     * Enable or disable the chapters feature for the media. Set to `true` to enable chapters or `false` to disable.
     */
    public CreateMediaRequest withChapters(Optional<Boolean> chapters) {
        Utils.checkNotNull(chapters, "chapters");
        this.chapters = chapters;
        return this;
    }

    /**
     * Enable or disable named entity extraction. Set to `true` to enable or `false` to disable.
     */
    public CreateMediaRequest withNamedEntities(boolean namedEntities) {
        Utils.checkNotNull(namedEntities, "namedEntities");
        this.namedEntities = Optional.ofNullable(namedEntities);
        return this;
    }

    /**
     * Enable or disable named entity extraction. Set to `true` to enable or `false` to disable.
     */
    public CreateMediaRequest withNamedEntities(Optional<Boolean> namedEntities) {
        Utils.checkNotNull(namedEntities, "namedEntities");
        this.namedEntities = namedEntities;
        return this;
    }

    public CreateMediaRequest withModeration(Moderation moderation) {
        Utils.checkNotNull(moderation, "moderation");
        this.moderation = Optional.ofNullable(moderation);
        return this;
    }

    public CreateMediaRequest withModeration(Optional<? extends Moderation> moderation) {
        Utils.checkNotNull(moderation, "moderation");
        this.moderation = moderation;
        return this;
    }

    public CreateMediaRequest withAccessRestrictions(CreateMediaRequestAccessRestrictions accessRestrictions) {
        Utils.checkNotNull(accessRestrictions, "accessRestrictions");
        this.accessRestrictions = Optional.ofNullable(accessRestrictions);
        return this;
    }

    public CreateMediaRequest withAccessRestrictions(Optional<? extends CreateMediaRequestAccessRestrictions> accessRestrictions) {
        Utils.checkNotNull(accessRestrictions, "accessRestrictions");
        this.accessRestrictions = accessRestrictions;
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
        CreateMediaRequest other = (CreateMediaRequest) o;
        return 
            Objects.deepEquals(this.inputs, other.inputs) &&
            Objects.deepEquals(this.metadata, other.metadata) &&
            Objects.deepEquals(this.subtitle, other.subtitle) &&
            Objects.deepEquals(this.accessPolicy, other.accessPolicy) &&
            Objects.deepEquals(this.mp4Support, other.mp4Support) &&
            Objects.deepEquals(this.sourceAccess, other.sourceAccess) &&
            Objects.deepEquals(this.optimizeAudio, other.optimizeAudio) &&
            Objects.deepEquals(this.maxResolution, other.maxResolution) &&
            Objects.deepEquals(this.summary, other.summary) &&
            Objects.deepEquals(this.chapters, other.chapters) &&
            Objects.deepEquals(this.namedEntities, other.namedEntities) &&
            Objects.deepEquals(this.moderation, other.moderation) &&
            Objects.deepEquals(this.accessRestrictions, other.accessRestrictions);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            inputs,
            metadata,
            subtitle,
            accessPolicy,
            mp4Support,
            sourceAccess,
            optimizeAudio,
            maxResolution,
            summary,
            chapters,
            namedEntities,
            moderation,
            accessRestrictions);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateMediaRequest.class,
                "inputs", inputs,
                "metadata", metadata,
                "subtitle", subtitle,
                "accessPolicy", accessPolicy,
                "mp4Support", mp4Support,
                "sourceAccess", sourceAccess,
                "optimizeAudio", optimizeAudio,
                "maxResolution", maxResolution,
                "summary", summary,
                "chapters", chapters,
                "namedEntities", namedEntities,
                "moderation", moderation,
                "accessRestrictions", accessRestrictions);
    }
    
    public final static class Builder {
 
        private List<Input> inputs;
 
        private Optional<? extends CreateMediaRequestMetadata> metadata = Optional.empty();
 
        private Optional<? extends Subtitle> subtitle = Optional.empty();
 
        private CreateMediaRequestAccessPolicy accessPolicy;
 
        private Optional<? extends CreateMediaRequestMp4Support> mp4Support = Optional.empty();
 
        private Optional<Boolean> sourceAccess = Optional.empty();
 
        private Optional<Boolean> optimizeAudio;
 
        private Optional<? extends CreateMediaRequestMaxResolution> maxResolution;
 
        private Optional<? extends Summary> summary = Optional.empty();
 
        private Optional<Boolean> chapters = Optional.empty();
 
        private Optional<Boolean> namedEntities = Optional.empty();
 
        private Optional<? extends Moderation> moderation = Optional.empty();
 
        private Optional<? extends CreateMediaRequestAccessRestrictions> accessRestrictions = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder inputs(List<Input> inputs) {
            Utils.checkNotNull(inputs, "inputs");
            this.inputs = inputs;
            return this;
        }

        /**
         * You can search for videos with specific key-value pairs using metadata, when you tag a video in "key" : "value" pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have a maximum of 255 characters and up to 10 entries are allowed.
         */
        public Builder metadata(CreateMediaRequestMetadata metadata) {
            Utils.checkNotNull(metadata, "metadata");
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * You can search for videos with specific key-value pairs using metadata, when you tag a video in "key" : "value" pairs. Dynamic Metadata allows you to define a key that allows any value pair. You can have a maximum of 255 characters and up to 10 entries are allowed.
         */
        public Builder metadata(Optional<? extends CreateMediaRequestMetadata> metadata) {
            Utils.checkNotNull(metadata, "metadata");
            this.metadata = metadata;
            return this;
        }

        /**
         * Generates subtitle files for audio/video files.
         */
        public Builder subtitle(Subtitle subtitle) {
            Utils.checkNotNull(subtitle, "subtitle");
            this.subtitle = Optional.ofNullable(subtitle);
            return this;
        }

        /**
         * Generates subtitle files for audio/video files.
         */
        public Builder subtitle(Optional<? extends Subtitle> subtitle) {
            Utils.checkNotNull(subtitle, "subtitle");
            this.subtitle = subtitle;
            return this;
        }

        /**
         * Determines whether access to the streamed content is kept private or available to all.
         */
        public Builder accessPolicy(CreateMediaRequestAccessPolicy accessPolicy) {
            Utils.checkNotNull(accessPolicy, "accessPolicy");
            this.accessPolicy = accessPolicy;
            return this;
        }

        /**
         * “capped_4k": Generates an mp4 video file up to 4k resolution "audioOnly": Generates an m4a audio file of the media file "audioOnly,capped_4k": Generates both video and audio media files for offline viewing
         */
        public Builder mp4Support(CreateMediaRequestMp4Support mp4Support) {
            Utils.checkNotNull(mp4Support, "mp4Support");
            this.mp4Support = Optional.ofNullable(mp4Support);
            return this;
        }

        /**
         * “capped_4k": Generates an mp4 video file up to 4k resolution "audioOnly": Generates an m4a audio file of the media file "audioOnly,capped_4k": Generates both video and audio media files for offline viewing
         */
        public Builder mp4Support(Optional<? extends CreateMediaRequestMp4Support> mp4Support) {
            Utils.checkNotNull(mp4Support, "mp4Support");
            this.mp4Support = mp4Support;
            return this;
        }

        /**
         * The sourceAccess parameter determines whether the original media file is accessible. Set to true to enable access or false to restrict it
         */
        public Builder sourceAccess(boolean sourceAccess) {
            Utils.checkNotNull(sourceAccess, "sourceAccess");
            this.sourceAccess = Optional.ofNullable(sourceAccess);
            return this;
        }

        /**
         * The sourceAccess parameter determines whether the original media file is accessible. Set to true to enable access or false to restrict it
         */
        public Builder sourceAccess(Optional<Boolean> sourceAccess) {
            Utils.checkNotNull(sourceAccess, "sourceAccess");
            this.sourceAccess = sourceAccess;
            return this;
        }

        /**
         * normalize volume of the audio track. This is available for pre-recorded content only.
         */
        public Builder optimizeAudio(boolean optimizeAudio) {
            Utils.checkNotNull(optimizeAudio, "optimizeAudio");
            this.optimizeAudio = Optional.ofNullable(optimizeAudio);
            return this;
        }

        /**
         * normalize volume of the audio track. This is available for pre-recorded content only.
         */
        public Builder optimizeAudio(Optional<Boolean> optimizeAudio) {
            Utils.checkNotNull(optimizeAudio, "optimizeAudio");
            this.optimizeAudio = optimizeAudio;
            return this;
        }

        /**
         * The maximum resolution tier determines the highest quality your media will be available in.
         */
        public Builder maxResolution(CreateMediaRequestMaxResolution maxResolution) {
            Utils.checkNotNull(maxResolution, "maxResolution");
            this.maxResolution = Optional.ofNullable(maxResolution);
            return this;
        }

        /**
         * The maximum resolution tier determines the highest quality your media will be available in.
         */
        public Builder maxResolution(Optional<? extends CreateMediaRequestMaxResolution> maxResolution) {
            Utils.checkNotNull(maxResolution, "maxResolution");
            this.maxResolution = maxResolution;
            return this;
        }

        public Builder summary(Summary summary) {
            Utils.checkNotNull(summary, "summary");
            this.summary = Optional.ofNullable(summary);
            return this;
        }

        public Builder summary(Optional<? extends Summary> summary) {
            Utils.checkNotNull(summary, "summary");
            this.summary = summary;
            return this;
        }

        /**
         * Enable or disable the chapters feature for the media. Set to `true` to enable chapters or `false` to disable.
         */
        public Builder chapters(boolean chapters) {
            Utils.checkNotNull(chapters, "chapters");
            this.chapters = Optional.ofNullable(chapters);
            return this;
        }

        /**
         * Enable or disable the chapters feature for the media. Set to `true` to enable chapters or `false` to disable.
         */
        public Builder chapters(Optional<Boolean> chapters) {
            Utils.checkNotNull(chapters, "chapters");
            this.chapters = chapters;
            return this;
        }

        /**
         * Enable or disable named entity extraction. Set to `true` to enable or `false` to disable.
         */
        public Builder namedEntities(boolean namedEntities) {
            Utils.checkNotNull(namedEntities, "namedEntities");
            this.namedEntities = Optional.ofNullable(namedEntities);
            return this;
        }

        /**
         * Enable or disable named entity extraction. Set to `true` to enable or `false` to disable.
         */
        public Builder namedEntities(Optional<Boolean> namedEntities) {
            Utils.checkNotNull(namedEntities, "namedEntities");
            this.namedEntities = namedEntities;
            return this;
        }

        public Builder moderation(Moderation moderation) {
            Utils.checkNotNull(moderation, "moderation");
            this.moderation = Optional.ofNullable(moderation);
            return this;
        }

        public Builder moderation(Optional<? extends Moderation> moderation) {
            Utils.checkNotNull(moderation, "moderation");
            this.moderation = moderation;
            return this;
        }

        public Builder accessRestrictions(CreateMediaRequestAccessRestrictions accessRestrictions) {
            Utils.checkNotNull(accessRestrictions, "accessRestrictions");
            this.accessRestrictions = Optional.ofNullable(accessRestrictions);
            return this;
        }

        public Builder accessRestrictions(Optional<? extends CreateMediaRequestAccessRestrictions> accessRestrictions) {
            Utils.checkNotNull(accessRestrictions, "accessRestrictions");
            this.accessRestrictions = accessRestrictions;
            return this;
        }
        
        public CreateMediaRequest build() {
            if (optimizeAudio == null) {
                optimizeAudio = _SINGLETON_VALUE_OptimizeAudio.value();
            }
            if (maxResolution == null) {
                maxResolution = _SINGLETON_VALUE_MaxResolution.value();
            }
            return new CreateMediaRequest(
                inputs,
                metadata,
                subtitle,
                accessPolicy,
                mp4Support,
                sourceAccess,
                optimizeAudio,
                maxResolution,
                summary,
                chapters,
                namedEntities,
                moderation,
                accessRestrictions);
        }

        private static final LazySingletonValue<Optional<Boolean>> _SINGLETON_VALUE_OptimizeAudio =
                new LazySingletonValue<>(
                        "optimizeAudio",
                        "false",
                        new TypeReference<Optional<Boolean>>() {});

        private static final LazySingletonValue<Optional<? extends CreateMediaRequestMaxResolution>> _SINGLETON_VALUE_MaxResolution =
                new LazySingletonValue<>(
                        "maxResolution",
                        "\"1080p\"",
                        new TypeReference<Optional<? extends CreateMediaRequestMaxResolution>>() {});
    }
}
