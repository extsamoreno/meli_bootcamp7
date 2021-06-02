package com.example.demo.EjercicioObtenerDiploma;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    private String nombre;
    private ArrayList<Asignatura> asignaturas;
}
