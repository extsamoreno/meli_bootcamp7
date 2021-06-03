package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.Set;

@RestController
@RequestMapping("api/v1")
public class GreetingController {

    @GetMapping("/romano/{number}")
    public  String convertRoman(@PathVariable int number){
        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roms = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder romanNumber = new StringBuilder();
        for (int i = 0; number > 0; i++)
            while (number >= val[i]) {
                romanNumber.append(roms[i]);
                number -= val[i];
            }
        return romanNumber.toString();
    }
    @GetMapping("/morse/{frase}")
    public  String converMorsetoString(@PathVariable String frase){
        Morse morseFrase = new Morse(frase);
        return morseFrase.decodificacion();
    }
    @GetMapping("/abecedario/{frase}")
    public  String converAbecedariotoString(@PathVariable String frase){
        Abecedario abecedario = new Abecedario(frase);
        return abecedario.decodificacion();
    }
    /*
    @GetMapping("/abecedario/{frase}")
    public  String converAbecedariotoString(@PathVariable String frase, @RequestParam(required = false, defaultValue = "") String color){
        Abecedario abecedario = new Abecedario(frase);
        return abecedario.decodificacion();
    }
     */

}
