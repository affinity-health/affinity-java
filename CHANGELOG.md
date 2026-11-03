# Changelog

All notable changes to `io.github.affinity-health:affinity-java` are documented here. The project
uses [Semantic Versioning](https://semver.org/spec/v2.0.0.html); before 1.0, a minor version can
break callers.

## 0.7.0 - 2026-11-03

Generated from the corrected API `2026-11-01` document. Requests and responses on the wire are
unchanged.

### Removed

- `com.affinity.api.errors.MethodNotAllowedError`. The API does not answer `405` to an SDK call. A `405` from a proxy raises `AffinityClientApiException`.
- The `ContentTooLargeErrorBody`, `ServiceUnavailableErrorBody` and their `…Code` and `…CodeCode` types. `ContentTooLargeError.body()` and `ServiceUnavailableError.body()` are now `Problem`, like the other errors.

### Changed

- Clearer descriptions in the types and reference. Every enum member keeps its name.

## 0.6.0 - 2026-11-02

This release is generated from the API `2026-11-01` contract that production serves. That contract
marks each response object and response value list as open: a later API version can add a field or
a value.

### Changed

- Response values keep their known-value types, such as `OrderStatus` and `AllergyCategory`. A response with an
  unknown value or an added field, at the root or nested, decodes without an error: `getEnumValue()` is `UNKNOWN` and `toString()` returns the value; added fields are in `getAdditionalProperties()`.
- `practices.update` accepts `liveEnabled(null)` for `liveEnabled`; it leaves Live unchanged, the same as omitting it.

## 0.5.0 - 2026-11-01

This release targets API `2026-11-01`, which breaks `2026-10-28`.

### Changed

- Every request sends `Affinity-Version: 2026-11-01`.
- A descending sort is `<field>_desc`, such as `ListPracticesRequestSort.CREATED_DESC`: `created_desc` and `patient_desc`
  for orders, and `name_desc`, `location_desc`, `mode_desc` and `created_desc` for practices. The
  `-created` values are gone; the API refuses them.
- The shipping destination input types are renamed: `ShippingDestinationInputAddress`,
  `ShippingDestinationInputPatient` and `ShippingDestinationInputPractice` are now
  `ShippingDestinationAddressInput`, `ShippingDestinationPatientInput` and
  `ShippingDestinationPracticeInput`.

### Added

- The `awaiting_approval` order status, in orders, webhook orders and the `orders.list` status
  filter.

## 0.4.1 - 2026-11-01

### Fixed

- Descending sorts are in the sort types: `-created` and `-patient` for orders, and `-name`,
  `-location`, `-mode` and `-created` for practices. Before, the generator dropped each `-` value,
  so a typed call could not reverse a sort.

### Removed

- The `endingBefore` list parameter. Lists page forward only. After a page fetched with
  `endingBefore`, the next page also sent the forward cursor, and the API refused it with a 400.

## 0.4.0 - 2026-10-31

This version is regenerated with [Fern](https://buildwithfern.com) from API version `2026-10-28`.
It breaks every caller of 0.3.0.

### Changed

- Create the client with `AffinityClient.builder().token(apiKey).build()`. The package is
  `com.affinity.api`; types are in `com.affinity.api.types` and errors in `com.affinity.api.errors`.
- Every write takes a request built with `.idempotencyKey(...)` first. The SDK no longer makes a
  key for you. Save the key with the reviewed request and reuse it to retry.
- Lists return a `SyncPagingIterable` that a `for` loop reads across every page.
- Each documented error status has its own exception, for example `UnprocessableEntityError`,
  whose `body().getIssues()` names each refused field.
- Retries default to 2, for 408, 429 and 5xx responses, and respect `Retry-After`. They reuse the
  request's idempotency key. The timeout is 60 seconds.
- The build is Gradle (`./gradlew build`) and targets Java 8 or later. `pom.xml` is removed.

### Added

- The API version `2026-10-28` operations: account, feedback, medications, orders (create, list,
  get, cancel), practices (create, list, get, update) and webhook endpoints (create, list, update,
  remove, resend failed).
- `docs/reference.md`, the reference for every method.
- A smoke test that runs every operation against a real API in Test mode, and a webhook signature
  verification example with a test.

### Removed

- The old patients, catalog, team, locations, API keys and signing surface, the `Affinity` facade
  and the scoped practice client. API version `2026-10-28` does not have them.
