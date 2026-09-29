package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class OrdersBatchesResource{private final SdkContext context;OrdersBatchesResource(SdkContext context){this.context=context;}
public CreateOrderBatchResponse create(OrderBatchCreateParams params,RequestOptions options){return context.call("createOrderBatch",new String[]{},params,options,new TypeReference<CreateOrderBatchResponse>(){});}
public CreateOrderBatchResponse create(OrderBatchCreateParams params){return create(params,null);}
}
