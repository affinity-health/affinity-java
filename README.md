# Affinity Java SDK

Server-side client for the Affinity API. Requires Java 17+.

The new interface is implemented in this source update and has not been published to a registry yet.

## Install from source

```sh
git clone https://github.com/affinity-health/affinity-java.git
cd affinity-java
./tests/with-fixtures.sh mvn install
```

## Use

Set `AFFINITY_API_KEY` to a Test practice key on your server. Keep API keys out of browser and mobile code.

```java
import com.affinity.api.Affinity;
import com.affinity.api.models.PatientListParams;

var api = new Affinity(System.getenv("AFFINITY_API_KEY"));
PatientListParams params = PatientListParams.builder()
    .limit(20)
    .build();

var patients = api.patients().list(params);
```

Put request statements inside a method. Maven installs this build locally; Maven Central publication is planned separately.

Practice keys identify their practice automatically. Platform keys pass a practice ID in request options or use a scoped client.

See the [SDK guide](docs/guide.md) for platform requests, patient updates, signing, submission, pagination, and errors.
Routine patient writes generate an idempotency key. Persist your own keys for order creation, signing, and submission.

Defaults: API `2026-09-28`, a 60-second timeout, and no automatic retries.

## Verify

```sh
./tests/with-fixtures.sh mvn test package
```

The tests use synthetic fixtures on loopback. The fixture runner requires Python 3; Docker runs the language toolchain for the `scripts/check.sh` commands.

Generated with Cloudflare Forge, Fern, and Affinity's facade generator. [generation.json](generation.json) records the pinned inputs. Fix the generator in the Affinity monorepo before regenerating client code.
