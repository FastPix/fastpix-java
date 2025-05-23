/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package io.fastpix.sdk.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.fastpix.sdk.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * SimulcastUpdateResponseMetadata
 * 
 * <p>Arbitrary user-supplied metadata that will be included in the simulcast details. Can be used to store your own ID for a video along with the simulcast. Max:255 characters, Upto 10 entries are allowed.
 */
public class SimulcastUpdateResponseMetadata {

    @JsonCreator
    public SimulcastUpdateResponseMetadata() {
        
        
    }

    public final static Builder builder() {
        return new Builder();
    }    

    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            );
    }
    
    @Override
    public String toString() {
        return Utils.toString(SimulcastUpdateResponseMetadata.class);
    }
    
    public final static class Builder {
        
        private Builder() {
          // force use of static builder() method
        }
        
        public SimulcastUpdateResponseMetadata build() {
            return new SimulcastUpdateResponseMetadata(
                );
        }
    }
}
