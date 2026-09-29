package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class TeamPrescribersLicensesResource{private final SdkContext context;TeamPrescribersLicensesResource(SdkContext context){this.context=context;}
public CreatePracticeTeamLicenseResponse create(String prescriberId,TeamPrescriberLicenseCreateParams params,RequestOptions options){return context.call("createPracticeTeamLicense",new String[]{prescriberId},params,options,new TypeReference<CreatePracticeTeamLicenseResponse>(){});}
public CreatePracticeTeamLicenseResponse create(String prescriberId,TeamPrescriberLicenseCreateParams params){return create(prescriberId,params,null);}
public UpdatePracticeTeamLicenseResponse update(String prescriberId,String licenseId,TeamPrescriberLicenseUpdateParams params,RequestOptions options){return context.call("updatePracticeTeamLicense",new String[]{prescriberId,licenseId},params,options,new TypeReference<UpdatePracticeTeamLicenseResponse>(){});}
public UpdatePracticeTeamLicenseResponse update(String prescriberId,String licenseId,TeamPrescriberLicenseUpdateParams params){return update(prescriberId,licenseId,params,null);}
}
