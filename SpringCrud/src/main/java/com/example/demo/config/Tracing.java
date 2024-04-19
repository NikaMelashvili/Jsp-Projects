package com.example.demo.config;

import io.micrometer.tracing.TraceContext;
import io.micrometer.tracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Tracing {

//    @Autowired
//    private Tracer tracer;
//
//    public void someMethod() {
//        TraceContext traceContext = tracer.currentTraceContext().get();
//        System.out.println("Trace ID: " + traceContext.traceId());
//        System.out.println("Span ID: " + traceContext.spanId());
//    }

}
