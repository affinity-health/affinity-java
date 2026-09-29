package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class PatientsResource{private final SdkContext context;PatientsResource(SdkContext context){this.context=context;}
public PatientsAddressesResource addresses(){return new PatientsAddressesResource(context);}
public PatientsAllergiesResource allergies(){return new PatientsAllergiesResource(context);}
public ListPatientsResponse list(PatientListParams params,RequestOptions options){return context.call("listPatients",new String[]{},params,options,new TypeReference<ListPatientsResponse>(){});}
public ListPatientsResponse list(PatientListParams params){return list(params,null);}
public Iterable<ListPatientsResponseDataItem> iterate(PatientListParams params,RequestOptions options){return context.iterate("listPatients",new String[]{},params,options,new TypeReference<ListPatientsResponseDataItem>(){});}public Iterable<ListPatientsResponseDataItem> iterate(PatientListParams params){return iterate(params,null);}
public CreatePatientResponse create(PatientCreateParams params,RequestOptions options){return context.call("createPatient",new String[]{},params,options,new TypeReference<CreatePatientResponse>(){});}
public CreatePatientResponse create(PatientCreateParams params){return create(params,null);}
public GetPatientResponse get(String patientId,RequestOptions options){return context.call("getPatient",new String[]{patientId},null,options,new TypeReference<GetPatientResponse>(){});}
public GetPatientResponse get(String patientId){return get(patientId,null);}
public DeletePatientResponse delete(String patientId,RequestOptions options){return context.call("deletePatient",new String[]{patientId},null,options,new TypeReference<DeletePatientResponse>(){});}
public DeletePatientResponse delete(String patientId){return delete(patientId,null);}
public UpdatePatientResponse update(String patientId,PatientUpdateParams params,RequestOptions options){return context.call("updatePatient",new String[]{patientId},params,options,new TypeReference<UpdatePatientResponse>(){});}
public UpdatePatientResponse update(String patientId,PatientUpdateParams params){return update(patientId,params,null);}
}
