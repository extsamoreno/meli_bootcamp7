package com.example.exercises.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeCalculatorService {

    public Integer calculateAge(int day, int month, int year) {
        LocalDate date1 = LocalDate.of(year,month,day);
        LocalDate date2 = LocalDate.now();
        Period period = date1.until(date2);
        return period.getYears();
    }
}
