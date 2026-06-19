package io.fastpix.sdk.models.operations.async;

import static io.fastpix.sdk.operations.Operations.AsyncRequestOperation;

import jakarta.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.models.operations.CompleteLiveStreamRequest;
import io.fastpix.sdk.operations.CompleteLiveStream;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class CompleteLiveStreamRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final CompleteLiveStreamRequest.Builder pojoBuilder;
    private CompleteLiveStreamRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public CompleteLiveStreamRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = CompleteLiveStreamRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public CompleteLiveStreamRequestBuilder streamId(@Nonnull String streamId) {
        this.pojoBuilder.streamId(streamId);
        this._setterCalled = true;
        return this;
    }

    public CompleteLiveStreamRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private CompleteLiveStreamRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public CompleteLiveStreamRequestBuilder header(String name, String value) {
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
    public CompletableFuture<CompleteLiveStreamResponse> call() {
        Options options = optionsBuilder.build();
        AsyncRequestOperation<CompleteLiveStreamRequest, CompleteLiveStreamResponse> operation
              = new CompleteLiveStream.Async(
                                    sdkConfiguration, options, sdkConfiguration.retryScheduler(),
                                    _headers);
        return operation.doRequest(this._buildRequest())
            .thenCompose(operation::handleResponse);
    }
}
