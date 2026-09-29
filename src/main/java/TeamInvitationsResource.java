package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class TeamInvitationsResource{private final SdkContext context;TeamInvitationsResource(SdkContext context){this.context=context;}
public InvitePracticeTeamPersonResponse create(TeamInvitationCreateParams params,RequestOptions options){return context.call("invitePracticeTeamPerson",new String[]{},params,options,new TypeReference<InvitePracticeTeamPersonResponse>(){});}
public InvitePracticeTeamPersonResponse create(TeamInvitationCreateParams params){return create(params,null);}
public ListPracticeTeamInvitationsResponse list(TeamInvitationListParams params,RequestOptions options){return context.call("listPracticeTeamInvitations",new String[]{},params,options,new TypeReference<ListPracticeTeamInvitationsResponse>(){});}
public ListPracticeTeamInvitationsResponse list(TeamInvitationListParams params){return list(params,null);}
public Iterable<ListPracticeTeamInvitationsResponseDataItem> iterate(TeamInvitationListParams params,RequestOptions options){return context.iterate("listPracticeTeamInvitations",new String[]{},params,options,new TypeReference<ListPracticeTeamInvitationsResponseDataItem>(){});}public Iterable<ListPracticeTeamInvitationsResponseDataItem> iterate(TeamInvitationListParams params){return iterate(params,null);}
public GetPracticeTeamInvitationResponse get(String invitationId,RequestOptions options){return context.call("getPracticeTeamInvitation",new String[]{invitationId},null,options,new TypeReference<GetPracticeTeamInvitationResponse>(){});}
public GetPracticeTeamInvitationResponse get(String invitationId){return get(invitationId,null);}
public RevokePracticeTeamInvitationResponse revoke(String invitationId,RequestOptions options){return context.call("revokePracticeTeamInvitation",new String[]{invitationId},null,options,new TypeReference<RevokePracticeTeamInvitationResponse>(){});}
public RevokePracticeTeamInvitationResponse revoke(String invitationId){return revoke(invitationId,null);}
public ResendPracticeTeamInvitationResponse resend(String invitationId,RequestOptions options){return context.call("resendPracticeTeamInvitation",new String[]{invitationId},null,options,new TypeReference<ResendPracticeTeamInvitationResponse>(){});}
public ResendPracticeTeamInvitationResponse resend(String invitationId){return resend(invitationId,null);}
}
