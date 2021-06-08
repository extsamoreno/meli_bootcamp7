package ej1;

import org.springframework.stereotype.Service;

@Service
public class Codificacion {

    private static final String[] CODE
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "|" };

    public static String morseToEnglish(String morseCode)
    {
        String[] array = morseCode.split(" ");
        String resultado = "";

        // Morse code to English
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < CODE.length; j++) {
                if (array[i].compareTo(CODE[j]) == 0) {
                    resultado +=(char)(j + 'a') + " ";
                    break;
                }
            }
        }
        return resultado;
    }

}
