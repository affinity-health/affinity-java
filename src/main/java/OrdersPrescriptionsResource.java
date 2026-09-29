package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class OrdersPrescriptionsResource{private final SdkContext context;OrdersPrescriptionsResource(SdkContext context){this.context=context;}
public AddOrderPrescriptionResponse add(String orderId,OrderPrescriptionAddParams params,RequestOptions options){return context.call("addOrderPrescription",new String[]{orderId},params,options,new TypeReference<AddOrderPrescriptionResponse>(){});}
public AddOrderPrescriptionResponse add(String orderId,OrderPrescriptionAddParams params){return add(orderId,params,null);}
public UpdateOrderPrescriptionResponse update(String orderId,String prescriptionId,OrderPrescriptionUpdateParams params,RequestOptions options){return context.call("updateOrderPrescription",new String[]{orderId,prescriptionId},params,options,new TypeReference<UpdateOrderPrescriptionResponse>(){});}
public UpdateOrderPrescriptionResponse update(String orderId,String prescriptionId,OrderPrescriptionUpdateParams params){return update(orderId,prescriptionId,params,null);}
}
