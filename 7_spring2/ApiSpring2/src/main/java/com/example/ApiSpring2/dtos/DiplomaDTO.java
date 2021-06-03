package com.example.ApiSpring2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiplomaDTO {
    private String mensaje;
    private float promedio;
    private AlumnoDTO alumno;
}
