package com.aorez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${country}")
    private String country;

    @Autowired
    private Environment environment;

    @GetMapping
    public String getById() {
        System.out.println("BookController getById");

        System.out.println(country);

        System.out.println(environment.getProperty("country"));

        return "BookController getById";
    }
}
