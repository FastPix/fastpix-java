package io.fastpix.sdk.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openapitools.jackson.nullable.JsonNullable;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class RequestBody {
    private static final Map<String, String> SERIALIZATION_METHOD_TO_CONTENT_TYPE = Map.of("json", "application/json",
            "form", "application/x-www-form-urlencoded", "multipart", "multipart/form-data", "raw",
            "application/octet-stream", "string", "text/plain");

    private RequestBody() {
        // prevent instantiation
    }

    // Reflection is used to read the request field of arbitrary generated request types, which requires
    // making the field accessible.
    @SuppressWarnings("java:S3011")
    public static SerializedBody serialize(Object request, String requestField, String serializationMethod,
                                           boolean nullable) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException,
            UnsupportedOperationException, IOException {
        if (request == null) {
            return null;
        }

        if (!nullable && (request instanceof Optional) && ((Optional<?>) request).isEmpty()) {
            request = JsonNullable.undefined();
        }

        if (Types.getType(request.getClass()) != Types.OBJECT) {
            return serializeContentType(requestField, SERIALIZATION_METHOD_TO_CONTENT_TYPE.get(serializationMethod),
                    request);
        }

        Field reqField = null;

        try {
            reqField = request.getClass().getDeclaredField(requestField);
            reqField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            // ignore
        }
        if (reqField == null) {
            return serializeContentType(requestField, SERIALIZATION_METHOD_TO_CONTENT_TYPE.get(serializationMethod),
                    request);
        }

        Object requestValue = reqField.get(request);
        requestValue = Utils.resolveOptionals(requestValue);
        if (requestValue == null) {
            return null;
        }

        RequestMetadata requestMetadata = RequestMetadata.parse(reqField);
        if (requestMetadata == null) {
            throw new IllegalStateException("Missing request metadata on request field");
        }

        return serializeContentType(requestField, requestMetadata.mediaType, requestValue);
    }

    private static SerializedBody serializeContentType(String fieldName, String contentType, Object value)
            throws IllegalArgumentException, IllegalAccessException, UnsupportedOperationException, IOException {
        // Media-type matching uses plain String checks rather than regular expressions: these tests are
        // simple prefix/contains comparisons, so String methods run in guaranteed linear time and avoid
        // the super-linear backtracking risk that regex quantifiers carry. The matched set is unchanged:
        // a "json" body is any application/* or text/* type whose subtype contains "json" (including a
        // +json vendor suffix).
        final boolean isText = "text/plain".equals(contentType);
        final boolean isJson = (contentType.startsWith("application/") || contentType.startsWith("text/"))
                && contentType.contains("json");
        final boolean isMultipart = contentType.startsWith("multipart/");
        final boolean isForm = contentType.startsWith("application/x-www-form-urlencoded");

        if (isText) {
            return new SerializedBody(contentType, BodyPublishers.ofString(value.toString()));
        } else if (isJson) {
            return serializeJson(contentType, value);
        } else if (isMultipart) {
            return serializeMultipart(value);
        } else if (isForm) {
            return serializeFormData(value);
        }
        return serializeRaw(fieldName, contentType, value);
    }

    private static SerializedBody serializeJson(String contentType, Object value) throws IOException {
        if (value instanceof JsonNullable && !((JsonNullable<?>) value).isPresent()) {
            return new SerializedBody(contentType, BodyPublishers.noBody());
        }
        ObjectMapper mapper = JSON.getMapper();
        return new SerializedBody(contentType, BodyPublishers.ofString(mapper.writeValueAsString(value)));
    }

    private static SerializedBody serializeRaw(String fieldName, String contentType, Object value) {
        if (value instanceof String) {
            return new SerializedBody(contentType, BodyPublishers.ofString((String) value));
        } else if (value instanceof byte[]) {
            return new SerializedBody(contentType, BodyPublishers.ofByteArray((byte[]) value));
        } else if (value instanceof HttpRequest.BodyPublisher) {
            return new SerializedBody(contentType, (HttpRequest.BodyPublisher) value);
        }
        throw new IllegalArgumentException("Unsupported content type " + contentType + " for field " + fieldName);
    }

    // This multipart serializer walks reflective fields and branches over file, json and scalar shapes,
    // skipping non-applicable fields inline; reflection is required to read arbitrary request types and
    // restructuring the branches would change the serialization flow.
    @SuppressWarnings({"java:S3776", "java:S135", "java:S3011"})
    private static SerializedBody serializeMultipart(Object value)
            throws IllegalArgumentException, IllegalAccessException, UnsupportedOperationException, IOException {
        Multipart.Builder builder = Multipart.builder();

        Field[] fields = value.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            Object val = Utils.resolveOptionals(field.get(value));

            if (val == null) {
                continue;
            }

            MultipartFormMetadata metadata = MultipartFormMetadata.parse(field);
            if (metadata == null) {
                throw new IllegalStateException("Missing multipart form metadata on field " + field.getName());
            }

            if (metadata.file) {
                if (val instanceof List || val.getClass().isArray()) {
                    // Handle file arrays
                    List<?> arr = Utils.toList(val);
                    for (Object item : arr) {
                        serializeMultipartFile(metadata.name, builder, item);
                    }
                } else {
                    // Handle single file
                    serializeMultipartFile(metadata.name, builder, val);
                }
            } else if (metadata.json) {
                ObjectMapper mapper = JSON.getMapper();
                String json = mapper.writeValueAsString(val);
                builder.addPart(metadata.name, json, "application/json");
            } else {
                if (val instanceof List || val.getClass().isArray()) {
                    List<?> arr = Utils.toList(val);
                    for (Object item : arr) {
                        builder.addPart(metadata.name, Utils.valToString(item));
                    }
                } else {
                    builder.addPart(metadata.name, Utils.valToString(val));
                }
            }
        }

        Multipart m = builder.build();
        return new SerializedBody(m.contentType(), m.bodyPublisher());
    }

    // Reflection is required to read the content and filename fields of arbitrary file wrapper types,
    // and the field scan skips non-applicable fields inline; restructuring would change the flow.
    @SuppressWarnings({"java:S3776", "java:S135", "java:S3011"})
    private static void serializeMultipartFile(String fieldName, Multipart.Builder builder, Object file)
            throws IllegalArgumentException, IllegalAccessException {
        if (Types.getType(file.getClass()) != Types.OBJECT) {
            throw new IllegalArgumentException("Invalid type for multipart file");
        }

        String fileName = "";
        Object content = null;

        Field[] fields = file.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object val = field.get(file);

            if (val == null) {
                continue;
            }

            MultipartFormMetadata metadata = MultipartFormMetadata.parse(field);
            if (metadata == null || (!metadata.content && (metadata.name == null || metadata.name.isBlank()))) {
                continue;
            }

            if (metadata.content) {
                content = val;
            } else {
                fileName = Utils.valToString(val);
            }
        }

        if (fileName.isBlank() || content == null) {
            throw new IllegalArgumentException("Invalid multipart file");
        }
        
        // Detect content type based on file extension
        String contentType = "application/octet-stream"; // default fallback
        try {
            String detectedType = Files.probeContentType(Path.of(fileName));
            if (detectedType != null && !detectedType.isEmpty()) {
                contentType = detectedType;
            }
        } catch (Exception e) {
            // If detection fails, use the default fallback
        }
        if (content instanceof byte[]) {
            builder.addPart(fieldName, (byte[]) content, fileName,  contentType);
        } else {
            builder.addPart(fieldName, (Blob) content, fileName,  contentType);
        }
    }

    // This form-data serializer branches over map, object and array shapes (nested), using reflection to
    // read arbitrary request types and skipping non-applicable fields inline; consolidating it would
    // change the established serialization flow.
    @SuppressWarnings({"java:S3776", "java:S6541", "java:S135", "java:S3011"})
    public static SerializedBody serializeFormData(Object value)
            throws IOException, IllegalArgumentException, IllegalAccessException {
        List<NameValue> params = new ArrayList<>();

        switch (Types.getType(value.getClass())) {
        case MAP:
            Map<?, ?> map = (Map<?, ?>) value;

            for (Map.Entry<?, ?> entry : map.entrySet()) {
                params.add(
                        new NameValue(Utils.valToString(entry.getKey()), Utils.valToString(entry.getValue())));
            }
            break;
        case OBJECT:
            if (!Utils.allowIntrospection(value.getClass())) {
                throw new IllegalArgumentException("Invalid type for form data");
            }
            Field[] fields = value.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                Object val = Utils.resolveOptionals(field.get(value));

                if (val == null) {
                    continue;
                }

                FormMetadata metadata = FormMetadata.parse(field);
                if (metadata == null) {
                    continue;
                }

                if (metadata.json) {
                    ObjectMapper mapper = JSON.getMapper();
                    String json = mapper.writeValueAsString(val);
                    params.add(new NameValue(metadata.name, json));
                } else {
                    switch (Types.getType(val.getClass())) {
                    case OBJECT: {
                        // Check if it's an enum wrapper first
                        Optional<?> unwrappedEnumValue = Reflections.getUnwrappedEnumValue(val.getClass(), val);
                        if (unwrappedEnumValue.isPresent()) {
                            params.add(new NameValue(metadata.name, Utils.valToString(unwrappedEnumValue.get())));
                            break;
                        }
                        
                        if (!Utils.allowIntrospection(val.getClass())) {
                            params.add(new NameValue(metadata.name, String.valueOf(val)));
                        } else {

                            Field[] valFields = val.getClass().getDeclaredFields();

                            List<String> items = new ArrayList<>();

                            for (Field valField : valFields) {
                                valField.setAccessible(true);
                                Object v = Utils.resolveOptionals(valField.get(val));
                                if (v == null) {
                                    continue;
                                }

                                FormMetadata valMetadata = FormMetadata.parse(valField);
                                if (valMetadata == null) {
                                    continue;
                                }

                                if (metadata.explode) {
                                    params.add(new NameValue(valMetadata.name, Utils.valToString(v)));
                                } else {
                                    items.add(String.format("%s,%s", valMetadata.name, Utils.valToString(v)));
                                }
                            }

                            if (!items.isEmpty()) {
                                params.add(new NameValue(metadata.name, String.join(",", items)));
                            }
                        }
                        break;
                    }
                    case MAP: {
                        Map<?, ?> valMap = (Map<?, ?>) val;

                        List<String> items = new ArrayList<>();

                        for (Map.Entry<?, ?> entry : valMap.entrySet()) {
                            if (metadata.explode) {
                                params.add(new NameValue(Utils.valToString(entry.getKey()),
                                        Utils.valToString(entry.getValue())));
                            } else {
                                items.add(String.format("%s,%s", entry.getKey(), entry.getValue()));
                            }
                        }

                        if (!items.isEmpty()) {
                            params.add(new NameValue(metadata.name, String.join(",", items)));
                        }

                        break;
                    }
                    case ARRAY: {
                        final List<?> array = Utils.toList(val);

                        List<String> items = new ArrayList<>();

                        for (Object item : array) {
                            if (metadata.explode) {
                                params.add(new NameValue(metadata.name, Utils.valToString(item)));
                            } else {
                                items.add(Utils.valToString(item));
                            }
                        }

                        if (!items.isEmpty()) {
                            params.add(new NameValue(metadata.name, String.join(",", items)));
                        }

                        break;
                    }
                    default:
                        params.add(new NameValue(metadata.name, Utils.valToString(val)));
                        break;
                    }
                }
            }
            break;
        default:
            throw new IllegalArgumentException("Invalid type for form data");
        }

        // ensure that a fresh open input stream is provided every time
        // by the BodyPublisher
        String contentType = "application/x-www-form-urlencoded; charset=ISO-8859-1";
        return new SerializedBody(contentType, BodyPublishers.ofInputStream(() -> {
            String query = QueryEncoding.formatQuery(params, StandardCharsets.ISO_8859_1, true);
            return new ByteArrayInputStream(query.getBytes(StandardCharsets.ISO_8859_1));
        }));
    }
    
}
