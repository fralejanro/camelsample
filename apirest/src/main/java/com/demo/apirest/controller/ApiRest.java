package com.demo.apirest.controller;

import com.demo.apirest.model.Person;
import com.demo.apirest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiRest {
    @Autowired
    private PersonService personService;
    @PostMapping("testService")
    public Person callRoute(@RequestHeader Map<String ,Object> headers, @RequestBody Map<String ,Object> body){
        return personService.getPerson(headers,body);
    }
}
