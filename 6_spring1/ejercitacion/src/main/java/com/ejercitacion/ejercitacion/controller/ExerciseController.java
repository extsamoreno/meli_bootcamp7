package com.ejercitacion.ejercitacion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ExerciseController {

    Map<String, Character> map;


    @GetMapping("/number/{number}")
    public String convertToRoman(@PathVariable int number) {

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

    @GetMapping("/morse/{morse}")
    public String translateMorse(@PathVariable String morse) {

        StringBuilder translated = new StringBuilder();
        String[] morseWords = morse.split("\\s{3}");
        for (String morseWord : morseWords) {
            String[] letters = morseWord.split(" ");
            for (String letter : letters) {
                translated.append(getEquivalent().get(letter));
            }
            translated.append(" ");
        }
        return translated.toString().toUpperCase();

    }

    private Map<String, Character> getEquivalent() {
        if (this.map == null) {
            Map<String, Character> map = new HashMap<>();
            map.put(".-", 'A');
            map.put("-...", 'B');
            map.put("-.-.", 'C');
            map.put("-..", 'D');
            map.put(".", 'E');
            map.put("..-.", 'F');
            map.put("--.", 'G');
            map.put("....", 'H');
            map.put("..", 'I');
            map.put(".---", 'J');
            map.put("-.-", 'K');
            map.put(".-..", 'L');
            map.put("--", 'M');
            map.put("-.", 'N');
            map.put("---", 'O');
            map.put(".--.", 'P');
            map.put("--.-", 'Q');
            map.put(".-.", 'R');
            map.put("...", 'S');
            map.put("-", 'T');
            map.put("..-", 'U');
            map.put("...-", 'V');

            map.put(".--", 'W');
            map.put("-..-", 'X');
            map.put("-.--", 'Y');
            map.put("--..", 'Z');
            return map;
        } else {
            return this.map;
        }
    }


}