package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class TeamRegisterParamsProfileDetails{private final Map<String,Object> values;private TeamRegisterParamsProfileDetails(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder firstName(String value){values.put("firstName",value);return this;}
public Builder middleName(String value){values.put("middleName",value);return this;}
public Builder lastName(String value){values.put("lastName",value);return this;}
public Builder namePrefix(String value){values.put("namePrefix",value);return this;}
public Builder nameSuffix(String value){values.put("nameSuffix",value);return this;}
public Builder fax(String value){values.put("fax",value);return this;}
public Builder specialties(List<TeamRegisterParamsProfileDetailsSpecialtiesItem> value){values.put("specialties",value);return this;}
public Builder addresses(List<TeamRegisterParamsProfileDetailsAddressesItem> value){values.put("addresses",value);return this;}
public Builder otherNames(List<TeamRegisterParamsProfileDetailsOtherNamesItem> value){values.put("otherNames",value);return this;}
public Builder identifiers(List<TeamRegisterParamsProfileDetailsIdentifiersItem> value){values.put("identifiers",value);return this;}
public Builder endpoints(List<TeamRegisterParamsProfileDetailsEndpointsItem> value){values.put("endpoints",value);return this;}
public Builder certifications(List<TeamRegisterParamsProfileDetailsCertificationsItem> value){values.put("certifications",value);return this;}public TeamRegisterParamsProfileDetails build(){return new TeamRegisterParamsProfileDetails(values);}}}