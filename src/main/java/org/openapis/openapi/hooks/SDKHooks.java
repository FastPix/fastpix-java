package org.openapis.openapi.hooks;

//
// This file is written once by fastpix code generation and
// thereafter will not be overwritten by fastpix updates. As a
// consequence any customization of this class will be preserved.
//

public final class SDKHooks {

    private SDKHooks() {
        // prevent instantiation
    }

    public static void initialize(org.openapis.openapi.utils.Hooks hooks) {
        // register synchronous hooks here
        // hooks.registerBeforeRequest(...);
        // hooks.registerAfterSuccess(...);
        // hooks.registerAfterError(...);

        // for more information see
        // https://www.fastpix.io/docs/additional-features/sdk-hooks
    }

    public static void initialize(org.openapis.openapi.utils.AsyncHooks asyncHooks) {
        // register async hooks here
        // asyncHooks.registerBeforeRequest(...);
        // asyncHooks.registerAfterSuccess(...);
        // asyncHooks.registerAfterError(...);
        
        // NOTE: If you have existing synchronous hooks, you can adapt them using HookAdapters:
        // asyncHooks.registerAfterError(org.openapis.openapi.utils.HookAdapters.adapt(mySyncHook));
        
        // PERFORMANCE TIP: For better performance, implement async hooks directly using
        // non-blocking I/O (NIO) APIs instead of adapting synchronous hooks, as adapters
        // offload execution to the ForkJoinPool which can introduce overhead.

        // for more information see
        // https://www.fastpix.io/docs/additional-features/sdk-hooks
    }

}
