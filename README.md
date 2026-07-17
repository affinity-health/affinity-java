# Affinity Java SDK

The official Java SDK for the Affinity API.

> **Status:** This repository is being prepared for its first release. The artifact is not yet
> published and its public API may change before `0.1.0`.

The SDK will provide a small, resource-oriented client for JVM services connecting healthcare
practices to Affinity's compounder network. The initial release will target Java 11 and newer.

## Planned artifact

```xml
<dependency>
  <groupId>ai.joinaffinity</groupId>
  <artifactId>affinity-sdk</artifactId>
  <version>0.1.0</version>
</dependency>
```

## Intended usage

```java
import ai.joinaffinity.sdk.Affinity;

public final class Application {
  public static void main(String[] args) throws Exception {
    Affinity affinity =
        new Affinity(
            System.getenv("AFFINITY_API_KEY"),
            new Affinity.Options().apiVersion("2026-07-09"));

    var catalog = affinity.catalog().list("semaglutide");
    var practices = affinity.practices().list();
    var orders = affinity.orders().list();
  }
}
```

## Resource model

The initial client surface is planned around these resources:

- `account()` — inspect the authenticated organization and API access
- `catalog()` — search products available through the Affinity network
- `practices()` — create and manage customer practices
- `orders()` — create, submit, inspect, update, and cancel orders
- `webhooks()` — manage endpoints and inspect or replay events

Generated transport classes will remain available as an escape hatch, while `Affinity` will be the
recommended entry point.

## Safety

Affinity API keys are service-account credentials. Use this SDK only in a trusted backend and load
keys from server-side secret storage. Do not embed a key into distributed clients or expose it
through logs.

Requests involving patient, prescription, or fulfillment data may contain protected health
information. Integrators are responsible for their own authorization, logging, retention,
infrastructure, and compliance controls.

## Generation and releases

This SDK will be generated from the versioned contract in
[`affinity-openapi`](https://github.com/affinity-health/affinity-openapi), with a maintained
resource facade layered over the generated transport. Releases will be validated against the same
contract before publication to Maven Central.

## Related projects

- [OpenAPI specification](https://github.com/affinity-health/affinity-openapi)
- [TypeScript SDK](https://github.com/affinity-health/affinity-typescript)

