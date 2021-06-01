package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/num")
public class NumberController {

    @GetMapping("/numeroARomano/{number}")
    public String getNum(@PathVariable Integer number ) {
        return NumerosRomanos.convertirANumerosRomanos(number);
    }
}
