/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fastpix.sdk.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

public class WatermarkInput {

    /**
     * Type of overlay (currently only supports 'watermark').
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("type")
    private Optional<? extends WatermarkInputType> type;

    /**
     * URL of the watermark image.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("url")
    private Optional<String> url;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("placement")
    private Optional<? extends Placement> placement;

    /**
     * Width of the watermark in percentage or pixels.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("width")
    private Optional<String> width;

    /**
     * Height of the watermark in percentage or pixels.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("height")
    private Optional<String> height;

    /**
     * Opacity of the watermark in percentage.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("opacity")
    private Optional<String> opacity;

    @JsonCreator
    public WatermarkInput(
            @JsonProperty("type") Optional<? extends WatermarkInputType> type,
            @JsonProperty("url") Optional<String> url,
            @JsonProperty("placement") Optional<? extends Placement> placement,
            @JsonProperty("width") Optional<String> width,
            @JsonProperty("height") Optional<String> height,
            @JsonProperty("opacity") Optional<String> opacity) {
        Utils.checkNotNull(type, "type");
        Utils.checkNotNull(url, "url");
        Utils.checkNotNull(placement, "placement");
        Utils.checkNotNull(width, "width");
        Utils.checkNotNull(height, "height");
        Utils.checkNotNull(opacity, "opacity");
        this.type = type;
        this.url = url;
        this.placement = placement;
        this.width = width;
        this.height = height;
        this.opacity = opacity;
    }
    
    public WatermarkInput() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * Type of overlay (currently only supports 'watermark').
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<WatermarkInputType> type() {
        return (Optional<WatermarkInputType>) type;
    }

    /**
     * URL of the watermark image.
     */
    @JsonIgnore
    public Optional<String> url() {
        return url;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Placement> placement() {
        return (Optional<Placement>) placement;
    }

    /**
     * Width of the watermark in percentage or pixels.
     */
    @JsonIgnore
    public Optional<String> width() {
        return width;
    }

    /**
     * Height of the watermark in percentage or pixels.
     */
    @JsonIgnore
    public Optional<String> height() {
        return height;
    }

    /**
     * Opacity of the watermark in percentage.
     */
    @JsonIgnore
    public Optional<String> opacity() {
        return opacity;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Type of overlay (currently only supports 'watermark').
     */
    public WatermarkInput withType(WatermarkInputType type) {
        Utils.checkNotNull(type, "type");
        this.type = Optional.ofNullable(type);
        return this;
    }

    /**
     * Type of overlay (currently only supports 'watermark').
     */
    public WatermarkInput withType(Optional<? extends WatermarkInputType> type) {
        Utils.checkNotNull(type, "type");
        this.type = type;
        return this;
    }

    /**
     * URL of the watermark image.
     */
    public WatermarkInput withUrl(String url) {
        Utils.checkNotNull(url, "url");
        this.url = Optional.ofNullable(url);
        return this;
    }

    /**
     * URL of the watermark image.
     */
    public WatermarkInput withUrl(Optional<String> url) {
        Utils.checkNotNull(url, "url");
        this.url = url;
        return this;
    }

    public WatermarkInput withPlacement(Placement placement) {
        Utils.checkNotNull(placement, "placement");
        this.placement = Optional.ofNullable(placement);
        return this;
    }

    public WatermarkInput withPlacement(Optional<? extends Placement> placement) {
        Utils.checkNotNull(placement, "placement");
        this.placement = placement;
        return this;
    }

    /**
     * Width of the watermark in percentage or pixels.
     */
    public WatermarkInput withWidth(String width) {
        Utils.checkNotNull(width, "width");
        this.width = Optional.ofNullable(width);
        return this;
    }

    /**
     * Width of the watermark in percentage or pixels.
     */
    public WatermarkInput withWidth(Optional<String> width) {
        Utils.checkNotNull(width, "width");
        this.width = width;
        return this;
    }

    /**
     * Height of the watermark in percentage or pixels.
     */
    public WatermarkInput withHeight(String height) {
        Utils.checkNotNull(height, "height");
        this.height = Optional.ofNullable(height);
        return this;
    }

    /**
     * Height of the watermark in percentage or pixels.
     */
    public WatermarkInput withHeight(Optional<String> height) {
        Utils.checkNotNull(height, "height");
        this.height = height;
        return this;
    }

    /**
     * Opacity of the watermark in percentage.
     */
    public WatermarkInput withOpacity(String opacity) {
        Utils.checkNotNull(opacity, "opacity");
        this.opacity = Optional.ofNullable(opacity);
        return this;
    }

    /**
     * Opacity of the watermark in percentage.
     */
    public WatermarkInput withOpacity(Optional<String> opacity) {
        Utils.checkNotNull(opacity, "opacity");
        this.opacity = opacity;
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
        WatermarkInput other = (WatermarkInput) o;
        return 
            Objects.deepEquals(this.type, other.type) &&
            Objects.deepEquals(this.url, other.url) &&
            Objects.deepEquals(this.placement, other.placement) &&
            Objects.deepEquals(this.width, other.width) &&
            Objects.deepEquals(this.height, other.height) &&
            Objects.deepEquals(this.opacity, other.opacity);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            type,
            url,
            placement,
            width,
            height,
            opacity);
    }
    
    @Override
    public String toString() {
        return Utils.toString(WatermarkInput.class,
                "type", type,
                "url", url,
                "placement", placement,
                "width", width,
                "height", height,
                "opacity", opacity);
    }
    
    public final static class Builder {
 
        private Optional<? extends WatermarkInputType> type = Optional.empty();
 
        private Optional<String> url = Optional.empty();
 
        private Optional<? extends Placement> placement = Optional.empty();
 
        private Optional<String> width = Optional.empty();
 
        private Optional<String> height = Optional.empty();
 
        private Optional<String> opacity = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Type of overlay (currently only supports 'watermark').
         */
        public Builder type(WatermarkInputType type) {
            Utils.checkNotNull(type, "type");
            this.type = Optional.ofNullable(type);
            return this;
        }

        /**
         * Type of overlay (currently only supports 'watermark').
         */
        public Builder type(Optional<? extends WatermarkInputType> type) {
            Utils.checkNotNull(type, "type");
            this.type = type;
            return this;
        }

        /**
         * URL of the watermark image.
         */
        public Builder url(String url) {
            Utils.checkNotNull(url, "url");
            this.url = Optional.ofNullable(url);
            return this;
        }

        /**
         * URL of the watermark image.
         */
        public Builder url(Optional<String> url) {
            Utils.checkNotNull(url, "url");
            this.url = url;
            return this;
        }

        public Builder placement(Placement placement) {
            Utils.checkNotNull(placement, "placement");
            this.placement = Optional.ofNullable(placement);
            return this;
        }

        public Builder placement(Optional<? extends Placement> placement) {
            Utils.checkNotNull(placement, "placement");
            this.placement = placement;
            return this;
        }

        /**
         * Width of the watermark in percentage or pixels.
         */
        public Builder width(String width) {
            Utils.checkNotNull(width, "width");
            this.width = Optional.ofNullable(width);
            return this;
        }

        /**
         * Width of the watermark in percentage or pixels.
         */
        public Builder width(Optional<String> width) {
            Utils.checkNotNull(width, "width");
            this.width = width;
            return this;
        }

        /**
         * Height of the watermark in percentage or pixels.
         */
        public Builder height(String height) {
            Utils.checkNotNull(height, "height");
            this.height = Optional.ofNullable(height);
            return this;
        }

        /**
         * Height of the watermark in percentage or pixels.
         */
        public Builder height(Optional<String> height) {
            Utils.checkNotNull(height, "height");
            this.height = height;
            return this;
        }

        /**
         * Opacity of the watermark in percentage.
         */
        public Builder opacity(String opacity) {
            Utils.checkNotNull(opacity, "opacity");
            this.opacity = Optional.ofNullable(opacity);
            return this;
        }

        /**
         * Opacity of the watermark in percentage.
         */
        public Builder opacity(Optional<String> opacity) {
            Utils.checkNotNull(opacity, "opacity");
            this.opacity = opacity;
            return this;
        }
        
        public WatermarkInput build() {
            return new WatermarkInput(
                type,
                url,
                placement,
                width,
                height,
                opacity);
        }
    }
}
