package com.meli.romanos.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RomanosServiceImp implements IRomanosService {

    @Override
    public float romanoToDecimal(String romano) {

        if (romano == null || romano.length() == 0)
            return -1;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = romano.length(), result = map.get(romano.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(romano.charAt(i)) >= map.get(romano.charAt(i + 1)))
                result += map.get(romano.charAt(i));
            else
                result -= map.get(romano.charAt(i));
        }

        return result;
    }

    @Override
    public String decimalToRomano(float num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }
}
