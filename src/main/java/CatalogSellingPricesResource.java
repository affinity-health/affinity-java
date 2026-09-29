package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class CatalogSellingPricesResource{private final SdkContext context;CatalogSellingPricesResource(SdkContext context){this.context=context;}
public PlatformPublicApiSellingPricesReadSellingPriceResponse get(String catalogItemId,RequestOptions options){return context.call("platform.public-api.selling-prices.readSellingPrice",new String[]{catalogItemId},null,options,new TypeReference<PlatformPublicApiSellingPricesReadSellingPriceResponse>(){});}
public PlatformPublicApiSellingPricesReadSellingPriceResponse get(String catalogItemId){return get(catalogItemId,null);}
public PlatformPublicApiSellingPricesUpdateSellingPriceResponse update(String catalogItemId,SellingPriceUpdateParams params,RequestOptions options){return context.call("platform.public-api.selling-prices.updateSellingPrice",new String[]{catalogItemId},params,options,new TypeReference<PlatformPublicApiSellingPricesUpdateSellingPriceResponse>(){});}
public PlatformPublicApiSellingPricesUpdateSellingPriceResponse update(String catalogItemId,SellingPriceUpdateParams params){return update(catalogItemId,params,null);}
}
