package com.example.demo;

public class Conversor {

    public static String convert(int number){

        int miles = number / 1000;
        int centenas = (number -miles *1000)/ 100;
        int decenas= (number -miles *1000 - centenas *100)/ 10;
        int unidades = number - decenas *10 - centenas * 100 - miles *1000;

        String roman = "";

        if(number >= 4000){
            roman = "Hasta aca llego nuestro conocimiento";
        }

        roman += subRoman(centenas, "M", "D", "C");
        roman += subRoman(decenas, "C", "L", "X");
        roman += subRoman(unidades, "X", "V", "I");

        return roman;
    }


    public static String  subRoman(int number, String big, String medium, String small){

        String roman = "";
        if(number < 4)
            for(int i= 0; i < number; i++ )
                roman += small;

        if(number == 4)
            roman += (small + medium);

        if(number >= 5 && number < 9){
            roman += medium;
            for(int i= 0; i < number-5; i++ )
                roman += small;
        }

        if(number == 9)
            roman += (small+ big);

        return roman;
    }
}
