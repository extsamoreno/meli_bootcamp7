package com.example.demo;

import com.google.common.collect.HashBiMap;

import java.util.*;

public abstract class Converter<T> {
    private HashBiMap<T, String> dictionary;

    public Converter(HashBiMap<T, String> dictionary) {
        this.dictionary = dictionary;
    }

    public abstract String convertTo(String decrypt);
    public abstract  String convertOf(String encrypt);

    public static String convert(int number){

        int miles = number / 1000;
        int centenas = (number -miles *1000)/ 100;
        int decenas= (number -miles *1000 - centenas *100)/ 10;
        int unidades = number - decenas *10 - centenas * 100 - miles *1000;

        String roman = "";

        if(number >= 4000){
            roman = "Hasta aca llego nuestro conocimiento";
        }

        if( miles < 4){
            for(int i= 0; i< miles; i++ ){
                roman = roman + "M";
            }
        }
        roman += subRoman(centenas, "M", "D", "C");
        roman += subRoman(decenas, "C", "L", "X");
        roman += subRoman(unidades, "X", "V", "I");

        return roman;
    }

    public static String  subRoman(int number, String big, String medium, String small){

        String roman = "";
        if(number < 4){

            for(int i= 0; i < number; i++ ){
                roman = roman + small;
            }
        }

        if(number == 4){
            roman = roman + small + medium;
        }

        if(number >= 5 && number < 9){
            roman = roman + medium;
            for(int i= 0; i < number-5; i++ ){
                roman = roman + small;
            }
        }

        if(number == 9){
            roman = roman + small+ big;
        }

        return roman;
    }

    public static String convertToMorse(String morse) {
        HashBiMap<String, String> equivalencias = HashBiMap.create();
        equivalencias.put("A", ".-");
        equivalencias.put("B", "-...");
        equivalencias.put("C", "-.-.");
        equivalencias.put("D", "-..");
        equivalencias.put("E", ".");
        equivalencias.put("F", "..-.");
        equivalencias.put("G", "--.");
        equivalencias.put("H", "....");
        equivalencias.put("I", "..");
        equivalencias.put("J", ".---");
        equivalencias.put("K", "-.-");
        equivalencias.put("L", ".-..");
        equivalencias.put("M", "--");
        equivalencias.put("N", "-.");
        equivalencias.put("Ñ", "--.--");
        equivalencias.put("O", "---");
        equivalencias.put("P", ".--.");
        equivalencias.put("Q", "--.-");
        equivalencias.put("R", ".-.");
        equivalencias.put("S", "...");
        equivalencias.put("T", "-");
        equivalencias.put("U", "..-");
        equivalencias.put("V", "...-");
        equivalencias.put("W", ".--");
        equivalencias.put("X", "-..-");
        equivalencias.put("Y", "-.--");

        String result = "";

        String[] firstSplit = morse.split("   ");

        for (String word: firstSplit) {
            String[] secondSplit = word.split(" ");

            for (String letter: secondSplit) result += equivalencias.inverse().get(letter);

            result += " ";
        }
        return result;
    }
}
