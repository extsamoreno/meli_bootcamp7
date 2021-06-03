package com.example.ApiSpring2.entities;

import com.example.ApiSpring2.dtos.AsignaturaDTO;
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
