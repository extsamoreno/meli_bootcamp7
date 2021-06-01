package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class Codificacion {

    private static final char[] LETTER = { 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0' };

    private static final String[] CODE
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "|" };

    public static String morseToEnglish(String morseCode)
    {
        String[] array = morseCode.split(" ");
        String resultado = "";

        // Morse code to English
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < CODE.length; j++) {
                if (array[i].compareTo(CODE[j]) == 0) {
                    resultado +=(char)(j + 'a') + " ";
                    break;
                }
            }
        }
        return resultado;
    }

    /*public static void main(String[] args)
    {


        String morseCode = "... -.-. .... --- --- .-..";
        String englishLang = "alice";
        // morse to English
        morseToEnglish(code, morseCode);
        System.out.println();
        // English to morse code
        englishToMorse(code, englishLang, letter);
    }*/
}
