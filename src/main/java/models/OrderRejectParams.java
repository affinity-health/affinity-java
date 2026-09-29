package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class OrderRejectParams{private final Map<String,Object> values;private OrderRejectParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder userId(String value){values.put("userId",value);return this;}
public Builder prescriber(PrescriberSelector value){values.put("prescriber",value);return this;}
public Builder reason(String value){values.put("reason",value);return this;}
public Builder expectedRevision(String value){values.put("expectedRevision",value);return this;}
public Builder expectedVersions(List<OrderRejectParamsExpectedVersionsItem> value){values.put("expectedVersions",value);return this;}public OrderRejectParams build(){if(!values.containsKey("reason")||values.get("reason")==null)throw new IllegalArgumentException("reason is required");return new OrderRejectParams(values);}}}