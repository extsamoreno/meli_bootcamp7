package com.example.demo.services;
import java.util.*;

public class Conversor {


    private static final Map<String, Character> morseAlphabet = new HashMap<>();

    // store the all the alphabet in an array
    private static char[] letter = { 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0' };
    // Morse code by indexing
    private static String[] code
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "|" };

    public static int romanoToInt(String cadena){
        HashMap<Character,Integer> equivalencia = new HashMap<>(){{put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',1000);
            put('M',1000000);}};
        int valor = 0;
        int acum = 0;
        int i=1;
        while(i<cadena.length()-1) {
            int actual = equivalencia.get(cadena.charAt(i));
            int anterior = equivalencia.get(cadena.charAt(i-1));
            if (anterior< actual){
                valor= actual-anterior;
                acum = acum + valor;

            }
            else{
                acum = anterior + acum;
            }
            i++;
        }
        return acum;
    }

    public static String intToRomano(int num){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }

        return roman.toString();
    }




    public static String morseATexto(String morseCode)
    {
        String texto="";
        boolean bespacio = false;
        String[] array = morseCode.split(" ");
        // Morse code to English
        for (int i = 0; i < array.length; i++) {
            if(array[i].isEmpty()){
                if(bespacio){
                    texto = texto + " ";
                    bespacio = false;

                }else {
                    bespacio = true;
                }
            }
            else{
                bespacio = false;
            }
            for (int j = 0; j < code.length; j++) {

                if (array[i].compareTo(code[j]) == 0) {
                    texto = texto + (char)(j + 'a');
                    break;
                }
            }
        }
        return texto;
    }

    public static String textoAMorse(String englishLang)
    {   englishLang = englishLang.toLowerCase();
        String tradmorse ="";
        for (int i = 0; i < englishLang.length(); i++) {
            if(englishLang.charAt(i)==' '){
                tradmorse = tradmorse + "  ";
            }
            for (int j = 0; j < letter.length; j++) {
                if (englishLang.charAt(i) == letter[j]) {
                    tradmorse = tradmorse + code[j] + " ";
                    break;
                }
            }
        }
        return tradmorse;
    }


}
