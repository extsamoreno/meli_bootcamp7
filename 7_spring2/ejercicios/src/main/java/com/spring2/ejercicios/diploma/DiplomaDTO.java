package com.spring2.ejercicios.diploma;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiplomaDTO {

    private String mensaje;

    private String nombre;

    private double promedio;

    private String felicitaciones;

}
