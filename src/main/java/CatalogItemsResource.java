package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class CatalogItemsResource{private final SdkContext context;CatalogItemsResource(SdkContext context){this.context=context;}
public ListCatalogItemsResponse list(CatalogItemListParams params,RequestOptions options){return context.call("listCatalogItems",new String[]{},params,options,new TypeReference<ListCatalogItemsResponse>(){});}
public ListCatalogItemsResponse list(CatalogItemListParams params){return list(params,null);}
public Iterable<ListCatalogItemsResponseDataItem> iterate(CatalogItemListParams params,RequestOptions options){return context.iterate("listCatalogItems",new String[]{},params,options,new TypeReference<ListCatalogItemsResponseDataItem>(){});}public Iterable<ListCatalogItemsResponseDataItem> iterate(CatalogItemListParams params){return iterate(params,null);}
}
