# Reference
## Locations
<details><summary><code>client.locations.listPracticeLocations(practiceId) -> ListPracticeLocationsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires locations:read on a practice key or an authorized platform key. Lists active and archived locations by name, with cursor pagination. Use status to filter. Location records are shared between Test and Live for the same practice.
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
client.locations().listPracticeLocations(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    ListPracticeLocationsRequest
        .builder()
        .startingAfter("loc_01j2y8m6jcc9tt24af5pw9x1bc")
        .endingBefore("loc_01j2y8m6jcc9tt24af5pw9x1bc")
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<ListPracticeLocationsRequestStatus>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.locations.createPracticeLocation(practiceId, request) -> CreatePracticeLocationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires locations:write and Idempotency-Key for API keys. Creates an active location with a unique name in this practice. Locations are shared between Test and Live. Use the returned ID for Team location access.
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
client.locations().createPracticeLocation(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    CreatePracticeLocationRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .name("name")
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**city:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**country:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**line1:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**line2:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**postalCode:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**state:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**timezone:** `Optional<String>` — Optional IANA timezone override. Omit to leave unchanged; null clears it. No timezone is inferred when creating a record.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.locations.getPracticeLocation(practiceId, locationId) -> GetPracticeLocationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires locations:read. Returns one active or archived location in the authorized practice.
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
client.locations().getPracticeLocation(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "loc_01j2y8m6jcc9tt24af5pw9x1bc",
    GetPracticeLocationRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.locations.updatePracticeLocation(practiceId, locationId, request) -> UpdatePracticeLocationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires locations:write and Idempotency-Key for API keys. Updates only supplied fields; null clears optional contact and address fields. Archived locations cannot be updated. Changes apply to both Test and Live.
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
client.locations().updatePracticeLocation(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "loc_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdatePracticeLocationRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**city:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**country:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**line1:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**line2:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**postalCode:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**state:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**timezone:** `Optional<String>` — Optional IANA timezone override. Omit to leave unchanged; null clears it. No timezone is inferred when creating a record.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.locations.archivePracticeLocation(practiceId, locationId) -> ArchivePracticeLocationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires locations:write and Idempotency-Key for API keys. Retains the location and historical associations. Archived locations cannot receive new Team assignments. Repeating archive returns the archived location. Changes apply to both Test and Live.
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
client.locations().archivePracticeLocation(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "loc_01j2y8m6jcc9tt24af5pw9x1bc",
    ArchivePracticeLocationRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## API Keys
<details><summary><code>client.apiKeys.createPlatformPracticeApiKey(practiceId, request) -> CreatePlatformPracticeApiKeyResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a practice API key for a connected practice. Requires a platform key with service_keys:write and every requested scope. The practice key uses the platform key's Test or Live mode and cannot outlive it. Requires Idempotency-Key for safe retries; the secret is returned in the encrypted replay response for 24 hours.
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
client.apiKeys().createPlatformPracticeApiKey(
    "practiceId",
    CreatePlatformPracticeApiKeyRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .name("name")
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**allowedIps:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**expiresAt:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**scopes:** `Optional<List<CreatePlatformPracticeApiKeyRequestScopesItem>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.apiKeys.getApiAccess() -> GetApiAccessResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the subject, mode, and scopes for the API key.
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
client.apiKeys().getApiAccess();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Account
<details><summary><code>client.account.getAccount() -> GetAccountResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the platform organization, request livemode, and effective access. API keys report scopes and the service_key role; dashboard sessions report membership permissions. operatingMode describes organization Live access, not the credential's Test/Live mode.
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
client.account().getAccount(
    GetAccountRequest
        .builder()
        .orgId("acct_01j2y8m6jcc9tt24af5pw9x1bc")
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

**orgId:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Catalog
<details><summary><code>client.catalog.listCatalogItems() -> ListCatalogItemsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists catalog items for the authenticated account and mode. Use view=medications for priced prescription groups with offer counts, pharmacy counts, and strengths; the default view=offers returns individual offers. Use relatedToCatalogItemId to find offers for the same medication and route. When practiceId is supplied, a practice price overrides the platform price and missing overrides inherit the platform price.
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
client.catalog().listCatalogItems(
    ListCatalogItemsRequest
        .builder()
        .relatedToCatalogItemId("cat_01j2y8m6jcc9tt24af5pw9x1bc")
        .catalogItemId("cat_01j2y8m6jcc9tt24af5pw9x1bc")
        .pharmacyIds(
            ListCatalogItemsRequestPharmacyIds.of("pharm_01j2y8m6jcc9tt24af5pw9x1bc")
        )
        .endingBefore("cat_01j2y8m6jcc9tt24af5pw9x1bc")
        .orgId("acct_01j2y8m6jcc9tt24af5pw9x1bc")
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .startingAfter("cat_01j2y8m6jcc9tt24af5pw9x1bc")
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

**view:** `Optional<ListCatalogItemsRequestView>` 
    
</dd>
</dl>

<dl>
<dd>

**relatedToCatalogItemId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**catalogKind:** `Optional<ListCatalogItemsRequestCatalogKind>` 
    
</dd>
</dl>

<dl>
<dd>

**sort:** `Optional<ListCatalogItemsRequestSort>` 
    
</dd>
</dl>

<dl>
<dd>

**catalogItemId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**availability:** `Optional<ListCatalogItemsRequestAvailability>` 
    
</dd>
</dl>

<dl>
<dd>

**pharmacyIds:** `Optional<ListCatalogItemsRequestPharmacyIds>` 
    
</dd>
</dl>

<dl>
<dd>

**dosageForms:** `Optional<ListCatalogItemsRequestDosageForms>` 
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**hideControlledSubstances:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**hideUnpriced:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**requirement:** `Optional<ListCatalogItemsRequestRequirement>` 
    
</dd>
</dl>

<dl>
<dd>

**routes:** `Optional<ListCatalogItemsRequestRoutes>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.catalog.listPharmacies() -> ListPharmaciesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists pharmacies available to the authenticated account, including approved invite-only relationships.
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
client.catalog().listPharmacies(
    ListPharmaciesRequest
        .builder()
        .endingBefore("pharm_01j2y8m6jcc9tt24af5pw9x1bc")
        .orgId("acct_01j2y8m6jcc9tt24af5pw9x1bc")
        .pharmacyId("pharm_01j2y8m6jcc9tt24af5pw9x1bc")
        .startingAfter("pharm_01j2y8m6jcc9tt24af5pw9x1bc")
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

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**orgId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**pharmacyId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**shipsToState:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.catalog.listShippingOptions(catalogItemId) -> List&amp;lt;ListShippingOptionsResponseItem&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns an array of at most 50 reviewed shipping services eligible for a catalog item, destination, and API mode. destinationState must be a USPS state or territory code. Each option has one temperature; pharmacy catalog summaries list all supported temperatures.
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
client.catalog().listShippingOptions(
    "cat_01j2y8m6jcc9tt24af5pw9x1bc",
    ListShippingOptionsRequest
        .builder()
        .destinationState("destinationState")
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

**catalogItemId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**destinationState:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**destinationType:** `Optional<ListShippingOptionsRequestDestinationType>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.catalog.retrievePrescribingOptions(catalogItemId) -> RetrievePrescribingOptionsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires catalog:read. Returns reviewed SIG presets, guided patterns, quantity constraints and product requirements for a practice and mode. Revisions identify changed defaults. No patient-specific rationale or diagnosis is inferred.
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
client.catalog().retrievePrescribingOptions(
    "cat_01j2y8m6jcc9tt24af5pw9x1bc",
    RetrievePrescribingOptionsRequest
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

**catalogItemId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Orders
<details><summary><code>client.orders.listOrders() -> ListOrdersResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().listOrders(
    ListOrdersRequest
        .builder()
        .endingBefore("ord_01j2y8m6jcc9tt24af5pw9x1bc")
        .orderId("ord_01j2y8m6jcc9tt24af5pw9x1bc")
        .patientId("pat_01j2y8m6jcc9tt24af5pw9x1bc")
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .startingAfter("ord_01j2y8m6jcc9tt24af5pw9x1bc")
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

**query:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**externalOrderId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**createdAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**createdBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**orderId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**patientExternalId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**sort:** `Optional<ListOrdersRequestSort>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<ListOrdersRequestStatus>` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.createOrder(request) -> CreateOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates one unsigned order with 1–20 prescriptions for one patient in one practice. Supply patientId or patient; inline patient creation requires patients:write. Prescriber is optional: select by npi, provider id, or integration-scoped externalId, or leave the draft unassigned until signing. First-use prescriber registration requires team:write. Legacy userId is supported but cannot be combined with prescriber. Idempotency-Key is required.
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
client.orders().createOrder(
    CreateOrderRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .prescriptions(
            Arrays.asList(
                CreateOrderRequestPrescriptionsItem
                    .builder()
                    .daysSupply(1)
                    .dispensing(
                        CreateOrderRequestPrescriptionsItemDispensing
                            .builder()
                            .build()
                    )
                    .directions("directions")
                    .medicationId("cat_01j2y8m6jcc9tt24af5pw9x1bc")
                    .quantity(
                        CreateOrderRequestPrescriptionsItemQuantity.of(CreateOrderRequestPrescriptionsItemQuantityOne.INFINITY)
                    )
                    .quantityUnit("quantityUnit")
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

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**prescriber:** `Optional<CreateOrderRequestPrescriber>` 
    
</dd>
</dl>

<dl>
<dd>

**otcItems:** `Optional<List<CreateOrderRequestOtcItemsItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**externalOrderId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**metadata:** `Optional<Map<String, Optional<CreateOrderRequestMetadataValue>>>` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**patient:** `Optional<CreateOrderRequestPatient>` 
    
</dd>
</dl>

<dl>
<dd>

**shippingAddressId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**prescriptions:** `List<CreateOrderRequestPrescriptionsItem>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.getOrder(orderId) -> GetOrderResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().getOrder(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    GetOrderRequest
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

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.cancelOrder(orderId, request) -> CancelOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requests cancellation. HTTP 200 means the request was handled; check cancellation.status for confirmed, pending, partial, or failed. Only confirmed means the entire order is cancelled. Shipment possession makes a fulfillment cancellation too late.
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
client.orders().cancelOrder(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    CancelOrderRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .reason("reason")
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

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>

<dl>
<dd>

**reason:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.actOnOrderException(orderId, exceptionId, request) -> ActOnOrderExceptionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Acknowledge, retry, contact, or resolve an order exception in the credential's Test/Live mode. assign_to_me requires a signed-in dashboard user; API keys receive 400 and may use acknowledge instead. Actor headers do not create a dashboard assignee.
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
client.orders().actOnOrderException(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    "fex_01j2y8m6jcc9tt24af5pw9x1bc",
    ActOnOrderExceptionRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .action(ActOnOrderExceptionRequestAction.ACKNOWLEDGE)
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

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**exceptionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>

<dl>
<dd>

**action:** `ActOnOrderExceptionRequestAction` 
    
</dd>
</dl>

<dl>
<dd>

**note:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.listOrderEvents(orderId) -> ListOrderEventsResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().listOrderEvents(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    ListOrderEventsRequest
        .builder()
        .endingBefore("evt_01j2y8m6jcc9tt24af5pw9x1bc")
        .startingAfter("evt_01j2y8m6jcc9tt24af5pw9x1bc")
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

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.getOrderTestSimulation(orderId) -> GetOrderTestSimulationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires orders:write. Available only in Test mode.
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
client.orders().getOrderTestSimulation(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    GetOrderTestSimulationRequest
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

**orderId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.updateOrderTestSimulation(orderId, request) -> UpdateOrderTestSimulationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires orders:write and Idempotency-Key. Configure before submission or queue a valid pharmacy event in manual mode. Events use normal order history and Test webhooks. Live requests are rejected.
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
client.orders().updateOrderTestSimulation(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdateOrderTestSimulationRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .mode(UpdateOrderTestSimulationRequestMode.AUTOMATIC)
        .scenario(UpdateOrderTestSimulationRequestScenario.SUCCESSFUL)
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

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**mode:** `UpdateOrderTestSimulationRequestMode` 
    
</dd>
</dl>

<dl>
<dd>

**scenario:** `UpdateOrderTestSimulationRequestScenario` 
    
</dd>
</dl>

<dl>
<dd>

**action:** `Optional<UpdateOrderTestSimulationRequestAction>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.previewOrder(request) -> PreviewOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires orders:write and catalog:read. Supply exactly one of patientId, patientExternalId, or inline patient details. External-ID lookup additionally requires patients:read; inline details require patients:write. Resolves defaults and explicit edits for 1–20 prescriptions. Reuses stored patient details when identifiers match; otherwise previews inline details without creating a patient. Complete previews contain an orders.create input. Does not create records, reserve prices, sign, charge or transmit. No idempotency key is required. Creation and signing recheck current requirements.
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
client.orders().previewOrder(
    PreviewOrderRequest
        .builder()
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .prescriptions(
            Arrays.asList(
                PreviewOrderRequestPrescriptionsItem
                    .builder()
                    .medicationId("cat_01j2y8m6jcc9tt24af5pw9x1bc")
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

**otcItems:** `Optional<List<PreviewOrderRequestOtcItemsItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**patientExternalId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**patient:** `Optional<PreviewOrderRequestPatient>` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**prescriber:** `Optional<PreviewOrderRequestPrescriber>` 
    
</dd>
</dl>

<dl>
<dd>

**shippingAddressId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**externalOrderId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**prescriptions:** `List<PreviewOrderRequestPrescriptionsItem>` 
    
</dd>
</dl>

<dl>
<dd>

**shipping:** `Optional<PreviewOrderRequestShipping>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.signOrder(orderId, request) -> SignOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires orders:sign, Idempotency-Key, signatureAttestation, and expectedRevision from the reviewed order. Existing integrations may send expectedVersions instead; supply exactly one. A stale revision returns 409 and requires renewed clinician review. Select prescriber by npi, provider id, or integration-scoped externalId, or inherit the draft's prescriber. First-use registration requires team:write. Actor headers are optional audit metadata with prescriber; legacy userId requires matching clinician actor headers. Signing does not submit to a pharmacy.
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
client.orders().signOrder(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    SignOrderRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .signatureAttestation(true)
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

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**prescriber:** `Optional<SignOrderRequestPrescriber>` 
    
</dd>
</dl>

<dl>
<dd>

**signatureAttestation:** `Boolean` 
    
</dd>
</dl>

<dl>
<dd>

**expectedRevision:** `Optional<String>` — Opaque revision of the complete order prescription set. Send the revision you reviewed as expectedRevision; never replace it automatically after a conflict.
    
</dd>
</dl>

<dl>
<dd>

**expectedVersions:** `Optional<List<SignOrderRequestExpectedVersionsItem>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.signAndSubmitOrder(orderId, request) -> SignAndSubmitOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires orders:sign, Idempotency-Key, signatureAttestation, and expectedRevision from the reviewed order. Existing integrations may send expectedVersions instead; supply exactly one. A stale revision returns 409 and requires renewed clinician review. Select prescriber by npi, provider id, or externalId, or inherit the draft's prescriber. First-use registration requires team:write. Actor headers are optional with prescriber; legacy userId requires matching clinician actor headers. Signs the complete order, then attempts each submission. Signing remains committed if submission fails. Replay the same key after an uncertain response; retry reported submission failures through Submit order with a new key. Submitted means queued, not pharmacy acceptance.
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
client.orders().signAndSubmitOrder(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    SignAndSubmitOrderRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .signatureAttestation(true)
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

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**prescriber:** `Optional<SignAndSubmitOrderRequestPrescriber>` 
    
</dd>
</dl>

<dl>
<dd>

**signatureAttestation:** `Boolean` 
    
</dd>
</dl>

<dl>
<dd>

**expectedRevision:** `Optional<String>` — Opaque revision of the complete order prescription set. Send the revision you reviewed as expectedRevision; never replace it automatically after a conflict.
    
</dd>
</dl>

<dl>
<dd>

**expectedVersions:** `Optional<List<SignAndSubmitOrderRequestExpectedVersionsItem>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.submitOrder(orderId, request) -> SubmitOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires orders:sign and Idempotency-Key. Queues signed prescriptions after rechecking authorization, signature integrity, billing, and fulfillment eligibility. Track pharmacy acceptance through order reads and webhooks. After a partial failure, retry submission with a new idempotency key; already queued prescriptions are not duplicated.
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
client.orders().submitOrder(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    SubmitOrderRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
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

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**prescriber:** `Optional<SubmitOrderRequestPrescriber>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.rejectOrder(orderId, request) -> RejectOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires orders:sign and Idempotency-Key. Select a prescriber or inherit the draft's prescriber. Legacy userId requires matching clinician actor headers. Supply expectedRevision from the reviewed order, or expectedVersions for existing integrations. Permanently rejects the complete unsigned order after checking its revision.
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
client.orders().rejectOrder(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    RejectOrderRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .reason("reason")
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

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**prescriber:** `Optional<RejectOrderRequestPrescriber>` 
    
</dd>
</dl>

<dl>
<dd>

**reason:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**expectedRevision:** `Optional<String>` — Opaque revision of the complete order prescription set. Send the revision you reviewed as expectedRevision; never replace it automatically after a conflict.
    
</dd>
</dl>

<dl>
<dd>

**expectedVersions:** `Optional<List<RejectOrderRequestExpectedVersionsItem>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.addOrderPrescription(orderId, request) -> AddOrderPrescriptionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires orders:write, Idempotency-Key and expectedRevision from the order being edited. Existing integrations may send expectedVersions instead; supply exactly one. Adds a complete prescription to an unsigned Order and returns all new versions. Omitted actor context defaults to the authenticated service account as a system actor. Patient and prescriber attribution stay fixed. Signed orders cannot be amended through this endpoint. Signing and submission require orders:sign through their separate endpoints.
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
client.orders().addOrderPrescription(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    AddOrderPrescriptionRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .prescription(
            AddOrderPrescriptionRequestPrescription
                .builder()
                .daysSupply(1)
                .dispensing(
                    AddOrderPrescriptionRequestPrescriptionDispensing
                        .builder()
                        .build()
                )
                .directions("directions")
                .medicationId("cat_01j2y8m6jcc9tt24af5pw9x1bc")
                .quantity(
                    AddOrderPrescriptionRequestPrescriptionQuantity.of(AddOrderPrescriptionRequestPrescriptionQuantityOne.INFINITY)
                )
                .quantityUnit("quantityUnit")
                .refills(1)
                .build()
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

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>

<dl>
<dd>

**metadata:** `Optional<Map<String, Optional<AddOrderPrescriptionRequestMetadataValue>>>` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**expectedRevision:** `Optional<String>` — Opaque revision of the complete order prescription set. Send the revision you reviewed as expectedRevision; never replace it automatically after a conflict.
    
</dd>
</dl>

<dl>
<dd>

**expectedVersions:** `Optional<List<AddOrderPrescriptionRequestExpectedVersionsItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**prescription:** `AddOrderPrescriptionRequestPrescription` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.updateOrderPrescription(orderId, prescriptionId, request) -> UpdateOrderPrescriptionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires orders:write, Idempotency-Key and expectedRevision from the order being edited. Existing integrations may send expectedVersions instead; supply exactly one. Replaces one prescription with complete medication instructions and returns all new versions. Omitted actor context defaults to the authenticated service account as a system actor. Patient and prescriber attribution stay fixed. Signed orders cannot be amended through this endpoint. Signing and submission require orders:sign through their separate endpoints.
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
client.orders().updateOrderPrescription(
    "ord_01j2y8m6jcc9tt24af5pw9x1bc",
    "rx_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdateOrderPrescriptionRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .prescription(
            UpdateOrderPrescriptionRequestPrescription
                .builder()
                .daysSupply(1)
                .dispensing(
                    UpdateOrderPrescriptionRequestPrescriptionDispensing
                        .builder()
                        .build()
                )
                .directions("directions")
                .medicationId("cat_01j2y8m6jcc9tt24af5pw9x1bc")
                .quantity(
                    UpdateOrderPrescriptionRequestPrescriptionQuantity.of(UpdateOrderPrescriptionRequestPrescriptionQuantityOne.INFINITY)
                )
                .quantityUnit("quantityUnit")
                .refills(1)
                .build()
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

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**prescriptionId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>

<dl>
<dd>

**metadata:** `Optional<Map<String, Optional<UpdateOrderPrescriptionRequestMetadataValue>>>` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**expectedRevision:** `Optional<String>` — Opaque revision of the complete order prescription set. Send the revision you reviewed as expectedRevision; never replace it automatically after a conflict.
    
</dd>
</dl>

<dl>
<dd>

**expectedVersions:** `Optional<List<UpdateOrderPrescriptionRequestExpectedVersionsItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**prescription:** `UpdateOrderPrescriptionRequestPrescription` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.createOrderBatch(request) -> CreateOrderBatchResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates 1–20 orders for distinct patients in one practice, each with 1–20 prescriptions. Each accepts patientId or inline patient details. Orders and newly created patients commit atomically; any failure saves none. Requires orders:write and Idempotency-Key; inline patients also require patients:write. Omitted actor context defaults to the authenticated service account as a system actor. Sign and submit each resulting order separately using orders:sign.
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
client.orders().createOrderBatch(
    CreateOrderBatchRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .practiceId("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .orders(
            Arrays.asList(
                CreateOrderBatchRequestOrdersItem
                    .builder()
                    .prescriptions(
                        Arrays.asList(
                            CreateOrderBatchRequestOrdersItemPrescriptionsItem
                                .builder()
                                .daysSupply(1)
                                .dispensing(
                                    CreateOrderBatchRequestOrdersItemPrescriptionsItemDispensing
                                        .builder()
                                        .build()
                                )
                                .directions("directions")
                                .medicationId("cat_01j2y8m6jcc9tt24af5pw9x1bc")
                                .quantity(
                                    CreateOrderBatchRequestOrdersItemPrescriptionsItemQuantity.of(CreateOrderBatchRequestOrdersItemPrescriptionsItemQuantityOne.INFINITY)
                                )
                                .quantityUnit("quantityUnit")
                                .refills(1)
                                .build()
                        )
                    )
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

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**userId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**prescriber:** `Optional<CreateOrderBatchRequestPrescriber>` 
    
</dd>
</dl>

<dl>
<dd>

**orders:** `List<CreateOrderBatchRequestOrdersItem>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Webhooks
<details><summary><code>client.webhooks.listWebhookEndpoints() -> ListWebhookEndpointsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires webhooks:read. Returns endpoints owned by the key organization, or the organization selected with X-Affinity-Organization-Id. Platform delegation requires a webhook grant in the key's mode.
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
client.webhooks().listWebhookEndpoints(
    ListWebhookEndpointsRequest
        .builder()
        .endingBefore("whe_01j2y8m6jcc9tt24af5pw9x1bc")
        .startingAfter("whe_01j2y8m6jcc9tt24af5pw9x1bc")
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

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**affinityOrganizationId:** `Optional<String>` — Defaults to the API key organization. A platform may select a practice or pharmacy only with an explicit webhook grant in this mode. This changes the webhook owner, not the caller or event subscriptions.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.createWebhookEndpoint(request) -> CreateWebhookEndpointResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires webhooks:write and Idempotency-Key. Defaults to the API key organization. A platform can select a practice or pharmacy owner with X-Affinity-Organization-Id and an explicit webhook grant. For platform-owned endpoints, practiceIds narrows delivery to selected connected practices. An empty filter receives all otherwise-authorized events.
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
client.webhooks().createWebhookEndpoint(
    CreateWebhookEndpointRequest
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

**affinityOrganizationId:** `Optional<String>` — Defaults to the API key organization. A platform may select a practice or pharmacy only with an explicit webhook grant in this mode. This changes the webhook owner, not the caller or event subscriptions.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**practiceIds:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**payloadStyle:** `Optional<CreateWebhookEndpointRequestPayloadStyle>` 
    
</dd>
</dl>

<dl>
<dd>

**subscribedEvents:** `Optional<List<CreateWebhookEndpointRequestSubscribedEventsItem>>` 
    
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

<details><summary><code>client.webhooks.deleteWebhookEndpoint(endpointId) -> DeleteWebhookEndpointResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().deleteWebhookEndpoint(
    "whe_01j2y8m6jcc9tt24af5pw9x1bc",
    DeleteWebhookEndpointRequest
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

**endpointId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityOrganizationId:** `Optional<String>` — Defaults to the API key organization. A platform may select a practice or pharmacy only with an explicit webhook grant in this mode. This changes the webhook owner, not the caller or event subscriptions.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.updateWebhookEndpoint(endpointId, request) -> UpdateWebhookEndpointResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires webhooks:write and Idempotency-Key. Updates an endpoint in the selected organization and mode. Omitted practiceIds preserves the filter; an empty array removes the practice filter. Subscription changes apply to newly generated events.
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
client.webhooks().updateWebhookEndpoint(
    "whe_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdateWebhookEndpointRequest
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

**endpointId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityOrganizationId:** `Optional<String>` — Defaults to the API key organization. A platform may select a practice or pharmacy only with an explicit webhook grant in this mode. This changes the webhook owner, not the caller or event subscriptions.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**practiceIds:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**description:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**payloadStyle:** `Optional<UpdateWebhookEndpointRequestPayloadStyle>` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<UpdateWebhookEndpointRequestStatus>` 
    
</dd>
</dl>

<dl>
<dd>

**subscribedEvents:** `Optional<List<UpdateWebhookEndpointRequestSubscribedEventsItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**url:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.rotateWebhookEndpointSecret(endpointId) -> RotateWebhookEndpointSecretResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().rotateWebhookEndpointSecret(
    "whe_01j2y8m6jcc9tt24af5pw9x1bc",
    RotateWebhookEndpointSecretRequest
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

**endpointId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityOrganizationId:** `Optional<String>` — Defaults to the API key organization. A platform may select a practice or pharmacy only with an explicit webhook grant in this mode. This changes the webhook owner, not the caller or event subscriptions.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.testWebhookEndpoint(endpointId) -> TestWebhookEndpointResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().testWebhookEndpoint(
    "whe_01j2y8m6jcc9tt24af5pw9x1bc",
    TestWebhookEndpointRequest
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

**endpointId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityOrganizationId:** `Optional<String>` — Defaults to the API key organization. A platform may select a practice or pharmacy only with an explicit webhook grant in this mode. This changes the webhook owner, not the caller or event subscriptions.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.listWebhookEvents() -> ListWebhookEventsResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().listWebhookEvents(
    ListWebhookEventsRequest
        .builder()
        .endingBefore("evt_01j2y8m6jcc9tt24af5pw9x1bc")
        .startingAfter("evt_01j2y8m6jcc9tt24af5pw9x1bc")
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

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<ListWebhookEventsRequestStatus>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**affinityOrganizationId:** `Optional<String>` — Defaults to the API key organization. A platform may select a practice or pharmacy only with an explicit webhook grant in this mode. This changes the webhook owner, not the caller or event subscriptions.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.getWebhookEvent(eventId) -> GetWebhookEventResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().getWebhookEvent(
    "evt_01j2y8m6jcc9tt24af5pw9x1bc",
    GetWebhookEventRequest
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

**eventId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityOrganizationId:** `Optional<String>` — Defaults to the API key organization. A platform may select a practice or pharmacy only with an explicit webhook grant in this mode. This changes the webhook owner, not the caller or event subscriptions.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.replayWebhookEvent(eventId) -> ReplayWebhookEventResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.webhooks().replayWebhookEvent(
    "evt_01j2y8m6jcc9tt24af5pw9x1bc",
    ReplayWebhookEventRequest
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

**eventId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityOrganizationId:** `Optional<String>` — Defaults to the API key organization. A platform may select a practice or pharmacy only with an explicit webhook grant in this mode. This changes the webhook owner, not the caller or event subscriptions.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.listWebhookGrants() -> ListWebhookGrantsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires webhooks:read on the owning practice or pharmacy key. Lists platform webhook grants in the key's mode. Platforms cannot list or grant themselves delegated access.
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
client.webhooks().listWebhookGrants(
    ListWebhookGrantsRequest
        .builder()
        .startingAfter("acct_01j2y8m6jcc9tt24af5pw9x1bc")
        .endingBefore("acct_01j2y8m6jcc9tt24af5pw9x1bc")
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

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.saveWebhookGrant(platformId, request) -> SaveWebhookGrantResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires webhooks:write on the owning practice or pharmacy key and Idempotency-Key. Grants or replaces a platform's webhook permissions in this mode. A practice must already be connected to that platform. The grant does not give the platform access to other API resources.
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
client.webhooks().saveWebhookGrant(
    "acct_01j2y8m6jcc9tt24af5pw9x1bc",
    SaveWebhookGrantRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .scopes(
            Arrays.asList(SaveWebhookGrantRequestScopesItem.WEBHOOKS_READ)
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

**platformId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**scopes:** `List<SaveWebhookGrantRequestScopesItem>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.webhooks.revokeWebhookGrant(platformId) -> RevokeWebhookGrantResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires webhooks:write on the owning practice or pharmacy key and Idempotency-Key. Removes platform webhook access in this mode. Existing endpoints remain owned by the practice or pharmacy and continue operating.
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
client.webhooks().revokeWebhookGrant(
    "acct_01j2y8m6jcc9tt24af5pw9x1bc",
    RevokeWebhookGrantRequest
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

**platformId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Team
<details><summary><code>client.team.registerUser(practiceId, request) -> RegisterUserResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:write and Idempotency-Key. Registers a practice member without an invitation. Test requires synthetic .test emails and Affinity Test NPIs. Live requires approved integration and practice access. Identity attestation records the integration's assertion; it does not verify login email or clinical credentials. Existing memberships and verified provider records are preserved. Use the returned user ID for orders and signing.
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
client.team().registerUser(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    RegisterUserRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .externalId("externalId")
        .email("email")
        .name("name")
        .role(RegisterUserRequestRole.ADMINISTRATOR)
        .identityAttestation(true)
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**email:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**role:** `RegisterUserRequestRole` 
    
</dd>
</dl>

<dl>
<dd>

**roles:** `Optional<List<RegisterUserRequestRolesItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**profileDetails:** `Optional<RegisterUserRequestProfileDetails>` 
    
</dd>
</dl>

<dl>
<dd>

**npi:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**licenses:** `Optional<List<RegisterUserRequestLicensesItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**legalName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**displayName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**credentials:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**address:** `Optional<RegisterUserRequestAddress>` 
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**locationIds:** `Optional<List<String>>` 
    
</dd>
</dl>

<dl>
<dd>

**identityAttestation:** `Boolean` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.listPracticeTeamInvitations(practiceId) -> ListPracticeTeamInvitationsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:read. Lists practice invitations, including invitations sent in Clinic. Filter by pending, expired, accepted, declined, or revoked status, exact email, or your integration externalId. Only your integration and API key mode can see its external identity and onboarding state. Follow person.nextActions after invitation acceptance.
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
client.team().listPracticeTeamInvitations(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    ListPracticeTeamInvitationsRequest
        .builder()
        .startingAfter("invite_01j2y8m6jcc9tt24af5pw9x1bc")
        .endingBefore("invite_01j2y8m6jcc9tt24af5pw9x1bc")
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<ListPracticeTeamInvitationsRequestStatus>` 
    
</dd>
</dl>

<dl>
<dd>

**email:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` — Match this integration's external identity in the API key's mode.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.invitePracticeTeamPerson(practiceId, request) -> InvitePracticeTeamPersonResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:write on the practice key or its platform key. Use roles to combine administrator, prescriber, clinical_staff, billing, or developer presets. Ownership uses the protected owner designation. The singular role field remains available for single-role assignments. Creates a real organization invitation and optional prescriber setup. The recipient must accept with their Affinity account. Repeating the same external identity retries pending invitation delivery. Accepted invitations do not change existing access. Team membership is shared between Test and Live; the external identity is mode-scoped. Keys cannot accept invitations. Headless registration and signing use separate endpoints.
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
client.team().invitePracticeTeamPerson(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    InvitePracticeTeamPersonRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .externalId("externalId")
        .email("email")
        .name("name")
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**email:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**role:** `Optional<InvitePracticeTeamPersonRequestRole>` 
    
</dd>
</dl>

<dl>
<dd>

**roles:** `Optional<List<InvitePracticeTeamPersonRequestRolesItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**profileDetails:** `Optional<InvitePracticeTeamPersonRequestProfileDetails>` 
    
</dd>
</dl>

<dl>
<dd>

**npi:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**licenses:** `Optional<List<InvitePracticeTeamPersonRequestLicensesItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**legalName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**displayName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**credentials:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**address:** `Optional<InvitePracticeTeamPersonRequestAddress>` 
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**locationIds:** `Optional<List<String>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.getPracticeTeam(practiceId) -> GetPracticeTeamResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:read. Returns counts of members, invitations, and prescribers. Use the paginated members, prescribers, and invitations collections for individual records. Team access and clinician credentials are shared between Test and Live.
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
client.team().getPracticeTeam(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    GetPracticeTeamRequest
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

**practiceId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.listPracticeTeamMembers(practiceId) -> ListPracticeTeamMembersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:read. Search the roster by name or email, and filter by role or membership status. Includes members invited in Clinic, location access, and account-specific prescriber connections. Memberships are shared between Test and Live.
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
client.team().listPracticeTeamMembers(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    ListPracticeTeamMembersRequest
        .builder()
        .startingAfter("mbr_01j2y8m6jcc9tt24af5pw9x1bc")
        .endingBefore("mbr_01j2y8m6jcc9tt24af5pw9x1bc")
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**role:** `Optional<ListPracticeTeamMembersRequestRole>` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<ListPracticeTeamMembersRequestStatus>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.listPracticeTeamPrescribers(practiceId) -> ListPracticeTeamPrescribersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:read. Filter practice prescribers by name, NPI, state, and practice status. Records include submitted licenses and their IDs. Signing authority also requires an active account connection, Live practice access, and prescription eligibility.
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
client.team().listPracticeTeamPrescribers(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    ListPracticeTeamPrescribersRequest
        .builder()
        .startingAfter("prov_01j2y8m6jcc9tt24af5pw9x1bc")
        .endingBefore("prov_01j2y8m6jcc9tt24af5pw9x1bc")
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**search:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**npi:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**state:** `Optional<String>` — Match a submitted license jurisdiction. This does not establish signing eligibility.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<ListPracticeTeamPrescribersRequestStatus>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.getPracticeTeamMember(practiceId, memberId) -> GetPracticeTeamMemberResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:read. Returns current account membership, roles, location access, and prescriber connection. The member ID identifies practice access; it is not the integration user ID used by orders.
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
client.team().getPracticeTeamMember(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "mbr_01j2y8m6jcc9tt24af5pw9x1bc",
    GetPracticeTeamMemberRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**memberId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.updatePracticeTeamMember(practiceId, memberId, request) -> UpdatePracticeTeamMemberResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:write. Supply role, status, or locationIds; omitted values stay unchanged. A role replaces existing roles. Disable access with status disabled. An empty locationIds array grants all practice locations. Ownership changes require an active practice owner using a personal API key; service keys manage non-owner memberships. The final active owner cannot be removed. Changes apply to both Test and Live. Sign-in email and account security remain account settings.
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
client.team().updatePracticeTeamMember(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "mbr_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdatePracticeTeamMemberRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**memberId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**role:** `Optional<UpdatePracticeTeamMemberRequestRole>` 
    
</dd>
</dl>

<dl>
<dd>

**roles:** `Optional<List<UpdatePracticeTeamMemberRequestRolesItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<UpdatePracticeTeamMemberRequestStatus>` 
    
</dd>
</dl>

<dl>
<dd>

**locationIds:** `Optional<List<String>>` — Replace location access. An empty array grants access to all practice locations.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.getPracticeTeamPrescriber(practiceId, prescriberId) -> GetPracticeTeamPrescriberResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:read. Returns the clinical profile and submitted licenses, including license IDs. This is setup information, not a signing authorization.
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
client.team().getPracticeTeamPrescriber(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "prov_01j2y8m6jcc9tt24af5pw9x1bc",
    GetPracticeTeamPrescriberRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**prescriberId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.updatePracticeTeamPrescriber(practiceId, prescriberId, request) -> UpdatePracticeTeamPrescriberResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:write. Set practiceStatus to inactive to remove prescribing access in this practice, or active to restore an existing association. This does not create membership or signing authority. Practice status applies to Test and Live. Shared identity and license edits require Affinity support.
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
client.team().updatePracticeTeamPrescriber(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "prov_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdatePracticeTeamPrescriberRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**prescriberId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**displayName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**legalName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**credentials:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**address:** `Optional<UpdatePracticeTeamPrescriberRequestAddress>` 
    
</dd>
</dl>

<dl>
<dd>

**practiceStatus:** `Optional<UpdatePracticeTeamPrescriberRequestPracticeStatus>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.createPracticeTeamLicense(practiceId, prescriberId, request) -> CreatePracticeTeamLicenseResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:write and an active accepted prescriber account connection in this practice. Adds a license. Expiration is optional, but must be in the future when supplied. An exact repeat returns the existing license; update an existing license with PATCH and its license ID. Licenses are shared across practices and Test/Live. Other licenses stay unchanged.
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
client.team().createPracticeTeamLicense(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "prov_01j2y8m6jcc9tt24af5pw9x1bc",
    CreatePracticeTeamLicenseRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .state("state")
        .licenseNumber("licenseNumber")
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**prescriberId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**state:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**licenseNumber:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**expiresAt:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.updatePracticeTeamLicense(practiceId, prescriberId, licenseId, request) -> UpdatePracticeTeamLicenseResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:write and an active accepted prescriber account connection in this practice. Correct the state or license number, or set or clear the optional expiresAt value. A supplied expiration must be in the future. Other licenses stay unchanged. Changes apply across practices and Test/Live.
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
client.team().updatePracticeTeamLicense(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "prov_01j2y8m6jcc9tt24af5pw9x1bc",
    "lic_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdatePracticeTeamLicenseRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**prescriberId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**licenseId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**state:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**licenseNumber:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**expiresAt:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.getPracticeTeamInvitation(practiceId, invitationId) -> GetPracticeTeamInvitationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:read. Returns invitation status and current onboarding state for your integration. An accepted invitation can still have disabled membership or pending clinical review. Invitation tokens are never returned.
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
client.team().getPracticeTeamInvitation(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "invite_01j2y8m6jcc9tt24af5pw9x1bc",
    GetPracticeTeamInvitationRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**invitationId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.revokePracticeTeamInvitation(practiceId, invitationId) -> RevokePracticeTeamInvitationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:write. Revokes a pending or expired invitation and its pending prescriber account connection. Repeating the revoke returns the revoked invitation. Accepted invitations return 409; disable the member instead. Retains invitation history.
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
client.team().revokePracticeTeamInvitation(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "invite_01j2y8m6jcc9tt24af5pw9x1bc",
    RevokePracticeTeamInvitationRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**invitationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.resendPracticeTeamInvitation(practiceId, invitationId) -> ResendPracticeTeamInvitationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires team:write. Resends a pending or expired invitation with the same ID, recipient, roles, and locations. The previous link stops working and the new link expires in seven days. Accepted and revoked invitations return 409. A 502 means the invitation was saved but email delivery could not be confirmed; retry this operation.
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
client.team().resendPracticeTeamInvitation(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "invite_01j2y8m6jcc9tt24af5pw9x1bc",
    ResendPracticeTeamInvitationRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**invitationId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Patients
<details><summary><code>client.patients.listPatientAddresses(practiceId, patientId) -> ListPatientAddressesResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.patients().listPatientAddresses(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "pat_01j2y8m6jcc9tt24af5pw9x1bc",
    ListPatientAddressesRequest
        .builder()
        .startingAfter("addr_01j2y8m6jcc9tt24af5pw9x1bc")
        .endingBefore("addr_01j2y8m6jcc9tt24af5pw9x1bc")
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<ListPatientAddressesRequestStatus>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.patients.createPatientAddress(practiceId, patientId, request) -> CreatePatientAddressResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the existing active address for a normalized duplicate. The first address becomes the default. API keys require Idempotency-Key.
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
client.patients().createPatientAddress(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "pat_01j2y8m6jcc9tt24af5pw9x1bc",
    CreatePatientAddressRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .address(
            CreatePatientAddressRequestAddress
                .builder()
                .city("city")
                .line1("line1")
                .postalCode("postalCode")
                .state("state")
                .build()
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>

<dl>
<dd>

**address:** `CreatePatientAddressRequestAddress` 
    
</dd>
</dl>

<dl>
<dd>

**label:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**preferredShipping:** `Optional<Boolean>` 
    
</dd>
</dl>

<dl>
<dd>

**recipientName:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.patients.archivePatientAddress(practiceId, patientId, addressId) -> ArchivePatientAddressResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Preserves the address ID and history. Archiving the default selects the oldest remaining active address. Existing orders remain unchanged.
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
client.patients().archivePatientAddress(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "pat_01j2y8m6jcc9tt24af5pw9x1bc",
    "addr_01j2y8m6jcc9tt24af5pw9x1bc",
    ArchivePatientAddressRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**addressId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.patients.updatePatientAddress(practiceId, patientId, addressId, request) -> UpdatePatientAddressResponse</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.patients().updatePatientAddress(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "pat_01j2y8m6jcc9tt24af5pw9x1bc",
    "addr_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdatePatientAddressRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**addressId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>

<dl>
<dd>

**address:** `Optional<UpdatePatientAddressRequestAddress>` 
    
</dd>
</dl>

<dl>
<dd>

**label:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**recipientName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**preferredShipping:** `Optional<Boolean>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.patients.setDefaultPatientAddress(practiceId, patientId, addressId) -> SetDefaultPatientAddressResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Changes delivery selection for future drafts, without changing patient clinical location or existing signed orders.
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
client.patients().setDefaultPatientAddress(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "pat_01j2y8m6jcc9tt24af5pw9x1bc",
    "addr_01j2y8m6jcc9tt24af5pw9x1bc",
    SetDefaultPatientAddressRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**addressId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.patients.listPatients(practiceId) -> ListPatientsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists patients in one practice and mode. Use externalId for an exact match in the calling integration's namespace. Use externalIdentitySource with externalIdentityValue to search an explicit alias. Identity matching is case-sensitive after trimming whitespace. Other filters also apply.
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
client.patients().listPatients(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    ListPatientsRequest
        .builder()
        .endingBefore("pat_01j2y8m6jcc9tt24af5pw9x1bc")
        .startingAfter("pat_01j2y8m6jcc9tt24af5pw9x1bc")
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**externalIdentitySource:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**externalIdentityValue:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**gender:** `Optional<ListPatientsRequestGender>` 
    
</dd>
</dl>

<dl>
<dd>

**lastOrderAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**lastOrderBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**program:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**sort:** `Optional<ListPatientsRequestSort>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**states:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<ListPatientsRequestStatus>` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.patients.createPatient(practiceId, request) -> CreatePatientResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a patient or resolves a matching externalId or external identity within this practice and mode. externalId belongs to the calling integration; externalIdentities holds aliases from other systems. Resolution preserves existing demographics; use PATCH to update them. Conflicting identifiers return 409. Email never merges patients. API keys require Idempotency-Key.
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
client.patients().createPatient(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    CreatePatientRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .dateOfBirth("dateOfBirth")
        .name(
            CreatePatientRequestName
                .builder()
                .first("first")
                .last("last")
                .build()
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>

<dl>
<dd>

**address:** `Optional<CreatePatientRequestAddress>` 
    
</dd>
</dl>

<dl>
<dd>

**clinicalProfile:** `Optional<CreatePatientRequestClinicalProfile>` 
    
</dd>
</dl>

<dl>
<dd>

**dateOfBirth:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**email:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**externalIdentities:** `Optional<List<CreatePatientRequestExternalIdentitiesItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**addresses:** `Optional<List<CreatePatientRequestAddressesItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**encounters:** `Optional<List<CreatePatientRequestEncountersItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**gender:** `Optional<CreatePatientRequestGender>` 
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**metadata:** `Optional<Map<String, Object>>` 
    
</dd>
</dl>

<dl>
<dd>

**medicalRecordNumber:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**measurements:** `Optional<List<CreatePatientRequestMeasurementsItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `CreatePatientRequestName` 
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**programs:** `Optional<List<CreatePatientRequestProgramsItem>>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.patients.getPatient(practiceId, patientId) -> GetPatientResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns one patient in the authorized practice and mode.
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
client.patients().getPatient(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "pat_01j2y8m6jcc9tt24af5pw9x1bc",
    GetPatientRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.patients.deletePatient(practiceId, patientId) -> DeletePatientResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires patients:write and Idempotency-Key for API keys. Permanently deletes a patient with no order history. Any order history returns 409; use Update patient with status archived instead. Available to practice keys and authorized platform keys. Reusing the same idempotency key returns the original deletion result.
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
client.patients().deletePatient(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "pat_01j2y8m6jcc9tt24af5pw9x1bc",
    DeletePatientRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.patients.updatePatient(practiceId, patientId, request) -> UpdatePatientResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a patient in the current practice and mode. Omitted fields remain unchanged; null clears an optional field. externalId updates the calling integration's identifier. externalIdentities replaces its explicit aliases. Identifiers cannot be reassigned from another patient. API keys require Idempotency-Key.
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
client.patients().updatePatient(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "pat_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdatePatientRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>

<dl>
<dd>

**address:** `Optional<UpdatePatientRequestAddress>` 
    
</dd>
</dl>

<dl>
<dd>

**clinicalProfile:** `Optional<UpdatePatientRequestClinicalProfile>` 
    
</dd>
</dl>

<dl>
<dd>

**dateOfBirth:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**email:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**externalIdentities:** `Optional<List<UpdatePatientRequestExternalIdentitiesItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**addresses:** `Optional<List<UpdatePatientRequestAddressesItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**encounters:** `Optional<List<UpdatePatientRequestEncountersItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**gender:** `Optional<UpdatePatientRequestGender>` 
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**metadata:** `Optional<Map<String, Object>>` 
    
</dd>
</dl>

<dl>
<dd>

**medicalRecordNumber:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**measurements:** `Optional<List<UpdatePatientRequestMeasurementsItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<UpdatePatientRequestName>` 
    
</dd>
</dl>

<dl>
<dd>

**programs:** `Optional<List<UpdatePatientRequestProgramsItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**phone:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<UpdatePatientRequestStatus>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.patients.getPatientAllergies(practiceId, patientId) -> GetPatientAllergiesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the patient's structured allergy entries and review status. A not_reviewed status is not a no-known-allergies assertion and blocks clinical review and signing.
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
client.patients().getPatientAllergies(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "pat_01j2y8m6jcc9tt24af5pw9x1bc",
    GetPatientAllergiesRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.patients.replacePatientAllergies(practiceId, patientId, request) -> ReplacePatientAllergiesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Replaces the patient's structured allergy record. Sending no_known is the explicit no-known-allergies acknowledgement; recorded requires at least one entry. Idempotency-Key is required.
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
client.patients().replacePatientAllergies(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    "pat_01j2y8m6jcc9tt24af5pw9x1bc",
    ReplacePatientAllergiesRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .reviewStatus(ReplacePatientAllergiesRequestReviewStatus.NOT_REVIEWED)
        .allergies(
            Arrays.asList(
                ReplacePatientAllergiesRequestAllergiesItem
                    .builder()
                    .category(ReplacePatientAllergiesRequestAllergiesItemCategory.DRUG)
                    .source(ReplacePatientAllergiesRequestAllergiesItemSource.DOCTOR)
                    .substance("substance")
                    .verificationStatus(ReplacePatientAllergiesRequestAllergiesItemVerificationStatus.UNCONFIRMED)
                    .reactions(
                        Arrays.asList(
                            ReplacePatientAllergiesRequestAllergiesItemReactionsItem
                                .builder()
                                .display("display")
                                .build()
                        )
                    )
                    .type(
                        Nullable.ofNull()
                    )
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**patientId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**affinityActorId:** `Optional<String>` — Required for user actors and optional for system actors. Omit both actor headers to use the authenticated service account as a system actor.
    
</dd>
</dl>

<dl>
<dd>

**affinityActorType:** `Optional<String>` — Use user when a person initiated the action and system for autonomous work. Omit both actor headers to default to system.
    
</dd>
</dl>

<dl>
<dd>

**allergies:** `List<ReplacePatientAllergiesRequestAllergiesItem>` 
    
</dd>
</dl>

<dl>
<dd>

**reviewStatus:** `ReplacePatientAllergiesRequestReviewStatus` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Practices
<details><summary><code>client.practices.listPractices() -> ListPracticesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the practices that belong to the platform. The default Affinity-Version is 2026-09-28.
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
client.practices().listPractices(
    ListPracticesRequest
        .builder()
        .endingBefore("prac_01j2y8m6jcc9tt24af5pw9x1bc")
        .startingAfter("prac_01j2y8m6jcc9tt24af5pw9x1bc")
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

**search:** `Optional<String>` — Case-insensitive search by practice name or external ID.
    
</dd>
</dl>

<dl>
<dd>

**endingBefore:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**startingAfter:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.practices.createPractice(request) -> CreatePracticeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a practice owned by the platform. Set liveEnabled to true to enable Live access at creation with an approved platform and a Live request. Defaults to false. Requires practices:write. Send Idempotency-Key when you retry the same request.
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
client.practices().createPractice(
    CreatePracticeRequest
        .builder()
        .address(
            CreatePracticeRequestAddress
                .builder()
                .city("Los Angeles")
                .line1("100 Practice Way")
                .postalCode("90001")
                .state("CA")
                .country("US")
                .build()
        )
        .attestations(
            CreatePracticeRequestAttestations
                .builder()
                .authorizedPracticeRelationship(true)
                .authorizedPhiTransfer(true)
                .minimumNecessaryPhi(true)
                .providerDataAccuracy(true)
                .build()
        )
        .name("Example Medical Group")
        .externalId("practice_123")
        .legalName("Example Medical Group PLLC")
        .metadata(
            new HashMap<String, Object>() {{
                put("key", "value");
            }}
        )
        .prescribers(
            Optional.of(
                Arrays.asList(
                    CreatePracticeRequestPrescribersItem
                        .builder()
                        .name("Alex Morgan")
                        .npi("1234567893")
                        .credentials("MD")
                        .licenseStates(
                            Arrays.asList("CA")
                        )
                        .build()
                )
            )
        )
        .primaryContact(
            CreatePracticeRequestPrimaryContact
                .builder()
                .email("operations@example-practice.com")
                .name("Jordan Lee")
                .build()
        )
        .supportEmail("support@example-practice.com")
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

**idempotencyKey:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**liveEnabled:** `Optional<Boolean>` — Enable Live access at creation. Requires an approved platform and a Live request. Defaults to false.
    
</dd>
</dl>

<dl>
<dd>

**address:** `CreatePracticeRequestAddress` 
    
</dd>
</dl>

<dl>
<dd>

**attestations:** `CreatePracticeRequestAttestations` 
    
</dd>
</dl>

<dl>
<dd>

**complianceContact:** `Optional<CreatePracticeRequestComplianceContact>` 
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**legalName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**metadata:** `Optional<Map<String, Object>>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**prescribers:** `Optional<List<CreatePracticeRequestPrescribersItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**primaryContact:** `Optional<CreatePracticeRequestPrimaryContact>` 
    
</dd>
</dl>

<dl>
<dd>

**supportEmail:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**supportPhone:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**timezone:** `Optional<String>` — Optional IANA timezone override. Omit to leave unchanged; null clears it. No timezone is inferred when creating a record.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.practices.getPractice(practiceId) -> GetPracticeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns one practice that belongs to the platform.
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
client.practices().getPractice(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    GetPracticeRequest
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

**practiceId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.practices.updatePractice(practiceId, request) -> UpdatePracticeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates one practice owned by the platform. Set liveEnabled to true or false to control Live access with an approved platform and a Live request. Affinity Admin decisions take precedence. Requires practices:write. Send Idempotency-Key when you retry the same request.
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
client.practices().updatePractice(
    "prac_01j2y8m6jcc9tt24af5pw9x1bc",
    UpdatePracticeRequest
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

**practiceId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**liveEnabled:** `Optional<Boolean>` — Enable or disable Live access for an owned practice. Requires an approved platform and a Live request. Affinity Admin decisions take precedence.
    
</dd>
</dl>

<dl>
<dd>

**address:** `Optional<UpdatePracticeRequestAddress>` 
    
</dd>
</dl>

<dl>
<dd>

**attestations:** `Optional<UpdatePracticeRequestAttestations>` 
    
</dd>
</dl>

<dl>
<dd>

**complianceContact:** `Optional<UpdatePracticeRequestComplianceContact>` 
    
</dd>
</dl>

<dl>
<dd>

**externalId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**legalName:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**metadata:** `Optional<Map<String, Object>>` 
    
</dd>
</dl>

<dl>
<dd>

**name:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**prescribers:** `Optional<List<UpdatePracticeRequestPrescribersItem>>` 
    
</dd>
</dl>

<dl>
<dd>

**primaryContact:** `Optional<UpdatePracticeRequestPrimaryContact>` 
    
</dd>
</dl>

<dl>
<dd>

**supportEmail:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**supportPhone:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**timezone:** `Optional<String>` — Optional IANA timezone override. Omit to leave unchanged; null clears it. No timezone is inferred when creating a record.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Platform Pricing
<details><summary><code>client.platformPricing.platformPublicApiSellingPricesReadSellingPrice(catalogItemId) -> PlatformPublicApiSellingPricesReadSellingPriceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires selling_prices:read. Omit practiceId for the platform default, or supply a managed practice. A null amount inherits the next applicable price. Amounts use the catalog pricing basis, in USD cents. purchaseAmountCents is the platform's Affinity purchase price for that same basis. requiresReview indicates changed product pricing terms, not a below-purchase-price discount.
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
client.platformPricing().platformPublicApiSellingPricesReadSellingPrice(
    "cat_01j2y8m6jcc9tt24af5pw9x1bc",
    PlatformPublicApiSellingPricesReadSellingPriceRequest
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

**catalogItemId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `Optional<String>` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.platformPricing.platformPublicApiSellingPricesUpdateSellingPrice(catalogItemId, request) -> PlatformPublicApiSellingPricesUpdateSellingPriceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Requires selling_prices:write. Sets a platform default or managed practice override in the current Test/Live mode. Send baseVersion from Read selling price. Null removes the override. Prices use the catalog pricing basis. Intentional discounts below purchaseAmountCents are allowed; compare these amounts to warn about selling below your Affinity purchase price. This does not change the platform's Affinity purchase price or collect practice payments.
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
client.platformPricing().platformPublicApiSellingPricesUpdateSellingPrice(
    "cat_01j2y8m6jcc9tt24af5pw9x1bc",
    PlatformPublicApiSellingPricesUpdateSellingPriceRequest
        .builder()
        .idempotencyKey("Idempotency-Key")
        .baseVersion(1)
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

**catalogItemId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**practiceId:** `Optional<String>` 
    
</dd>
</dl>

<dl>
<dd>

**amountCents:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**baseVersion:** `Integer` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

