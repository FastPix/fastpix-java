package io.fastpix.sdk.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class QueryParameters {

    private static final String DEEP_OBJECT_KEY_FORMAT = "%s[%s]";

    private QueryParameters() {
        // Utility class, prevent instantiation
    }

    // This metadata-driven query builder walks reflective fields and skips several non-applicable
    // cases inline; reflection is required to read arbitrary request types and restructuring the
    // skips would change the parsing flow, so the related findings are suppressed.
    @SuppressWarnings({"java:S3776", "java:S135", "java:S3011", "java:S112"})
    public static <T extends Object> List<QueryParameter> parseQueryParams(Class<T> type, T queryParams,
            Globals globals) throws Exception {
        List<QueryParameter> allParams = new ArrayList<>();

        Field[] fields = type.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            
            Object value = queryParams != null ? field.get(queryParams) : null;
            value = Utils.resolveStringShape(type, field.getName(), value); 
            value = Utils.resolveOptionals(value);
            
            value = Utils.populateGlobal(value, field.getName(), "queryParam", globals);
            if (value == null) {
                continue;
            }

            QueryParamsMetadata queryParamsMetadata = QueryParamsMetadata.parse(field);
            if (queryParamsMetadata == null) {
                continue;
            }

            if (queryParamsMetadata.serialization != null && !queryParamsMetadata.serialization.isBlank()) {
                List<QueryParameter> params = parseSerializedParams(queryParamsMetadata, value);
                allParams.addAll(params);
            } else {
                switch (queryParamsMetadata.style) {
                    case "form":
                        List<QueryParameter> formParams = parseDelimitedParams(queryParamsMetadata, value, ",");
                        allParams.addAll(formParams);
                        break;
                    case "deepObject":
                        List<QueryParameter> deepObjectParams = parseDeepObjectParams(queryParamsMetadata, value);
                        allParams.addAll(deepObjectParams);
                        break;
                    case "pipeDelimited":
                        List<QueryParameter> pipeDelimitedParams = parseDelimitedParams(queryParamsMetadata, value, "|");
                        allParams.addAll(pipeDelimitedParams);
                        break;
                    default:
                        break;
                }
            }
        }

        // include all global params in query params if not already present
        if (globals != null) {
            Set<String> allParamNames = allParams.stream()
                .map(QueryParameter::name)
                .collect(Collectors.toSet());
            globals.queryParamsAsStream()
                .filter(entry -> !allParamNames.contains(entry.getKey()))
                .forEach(entry ->
                        allParams.add(QueryParameter.of(entry.getKey(),
                            entry.getValue(), false)));
        }
        
        return allParams;
    }

    private static List<QueryParameter> parseSerializedParams(QueryParamsMetadata queryParamsMetadata, Object value)
            throws JsonProcessingException {
        List<QueryParameter> params = new ArrayList<>();
        if ("json".equals(queryParamsMetadata.serialization)) {
            ObjectMapper mapper = JSON.getMapper();
            String json = mapper.writeValueAsString(value);
            params.add(QueryParameter.of(queryParamsMetadata.name, json, queryParamsMetadata.allowReserved));
        }
        return params;
    }

    // This delimited-style builder branches over array, map and object shapes and uses reflection to
    // read object fields; consolidating it would change the serialization flow, so the brain-method,
    // complexity and reflective-accessibility findings are suppressed.
    @SuppressWarnings({"java:S3776", "java:S6541", "java:S3011", "java:S135"})
    private static List<QueryParameter> parseDelimitedParams(QueryParamsMetadata queryParamsMetadata, Object value, String delimiter)
            throws IllegalArgumentException, IllegalAccessException {
        List<QueryParameter> params = new ArrayList<>();

        switch (Types.getType(value.getClass())) {
            case ARRAY: {
                final List<?> array = Utils.toList(value);
                List<String> values = new ArrayList<>();
                List<String> items = new ArrayList<>();

                for (Object v : array) {
                    if (queryParamsMetadata.explode) {
                        values.add(Utils.valToString(v));
                    } else {
                        items.add(Utils.valToString(v));
                    }
                }

                if (!items.isEmpty()) {
                    values.add(String.join(delimiter, items));
                }

                params.addAll(values.stream().map(v -> QueryParameter.of(queryParamsMetadata.name, v, queryParamsMetadata.allowReserved))
                        .collect(Collectors.toList()));
                break;
            }
            case MAP: {
                Map<?, ?> map = (Map<?, ?>) value;

                List<String> items = new ArrayList<>();

                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    String key = Utils.valToString(entry.getKey());
                    String val = Utils.valToString(entry.getValue());

                    if (queryParamsMetadata.explode) {
                        params.add(QueryParameter.of(key, val, queryParamsMetadata.allowReserved));
                    } else {
                        items.add(String.format("%s%s%s", key, delimiter, val));
                    }
                }

                if (!items.isEmpty()) {
                    params.add(QueryParameter.of(queryParamsMetadata.name, String.join(delimiter, items), queryParamsMetadata.allowReserved));
                }
                break;
            }
            case OBJECT: {
                if (!Utils.allowIntrospection(value.getClass())) {
                    params.add(QueryParameter.of(queryParamsMetadata.name, Utils.valToString(value), queryParamsMetadata.allowReserved));
                    break;
                }
                Optional<?> unwrappedEnumValue = Reflections.getUnwrappedEnumValue(value.getClass(), value);
                if (unwrappedEnumValue.isPresent()) {
                    params.add(QueryParameter.of(queryParamsMetadata.name, Utils.valToString(unwrappedEnumValue.get()), queryParamsMetadata.allowReserved));
                    break;
                }
                Field[] fields = value.getClass().getDeclaredFields();

                List<String> items = new ArrayList<>();

                for (Field field : fields) {
                    field.setAccessible(true);
                    Object val = field.get(value);
                    val = Utils.resolveOptionals(val);
                    if (val == null) {
                        continue;
                    }

                    QueryParamsMetadata metadata = QueryParamsMetadata.parse(field);
                    if (metadata == null) {
                        continue;
                    }

                    if (queryParamsMetadata.explode) {
                        params.add(QueryParameter.of(metadata.name, Utils.valToString(val), metadata.allowReserved));
                    } else {
                        items.add(String.format("%s%s%s", metadata.name, delimiter, Utils.valToString(val)));
                    }
                }

                if (!items.isEmpty()) {
                    params.add(QueryParameter.of(queryParamsMetadata.name, String.join(delimiter, items), queryParamsMetadata.allowReserved));
                }
                break;
            }
            default:
                params.add(QueryParameter.of(queryParamsMetadata.name, Utils.valToString(value), queryParamsMetadata.allowReserved));
                break;
        }

        return params;
    }

    // This deepObject builder branches over map and object shapes and uses reflection to read object
    // fields; restructuring it would change the serialization flow, so the complexity and reflective
    // accessibility findings are suppressed.
    @SuppressWarnings({"java:S3776", "java:S3011", "java:S135"})
    private static List<QueryParameter> parseDeepObjectParams(QueryParamsMetadata queryParamsMetadata, Object value)
        throws IllegalArgumentException, IllegalAccessException {
        
        List<QueryParameter> params = new ArrayList<>();

        switch (Types.getType(value.getClass())) {
            case MAP: {
                Map<?, ?> map = (Map<?, ?>) value;

                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    String key = Utils.valToString(entry.getKey());
                    Object val = Utils.resolveOptionals(entry.getValue());

                    if (val instanceof List || val.getClass().isArray()) {
                        for (Object v : Utils.toList(val)) {
                            params.add(QueryParameter.of(String.format(DEEP_OBJECT_KEY_FORMAT, queryParamsMetadata.name, key),
                                    Utils.valToString(v), queryParamsMetadata.allowReserved));
                        }
                    } else {
                        params.add(QueryParameter.of(String.format(DEEP_OBJECT_KEY_FORMAT, queryParamsMetadata.name, key),
                                Utils.valToString(val), queryParamsMetadata.allowReserved));
                    }
                }

                return params;
            }
            case OBJECT: {
                if (!Utils.allowIntrospection(value.getClass())) {
                    throw new IllegalArgumentException("DeepObject style only supports Map and Object types, not " + value.getClass());
                }

                Field[] fields = value.getClass().getDeclaredFields();

                for (Field field : fields) {
                    field.setAccessible(true);
                    Object val = field.get(value);
                    val = Utils.resolveOptionals(val);
                    if (val == null) {
                        continue;
                    }

                    QueryParamsMetadata metadata = QueryParamsMetadata.parse(field);
                    if (metadata == null) {
                        continue;
                    }

                    if (val instanceof List || val.getClass().isArray()) {
                        for (Object v : Utils.toList(val)) {
                            params.add(QueryParameter.of(
                                    String.format(DEEP_OBJECT_KEY_FORMAT, queryParamsMetadata.name, metadata.name),
                                    Utils.valToString(v), metadata.allowReserved));
                        }
                    } else {
                        params.add(
                                QueryParameter.of(String.format(DEEP_OBJECT_KEY_FORMAT, queryParamsMetadata.name, metadata.name),
                                        Utils.valToString(val), metadata.allowReserved));
                    }
                }

                return params;
            }
            default:
                throw new IllegalArgumentException("DeepObject style only supports Map and Object types");
        }
    }
}
