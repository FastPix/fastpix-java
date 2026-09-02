package io.fastpix.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import io.fastpix.sdk.AsyncLivePlayback;
import io.fastpix.sdk.LivePlayback;
import io.fastpix.sdk.Playback;
import io.fastpix.sdk.models.components.CreateLiveStreamRequest;
import io.fastpix.sdk.models.components.GetAllMediaResponse;
import io.fastpix.sdk.models.components.GetMediaDetailResponse;
import io.fastpix.sdk.models.components.InputMediaSettings;
import io.fastpix.sdk.models.components.LiveMediaClips;
import io.fastpix.sdk.models.components.Media;
import io.fastpix.sdk.models.components.MediaClipResponseData;
import io.fastpix.sdk.models.components.PlaybackIdAccessRestrictions;
import io.fastpix.sdk.models.components.PlaybackIdDomains;
import io.fastpix.sdk.models.components.PlaybackIdRequest;
import io.fastpix.sdk.models.components.PlaybackIdResponse;
import io.fastpix.sdk.models.components.PlaybackIdSuccessResponse;
import io.fastpix.sdk.models.components.PlaybackIdUserAgents;
import io.fastpix.sdk.models.components.PlaybackSettings;
import io.fastpix.sdk.models.components.PlaylistByIdResponseMediaListItem;
import io.fastpix.sdk.models.components.PolicyAction;
import io.fastpix.sdk.models.components.SourceAccessMedia;
import io.fastpix.sdk.models.components.UpdateMedia;
import io.fastpix.sdk.models.operations.UpdateDomainRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsRequest;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateLiveStreamDomainRestrictionsResponseBody;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsRequest;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsRequestBody;
import io.fastpix.sdk.models.operations.UpdateLiveStreamUserAgentRestrictionsResponseBody;
import io.fastpix.sdk.models.operations.UpdateUserAgentRestrictionsRequestBody;
import io.fastpix.sdk.utils.JSON;

/** Wire-contract checks for models touched by the live-restrictions spec sync. */
class ModelContractTest {

    private static final ObjectMapper MAPPER = JSON.getMapper();

    private static final String RESTRICTIONS = "{\"domains\":{\"defaultPolicy\":\"deny\",\"allow\":[\"example.com\"],\"deny\":[]},"
            + "\"userAgents\":{\"defaultPolicy\":\"allow\",\"allow\":[],\"deny\":[]}}";

    static Stream<Class<?>> durationModels() {
        return Stream.of(GetAllMediaResponse.class, GetMediaDetailResponse.class, LiveMediaClips.class,
                MediaClipResponseData.class, Media.class, UpdateMedia.class, SourceAccessMedia.class,
                PlaylistByIdResponseMediaListItem.class);
    }

    @SuppressWarnings("unchecked")
    private static Optional<Double> duration(Object model) throws Exception {
        return (Optional<Double>) model.getClass().getMethod("duration").invoke(model);
    }

    @ParameterizedTest
    @MethodSource("durationModels")
    void durationIsOptionalDouble(Class<?> type) throws Exception {
        assertEquals(Optional.of(145.821315), duration(MAPPER.readValue("{\"duration\":145.821315}", type)));
        assertEquals(Optional.of(10.0), duration(MAPPER.readValue("{\"duration\":10}", type)));
        assertEquals(Optional.empty(), duration(MAPPER.readValue("{}", type)));
        JsonNode out = MAPPER.readTree(MAPPER.writeValueAsString(MAPPER.readValue("{\"duration\":145.82}", type)));
        assertTrue(out.get("duration").isNumber());
        assertEquals(145.82, out.get("duration").doubleValue());
        assertThrows(MismatchedInputException.class, () -> MAPPER.readValue("{\"duration\":\"00:02:25\"}", type));
    }

    @Test
    void enableRecordingIsOptionalAndRoundTrips() throws Exception {
        assertFalse(MAPPER.readTree(MAPPER.writeValueAsString(InputMediaSettings.builder().build())).has("enableRecording"));
        InputMediaSettings parsed = MAPPER.readValue("{\"enableRecording\":false}", InputMediaSettings.class);
        assertEquals(Optional.of(false), parsed.enableRecording());
        assertFalse(MAPPER.readTree(MAPPER.writeValueAsString(parsed)).get("enableRecording").booleanValue());
        CreateLiveStreamRequest req = CreateLiveStreamRequest.builder()
                .playbackSettings(PlaybackSettings.builder().build())
                .inputMediaSettings(InputMediaSettings.builder().enableRecording(false).build()).build();
        assertFalse(MAPPER.readTree(MAPPER.writeValueAsString(req)).at("/inputMediaSettings/enableRecording").booleanValue());
    }

    private static PlaybackIdAccessRestrictions exampleRestrictions() {
        return PlaybackIdAccessRestrictions.builder()
                .domains(PlaybackIdDomains.builder().defaultPolicy(PolicyAction.DENY)
                        .allow(List.of("example.com")).deny(List.of()).build())
                .userAgents(PlaybackIdUserAgents.builder().defaultPolicy(PolicyAction.ALLOW)
                        .allow(List.of()).deny(List.of()).build())
                .build();
    }

    @Test
    void accessRestrictionsOnLivePlaybackModels() throws Exception {
        JsonNode expected = MAPPER.readTree(RESTRICTIONS);

        PlaybackIdRequest request = PlaybackIdRequest.builder().accessRestrictions(exampleRestrictions()).build();
        assertEquals(MAPPER.readTree("{\"accessPolicy\":\"public\",\"accessRestrictions\":" + RESTRICTIONS + "}"),
                MAPPER.readTree(MAPPER.writeValueAsString(request)));
        assertFalse(MAPPER.readTree(MAPPER.writeValueAsString(PlaybackIdRequest.builder().build())).has("accessRestrictions"));

        PlaybackSettings settings = PlaybackSettings.builder().accessRestrictions(exampleRestrictions()).build();
        assertEquals(expected, MAPPER.readTree(MAPPER.writeValueAsString(settings)).get("accessRestrictions"));

        PlaybackIdResponse item = MAPPER.readValue("{\"id\":\"p1\",\"accessRestrictions\":" + RESTRICTIONS + "}", PlaybackIdResponse.class);
        assertEquals(Optional.of(PolicyAction.DENY), item.accessRestrictions().get().domains().get().defaultPolicy());
        assertEquals(Optional.empty(), MAPPER.readValue("{\"id\":\"p1\"}", PlaybackIdResponse.class).accessRestrictions());

        PlaybackIdSuccessResponse with = MAPPER.readValue(
                "{\"success\":true,\"data\":{\"id\":\"p1\",\"accessPolicy\":\"public\",\"accessRestrictions\":" + RESTRICTIONS + "}}",
                PlaybackIdSuccessResponse.class);
        assertEquals(Optional.of(List.of("example.com")), with.data().get().accessRestrictions().get().domains().get().allow());
        PlaybackIdSuccessResponse without = MAPPER.readValue(
                "{\"success\":true,\"data\":{\"id\":\"p1\",\"accessPolicy\":\"public\"}}", PlaybackIdSuccessResponse.class);
        assertEquals(Optional.empty(), without.data().get().accessRestrictions());
    }

    @Test
    void liveRestrictionRequestBodiesAreFlat() throws Exception {
        assertEquals(MAPPER.readTree("{\"defaultPolicy\":\"allow\",\"allow\":[\"yourdomain.com\"],\"deny\":[\"malicioussite.io\"]}"),
                MAPPER.readTree(MAPPER.writeValueAsString(UpdateLiveStreamDomainRestrictionsRequestBody.builder()
                        .allow(List.of("yourdomain.com")).deny(List.of("malicioussite.io")).build())));
        assertEquals(MAPPER.readTree("{\"defaultPolicy\":\"allow\"}"),
                MAPPER.readTree(MAPPER.writeValueAsString(UpdateLiveStreamUserAgentRestrictionsRequestBody.builder().build())));

        UpdateLiveStreamDomainRestrictionsRequest request = new UpdateLiveStreamDomainRestrictionsRequest(
                "s1", "p1", UpdateLiveStreamDomainRestrictionsRequestBody.builder().build());
        assertEquals("s1", request.streamId());
        assertEquals("p1", request.playbackId());
        assertThrows(NoSuchMethodException.class, () -> UpdateLiveStreamDomainRestrictionsRequest.class.getMethod("mediaId"));
        assertThrows(NoSuchMethodException.class, () -> UpdateLiveStreamUserAgentRestrictionsRequest.class.getMethod("mediaId"));

        String response = "{\"success\":true,\"data\":{\"defaultPolicy\":\"allow\",\"allow\":[\"yourdomain.com\"],\"deny\":[\"malicioussite.io\"]}}";
        UpdateLiveStreamDomainRestrictionsResponseBody domains = MAPPER.readValue(response, UpdateLiveStreamDomainRestrictionsResponseBody.class);
        assertEquals(Optional.of(true), domains.success());
        assertEquals(Optional.of("allow"), domains.data().get().defaultPolicy());
        assertEquals(Optional.of(List.of("malicioussite.io")), domains.data().get().deny());
        UpdateLiveStreamUserAgentRestrictionsResponseBody agents = MAPPER.readValue(response, UpdateLiveStreamUserAgentRestrictionsResponseBody.class);
        assertEquals(Optional.of(List.of("yourdomain.com")), agents.data().get().allow());
    }

    @Test
    void livePlaybackExposesRestrictionOperations() throws Exception {
        LivePlayback.class.getMethod("updateDomainRestrictions", String.class, String.class, UpdateLiveStreamDomainRestrictionsRequestBody.class);
        LivePlayback.class.getMethod("updateUserAgentRestrictions", String.class, String.class, UpdateLiveStreamUserAgentRestrictionsRequestBody.class);
        AsyncLivePlayback.class.getMethod("updateDomainRestrictions", String.class, String.class, UpdateLiveStreamDomainRestrictionsRequestBody.class);
        AsyncLivePlayback.class.getMethod("updateUserAgentRestrictions", String.class, String.class, UpdateLiveStreamUserAgentRestrictionsRequestBody.class);
        Playback.class.getMethod("updateDomainRestrictions", String.class, String.class, UpdateDomainRestrictionsRequestBody.class);
        Playback.class.getMethod("updateUserAgentRestrictions", String.class, String.class, UpdateUserAgentRestrictionsRequestBody.class);
    }
}
