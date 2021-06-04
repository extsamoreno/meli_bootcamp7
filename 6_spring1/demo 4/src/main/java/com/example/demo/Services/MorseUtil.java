package com.example.demo.Services;

public class MorseUtil {

    private static char[] letter = {'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0'};

    private static String[] code
            = {".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--",
            "--..", "|"};

    public static String textToMorse(String text) {

        String result = "";
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < letter.length; j++) {
                if (text.charAt(i) == letter[j]) {
                    result += code[j] + " ";
                    break;
                }
            }
        }

        return result;
    }

}
