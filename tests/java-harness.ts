/*
 * Java SDK invocation bridge for the endpoint validators.
 *
 * The fastpix-java SDK is compiled, so (unlike the PHP harness which runs inline
 * code) we drive it through a small hand-written Java program — tests/sdkharness
 * (SdkHarness.java + Dispatch.java). This module:
 *
 *   1. resolves the SDK's runtime classpath via `./gradlew -q printRuntimeClasspath`
 *      (which also compiles the SDK), then
 *   2. compiles the harness once with `javac`, then
 *   3. runs `java ... io.fastpix.sdk.harness.SdkHarness` per operation, passing
 *      the operation + request as JSON on stdin.
 *
 * The harness prints back the contract the validators expect:
 *   success: { ok: true,  value, statusCode, rawBody }
 *   failure: { ok: false, error: { name, message, statusCode?, bodyJson? } }
 *
 * Steps 1–2 run once (lazily) and are cached for the process lifetime, mirroring
 * the Go harness's compile-once / run-many behavior.
 */

import { spawnSync } from "node:child_process";
import { existsSync, mkdirSync } from "node:fs";
import { tmpdir } from "node:os";
import { join, delimiter, dirname } from "node:path";
import { fileURLToPath } from "node:url";

const __dirname = dirname(fileURLToPath(import.meta.url));

export type JavaSDKResult =
  | { ok: true; value: any; statusCode: number | null; rawBody: any }
  | { ok: false; error: { name?: string; message?: string; statusCode?: number; bodyJson?: any } };

function repoRoot(): string {
  return join(__dirname, "..");
}

function gradlew(): string {
  return process.platform === "win32" ? "gradlew.bat" : "./gradlew";
}

let harness: { classpath: string; outDir: string } | null = null;
let setupError: string | null = null;

// Resolve the SDK runtime classpath and compile the harness once.
function setup(): { classpath: string; outDir: string } | null {
  if (harness) return harness;
  if (setupError) return null;

  const root = repoRoot();

  const cpRes = spawnSync(gradlew(), ["-q", "printRuntimeClasspath"], {
    cwd: root,
    encoding: "utf-8",
    maxBuffer: 32 * 1024 * 1024,
  });
  if (cpRes.status !== 0 || !cpRes.stdout) {
    setupError = `Failed to resolve SDK classpath: ${(cpRes.stderr || cpRes.stdout || "").slice(0, 800)}`;
    return null;
  }
  const classpath = cpRes.stdout
    .trim()
    .split(/\r?\n/)
    .filter(Boolean)
    .pop()!
    .trim();

  const outDir = join(tmpdir(), `fastpix-java-harness-${process.pid}`);
  mkdirSync(outDir, { recursive: true });

  const srcs = [
    join(__dirname, "sdkharness", "SdkHarness.java"),
    join(__dirname, "sdkharness", "Dispatch.java"),
  ];
  const javac = spawnSync("javac", ["-cp", classpath, "-d", outDir, ...srcs], {
    cwd: root,
    encoding: "utf-8",
    maxBuffer: 32 * 1024 * 1024,
  });
  if (javac.status !== 0) {
    setupError = `Failed to compile Java harness: ${(javac.stderr || javac.stdout || "").slice(0, 1500)}`;
    return null;
  }

  harness = { classpath, outDir };
  return harness;
}

export function invokeJavaSDK(
  operationId: string,
  request: any,
  baseUrl: string,
  username: string,
  password: string,
): JavaSDKResult {
  const h = setup();
  if (!h) {
    return { ok: false, error: { name: "JavaHarnessSetupError", message: setupError ?? "unknown setup error" } };
  }

  const cp = `${h.outDir}${delimiter}${h.classpath}`;
  const child = spawnSync("java", ["-cp", cp, "io.fastpix.sdk.harness.SdkHarness"], {
    input: JSON.stringify({ operationId, request: request ?? {}, baseUrl, username, password }),
    encoding: "utf-8",
    cwd: repoRoot(),
    maxBuffer: 32 * 1024 * 1024,
  });

  if (child.error) {
    return { ok: false, error: { name: "JavaSpawnError", message: child.error.message } };
  }

  const stdout = (child.stdout || "").trim();
  const stderr = (child.stderr || "").trim();

  // SLF4J emits NOP-logger warnings to stderr; only surface unexpected chatter.
  const noise = stderr
    .split("\n")
    .filter((l) => !l.startsWith("SLF4J"))
    .join(" ")
    .trim();

  if (!stdout.startsWith("{") && !stdout.startsWith("[")) {
    return { ok: false, error: { name: "JavaRuntimeError", message: (noise || stdout).slice(0, 1000) || "Java harness produced no output" } };
  }
  if (noise) console.error(`java stderr: ${noise.slice(0, 300)}`);

  try {
    const parsed = JSON.parse(stdout);
    if (parsed?.ok) {
      return { ok: true, value: parsed.value, statusCode: parsed.statusCode ?? null, rawBody: parsed.rawBody ?? null };
    }
    return { ok: false, error: parsed?.error ?? { name: "JavaSDKError", message: stdout.slice(0, 500) } };
  } catch (e: any) {
    return { ok: false, error: { name: "JavaOutputParseError", message: `Failed to parse JSON: ${e.message}. Output: ${stdout.slice(0, 500)}` } };
  }
}
