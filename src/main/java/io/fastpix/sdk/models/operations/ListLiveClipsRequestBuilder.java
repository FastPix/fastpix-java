package io.fastpix.sdk.models.operations;

import static io.fastpix.sdk.operations.Operations.RequestOperation;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.models.components.SortOrder;
import io.fastpix.sdk.operations.ListLiveClips;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class ListLiveClipsRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final ListLiveClipsRequest.Builder pojoBuilder;
    private ListLiveClipsRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public ListLiveClipsRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = ListLiveClipsRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public ListLiveClipsRequestBuilder livestreamId(@Nonnull String livestreamId) {
        this.pojoBuilder.livestreamId(livestreamId);
        this._setterCalled = true;
        return this;
    }

    public ListLiveClipsRequestBuilder limit(@Nullable Long limit) {
        this.pojoBuilder.limit(limit);
        this._setterCalled = true;
        return this;
    }

    public ListLiveClipsRequestBuilder offset(@Nullable Long offset) {
        this.pojoBuilder.offset(offset);
        this._setterCalled = true;
        return this;
    }

    public ListLiveClipsRequestBuilder orderBy(@Nullable SortOrder orderBy) {
        this.pojoBuilder.orderBy(orderBy);
        this._setterCalled = true;
        return this;
    }

    public ListLiveClipsRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private ListLiveClipsRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public ListLiveClipsRequestBuilder header(String name, String value) {
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(value, "value");
        this._headers.add(name, value);
        return this;
    }

    /**
    * Executes the request and returns the response.
    *
    * @return The response from the server.
    */
    public ListLiveClipsResponse call() {
        Options options = optionsBuilder.build();
        RequestOperation<ListLiveClipsRequest, ListLiveClipsResponse> operation
              = new ListLiveClips.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(this._buildRequest()));
    }
}
