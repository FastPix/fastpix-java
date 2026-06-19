package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fastpix.sdk.utils.Utils;


public class UpdatedSourceAccessRequestBody {
    /**
     * The sourceAccess parameter determines whether the original media file is accessible. Set to true to
     * enable access or false to restrict it.
     */
    @JsonProperty("sourceAccess")
    private boolean sourceAccess;

    @JsonCreator
    public UpdatedSourceAccessRequestBody(
            @JsonProperty("sourceAccess") boolean sourceAccess) {
        this.sourceAccess = sourceAccess;
    }

    /**
     * The sourceAccess parameter determines whether the original media file is accessible. Set to true to
     * enable access or false to restrict it.
     */
    public boolean sourceAccess() {
        return this.sourceAccess;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The sourceAccess parameter determines whether the original media file is accessible. Set to true to
     * enable access or false to restrict it.
     */
    public UpdatedSourceAccessRequestBody withSourceAccess(boolean sourceAccess) {
        this.sourceAccess = sourceAccess;
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
        UpdatedSourceAccessRequestBody other = (UpdatedSourceAccessRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.sourceAccess, other.sourceAccess);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            sourceAccess);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdatedSourceAccessRequestBody.class,
                "sourceAccess", sourceAccess);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private boolean sourceAccess;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * The sourceAccess parameter determines whether the original media file is accessible. Set to true to
         * enable access or false to restrict it.
         */
        public Builder sourceAccess(boolean sourceAccess) {
            this.sourceAccess = sourceAccess;
            return this;
        }

        public UpdatedSourceAccessRequestBody build() {
            return new UpdatedSourceAccessRequestBody(
                sourceAccess);
        }

    }
}
