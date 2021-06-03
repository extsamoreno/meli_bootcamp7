package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    private static final char[] TEXT_ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0'};

    private static final String[] MORSE_ALPHABET
            = {".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--",
            "--..", "|"};

    public static String integerToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {

                roman.append(romanLiterals[i]);
                num -= values[i];
            }
        }
        return roman.toString();
    }

    public static String morseToText(String morseCode) {

        String[] array = morseCode.split(" ");

        StringBuilder result = new StringBuilder();

        for (String s : array) {
            for (int j = 0; j < MORSE_ALPHABET.length; j++) {
                if (s.compareTo(MORSE_ALPHABET[j]) == 0) {
                    result.append((char) (j + 'a')).append(" ");
                    break;
                }
            }
        }
        return "La traducción del código morse ingresado es: " + result.toString().toUpperCase();
    }

    public static String textToMorse(String text) {

        text = text.toLowerCase();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < TEXT_ALPHABET.length; j++) {
                if (text.charAt(i) == TEXT_ALPHABET[j]) {
                    result.append(MORSE_ALPHABET[j]).append(" ");
                    break;
                }
            }
        }
        return "La traducción en código morse para el texto '" + text
                + "' es: " + result;
    }
}



