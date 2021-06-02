package com.example.demo.DTO;

import lombok.Data;

import java.util.List;

@Data
public class Alumno {

    private String nombre;
    private List<Asignaturas> listaAsignaturas;

}
