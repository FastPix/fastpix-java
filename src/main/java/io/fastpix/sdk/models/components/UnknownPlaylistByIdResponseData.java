package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import io.fastpix.sdk.utils.UnknownType;


public class UnknownPlaylistByIdResponseData extends UnknownType implements PlaylistByIdResponseData {

    @JsonCreator
    public UnknownPlaylistByIdResponseData(JsonNode rawNode) {
        super(rawNode);
    }

    @Override
    public String type() {
        return extractDiscriminator("type").orElse("UNKNOWN");
    }

}