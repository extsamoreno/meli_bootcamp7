package com.example.validaciones.entities;

import com.example.validaciones.dtos.AsignaturaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Alumno {
    private Integer id;
    private String nombre;
    private ArrayList<AsignaturaDTO> asignaturas;
}
