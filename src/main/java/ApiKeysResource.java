package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class ApiKeysResource{private final SdkContext context;ApiKeysResource(SdkContext context){this.context=context;}
public CreatePlatformPracticeApiKeyResponse create(ApiKeyCreateParams params,RequestOptions options){return context.call("createPlatformPracticeApiKey",new String[]{},params,options,new TypeReference<CreatePlatformPracticeApiKeyResponse>(){});}
public CreatePlatformPracticeApiKeyResponse create(ApiKeyCreateParams params){return create(params,null);}
public GetApiAccessResponse getAccess(RequestOptions options){return context.call("getApiAccess",new String[]{},null,options,new TypeReference<GetApiAccessResponse>(){});}
public GetApiAccessResponse getAccess(){return getAccess(null);}
}
