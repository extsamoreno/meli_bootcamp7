package com.example.demo.demo;

import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    private String nombre;
    private ArrayList<Asignatura> asignaturas = new ArrayList<>();
}
