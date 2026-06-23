package io.fastpix.sdk.models.operations.async;

import static io.fastpix.sdk.operations.Operations.AsyncRequestOperation;

import jakarta.annotation.Nullable;
import java.util.concurrent.CompletableFuture;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.models.components.SortOrder;
import io.fastpix.sdk.models.operations.ListMediaRequest;
import io.fastpix.sdk.operations.ListMedia;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class ListMediaRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final ListMediaRequest.Builder pojoBuilder;
    private ListMediaRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public ListMediaRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = ListMediaRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public ListMediaRequestBuilder limit(@Nullable Long limit) {
        this.pojoBuilder.limit(limit);
        this._setterCalled = true;
        return this;
    }

    public ListMediaRequestBuilder offset(@Nullable Long offset) {
        this.pojoBuilder.offset(offset);
        this._setterCalled = true;
        return this;
    }

    public ListMediaRequestBuilder orderBy(@Nullable SortOrder orderBy) {
        this.pojoBuilder.orderBy(orderBy);
        this._setterCalled = true;
        return this;
    }

    public ListMediaRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private ListMediaRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public ListMediaRequestBuilder header(String name, String value) {
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
    public CompletableFuture<ListMediaResponse> call() {
        Options options = optionsBuilder.build();
        AsyncRequestOperation<ListMediaRequest, ListMediaResponse> operation
              = new ListMedia.Async(
                                    sdkConfiguration, options, sdkConfiguration.retryScheduler(),
                                    _headers);
        return operation.doRequest(this._buildRequest())
            .thenCompose(operation::handleResponse);
    }
}
