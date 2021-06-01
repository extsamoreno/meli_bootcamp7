package com.example.demo;

import java.util.Hashtable;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

public class Morse {

    public static String morseCode(String code) {

        String result = "";
        String[] diccionario = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "......."};

        BidiMap<String, String> equivalencias = new TreeBidiMap<>();
        String[] words = code.split("   ");

        for (int i = 0; i<diccionario.length; i++)
            equivalencias.put(String.valueOf((char)(i+65)), diccionario[i]);

        for (String word: words) {
            String[] letters = word.split(" ");
            for (String value: letters) {
                result += equivalencias.getKey(value);
            }
            result+= " ";
        }

        return result;
    }
}
