package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hola Mundo";
    }


    @GetMapping("/hello/{name}")
    public String helloWorld(@PathVariable String name){
        return "Hola "+name;
    }
}
