package com.example.numeros_romanos;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numerosromanos")
public class ConvertController {

    @GetMapping("/convert/{numero}")
    public String convert(@PathVariable Integer numero){
        return NumeroUtil.convertirANumerosRomanos(numero);
    }

}
