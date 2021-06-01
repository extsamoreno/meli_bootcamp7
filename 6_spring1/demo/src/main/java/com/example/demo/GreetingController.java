package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @GetMapping("/toRomanNumber/{numero}")
    public String getHello(@PathVariable Integer numero) {
        int i, miles, centenas, decenas, unidades;
        String romano = "";
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

    @GetMapping("/text/{code}")
    public String getText(@PathVariable String code) {
        String res = "";
        String[] palabras = code.split("   ");
        HashMap<String, String> morse = morseToString();
        for (String p : palabras) {
            String[] letras = p.split(" ");
            for (String l : letras) {
                if (morse.containsKey(l))
                    res = res + morse.get(l);
                else
                    return res = "Hubo un error en decodificar";
            }
            res = res + " ";
        }
        return res;

    }

    public HashMap<String, String> stringToMorse() {
        HashMap<String, String> res = new HashMap<>();
        res.put("A", ".-");
        res.put("B", "-...");
        res.put("C", "-.-.");
        res.put("CH", "----");
        res.put("D", "-..");
        res.put("E", ".");
        res.put("F", "..-.");
        res.put("G", "--.");
        res.put("H", "....");
        res.put("I", "..");
        res.put("J", ".---");
        res.put("K", "-.-");
        res.put("L", ".-..");
        res.put("M", "--");
        res.put("N", "-.");
        res.put("Ñ", "--.--");
        res.put("O", "---");
        res.put("P", ".--.");
        res.put("Q", "--.-");
        res.put("R", ".-.");
        res.put("S", "...");
        res.put("T", "-");
        res.put("U", "..-");
        res.put("V", "...-");
        res.put("W", ".--");
        res.put("X", "-..-");
        res.put("Y", "-.--");
        res.put("Z", "--..");
        res.put("0", "-----");
        res.put("1", ".----");
        res.put("2", "..---");
        res.put("3", "...--");
        res.put("4", "....-");
        res.put("5", ".....");
        res.put("6", "-....");
        res.put("7", "--...");
        res.put("8", "---..");
        res.put("9", "----.");
        res.put(".", ".-.-.-");
        res.put(",", "--..--");
        res.put(":", "---...");
        res.put("?", "..--..");
        res.put("'", ".----.");
        res.put("-", "-....-");
        res.put("/", "-..-.");
        res.put("\"", ".-..-.");
        res.put("@", ".--.-.");
        res.put("=", "-...-");
        res.put("!", "−.−.−−");
        return res;

    }

    public HashMap<String, String> morseToString() {
        HashMap<String, String> res = new HashMap<>();
        res.put(".-", "A");
        res.put("-...", "B");
        res.put("-.-.", "C");
        res.put("----", "CH");
        res.put("-..", "D");
        res.put(".", "E");
        res.put("..-.", "F");
        res.put("--.", "G");
        res.put("....", "H");
        res.put("..", "I");
        res.put(".---", "J");
        res.put("-.-", "K");
        res.put(".-..", "L");
        res.put("--", "M");
        res.put("-.", "N");
        res.put("--.--", "Ñ");
        res.put("---", "O");
        res.put(".--.", "P");
        res.put("--.-", "Q");
        res.put(".-.", "R");
        res.put("...", "S");
        res.put("-", "T");
        res.put("..-", "U");
        res.put("...-", "V");
        res.put(".--", "W");
        res.put("-..-", "X");
        res.put("-.--", "Y");
        res.put("--..", "Z");
        res.put("-----", "0");
        res.put(".----", "1");
        res.put("..---", "2");
        res.put("...--", "3");
        res.put("....-", "4");
        res.put(".....", "5");
        res.put("-....", "6");
        res.put("--...", "7");
        res.put("---..", "8");
        res.put("----.", "9");
        res.put(".-.-.-", ".");
        res.put("--..--", ",");
        res.put("---...", ":");
        res.put("..--..", "?");
        res.put(".----.", "'");
        res.put("-....-", "-");
        res.put("-..-.", "/");
        res.put(".-..-.", "\"");
        res.put(".--.-.", "@");
        res.put("-...-", "=");
        res.put("−.−.−−", "!");
        return res;

    }

}


