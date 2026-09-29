package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class PatientsAllergiesResource{private final SdkContext context;PatientsAllergiesResource(SdkContext context){this.context=context;}
public GetPatientAllergiesResponse get(String patientId,RequestOptions options){return context.call("getPatientAllergies",new String[]{patientId},null,options,new TypeReference<GetPatientAllergiesResponse>(){});}
public GetPatientAllergiesResponse get(String patientId){return get(patientId,null);}
public ReplacePatientAllergiesResponse replace(String patientId,PatientAllergyReplaceParams params,RequestOptions options){return context.call("replacePatientAllergies",new String[]{patientId},params,options,new TypeReference<ReplacePatientAllergiesResponse>(){});}
public ReplacePatientAllergiesResponse replace(String patientId,PatientAllergyReplaceParams params){return replace(patientId,params,null);}
}
