package com.ensta.asi34;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Asi34Application {


    public static void main(String[] args) {
        SpringApplication.run(Asi34Application.class, args);
    }
}
