package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class TeamMembersResource{private final SdkContext context;TeamMembersResource(SdkContext context){this.context=context;}
public ListPracticeTeamMembersResponse list(TeamMemberListParams params,RequestOptions options){return context.call("listPracticeTeamMembers",new String[]{},params,options,new TypeReference<ListPracticeTeamMembersResponse>(){});}
public ListPracticeTeamMembersResponse list(TeamMemberListParams params){return list(params,null);}
public Iterable<ListPracticeTeamMembersResponseDataItem> iterate(TeamMemberListParams params,RequestOptions options){return context.iterate("listPracticeTeamMembers",new String[]{},params,options,new TypeReference<ListPracticeTeamMembersResponseDataItem>(){});}public Iterable<ListPracticeTeamMembersResponseDataItem> iterate(TeamMemberListParams params){return iterate(params,null);}
public GetPracticeTeamMemberResponse get(String memberId,RequestOptions options){return context.call("getPracticeTeamMember",new String[]{memberId},null,options,new TypeReference<GetPracticeTeamMemberResponse>(){});}
public GetPracticeTeamMemberResponse get(String memberId){return get(memberId,null);}
public UpdatePracticeTeamMemberResponse update(String memberId,TeamMemberUpdateParams params,RequestOptions options){return context.call("updatePracticeTeamMember",new String[]{memberId},params,options,new TypeReference<UpdatePracticeTeamMemberResponse>(){});}
public UpdatePracticeTeamMemberResponse update(String memberId,TeamMemberUpdateParams params){return update(memberId,params,null);}
}
