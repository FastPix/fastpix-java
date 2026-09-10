package io.fastpix.sdk;

import static io.fastpix.sdk.operations.Operations.RequestOperation;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import io.fastpix.sdk.models.components.PlaybackIdRequest;
import io.fastpix.sdk.models.operations.CreatePlaybackIdOfStreamRequest;
import io.fastpix.sdk.models.operations.CreatePlaybackIdOfStreamRequestBuilder;
import io.fastpix.sdk.models.operations.CreatePlaybackIdOfStreamResponse;
import io.fastpix.sdk.models.operations.DeletePlaybackIdOfStreamRequest;
import io.fastpix.sdk.models.operations.DeletePlaybackIdOfStreamRequestBuilder;
import io.fastpix.sdk.models.operations.DeletePlaybackIdOfStreamResponse;
import io.fastpix.sdk.operations.CreatePlaybackIdOfStream;
import io.fastpix.sdk.operations.DeletePlaybackIdOfStream;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsRequest;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsRequestBuilder;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsResponse;
import io.fastpix.sdk.operations.UpdateLiveStreamDomainRestrictions;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsRequest;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsRequestBuilder;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsResponse;
import io.fastpix.sdk.operations.UpdateLiveStreamUserAgentRestrictions;
import io.fastpix.sdk.utils.Headers;
import io.fastpix.sdk.utils.Options;


public class LivePlayback {
    private static final Headers _headers = Headers.EMPTY;
    private final SDKConfiguration sdkConfiguration;
    private final AsyncLivePlayback asyncSDK;

    LivePlayback(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
        this.asyncSDK = new AsyncLivePlayback(this, sdkConfiguration);
    }

    /**
     * Switches to the async SDK.
     * 
     * @return The async SDK
     */
    public AsyncLivePlayback async() {
        return asyncSDK;
    }

    /**
     * Create a playbackId
     * 
     * <p>Generates a new playback ID for the live stream, allowing viewers to access the stream through this
     * ID. The playback ID can be shared with viewers for direct access to the live broadcast.
     * 
     * <p>By calling this endpoint with the `streamId`, FastPix returns a unique `playbackId`, which can be
     * used to stream the live content.
     * 
     * <p>#### Example
     * 
     * <p>A media platform needs to distribute a unique playback ID to users for an exclusive live concert.
     * The platform can also embed the stream on various partner websites.
     * 
     * @return The call builder
     */
    public CreatePlaybackIdOfStreamRequestBuilder createPlaybackId() {
        return new CreatePlaybackIdOfStreamRequestBuilder(sdkConfiguration);
    }

    /**
     * Create a playbackId
     * 
     * <p>Generates a new playback ID for the live stream, allowing viewers to access the stream through this
     * ID. The playback ID can be shared with viewers for direct access to the live broadcast.
     * 
     * <p>By calling this endpoint with the `streamId`, FastPix returns a unique `playbackId`, which can be
     * used to stream the live content.
     * 
     * <p>#### Example
     * 
     * <p>A media platform needs to distribute a unique playback ID to users for an exclusive live concert.
     * The platform can also embed the stream on various partner websites.
     * 
     * @param streamId After creating a new live stream, FastPix assigns a unique identifier to the stream.
     * @param body 
     * @return The response from the API call
     * @throws RuntimeException subclass if the API call fails
     */
    public CreatePlaybackIdOfStreamResponse createPlaybackId(@Nonnull String streamId, @Nonnull PlaybackIdRequest body) {
        return createPlaybackId(streamId, body, null);
    }

    /**
     * Create a playbackId
     * 
     * <p>Generates a new playback ID for the live stream, allowing viewers to access the stream through this
     * ID. The playback ID can be shared with viewers for direct access to the live broadcast.
     * 
     * <p>By calling this endpoint with the `streamId`, FastPix returns a unique `playbackId`, which can be
     * used to stream the live content.
     * 
     * <p>#### Example
     * 
     * <p>A media platform needs to distribute a unique playback ID to users for an exclusive live concert.
     * The platform can also embed the stream on various partner websites.
     * 
     * @param streamId After creating a new live stream, FastPix assigns a unique identifier to the stream.
     * @param body 
     * @param options additional options
     * @return The response from the API call
     * @throws RuntimeException subclass if the API call fails
     */
    public CreatePlaybackIdOfStreamResponse createPlaybackId(
            @Nonnull String streamId, @Nonnull PlaybackIdRequest body,
            @Nullable Options options) {
        CreatePlaybackIdOfStreamRequest request = new CreatePlaybackIdOfStreamRequest(streamId, body);
        RequestOperation<CreatePlaybackIdOfStreamRequest, CreatePlaybackIdOfStreamResponse> operation
              = new CreatePlaybackIdOfStream.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Delete a playbackId
     * 
     * <p>Deletes a previously created playback ID for a live stream.This prevents new viewers from accessing
     * the stream using the playback ID, while current viewers can continue watching for a short period
     * before the connection ends. FastPix deletes the ID and ensures the new playback request fails.
     * 
     * <p>#### Example
     * A streaming service wants to prevent new users from joining a live stream that is nearing its end.
     * The host can delete the playback ID to ensure no one can join the stream or replay it once it ends.
     * 
     * @return The call builder
     */
    public DeletePlaybackIdOfStreamRequestBuilder deletePlaybackId() {
        return new DeletePlaybackIdOfStreamRequestBuilder(sdkConfiguration);
    }

    /**
     * Delete a playbackId
     * 
     * <p>Deletes a previously created playback ID for a live stream.This prevents new viewers from accessing
     * the stream using the playback ID, while current viewers can continue watching for a short period
     * before the connection ends. FastPix deletes the ID and ensures the new playback request fails.
     * 
     * <p>#### Example
     * A streaming service wants to prevent new users from joining a live stream that is nearing its end.
     * The host can delete the playback ID to ensure no one can join the stream or replay it once it ends.
     * 
     * @param streamId Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
     * @param playbackId Unique identifier for the playbackId
     * @return The response from the API call
     * @throws RuntimeException subclass if the API call fails
     */
    public DeletePlaybackIdOfStreamResponse deletePlaybackId(@Nonnull String streamId, @Nonnull String playbackId) {
        return deletePlaybackId(streamId, playbackId, null);
    }

    /**
     * Delete a playbackId
     * 
     * <p>Deletes a previously created playback ID for a live stream.This prevents new viewers from accessing
     * the stream using the playback ID, while current viewers can continue watching for a short period
     * before the connection ends. FastPix deletes the ID and ensures the new playback request fails.
     * 
     * <p>#### Example
     * A streaming service wants to prevent new users from joining a live stream that is nearing its end.
     * The host can delete the playback ID to ensure no one can join the stream or replay it once it ends.
     * 
     * @param streamId Upon creating a new live stream, FastPix assigns a unique identifier to the stream.
     * @param playbackId Unique identifier for the playbackId
     * @param options additional options
     * @return The response from the API call
     * @throws RuntimeException subclass if the API call fails
     */
    public DeletePlaybackIdOfStreamResponse deletePlaybackId(
            @Nonnull String streamId, @Nonnull String playbackId,
            @Nullable Options options) {
        DeletePlaybackIdOfStreamRequest request = new DeletePlaybackIdOfStreamRequest(streamId, playbackId);
        RequestOperation<DeletePlaybackIdOfStreamRequest, DeletePlaybackIdOfStreamResponse> operation
              = new DeletePlaybackIdOfStream.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(request));
    }


    /**
     * Update domain restrictions for a playback ID
     * 
     * <p>This endpoint updates domain-level restrictions for a specific playback ID associated with a live
     * stream.
     * It allows you to restrict playback to specific domains or block known unauthorized domains.
     * 
     * <p>**How it works:**
     * 1. Make a `PATCH` request to this endpoint with your desired domain access configuration.
     * 2. Set a default policy (`allow` or `deny`) and specify domain names in the `allow` or `deny` lists.
     * 3. This is commonly used to restrict video playback to your website or approved client domains.
     * 
     * <p>**Example:**
     * A streaming service can allow playback only from `example.com` and deny all others by setting:
     * `"defaultPolicy": "deny"` and `"allow": ["example.com"]`.
     * 
     * @return The call builder
     */
    public UpdateLiveStreamDomainRestrictionsRequestBuilder updateDomainRestrictions() {
        return new UpdateLiveStreamDomainRestrictionsRequestBuilder(sdkConfiguration);
    }

    /**
     * Update domain restrictions for a playback ID
     * 
     * <p>This endpoint updates domain-level restrictions for a specific playback ID associated with a live
     * stream.
     * It allows you to restrict playback to specific domains or block known unauthorized domains.
     * 
     * <p>**How it works:**
     * 1. Make a `PATCH` request to this endpoint with your desired domain access configuration.
     * 2. Set a default policy (`allow` or `deny`) and specify domain names in the `allow` or `deny` lists.
     * 3. This is commonly used to restrict video playback to your website or approved client domains.
     * 
     * <p>**Example:**
     * A streaming service can allow playback only from `example.com` and deny all others by setting:
     * `"defaultPolicy": "deny"` and `"allow": ["example.com"]`.
     * 
     * @param streamId 
     * @param playbackId 
     * @param body 
     * @return The response from the API call
     * @throws RuntimeException subclass if the API call fails
     */
    public UpdateLiveStreamDomainRestrictionsResponse updateDomainRestrictions(
            @Nonnull String streamId, @Nonnull String playbackId,
            @Nonnull UpdateLiveStreamDomainRestrictionsRequestBody body) {
        return updateDomainRestrictions(streamId, playbackId, body,
            null);
    }

    /**
     * Update domain restrictions for a playback ID
     * 
     * <p>This endpoint updates domain-level restrictions for a specific playback ID associated with a live
     * stream.
     * It allows you to restrict playback to specific domains or block known unauthorized domains.
     * 
     * <p>**How it works:**
     * 1. Make a `PATCH` request to this endpoint with your desired domain access configuration.
     * 2. Set a default policy (`allow` or `deny`) and specify domain names in the `allow` or `deny` lists.
     * 3. This is commonly used to restrict video playback to your website or approved client domains.
     * 
     * <p>**Example:**
     * A streaming service can allow playback only from `example.com` and deny all others by setting:
     * `"defaultPolicy": "deny"` and `"allow": ["example.com"]`.
     * 
     * @param streamId 
     * @param playbackId 
     * @param body 
     * @param options additional options
     * @return The response from the API call
     * @throws RuntimeException subclass if the API call fails
     */
    public UpdateLiveStreamDomainRestrictionsResponse updateDomainRestrictions(
            @Nonnull String streamId, @Nonnull String playbackId,
            @Nonnull UpdateLiveStreamDomainRestrictionsRequestBody body, @Nullable Options options) {
        UpdateLiveStreamDomainRestrictionsRequest request = new UpdateLiveStreamDomainRestrictionsRequest(streamId, playbackId, body);
        RequestOperation<UpdateLiveStreamDomainRestrictionsRequest, UpdateLiveStreamDomainRestrictionsResponse> operation
              = new UpdateLiveStreamDomainRestrictions.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Update user-agent restrictions for a playback ID
     * 
     * <p>This endpoint allows updating user-agent restrictions for a specific playback ID associated with a
     * live stream.
     * It can be used to allow or deny specific user-agents during playback request evaluation.
     * 
     * <p>**How it works:**
     * 1. Make a `PATCH` request to this endpoint with your desired user-agent access configuration.
     * 2. Specify a default policy (`allow` or `deny`) and provide specific `allow` or `deny` lists.
     * 3. Use this to restrict access to specific browsers, devices, or bots.
     * 
     * <p>**Example:**
     * A developer may configure a playback ID to deny access from known scraping user-agents while
     * allowing all others by default.
     * 
     * @return The call builder
     */
    public UpdateLiveStreamUserAgentRestrictionsRequestBuilder updateUserAgentRestrictions() {
        return new UpdateLiveStreamUserAgentRestrictionsRequestBuilder(sdkConfiguration);
    }

    /**
     * Update user-agent restrictions for a playback ID
     * 
     * <p>This endpoint allows updating user-agent restrictions for a specific playback ID associated with a
     * live stream.
     * It can be used to allow or deny specific user-agents during playback request evaluation.
     * 
     * <p>**How it works:**
     * 1. Make a `PATCH` request to this endpoint with your desired user-agent access configuration.
     * 2. Specify a default policy (`allow` or `deny`) and provide specific `allow` or `deny` lists.
     * 3. Use this to restrict access to specific browsers, devices, or bots.
     * 
     * <p>**Example:**
     * A developer may configure a playback ID to deny access from known scraping user-agents while
     * allowing all others by default.
     * 
     * @param streamId 
     * @param playbackId 
     * @param body 
     * @return The response from the API call
     * @throws RuntimeException subclass if the API call fails
     */
    public UpdateLiveStreamUserAgentRestrictionsResponse updateUserAgentRestrictions(
            @Nonnull String streamId, @Nonnull String playbackId,
            @Nonnull UpdateLiveStreamUserAgentRestrictionsRequestBody body) {
        return updateUserAgentRestrictions(streamId, playbackId, body,
            null);
    }

    /**
     * Update user-agent restrictions for a playback ID
     * 
     * <p>This endpoint allows updating user-agent restrictions for a specific playback ID associated with a
     * live stream.
     * It can be used to allow or deny specific user-agents during playback request evaluation.
     * 
     * <p>**How it works:**
     * 1. Make a `PATCH` request to this endpoint with your desired user-agent access configuration.
     * 2. Specify a default policy (`allow` or `deny`) and provide specific `allow` or `deny` lists.
     * 3. Use this to restrict access to specific browsers, devices, or bots.
     * 
     * <p>**Example:**
     * A developer may configure a playback ID to deny access from known scraping user-agents while
     * allowing all others by default.
     * 
     * @param streamId 
     * @param playbackId 
     * @param body 
     * @param options additional options
     * @return The response from the API call
     * @throws RuntimeException subclass if the API call fails
     */
    public UpdateLiveStreamUserAgentRestrictionsResponse updateUserAgentRestrictions(
            @Nonnull String streamId, @Nonnull String playbackId,
            @Nonnull UpdateLiveStreamUserAgentRestrictionsRequestBody body, @Nullable Options options) {
        UpdateLiveStreamUserAgentRestrictionsRequest request = new UpdateLiveStreamUserAgentRestrictionsRequest(streamId, playbackId, body);
        RequestOperation<UpdateLiveStreamUserAgentRestrictionsRequest, UpdateLiveStreamUserAgentRestrictionsResponse> operation
              = new UpdateLiveStreamUserAgentRestrictions.Sync(sdkConfiguration, options, _headers);
        return operation.handleResponse(operation.doRequest(request));
    }
}
