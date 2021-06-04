package com.example.demo;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @GetMapping("/hello")
    public String getHello1(@PathVariable String name  ){
        return "Hello with name:" + name;
    }

   /* @GetMapping("/hello/{name}")
    public String getHello(@PathVariable String name, @RequestParam(required = false, defaultValue = "") String color,
                           @RequestParam(required = false, defaultValue = "") String tamanio
    ){
        return "Hello " + color.equals("hola");
    }

    @GetMapping("/hello/{name}/surname")
    public String getHello2(@PathVariable String name  ){
        return "Hello";
    }

    */


}
