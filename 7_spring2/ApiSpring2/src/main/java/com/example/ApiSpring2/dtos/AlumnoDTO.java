package com.example.ApiSpring2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class AlumnoDTO {
    private String nombre;
    private ArrayList<AsignaturaDTO> asignaturas;
}
