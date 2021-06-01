package com.meli.demo;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Hashmap;

public class Morse {

    public static String toText(String code){
        String text = "";
        String[] words = code.split("   ");

        HashMap<String, Character> equivalencias = equivalencias();

        try{
            for( String w: words){
                String[] letters = w.split(" ");

                for(String l: letters){
                    text +=  equivalencias.get(l).toString();
                }
                text += " ";
            }
        }
        catch (Exception e){

            System.out.println("e = " + e);
            text = "Decodifique hasta aca: " + text + " hay un error luego de ese texto";
        }


        return text;
    }

    public static HashMap<String, Character> equivalencias(){
        HashMap<String, Character> morseAlphabet = new HashMap();
        morseAlphabet.put(".-", 'A');
        morseAlphabet.put("-...", 'B');
        morseAlphabet.put("-.-.", 'C');
        morseAlphabet.put("-..", 'D');
        morseAlphabet.put(".", 'E');
        morseAlphabet.put("..-.", 'F');
        morseAlphabet.put("--.", 'G');
        morseAlphabet.put("....", 'H');
        morseAlphabet.put("..", 'I');
        morseAlphabet.put(".---", 'J');
        morseAlphabet.put("-.-", 'K');
        morseAlphabet.put(".-..", 'L');
        morseAlphabet.put("--", 'M');
        morseAlphabet.put("-.", 'N');
        morseAlphabet.put("---", 'O');
        morseAlphabet.put(".--.", 'P');
        morseAlphabet.put("--.-", 'Q');
        morseAlphabet.put(".-.", 'R');
        morseAlphabet.put("...", 'S');
        morseAlphabet.put("-", 'T');
        morseAlphabet.put("..-", 'U');
        morseAlphabet.put("...-", 'V');
        morseAlphabet.put(".--", 'W');
        morseAlphabet.put("-..-", 'X');
        morseAlphabet.put("-.--", 'Y');
        morseAlphabet.put("--..", 'Z');
        morseAlphabet.put("-----", '0');
        morseAlphabet.put(".----", '1');
        morseAlphabet.put("..---", '2');
        morseAlphabet.put("...--", '3');
        morseAlphabet.put("....-", '4');
        morseAlphabet.put(".....", '5');
        morseAlphabet.put("-....", '6');
        morseAlphabet.put("--...", '7');
        morseAlphabet.put("---..", '8');
        morseAlphabet.put("----.", '9');

        return morseAlphabet;
    }
}
