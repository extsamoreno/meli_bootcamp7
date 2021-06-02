package com.calculadora;

import com.models.ResponseEdadDTO;

import java.time.LocalDate;
import java.time.Period;

public class AgeService {

    public static ResponseEdadDTO calcularEdad(Integer day, Integer month, Integer year){

        LocalDate date = LocalDate.of(year,month,day) ;
        Period period =  Period.between(date, LocalDate.now());

        return new ResponseEdadDTO(day, month, year, period.getYears());

    }
}
