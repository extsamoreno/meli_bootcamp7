package com.ejerciciotm.clase2.services;

import com.ejerciciotm.clase2.models.Age;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class AgeService {

    public Age calculateAge(int day, int month, int year){
        Age age = new Age();
        LocalDate ld = LocalDate.of(year, month, day);
        Period period = Period.between(ld, LocalDate.now());
        age.setAge(period.getYears());
        return age;
    }
}
