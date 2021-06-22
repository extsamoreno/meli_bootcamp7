package com.example.demo;

public class Convertidor {

    private static String[] code
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "|", "—.—" };

    //método para pasar a números romanos
    public static String convertirANumerosRomanos(int numero) {
        int i, miles, centenas, decenas, unidades;
        String romano = "";

        //obtenemos cada cifra del número
        miles = numero / 1000;
        centenas = numero / 100 % 10;
        decenas = numero / 10 % 10;
        unidades = numero % 10;

        //millar
        for (i = 1; i <= miles; i++) {
            romano = romano + "M";
        }

        //centenas
        if (centenas == 9) {
            romano = romano + "CM";
        } else if (centenas >= 5) {
            romano = romano + "D";
            for (i = 6; i <= centenas; i++) {
                romano = romano + "C";
            }
        } else if (centenas == 4) {
            romano = romano + "CD";
        } else {
            for (i = 1; i <= centenas; i++) {
                romano = romano + "C";
            }
        }

        //decenas
        if (decenas == 9) {
            romano = romano + "XC";
        } else if (decenas >= 5) {
            romano = romano + "L";
            for (i = 6; i <= decenas; i++) {
                romano = romano + "X";
            }
        } else if (decenas == 4) {
            romano = romano + "XL";
        } else {
            for (i = 1; i <= decenas; i++) {
                romano = romano + "X";
            }
        }

        //unidades
        if (unidades == 9) {
            romano = romano + "IX";
        } else if (unidades >= 5) {
            romano = romano + "V";
            for (i = 6; i <= unidades; i++) {
                romano = romano + "I";
            }
        } else if (unidades == 4) {
            romano = romano + "IV";
        } else {
            for (i = 1; i <= unidades; i++) {
                romano = romano + "I";
            }
        }
        return romano;
    }


    public static String morseATexto(String codigoMorse) {
        System.out.print("Codigo morse es : " + codigoMorse
                + " Y traducido es : ");

        String[] separadorPalabras = codigoMorse.split("   ");
        String codigoTexto = "";

        for (int i = 0; i < separadorPalabras.length ; i++) {
            String[] array = separadorPalabras[i].split(" ");


            for (int k = 0; k < array.length; k++) {

                if(array[k].compareTo("--.--") == 0){
                    codigoTexto += "ñ";
                }

                for (int j = 0; j < code.length; j++) {
                    if (array[k].compareTo(code[j]) == 0) {
                        System.out.print((char)(j + 'a') + " ");
                        codigoTexto = codigoTexto + ((char)(j + 'a'));
                        break;
                    }
                }
            }
            if (!(i == separadorPalabras.length-1))
                codigoTexto += " ";
        }

        return codigoTexto;
    }


}