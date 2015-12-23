package geoand.rxjavajpa.config

import geoand.rxjavajpa.mvc.handler.ObservableReturnValueHandler
import groovy.transform.CompileStatic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by gandrianakis on 23/12/2015.
 */
@Configuration
@CompileStatic
class RxJavaConfiguration {

    @Bean
    public ObservableReturnValueHandler observableReturnValueHandler() {
        return new ObservableReturnValueHandler();
    }

    @Bean
    public WebMvcConfigurerAdapter observableMVCConfiguration() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
                returnValueHandlers.add(observableReturnValueHandler());
            }
        };
    }
}
