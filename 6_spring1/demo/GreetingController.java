package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @GetMapping("/getroman/{num}")//rutaaa
    public String getRomanNumber(@PathVariable() Integer num){
        String roman = Functions.converterToRoma(num);
        return "Numero entero ingresado  "+ num+ "    Correspondente romano :  "+roman;
    }

    @GetMapping("/gettext/{morse}")//rutaaa
    public String getText(@PathVariable() String morse){
        String text = Functions.toText(morse);
        return "La traduccion de  "+ morse+ "    Correspondente a :  "+text;
    }

}
