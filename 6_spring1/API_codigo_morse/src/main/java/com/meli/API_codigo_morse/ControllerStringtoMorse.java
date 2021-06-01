package com.meli.API_codigo_morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert_from_string_to_morse")
public class ControllerStringtoMorse {
    @GetMapping("/")
    public String getMain() {
        return "Bienvenido a la API  de código string a morse, en la ruta " +
                "`localhost:8080/meli/api/convert_from_strin_to_morse/{string}`" +
                " podrás recibir el respectivo còdigo morse lo que coloques en ´{string}´";
    }

    @GetMapping("/{string}")
    public String convertToMorse(@PathVariable String string) {
        return MorseConverter.codificarMorse(string);
    }
}
