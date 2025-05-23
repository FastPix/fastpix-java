/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.operations;

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

public class Moderation {

    /**
     * Defines the type of input. Possible values include video, audio, av.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("type")
    private Optional<? extends Type> type;

    @JsonCreator
    public Moderation(
            @JsonProperty("type") Optional<? extends Type> type) {
        Utils.checkNotNull(type, "type");
        this.type = type;
    }
    
    public Moderation() {
        this(Optional.empty());
    }

    /**
     * Defines the type of input. Possible values include video, audio, av.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Type> type() {
        return (Optional<Type>) type;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Defines the type of input. Possible values include video, audio, av.
     */
    public Moderation withType(Type type) {
        Utils.checkNotNull(type, "type");
        this.type = Optional.ofNullable(type);
        return this;
    }

    /**
     * Defines the type of input. Possible values include video, audio, av.
     */
    public Moderation withType(Optional<? extends Type> type) {
        Utils.checkNotNull(type, "type");
        this.type = type;
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
        Moderation other = (Moderation) o;
        return 
            Objects.deepEquals(this.type, other.type);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            type);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Moderation.class,
                "type", type);
    }
    
    public final static class Builder {
 
        private Optional<? extends Type> type = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Defines the type of input. Possible values include video, audio, av.
         */
        public Builder type(Type type) {
            Utils.checkNotNull(type, "type");
            this.type = Optional.ofNullable(type);
            return this;
        }

        /**
         * Defines the type of input. Possible values include video, audio, av.
         */
        public Builder type(Optional<? extends Type> type) {
            Utils.checkNotNull(type, "type");
            this.type = type;
            return this;
        }
        
        public Moderation build() {
            return new Moderation(
                type);
        }
    }
}
