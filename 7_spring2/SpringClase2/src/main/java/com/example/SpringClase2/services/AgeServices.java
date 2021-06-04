package com.example.springclase2.services;

import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class AgeServices {

    public static String calculateAge(String bornDateStr)
    {
        try {
            LocalDate bornDate = LocalDate.parse(bornDateStr);
            LocalDate ahora = LocalDate.now();

            Period period = Period.between(bornDate, ahora);
            return "Tu edad es: " + period.getYears() +  "años, " + period.getMonths() + " meses y " + period.getDays() + " días";

        }
        catch (Exception e)
        {
            return "-1";
        }
    }


}
