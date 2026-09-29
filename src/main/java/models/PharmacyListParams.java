package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class PharmacyListParams{private final Map<String,Object> values;private PharmacyListParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder endingBefore(String value){values.put("endingBefore",value);return this;}
public Builder limit(Integer value){values.put("limit",value);return this;}
public Builder orgId(String value){values.put("orgId",value);return this;}
public Builder pharmacyId(String value){values.put("pharmacyId",value);return this;}
public Builder query(String value){values.put("query",value);return this;}
public Builder shipsToState(String value){values.put("shipsToState",value);return this;}
public Builder startingAfter(String value){values.put("startingAfter",value);return this;}public PharmacyListParams build(){return new PharmacyListParams(values);}}}