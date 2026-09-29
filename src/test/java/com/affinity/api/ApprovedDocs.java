package com.affinity.api;import com.affinity.api.models.*;import java.util.*;class ApprovedDocs{static class Draft{List<OrderCreateParamsPrescriptionsItem> prescriptions(){return List.of();}}static class Job{String createOrderKey(){return "create";}String signOrderKey(){return "sign";}String submitOrderKey(){return "submit";}}static class Review{String prescriberId(){return "prov_a";}String orderRevision(){return "rev_a";}boolean signatureAttestation(){return true;}}void syncPatient(Object patient){}
void example0(){var api=new Affinity("test");var practice=api.forPractice("prac_a");String practiceId="prac_a",patientId="pat_a",orderId="ord_a";var draft=new Draft();var job=new Job();var review=new Review();
PatientListParams patientParams = PatientListParams.builder()
    .limit(20)
    .build();

var patients = api.patients().list(patientParams);
var patient = api.patients().get(patientId);

CatalogItemListParams itemParams = CatalogItemListParams.builder()
    .limit(20)
    .build();

var items = api.catalog().items().list(itemParams);

}
void example1(){var api=new Affinity("test");var practice=api.forPractice("prac_a");String practiceId="prac_a",patientId="pat_a",orderId="ord_a";var draft=new Draft();var job=new Job();var review=new Review();
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

}
void example2(){var api=new Affinity("test");String practiceId="prac_a",patientId="pat_a",orderId="ord_a";var draft=new Draft();var job=new Job();var review=new Review();
var practice = api.forPractice(practiceId);

PatientListParams patientParams = PatientListParams.builder()
    .limit(20)
    .build();

var patients = practice.patients().list(patientParams);

CatalogItemListParams itemParams = CatalogItemListParams.builder()
    .limit(20)
    .build();

var items = practice.catalog().items().list(itemParams);

}
void example3(){var api=new Affinity("test");var practice=api.forPractice("prac_a");String practiceId="prac_a",patientId="pat_a",orderId="ord_a";var draft=new Draft();var job=new Job();var review=new Review();
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

}
void example4(){var api=new Affinity("test");var practice=api.forPractice("prac_a");String practiceId="prac_a",patientId="pat_a",orderId="ord_a";var draft=new Draft();var job=new Job();var review=new Review();
practice.patients().delete(patientId);

}
void example5(){var api=new Affinity("test");var practice=api.forPractice("prac_a");String practiceId="prac_a",patientId="pat_a",orderId="ord_a";var draft=new Draft();var job=new Job();var review=new Review();
OrderCreateParams params = OrderCreateParams.builder()
    .patientId(patientId)
    .prescriptions(draft.prescriptions())
    .build();

RequestOptions options = RequestOptions.builder()
    .practiceId(practiceId)
    .idempotencyKey(job.createOrderKey())
    .build();

var order = api.orders().create(params, options);

}
void example6(){var api=new Affinity("test");var practice=api.forPractice("prac_a");String practiceId="prac_a",patientId="pat_a",orderId="ord_a";var draft=new Draft();var job=new Job();var review=new Review();
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

}
void example7(){var api=new Affinity("test");var practice=api.forPractice("prac_a");String practiceId="prac_a",patientId="pat_a",orderId="ord_a";var draft=new Draft();var job=new Job();var review=new Review();
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

}
void example8(){var api=new Affinity("test");var practice=api.forPractice("prac_a");String practiceId="prac_a",patientId="pat_a",orderId="ord_a";var draft=new Draft();var job=new Job();var review=new Review();
try {
    practice.patients().get(patientId);
} catch (AffinityException error) {
    System.err.printf("status=%d code=%s request=%s retryable=%s retryAfter=%s%n",
        error.status(), error.code(), error.requestId(),
        error.retryable(), error.retryAfter());
}

}
void example9(){var api=new Affinity("test");var practice=api.forPractice("prac_a");String practiceId="prac_a",patientId="pat_a",orderId="ord_a";var draft=new Draft();var job=new Job();var review=new Review();
PracticeListParams practiceParams = PracticeListParams.builder()
    .limit(20)
    .build();

var practices = api.practices().list(practiceParams);
var selected = api.practices().get(practiceId);

WebhookEndpointListParams endpointParams = WebhookEndpointListParams.builder()
    .limit(20)
    .build();

var endpoints = api.webhooks().endpoints().list(endpointParams);

}
}