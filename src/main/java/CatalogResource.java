package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class CatalogResource{private final SdkContext context;CatalogResource(SdkContext context){this.context=context;}
public CatalogItemsResource items(){return new CatalogItemsResource(context);}
public CatalogPrescribingOptionsResource prescribingOptions(){return new CatalogPrescribingOptionsResource(context);}
public CatalogSellingPricesResource sellingPrices(){return new CatalogSellingPricesResource(context);}
public CatalogShippingOptionsResource shippingOptions(){return new CatalogShippingOptionsResource(context);}
}
