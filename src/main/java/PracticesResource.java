package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class PracticesResource{private final SdkContext context;PracticesResource(SdkContext context){this.context=context;}
public ListPracticesResponse list(PracticeListParams params,RequestOptions options){return context.call("listPractices",new String[]{},params,options,new TypeReference<ListPracticesResponse>(){});}
public ListPracticesResponse list(PracticeListParams params){return list(params,null);}
public Iterable<ListPracticesResponseDataItem> iterate(PracticeListParams params,RequestOptions options){return context.iterate("listPractices",new String[]{},params,options,new TypeReference<ListPracticesResponseDataItem>(){});}public Iterable<ListPracticesResponseDataItem> iterate(PracticeListParams params){return iterate(params,null);}
public CreatePracticeResponse create(PracticeCreateParams params,RequestOptions options){return context.call("createPractice",new String[]{},params,options,new TypeReference<CreatePracticeResponse>(){});}
public CreatePracticeResponse create(PracticeCreateParams params){return create(params,null);}
public GetPracticeResponse get(String practiceId,RequestOptions options){return context.call("getPractice",new String[]{practiceId},null,options,new TypeReference<GetPracticeResponse>(){});}
public GetPracticeResponse get(String practiceId){return get(practiceId,null);}
public UpdatePracticeResponse update(String practiceId,PracticeUpdateParams params,RequestOptions options){return context.call("updatePractice",new String[]{practiceId},params,options,new TypeReference<UpdatePracticeResponse>(){});}
public UpdatePracticeResponse update(String practiceId,PracticeUpdateParams params){return update(practiceId,params,null);}
}
