package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class OrderPreviewParamsPrescriptionsItemOverrides{private final Map<String,Object> values;private OrderPreviewParamsPrescriptionsItemOverrides(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder sig(Object value){values.put("sig",value);return this;}
public Builder quantity(OrderPreviewParamsPrescriptionsItemOverridesQuantity value){values.put("quantity",value);return this;}
public Builder daysSupply(Integer value){values.put("daysSupply",value);return this;}
public Builder refills(Integer value){values.put("refills",value);return this;}
public Builder clinical(OrderPreviewParamsPrescriptionsItemOverridesClinical value){values.put("clinical",value);return this;}
public Builder dispensing(OrderPreviewParamsPrescriptionsItemOverridesDispensing value){values.put("dispensing",value);return this;}public OrderPreviewParamsPrescriptionsItemOverrides build(){return new OrderPreviewParamsPrescriptionsItemOverrides(values);}}}