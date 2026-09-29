package com.affinity.api;
public final class Affinity{private final SdkContext context;public Affinity(String apiKey){this(apiKey,new ClientOptions());}public Affinity(String apiKey,ClientOptions options){this.context=new SdkContext(new SdkTransport(apiKey,options),null);}private Affinity(SdkContext context){this.context=context;}public Affinity forPractice(String practiceId){if(practiceId==null||practiceId.isBlank())throw new IllegalArgumentException("practiceId is required");if(context.practiceId!=null&&!context.practiceId.equals(practiceId))throw new IllegalArgumentException("Conflicting practice ID");return new Affinity(new SdkContext(context.transport,practiceId));}public AccountResource account(){return new AccountResource(context);}
public ApiKeysResource apiKeys(){return new ApiKeysResource(context);}
public CatalogResource catalog(){return new CatalogResource(context);}
public LocationsResource locations(){return new LocationsResource(context);}
public OrdersResource orders(){return new OrdersResource(context);}
public PatientsResource patients(){return new PatientsResource(context);}
public PharmaciesResource pharmacies(){return new PharmaciesResource(context);}
public PracticesResource practices(){return new PracticesResource(context);}
public TeamResource team(){return new TeamResource(context);}
public WebhooksResource webhooks(){return new WebhooksResource(context);}}