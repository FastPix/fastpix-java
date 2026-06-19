package io.fastpix.sdk.models.operations.async;

import static io.fastpix.sdk.operations.Operations.AsyncRequestOperation;

import jakarta.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.models.operations.UpdateMediaModerationRequest;
import io.fastpix.sdk.models.operations.UpdateMediaModerationRequestBody;
import io.fastpix.sdk.operations.UpdateMediaModeration;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class UpdateMediaModerationRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final UpdateMediaModerationRequest.Builder pojoBuilder;
    private UpdateMediaModerationRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public UpdateMediaModerationRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = UpdateMediaModerationRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public UpdateMediaModerationRequestBuilder mediaId(@Nonnull String mediaId) {
        this.pojoBuilder.mediaId(mediaId);
        this._setterCalled = true;
        return this;
    }

    public UpdateMediaModerationRequestBuilder body(@Nonnull UpdateMediaModerationRequestBody body) {
        this.pojoBuilder.body(body);
        this._setterCalled = true;
        return this;
    }

    public UpdateMediaModerationRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private UpdateMediaModerationRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public UpdateMediaModerationRequestBuilder header(String name, String value) {
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
    public CompletableFuture<UpdateMediaModerationResponse> call() {
        Options options = optionsBuilder.build();
        AsyncRequestOperation<UpdateMediaModerationRequest, UpdateMediaModerationResponse> operation
              = new UpdateMediaModeration.Async(
                                    sdkConfiguration, options, sdkConfiguration.retryScheduler(),
                                    _headers);
        return operation.doRequest(this._buildRequest())
            .thenCompose(operation::handleResponse);
    }
}
