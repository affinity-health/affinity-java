package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class TeamPrescriberListParams{private final Map<String,Object> values;private TeamPrescriberListParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder limit(Integer value){values.put("limit",value);return this;}
public Builder startingAfter(String value){values.put("startingAfter",value);return this;}
public Builder endingBefore(String value){values.put("endingBefore",value);return this;}
public Builder search(String value){values.put("search",value);return this;}
public Builder npi(String value){values.put("npi",value);return this;}
public Builder state(String value){values.put("state",value);return this;}
public Builder status(String value){values.put("status",value);return this;}public TeamPrescriberListParams build(){return new TeamPrescriberListParams(values);}}}