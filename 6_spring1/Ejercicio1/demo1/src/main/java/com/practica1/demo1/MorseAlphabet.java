package com.practica1.demo1;

import java.util.Hashtable;

public final class MorseAlphabet {

    public static Hashtable<String, String> morseAlphabet() {
        Hashtable<String, String> alphabet = new Hashtable<>();
        alphabet.put("A", ".-");
        alphabet.put("B", "-...");
        alphabet.put("C", "-.-.");
        alphabet.put("CH", "----");
        alphabet.put("D", "-..");
        alphabet.put("E", ".");
        alphabet.put("F", "..-.");
        alphabet.put("G", "--.");
        alphabet.put("H", "....");
        alphabet.put("I", "..");
        alphabet.put("J", ".---");
        alphabet.put("K", "-.-");
        alphabet.put("L", ".-..");
        alphabet.put("M", "--");
        alphabet.put("N", "-.");
        alphabet.put("Ñ", "--.--");
        alphabet.put("O", "---");
        alphabet.put("P", ".--.");
        alphabet.put("Q", "--.-");
        alphabet.put("R", ".-.");
        alphabet.put("S", "...");
        alphabet.put("T", "-");
        alphabet.put("U", "..-");
        alphabet.put("V", "...-");
        alphabet.put("W", ".--");
        alphabet.put("X", "-..-");
        alphabet.put("Y", "-.--");
        alphabet.put("Z", "--..");
        alphabet.put("0", "-----");
        alphabet.put("1", ".----");
        alphabet.put("2", "..---");
        alphabet.put("3", "...--");
        alphabet.put("4", "....-");
        alphabet.put("5", ".....");
        alphabet.put("6", "-....");
        alphabet.put("7", "--...");
        alphabet.put("8", "---..");
        alphabet.put("9", "----.");
        alphabet.put(".", ".-.-.-");
        alphabet.put(",", "--..--");
        alphabet.put(":", "---...");
        alphabet.put("?", "..--..");
        alphabet.put("'", ".----.");
        alphabet.put("-", "-....-");
        alphabet.put("/", "-..-.");
        alphabet.put("@", ".--.-.");
        alphabet.put("=", "-...-");
        alphabet.put("!", "−.−.−−");
        return alphabet;
    }
}
