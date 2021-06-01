package com.example.numeros_romanos;

import java.util.Locale;

public class MorseUtil {

    private static String[] code
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "|","—.—"};

    public static String convertToString(String morseCode){

        String resultado="";

        for (String s : morseCode.split("   ")) {
            String[] array = s.split(" ");
            for (int k = 0; k < array.length; k++) {
                for (int j = 0; j < code.length; j++) {
                    if (array[k].compareTo(code[j]) == 0) {
                        resultado += (char)(j + 'a');
                        break;
                    }
                }
            }
            resultado+=" ";
        }

        return resultado.toUpperCase(Locale.ROOT);
    }

}
