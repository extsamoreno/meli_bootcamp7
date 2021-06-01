package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertidor")
public class GreetingController {

    @GetMapping("/convertirADecimal/{numero}")
    public String getHello(@PathVariable Integer numero){
        return Convertidor.convertirANumerosRomanos(numero);
    }
}
