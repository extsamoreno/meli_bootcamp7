package com.example.demo.Controllers;

import com.example.demo.Services.DTO.TranslationDTO;
import com.example.demo.Services.MorseUtil;
import com.example.demo.Services.RomanUtil;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translations")
public class TranslationsController {


    @GetMapping("/roman/{number}")
    public TranslationDTO getRomanNumber(@PathVariable Integer number ){
        String output = RomanUtil.getRomanNumber(number);
        TranslationDTO result = new TranslationDTO();
        result.setInput(number.toString());
        result.setOutput(output);
        return result;
    }

    @PostMapping("/morse")
    public TranslationDTO getMorseText(@RequestBody String text){
        String output = MorseUtil.textToMorse(text);
        TranslationDTO result = new TranslationDTO();
        result.setInput(text);
        result.setOutput(output);
        return result;
    }

}
