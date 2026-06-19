package io.fastpix.sdk.models.operations;

import static io.fastpix.sdk.operations.Operations.RequestOperation;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.models.components.SortOrder;
import io.fastpix.sdk.operations.GetMediaClips;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class GetMediaClipsRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final GetMediaClipsRequest.Builder pojoBuilder;
    private GetMediaClipsRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public GetMediaClipsRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = GetMediaClipsRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public GetMediaClipsRequestBuilder mediaId(@Nonnull String mediaId) {
        this.pojoBuilder.mediaId(mediaId);
        this._setterCalled = true;
        return this;
    }

    public GetMediaClipsRequestBuilder offset(@Nullable Long offset) {
        this.pojoBuilder.offset(offset);
        this._setterCalled = true;
        return this;
    }

    public GetMediaClipsRequestBuilder limit(@Nullable Long limit) {
        this.pojoBuilder.limit(limit);
        this._setterCalled = true;
        return this;
    }

    public GetMediaClipsRequestBuilder orderBy(@Nullable SortOrder orderBy) {
        this.pojoBuilder.orderBy(orderBy);
        this._setterCalled = true;
        return this;
    }

    public GetMediaClipsRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private GetMediaClipsRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public GetMediaClipsRequestBuilder header(String name, String value) {
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
    public GetMediaClipsResponse call() {
        Options options = optionsBuilder.build();
        RequestOperation<GetMediaClipsRequest, GetMediaClipsResponse> operation
              = new GetMediaClips.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(this._buildRequest()));
    }
}
