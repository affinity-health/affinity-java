package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class OrdersResource{private final SdkContext context;OrdersResource(SdkContext context){this.context=context;}
public OrdersBatchesResource batches(){return new OrdersBatchesResource(context);}
public OrdersEventsResource events(){return new OrdersEventsResource(context);}
public OrdersExceptionsResource exceptions(){return new OrdersExceptionsResource(context);}
public OrdersPrescriptionsResource prescriptions(){return new OrdersPrescriptionsResource(context);}
public OrdersTestSimulationResource testSimulation(){return new OrdersTestSimulationResource(context);}
public ListOrdersResponse list(OrderListParams params,RequestOptions options){return context.call("listOrders",new String[]{},params,options,new TypeReference<ListOrdersResponse>(){});}
public ListOrdersResponse list(OrderListParams params){return list(params,null);}
public Iterable<ListOrdersResponseDataItem> iterate(OrderListParams params,RequestOptions options){return context.iterate("listOrders",new String[]{},params,options,new TypeReference<ListOrdersResponseDataItem>(){});}public Iterable<ListOrdersResponseDataItem> iterate(OrderListParams params){return iterate(params,null);}
public CreateOrderResponse create(OrderCreateParams params,RequestOptions options){return context.call("createOrder",new String[]{},params,options,new TypeReference<CreateOrderResponse>(){});}
public CreateOrderResponse create(OrderCreateParams params){return create(params,null);}
public GetOrderResponse get(String orderId,RequestOptions options){return context.call("getOrder",new String[]{orderId},null,options,new TypeReference<GetOrderResponse>(){});}
public GetOrderResponse get(String orderId){return get(orderId,null);}
public CancelOrderResponse cancel(String orderId,OrderCancelParams params,RequestOptions options){return context.call("cancelOrder",new String[]{orderId},params,options,new TypeReference<CancelOrderResponse>(){});}
public CancelOrderResponse cancel(String orderId,OrderCancelParams params){return cancel(orderId,params,null);}
public PreviewOrderResponse preview(OrderPreviewParams params,RequestOptions options){return context.call("previewOrder",new String[]{},params,options,new TypeReference<PreviewOrderResponse>(){});}
public PreviewOrderResponse preview(OrderPreviewParams params){return preview(params,null);}
public SignOrderResponse sign(String orderId,OrderSignParams params,RequestOptions options){return context.call("signOrder",new String[]{orderId},params,options,new TypeReference<SignOrderResponse>(){});}
public SignOrderResponse sign(String orderId,OrderSignParams params){return sign(orderId,params,null);}
public SignAndSubmitOrderResponse signAndSubmit(String orderId,OrderSignAndSubmitParams params,RequestOptions options){return context.call("signAndSubmitOrder",new String[]{orderId},params,options,new TypeReference<SignAndSubmitOrderResponse>(){});}
public SignAndSubmitOrderResponse signAndSubmit(String orderId,OrderSignAndSubmitParams params){return signAndSubmit(orderId,params,null);}
public SubmitOrderResponse submit(String orderId,RequestOptions options){return context.call("submitOrder",new String[]{orderId},null,options,new TypeReference<SubmitOrderResponse>(){});}
public SubmitOrderResponse submit(String orderId){return submit(orderId,null);}
public RejectOrderResponse reject(String orderId,OrderRejectParams params,RequestOptions options){return context.call("rejectOrder",new String[]{orderId},params,options,new TypeReference<RejectOrderResponse>(){});}
public RejectOrderResponse reject(String orderId,OrderRejectParams params){return reject(orderId,params,null);}
}
