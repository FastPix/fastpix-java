# FastPix Spring Boot example

A minimal Spring Boot integration with two endpoints:

- `POST /uploads` — mints a signed direct-upload URL via the SDK and returns
  `{uploadId, url}`. The client uploads the file straight to that URL; the bytes
  never pass through this server.
- `POST /webhooks` — verifies the `FastPix-Signature` over the raw request body,
  then reacts to the event. It acks fast with a 2xx (FastPix retries on non-2xx).

## Setup

Set your credentials (Access Token = username, Secret Key = password) and your
webhook signing secret — the app reads them from the environment:

```bash
export FASTPIX_USERNAME="your-access-token"
export FASTPIX_PASSWORD="your-secret-key"
export FASTPIX_WEBHOOK_SECRET="your-webhook-signing-secret"
```

(Or copy [`.env.example`](.env.example) to `.env` and load it.)

The SDK (`io.fastpix:sdk`) is pulled from Maven Central automatically — there's
nothing else to install or build first.

## Run

From this directory (`examples/spring-boot`):

```bash
cd examples/spring-boot
./gradlew bootRun
```

The app listens on `http://localhost:8080`.

> This example wires the `FastPixSDK` bean by hand (see `SdkConfig`). FastPix also
> ships a Spring Boot starter that auto-configures that bean from
> `openapi.security.*` properties — once that artifact is available to you, delete
> `SdkConfig` and depend on the starter instead.

## Create an upload, then send the file

`POST /uploads` hands you a signed URL. The client uploads the file straight to
that URL, so the bytes never touch your server, and once it finishes FastPix
processes the video and sends the `video.media.ready` webhook.

We keep this example simple and just PUT the whole file in one request — good
enough for small files. For larger ones you'll usually want a resumable upload
(chunked, with retries and progress); the same signed URL supports that too.

```bash
# 1. Ask your app for a signed upload URL
UPLOAD_URL=$(
  curl -s -X POST localhost:8080/uploads \
    | python3 -c "import sys, json; print(json.load(sys.stdin)['url'])"
)

# 2. Upload the file straight to it
curl -X PUT --upload-file video.mp4 \
  -H "Content-Type: video/mp4" \
  "$UPLOAD_URL"
```

Or from the browser, straight off a file input:

```js
// 1. Ask your app for a signed upload URL
const res = await fetch("/uploads", { method: "POST" });
const { url } = await res.json();

// 2. Upload the file straight to it
await fetch(url, {
  method: "PUT",
  headers: { "Content-Type": file.type || "application/octet-stream" },
  body: file,
});
```

We create uploads with `corsOrigin: "*"` so the browser can PUT from anywhere —
lock that down before you ship, and put your own auth in front of `/uploads`.
The docs go deeper (resumable included):
https://fastpix.com/docs/upload-videos/upload-videos-from-device
