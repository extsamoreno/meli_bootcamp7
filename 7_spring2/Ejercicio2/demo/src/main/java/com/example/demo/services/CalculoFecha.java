package com.example.demo.services;

import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.Year;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.*;

public class CalculoFecha {

    public static Integer calcularFechas(String dia, String mes, String ano){
            Integer salida = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ChronoLocalDate fechaEntrada = ChronoLocalDate.from(formatter.parse(dia+"/" +mes+"/"+ano));
            ChronoLocalDate fechaHoy = LocalDate.now();

            ChronoPeriod diaDiferencia = ChronoPeriod.between(fechaEntrada,fechaHoy);

            System.out.println(diaDiferencia.get(YEARS) + " AÑO " + diaDiferencia.get(MONTHS) + " MES " + diaDiferencia.get(DAYS) + " DIA ");
            salida = Integer.valueOf((int) diaDiferencia.get(YEARS));

        }catch (Exception exception){
            salida = -1;
        }
        return salida;
    }
}
