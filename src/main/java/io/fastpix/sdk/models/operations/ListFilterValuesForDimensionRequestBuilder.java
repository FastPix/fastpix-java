package io.fastpix.sdk.models.operations;

import static io.fastpix.sdk.operations.Operations.RequestOperation;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.operations.ListFilterValuesForDimension;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class ListFilterValuesForDimensionRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final ListFilterValuesForDimensionRequest.Builder pojoBuilder;
    private ListFilterValuesForDimensionRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public ListFilterValuesForDimensionRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = ListFilterValuesForDimensionRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public ListFilterValuesForDimensionRequestBuilder dimensionsId(@Nonnull DimensionsId dimensionsId) {
        this.pojoBuilder.dimensionsId(dimensionsId);
        this._setterCalled = true;
        return this;
    }

    public ListFilterValuesForDimensionRequestBuilder timespan(@Nullable ListFilterValuesForDimensionTimespan timespan) {
        this.pojoBuilder.timespan(timespan);
        this._setterCalled = true;
        return this;
    }

    public ListFilterValuesForDimensionRequestBuilder filterby(@Nullable String filterby) {
        this.pojoBuilder.filterby(filterby);
        this._setterCalled = true;
        return this;
    }

    public ListFilterValuesForDimensionRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private ListFilterValuesForDimensionRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public ListFilterValuesForDimensionRequestBuilder header(String name, String value) {
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
    public ListFilterValuesForDimensionResponse call() {
        Options options = optionsBuilder.build();
        RequestOperation<ListFilterValuesForDimensionRequest, ListFilterValuesForDimensionResponse> operation
              = new ListFilterValuesForDimension.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(this._buildRequest()));
    }
}
