package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class RomanController {

    @GetMapping("/{n}")
    public String getRomano (@PathVariable Integer n){

        return "El numero "+ n +" en romano es: "+convertirIntegerARomano(n);
    }

    public String convertirIntegerARomano(Integer n){

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

        while(n > 0){
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
                Integer resto = n / entry.getKey();
                if(resto > 0){
                    valor += entry.getValue().repeat(resto);
                    n -= (entry.getKey() * resto);
                }
            }
        }

        return valor;

    }



}
