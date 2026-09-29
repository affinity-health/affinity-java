package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class OrderBatchCreateParamsOrdersItemPrescriptionsItemStructuredSig{private final Map<String,Object> values;private OrderBatchCreateParamsOrdersItemPrescriptionsItemStructuredSig(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder dose(String value){values.put("dose",value);return this;}
public Builder doseUnit(String value){values.put("doseUnit",value);return this;}
public Builder duration(String value){values.put("duration",value);return this;}
public Builder frequency(String value){values.put("frequency",value);return this;}
public Builder indication(String value){values.put("indication",value);return this;}
public Builder maxDailyUse(String value){values.put("maxDailyUse",value);return this;}
public Builder prn(Boolean value){values.put("prn",value);return this;}
public Builder route(String value){values.put("route",value);return this;}
public Builder titrationSchedule(String value){values.put("titrationSchedule",value);return this;}public OrderBatchCreateParamsOrdersItemPrescriptionsItemStructuredSig build(){if(!values.containsKey("dose")||values.get("dose")==null)throw new IllegalArgumentException("dose is required");if(!values.containsKey("doseUnit")||values.get("doseUnit")==null)throw new IllegalArgumentException("doseUnit is required");if(!values.containsKey("frequency")||values.get("frequency")==null)throw new IllegalArgumentException("frequency is required");if(!values.containsKey("route")||values.get("route")==null)throw new IllegalArgumentException("route is required");return new OrderBatchCreateParamsOrdersItemPrescriptionsItemStructuredSig(values);}}}