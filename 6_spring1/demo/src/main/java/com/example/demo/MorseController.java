package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;

@RestController
public class MorseController {
    private final Hashtable<String, String> morse = createMorseTable();

    @GetMapping("/morse/{morse}")
    public String convertMorse(@PathVariable String morse) {
        return getPlainText(morse);
    }

    private String getPlainText(String morse) {
        StringBuilder sb = new StringBuilder();
        String[] arrayWords = morse.split("   ");
        for (String s : arrayWords) {
            sb.append(convertWord(s));
            sb.append(" ");
        }
        return sb.toString();
    }

    private String convertWord(String word) {
        StringBuilder sb = new StringBuilder();
        String[] arrayChar = word.split(" ");
        for (String s : arrayChar) {
            sb.append(morse.get(s));
        }
        return sb.toString();
    }

    private Hashtable<String, String> createMorseTable() {
        Hashtable<String, String> mapMorse = new Hashtable<>();

        final String MORSEA= ".-";
        final String MORSEB = "-...";
        final String MORSEC = "-.-.";
        final String MORSE_CH = "----";
        final String MORSED = "-..";
        final String MORSEE = ".";
        final String MORSEF = "..-.";
        final String MORSEG = "--.";
        final String MORSEH = "....";
        final String MORSEI = "..";
        final String MORSEJ = ".___";
        final String MORSEK = "-.-";
        final String MORSEL = ".-..";
        final String MORSEM = "--";
        final String MORSEN = "-.";
        final String MORSE_ENIE = "--.--";
        final String MORSEO = "---";
        final String MORSEP = ".--.";
        final String MORSEQ = "--.-";
        final String MORSER = ".-.";
        final String MORSES = "...";
        final String MORSET = "-";
        final String MORSEU = "..-";
        final String MORSEV = "...-";
        final String MORSEW = ".--";
        final String MORSEX = "-..-";
        final String MORSEY = "-.--";
        final String MORSEZ = "--..";
        final String MORSE0 = "-----";
        final String MORSE1 = ".----";
        final String MORSE2 = "..---";
        final String MORSE3 = "...--";
        final String MORSE4 = "....-";
        final String MORSE5 = ".....";
        final String MORSE6 = "-....";
        final String MORSE7 = "--...";
        final String MORSE8 = "---..";
        final String MORSE9 = "----.";
        final String MORSE_DOT = ".-.-.-";
        final String MORSE_COMMA = "--..--";
        final String MORSE_QUESTION = "..--..";
        final String MORSE_DOUBLE= ".-..-.";
        final String MORSE_SLASH = "-..-.";

        mapMorse.put(MORSEA, "A");
        mapMorse.put(MORSEB, "B");
        mapMorse.put(MORSEC, "C");
        mapMorse.put(MORSE_CH, "CH");
        mapMorse.put(MORSED, "D");
        mapMorse.put(MORSEE, "E");
        mapMorse.put(MORSEF, "F");
        mapMorse.put(MORSEG, "G");
        mapMorse.put(MORSEH, "H");
        mapMorse.put(MORSEI, "I");
        mapMorse.put(MORSEJ, "J");
        mapMorse.put(MORSEK, "K");
        mapMorse.put(MORSEL, "L");
        mapMorse.put(MORSEM, "M");
        mapMorse.put(MORSEN, "N");
        mapMorse.put(MORSE_ENIE, "Ñ");
        mapMorse.put(MORSEO, "O");
        mapMorse.put(MORSEP, "P");
        mapMorse.put(MORSEQ, "Q");
        mapMorse.put(MORSER, "R");
        mapMorse.put(MORSES, "S");
        mapMorse.put(MORSET, "T");
        mapMorse.put(MORSEU, "U");
        mapMorse.put(MORSEV, "V");
        mapMorse.put(MORSEW, "W");
        mapMorse.put(MORSEX, "X");
        mapMorse.put(MORSEY, "Y");
        mapMorse.put(MORSEZ, "Z");
        mapMorse.put(MORSE0, "0");
        mapMorse.put(MORSE1, "1");
        mapMorse.put(MORSE2, "2");
        mapMorse.put(MORSE3, "3");
        mapMorse.put(MORSE4, "4");
        mapMorse.put(MORSE5, "5");
        mapMorse.put(MORSE6, "6");
        mapMorse.put(MORSE7, "7");
        mapMorse.put(MORSE8, "8");
        mapMorse.put(MORSE9, "9");
        mapMorse.put(MORSE_DOT, ".");
        mapMorse.put(MORSE_COMMA, ",");
        mapMorse.put(MORSE_QUESTION, "?");
        mapMorse.put(MORSE_DOUBLE, "\"");
        mapMorse.put(MORSE_SLASH, "/");

        return mapMorse;
    }

}
