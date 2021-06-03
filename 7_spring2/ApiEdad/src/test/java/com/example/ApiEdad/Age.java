package com.example.ApiEdad;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Age {

    public static int getAge(String date){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(date, fmt);
        LocalDate now = LocalDate.now();

        Period periodo = Period.between(birthDate, now);
        return periodo.getYears();
    }
}
