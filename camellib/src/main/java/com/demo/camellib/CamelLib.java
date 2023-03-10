package com.demo.camellib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelLib {
    public static void main(String[] args) {
        new SpringApplication(CamelLib.class).run(args);
    }
}