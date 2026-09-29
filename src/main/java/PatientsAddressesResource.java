package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class PatientsAddressesResource{private final SdkContext context;PatientsAddressesResource(SdkContext context){this.context=context;}
public ListPatientAddressesResponse list(String patientId,PatientAddressListParams params,RequestOptions options){return context.call("listPatientAddresses",new String[]{patientId},params,options,new TypeReference<ListPatientAddressesResponse>(){});}
public ListPatientAddressesResponse list(String patientId,PatientAddressListParams params){return list(patientId,params,null);}
public Iterable<ListPatientAddressesResponseDataItem> iterate(String patientId,PatientAddressListParams params,RequestOptions options){return context.iterate("listPatientAddresses",new String[]{patientId},params,options,new TypeReference<ListPatientAddressesResponseDataItem>(){});}public Iterable<ListPatientAddressesResponseDataItem> iterate(String patientId,PatientAddressListParams params){return iterate(patientId,params,null);}
public CreatePatientAddressResponse create(String patientId,PatientAddressCreateParams params,RequestOptions options){return context.call("createPatientAddress",new String[]{patientId},params,options,new TypeReference<CreatePatientAddressResponse>(){});}
public CreatePatientAddressResponse create(String patientId,PatientAddressCreateParams params){return create(patientId,params,null);}
public UpdatePatientAddressResponse update(String patientId,String addressId,PatientAddressUpdateParams params,RequestOptions options){return context.call("updatePatientAddress",new String[]{patientId,addressId},params,options,new TypeReference<UpdatePatientAddressResponse>(){});}
public UpdatePatientAddressResponse update(String patientId,String addressId,PatientAddressUpdateParams params){return update(patientId,addressId,params,null);}
public ArchivePatientAddressResponse archive(String patientId,String addressId,RequestOptions options){return context.call("archivePatientAddress",new String[]{patientId,addressId},null,options,new TypeReference<ArchivePatientAddressResponse>(){});}
public ArchivePatientAddressResponse archive(String patientId,String addressId){return archive(patientId,addressId,null);}
public SetDefaultPatientAddressResponse setDefault(String patientId,String addressId,RequestOptions options){return context.call("setDefaultPatientAddress",new String[]{patientId,addressId},null,options,new TypeReference<SetDefaultPatientAddressResponse>(){});}
public SetDefaultPatientAddressResponse setDefault(String patientId,String addressId){return setDefault(patientId,addressId,null);}
}
