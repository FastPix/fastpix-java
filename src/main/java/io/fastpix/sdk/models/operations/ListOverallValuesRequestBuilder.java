package io.fastpix.sdk.models.operations;

import static io.fastpix.sdk.operations.Operations.RequestOperation;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.operations.ListOverallValues;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class ListOverallValuesRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final ListOverallValuesRequest.Builder pojoBuilder;
    private ListOverallValuesRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public ListOverallValuesRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = ListOverallValuesRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public ListOverallValuesRequestBuilder metricId(@Nonnull ListOverallValuesMetricId metricId) {
        this.pojoBuilder.metricId(metricId);
        this._setterCalled = true;
        return this;
    }

    public ListOverallValuesRequestBuilder measurement(@Nullable String measurement) {
        this.pojoBuilder.measurement(measurement);
        this._setterCalled = true;
        return this;
    }

    public ListOverallValuesRequestBuilder timespan(@Nullable ListOverallValuesTimespan timespan) {
        this.pojoBuilder.timespan(timespan);
        this._setterCalled = true;
        return this;
    }

    public ListOverallValuesRequestBuilder filterby(@Nullable String filterby) {
        this.pojoBuilder.filterby(filterby);
        this._setterCalled = true;
        return this;
    }

    public ListOverallValuesRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private ListOverallValuesRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public ListOverallValuesRequestBuilder header(String name, String value) {
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
    public ListOverallValuesResponse call() {
        Options options = optionsBuilder.build();
        RequestOperation<ListOverallValuesRequest, ListOverallValuesResponse> operation
              = new ListOverallValues.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(this._buildRequest()));
    }
}
