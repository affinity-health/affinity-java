package com.affinity.api;
import com.affinity.api.models.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.net.URI;
import java.net.http.*;
import java.time.Duration;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ApprovedJavaTest {
 @Test void approvedInterface() throws Exception {
  String base="http://127.0.0.1:5199/java-practice-retry";HttpClient http=HttpClient.newHttpClient();http.send(HttpRequest.newBuilder(URI.create(base+"/reset")).build(),HttpResponse.BodyHandlers.ofString());
  Affinity api=new Affinity("test",new ClientOptions(base,Duration.ofSeconds(60),1,http));
  PatientName name=PatientName.builder().first("Alex").last("Example").build();
  PatientCreateParams params=PatientCreateParams.builder().name(name).dateOfBirth("1990-01-01").build();
  var patient=api.patients().create(params);assertEquals("pat_a",patient.id());
  api.patients().update(patient.id(),PatientUpdateParams.builder().email(null).build());api.patients().delete(patient.id());
  var patients=api.patients().iterate(PatientListParams.builder().limit(1).query("Alex").build());var ids=new ArrayList<String>();for(var p:patients)ids.add(p.id());assertEquals(List.of("pat_a","pat_b"),ids);
  assertThrows(IllegalArgumentException.class,()->api.patients().get("pat_a",RequestOptions.builder().practiceId("prac_b").build()));
  assertThrows(IllegalArgumentException.class,()->api.orders().submit("ord_a"));
  var sign=OrderSignParams.builder().prescriber(PrescriberSelector.builder().id("prov_a").build()).expectedRevision("rev_reviewed").signatureAttestation(true).build();
  api.orders().sign("ord_a",sign,RequestOptions.builder().idempotencyKey("sign_job").build());api.orders().submit("ord_a",RequestOptions.builder().idempotencyKey("submit_job").build());
  var error=assertThrows(AffinityException.class,()->api.patients().get("pat_error"));assertEquals(429,error.status());assertEquals("rate_limited",error.code());assertEquals("req_a",error.requestId());assertEquals(0,error.retryAfter());assertFalse(error.getMessage().contains("private"));
  JsonNode trace=SdkTransport.JSON.readTree(http.send(HttpRequest.newBuilder(URI.create(base+"/trace")).build(),HttpResponse.BodyHandlers.ofString()).body());int access=0;var keys=new ArrayList<String>();for(JsonNode r:trace){if(r.get("path").asText().equals("/v1/auth/access"))access++;if(r.get("method").asText().equals("PATCH")){keys.add(r.get("key").asText());assertTrue(r.get("body").has("email"));assertTrue(r.get("body").get("email").isNull());}}assertEquals(1,access);assertEquals(2,keys.size());assertEquals(keys.get(0),keys.get(1));
 }
}
