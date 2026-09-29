package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class OrderBatchCreateParamsOrdersItem{private final Map<String,Object> values;private OrderBatchCreateParamsOrdersItem(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder otcItems(List<OrderBatchCreateParamsOrdersItemOtcItemsItem> value){values.put("otcItems",value);return this;}
public Builder externalOrderId(String value){values.put("externalOrderId",value);return this;}
public Builder metadata(Map<String,Object> value){values.put("metadata",value);return this;}
public Builder patientId(String value){values.put("patientId",value);return this;}
public Builder patient(OrderBatchCreateParamsOrdersItemPatient value){values.put("patient",value);return this;}
public Builder shippingAddressId(String value){values.put("shippingAddressId",value);return this;}
public Builder prescriptions(List<OrderBatchCreateParamsOrdersItemPrescriptionsItem> value){values.put("prescriptions",value);return this;}public OrderBatchCreateParamsOrdersItem build(){if(!values.containsKey("prescriptions")||values.get("prescriptions")==null)throw new IllegalArgumentException("prescriptions is required");return new OrderBatchCreateParamsOrdersItem(values);}}}