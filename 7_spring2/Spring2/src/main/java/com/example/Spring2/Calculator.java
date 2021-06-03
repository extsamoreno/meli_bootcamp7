package com.example.Spring2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
public class Calculator {

    public static Integer calcAge(Integer day, Integer month, Integer year){

        LocalDate date = LocalDate.of(year,month,day) ;
        Period period =  Period.between(date, LocalDate.now());

        return period.getYears();
    }

}
