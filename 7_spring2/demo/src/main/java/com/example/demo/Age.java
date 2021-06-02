package com.example.demo;

import java.time.LocalDate;
import java.time.Period;

public class Age {
    public String age(int year, int month, int day){
        Period age = Period.between(LocalDate.of(year, month, day), LocalDate.now());
        return "La edad es: "+" "+ age.getYears() +" años";
    }
}
