/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * CreateMediaRequestMp4Support
 * 
 * <p>“capped_4k": Generates an mp4 video file up to 4k resolution "audioOnly": Generates an m4a audio file of the media file "audioOnly,capped_4k": Generates both video and audio media files for offline viewing
 */
public enum CreateMediaRequestMp4Support {
    CAPPED4K("capped_4k"),
    AUDIO_ONLY("audioOnly"),
    AUDIO_ONLY_CAPPED4K("audioOnly,capped_4k");

    @JsonValue
    private final String value;

    private CreateMediaRequestMp4Support(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<CreateMediaRequestMp4Support> fromValue(String value) {
        for (CreateMediaRequestMp4Support o: CreateMediaRequestMp4Support.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

