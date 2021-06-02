package com.example.demo;

import java.sql.Struct;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")

public class GreetingController {
    @GetMapping("/hello/{name}") // hello es la ruta
    public String getHello(@PathVariable String name ){ //Se usa cuando queremos especificar algo
        return "Hello"+name;
    }
    /*@GetMapping("/hello/{name}") // hello es la ruta
    public String getHello(@PathVariable String name, @RequestParam (required = false,defaultValue = "") String color){
        return "Hello"+name;
    }*/
}

//Request param se usa en su mayoría para filtrar algo en especifico de la búsqueda
// Para usarlo es: /hello/fname?color=rojo
//Clase opcional como soluciones