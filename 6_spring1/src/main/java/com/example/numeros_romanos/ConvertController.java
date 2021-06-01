package com.example.numeros_romanos;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class ConvertController {

    @GetMapping("/numerosromanos/{numero}")
    public String convert(@PathVariable Integer numero){
        return NumeroUtil.convertirANumerosRomanos(numero);
    }

    @GetMapping("/morse/{cadena}")
    public String convert(@PathVariable String cadena){
        return MorseUtil.convertToString(cadena);
    }

}
