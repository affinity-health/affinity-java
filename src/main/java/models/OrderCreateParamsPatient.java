package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class OrderCreateParamsPatient{private final Map<String,Object> values;private OrderCreateParamsPatient(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder address(OrderCreateParamsPatientAddress value){values.put("address",value);return this;}
public Builder clinicalProfile(OrderCreateParamsPatientClinicalProfile value){values.put("clinicalProfile",value);return this;}
public Builder dateOfBirth(String value){values.put("dateOfBirth",value);return this;}
public Builder email(String value){values.put("email",value);return this;}
public Builder externalId(String value){values.put("externalId",value);return this;}
public Builder externalIdentities(List<OrderCreateParamsPatientExternalIdentitiesItem> value){values.put("externalIdentities",value);return this;}
public Builder addresses(List<OrderCreateParamsPatientAddressesItem> value){values.put("addresses",value);return this;}
public Builder encounters(List<OrderCreateParamsPatientEncountersItem> value){values.put("encounters",value);return this;}
public Builder gender(String value){values.put("gender",value);return this;}
public Builder locationId(String value){values.put("locationId",value);return this;}
public Builder metadata(Object value){values.put("metadata",value);return this;}
public Builder medicalRecordNumber(String value){values.put("medicalRecordNumber",value);return this;}
public Builder measurements(List<OrderCreateParamsPatientMeasurementsItem> value){values.put("measurements",value);return this;}
public Builder name(OrderCreateParamsPatientName value){values.put("name",value);return this;}
public Builder phone(String value){values.put("phone",value);return this;}
public Builder programs(List<OrderCreateParamsPatientProgramsItem> value){values.put("programs",value);return this;}public OrderCreateParamsPatient build(){if(!values.containsKey("dateOfBirth")||values.get("dateOfBirth")==null)throw new IllegalArgumentException("dateOfBirth is required");if(!values.containsKey("name")||values.get("name")==null)throw new IllegalArgumentException("name is required");return new OrderCreateParamsPatient(values);}}}