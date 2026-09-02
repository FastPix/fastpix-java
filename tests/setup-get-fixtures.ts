#!/usr/bin/env tsx
/*
 * Fills `get-endpoints-fixtures.json` with real IDs for a GET validator run.
 *
 *   npm run fixtures:setup     creates a stream + playback ID, a playlist and a
 *                              signing key, picks a Ready media, writes the IDs
 *                              into the fixture file and records them in
 *                              .fixture-resources.json
 *   npm run fixtures:teardown  deletes those resources and restores the fixture
 *                              file from git
 *
 * Requires FASTPIX_USERNAME / FASTPIX_PASSWORD and optionally FASTPIX_BASE_URL.
 * Never commit the filled fixture file; teardown restores it.
 */

import { readFileSync, writeFileSync, existsSync, unlinkSync } from "node:fs";
import { execSync } from "node:child_process";
import { join, dirname } from "node:path";
import { fileURLToPath } from "node:url";

const here = dirname(fileURLToPath(import.meta.url));
const fixturePath = join(here, "get-endpoints-fixtures.json");
const statePath = join(here, ".fixture-resources.json");
const base = (process.env.FASTPIX_BASE_URL ?? "https://api.fastpix.com/v1").replace(/\/$/, "");
const auth = "Basic " + Buffer.from(`${process.env.FASTPIX_USERNAME}:${process.env.FASTPIX_PASSWORD}`).toString("base64");

if (!process.env.FASTPIX_USERNAME || !process.env.FASTPIX_PASSWORD) {
  console.error("Set FASTPIX_USERNAME and FASTPIX_PASSWORD (see .env.example).");
  process.exit(1);
}

async function call(method: string, path: string, body?: unknown): Promise<any> {
  const res = await fetch(base + path, {
    method,
    headers: { Authorization: auth, "Content-Type": "application/json" },
    body: body === undefined ? undefined : JSON.stringify(body),
  });
  const text = await res.text();
  if (!res.ok) throw new Error(`${method} ${path} -> ${res.status} ${text.slice(0, 200)}`);
  return text ? JSON.parse(text) : {};
}

async function setup() {
  const stream = (await call("POST", "/live/streams", {
    playbackSettings: { accessPolicy: "public" },
    inputMediaSettings: { metadata: { name: "sdk-get-validate" }, enableRecording: true },
  })).data;
  const streamId: string = stream.streamId ?? stream.id;
  const pb = (await call("POST", `/live/streams/${streamId}/playback-ids`, {
    accessPolicy: "public",
    accessRestrictions: {
      domains: { defaultPolicy: "deny", allow: ["example.com"], deny: [] },
      userAgents: { defaultPolicy: "allow", allow: [], deny: [] },
    },
  })).data;
  const playbackId: string = pb.id ?? pb.playbackIds?.[0]?.id;
  const playlistId: string = (await call("POST", "/on-demand/playlists", {
    name: "sdk-get-validate", referenceId: "sdkgetvalidate" + Date.now(), type: "manual",
  })).data.id;
  const signingKeyId: string = (await call("POST", "/iam/signing-keys", {})).data.id;
  const media = ((await call("GET", "/on-demand?limit=50&offset=1")).data as any[]).find((m) => m.status === "Ready");
  if (!media) throw new Error("no Ready media in this workspace; upload one first");

  const ids: Record<string, string> = {
    "your-stream-id": streamId, "your-livestream-id": streamId, "your-playback-id": playbackId,
    "your-playlist-id": playlistId, "your-signing-key-id": signingKeyId, "your-media-id": media.id,
  };
  const fixtures = JSON.parse(readFileSync(fixturePath, "utf-8"));
  const walk = (v: any): any =>
    typeof v === "string" ? (ids[v] ?? v) : Array.isArray(v) ? v.map(walk) :
    v && typeof v === "object" ? Object.fromEntries(Object.entries(v).map(([k, x]) => [k, walk(x)])) : v;
  const filled = walk(fixtures);
  // the on-demand playback lookup needs the media's own playback ID, not the stream's
  filled.operations["get-playback-id"].pathParams.playbackId = media.playbackIds?.[0]?.id ?? playbackId;
  writeFileSync(fixturePath, JSON.stringify(filled, null, 2) + "\n");
  writeFileSync(statePath, JSON.stringify({ streamId, playbackId, playlistId, signingKeyId }, null, 2) + "\n");
  console.log(`fixtures filled: stream=${streamId} playback=${playbackId} playlist=${playlistId} signingKey=${signingKeyId} media=${media.id}`);
  console.log("run `npm run validate:get-endpoints`, then `npm run fixtures:teardown`");
}

async function teardown() {
  if (!existsSync(statePath)) { console.log("nothing to tear down"); return; }
  const s = JSON.parse(readFileSync(statePath, "utf-8"));
  for (const [m, p] of [
    ["DELETE", `/live/streams/${s.streamId}/playback-ids/${s.playbackId}`],
    ["DELETE", `/live/streams/${s.streamId}`],
    ["DELETE", `/on-demand/playlists/${s.playlistId}`],
    ["DELETE", `/iam/signing-keys/${s.signingKeyId}`],
  ]) {
    try { await call(m, p); console.log(`deleted ${p}`); } catch (e) { console.warn(String(e)); }
  }
  unlinkSync(statePath);
  execSync("git checkout -- get-endpoints-fixtures.json", { cwd: here, stdio: "inherit" });
  console.log("fixture file restored");
}

(process.argv.includes("--teardown") ? teardown() : setup()).catch((e) => { console.error(String(e)); process.exit(1); });
