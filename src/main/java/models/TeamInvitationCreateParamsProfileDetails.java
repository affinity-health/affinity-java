package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class TeamInvitationCreateParamsProfileDetails{private final Map<String,Object> values;private TeamInvitationCreateParamsProfileDetails(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder firstName(String value){values.put("firstName",value);return this;}
public Builder middleName(String value){values.put("middleName",value);return this;}
public Builder lastName(String value){values.put("lastName",value);return this;}
public Builder namePrefix(String value){values.put("namePrefix",value);return this;}
public Builder nameSuffix(String value){values.put("nameSuffix",value);return this;}
public Builder fax(String value){values.put("fax",value);return this;}
public Builder specialties(List<TeamInvitationCreateParamsProfileDetailsSpecialtiesItem> value){values.put("specialties",value);return this;}
public Builder addresses(List<TeamInvitationCreateParamsProfileDetailsAddressesItem> value){values.put("addresses",value);return this;}
public Builder otherNames(List<TeamInvitationCreateParamsProfileDetailsOtherNamesItem> value){values.put("otherNames",value);return this;}
public Builder identifiers(List<TeamInvitationCreateParamsProfileDetailsIdentifiersItem> value){values.put("identifiers",value);return this;}
public Builder endpoints(List<TeamInvitationCreateParamsProfileDetailsEndpointsItem> value){values.put("endpoints",value);return this;}
public Builder certifications(List<TeamInvitationCreateParamsProfileDetailsCertificationsItem> value){values.put("certifications",value);return this;}public TeamInvitationCreateParamsProfileDetails build(){return new TeamInvitationCreateParamsProfileDetails(values);}}}