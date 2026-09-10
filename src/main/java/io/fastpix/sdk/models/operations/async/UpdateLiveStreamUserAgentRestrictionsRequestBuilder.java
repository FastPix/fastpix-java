package io.fastpix.sdk.models.operations.async;

import static io.fastpix.sdk.operations.Operations.AsyncRequestOperation;

import jakarta.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsRequest;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsRequestBody;
import io.fastpix.sdk.operations.UpdateLiveStreamUserAgentRestrictions;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class UpdateLiveStreamUserAgentRestrictionsRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final UpdateLiveStreamUserAgentRestrictionsRequest.Builder pojoBuilder;
    private UpdateLiveStreamUserAgentRestrictionsRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public UpdateLiveStreamUserAgentRestrictionsRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = UpdateLiveStreamUserAgentRestrictionsRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public UpdateLiveStreamUserAgentRestrictionsRequestBuilder streamId(@Nonnull String streamId) {
        this.pojoBuilder.streamId(streamId);
        this._setterCalled = true;
        return this;
    }

    public UpdateLiveStreamUserAgentRestrictionsRequestBuilder playbackId(@Nonnull String playbackId) {
        this.pojoBuilder.playbackId(playbackId);
        this._setterCalled = true;
        return this;
    }

    public UpdateLiveStreamUserAgentRestrictionsRequestBuilder body(@Nonnull UpdateLiveStreamUserAgentRestrictionsRequestBody body) {
        this.pojoBuilder.body(body);
        this._setterCalled = true;
        return this;
    }

    public UpdateLiveStreamUserAgentRestrictionsRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private UpdateLiveStreamUserAgentRestrictionsRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public UpdateLiveStreamUserAgentRestrictionsRequestBuilder header(String name, String value) {
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
    public CompletableFuture<UpdateLiveStreamUserAgentRestrictionsResponse> call() {
        Options options = optionsBuilder.build();
        AsyncRequestOperation<UpdateLiveStreamUserAgentRestrictionsRequest, UpdateLiveStreamUserAgentRestrictionsResponse> operation
              = new UpdateLiveStreamUserAgentRestrictions.Async(
                                    sdkConfiguration, options, sdkConfiguration.retryScheduler(),
                                    _headers);
        return operation.doRequest(this._buildRequest())
            .thenCompose(operation::handleResponse);
    }
}
