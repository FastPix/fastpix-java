package io.fastpix.sdk.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jakarta.annotation.Nullable;
import io.fastpix.sdk.models.components.Event;
import io.fastpix.sdk.models.components.EventTime;
import io.fastpix.sdk.models.components.ViewerTime;
import io.fastpix.sdk.models.components.Views;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Maps the fields of a {@link Views} response into logical event categories
 * that correspond to the FastPix Video Data API semantics.
 *
 * <p>Categories:
 * <ul>
 *   <li>VIEW_SESSION   – session identifiers and lifecycle timestamps</li>
 *   <li>STARTUP_EVENT  – time-to-first-frame and startup scoring</li>
 *   <li>PLAYBACK_EVENT – watch time, seek, and engagement metrics</li>
 *   <li>BUFFER_EVENT   – rebuffering occurrences and ratios</li>
 *   <li>ERROR_EVENT    – playback errors captured during the session</li>
 *   <li>QUALITY_METRICS – composite QoE and stream-quality scores</li>
 *   <li>NETWORK_EVENT  – CDN, connection type, and request latency</li>
 *   <li>CONTENT_INFO   – video asset and source metadata</li>
 *   <li>PLAYER_INFO    – player name, version, and SDK details</li>
 *   <li>DEVICE_ENV     – hardware, OS, and browser context</li>
 *   <li>GEO_INFO       – viewer location derived from IP geolocation</li>
 *   <li>PLAYER_EVENTS  – raw per-event timeline from the player</li>
 * </ul>
 */
public final class ViewEventMapper {

    // The Event model uses snake_case @JsonProperty names (e.g. "player_playhead_time")
    // but the API returns camelCase (e.g. "playerPlayheadTime"). This custom deserializer
    // reads both naming conventions directly and is registered before any API call via
    // registerEventDeserializer(), which SDKHooks.initialize() calls during SDK construction.
    private static class EventDeserializer extends JsonDeserializer<Event> {
        // Abbreviated key mappings used by the FastPix API in the events array:
        //   "pt"   → playerPlayheadTime
        //   "e"    → eventName
        //   "vt"   → viewerTime
        //   "d"    → eventDetails  (inner: "host"→hostName, "txt"→text, "c"→code,
        //                                   "err"→error, "t"→type, "u"→url)
        @Override
        public Event deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonNode node = p.getCodec().readTree(p);

            Long playheadTime = longNode(node, "pt", "playerPlayheadTime", "player_playhead_time");
            String eventName  = strNode(node, "e", "eventName", "event_name");
            Long viewerTs     = longNode(node, "vt", "viewerTime", "viewer_time");
            Long eventTs      = longNode(node, "et", "eventTime", "event_time");

            Map<String, Object> details = null;
            JsonNode detailsNode = firstNode(node, "d", "eventDetails", "event_details");
            if (detailsNode != null && !detailsNode.isNull() && detailsNode.isObject()) {
                details = expandDetails(detailsNode);
            }

            return new Event(
                playheadTime != null ? JsonNullable.of(playheadTime) : JsonNullable.undefined(),
                eventName    != null ? JsonNullable.of(eventName)    : JsonNullable.undefined(),
                details,
                viewerTs != null ? JsonNullable.of(ViewerTime.of(viewerTs)) : JsonNullable.undefined(),
                eventTs  != null ? JsonNullable.of(EventTime.of(eventTs))   : JsonNullable.undefined()
            );
        }

        // All known abbreviated key → full name mappings for eventDetails
        private static final Map<String, String> DETAIL_KEY_MAP = new java.util.HashMap<>();
        static {
            DETAIL_KEY_MAP.put("host", "hostName");
            DETAIL_KEY_MAP.put("txt",  "text");
            DETAIL_KEY_MAP.put("c",    "code");
            DETAIL_KEY_MAP.put("err",  "error");
            DETAIL_KEY_MAP.put("t",    "type");
            DETAIL_KEY_MAP.put("u",    "url");
            DETAIL_KEY_MAP.put("br",   "bitrate");
            DETAIL_KEY_MAP.put("h",    "height");
            DETAIL_KEY_MAP.put("w",    "width");
            DETAIL_KEY_MAP.put("cd",   "codec");
        }

        private static Map<String, Object> expandDetails(JsonNode d) {
            Map<String, Object> m = new LinkedHashMap<>();
            d.fieldNames().forEachRemaining(k -> {
                String outKey = DETAIL_KEY_MAP.getOrDefault(k, k);
                JsonNode v = d.get(k);
                if (v.isNull()) {
                    m.put(outKey, null);
                } else if (v.isNumber()) {
                    double num = v.asDouble();
                    boolean isWhole = !Double.isInfinite(num) && num == Math.floor(num);
                    // Explicit if/else avoids Java's long→double promotion in ternary
                    if (v.isIntegralNumber() || isWhole) {
                        m.put(outKey, Long.valueOf(v.asLong()));
                    } else {
                        m.put(outKey, num);
                    }
                } else {
                    m.put(outKey, v.asText());
                }
            });
            return m;
        }

        private static JsonNode firstNode(JsonNode n, String... keys) {
            for (String k : keys) { if (n.has(k)) return n.get(k); }
            return null;
        }

        private static Long longNode(JsonNode n, String... keys) {
            JsonNode v = firstNode(n, keys);
            return (v != null && !v.isNull()) ? v.asLong() : null;
        }

        private static String strNode(JsonNode n, String... keys) {
            JsonNode v = firstNode(n, keys);
            return (v != null && !v.isNull()) ? v.asText() : null;
        }
    }

    public static void registerEventDeserializer() {
        SimpleModule module = new SimpleModule("EventCamelCaseModule");
        module.addDeserializer(Event.class, new EventDeserializer());
        JSON.getMapper().registerModule(module);
    }

    private ViewEventMapper() {}

    /**
     * Converts a {@link Views} object into a flat map matching the FastPix API response structure:
     * {@code { "success": true, "data": { ...all fields..., "events": [...] } }}.
     *
     * @param v the view data returned by {@code sdk.views().getDetails()}
     * @return a map with {@code success} and {@code data} keys, where {@code data} contains
     *         all view fields in alphabetical order with {@code events} at the end
     */
    public static Map<String, Object> map(Views v) {
        // Build all fields alphabetically; events is appended last to match API response order
        TreeMap<String, Object> sorted = new TreeMap<>();
        Map<String, Object> data = sorted; // placeholder; replaced below after all fields are added

        data.put("asnId",                    get(v.asnId()));
        data.put("asnName",                  get(v.asnName()));
        data.put("averageBitrate",           numVal(v.averageBitrate()));
        data.put("avgDownscaling",           get(v.avgDownscaling()));
        data.put("avgRequestLatency",        numVal(v.avgRequestLatency()));
        data.put("avgRequestThroughput",     numVal(v.avgRequestThroughput()));
        data.put("avgUpscaling",             numVal(v.avgUpscaling()));
        data.put("beaconDomain",             v.beaconDomain().orElse(null));
        data.put("browserEngine",            get(v.browserEngine()));
        data.put("browserName",              get(v.browserName()));
        data.put("browserVersion",           get(v.browserVersion()));
        data.put("bufferCount",              get(v.bufferCount()));
        data.put("bufferFill",               get(v.bufferFill()));
        data.put("bufferFrequency",          numVal(v.bufferFrequency()));
        data.put("bufferRatio",              numVal(v.bufferRatio()));
        data.put("cdn",                      get(v.cdn()));
        data.put("city",                     get(v.city()));
        data.put("connectionType",           get(v.connectionType()));
        data.put("continent",                get(v.continent()));
        data.put("country",                  get(v.country()));
        data.put("countryCode",              get(v.countryCode()));
        data.put("custom",                   v.custom().map(c -> JSON.getMapper().convertValue(c, Map.class)).orElse(null));
        data.put("deviceManufacturer",       get(v.deviceManufacturer()));
        data.put("deviceModel",              get(v.deviceModel()));
        data.put("deviceName",               get(v.deviceName()));
        data.put("deviceType",               get(v.deviceType()));
        data.put("drmType",                  get(v.drmType()));
        data.put("droppedFrameCount",        get(v.droppedFrameCount()));
        data.put("errorCode",                get(v.errorCode()));
        data.put("errorContext",             get(v.errorContext()));
        data.put("errorId",                  get(v.errorId()));
        data.put("errorMessage",             get(v.errorMessage()));
        data.put("exitBeforeVideoStart",     v.exitBeforeVideoStart().orElse(null));
        data.put("experimentName",           get(v.experimentName()));
        data.put("fpApiVersion",             get(v.fpApiVersion()));
        data.put("fpEmbed",                  get(v.fpEmbed()));
        data.put("fpEmbedVersion",           get(v.fpEmbedVersion()));
        data.put("fpLiveStreamId",           get(v.fpLiveStreamId()));
        data.put("fpPlaybackId",             get(v.fpPlaybackId()));
        data.put("fpSDK",                    get(v.fpSDK()));
        data.put("fpSDKVersion",             get(v.fpSDKVersion()));
        data.put("fpViewerId",               get(v.fpViewerId()));
        data.put("insertTimestamp",          v.insertTimestamp().orElse(null));
        data.put("ipAddress",                v.ipAddress().orElse(null));
        data.put("jumpLatency",              numVal(v.jumpLatency()));
        data.put("latitude",                 get(v.latitude()));
        data.put("liveStreamLatency",        get(v.liveStreamLatency()));
        data.put("longitude",                get(v.longitude()));
        data.put("maxDownscaling",           get(v.maxDownscaling()));
        data.put("maxRequestLatency",        numVal(v.maxRequestLatency()));
        data.put("maxUpscaling",             numVal(v.maxUpscaling()));
        data.put("mediaId",                  get(v.mediaId()));
        data.put("osName",                   get(v.osName()));
        data.put("osVersion",                v.osVersion().orElse(null));
        data.put("pageContext",              get(v.pageContext()));
        data.put("pageLoadTime",             get(v.pageLoadTime()));
        data.put("playbackScore",            numVal(v.playbackScore()));
        data.put("playerAutoplayOn",         v.playerAutoplayOn().orElse(null));
        data.put("playerHeight",             get(v.playerHeight()));
        data.put("playerInitializationTime", get(v.playerInitializationTime()));
        data.put("playerInstanceId",         get(v.playerInstanceId()));
        data.put("playerLanguage",           get(v.playerLanguage()));
        data.put("playerName",               get(v.playerName()));
        data.put("playerPoster",             get(v.playerPoster()));
        data.put("playerPreloadOn",          v.playerPreloadOn().orElse(null));
        data.put("playerRemotePlayed",       v.playerRemotePlayed().orElse(null));
        data.put("playerResolution",         get(v.playerResolution()));
        data.put("playerSoftwareName",       get(v.playerSoftwareName()));
        data.put("playerSoftwareVersion",    get(v.playerSoftwareVersion()));
        data.put("playerSourceDomain",       get(v.playerSourceDomain()));
        data.put("playerSourceHeight",       get(v.playerSourceHeight()));
        data.put("playerSourceWidth",        get(v.playerSourceWidth()));
        data.put("playerVersion",            get(v.playerVersion()));
        data.put("playerViewCount",          get(v.playerViewCount()));
        data.put("playerWidth",              get(v.playerWidth()));
        data.put("propertyId",               get(v.propertyId()));
        data.put("qualityOfExperienceScore", get(v.qualityOfExperienceScore()));
        data.put("region",                   get(v.region()));
        data.put("renderQualityScore",       numVal(v.renderQualityScore()));
        data.put("sessionId",                get(v.sessionId()));
        data.put("sign",                     get(v.sign()));
        data.put("stabilityScore",           numVal(v.stabilityScore()));
        data.put("startupScore",             get(v.startupScore()));
        data.put("subPropertyId",            get(v.subPropertyId()));
        data.put("totalStartupTime",         get(v.totalStartupTime()));
        data.put("updatedTimestamp",         get(v.updatedTimestamp()));
        data.put("usedFullScreen",           v.usedFullScreen().orElse(null));
        data.put("userAgent",                get(v.userAgent()));
        data.put("videoContentType",         get(v.videoContentType()));
        data.put("videoDuration",            get(v.videoDuration()));
        data.put("videoEncodingVariant",     get(v.videoEncodingVariant()));
        data.put("videoId",                  get(v.videoId()));
        data.put("videoLanguage",            get(v.videoLanguage()));
        data.put("videoProducer",            get(v.videoProducer()));
        data.put("videoResolution",          get(v.videoResolution()));
        data.put("videoSeries",              get(v.videoSeries()));
        data.put("videoSourceDomain",        get(v.videoSourceDomain()));
        data.put("videoSourceDuration",      get(v.videoSourceDuration()));
        data.put("videoSourceHostname",      get(v.videoSourceHostname()));
        data.put("videoSourceStreamType",    get(v.videoSourceStreamType()));
        data.put("videoSourceType",          get(v.videoSourceType()));
        data.put("videoSourceUrl",           get(v.videoSourceUrl()));
        data.put("videoStartupFailed",       v.videoStartupFailed().orElse(null));
        data.put("videoStartupTime",         get(v.videoStartupTime()));
        data.put("videoTitle",               get(v.videoTitle()));
        data.put("videoVariantId",           get(v.videoVariantId()));
        data.put("videoVariantName",         get(v.videoVariantName()));
        data.put("viewEnd",                  get(v.viewEnd()));
        data.put("viewHasAd",                v.viewHasAd().orElse(null));
        data.put("viewHasError",             v.viewHasError().orElse(null));
        data.put("viewId",                   v.viewId().orElse(null));
        data.put("viewMaxPlayheadPosition",  get(v.viewMaxPlayheadPosition()));
        data.put("viewPageUrl",              get(v.viewPageUrl()));
        data.put("viewPlayingTime",          get(v.viewPlayingTime()));
        data.put("viewSeekedCount",          get(v.viewSeekedCount()));
        data.put("viewSeekedDuration",       get(v.viewSeekedDuration()));
        data.put("viewSessionId",            get(v.viewSessionId()));
        data.put("viewStart",                get(v.viewStart()));
        data.put("viewTotalContentPlaybackTime", get(v.viewTotalContentPlaybackTime()));
        data.put("viewerId",                 get(v.viewerId()));
        data.put("watchTime",                get(v.watchTime()));
        data.put("workspaceId",              v.workspaceId().orElse(null));

        // Convert to LinkedHashMap so events can be appended AFTER all alphabetical fields
        Map<String, Object> orderedData = new LinkedHashMap<>(sorted);
        orderedData.put("events", buildEvents(v));

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("success", true);
        result.put("data",    orderedData);
        return result;
    }

    private static List<Map<String, Object>> buildEvents(Views v) {
        List<Map<String, Object>> list = new ArrayList<>();
        v.events().ifPresent(events -> {
            for (Event e : events) {
                Map<String, Object> entry = new LinkedHashMap<>();
                entry.put("playerPlayheadTime", get(e.playerPlayheadTime()));
                entry.put("eventName",          get(e.eventName()));

                // eventDetails only included when present (matches API behaviour)
                Map<String, Object> details = e.eventDetails().orElse(null);
                if (details != null) entry.put("eventDetails", details);

                // viewerTime is OneOf(String | Long) — unwrap to the primitive value
                ViewerTime vt = get(e.viewerTime());
                entry.put("viewerTime", vt != null
                    ? vt.asLong().map(Object.class::cast).orElseGet(() -> vt.string().orElse(null))
                    : null);

                list.add(entry);
            }
        });
        return list;
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private static <T> T get(JsonNullable<T> n) {
        return (n != null && n.isPresent()) ? n.get() : null;
    }

    // Returns Long when the double is a whole number (e.g. 0.0→0, 1.0→1, 2550448.0→2550448),
    // matching the API's integer representation for integral-valued fields.
    private static Object numVal(JsonNullable<Double> n) {
        Double d = get(n);
        if (d == null) return null;
        if (!Double.isInfinite(d) && d == Math.floor(d) && d >= Long.MIN_VALUE && d <= Long.MAX_VALUE) {
            return d.longValue();
        }
        return d;
    }
}
