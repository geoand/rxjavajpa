package geoand.rxjavajpa.util;

import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by gandrianakis on 22/12/2015.
 */
public class ObservableToDeferredResult {

    private final long timeoutMillis;

    public ObservableToDeferredResult(long timeoutMillis) {
        this.timeoutMillis = timeoutMillis;
    }

    public ObservableToDeferredResult() {
        this(20000);
    }

    public <T> DeferredResult<T> convert(rx.Observable<T> observable) {
        final DeferredResult<T> deferred = new DeferredResult<>(timeoutMillis);
        observable.subscribe(deferred::setResult, deferred::setErrorResult);
        return deferred;
    }
}
