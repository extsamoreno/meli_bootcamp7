package com.nicoll.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/romanos")
public class GreatingControler {

    @GetMapping("/{num}")
    public String romanos(@PathVariable int num){
        return NumerosRomanos.convertirANumerosRomanos(num);
    }
}
