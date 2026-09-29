package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class PatientUpdateParamsName{private final Map<String,Object> values;private PatientUpdateParamsName(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder first(String value){values.put("first",value);return this;}
public Builder last(String value){values.put("last",value);return this;}
public Builder middle(String value){values.put("middle",value);return this;}
public Builder preferred(String value){values.put("preferred",value);return this;}public PatientUpdateParamsName build(){return new PatientUpdateParamsName(values);}}}