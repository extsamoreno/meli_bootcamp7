package com.example.demo.EjercicioObtenerDiploma;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class DiplomaDTO {
    private double promedio;
    private String nombreAlumno;

}
