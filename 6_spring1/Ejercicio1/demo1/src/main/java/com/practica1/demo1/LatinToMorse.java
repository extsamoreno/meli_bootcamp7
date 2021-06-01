package com.practica1.demo1;

import java.util.Hashtable;

public class LatinToMorse implements ITranslate {

    public LatinToMorse() {
    }

    @Override
    public String translateCharacter(String character) {
        Hashtable<String, String> translation  = MorseAlphabet.morseAlphabet();
        return translation.getOrDefault(character,"");
    }

    @Override
    public String translateMessage(String message) {
        StringBuilder coded = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            String cleaned = String.valueOf(message.charAt(i)).toUpperCase();
            String translation = translateCharacter(cleaned);
            coded.append(translation).append(" ");
        }
        return coded.toString();
    }
}
