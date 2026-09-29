package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class PrescriberSelector{private final Map<String,Object> values;private PrescriberSelector(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder id(String value){values.put("id",value);return this;}
public Builder npi(String value){values.put("npi",value);return this;}
public Builder externalId(String value){values.put("externalId",value);return this;}
public Builder profile(PrescriberSelectorProfile value){values.put("profile",value);return this;}public PrescriberSelector build(){return new PrescriberSelector(values);}}}