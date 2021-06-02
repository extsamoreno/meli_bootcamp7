package com.example.demo;

public class CodigoMorse {

    private static String[] code
            = {".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--",
            "--..", "|"};

    public static String convertCodigoMorse(String morseCode) {

        String resultado = "";
        String[] separadorPalabra = morseCode.split("   ");

        for (int x = 0; x < separadorPalabra.length ; x++) {

            String[] letra = separadorPalabra[x].split(" ");

            // Convertir codigo morse
            for (int i = 0 ; i < letra.length ; i++) {
                for (int j = 0; j < code.length; j++) {
                    if (letra[i].compareTo(code[j]) == 0) {
                        resultado += (char) (j + 'a');
                        break;
                    }
                }
            }
            if(x < separadorPalabra.length) {
                resultado += " ";
            }
        }
        return resultado.toUpperCase();
    }
}
