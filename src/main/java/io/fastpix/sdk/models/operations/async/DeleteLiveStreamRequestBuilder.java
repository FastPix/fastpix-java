package io.fastpix.sdk.models.operations.async;

import static io.fastpix.sdk.operations.Operations.AsyncRequestOperation;

import jakarta.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.models.operations.DeleteLiveStreamRequest;
import io.fastpix.sdk.operations.DeleteLiveStream;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class DeleteLiveStreamRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final DeleteLiveStreamRequest.Builder pojoBuilder;
    private DeleteLiveStreamRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public DeleteLiveStreamRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = DeleteLiveStreamRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public DeleteLiveStreamRequestBuilder streamId(@Nonnull String streamId) {
        this.pojoBuilder.streamId(streamId);
        this._setterCalled = true;
        return this;
    }

    public DeleteLiveStreamRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private DeleteLiveStreamRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public DeleteLiveStreamRequestBuilder header(String name, String value) {
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
    public CompletableFuture<DeleteLiveStreamResponse> call() {
        Options options = optionsBuilder.build();
        AsyncRequestOperation<DeleteLiveStreamRequest, DeleteLiveStreamResponse> operation
              = new DeleteLiveStream.Async(
                                    sdkConfiguration, options, sdkConfiguration.retryScheduler(),
                                    _headers);
        return operation.doRequest(this._buildRequest())
            .thenCompose(operation::handleResponse);
    }
}
