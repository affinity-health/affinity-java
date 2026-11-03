#!/usr/bin/env bash
# Generates the Java SDK with Fern from spec/affinity.openapi.json, the committed Affinity
# contract. Fern runs locally in Docker; no Fern account or token is used. Needs Docker, Node and jq.
#
# Fern writes the Gradle project (build.gradle, settings.gradle, the Gradle wrapper, src/ and a
# placeholder sample-app/). This script replaces those paths in the repository with the new
# output. Every other file in the repository is written by hand (see AGENTS.md).
set -euo pipefail
root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$root"

fern_version="$(jq -r .version fern/fern.config.json)"
sdk_version="0.7.0"
output="$root/.fern-output"
# The paths Fern owns in the repository.
generated=(src sample-app gradle build.gradle settings.gradle gradlew gradlew.bat)

jq -f scripts/prepare-spec.jq spec/affinity.openapi.json >fern/openapi.json
rm -rf "$output"
# --generate-tests makes Fern write the full Gradle project (build.gradle with the Maven
# coordinates from fern/generators.yml) instead of only src/main.
env -u FERN_TOKEN npx --yes "fern-api@$fern_version" generate --group java --local --no-prompt \
  --force --version "$sdk_version" --generate-tests
# Fern can exit 0 after its container fails; require the client it writes.
test -f "$output/src/main/java/com/affinity/api/AffinityClient.java" || {
  echo "Fern wrote no AffinityClient.java" >&2
  exit 1
}

# Fern has no repository URL in local-file-system mode and writes a placeholder in the POM.
sed -i 's#github.com/YOUR-ORG/YOUR-REPO#github.com/affinity-health/affinity-java#g' "$output/build.gradle"

mkdir -p docs
mv "$output/reference.md" docs/reference.md
for path in "${generated[@]}"; do rm -rf "${root:?}/$path"; done
for path in "${generated[@]}"; do cp -R "$output/$path" "$root/$path"; done
rm -rf "$output" fern/openapi.json

generator_version="$(awk '/fern-java-sdk/ {getline; print $2; exit}' fern/generators.yml)"
jq --arg fern "$fern_version" --arg generatorVersion "$generator_version" \
  --arg sha "$(sha256sum spec/affinity.openapi.json | cut -d' ' -f1)" '
  {
    contractVersion: .info.version,
    contractSha256: $sha,
    fernVersion: $fern,
    generator: "fernapi/fern-java-sdk",
    generatorVersion: $generatorVersion,
    operations: ([.paths | to_entries[] | .key as $path | .value | to_entries[]
      | select((.value | type) == "object" and .value.operationId != null)
      | {key: .value.operationId, value: "\(.key | ascii_upcase) \($path)"}] | from_entries)
  }' spec/affinity.openapi.json >generation.json
echo "Generated the Java SDK from API $(jq -r .contractVersion generation.json): $(jq '.operations | length' generation.json) operations."
