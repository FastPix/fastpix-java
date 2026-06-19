package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import io.fastpix.sdk.utils.FastpixMetadata;
import io.fastpix.sdk.utils.Utils;


public class GetVideoViewDetailsRequest {

    private static final String VIEW_ID = "viewId";
    /**
     * Pass View Id
     */
    @FastpixMetadata("pathParam:style=simple,explode=false,name=viewId")
    private String viewId;

    @JsonCreator
    public GetVideoViewDetailsRequest(
            @Nonnull String viewId) {
        this.viewId = Optional.ofNullable(viewId)
            .orElseThrow(() -> new IllegalArgumentException("viewId cannot be null"));
    }

    /**
     * Pass View Id
     */
    public String viewId() {
        return this.viewId;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Pass View Id
     */
    public GetVideoViewDetailsRequest withViewId(@Nonnull String viewId) {
        this.viewId = Utils.checkNotNull(viewId, VIEW_ID);
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
        GetVideoViewDetailsRequest other = (GetVideoViewDetailsRequest) o;
        return 
            Utils.enhancedDeepEquals(this.viewId, other.viewId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            viewId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetVideoViewDetailsRequest.class,
                VIEW_ID, viewId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public static final class Builder {

        private String viewId;

        private Builder() {
          // force use of static builder() method
        }

        /**
         * Pass View Id
         */
        public Builder viewId(@Nonnull String viewId) {
            this.viewId = Utils.checkNotNull(viewId, VIEW_ID);
            return this;
        }

        public GetVideoViewDetailsRequest build() {
            return new GetVideoViewDetailsRequest(
                viewId);
        }

    }
}
