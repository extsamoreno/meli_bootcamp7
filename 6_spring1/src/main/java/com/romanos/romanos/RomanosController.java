package com.romanos.romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertToRoman")
public class RomanosController {
    @GetMapping("/{number}")
    public String getRomano(@PathVariable int number){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(number >= values[i]) {
                number -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }


}