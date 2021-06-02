package com.example.demo.services;

import org.springframework.web.bind.annotation.*;


@RestController
public class Morse {
    @PostMapping(path = "/convertir/atexto/")
    public String aEnteros(@RequestBody String pcadena){

        return Conversor.morseATexto(pcadena);
    }
    @PostMapping(path = "/convertir/amorse/")
    public String aMorse(@RequestBody String pcadena){

        return Conversor.textoAMorse(pcadena);
    }
}
