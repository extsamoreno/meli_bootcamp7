package spring1.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DecimalToRoman")
public class DecimalToRoman {

    @GetMapping("/Convert/{number}")
    public String Convert(@PathVariable Integer number){
        return intToRoman(number);
    }

    private String intToRoman(Integer n){
        if (n>3999 || n<1){
            return "Ingrese un numero entre 1 y 4000";
        }

        var unitToRoman = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
        var tensToRoman = new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        var hundredsToRoman = new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        var thousandsToRoman = new String[]{"","M","MM","MMM"};
        var unit = n%10;
        var tens = n%100/10;
        var hundreds = n%1000/100;
        var thousands = n/1000;
        return thousandsToRoman[thousands] + hundredsToRoman[hundreds] + tensToRoman[tens] + unitToRoman[unit];
    }
}
