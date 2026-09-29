package com.affinity.api.models;
import java.util.*;import com.fasterxml.jackson.annotation.JsonValue;
public final class CatalogItemListParams{private final Map<String,Object> values;private CatalogItemListParams(Map<String,Object> values){this.values=Collections.unmodifiableMap(new LinkedHashMap<>(values));}@JsonValue public Map<String,Object> values(){return values;}public static Builder builder(){return new Builder();}public static final class Builder {private final Map<String,Object> values=new LinkedHashMap<>();public Builder view(String value){values.put("view",value);return this;}
public Builder relatedToCatalogItemId(String value){values.put("relatedToCatalogItemId",value);return this;}
public Builder catalogKind(String value){values.put("catalogKind",value);return this;}
public Builder sort(String value){values.put("sort",value);return this;}
public Builder catalogItemId(String value){values.put("catalogItemId",value);return this;}
public Builder availability(String value){values.put("availability",value);return this;}
public Builder pharmacyIds(Object value){values.put("pharmacyIds",value);return this;}
public Builder dosageForms(Object value){values.put("dosageForms",value);return this;}
public Builder endingBefore(String value){values.put("endingBefore",value);return this;}
public Builder hideControlledSubstances(Boolean value){values.put("hideControlledSubstances",value);return this;}
public Builder hideUnpriced(Boolean value){values.put("hideUnpriced",value);return this;}
public Builder limit(Integer value){values.put("limit",value);return this;}
public Builder orgId(String value){values.put("orgId",value);return this;}
public Builder query(String value){values.put("query",value);return this;}
public Builder requirement(String value){values.put("requirement",value);return this;}
public Builder routes(Object value){values.put("routes",value);return this;}
public Builder startingAfter(String value){values.put("startingAfter",value);return this;}public CatalogItemListParams build(){return new CatalogItemListParams(values);}}}