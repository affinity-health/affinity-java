package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class WebhookEndpointUpdateParams{private final Map<String,Object> values;private WebhookEndpointUpdateParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder practiceIds(List<String> value){values.put("practiceIds",value);return this;}
public Builder description(String value){values.put("description",value);return this;}
public Builder payloadStyle(String value){values.put("payloadStyle",value);return this;}
public Builder status(String value){values.put("status",value);return this;}
public Builder subscribedEvents(List<String> value){values.put("subscribedEvents",value);return this;}
public Builder url(String value){values.put("url",value);return this;}public WebhookEndpointUpdateParams build(){return new WebhookEndpointUpdateParams(values);}}}