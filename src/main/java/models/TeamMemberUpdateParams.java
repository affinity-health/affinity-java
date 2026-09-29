package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class TeamMemberUpdateParams{private final Map<String,Object> values;private TeamMemberUpdateParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder role(String value){values.put("role",value);return this;}
public Builder roles(List<String> value){values.put("roles",value);return this;}
public Builder status(String value){values.put("status",value);return this;}
public Builder locationIds(List<String> value){values.put("locationIds",value);return this;}public TeamMemberUpdateParams build(){return new TeamMemberUpdateParams(values);}}}