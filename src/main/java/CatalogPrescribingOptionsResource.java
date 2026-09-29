package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class CatalogPrescribingOptionsResource{private final SdkContext context;CatalogPrescribingOptionsResource(SdkContext context){this.context=context;}
public RetrievePrescribingOptionsResponse get(String catalogItemId,RequestOptions options){return context.call("retrievePrescribingOptions",new String[]{catalogItemId},null,options,new TypeReference<RetrievePrescribingOptionsResponse>(){});}
public RetrievePrescribingOptionsResponse get(String catalogItemId){return get(catalogItemId,null);}
}
