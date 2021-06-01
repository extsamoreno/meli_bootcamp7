package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController()
@RequestMapping("/romano")
public class RomanConversionController {

    @GetMapping("/{numero}")
    public String getRomano(@PathVariable Integer numero){
        return "El numero "+numero+" en romano es: "+ convertirIntegerARomano(numero);
    }

    /*public String convertirIntegerARomano(Integer number){
        String romanNumbers[] = {"M", "CMXC", "CM", "D", "CDXC", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Integer arab[] = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        Integer i = 0;
        while (number > 0 || arab.length == (i - 1)) {
            while ((number - arab[i]) >= 0) {
                number -= arab[i];
                result.append(romanNumbers[i]);
            }
            i++;
        }
        return result.toString();
    }*/

    public String convertirIntegerARomano(Integer n){
        String valor = "";

        Map<Integer,String> map = new LinkedHashMap<>();
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

        while (n > 0) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                Integer resto = n / entry.getKey();

                if ( resto > 0){
                    valor += entry.getValue().repeat(resto);
                    n -= entry.getKey() * resto;
                }
            }
        }

        return valor;
    }
}
