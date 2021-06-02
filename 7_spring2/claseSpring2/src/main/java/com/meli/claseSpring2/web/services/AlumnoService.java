package com.meli.claseSpring2.web.services;

import com.meli.claseSpring2.web.dto.AlumnoDTO;
import com.meli.claseSpring2.web.dto.CasaDTO;
import com.meli.claseSpring2.web.dto.MateriaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data

public class AlumnoService {

    static List<AlumnoDTO>  listaAlumno= new ArrayList<>();
    public static void guardarAlumno(AlumnoDTO alumno){
        listaAlumno.add(alumno);
    }

    public static double calcularPromedio(String nombre){
        double promedio = 0;
        for(AlumnoDTO alumno:listaAlumno){
            if(alumno.getNombre().equals(nombre)){
                for(MateriaDTO materia:alumno.getMaterias()){
                    promedio = promedio + materia.getNota();
                }
                promedio = promedio/alumno.getMaterias().size();
                break;
            }
        }
        return promedio;
    }
}
