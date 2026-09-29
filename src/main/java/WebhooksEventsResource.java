package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class WebhooksEventsResource{private final SdkContext context;WebhooksEventsResource(SdkContext context){this.context=context;}
public ListWebhookEventsResponse list(WebhookEventListParams params,RequestOptions options){return context.call("listWebhookEvents",new String[]{},params,options,new TypeReference<ListWebhookEventsResponse>(){});}
public ListWebhookEventsResponse list(WebhookEventListParams params){return list(params,null);}
public Iterable<ListWebhookEventsResponseDataItem> iterate(WebhookEventListParams params,RequestOptions options){return context.iterate("listWebhookEvents",new String[]{},params,options,new TypeReference<ListWebhookEventsResponseDataItem>(){});}public Iterable<ListWebhookEventsResponseDataItem> iterate(WebhookEventListParams params){return iterate(params,null);}
public GetWebhookEventResponse get(String eventId,RequestOptions options){return context.call("getWebhookEvent",new String[]{eventId},null,options,new TypeReference<GetWebhookEventResponse>(){});}
public GetWebhookEventResponse get(String eventId){return get(eventId,null);}
public ReplayWebhookEventResponse replay(String eventId,RequestOptions options){return context.call("replayWebhookEvent",new String[]{eventId},null,options,new TypeReference<ReplayWebhookEventResponse>(){});}
public ReplayWebhookEventResponse replay(String eventId){return replay(eventId,null);}
}
