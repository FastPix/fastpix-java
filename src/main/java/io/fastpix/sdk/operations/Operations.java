package io.fastpix.sdk.operations;

import io.fastpix.sdk.utils.Blob;

import java.io.InputStream;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

// Internal API only

// The descriptive type-parameter names (ReqT/ResT) are an intentional convention that conveys the
// request and response roles across these operation interfaces; the naming-convention finding is
// suppressed rather than renaming them to single letters.
@SuppressWarnings("java:S119")
public class Operations {
    /**
    * Base interface for all operations
    */
    public interface Operation<ResT> {
        ResT handleResponse(HttpResponse<InputStream> response);
    }

    /**
    * Interface for operations that require a request parameter
    */
    public interface RequestOperation<ReqT, ResT> extends Operation<ResT> {
        HttpResponse<InputStream> doRequest(ReqT request);
    }

    /**
    * Interface for operations that don't require a request parameter
    */
    public interface RequestlessOperation<ResT> extends Operation<ResT> {
        HttpResponse<InputStream> doRequest();
    }

    /**
    * Base interface for all async operations
    */
    public interface AsyncOperation<ResT> {
        CompletableFuture<ResT> handleResponse(HttpResponse<Blob> response);
    }

    /**
    * Interface for async operations that require a request parameter
    */
    public interface AsyncRequestOperation<ReqT, ResT> extends AsyncOperation<ResT> {
        CompletableFuture<HttpResponse<Blob>> doRequest(ReqT request);
    }

    /**
    * Interface for async operations that don't require a request parameter
    */
    public interface AsyncRequestlessOperation<ResT> extends AsyncOperation<ResT> {
        CompletableFuture<HttpResponse<Blob>> doRequest();
    }
}