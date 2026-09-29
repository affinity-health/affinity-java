package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class OrderListParams{private final Map<String,Object> values;private OrderListParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder query(String value){values.put("query",value);return this;}
public Builder externalOrderId(String value){values.put("externalOrderId",value);return this;}
public Builder createdAfter(String value){values.put("createdAfter",value);return this;}
public Builder createdBefore(String value){values.put("createdBefore",value);return this;}
public Builder endingBefore(String value){values.put("endingBefore",value);return this;}
public Builder limit(Integer value){values.put("limit",value);return this;}
public Builder orderId(String value){values.put("orderId",value);return this;}
public Builder patientId(String value){values.put("patientId",value);return this;}
public Builder patientExternalId(String value){values.put("patientExternalId",value);return this;}
public Builder sort(String value){values.put("sort",value);return this;}
public Builder startingAfter(String value){values.put("startingAfter",value);return this;}
public Builder status(String value){values.put("status",value);return this;}public OrderListParams build(){return new OrderListParams(values);}}}