package io.fastpix.sdk.models.operations.async;

import static io.fastpix.sdk.operations.Operations.AsyncRequestOperation;

import jakarta.annotation.Nullable;
import java.util.concurrent.CompletableFuture;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.models.operations.ListByTopContentRequest;
import io.fastpix.sdk.models.operations.ListByTopContentTimespan;
import io.fastpix.sdk.operations.ListByTopContent;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class ListByTopContentRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final ListByTopContentRequest.Builder pojoBuilder;
    private ListByTopContentRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public ListByTopContentRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = ListByTopContentRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public ListByTopContentRequestBuilder timespan(@Nullable ListByTopContentTimespan timespan) {
        this.pojoBuilder.timespan(timespan);
        this._setterCalled = true;
        return this;
    }

    public ListByTopContentRequestBuilder filterby(@Nullable String filterby) {
        this.pojoBuilder.filterby(filterby);
        this._setterCalled = true;
        return this;
    }

    public ListByTopContentRequestBuilder limit(@Nullable Long limit) {
        this.pojoBuilder.limit(limit);
        this._setterCalled = true;
        return this;
    }

    public ListByTopContentRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private ListByTopContentRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public ListByTopContentRequestBuilder header(String name, String value) {
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
    public CompletableFuture<ListByTopContentResponse> call() {
        Options options = optionsBuilder.build();
        AsyncRequestOperation<ListByTopContentRequest, ListByTopContentResponse> operation
              = new ListByTopContent.Async(
                                    sdkConfiguration, options, sdkConfiguration.retryScheduler(),
                                    _headers);
        return operation.doRequest(this._buildRequest())
            .thenCompose(operation::handleResponse);
    }
}
