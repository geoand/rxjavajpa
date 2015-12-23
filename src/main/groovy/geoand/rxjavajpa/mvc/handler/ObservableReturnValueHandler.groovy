package geoand.rxjavajpa.mvc.handler

import geoand.rxjavajpa.util.ObservableToDeferredResult
import groovy.transform.CompileStatic
import org.springframework.core.MethodParameter
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.context.request.async.DeferredResult
import org.springframework.web.context.request.async.WebAsyncUtils
import org.springframework.web.method.support.AsyncHandlerMethodReturnValueHandler
import org.springframework.web.method.support.ModelAndViewContainer

import rx.Observable as Observable

/**
 * Created by gandrianakis on 23/12/2015.
 */
@CompileStatic
class ObservableReturnValueHandler implements AsyncHandlerMethodReturnValueHandler {

    private final ObservableToDeferredResult observableToDeferredResult = new ObservableToDeferredResult()

    @Override
    boolean isAsyncReturnValue(Object returnValue, MethodParameter returnType) {
        return returnValue != null && returnValue instanceof Observable
    }

    @Override
    boolean supportsReturnType(MethodParameter returnType) {
        return Observable.isAssignableFrom(returnType.getParameterType())
    }

    @Override
    void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        if (returnValue == null) {
            mavContainer.setRequestHandled(true)
            return
        }

        final Observable<?> observable = Observable.class.cast(returnValue)
        final DeferredResult<?> deferredResult = observableToDeferredResult.convert(observable)

        WebAsyncUtils.getAsyncManager(webRequest).startDeferredResultProcessing(deferredResult, mavContainer)
    }
}
