package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class LocationUpdateParams{private final Map<String,Object> values;private LocationUpdateParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder city(String value){values.put("city",value);return this;}
public Builder country(String value){values.put("country",value);return this;}
public Builder line1(String value){values.put("line1",value);return this;}
public Builder line2(String value){values.put("line2",value);return this;}
public Builder name(String value){values.put("name",value);return this;}
public Builder phone(String value){values.put("phone",value);return this;}
public Builder postalCode(String value){values.put("postalCode",value);return this;}
public Builder state(String value){values.put("state",value);return this;}
public Builder timezone(String value){values.put("timezone",value);return this;}public LocationUpdateParams build(){return new LocationUpdateParams(values);}}}