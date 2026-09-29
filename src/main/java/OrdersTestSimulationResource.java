package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class OrdersTestSimulationResource{private final SdkContext context;OrdersTestSimulationResource(SdkContext context){this.context=context;}
public GetOrderTestSimulationResponse get(String orderId,RequestOptions options){return context.call("getOrderTestSimulation",new String[]{orderId},null,options,new TypeReference<GetOrderTestSimulationResponse>(){});}
public GetOrderTestSimulationResponse get(String orderId){return get(orderId,null);}
public UpdateOrderTestSimulationResponse update(String orderId,OrderTestSimulationUpdateParams params,RequestOptions options){return context.call("updateOrderTestSimulation",new String[]{orderId},params,options,new TypeReference<UpdateOrderTestSimulationResponse>(){});}
public UpdateOrderTestSimulationResponse update(String orderId,OrderTestSimulationUpdateParams params){return update(orderId,params,null);}
}
