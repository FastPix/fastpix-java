// Dispatch maps an operationId to the corresponding fastpix-java SDK call and
// returns the SDK response object (so SdkHarness can reflect out the body) or
// throws (so SdkHarness can normalize the error).
//
// GET operations are fully wired with the fixture-supplied path/query params.
// Non-GET (create/update/delete) operations are wired to the correct SDK method
// with minimal request bodies; the non-GET validator orchestrates the real
// create -> use -> delete lifecycle and supplies captured ids at runtime.
//
// Hand-written (not generated).
package io.fastpix.sdk.harness;

import java.util.List;
import java.util.Map;

import io.fastpix.sdk.FastPixSDK;

import io.fastpix.sdk.models.components.MediaIdsRequest;
import io.fastpix.sdk.models.components.CreatePlaylistRequestManual;
import io.fastpix.sdk.models.components.CreatePlaylistRequestManualType;
import io.fastpix.sdk.models.components.UpdatePlaylistRequest;
import io.fastpix.sdk.models.components.CreateLiveStreamRequest;
import io.fastpix.sdk.models.components.PlaybackSettings;
import io.fastpix.sdk.models.components.InputMediaSettings;
import io.fastpix.sdk.models.components.PatchLiveStreamRequest;
import io.fastpix.sdk.models.components.PlaybackIdRequest;
import io.fastpix.sdk.models.components.SimulcastRequest;
import io.fastpix.sdk.models.components.SimulcastUpdateRequest;
import io.fastpix.sdk.models.components.UpdateTrackRequest;
import io.fastpix.sdk.models.components.CreateMediaRequest;
import io.fastpix.sdk.models.components.TrackSubtitlesGenerateRequest;
import io.fastpix.sdk.models.components.Input;
import io.fastpix.sdk.models.components.PullVideoInput;
import io.fastpix.sdk.models.components.AddTrackRequest;
import io.fastpix.sdk.models.components.AccessPolicy;

import io.fastpix.sdk.models.operations.AddMediaTrackRequestBody;
import io.fastpix.sdk.models.operations.CreateMediaPlaybackIdRequestBody;
import io.fastpix.sdk.models.operations.Resolution;
import io.fastpix.sdk.models.operations.UpdateMediaModerationModeration;
import io.fastpix.sdk.models.operations.DirectUploadVideoMediaRequest;
import io.fastpix.sdk.models.operations.PushMediaSettings;
import io.fastpix.sdk.models.operations.UpdatedMediaRequestBody;
import io.fastpix.sdk.models.operations.UpdatedSourceAccessRequestBody;
import io.fastpix.sdk.models.operations.UpdatedMp4SupportRequestBody;
import io.fastpix.sdk.models.operations.UpdateMediaChaptersRequestBody;
import io.fastpix.sdk.models.operations.UpdateMediaSummaryRequestBody;
import io.fastpix.sdk.models.operations.UpdateMediaModerationRequestBody;
import io.fastpix.sdk.models.operations.UpdateMediaNamedEntitiesRequestBody;
import io.fastpix.sdk.models.operations.UpdateDomainRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateUserAgentRestrictionsRequestBody;

import io.fastpix.sdk.models.operations.ListVideoViewsRequest;
import io.fastpix.sdk.models.operations.ListVideoViewsTimespan;
import io.fastpix.sdk.models.operations.ListByTopContentTimespan;
import io.fastpix.sdk.models.operations.DimensionsId;
import io.fastpix.sdk.models.operations.ListFilterValuesForDimensionTimespan;
import io.fastpix.sdk.models.operations.ListBreakdownValuesRequest;
import io.fastpix.sdk.models.operations.ListBreakdownValuesMetricId;
import io.fastpix.sdk.models.operations.ListBreakdownValuesTimespan;
import io.fastpix.sdk.models.operations.ListOverallValuesMetricId;
import io.fastpix.sdk.models.operations.ListOverallValuesTimespan;
import io.fastpix.sdk.models.operations.GetTimeseriesDataRequest;
import io.fastpix.sdk.models.operations.GetTimeseriesDataMetricId;
import io.fastpix.sdk.models.operations.GetTimeseriesDataTimespan;
import io.fastpix.sdk.models.operations.GroupBy;
import io.fastpix.sdk.models.operations.ListComparisonValuesTimespan;
import io.fastpix.sdk.models.operations.Dimension;
import io.fastpix.sdk.models.operations.ListErrorsTimespan;

import static io.fastpix.sdk.harness.SdkHarness.str;
import static io.fastpix.sdk.harness.SdkHarness.lng;
import static io.fastpix.sdk.harness.SdkHarness.sortOrder;
import static io.fastpix.sdk.harness.SdkHarness.opOrderBy;

final class Dispatch {

    static Object invoke(FastPixSDK sdk, String op, Map<String, Object> req) throws Exception {
        switch (op) {
            // ------------------------------ GET ------------------------------
            case "list-media":
                return sdk.manageVideos().list()
                        .limit(lng(req, "limit")).offset(lng(req, "offset")).orderBy(sortOrder(req)).call();
            case "get-media":
                return sdk.manageVideos().get(str(req, "mediaId"));
            case "get-media-summary":
                return sdk.manageVideos().getSummary(str(req, "mediaId"));
            case "retrieveMediaInputInfo":
                return sdk.manageVideos().getInputInfo(str(req, "mediaId"));
            case "list-uploads":
                return sdk.videos().listUploads()
                        .limit(lng(req, "limit")).offset(lng(req, "offset")).orderBy(sortOrder(req)).call();
            case "get-media-clips":
                return sdk.videos().getMediaClips(str(req, "mediaId"));
            case "list-live-clips":
                return sdk.videos().listLiveClips(str(req, "livestreamId"));
            case "get-all-playlists":
                return sdk.playlists().list().limit(lng(req, "limit")).offset(lng(req, "offset")).call();
            case "get-playlist-by-id":
                return sdk.playlists().get(str(req, "playlistId"));
            case "list-playback-ids":
                return sdk.playback().list(str(req, "mediaId"));
            case "get-playback-id":
                return sdk.playback().get(str(req, "mediaId"), str(req, "playbackId"));
            case "getDrmConfiguration":
                return sdk.drmConfigurations().list().limit(lng(req, "limit")).offset(lng(req, "offset")).call();
            case "getDrmConfigurationById":
                return sdk.drmConfigurations().getById(str(req, "drmConfigurationId"));
            case "get-all-streams":
                return sdk.streams().list()
                        .limit(lng(req, "limit")).offset(lng(req, "offset")).orderBy(opOrderBy(req)).call();
            case "get-live-stream-by-id":
                return sdk.manageLiveStream().get(str(req, "streamId"));
            case "get-live-stream-viewer-count-by-id":
                return sdk.manageLiveStreams().getViewerCount(str(req, "streamId"));
            case "get-live-stream-playback-id":
                return sdk.livePlaybacks().getPlaybackIdDetails(str(req, "streamId"), str(req, "playbackId"));
            case "get-specific-simulcast-of-stream":
                return sdk.simulcastStreams().getSpecific(str(req, "streamId"), str(req, "simulcastId"));
            case "list_signing_keys":
                return sdk.signingKeys().list().limit(lng(req, "limit")).offset(lng(req, "offset")).call();
            case "get-signing_key_by_id":
                return sdk.signingKeys().getById(str(req, "signingKeyId"));
            case "list_video_views": {
                ListVideoViewsRequest.Builder b = ListVideoViewsRequest.builder()
                        .limit(lng(req, "limit")).offset(lng(req, "offset"));
                if (str(req, "timespan") != null) {
                    b = b.timespan(ListVideoViewsTimespan.fromValue(str(req, "timespan")).orElseThrow());
                }
                return sdk.views().list(b.build());
            }
            case "get_video_view_details":
                return sdk.views().getDetails(str(req, "viewId"));
            case "list_by_top_content": {
                var rb = sdk.views().listByTopContent().limit(lng(req, "limit"));
                if (str(req, "timespan") != null) {
                    rb = rb.timespan(ListByTopContentTimespan.fromValue(str(req, "timespan")).orElseThrow());
                }
                return rb.call();
            }
            case "list_dimensions":
                return sdk.dimensions().listDirect();
            case "list_filter_values_for_dimension": {
                var rb = sdk.dimensions().listFilterValues()
                        .dimensionsId(DimensionsId.fromValue(str(req, "dimensionsId")).orElseThrow());
                if (str(req, "timespan") != null) {
                    rb = rb.timespan(ListFilterValuesForDimensionTimespan.fromValue(str(req, "timespan")).orElseThrow());
                }
                return rb.call();
            }
            case "list_breakdown_values": {
                ListBreakdownValuesRequest.Builder b = ListBreakdownValuesRequest.builder()
                        .metricId(ListBreakdownValuesMetricId.fromValue(str(req, "metricId")).orElseThrow())
                        .timespan(ListBreakdownValuesTimespan.fromValue(str(req, "timespan")).orElseThrow())
                        .groupBy(str(req, "groupBy"));
                return sdk.metrics().listBreakdown(b.build());
            }
            case "list_overall_values": {
                var rb = sdk.metrics().listOverallValues()
                        .metricId(ListOverallValuesMetricId.fromValue(str(req, "metricId")).orElseThrow());
                if (str(req, "timespan") != null) {
                    rb = rb.timespan(ListOverallValuesTimespan.fromValue(str(req, "timespan")).orElseThrow());
                }
                return rb.call();
            }
            case "get_timeseries_data": {
                GetTimeseriesDataRequest.Builder b = GetTimeseriesDataRequest.builder()
                        .metricId(GetTimeseriesDataMetricId.fromValue(str(req, "metricId")).orElseThrow())
                        .timespan(GetTimeseriesDataTimespan.fromValue(str(req, "timespan")).orElseThrow());
                if (str(req, "groupBy") != null) {
                    b = b.groupBy(GroupBy.fromValue(str(req, "groupBy")).orElseThrow());
                }
                return sdk.metrics().getTimeseries(b.build());
            }
            case "list_comparison_values": {
                var rb = sdk.metrics().listComparison().value(str(req, "value"));
                if (str(req, "timespan") != null) {
                    rb = rb.timespan(ListComparisonValuesTimespan.fromValue(str(req, "timespan")).orElseThrow());
                }
                if (str(req, "dimension") != null) {
                    rb = rb.dimension(Dimension.fromValue(str(req, "dimension")).orElseThrow());
                }
                return rb.call();
            }
            case "list_errors": {
                var rb = sdk.errors().list().limit(lng(req, "limit"));
                if (str(req, "timespan") != null) {
                    rb = rb.timespan(ListErrorsTimespan.fromValue(str(req, "timespan")).orElseThrow());
                }
                return rb.call();
            }

            // -------------------------- POST (create) --------------------------
            case "create-media":
                return sdk.inputVideos().create(CreateMediaRequest.builder()
                        .inputs(List.of(Input.of(PullVideoInput.builder().build())))
                        .metadata(Map.of("source", "sdk-validate"))
                        .build());
            case "create_signing_key":
                return sdk.signingKeys().createDirect();
            case "create-a-playlist":
                return sdk.playlists().create(CreatePlaylistRequestManual.builder()
                        .name("sdk-validate-playlist")
                        // referenceId must be alphanumeric (no separators)
                        .referenceId("sdkvalidate" + uniq())
                        .type(CreatePlaylistRequestManualType.MANUAL)
                        .build());
            case "create-new-stream":
                return sdk.streams().create(CreateLiveStreamRequest.builder()
                        .playbackSettings(PlaybackSettings.builder().build())
                        .inputMediaSettings(InputMediaSettings.builder()
                                .metadata(Map.of("name", "sdk-validate")).build())
                        .build());
            case "create-media-playback-id":
                return sdk.playback().createId(str(req, "mediaId"),
                        CreateMediaPlaybackIdRequestBody.builder()
                                .accessPolicy(AccessPolicy.PUBLIC)
                                .resolution(Resolution.ONE_THOUSAND_AND_EIGHTYP)
                                .build(),
                        null);
            case "Add-media-track":
                return sdk.manageVideos().addTrack(str(req, "mediaId"), AddMediaTrackRequestBody.builder()
                        .tracks(AddTrackRequest.builder().build()).build());
            case "Generate-subtitle-track":
                return sdk.manageVideos().generateSubtitles(str(req, "mediaId"), str(req, "trackId"),
                        TrackSubtitlesGenerateRequest.builder().build());
            case "create-playbackId-of-stream":
                return sdk.livePlayback().createPlaybackId(str(req, "streamId"), PlaybackIdRequest.builder().build());
            case "create-simulcast-of-stream":
                return sdk.simulcastStream().create(str(req, "streamId"), SimulcastRequest.builder()
                        .url("rtmp://example.com/live")
                        .streamKey("sk-" + uniq())
                        .build());
            case "direct-upload-video-media":
                return sdk.inputVideos().upload(DirectUploadVideoMediaRequest.builder()
                        .pushMediaSettings(PushMediaSettings.builder()
                                .metadata(Map.of("source", "sdk-validate")).build())
                        .build(), null);

            // ----------------------- PUT / PATCH (update) -----------------------
            case "updated-media":
                return sdk.videos().updateMedia(str(req, "mediaId"), UpdatedMediaRequestBody.builder()
                        .metadata(Map.of("updated", "true"))
                        .title("SDK Validate Title")
                        .build());
            case "updated-source-access":
                return sdk.manageVideos().updateSourceAccess(str(req, "mediaId"),
                        UpdatedSourceAccessRequestBody.builder().sourceAccess(true).build());
            case "updated-mp4Support":
                return sdk.videos().updateMp4Support(str(req, "mediaId"), UpdatedMp4SupportRequestBody.builder().build());
            case "update-media-summary":
                return sdk.aiFeatures().updateMediaSummary(str(req, "mediaId"),
                        UpdateMediaSummaryRequestBody.builder().generate(true).build());
            case "update-media-chapters":
                return sdk.videos().updateChapters(str(req, "mediaId"),
                        UpdateMediaChaptersRequestBody.builder().chapters(true).build());
            case "update-media-named-entities":
                return sdk.inVideoAiFeatures().generateNamedEntities(str(req, "mediaId"),
                        UpdateMediaNamedEntitiesRequestBody.builder().namedEntities(true).build());
            case "update-media-moderation":
                return sdk.inVideoAiFeatures().updateModeration(str(req, "mediaId"),
                        UpdateMediaModerationRequestBody.builder()
                                .moderation(UpdateMediaModerationModeration.builder().build()).build());
            case "update-media-track":
                return sdk.videos().updateTrack(str(req, "trackId"), str(req, "mediaId"), UpdateTrackRequest.builder().build());
            case "update-domain-restrictions":
                return sdk.playback().updateDomainRestrictions(str(req, "mediaId"), str(req, "playbackId"),
                        UpdateDomainRestrictionsRequestBody.builder().allow(List.of("example.com")).build());
            case "update-user-agent-restrictions":
                return sdk.playback().updateUserAgentRestrictions(str(req, "mediaId"), str(req, "playbackId"),
                        UpdateUserAgentRestrictionsRequestBody.builder().allow(List.of("Mozilla")).build());
            case "update-a-playlist":
                return sdk.playlists().update(str(req, "playlistId"), UpdatePlaylistRequest.builder()
                        .name("SDK Validate Updated").description("updated by validator").build());
            case "add-media-to-playlist":
                return sdk.playlists().addMedia(str(req, "playlistId"),
                        MediaIdsRequest.builder().mediaIds(List.of(str(req, "mediaId"))).build());
            case "change-media-order-in-playlist":
                return sdk.playlist().updateMediaOrder(str(req, "playlistId"),
                        MediaIdsRequest.builder().mediaIds(List.of(str(req, "mediaId"))).build());
            case "update-live-stream":
                return sdk.manageLiveStream().update(str(req, "streamId"), PatchLiveStreamRequest.builder()
                        .metadata(Map.of("updated", "true")).reconnectWindow(120L).build());
            case "update-specific-simulcast-of-stream":
                return sdk.simulcasts().update(str(req, "streamId"), str(req, "simulcastId"),
                        SimulcastUpdateRequest.builder().isEnabled(false).build());
            case "enable-live-stream":
                return sdk.liveStream().enable(str(req, "streamId"));
            case "disable-live-stream":
                return sdk.liveStream().disable(str(req, "streamId"));
            case "complete-live-stream":
                return sdk.liveStream().complete(str(req, "streamId"));
            case "cancel-upload":
                return sdk.videos().cancelUpload(str(req, "uploadId"));

            // ----------------------------- DELETE -----------------------------
            case "delete-media-from-playlist":
                return sdk.playlist().removeMedia(str(req, "playlistId"),
                        MediaIdsRequest.builder().mediaIds(List.of(str(req, "mediaId"))).build(), null);
            case "delete-a-playlist":
                return sdk.playlists().delete(str(req, "playlistId"));
            case "delete-media-track":
                return sdk.manageVideos().deleteTrack(str(req, "mediaId"), str(req, "trackId"));
            case "delete-media-playback-id":
                return sdk.playback().deleteId(str(req, "mediaId"), str(req, "playbackId"));
            case "delete-simulcast-of-stream":
                return sdk.simulcastStreams().delete(str(req, "streamId"), str(req, "simulcastId"));
            case "delete-playbackId-of-stream":
                return sdk.livePlayback().deletePlaybackId(str(req, "streamId"), str(req, "playbackId"));
            case "delete-live-stream":
                return sdk.liveStream().delete(str(req, "streamId"));
            case "delete-media":
                return sdk.videos().delete(str(req, "mediaId"));
            case "delete_signing_key":
                return sdk.signingKeys().delete(str(req, "signingKeyId"));

            default:
                throw new IllegalArgumentException("no Java SDK mapping for operationId \"" + op + "\"");
        }
    }

    // Digits-only unique suffix for fields that must be alphanumeric (e.g. playlist
    // referenceId) and unique per run.
    private static String uniq() {
        return Long.toString(System.nanoTime());
    }

    private Dispatch() {}
}
