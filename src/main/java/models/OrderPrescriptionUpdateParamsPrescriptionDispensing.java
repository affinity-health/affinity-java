package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class OrderPrescriptionUpdateParamsPrescriptionDispensing{private final Map<String,Object> values;private OrderPrescriptionUpdateParamsPrescriptionDispensing(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder dispenseUponAcceptance(Boolean value){values.put("dispenseUponAcceptance",value);return this;}
public Builder shippingOptionId(String value){values.put("shippingOptionId",value);return this;}
public Builder shippingAmountCents(Integer value){values.put("shippingAmountCents",value);return this;}
public Builder shippingDestinationType(String value){values.put("shippingDestinationType",value);return this;}
public Builder pharmacyNotes(String value){values.put("pharmacyNotes",value);return this;}
public Builder requestedFillDate(String value){values.put("requestedFillDate",value);return this;}
public Builder substitutionPermitted(Boolean value){values.put("substitutionPermitted",value);return this;}public OrderPrescriptionUpdateParamsPrescriptionDispensing build(){return new OrderPrescriptionUpdateParamsPrescriptionDispensing(values);}}}