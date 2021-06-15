package com.obtenerdiploma.validaciones.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class DiplomaDTO {

    private double promedio;
    private String nombreAlumno;


}
