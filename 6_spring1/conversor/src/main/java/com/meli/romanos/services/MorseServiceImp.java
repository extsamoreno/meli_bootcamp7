package com.meli.romanos.services;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MorseServiceImp implements IMorseService {

    // store the all the alphabet in an array
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

    @Override
    public String morseToText(String morseCode) {
        String[] array = morseCode.split(" ");
        StringBuilder text = new StringBuilder();
        // Morse code to English
        for (String s : array) {
            if (s.compareTo("") == 0) text.append(" ");
            for (int j = 0; j < code.length; j++) {
                if (s.compareTo(code[j]) == 0) {
                    text.append((char) (j + 'a'));
                    System.out.print((char) (j + 'a'));
                    break;
                }
            }
        }
        return text.toString().toUpperCase();
    }

    @Override
    public String textToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        String entrada = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            if (entrada.charAt(i) == ' ') {
                morseCode.append(" ");
            }
            for (int j = 0; j < letter.length; j++) {
                if (entrada.charAt(i) == letter[j]) {
                    morseCode.append(code[j] + " ");
                    break;
                }
            }
        }
        return morseCode.toString();
    }
}
