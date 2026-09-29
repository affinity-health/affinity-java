package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class PatientAddressUpdateParams{private final Map<String,Object> values;private PatientAddressUpdateParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder address(PatientAddressUpdateParamsAddress value){values.put("address",value);return this;}
public Builder label(String value){values.put("label",value);return this;}
public Builder recipientName(String value){values.put("recipientName",value);return this;}
public Builder preferredShipping(Boolean value){values.put("preferredShipping",value);return this;}public PatientAddressUpdateParams build(){return new PatientAddressUpdateParams(values);}}}