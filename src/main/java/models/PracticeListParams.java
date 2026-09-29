package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class PracticeListParams{private final Map<String,Object> values;private PracticeListParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder search(String value){values.put("search",value);return this;}
public Builder endingBefore(String value){values.put("endingBefore",value);return this;}
public Builder limit(Integer value){values.put("limit",value);return this;}
public Builder startingAfter(String value){values.put("startingAfter",value);return this;}public PracticeListParams build(){return new PracticeListParams(values);}}}