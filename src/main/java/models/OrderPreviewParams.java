package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class OrderPreviewParams{private final Map<String,Object> values;private OrderPreviewParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder otcItems(List<OrderPreviewParamsOtcItemsItem> value){values.put("otcItems",value);return this;}
public Builder patientId(String value){values.put("patientId",value);return this;}
public Builder patientExternalId(String value){values.put("patientExternalId",value);return this;}
public Builder patient(OrderPreviewParamsPatient value){values.put("patient",value);return this;}
public Builder userId(String value){values.put("userId",value);return this;}
public Builder prescriber(PrescriberSelector value){values.put("prescriber",value);return this;}
public Builder shippingAddressId(String value){values.put("shippingAddressId",value);return this;}
public Builder externalOrderId(String value){values.put("externalOrderId",value);return this;}
public Builder prescriptions(List<OrderPreviewParamsPrescriptionsItem> value){values.put("prescriptions",value);return this;}
public Builder shipping(OrderPreviewParamsShipping value){values.put("shipping",value);return this;}public OrderPreviewParams build(){if(!values.containsKey("prescriptions")||values.get("prescriptions")==null)throw new IllegalArgumentException("prescriptions is required");return new OrderPreviewParams(values);}}}