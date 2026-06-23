package io.fastpix.sdk.models.operations;

import static io.fastpix.sdk.operations.Operations.RequestOperation;

import jakarta.annotation.Nonnull;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.operations.AddMediaTrack;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

// Leading-underscore field/method names (_headers, _setterCalled, _buildRequest) are an
// intentional generated convention that avoids clashing with the user-facing builder
// setters (header(), body(), ...); renaming would be inconsistent across all
// *RequestBuilder classes and could reintroduce those clashes.
@SuppressWarnings({"java:S116", "java:S100"})
public class AddMediaTrackRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers _headers = new Headers();
    private final AddMediaTrackRequest.Builder pojoBuilder;
    private AddMediaTrackRequest request;
    private final Options.Builder optionsBuilder;
    private boolean _setterCalled;

    public AddMediaTrackRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = AddMediaTrackRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public AddMediaTrackRequestBuilder mediaId(@Nonnull String mediaId) {
        this.pojoBuilder.mediaId(mediaId);
        this._setterCalled = true;
        return this;
    }

    public AddMediaTrackRequestBuilder body(@Nonnull AddMediaTrackRequestBody body) {
        this.pojoBuilder.body(body);
        this._setterCalled = true;
        return this;
    }

    public AddMediaTrackRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private AddMediaTrackRequest _buildRequest() {
        if (this._setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public AddMediaTrackRequestBuilder header(String name, String value) {
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
    public AddMediaTrackResponse call() {
        Options options = optionsBuilder.build();
        RequestOperation<AddMediaTrackRequest, AddMediaTrackResponse> operation
              = new AddMediaTrack.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(this._buildRequest()));
    }
}
