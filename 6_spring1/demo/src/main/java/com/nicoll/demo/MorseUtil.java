package com.nicoll.demo;

import java.util.HashMap;
import java.util.Locale;

public class MorseUtil {

    public static String[] letter = {
            "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "0"};

    public static String[] code = {
            ".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--",
            "--..", "|"};


    public static String morseString(String string) {
        return replace(string);
    }

    public static String StringMorse(String string) {
        return replaceString(string.toLowerCase(Locale.ROOT));
    }

    static String replaceString(String text){

        String result = " ";
        String[] arraySplit = text.split(" ");

        for (String s: arraySplit) {
            char[] ch = s.toCharArray();

            for (int i = 0; i < ch.length; i++) {  // Letra

                for (int j = 0; j < letter.length; j++) {
                    if (String.valueOf(ch[i]).compareTo(letter[j]) == 0) {
                        result += code[j] + " ";
                        break;
                    }
                }
            }

            result  += "    ";
        }
        System.out.println(result);
        return result;
    }

    static String replace(String morseCode) {

        String result = " ";
        String[] arraySplit = morseCode.split("   ");

        for (String s: arraySplit) {
            String[] array = s.split(" ");


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (array[i].compareTo(code[j]) == 0) {
                    result += letter[j];
                    break;
                }
            }
        }
            result += " ";

        }
        return result.toUpperCase(Locale.ROOT);
    }

}