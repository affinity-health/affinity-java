package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class TeamResource{private final SdkContext context;TeamResource(SdkContext context){this.context=context;}
public TeamInvitationsResource invitations(){return new TeamInvitationsResource(context);}
public TeamMembersResource members(){return new TeamMembersResource(context);}
public TeamPrescribersResource prescribers(){return new TeamPrescribersResource(context);}
public RegisterUserResponse register(TeamRegisterParams params,RequestOptions options){return context.call("registerUser",new String[]{},params,options,new TypeReference<RegisterUserResponse>(){});}
public RegisterUserResponse register(TeamRegisterParams params){return register(params,null);}
public GetPracticeTeamResponse get(RequestOptions options){return context.call("getPracticeTeam",new String[]{},null,options,new TypeReference<GetPracticeTeamResponse>(){});}
public GetPracticeTeamResponse get(){return get(null);}
}
