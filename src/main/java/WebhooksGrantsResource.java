package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class WebhooksGrantsResource{private final SdkContext context;WebhooksGrantsResource(SdkContext context){this.context=context;}
public ListWebhookGrantsResponse list(WebhookGrantListParams params,RequestOptions options){return context.call("listWebhookGrants",new String[]{},params,options,new TypeReference<ListWebhookGrantsResponse>(){});}
public ListWebhookGrantsResponse list(WebhookGrantListParams params){return list(params,null);}
public Iterable<ListWebhookGrantsResponseDataItem> iterate(WebhookGrantListParams params,RequestOptions options){return context.iterate("listWebhookGrants",new String[]{},params,options,new TypeReference<ListWebhookGrantsResponseDataItem>(){});}public Iterable<ListWebhookGrantsResponseDataItem> iterate(WebhookGrantListParams params){return iterate(params,null);}
public SaveWebhookGrantResponse save(String platformId,WebhookGrantSaveParams params,RequestOptions options){return context.call("saveWebhookGrant",new String[]{platformId},params,options,new TypeReference<SaveWebhookGrantResponse>(){});}
public SaveWebhookGrantResponse save(String platformId,WebhookGrantSaveParams params){return save(platformId,params,null);}
public RevokeWebhookGrantResponse revoke(String platformId,RequestOptions options){return context.call("revokeWebhookGrant",new String[]{platformId},null,options,new TypeReference<RevokeWebhookGrantResponse>(){});}
public RevokeWebhookGrantResponse revoke(String platformId){return revoke(platformId,null);}
}
