# Endpoint Validation (Hybrid: OpenAPI via Node, SDK via Java)

These dev tools validate the generated **Java** SDK against the live FastPix API
and the OpenAPI spec. The orchestration runs in TypeScript (for the OpenAPI
response-schema validation and JSON-path diffing); the SDK itself is exercised
through a small Java harness (`tests/sdkharness`) compiled against the built SDK
and invoked as a subprocess.

## Quick Start

1. Install Node deps (from the SDK repo root):

```bash
npm install --prefix tests
```

2. Ensure a JDK (11+) is available and the SDK builds. The harness is compiled
   automatically on first run against the SDK runtime classpath, which is
   resolved via:

```bash
./gradlew -q printRuntimeClasspath   # compiles the SDK + prints its classpath
```

3. Set env vars:

```bash
export FASTPIX_USERNAME="your-username"
export FASTPIX_PASSWORD="your-password"
# optional:
# export FASTPIX_BASE_URL="https://api.fastpix.com/v1/"
# export FASTPIX_OPENAPI_SPEC="/abs/path/to/spec.yaml"   # overrides spec auto-discovery
```

4. Run:

```bash
cd tests
npm run validate:get-endpoints       # GET endpoints
npm run validate:non-get-endpoints   # POST/PUT/PATCH/DELETE lifecycle
```

Artifacts and reports are written into `tests/`.

## Overview

The GET validator implements a **hybrid testing approach**:

1. **Calls the API directly** via HTTP to get raw JSON responses
2. **Validates API responses** against the OpenAPI schema using `openapi-response-validator`
3. **Calls the Java SDK** for the same operation (via the `tests/sdkharness` subprocess)
4. **Compares API vs SDK responses** to identify:
   - Fields missing in SDK (present in API but dropped by SDK parsing)
   - Fields missing in API (present in SDK but not in API response)
   - Empty arrays omitted in SDK vs API
5. **Generates artifacts** (API vs SDK JSON files) and validation reports

The non-GET validator mutates live data, so it cannot hit the API and the SDK
separately. It runs a **create → update → delete** lifecycle through the SDK,
captures each created resource id for downstream steps, and validates the SDK's
raw wire response (captured by a body-tee'ing HTTP client in the harness)
against the OpenAPI schema.

## How It Works

### TypeScript drivers

- `validate-get-endpoints.ts` — extracts all GET endpoints from the spec, calls
  each via fetch + the SDK, diffs the two, and writes:
  - `GET_ENDPOINTS_OPENAPI_RESPONSE_VALIDATION_REPORT.md`
  - `GET_ENDPOINTS_OPENAPI_RESPONSE_FIX_SUGGESTIONS.md`
- `validate-non-get-endpoints.ts` — runs the mutating lifecycle and writes
  `NON_GET_ENDPOINTS_VALIDATION_REPORT.md`.
- `java-harness.ts` — resolves the SDK classpath, compiles the harness once, and
  runs it per operation (`invokeJavaSDK`).

### Java SDK harness (`tests/sdkharness/`)

`SdkHarness.java` (entry point) + `Dispatch.java` (operationId → SDK method map).
The drivers run `java -cp <sdk-classpath> io.fastpix.sdk.harness.SdkHarness`,
passing a JSON payload on stdin:

```json
{ "operationId": "...", "request": { ... }, "baseUrl": "...", "username": "...", "password": "..." }
```

The harness dispatches to the matching SDK method, then prints a JSON result:

- success: `{ "ok": true, "value": <body>, "statusCode": <int|null>, "rawBody": <json|string|null> }`
- failure: `{ "ok": false, "error": { "name", "message", "statusCode?", "bodyJson?" } }`

It captures the raw wire status + body via a wrapping `HTTPClient` so the non-GET
validator can validate the on-the-wire response even though the SDK consumes the
body during deserialization. The classpath resolution + `javac` compile happen
once per process (lazily, cached), mirroring the Go harness's compile-once model.

## Fixtures

`get-endpoints-fixtures.json` ships with placeholder IDs. Fill it for a run with

```bash
npm run fixtures:setup        # creates temp resources on the account, writes their IDs
npm run validate:get-endpoints
npm run fixtures:teardown     # deletes them and restores the fixture file
```

Never commit the filled file. Endpoints without a fixture fall back to a
placeholder UUID, which typically yields a 404 or 422.
