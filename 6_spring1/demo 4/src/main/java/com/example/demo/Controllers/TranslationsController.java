package com.example.demo.Controllers;

import com.example.demo.Services.DTO.TranslationDTO;
import com.example.demo.Services.RomanUtil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
