package com.example.API_Spring1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.serial.SerialStruct;

@RestController
@RequestMapping("/morseLatinDecoder")
public class MorseLatinController {
    private static final MorseLatinEqTable decoder = new MorseLatinEqTable();

    @GetMapping("/toLatin/{morse}")
    public static String convertMorseToLatin(@PathVariable String morse)
    {
        return decoder.toExpression(morse);
    }

    @GetMapping("/toMorse/{expression}")
    public static String convertLatinToMorse(@PathVariable String expression)
    {
        return decoder.toMorse(expression);
    }
}
