package com.spring2.ejercicios.calcularedad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/age")
public class CalcularEdadController {

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<String> getAge(@PathVariable("day") Integer day,
                                   @PathVariable("month") Integer month,
                                   @PathVariable("year") Integer year
                                   ) {

        String dayClean = "";
        if(month <= 9){ dayClean = "0"+month; }
        else { dayClean = String.valueOf(month); }

        String monthClean = "";
        if(month <= 9){ monthClean = "0"+month; }
        else { monthClean = String.valueOf(month); }

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateBorn = LocalDate.parse(dayClean + "/" + monthClean + "/" + year, fmt);
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateBorn, now);
        int age = period.getYears();

        return new ResponseEntity<>(String.valueOf(age), HttpStatus.OK);
    }
}
