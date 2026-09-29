package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class TeamInvitationCreateParams{private final Map<String,Object> values;private TeamInvitationCreateParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder externalId(String value){values.put("externalId",value);return this;}
public Builder email(String value){values.put("email",value);return this;}
public Builder name(String value){values.put("name",value);return this;}
public Builder role(String value){values.put("role",value);return this;}
public Builder roles(List<String> value){values.put("roles",value);return this;}
public Builder profileDetails(TeamInvitationCreateParamsProfileDetails value){values.put("profileDetails",value);return this;}
public Builder npi(String value){values.put("npi",value);return this;}
public Builder licenses(List<TeamInvitationCreateParamsLicensesItem> value){values.put("licenses",value);return this;}
public Builder legalName(String value){values.put("legalName",value);return this;}
public Builder displayName(String value){values.put("displayName",value);return this;}
public Builder credentials(String value){values.put("credentials",value);return this;}
public Builder address(TeamInvitationCreateParamsAddress value){values.put("address",value);return this;}
public Builder phone(String value){values.put("phone",value);return this;}
public Builder locationIds(List<String> value){values.put("locationIds",value);return this;}public TeamInvitationCreateParams build(){if(!values.containsKey("externalId")||values.get("externalId")==null)throw new IllegalArgumentException("externalId is required");if(!values.containsKey("email")||values.get("email")==null)throw new IllegalArgumentException("email is required");if(!values.containsKey("name")||values.get("name")==null)throw new IllegalArgumentException("name is required");return new TeamInvitationCreateParams(values);}}}