package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class LocationsResource{private final SdkContext context;LocationsResource(SdkContext context){this.context=context;}
public ListPracticeLocationsResponse list(LocationListParams params,RequestOptions options){return context.call("listPracticeLocations",new String[]{},params,options,new TypeReference<ListPracticeLocationsResponse>(){});}
public ListPracticeLocationsResponse list(LocationListParams params){return list(params,null);}
public Iterable<ListPracticeLocationsResponseDataItem> iterate(LocationListParams params,RequestOptions options){return context.iterate("listPracticeLocations",new String[]{},params,options,new TypeReference<ListPracticeLocationsResponseDataItem>(){});}public Iterable<ListPracticeLocationsResponseDataItem> iterate(LocationListParams params){return iterate(params,null);}
public CreatePracticeLocationResponse create(LocationCreateParams params,RequestOptions options){return context.call("createPracticeLocation",new String[]{},params,options,new TypeReference<CreatePracticeLocationResponse>(){});}
public CreatePracticeLocationResponse create(LocationCreateParams params){return create(params,null);}
public GetPracticeLocationResponse get(String locationId,RequestOptions options){return context.call("getPracticeLocation",new String[]{locationId},null,options,new TypeReference<GetPracticeLocationResponse>(){});}
public GetPracticeLocationResponse get(String locationId){return get(locationId,null);}
public UpdatePracticeLocationResponse update(String locationId,LocationUpdateParams params,RequestOptions options){return context.call("updatePracticeLocation",new String[]{locationId},params,options,new TypeReference<UpdatePracticeLocationResponse>(){});}
public UpdatePracticeLocationResponse update(String locationId,LocationUpdateParams params){return update(locationId,params,null);}
public ArchivePracticeLocationResponse archive(String locationId,RequestOptions options){return context.call("archivePracticeLocation",new String[]{locationId},null,options,new TypeReference<ArchivePracticeLocationResponse>(){});}
public ArchivePracticeLocationResponse archive(String locationId){return archive(locationId,null);}
}
