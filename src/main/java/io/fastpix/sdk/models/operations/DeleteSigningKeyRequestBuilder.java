package io.fastpix.sdk.models.operations;

import static io.fastpix.sdk.operations.Operations.RequestOperation;

import jakarta.annotation.Nonnull;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.operations.DeleteSigningKey;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class DeleteSigningKeyRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final DeleteSigningKeyRequest.Builder pojoBuilder;
    private DeleteSigningKeyRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public DeleteSigningKeyRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = DeleteSigningKeyRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public DeleteSigningKeyRequestBuilder signingKeyId(@Nonnull String signingKeyId) {
        this.pojoBuilder.signingKeyId(signingKeyId);
        this._setterCalled = true;
        return this;
    }

    public DeleteSigningKeyRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private DeleteSigningKeyRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public DeleteSigningKeyRequestBuilder header(String name, String value) {
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
    public DeleteSigningKeyResponse call() {
        Options options = optionsBuilder.build();
        RequestOperation<DeleteSigningKeyRequest, DeleteSigningKeyResponse> operation
              = new DeleteSigningKey.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(this._buildRequest()));
    }
}
