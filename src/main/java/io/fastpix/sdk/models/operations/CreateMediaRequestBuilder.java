package io.fastpix.sdk.models.operations;

import static io.fastpix.sdk.operations.Operations.RequestOperation;

import jakarta.annotation.Nonnull;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.models.components.CreateMediaRequest;
import io.fastpix.sdk.operations.CreateMedia;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class CreateMediaRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private CreateMediaRequest request;
    private final Options.Builder optionsBuilder;

    public CreateMediaRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.optionsBuilder = Options.builder();
    }

    public CreateMediaRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    public CreateMediaRequestBuilder request(@Nonnull CreateMediaRequest request) {
        this.request = Utils.checkNotNull(request, "request");
        return this;
    }

    private CreateMediaRequest _buildRequest() {
        return this.request;
    }
    
    public CreateMediaRequestBuilder header(String name, String value) {
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
    public CreateMediaResponse call() {
        Options options = optionsBuilder.build();
        RequestOperation<CreateMediaRequest, CreateMediaResponse> operation
              = new CreateMedia.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(this._buildRequest()));
    }
}
