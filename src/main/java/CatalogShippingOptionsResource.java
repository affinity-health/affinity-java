package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class CatalogShippingOptionsResource{private final SdkContext context;CatalogShippingOptionsResource(SdkContext context){this.context=context;}
public List<ListShippingOptionsResponseItem> list(String catalogItemId,ShippingOptionListParams params,RequestOptions options){return context.call("listShippingOptions",new String[]{catalogItemId},params,options,new TypeReference<List<ListShippingOptionsResponseItem>>(){});}
public List<ListShippingOptionsResponseItem> list(String catalogItemId,ShippingOptionListParams params){return list(catalogItemId,params,null);}
}
