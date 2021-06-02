package com.meli.spring_day_2.PracticaTarde.Clases;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private List<Asignatura> asignaturaList;

    public Alumno() {
        this.asignaturaList = new ArrayList<>();
    }

    public Alumno(String nombre, List<Asignatura> asignaturaList) {
        this.nombre = nombre;
        this.asignaturaList = asignaturaList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Asignatura> getAsignaturaList() {
        return asignaturaList;
    }

    public void setAsignaturaList(List<Asignatura> asignaturaList) {
        this.asignaturaList = asignaturaList;
    }
}
