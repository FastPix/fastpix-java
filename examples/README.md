# FastPix Java SDK — Examples

Each example is an end-to-end flow that chains related methods into one realistic
sequence (create → use → clean up), rather than a single call. For single-method
usage and parameter reference, see [`docs/sdks/`](../docs/sdks).

## Setup

The examples resolve the SDK from Maven Central (`io.fastpix:sdk`). If you're
working against a local build of the SDK, publish it first:

```bash
cd ..
./gradlew publishToMavenLocal
```

Then set your credentials from the [FastPix Dashboard](https://dashboard.fastpix.com)
(Access Token = username, Secret Key = password):

```bash
export FASTPIX_USERNAME="your-access-token"
export FASTPIX_PASSWORD="your-secret-key"
```

You can also copy [`.env.example`](.env.example) to `.env` and load it in your
shell (`set -a; . ./.env; set +a`).

## Running

Each example is its own `run<Name>` Gradle task:

```bash
./gradlew runDirectUpload
./gradlew runMediaLifecycle
./gradlew runVerifyWebhook
```

A few examples work on existing resources — a ready media, a view — and have a
placeholder constant at the top of the file (e.g. `REPLACE_WITH_A_READY_MEDIA_ID`).
Swap in a real id before running. `MediaLifecycleExample` prints media ids you can
reuse.

## Examples

| Example | What it chains |
| --- | --- |
| [`DirectUploadExample`](src/main/java/com/fastpix/example/DirectUploadExample.java) | create signed upload URL → list uploads → cancel upload |
| [`MediaLifecycleExample`](src/main/java/com/fastpix/example/MediaLifecycleExample.java) | create media → get → list → update → source-access → delete |
| [`MediaTracksExample`](src/main/java/com/fastpix/example/MediaTracksExample.java) | add an audio track → add a subtitle track (on a ready media) |
| [`PlaybackIdsExample`](src/main/java/com/fastpix/example/PlaybackIdsExample.java) | create playback id → domain & user-agent restrictions → delete |
| [`PlaylistsExample`](src/main/java/com/fastpix/example/PlaylistsExample.java) | create → add/reorder/remove media → get/list → update → delete |
| [`LiveStreamingExample`](src/main/java/com/fastpix/example/LiveStreamingExample.java) | create stream → playback id → update → disable/enable/complete → delete |
| [`SimulcastingExample`](src/main/java/com/fastpix/example/SimulcastingExample.java) | create stream → add simulcast target → update → delete |
| [`SigningKeysExample`](src/main/java/com/fastpix/example/SigningKeysExample.java) | create → list → get → delete a signing key |
| [`AiFeaturesExample`](src/main/java/com/fastpix/example/AiFeaturesExample.java) | enable summary → chapters → moderation → named entities → read summary |
| [`VideoViewDetailsExample`](src/main/java/com/fastpix/example/VideoViewDetailsExample.java) | fetch analytics for a single view |
| [`VerifyWebhookExample`](src/main/java/com/fastpix/example/VerifyWebhookExample.java) | verify a `FastPix-Signature` webhook (offline, no API call) |

## Spring Boot project

A runnable Spring Boot integration lives in [`spring-boot/`](spring-boot) — it
exposes `POST /uploads` (mint a signed upload URL) and `POST /webhooks` (verify
the signature and react to events). See its own README for run steps.
