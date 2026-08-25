package com.fastpix.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.fastpix.sdk.FastPixSDK;
import io.fastpix.sdk.models.components.CreatePlaylistRequestManual;
import io.fastpix.sdk.models.components.CreatePlaylistRequestManualType;
import io.fastpix.sdk.models.components.MediaIdsRequest;
import io.fastpix.sdk.models.components.PlaylistByIdResponseDataManual;
import io.fastpix.sdk.models.components.PlaylistCreatedResponse;
import io.fastpix.sdk.models.components.Security;
import io.fastpix.sdk.models.components.UpdatePlaylistRequest;
import io.fastpix.sdk.utils.JSON;

/**
 * Playlists: create a playlist, add/reorder/remove media, read it back, update
 * it, then delete it. A "manual" playlist is used so no metadata filter is
 * required for the add/reorder/remove-media flow.
 */
public class PlaylistsExample {

    // referenceId must be alphanumeric and unique per workspace; a rerun with
    // the same id collides ("DuplicateReferenceID"). Bump this each run.
    static final String REFERENCE_ID = "playlistexample001";

    // Real media ids from your workspace (add/reorder/remove need media that exist).
    static final List<String> MEDIA_IDS = List.of(
            "REPLACE_WITH_MEDIA_ID_1",
            "REPLACE_WITH_MEDIA_ID_2");

    public static void main(String[] args) throws Exception {
        FastPixSDK sdk = FastPixSDK.builder()
                .security(Security.builder()
                        .username(System.getenv("FASTPIX_USERNAME"))
                        .password(System.getenv("FASTPIX_PASSWORD"))
                        .build())
                .build();

        ObjectMapper mapper = JSON.getMapper().enable(SerializationFeature.INDENT_OUTPUT);

        // 1. Create a manual playlist.
        PlaylistCreatedResponse created = sdk.playlists().create(
                CreatePlaylistRequestManual.builder()
                        .name("My Playlist")
                        .referenceId(REFERENCE_ID)
                        .type(CreatePlaylistRequestManualType.MANUAL)
                        .description("A sample playlist")
                        .limit(20L)
                        .build())
                .playlistCreatedResponse().orElseThrow();
        System.out.println("=== create playlist ===");
        System.out.println(mapper.writeValueAsString(created));
        String playlistId = ((PlaylistByIdResponseDataManual) created.data()).id().orElseThrow();

        // 2. Add media, then reorder them (reversed).
        System.out.println("\n=== add media ===");
        System.out.println(mapper.writeValueAsString(sdk.playlists()
                .addMedia(playlistId, MediaIdsRequest.builder().mediaIds(MEDIA_IDS).build())
                .playlistByIdResponse().orElseThrow()));

        List<String> reversed = new ArrayList<>(MEDIA_IDS);
        Collections.reverse(reversed);
        System.out.println("\n=== reorder media ===");
        System.out.println(mapper.writeValueAsString(sdk.playlist()
                .updateMediaOrder(playlistId, MediaIdsRequest.builder().mediaIds(reversed).build())
                .playlistByIdResponse().orElseThrow()));

        // 3. Read it back (single + list).
        System.out.println("\n=== get playlist ===");
        System.out.println(mapper.writeValueAsString(
                sdk.playlists().get(playlistId).playlistByIdResponse().orElseThrow()));

        System.out.println("\n=== list playlists ===");
        System.out.println(mapper.writeValueAsString(
                sdk.playlists().list(10L, 1L, null).getAllPlaylistsResponse().orElseThrow()));

        // 4. Update, remove media, then delete.
        System.out.println("\n=== update playlist ===");
        System.out.println(mapper.writeValueAsString(sdk.playlists()
                .update(playlistId, UpdatePlaylistRequest.builder()
                        .name("Renamed Playlist")
                        .description("Updated")
                        .build())
                .playlistCreatedResponse().orElseThrow()));

        System.out.println("\n=== remove media ===");
        System.out.println(mapper.writeValueAsString(sdk.playlist()
                .removeMedia(playlistId, MediaIdsRequest.builder().mediaIds(MEDIA_IDS).build(), null)
                .playlistByIdResponse().orElseThrow()));

        System.out.println("\n=== delete playlist ===");
        System.out.println(mapper.writeValueAsString(
                sdk.playlists().delete(playlistId).playlistDeleteResponse().orElseThrow()));
    }
}
