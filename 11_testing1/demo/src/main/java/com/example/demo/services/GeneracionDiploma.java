package com.example.demo.services;

import com.example.demo.DTO.Alumno;
import com.example.demo.DTO.Asignaturas;
import com.example.demo.DTO.Diploma;

public class GeneracionDiploma {

    public static Diploma generarDiploma(Alumno alumno){
        Diploma diploma = new Diploma();
        double acumulador = 0;

        for (Asignaturas asignatura: alumno.getListaAsignaturas()) {
            acumulador += asignatura.getNota();
        }
        diploma.setPromedio(acumulador/alumno.getListaAsignaturas().size());
        diploma.setAlumno(alumno.getNombre());
        diploma.setMensaje(" SE LE OTORGA EL DIPLOMA A " + diploma.getAlumno() + " POR COMPLETAR TODAS LAS ASIGNATURAS  ");
        if (diploma.getPromedio() > 9)
            diploma.setMensaje(diploma.getMensaje() + " SE LE FELICITA POR HABER OBTENIDO UN PROMEDIO SUPERIOR A 9");
        return diploma;
    }
}
