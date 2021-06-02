package com.meli.metrocuadrado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fecha {
    private int dia,mes,anio;

    public int calcularEdad(){
        Period edad= Period.between(LocalDate.of(anio,mes,dia), LocalDate.now());
        return edad.getYears();
    }
}
