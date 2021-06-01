package com.practica1.demo1;

import java.util.Hashtable;
import java.util.Set;

public class MorseToLatin implements ITranslate {

    public MorseToLatin() {
    }

    @Override
    public String translateCharacter(String character) {
        Hashtable<String, String> translation  = MorseAlphabet.morseAlphabet();
        Set<String> latinLetters = translation.keySet();
        for (String letter : latinLetters) {
            String morseSymbol = translation.get(letter);
            if (morseSymbol.equals(character)) {
                return letter;
            }
        }
        return "";
    }

    @Override
    public String translateMessage(String message) {
        StringBuilder decoded = new StringBuilder();

        String[] morse = message.split(" ");
        for (String current : morse) {
            String translation = translateCharacter(current);
            decoded.append(translation);
        }
        return decoded.toString();
    }
}
