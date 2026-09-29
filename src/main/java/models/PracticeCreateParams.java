package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class PracticeCreateParams{private final Map<String,Object> values;private PracticeCreateParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder liveEnabled(Boolean value){values.put("liveEnabled",value);return this;}
public Builder address(PracticeCreateParamsAddress value){values.put("address",value);return this;}
public Builder attestations(PracticeCreateParamsAttestations value){values.put("attestations",value);return this;}
public Builder complianceContact(PracticeCreateParamsComplianceContact value){values.put("complianceContact",value);return this;}
public Builder externalId(String value){values.put("externalId",value);return this;}
public Builder legalName(String value){values.put("legalName",value);return this;}
public Builder metadata(Object value){values.put("metadata",value);return this;}
public Builder name(String value){values.put("name",value);return this;}
public Builder prescribers(List<PracticeCreateParamsPrescribersItem> value){values.put("prescribers",value);return this;}
public Builder primaryContact(PracticeCreateParamsPrimaryContact value){values.put("primaryContact",value);return this;}
public Builder supportEmail(String value){values.put("supportEmail",value);return this;}
public Builder supportPhone(String value){values.put("supportPhone",value);return this;}
public Builder timezone(String value){values.put("timezone",value);return this;}public PracticeCreateParams build(){if(!values.containsKey("address")||values.get("address")==null)throw new IllegalArgumentException("address is required");if(!values.containsKey("attestations")||values.get("attestations")==null)throw new IllegalArgumentException("attestations is required");if(!values.containsKey("name")||values.get("name")==null)throw new IllegalArgumentException("name is required");return new PracticeCreateParams(values);}}}