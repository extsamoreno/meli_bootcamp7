package com.example.demo;

import java.util.HashMap;

public class Functions {
    public static String converterToRoma(int number){
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

    // Funcion para convertir de morse a texto

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

    //Equivalencias

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
