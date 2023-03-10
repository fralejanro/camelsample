package com.demo.camellib.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:MyRoute")
                .marshal().json(JsonLibrary.Jackson)
                .to("http:localhost:9090/testService")
                .unmarshal().json(JsonLibrary.Jackson,Class.forName("com.demo.apirest.model.Person"));
    }
}
