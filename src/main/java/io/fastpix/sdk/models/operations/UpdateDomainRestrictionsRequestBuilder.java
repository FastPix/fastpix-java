package io.fastpix.sdk.models.operations;

import static io.fastpix.sdk.operations.Operations.RequestOperation;

import jakarta.annotation.Nonnull;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.operations.UpdateDomainRestrictions;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class UpdateDomainRestrictionsRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final UpdateDomainRestrictionsRequest.Builder pojoBuilder;
    private UpdateDomainRestrictionsRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public UpdateDomainRestrictionsRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = UpdateDomainRestrictionsRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public UpdateDomainRestrictionsRequestBuilder mediaId(@Nonnull String mediaId) {
        this.pojoBuilder.mediaId(mediaId);
        this._setterCalled = true;
        return this;
    }

    public UpdateDomainRestrictionsRequestBuilder playbackId(@Nonnull String playbackId) {
        this.pojoBuilder.playbackId(playbackId);
        this._setterCalled = true;
        return this;
    }

    public UpdateDomainRestrictionsRequestBuilder body(@Nonnull UpdateDomainRestrictionsRequestBody body) {
        this.pojoBuilder.body(body);
        this._setterCalled = true;
        return this;
    }

    public UpdateDomainRestrictionsRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private UpdateDomainRestrictionsRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public UpdateDomainRestrictionsRequestBuilder header(String name, String value) {
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
    public UpdateDomainRestrictionsResponse call() {
        Options options = optionsBuilder.build();
        RequestOperation<UpdateDomainRestrictionsRequest, UpdateDomainRestrictionsResponse> operation
              = new UpdateDomainRestrictions.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(this._buildRequest()));
    }
}
