package com.demo.apirest.service;

import com.demo.apirest.model.Person;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PersonService {
    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private CamelContext camelContext;

    public Person getPerson(Map<String, Object> headers, Map<String, Object> body) {
        Exchange requestExchange = ExchangeBuilder.anExchange(camelContext).build();
        requestExchange.getIn().setHeaders(headers);
        requestExchange.getIn().setBody(body);
        Exchange outExchange = producerTemplate.send("direct:MyRoute", requestExchange);
        // generate casting error
        Person person = (Person) outExchange.getMessage().getBody();
        // retun null
        Person person2 = outExchange.getMessage().getBody(Person.class);
        return person;
    }
}
