#!/usr/bin/env bash
# Regenerates the SDK from spec/affinity.openapi.json and fails if anything differs from the
# committed files: generated code is never edited by hand. Build output (build/, .gradle/) is
# ignored. Needs Docker, Node and jq.
set -euo pipefail
root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
paths=(src sample-app gradle build.gradle settings.gradle gradlew gradlew.bat docs/reference.md generation.json)
snapshot="$(mktemp -d)"
trap 'rm -rf "$snapshot"' EXIT
for path in "${paths[@]}"; do
  mkdir -p "$snapshot/$(dirname "$path")"
  cp -R "$root/$path" "$snapshot/$path"
done
"$root/scripts/generate.sh" >/dev/null
status=0
for path in "${paths[@]}"; do
  diff -ru -x build -x .gradle "$snapshot/$path" "$root/$path" || status=1
done
exit "$status"
