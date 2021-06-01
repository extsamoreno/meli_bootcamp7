package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/Words/Convert")
public class WordsController {
    private final char[] letter = {'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0'};
    // Morse code by indexing
    private final String[] code
            = {".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--",
            "--..", "|"};

    @GetMapping("/MorseCode/{words}")
    public String getMorseCode(@PathVariable String words) {
            return englishToMorse(words.toLowerCase());
    }

    public String englishToMorse(String englishLang) {
        String result = "";
        for (int i = 0; i < englishLang.length(); i++) {
            for (int j = 0; j < letter.length; j++) {
                if (englishLang.charAt(i) == letter[j]) {
                    result += code[j] + " ";
                    break;
                }
            }
        }

        return result;
    }

    @GetMapping("/String/{morse}")
    public String getString(@PathVariable String morse){
        return morseToEnglish(morse);
    }

    public String morseToEnglish(String morseCode)
    {
        String result = "";
        for (String s : morseCode.split("   ")) {
            String[] array = s.split(" ");
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < code.length; j++) {
                    if (array[i].compareTo(code[j]) == 0) {
                        result += ((char)(j + 'a'));
                        break;
                    }
                }
            }
            result += " ";
        }

        return result.toUpperCase().trim();
    }
}
