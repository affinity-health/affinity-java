package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class PatientListParams{private final Map<String,Object> values;private PatientListParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder endingBefore(String value){values.put("endingBefore",value);return this;}
public Builder externalId(String value){values.put("externalId",value);return this;}
public Builder externalIdentitySource(String value){values.put("externalIdentitySource",value);return this;}
public Builder externalIdentityValue(String value){values.put("externalIdentityValue",value);return this;}
public Builder gender(String value){values.put("gender",value);return this;}
public Builder lastOrderAfter(String value){values.put("lastOrderAfter",value);return this;}
public Builder lastOrderBefore(String value){values.put("lastOrderBefore",value);return this;}
public Builder limit(Integer value){values.put("limit",value);return this;}
public Builder program(String value){values.put("program",value);return this;}
public Builder query(String value){values.put("query",value);return this;}
public Builder sort(String value){values.put("sort",value);return this;}
public Builder startingAfter(String value){values.put("startingAfter",value);return this;}
public Builder states(String value){values.put("states",value);return this;}
public Builder status(String value){values.put("status",value);return this;}public PatientListParams build(){return new PatientListParams(values);}}}