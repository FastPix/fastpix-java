/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import io.fastpix.sdk.utils.LazySingletonValue;
import io.fastpix.sdk.utils.SpeakeasyMetadata;
import io.fastpix.sdk.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

public class GetAllStreamsRequest {

    /**
     * Limit specifies the maximum number of items to display per page.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=limit")
    private Optional<String> limit;

    /**
     * Offset determines the starting point for data retrieval within a paginated list.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=offset")
    private Optional<String> offset;

    /**
     * The list of value can be order in two ways DESC (Descending) or ASC (Ascending). In case not specified, by default it will be DESC.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=orderBy")
    private Optional<? extends GetAllStreamsOrderBy> orderBy;

    @JsonCreator
    public GetAllStreamsRequest(
            Optional<String> limit,
            Optional<String> offset,
            Optional<? extends GetAllStreamsOrderBy> orderBy) {
        Utils.checkNotNull(limit, "limit");
        Utils.checkNotNull(offset, "offset");
        Utils.checkNotNull(orderBy, "orderBy");
        this.limit = limit;
        this.offset = offset;
        this.orderBy = orderBy;
    }
    
    public GetAllStreamsRequest() {
        this(Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * Limit specifies the maximum number of items to display per page.
     */
    @JsonIgnore
    public Optional<String> limit() {
        return limit;
    }

    /**
     * Offset determines the starting point for data retrieval within a paginated list.
     */
    @JsonIgnore
    public Optional<String> offset() {
        return offset;
    }

    /**
     * The list of value can be order in two ways DESC (Descending) or ASC (Ascending). In case not specified, by default it will be DESC.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetAllStreamsOrderBy> orderBy() {
        return (Optional<GetAllStreamsOrderBy>) orderBy;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Limit specifies the maximum number of items to display per page.
     */
    public GetAllStreamsRequest withLimit(String limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = Optional.ofNullable(limit);
        return this;
    }

    /**
     * Limit specifies the maximum number of items to display per page.
     */
    public GetAllStreamsRequest withLimit(Optional<String> limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = limit;
        return this;
    }

    /**
     * Offset determines the starting point for data retrieval within a paginated list.
     */
    public GetAllStreamsRequest withOffset(String offset) {
        Utils.checkNotNull(offset, "offset");
        this.offset = Optional.ofNullable(offset);
        return this;
    }

    /**
     * Offset determines the starting point for data retrieval within a paginated list.
     */
    public GetAllStreamsRequest withOffset(Optional<String> offset) {
        Utils.checkNotNull(offset, "offset");
        this.offset = offset;
        return this;
    }

    /**
     * The list of value can be order in two ways DESC (Descending) or ASC (Ascending). In case not specified, by default it will be DESC.
     */
    public GetAllStreamsRequest withOrderBy(GetAllStreamsOrderBy orderBy) {
        Utils.checkNotNull(orderBy, "orderBy");
        this.orderBy = Optional.ofNullable(orderBy);
        return this;
    }

    /**
     * The list of value can be order in two ways DESC (Descending) or ASC (Ascending). In case not specified, by default it will be DESC.
     */
    public GetAllStreamsRequest withOrderBy(Optional<? extends GetAllStreamsOrderBy> orderBy) {
        Utils.checkNotNull(orderBy, "orderBy");
        this.orderBy = orderBy;
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
        GetAllStreamsRequest other = (GetAllStreamsRequest) o;
        return 
            Objects.deepEquals(this.limit, other.limit) &&
            Objects.deepEquals(this.offset, other.offset) &&
            Objects.deepEquals(this.orderBy, other.orderBy);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            limit,
            offset,
            orderBy);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetAllStreamsRequest.class,
                "limit", limit,
                "offset", offset,
                "orderBy", orderBy);
    }
    
    public final static class Builder {
 
        private Optional<String> limit;
 
        private Optional<String> offset;
 
        private Optional<? extends GetAllStreamsOrderBy> orderBy;
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Limit specifies the maximum number of items to display per page.
         */
        public Builder limit(String limit) {
            Utils.checkNotNull(limit, "limit");
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Limit specifies the maximum number of items to display per page.
         */
        public Builder limit(Optional<String> limit) {
            Utils.checkNotNull(limit, "limit");
            this.limit = limit;
            return this;
        }

        /**
         * Offset determines the starting point for data retrieval within a paginated list.
         */
        public Builder offset(String offset) {
            Utils.checkNotNull(offset, "offset");
            this.offset = Optional.ofNullable(offset);
            return this;
        }

        /**
         * Offset determines the starting point for data retrieval within a paginated list.
         */
        public Builder offset(Optional<String> offset) {
            Utils.checkNotNull(offset, "offset");
            this.offset = offset;
            return this;
        }

        /**
         * The list of value can be order in two ways DESC (Descending) or ASC (Ascending). In case not specified, by default it will be DESC.
         */
        public Builder orderBy(GetAllStreamsOrderBy orderBy) {
            Utils.checkNotNull(orderBy, "orderBy");
            this.orderBy = Optional.ofNullable(orderBy);
            return this;
        }

        /**
         * The list of value can be order in two ways DESC (Descending) or ASC (Ascending). In case not specified, by default it will be DESC.
         */
        public Builder orderBy(Optional<? extends GetAllStreamsOrderBy> orderBy) {
            Utils.checkNotNull(orderBy, "orderBy");
            this.orderBy = orderBy;
            return this;
        }
        
        public GetAllStreamsRequest build() {
            if (limit == null) {
                limit = _SINGLETON_VALUE_Limit.value();
            }
            if (offset == null) {
                offset = _SINGLETON_VALUE_Offset.value();
            }
            if (orderBy == null) {
                orderBy = _SINGLETON_VALUE_OrderBy.value();
            }
            return new GetAllStreamsRequest(
                limit,
                offset,
                orderBy);
        }

        private static final LazySingletonValue<Optional<String>> _SINGLETON_VALUE_Limit =
                new LazySingletonValue<>(
                        "limit",
                        "\"10\"",
                        new TypeReference<Optional<String>>() {});

        private static final LazySingletonValue<Optional<String>> _SINGLETON_VALUE_Offset =
                new LazySingletonValue<>(
                        "offset",
                        "\"1\"",
                        new TypeReference<Optional<String>>() {});

        private static final LazySingletonValue<Optional<? extends GetAllStreamsOrderBy>> _SINGLETON_VALUE_OrderBy =
                new LazySingletonValue<>(
                        "orderBy",
                        "\"desc\"",
                        new TypeReference<Optional<? extends GetAllStreamsOrderBy>>() {});
    }
}
