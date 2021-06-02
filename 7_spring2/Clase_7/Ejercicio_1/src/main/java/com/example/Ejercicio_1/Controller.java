package com.example.Ejercicio_1;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class Controller {

    @GetMapping("/hello/{name}")
    public String getHello(@PathVariable String name , @RequestParam(required = false,defaultValue = "") String color,
                           @RequestParam(required = false,defaultValue = "") String tamaño){
        return "hello" + color.equals("hola");
    }



  //  /auto/fiat?color=rojo

}
