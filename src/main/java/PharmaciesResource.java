package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class PharmaciesResource{private final SdkContext context;PharmaciesResource(SdkContext context){this.context=context;}
public ListPharmaciesResponse list(PharmacyListParams params,RequestOptions options){return context.call("listPharmacies",new String[]{},params,options,new TypeReference<ListPharmaciesResponse>(){});}
public ListPharmaciesResponse list(PharmacyListParams params){return list(params,null);}
public Iterable<ListPharmaciesResponseDataItem> iterate(PharmacyListParams params,RequestOptions options){return context.iterate("listPharmacies",new String[]{},params,options,new TypeReference<ListPharmaciesResponseDataItem>(){});}public Iterable<ListPharmaciesResponseDataItem> iterate(PharmacyListParams params){return iterate(params,null);}
}
