package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

@JsonTypeInfo(
        use = Id.CUSTOM,
        property = "type",
        include = As.EXISTING_PROPERTY,
        visible = true,
        defaultImpl = UnknownPlaylistByIdResponseData.class
)
@JsonTypeIdResolver(PlaylistByIdResponseDataTypeIdResolver.class)
public interface PlaylistByIdResponseData {

    String type();

}

