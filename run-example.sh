#!/usr/bin/env bash
#
# Compile and run a single FastPix example, go-run style:
#
#     ./run-example.sh tests/examples/CreateSimulcast.java
#
# It always recompiles the file first, so you never hit a stale .class.
# All examples use `package hello.world;`, so the main class is
# hello.world.<Filename>.
#
set -euo pipefail

ROOT="$(cd "$(dirname "$0")" && pwd)"
OUT="/tmp/fp-example"
CP_CACHE="$ROOT/.example-classpath"

file="${1:-}"
if [[ -z "$file" ]]; then
    echo "usage: $0 <path/to/Example.java>" >&2
    exit 2
fi
if [[ ! -f "$file" ]]; then
    echo "no such file: $file" >&2
    exit 2
fi

# Build (or reuse cached) classpath: SDK classes/resources + dependency jars.
if [[ ! -f "$CP_CACHE" || "$ROOT/build.gradle" -nt "$CP_CACHE" ]]; then
    sdk_paths="$ROOT/build/classes/java/main:$ROOT/build/resources/main"
    [[ -d "$ROOT/build/libs" ]] && for j in "$ROOT"/build/libs/*.jar; do sdk_paths="$sdk_paths:$j"; done
    deps="$(find "$HOME/.gradle/caches/modules-2" -name '*.jar' 2>/dev/null | tr '\n' ':')"
    printf '%s:%s' "$sdk_paths" "$deps" > "$CP_CACHE"
fi
CP="$(cat "$CP_CACHE")"

# Derive fully-qualified main class from `package` + filename.
pkg="$(grep -m1 '^package ' "$file" | sed -E 's/^package[[:space:]]+([^;]+);.*/\1/')"
cls="$(basename "$file" .java)"
main="${pkg:+$pkg.}$cls"

mkdir -p "$OUT"
echo ">> compiling $file" >&2
javac -cp "$CP" -d "$OUT" "$file"
echo ">> running $main" >&2
exec java -cp "$CP:$OUT" "$main"
