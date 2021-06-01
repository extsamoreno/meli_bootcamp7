package com.nicoll.demo;

import java.util.Locale;

public class MorseUtil {

    public static String[] letter = {"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "0"};

    public static String[] code
            = {".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--",
            "--..", "|"};

    public static String morseString(String string) {
        return replace(string, code);
    }


    public static String replace(String morseCode, String[] code) {

        String result = " ";
        String[] arraySplit = morseCode.split("   ");
        for (String s:
             arraySplit) {
            System.out.println(s);
        }

        for (String s: arraySplit) {
            String[] array = s.split(" ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (array[i].compareTo(code[j]) == 0) {
                    result += (char) (j + 'a');
                    break;
                }
            }
        }
            result += " ";

        }
        return result.toUpperCase(Locale.ROOT);
    }
}