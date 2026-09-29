package com.affinity.api;

import com.affinity.api.core.ObjectMappers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.*;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

final class SdkTransport {
 static final ObjectMapper JSON = ObjectMappers.JSON_MAPPER.copy();
 final String key; final String baseUrl; final HttpClient http; final Duration timeout; final int retries;
 private Map<String,Object> identity;
 SdkTransport(String key, ClientOptions options) {
  if(key==null||key.isBlank()) throw new IllegalArgumentException("An API key is required");
  if(options.timeout().isNegative()||options.timeout().isZero()||options.maxRetries()<0||options.maxRetries()>10)throw new IllegalArgumentException("Invalid timeout or retry limit");
  this.key=key;this.baseUrl=options.baseUrl().replaceAll("/$","");this.http=options.httpClient();this.timeout=options.timeout();this.retries=options.maxRetries();
  if(http.followRedirects()!=HttpClient.Redirect.NEVER)throw new IllegalArgumentException("The HTTP client must not follow redirects");
 }
 synchronized Map<String,Object> access() {
  if(identity==null){Map<?,?> result=request("/v1/auth/access","GET",null,Map.of(),new TypeReference<Map<String,Object>>(){});Object subject=result.get("serviceAccount");if(!(subject instanceof Map<?,?> map)||!(map.get("subjectId") instanceof String)||!(map.get("subjectType") instanceof String))throw new IllegalStateException("Invalid API key access response");identity=new LinkedHashMap<>();identity.put("subjectId",map.get("subjectId"));identity.put("subjectType",map.get("subjectType"));}
  return identity;
 }
 <T>T request(String path,String method,Object body,Map<String,String> headers,TypeReference<T> type){
  try {
   String payload=body==null?null:JSON.writeValueAsString(body);
   int maxRetries=method.equals("GET")||headers.containsKey("Idempotency-Key")?retries:0;
   for(int attempt=0;;attempt++){
    if(Thread.currentThread().isInterrupted())throw new InterruptedException();
    HttpRequest.Builder builder=HttpRequest.newBuilder(URI.create(baseUrl+path)).timeout(timeout).header("Authorization","Bearer "+key).header("Affinity-Version","2026-09-28");
    headers.forEach(builder::header);if(body!=null)builder.header("Content-Type","application/json");
    builder.method(method,payload==null?HttpRequest.BodyPublishers.noBody():HttpRequest.BodyPublishers.ofString(payload));
    long delay=250L*(1L<<attempt);
    try {
     HttpResponse<String> response=http.send(builder.build(),HttpResponse.BodyHandlers.ofString());
     if(response.statusCode()>=200&&response.statusCode()<300)return response.body().isBlank()?null:JSON.readValue(response.body(),type);
     Map<String,Object> problem;try{problem=JSON.readValue(response.body(),new TypeReference<Map<String,Object>>(){});}catch(Exception ignored){problem=Map.of();}
     String retryHeader=response.headers().firstValue("Retry-After").orElse(null);Double retryAfter=null;
     if(retryHeader!=null){try{retryAfter=Math.max(0,Double.parseDouble(retryHeader));}catch(NumberFormatException ignored){try{retryAfter=Math.max(0,Duration.between(Instant.now(),ZonedDateTime.parse(retryHeader,DateTimeFormatter.RFC_1123_DATE_TIME).toInstant()).toMillis()/1000.0);}catch(Exception invalid){}}}
     AffinityException error=new AffinityException(response.statusCode(),String.valueOf(problem.getOrDefault("code","api_error")),(String)problem.get("requestId"),retryAfter);
     if(!error.retryable()||attempt>=maxRetries)throw error;
     if(retryAfter!=null)delay=Math.max(delay,(long)(retryAfter*1000));
    }catch(IOException error){if(attempt>=maxRetries)throw error;}
    Thread.sleep(Math.min(30_000,delay));
   }
  }catch(InterruptedException error){Thread.currentThread().interrupt();throw new IllegalStateException("Affinity request interrupted",error);}
  catch(IOException error){throw new UncheckedIOException("Affinity transport failed",error);}
 }
 static String escape(String value){return URLEncoder.encode(value,StandardCharsets.UTF_8).replace("+","%20");}
}
final class SdkContext {
 final SdkTransport transport;final String practiceId;
 SdkContext(SdkTransport transport,String practiceId){this.transport=transport;this.practiceId=practiceId;}
 <T>T call(String operationId,String[] ids,Object params,RequestOptions options,TypeReference<T> responseType){
  Map<String,Object> op=SdkOperations.ALL.get(operationId);if(options==null)options=RequestOptions.builder().build();
  if(Boolean.TRUE.equals(op.get("rootOnly"))&&practiceId!=null)throw new IllegalArgumentException("Use the root client for platform-wide operations");
  if(practiceId!=null&&options.practiceId()!=null&&!practiceId.equals(options.practiceId()))throw new IllegalArgumentException("Conflicting practice ID");
  String key=options.idempotencyKey();String policy=(String)op.get("idempotency");
  if(key!=null&&key.isBlank())throw new IllegalArgumentException("idempotencyKey must not be empty");
  if(policy.equals("required")&&key==null)throw new IllegalArgumentException("A persisted idempotencyKey is required");
  if(policy.equals("none")&&key!=null)throw new IllegalArgumentException("This endpoint does not support idempotency keys");
  if(policy.equals("auto")&&key==null)key=UUID.randomUUID().toString();
  String selected=options.practiceId()!=null?options.practiceId():practiceId;String scope=(String)op.get("practice");
  if(!scope.equals("none")){Map<String,Object> identity=transport.access();if("practice".equals(identity.get("subjectType"))){String keyPractice=(String)identity.get("subjectId");if(selected!=null&&!selected.equals(keyPractice))throw new IllegalArgumentException("Practice context conflicts with the API key");selected=keyPractice;}if(selected==null||selected.isBlank())throw new IllegalArgumentException("A platform key requires practiceId");}
  else if(options.practiceId()!=null)throw new IllegalArgumentException("This endpoint does not accept practice context");
  Map<String,Object> data=params==null?new LinkedHashMap<>():SdkTransport.JSON.convertValue(params,new TypeReference<LinkedHashMap<String,Object>>(){});
  if(operationId.equals("updatePatient")&&"archived".equals(data.get("status")))data.put("status","inactive");
  if(data.containsKey("practiceId"))throw new IllegalArgumentException("Pass practiceId in request options");
  String path=(String)op.get("path");List<?> names=(List<?>)op.get("ids");if(ids.length!=names.size())throw new IllegalArgumentException("Missing resource ID");
  for(int i=0;i<ids.length;i++){if(ids[i]==null||ids[i].isBlank())throw new IllegalArgumentException("A resource ID is required");path=path.replace("{"+names.get(i)+"}",SdkTransport.escape(ids[i]));}
  if(scope.equals("path"))path=path.replace("{practiceId}",SdkTransport.escape(selected));
  if(scope.equals("body")||scope.equals("query"))data.put("practiceId",selected);
  if(scope.equals("order")){String orderId=ids[names.indexOf("orderId")];Map<String,Object> order=transport.request("/v1/orders/"+SdkTransport.escape(orderId),"GET",null,Map.of(),new TypeReference<Map<String,Object>>(){});if(!Objects.equals(order.get("practiceId"),selected))throw new IllegalArgumentException("Order does not belong to the selected practice");if(operationId.equals("getOrder"))return SdkTransport.JSON.convertValue(order,responseType);}
  List<String> query=new ArrayList<>();for(Object q:(List<?>)op.get("query")){String name=(String)q;if(data.get(name)!=null)query.add(SdkTransport.escape(name)+"="+SdkTransport.escape(String.valueOf(data.remove(name))));}
  if(!query.isEmpty())path+="?"+String.join("&",query);
  Map<String,String> headers=new LinkedHashMap<>();Map<?,?> allowed=(Map<?,?>)op.get("headers");for(var entry:options.headers().entrySet()){if(allowed.containsKey(entry.getKey()))headers.put((String)allowed.get(entry.getKey()),entry.getValue());}
  if(key!=null)headers.put("Idempotency-Key",key);
  return transport.request(path,(String)op.get("verb"),Boolean.TRUE.equals(op.get("body"))?data:null,headers,responseType);
 }
 <T>Iterable<T> iterate(String operation,String[] ids,Object params,RequestOptions options,TypeReference<T> itemType){
  Map<String,Object> initial=SdkTransport.JSON.convertValue(params,new TypeReference<LinkedHashMap<String,Object>>(){});
  if(initial.get("endingBefore")!=null)throw new IllegalArgumentException("iterate supports forward pagination");
  return ()->new Iterator<T>(){
   final Map<String,Object> query=new LinkedHashMap<>(initial);Iterator<?> items=Collections.emptyIterator();boolean done=false;
   public boolean hasNext(){if(Thread.currentThread().isInterrupted())throw new IllegalStateException("Affinity iteration interrupted");if(items.hasNext())return true;if(done)return false;Map<String,Object> page=call(operation,ids,query,options,new TypeReference<Map<String,Object>>(){});List<?> records=(List<?>)page.get("data");done=!Boolean.TRUE.equals(page.get("hasMore"));if(!done){Object cursor=records.isEmpty()?null:((Map<?,?>)records.get(records.size()-1)).get("id");if(cursor==null||Objects.equals(cursor,query.get("startingAfter")))throw new IllegalStateException("Pagination did not advance");query.put("startingAfter",cursor);}items=records.iterator();return items.hasNext();}
   public T next(){if(!hasNext())throw new NoSuchElementException();return SdkTransport.JSON.convertValue(items.next(),itemType);}
  };
 }
}
