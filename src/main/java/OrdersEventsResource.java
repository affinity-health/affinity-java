package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class OrdersEventsResource{private final SdkContext context;OrdersEventsResource(SdkContext context){this.context=context;}
public ListOrderEventsResponse list(String orderId,OrderEventListParams params,RequestOptions options){return context.call("listOrderEvents",new String[]{orderId},params,options,new TypeReference<ListOrderEventsResponse>(){});}
public ListOrderEventsResponse list(String orderId,OrderEventListParams params){return list(orderId,params,null);}
public Iterable<ListOrderEventsResponseDataItem> iterate(String orderId,OrderEventListParams params,RequestOptions options){return context.iterate("listOrderEvents",new String[]{orderId},params,options,new TypeReference<ListOrderEventsResponseDataItem>(){});}public Iterable<ListOrderEventsResponseDataItem> iterate(String orderId,OrderEventListParams params){return iterate(orderId,params,null);}
}
