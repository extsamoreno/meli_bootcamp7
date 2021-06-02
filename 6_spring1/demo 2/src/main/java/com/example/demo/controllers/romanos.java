package com.example.demo.controllers;

import com.example.demo.services.Conversor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class romanos {
    @GetMapping(path = "/convertir/aromanos/{numero}")
    public String aRomanos(@PathVariable("numero") int pnumero){
        Conversor conversor = new Conversor() ;
        return conversor.intToRomano(pnumero);
    }

    @GetMapping(path = "/convertir/aenteros/{cadena}")
    public int aEnteros(@PathVariable("cadena") String pcadena){

        return Conversor.romanoToInt(pcadena);
    }

}
