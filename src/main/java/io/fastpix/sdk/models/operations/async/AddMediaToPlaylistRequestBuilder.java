package io.fastpix.sdk.models.operations.async;

import static io.fastpix.sdk.operations.Operations.AsyncRequestOperation;

import jakarta.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;
import io.fastpix.sdk.SDKConfiguration;
import io.fastpix.sdk.models.components.MediaIdsRequest;
import io.fastpix.sdk.models.operations.AddMediaToPlaylistRequest;
import io.fastpix.sdk.operations.AddMediaToPlaylist;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;
import io.fastpix.sdk.utils.RetryConfig;
import io.fastpix.sdk.utils.Utils;

public class AddMediaToPlaylistRequestBuilder {
    private final SDKConfiguration sdkConfiguration;
    private final Headers headers = new Headers();
    private final AddMediaToPlaylistRequest.Builder pojoBuilder;
    private AddMediaToPlaylistRequest request;
    private final Options.Builder optionsBuilder;
    private boolean setterCalled;

    public AddMediaToPlaylistRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.pojoBuilder = AddMediaToPlaylistRequest.builder();
        this.optionsBuilder = Options.builder();
    }

    public AddMediaToPlaylistRequestBuilder playlistId(@Nonnull String playlistId) {
        this.pojoBuilder.playlistId(playlistId);
        this.setterCalled = true;
        return this;
    }

    public AddMediaToPlaylistRequestBuilder body(@Nonnull MediaIdsRequest body) {
        this.pojoBuilder.body(body);
        this.setterCalled = true;
        return this;
    }

    public AddMediaToPlaylistRequestBuilder retryConfig(RetryConfig retryConfig) {
        this.optionsBuilder.retryConfig(retryConfig);
        return this;
    }

    private AddMediaToPlaylistRequest buildRequest() {
        if (this.setterCalled) {
            this.request = this.pojoBuilder.build();
        }
        return this.request;
    }
    
    public AddMediaToPlaylistRequestBuilder header(String name, String value) {
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(value, "value");
        this.headers.add(name, value);
        return this;
    }

    /**
    * Executes the request and returns the response.
    *
    * @return The response from the server.
    */
    public CompletableFuture<AddMediaToPlaylistResponse> call() {
        Options options = optionsBuilder.build();
        AsyncRequestOperation<AddMediaToPlaylistRequest, AddMediaToPlaylistResponse> operation
              = new AddMediaToPlaylist.Async(
                                    sdkConfiguration, options, sdkConfiguration.retryScheduler(),
                                    headers);
        return operation.doRequest(this.buildRequest())
            .thenCompose(operation::handleResponse);
    }
}
