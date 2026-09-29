package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class WebhooksResource{private final SdkContext context;WebhooksResource(SdkContext context){this.context=context;}
public WebhooksEndpointsResource endpoints(){return new WebhooksEndpointsResource(context);}
public WebhooksEventsResource events(){return new WebhooksEventsResource(context);}
public WebhooksGrantsResource grants(){return new WebhooksGrantsResource(context);}
}
