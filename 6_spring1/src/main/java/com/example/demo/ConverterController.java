package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConverterController {

    @GetMapping("/conversorRomano/{num}")
    public String convertToRomanNumber(@PathVariable int num) {
        return ConverterService.integerToRoman(num);
    }

    @GetMapping("conversorMorseTexto/{morse}")
    public String convertMorseToString(@PathVariable String morse) {
        return ConverterService.morseToText(morse);
    }

    @GetMapping("conversorTextoMorse/{text}")
    public String convertTextToMorse(@PathVariable String text) {
        return ConverterService.textToMorse(text);
    }
}
