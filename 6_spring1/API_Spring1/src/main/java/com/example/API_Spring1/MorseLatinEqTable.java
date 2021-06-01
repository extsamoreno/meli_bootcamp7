package com.example.API_Spring1;

import java.util.ArrayList;

public class MorseLatinEqTable {

    private final ArrayList<String> latinChars;
    private final ArrayList<String> morseChars;

    public MorseLatinEqTable()
    {
        latinChars = new ArrayList<String>();
        morseChars = new ArrayList<String>();
        this.buildTable();
    }

    private void addChars (String character, String morse)
    {
        latinChars.add(character);
        morseChars.add(morse);
    }

    private String latinToMorse (String character)
    {
        int index = latinChars.indexOf(character);
        return (String) morseChars.get(index);
    }

    private String morseToLatin (String morse)
    {
        int index = morseChars.indexOf(morse);
        return (String) latinChars.get(index);
    }

    private void buildTable()
    {
        addChars("A", ".-");
        addChars("B", "-...");
        addChars("C", "-.-.");
        addChars("CH", "----");
        addChars("D", "-..");
        addChars("E", ".");
        addChars("F", "..-.");
        addChars("G", "--.");
        addChars("H", "....");
        addChars("I", "..");
        addChars("J", ".---");
        addChars("K", "-.-");
        addChars("L", ".-..");
        addChars("M", "--");
        addChars("N", "-.");
        addChars("Ñ", "--.--");
        addChars("O", "---");
        addChars("P", ".--.");
        addChars("Q", "--.-");
        addChars("R", ".-.");
        addChars("S", "...");
        addChars("T", "-");
        addChars("U", "..-");
        addChars("V", "...-");
        addChars("W", ".--");
        addChars("X", "-..-");
        addChars("Y", "-.--");
        addChars("Z", "--..");
        addChars("0", "-----");
        addChars("1", ".----");
        addChars("2", "..---");
        addChars("3", "...--");
        addChars("4", "....-");
        addChars("5", ".....");
        addChars("6", "-....");
        addChars("7", "--...");
        addChars("8", "---..");
        addChars("9", "----.");
        addChars(".", ".-.-.-");
        addChars(",", "--..--");
        addChars(":", "---...");
        addChars("?", "..--..");
        addChars("'", ".----.");
        addChars("-", "-....-");
        addChars("/", "-..-.");
        addChars("\"", ".-..-.");
        addChars("@", ".--.-.");
        addChars("=", "-...-");
        addChars("!", "−.−.−−");
    }

    public String toMorse(String phrase)
    {
        String finalExpression = "";
        String[] phraseWords = phrase.split(" ");
        for (int i = 0; i < phraseWords.length; i++) {
            String[] wordChars = phraseWords[i].split("");
            for (int j = 0; j < wordChars.length; j++) {
                finalExpression += latinToMorse(wordChars[j]);
            }
            if (i != phraseWords.length - 1) {
                finalExpression += " ";
            }
        }
        return finalExpression;
    }

    public String toExpression(String morseExpression)
    {
        String finalExpression = "";
        String[] phraseWords = morseExpression.split("   ");
        for (int i = 0; i < phraseWords.length; i++) {
            String[] wordChars = phraseWords[i].split(" ");
            for (int j = 0; j < wordChars.length; j++) {
                finalExpression += morseToLatin(wordChars[j]);
            }
            if (i != phraseWords.length - 1) {
                finalExpression += " ";
            }
        }
        return finalExpression;
    }

}

