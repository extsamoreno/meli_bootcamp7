package com.ejerciciotm.clase1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/roman")
public class NumberRomanController {

    @GetMapping("/decimal/{number}")
    public String getNumberRoman(@PathVariable Integer number){
        return "El numero "+ number +" en romano es: "+ convertIntToRoman(number);
    }

    private String convertIntToRoman(Integer number){
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(990, "CMXC");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(490, "CDXC");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        String valor = "";

        while(number > 0){
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
                Integer resto = number / entry.getKey();
                if(resto > 0){
                    valor += entry.getValue().repeat(resto);
                    number -= (entry.getKey() * resto);
                }
            }
        }

        return valor;

    }
}
