# Java SDK proposal

> **Proposed interface.**
  These examples describe the SDK we plan to build. They are for review and do not run against the
  current release. Package versions and migration steps will follow approval.


Java server applications. Put request statements inside a method. [Source repository](https://github.com/affinity-health/affinity-java) · [All SDKs](https://docs.joinaffinityai.com/guides/reference/sdks/)

## Connect

Set `AFFINITY_API_KEY` to a Test API key on your server. The key selects Test or Live mode. Keep it out of browser and mobile code.

```java
import com.affinity.api.Affinity;
import com.affinity.api.AffinityException;
import com.affinity.api.RequestOptions;
import com.affinity.api.models.*;

var api = new Affinity(System.getenv("AFFINITY_API_KEY"));
```

## With a practice key

The key identifies the practice. No practice ID or scoped client is needed.
The resource IDs below come from records in that practice.
Each section is a separate usage example, not one script to concatenate.

```java
PatientListParams patientParams = PatientListParams.builder()
    .limit(20)
    .build();

var patients = api.patients().list(patientParams);
var patient = api.patients().get(patientId);

CatalogItemListParams itemParams = CatalogItemListParams.builder()
    .limit(20)
    .build();

var items = api.catalog().items().list(itemParams);
```

## With a platform key

Pass the target practice with each practice-scoped request. Keep record data separate from request context and idempotency options.

```java
RequestOptions options = RequestOptions.builder()
    .practiceId(practiceId)
    .build();

PatientListParams listParams = PatientListParams.builder()
    .limit(20)
    .build();

var patients = api.patients().list(listParams, options);
var patient = api.patients().get(patientId, options);

PatientUpdateParams updateParams = PatientUpdateParams.builder()
    .email("alex@example.com")
    .build();

api.patients().update(patientId, updateParams, options);
```

## Scope a workflow once

A scoped client remembers the practice for subsequent requests. It is immutable; the original client and other scoped clients stay independent.
A conflicting practice ID produces an error. Scoping never grants access to another practice.

```java
var practice = api.forPractice(practiceId);

PatientListParams patientParams = PatientListParams.builder()
    .limit(20)
    .build();

var patients = practice.patients().list(patientParams);

CatalogItemListParams itemParams = CatalogItemListParams.builder()
    .limit(20)
    .build();

var items = practice.catalog().items().list(itemParams);
```

The following examples use this scoped client. A practice-key client supports the same calls without the scoping step.

## Create, get, and update a patient

Use synthetic Test data. Routine writes generate a fresh idempotency key per call and preserve it during internal retries.
Supply your own persisted key when retrying across calls or process restarts.

```java
PatientName name = PatientName.builder()
    .first("Alex")
    .last("Example")
    .build();

PatientCreateParams params = PatientCreateParams.builder()
    .name(name)
    .dateOfBirth("1990-01-01")
    .build();

var patient = practice.patients().create(params);

var saved = practice.patients().get(patient.id());

PatientUpdateParams updateParams = PatientUpdateParams.builder()
    .email("alex@example.com")
    .build();

practice.patients().update(patient.id(), updateParams);

PatientUpdateParams archiveParams = PatientUpdateParams.builder()
    .status("archived")
    .build();

practice.patients().update(patient.id(), archiveParams);
```

Archive patients whose records you need to retain. Permanent deletion is available only for patients without order history. No explicit idempotency key is needed.

```java
practice.patients().delete(patientId);
```

## Create an order draft

`draft` is your application's prepared prescription data, using catalog and prescribing options from this practice.
An order contains 1–20 complete prescriptions for one patient. This example creates an unsigned draft.
It shows a platform call without a scoped client: practice context and the persisted key belong together in request options.

`job` is your persisted workflow record. Generate and save a unique key for each action before making its first request.

```java
OrderCreateParams params = OrderCreateParams.builder()
    .patientId(patientId)
    .prescriptions(draft.prescriptions())
    .build();

RequestOptions options = RequestOptions.builder()
    .practiceId(practiceId)
    .idempotencyKey(job.createOrderKey())
    .build();

var order = api.orders().create(params, options);
```

## Sign and submit

`review` is your saved clinician review and signing consent for this exact order.
Store the reviewed revision, authorized prescriber ID, and explicit attestation together.
Your API key needs `orders:sign`. Never infer consent or automatically replace a stale revision.

```java
PrescriberSelector prescriber = PrescriberSelector.builder()
    .id(review.prescriberId())
    .build();

OrderSignParams params = OrderSignParams.builder()
    .prescriber(prescriber)
    .expectedRevision(review.orderRevision())
    .signatureAttestation(review.signatureAttestation())
    .build();

RequestOptions signOptions = RequestOptions.builder()
    .idempotencyKey(job.signOrderKey())
    .build();

practice.orders().sign(orderId, params, signOptions);

RequestOptions submitOptions = RequestOptions.builder()
    .idempotencyKey(job.submitOrderKey())
    .build();

var submission = practice.orders().submit(orderId, submitOptions);
```

Use separate keys for creating, signing, and submitting. After an uncertain response, retry the same action with the same key and unchanged data.
A revision conflict requires renewed clinician review before another signing attempt.

Submission means queued, not accepted by the pharmacy. Inspect the result and track order events or webhooks.
After a reported partial submission failure, retry only the unconfirmed send with a new submission key.

## Read more than one page

The list method returns one page. Pass the last record's ID to request the next page.
The iterator fetches pages as you consume records; it does not load the full collection into memory.
`syncPatient` or its language equivalent represents your application's record handler.

```java
PatientListParams params = PatientListParams.builder()
    .limit(20)
    .build();

var page = practice.patients().list(params);

if (page.hasMore() && !page.data().isEmpty()) {
    var last = page.data().get(page.data().size() - 1);
    PatientListParams nextParams = PatientListParams.builder()
        .limit(20)
        .startingAfter(last.id())
        .build();

    var next = practice.patients().list(nextParams);
}

PatientListParams syncParams = PatientListParams.builder()
    .limit(100)
    .build();

var patients = practice.patients().iterate(syncParams);

for (var patient : patients) {
    syncPatient(patient);
}
```

## Handle errors

API failures expose status, code, request ID, retryability, and an optional retry delay in seconds.
Log those fields without logging patient data or credentials. Transport failures remain distinguishable from API responses.

```java
try {
    practice.patients().get(patientId);
} catch (AffinityException error) {
    System.err.printf("status=%d code=%s request=%s retryable=%s retryAfter=%s%n",
        error.status(), error.code(), error.requestId(),
        error.retryable(), error.retryAfter());
}
```

Retryability is a transport hint, not permission to repeat a clinical action with a new key.
Keep the same key and body for an uncertain write. Validation and authorization errors require a corrected request.
See [API errors](https://docs.joinaffinityai.com/errors/) for recovery guidance.

## Platform directory and webhooks

Use the root platform client to list its practices and webhook endpoints. These calls do not need a target practice or an idempotency key.
The webhook list belongs to the platform itself. Access to another organization's endpoints still requires an explicit grant.

```java
PracticeListParams practiceParams = PracticeListParams.builder()
    .limit(20)
    .build();

var practices = api.practices().list(practiceParams);
var selected = api.practices().get(practiceId);

WebhookEndpointListParams endpointParams = WebhookEndpointListParams.builder()
    .limit(20)
    .build();

var endpoints = api.webhooks().endpoints().list(endpointParams);
```

## More resources

Use the same conventions for addresses, allergies, locations, team members, and nested order resources.
[API reference](https://docs.joinaffinityai.com/api/) · [Webhooks](https://docs.joinaffinityai.com/guides/webhooks/)
