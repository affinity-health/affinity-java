package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class TeamPrescriberUpdateParams{private final Map<String,Object> values;private TeamPrescriberUpdateParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder displayName(String value){values.put("displayName",value);return this;}
public Builder legalName(String value){values.put("legalName",value);return this;}
public Builder credentials(String value){values.put("credentials",value);return this;}
public Builder phone(String value){values.put("phone",value);return this;}
public Builder address(TeamPrescriberUpdateParamsAddress value){values.put("address",value);return this;}
public Builder practiceStatus(String value){values.put("practiceStatus",value);return this;}public TeamPrescriberUpdateParams build(){return new TeamPrescriberUpdateParams(values);}}}