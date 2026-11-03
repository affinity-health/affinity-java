# Reference
## Account
<details><summary><code>client.account.get() -> Account</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Read the organization and Test or Live mode selected by the API key.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.account().get();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Feedback
<details><summary><code>client.feedback.create(request) -> CreateFeedbackResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Send feedback without credentials, or with an API key to include its organization and mode. Do not include patient information. API-key callers are limited to 10 submissions per hour per key. Anonymous callers are limited to 10 submissions per hour per IP address. A 429 response includes Retry-After in seconds.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.feedback().create(
    CreateFeedbackRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .message("The error does not explain which field is invalid.")
        .pageUrl("https://docs.affinityrx.com/errors/")
        .requestId("6e562761-eff3-4626-a8b9-25ce7c670ccd")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `String` — A unique key per operation, 1 to 255 printable ASCII characters without spaces. Retry the same key and body to avoid repeating the action. The replay response depends on the operation. See https://docs.affinityrx.com/guides/#retry-safely.
    
</dd>
</dl>

<dl>
<dd>

**message:** `String` — Text with at least one visible character.
    
</dd>
</dl>

<dl>
<dd>

**pageUrl:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**requestId:** `Optional<String>` — The `requestId` of the response, as the API returned it: a UUID or its `req_` form.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Medications
<details><summary><code>client.medications.list() -> SyncPagingIterable&amp;lt;Medication&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Every medication you can order in the current mode, A to Z by name, then by ID. Send query to find medications by name: every word must appear in the name, so check the spelling when nothing matches. Then choose by name, strength, form and pharmacy. Send practiceId to list what that practice can order, at its prices; without it, the caller's organization is used. Prices are in cents. `requirements` names the optional prescription fields this pharmacy requires; `compoundingReasons` and `quantities` list the accepted values when the pharmacy limits them, counted in `quantityUnit`. With a `fill`, `price` is per fill and each quantity counts `quantityUnit`, not fills: it is a whole number of fills in units. For a fill of 30 tablets, quantity 60 is two fills. For vials, quantity 1 is one vial and quantity 2 is two vials. A 2 mL vial lists quantities 1–10; its volume is separate from its quantity.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.medications().list(
    ListMedicationsRequest
        .builder()
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**practiceId:** `Optional<String>` — Quote prices and availability for this practice. A platform may select only its own child practices; a practice may select only itself. Omit to use the caller's organization.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Maximum records per page, from 1 to 100. Defaults to 25.
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` — Page forward using the previous response's nextCursor. Keep the same filters, sort, organization and mode.
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<String>` — Match medication names that contain every word of this text, in any order, ignoring case and accents. Each word must appear in the name, so a misspelled word matches nothing. Strength, form and pharmacy are not searched. An empty query lists every medication. Restart pagination after changing query.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.medications.get(medicationId) -> GetMedicationsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Read one available medication, its pricing, and pharmacy details for the current organization and mode. Pass expand=variants to include its other strengths, forms and pharmacies.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.medications().get(
    "med_01j2y8m6jcc9tt24af5pw9x1bc",
    GetMedicationsRequest
        .builder()
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**medicationId:** `String` — The medication ID.
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `Optional<String>` — Quote prices and availability for this practice. A platform may select only its own child practices; a practice may select only itself. Omit to use the caller's organization.
    
</dd>
</dl>

<dl>
<dd>

**expand:** `Optional<GetMedicationsRequestExpandItem>` — Add related records to the response. `variants` adds the medication's other strengths, forms and pharmacies.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Orders
<details><summary><code>client.orders.list() -> SyncPagingIterable&amp;lt;Order&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List accessible orders in the current mode, newest first. `externalOrderId` matches exactly, including case. `updatedAfter` accepts an ISO 8601 timestamp with a timezone and returns strictly later updates. Keep filters fixed while paging. `sort` takes `patient` (lowercase firstName + space + lastName A to Z, then order ID) or `created` (oldest first); a `_desc` suffix reverses. Creation time or patient name and the order ID determine cursor order, even when updatedAt changes.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().list(
    ListOrdersRequest
        .builder()
        .patientId("pat_01j2y8m6jcc9tt24af5pw9x1bc")
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Integer>` — Maximum records per page, from 1 to 100. Defaults to 25.
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` — Page forward using the previous response's nextCursor. Keep the same filters, sort, organization and mode.
    
</dd>
</dl>

<dl>
<dd>

**externalOrderId:** `Optional<String>` — Match the external order ID exactly, including case. Combine with practiceId when your platform reuses IDs across practices.
    
</dd>
</dl>

<dl>
<dd>

**updatedAfter:** `Optional<OffsetDateTime>` — Return orders whose updatedAt is strictly later than this ISO 8601 timestamp. Sorting stays by creation time and ID unless sort is supplied. Keep this cutoff unchanged while paging.
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `Optional<String>` — Limit results to the patient with this pat_ ID.
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `Optional<String>` — Limit results to the practice with this prac_ ID, within your authorized practices.
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<String>` — Search saved order snapshots: patient names, email, phone and external ID; order external ID; prescriber name and NPI; medication names and brands; pharmacy name. Whole ord_ and pat_ IDs and six-character order numbers also match. Text matches ignore case and allow substrings, word prefixes and similar spellings for alphanumeric words of four or more characters. Every one of the first eight words containing letters or numbers must match; punctuation-only words are ignored. An empty or punctuation-only query leaves the list unfiltered. Date of birth, separate strength fields, practice names, prac_ IDs and rx_ IDs are not searched. Restart pagination when filters change.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<ListOrdersRequestStatus>` — Return only orders with this status. Omit to include all statuses.
    
</dd>
</dl>

<dl>
<dd>

**cancelRequested:** `Optional<ListOrdersRequestCancelRequested>` — true returns only submitted or processing orders with a cancel the pharmacy has not confirmed yet (cancelRequestedAt set). false leaves those orders out. Omit to include both.
    
</dd>
</dl>

<dl>
<dd>

**recentlyShipped:** `Optional<ListOrdersRequestRecentlyShipped>` — true returns only orders whose status is shipped and that shipped in the last 60 days; delivered orders are excluded. false leaves those orders out. Omit to include both.
    
</dd>
</dl>

<dl>
<dd>

**sort:** `Optional<ListOrdersRequestSort>` — patient sorts the lowercase text firstName + space + lastName A to Z, then order ID; created sorts oldest first. A _desc suffix reverses the order. Defaults to created_desc. Restart pagination after changing sort.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.create(request) -> Order</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

One request creates the order, signs it and sends it to the pharmacy. Platforms must send practiceId; practice callers can omit it to use their own practice. With an API key, name the prescriber and send signatureAttestation. Optional prescriber phone and address each default to the practice; no account is looked up by NPI. In the app, the signed-in member signs with the NPI in their settings, or names the prescriber with the same attestation. With patient.id (a pat_ ID) or patient.externalId, the order reuses that patient of the practice and mode and updates the saved record; without them, each order creates a new patient. If id and externalId identify different patients, the request returns 422 invalid_order. When the pharmacy already holds the patient's name, a different firstName or lastName returns 422 invalid_order. Live orders require Live access on the practice and its platform. No payment method is required.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().create(
    OrderInput
        .builder()
        .idempotencyKey("Idempotency-Key")
        .patient(
            PatientInput
                .builder()
                .address(
                    AddressInput
                        .builder()
                        .line1("line1")
                        .city("city")
                        .state("state")
                        .postalCode("postalCode")
                        .build()
                )
                .dateOfBirth("dateOfBirth")
                .email("email")
                .firstName("firstName")
                .sex(PatientInputSex.FEMALE)
                .lastName("lastName")
                .phone("phone")
                .allergies(
                    Arrays.asList(
                        PatientInputAllergiesItem
                            .builder()
                            .category(PatientInputAllergiesItemCategory.DRUG)
                            .display("display")
                            .build()
                    )
                )
                .build()
        )
        .shipping(
            OrderInputShipping
                .builder()
                .optionId("shp_01j2y8m6jcc9tt24af5pw9x1bc")
                .build()
        )
        .signatureAttestation(true)
        .prescriptions(
            Arrays.asList(
                PrescriptionInput
                    .builder()
                    .directions("directions")
                    .medicationId("med_01j2y8m6jcc9tt24af5pw9x1bc")
                    .quantity(1)
                    .refills(1)
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `String` — A unique key per operation, 1 to 255 printable ASCII characters without spaces. Retry the same key and body to avoid repeating the action. The replay response depends on the operation. See https://docs.affinityrx.com/guides/#retry-safely.
    
</dd>
</dl>

<dl>
<dd>

**externalOrderId:** `Optional<String>` — Your order identifier, unique within the practice and mode. A failed or cancelled order keeps it, so send a new one for a replacement order.
    
</dd>
</dl>

<dl>
<dd>

**patient:** `PatientInput` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `Optional<String>` — Required with a platform API key. Send a child practice ID. Independent practice keys can omit this field to use their own practice.
    
</dd>
</dl>

<dl>
<dd>

**prescriber:** `Optional<PrescriberInput>` 
    
</dd>
</dl>

<dl>
<dd>

**prescriptions:** `List<PrescriptionInput>` — The 1 to 20 prescriptions approved for this patient.
    
</dd>
</dl>

<dl>
<dd>

**shipping:** `OrderInputShipping` — The shipping option and destination.
    
</dd>
</dl>

<dl>
<dd>

**signatureAttestation:** `Boolean` — Must be true to attest that the named prescriber approved and signed these prescriptions.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.get(orderId) -> Order</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Read one order and its prescriptions in the API key's organization and mode.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().get(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    GetOrdersRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**orderId:** `String` — The order ID.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.cancel(orderId) -> Order</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

200 with status cancelled when the cancel is confirmed. 202 with cancelRequestedAt when the pharmacy has not confirmed yet: you get order.cancelled when it confirms, or, when it refuses, cancelRequestedAt becomes null and you get order.updated. If an earlier ask may have reached the pharmacy, a refusal keeps cancelRequestedAt and sends no event until the pharmacy ends the order (order.cancelled or order.shipped). 409 cannot_cancel when the order is shipped, delivered or failed. 409 cancel_refused when the pharmacy refused the cancel, or when Affinity could not reach the pharmacy; only the second says to retry with a new Idempotency-Key.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().cancel(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    CancelOrdersRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**orderId:** `String` — The order ID.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` — A unique key per operation, 1 to 255 printable ASCII characters without spaces. Retry the same key and body to avoid repeating the action. The replay response depends on the operation. See https://docs.affinityrx.com/guides/#retry-safely.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Practices
<details><summary><code>client.practices.list() -> SyncPagingIterable&amp;lt;Practice&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List the platform's practices, newest first. Available to platforms only. `sort` takes `name` or `location` (A to Z, practices without a location last), `mode` (without Live access, then with it) or `created` (oldest first); a `_desc` suffix reverses.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.practices().list(
    ListPracticesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Integer>` — Maximum records per page, from 1 to 100. Defaults to 25.
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` — Page forward using the previous response's nextCursor. Keep the same filters, sort, organization and mode.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — Match the external practice ID exactly, including case. Keep this filter unchanged while paging.
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<String>` — Match practice names containing this text, ignoring case. Restart pagination after changing query.
    
</dd>
</dl>

<dl>
<dd>

**sort:** `Optional<ListPracticesRequestSort>` — name and location sort A to Z; mode sorts practices without Live access before those with it; created sorts oldest first. A _desc suffix reverses the order. Defaults to created_desc. Missing locations sort last. Restart pagination after changing sort.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.practices.create(request) -> Practice</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Platforms only. Name, phone and address are required. The practice starts in Test; `liveEnabled: true` also allows new Live orders, which needs a platform with Live access and a Live caller: a Live key, or a session in Live mode. Turning Live off later preserves access to existing records. A retry with the same key and body returns the stored first response, even if the practice has changed. Use GET /v1/practices/{practiceId} to read the current practice.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.practices().create(
    CreatePracticesRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .address(
            PracticeAddressInput
                .builder()
                .line1("line1")
                .city("city")
                .state("state")
                .postalCode("postalCode")
                .build()
        )
        .name("name")
        .phone("phone")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `String` — A unique key per operation, 1 to 255 printable ASCII characters without spaces. Retry the same key and body to avoid repeating the action. The replay response depends on the operation. See https://docs.affinityrx.com/guides/#retry-safely.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — Your practice identifier, unique among your platform's active practices.
    
</dd>
</dl>

<dl>
<dd>

**address:** `PracticeAddressInput` 
    
</dd>
</dl>

<dl>
<dd>

**liveEnabled:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` — The practice name. PerfectRx prints it: use Windows-1252 characters, without < or >.
    
</dd>
</dl>

<dl>
<dd>

**phone:** `String` — A US phone number: 10 digits, with or without +1 or 1 before them. Spaces, dashes, dots and parentheses are allowed, such as (512) 555-0100. Affinity stores and returns +15125550100.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.practices.get(practiceId) -> Practice</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Read one practice accessible to the API key. A platform can read its own practices.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.practices().get(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    GetPracticesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**practiceId:** `String` — The practice ID.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.practices.update(practiceId, request) -> Practice</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

`liveEnabled` allows or refuses new Live orders. Existing records, cancellation, webhooks and billing keep working. Only its platform changes it; enabling requires platform Live access, and either change needs a Live caller: a Live key (403 live_key_required otherwise) or a session in Live mode (403 live_mode_required otherwise). Live orders send `name`, `phone` and `address` to the pharmacy, so a practice with Live access changes them only in Live mode, with a Live key or a session in Live mode (403 live_mode_required otherwise). A retry with the same key and body returns the stored first response, even if the practice has changed. Use GET /v1/practices/{practiceId} to read the current practice.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.practices().update(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdatePracticesRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**practiceId:** `String` — The practice ID.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` — A unique key per operation, 1 to 255 printable ASCII characters without spaces. Retry the same key and body to avoid repeating the action. The replay response depends on the operation. See https://docs.affinityrx.com/guides/#retry-safely.
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — Your practice identifier, unique among your platform's active practices. Send null to clear it.
    
</dd>
</dl>

<dl>
<dd>

**address:** `Optional<UpdatePracticesRequestAddress>` — Affinity merges the address parts you send into the saved address. An omitted part keeps its saved value. To move to an address with no suite, send `"line2": null` with the new `line1`, `city`, `state` and `postalCode`. PerfectRx prints it: use Windows-1252 characters, without < or >. Line 1 and line 2 together: 70 characters or fewer.
    
</dd>
</dl>

<dl>
<dd>

**liveEnabled:** `Optional<Boolean>` — Omit it or send null to leave Live unchanged.
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` — The practice name. PerfectRx prints it: use Windows-1252 characters, without < or >.
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` — A US phone number: 10 digits, with or without +1 or 1 before them. Spaces, dashes, dots and parentheses are allowed, such as (512) 555-0100. Affinity stores and returns +15125550100. Empty text counts as null.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Webhooks
<details><summary><code>client.webhooks.list() -> SyncPagingIterable&amp;lt;WebhookEndpoint&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List webhook endpoints owned by the API key's organization in its current mode. Signing secrets are not returned.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().list(
    ListWebhooksRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Integer>` — Maximum records per page, from 1 to 100. Defaults to 25.
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` — Page forward using the previous response's nextCursor. Keep the same filters, sort, organization and mode.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.create(request) -> CreateWebhooksResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Platforms and independent practices can register up to 16 public HTTPS endpoints per mode. An API key acts only for its own organization and mode. Every event goes to every endpoint. The signing secret is returned by creation and its idempotent replay for 24 hours.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().create(
    CreateWebhooksRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .url("url")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `String` — A unique key per operation, 1 to 255 printable ASCII characters without spaces. Retry the same key and body to avoid repeating the action. The replay response depends on the operation. See https://docs.affinityrx.com/guides/#retry-safely.
    
</dd>
</dl>

<dl>
<dd>

**url:** `String` — The public HTTPS URL that receives webhook events.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.remove(webhookEndpointId) -> RemoveWebhooksResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Events not delivered to it yet are dropped.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().remove(
    "whe_01j2y8m6jcc9tt24af5pw9x1bc",
    RemoveWebhooksRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**webhookEndpointId:** `String` — The webhook endpoint ID.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.update(webhookEndpointId, request) -> WebhookEndpoint</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

The signing secret stays the same.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().update(
    "whe_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdateWebhooksRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .url("url")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**webhookEndpointId:** `String` — The webhook endpoint ID.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` — A unique key per operation, 1 to 255 printable ASCII characters without spaces. Retry the same key and body to avoid repeating the action. The replay response depends on the operation. See https://docs.affinityrx.com/guides/#retry-safely.
    
</dd>
</dl>

<dl>
<dd>

**url:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.resendFailed(webhookEndpointId) -> ResendFailedWebhooksResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Queue failed order event deliveries from the last 30 days for this endpoint. Only the current organization and mode apply. Each failed delivery gets up to 12 new attempts. Also make pending deliveries waiting on a later retry due now, without resetting their attempt counts. Keep the same event IDs, payloads, and per-order delivery sequence. The queued count includes both kinds. Pending deliveries already due, delivered events, and one-time test events stay unchanged. Send a unique Idempotency-Key for each request. Reuse that key after an uncertain response to return the original count. A request with a new key returns 0 when no eligible failures or pending deliveries waiting on a later retry remain.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().resendFailed(
    "whe_01j2y8m6jcc9tt24af5pw9x1bc",
    ResendFailedWebhooksRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**webhookEndpointId:** `String` — The webhook endpoint ID.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` — A unique key per operation, 1 to 255 printable ASCII characters without spaces. Retry the same key and body to avoid repeating the action. The replay response depends on the operation. See https://docs.affinityrx.com/guides/#retry-safely.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

