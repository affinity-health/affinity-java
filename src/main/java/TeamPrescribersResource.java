package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class TeamPrescribersResource{private final SdkContext context;TeamPrescribersResource(SdkContext context){this.context=context;}
public TeamPrescribersLicensesResource licenses(){return new TeamPrescribersLicensesResource(context);}
public ListPracticeTeamPrescribersResponse list(TeamPrescriberListParams params,RequestOptions options){return context.call("listPracticeTeamPrescribers",new String[]{},params,options,new TypeReference<ListPracticeTeamPrescribersResponse>(){});}
public ListPracticeTeamPrescribersResponse list(TeamPrescriberListParams params){return list(params,null);}
public Iterable<ListPracticeTeamPrescribersResponseDataItem> iterate(TeamPrescriberListParams params,RequestOptions options){return context.iterate("listPracticeTeamPrescribers",new String[]{},params,options,new TypeReference<ListPracticeTeamPrescribersResponseDataItem>(){});}public Iterable<ListPracticeTeamPrescribersResponseDataItem> iterate(TeamPrescriberListParams params){return iterate(params,null);}
public GetPracticeTeamPrescriberResponse get(String prescriberId,RequestOptions options){return context.call("getPracticeTeamPrescriber",new String[]{prescriberId},null,options,new TypeReference<GetPracticeTeamPrescriberResponse>(){});}
public GetPracticeTeamPrescriberResponse get(String prescriberId){return get(prescriberId,null);}
public UpdatePracticeTeamPrescriberResponse update(String prescriberId,TeamPrescriberUpdateParams params,RequestOptions options){return context.call("updatePracticeTeamPrescriber",new String[]{prescriberId},params,options,new TypeReference<UpdatePracticeTeamPrescriberResponse>(){});}
public UpdatePracticeTeamPrescriberResponse update(String prescriberId,TeamPrescriberUpdateParams params){return update(prescriberId,params,null);}
}
