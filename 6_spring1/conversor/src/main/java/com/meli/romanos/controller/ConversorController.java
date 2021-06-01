package com.meli.romanos.controller;

import com.meli.romanos.services.IMorseService;
import com.meli.romanos.services.IRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("conversor")
public class ConversorController {

    @Autowired
    private IRomanosService romanosService;

    @Autowired
    private IMorseService morseService;

    @GetMapping("/ToRoman/{numero}")
    public String decimalToRoman(@PathVariable float numero){
        return romanosService.decimalToRomano(numero);
    }

    @GetMapping("/ToDecimal/{romano}")
    public float romanToDecimal(@PathVariable String romano){
        return romanosService.romanoToDecimal(romano);
    }

    //@GetMapping("/morseToText/{morseCode}")
    @PostMapping("/morseToText")
    public String morseToText(@RequestBody String morseCode){
        return morseService.morseToText(morseCode);
    }

    //@GetMapping("/textToMorse/{text}")
    @PostMapping("/textToMorse")
    public String textToMorse(@RequestBody String text){
        return morseService.textToMorse(text);
    }

}
