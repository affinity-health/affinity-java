package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class CatalogPresentationPricesResource{private final SdkContext context;CatalogPresentationPricesResource(SdkContext context){this.context=context;}
public PlatformPublicApiSellingPricesReadPresentationPriceResponse get(String catalogItemId,RequestOptions options){return context.call("platform.public-api.selling-prices.readPresentationPrice",new String[]{catalogItemId},null,options,new TypeReference<PlatformPublicApiSellingPricesReadPresentationPriceResponse>(){});}
public PlatformPublicApiSellingPricesReadPresentationPriceResponse get(String catalogItemId){return get(catalogItemId,null);}
}
