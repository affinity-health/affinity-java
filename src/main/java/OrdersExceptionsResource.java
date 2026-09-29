package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class OrdersExceptionsResource{private final SdkContext context;OrdersExceptionsResource(SdkContext context){this.context=context;}
public ActOnOrderExceptionResponse act(String orderId,String exceptionId,OrderExceptionActParams params,RequestOptions options){return context.call("actOnOrderException",new String[]{orderId,exceptionId},params,options,new TypeReference<ActOnOrderExceptionResponse>(){});}
public ActOnOrderExceptionResponse act(String orderId,String exceptionId,OrderExceptionActParams params){return act(orderId,exceptionId,params,null);}
}
