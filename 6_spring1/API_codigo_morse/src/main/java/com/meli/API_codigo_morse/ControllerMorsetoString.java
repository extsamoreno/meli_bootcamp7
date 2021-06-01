package com.meli.API_codigo_morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert_from_morse_to_string")
public class ControllerMorsetoString {
    @GetMapping("/")
    public String getMain() {
        return "Bienvenido a la API  de código morse a string, en la ruta " +
                "`localhost:8080/meli/api/convert_from_morse_to_string/{morseCode}`" +
                " podrás recibir el respectivo string lo que coloques en ´{morseCode}´";
    }

    @GetMapping("/{morseCode}")
    public String convertToString(@PathVariable String morseCode) {
        return MorseConverter.decodificarMorse(morseCode);
    }


}
