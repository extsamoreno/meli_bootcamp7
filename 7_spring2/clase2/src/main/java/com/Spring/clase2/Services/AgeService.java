package com.Spring.clase2.Services;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class AgeService {

    public long calulateAge(String dateBorn){
        LocalDate fNacimiento = LocalDate.parse(dateBorn, DateTimeFormatter.ofPattern("dd-MM-yyyy") );

        return ChronoUnit.YEARS.between(fNacimiento, LocalDate.now());
    }


}
