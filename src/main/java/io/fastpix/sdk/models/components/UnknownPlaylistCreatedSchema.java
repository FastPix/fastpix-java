package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import io.fastpix.sdk.utils.UnknownType;


public class UnknownPlaylistCreatedSchema extends UnknownType implements PlaylistCreatedSchema {

    @JsonCreator
    public UnknownPlaylistCreatedSchema(JsonNode rawNode) {
        super(rawNode);
    }

    @Override
    public String type() {
        return extractDiscriminator("type").orElse("UNKNOWN");
    }

}