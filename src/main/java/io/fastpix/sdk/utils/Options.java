package io.fastpix.sdk.utils;

import java.util.Optional;
import java.util.List;

public class Options {

    private static final String RETRY_CONFIG_FIELD = "retryConfig";

    public enum Option {
        RETRY_CONFIG;
    }

    private Optional<RetryConfig> retryConfig = Optional.empty();

    private Options(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, RETRY_CONFIG_FIELD);
        this.retryConfig = retryConfig;
    }

    public Optional<RetryConfig> retryConfig() {
        return retryConfig;
    }

    public final void validate(List<Option> supportedOptions) throws IllegalArgumentException {
        if (this.retryConfig.isPresent() && !supportedOptions.contains(Option.RETRY_CONFIG)) {
            throw new IllegalArgumentException("retryConfig is not supported for this operation.");
        }
    }

    public static final Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private Optional<RetryConfig> retryConfig = Optional.empty();

        private Builder() {}

        public Builder retryConfig(RetryConfig retryConfig) throws IllegalArgumentException {
            Utils.checkNotNull(retryConfig, RETRY_CONFIG_FIELD);
            this.retryConfig = Optional.of(retryConfig);
            return this;
        }

        public Builder retryConfig(Optional<RetryConfig> retryConfig) throws IllegalArgumentException {
            Utils.checkNotNull(retryConfig, RETRY_CONFIG_FIELD);
            this.retryConfig = retryConfig;
            return this;
        }

        public Options build() {
            return new Options(retryConfig);
        }
    }
}
