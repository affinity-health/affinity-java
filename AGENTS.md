# Affinity Java SDK agent guide

This repository contains the official Java SDK for the Affinity public API.

## Source of truth

- `spec/affinity.openapi.json` is a copy of the committed Affinity API contract (the same file as
  `spec/affinity.openapi.json` in affinity-health/affinity-typescript). Do not edit it here.
  Change the contract upstream, copy the new snapshot, and regenerate.
- Fern generates these paths. Never edit them by hand; change `fern/generators.yml`,
  `scripts/prepare-spec.jq` or `scripts/generate.sh` and regenerate:
  `src/`, `sample-app/`, `gradle/`, `build.gradle`, `settings.gradle`, `gradlew`, `gradlew.bat`,
  `docs/reference.md` and `generation.json`.
- Hand-written files: `README.md`, `CHANGELOG.md`, `AGENTS.md`, `CONTRIBUTING.md`, `SECURITY.md`,
  `LICENSE`, `.gitignore`, `.github/workflows/ci.yml`, `fern/fern.config.json`,
  `fern/generators.yml`, `scripts/` and everything in `tests/` (the smoke test and the webhook
  signature example and test). The webhook example in README.md and
  `tests/src/main/java/smoke/WebhookSignature.java` must stay the same.

## Commands

```sh
./scripts/generate.sh          # regenerate (needs Docker, Node and jq)
./scripts/generate-check.sh    # regenerate and fail on any diff
docker run --rm -u "$(id -u):$(id -g)" -e GRADLE_USER_HOME=/tmp/gradle -v "$PWD":/work -w /work \
  gradle:8-jdk17 sh -c './gradlew --no-daemon build && ./gradlew --no-daemon -p tests test installDist'
```

The staging smoke test is in README "Build and verify". Use Test keys (`sk_test_...`) only, and
never call production with it.

## Rules

- Do not publish to Maven Central or any other registry, and do not push tags, without explicit
  authorization.
- The SDK is for trusted server-side Java. Never encourage API keys in browser or mobile code.
- Keep examples synthetic and Test mode only.
- A provider is an individual clinician or prescriber. A practice is the customer organization and
  API tenant. Do not introduce a `clinic` resource.
