package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class WebhooksEndpointsResource{private final SdkContext context;WebhooksEndpointsResource(SdkContext context){this.context=context;}
public ListWebhookEndpointsResponse list(WebhookEndpointListParams params,RequestOptions options){return context.call("listWebhookEndpoints",new String[]{},params,options,new TypeReference<ListWebhookEndpointsResponse>(){});}
public ListWebhookEndpointsResponse list(WebhookEndpointListParams params){return list(params,null);}
public Iterable<ListWebhookEndpointsResponseDataItem> iterate(WebhookEndpointListParams params,RequestOptions options){return context.iterate("listWebhookEndpoints",new String[]{},params,options,new TypeReference<ListWebhookEndpointsResponseDataItem>(){});}public Iterable<ListWebhookEndpointsResponseDataItem> iterate(WebhookEndpointListParams params){return iterate(params,null);}
public CreateWebhookEndpointResponse create(WebhookEndpointCreateParams params,RequestOptions options){return context.call("createWebhookEndpoint",new String[]{},params,options,new TypeReference<CreateWebhookEndpointResponse>(){});}
public CreateWebhookEndpointResponse create(WebhookEndpointCreateParams params){return create(params,null);}
public UpdateWebhookEndpointResponse update(String endpointId,WebhookEndpointUpdateParams params,RequestOptions options){return context.call("updateWebhookEndpoint",new String[]{endpointId},params,options,new TypeReference<UpdateWebhookEndpointResponse>(){});}
public UpdateWebhookEndpointResponse update(String endpointId,WebhookEndpointUpdateParams params){return update(endpointId,params,null);}
public DeleteWebhookEndpointResponse delete(String endpointId,RequestOptions options){return context.call("deleteWebhookEndpoint",new String[]{endpointId},null,options,new TypeReference<DeleteWebhookEndpointResponse>(){});}
public DeleteWebhookEndpointResponse delete(String endpointId){return delete(endpointId,null);}
public RotateWebhookEndpointSecretResponse rotateSecret(String endpointId,RequestOptions options){return context.call("rotateWebhookEndpointSecret",new String[]{endpointId},null,options,new TypeReference<RotateWebhookEndpointSecretResponse>(){});}
public RotateWebhookEndpointSecretResponse rotateSecret(String endpointId){return rotateSecret(endpointId,null);}
public TestWebhookEndpointResponse test(String endpointId,RequestOptions options){return context.call("testWebhookEndpoint",new String[]{endpointId},null,options,new TypeReference<TestWebhookEndpointResponse>(){});}
public TestWebhookEndpointResponse test(String endpointId){return test(endpointId,null);}
}
