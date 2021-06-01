package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {


    @GetMapping("/hello/{name}")
    public String getHello(@PathVariable String name){
        return "Hello "+name;
    }
}

/*
@RestController
@RequestMapping("/greetings")
public class GreetingController {


    @GetMapping("/hello")
    public String getHello(){
        return "Hello World";
    }
}

 */