package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class GreetingController {

    @GetMapping("/romano/{number}")
    public  String convertRoman(@PathVariable int number){
        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roms = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder romanNumber = new StringBuilder();
        for (int i = 0; number > 0; i++)
            while (number >= val[i]) {
                romanNumber.append(roms[i]);
                number -= val[i];
            }
        return romanNumber.toString();
    }
}
