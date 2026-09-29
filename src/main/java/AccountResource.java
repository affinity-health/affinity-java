package com.affinity.api;
import com.affinity.api.models.*;import com.affinity.api.types.*;import com.fasterxml.jackson.core.type.TypeReference;import java.util.*;
public final class AccountResource{private final SdkContext context;AccountResource(SdkContext context){this.context=context;}
public GetAccountResponse get(AccountGetParams params,RequestOptions options){return context.call("getAccount",new String[]{},params,options,new TypeReference<GetAccountResponse>(){});}
public GetAccountResponse get(AccountGetParams params){return get(params,null);}
}
