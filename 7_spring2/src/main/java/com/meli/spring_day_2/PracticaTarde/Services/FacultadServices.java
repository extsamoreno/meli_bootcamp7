package com.meli.spring_day_2.PracticaTarde.Services;

import com.meli.spring_day_2.PracticaTarde.Clases.Alumno;
import com.meli.spring_day_2.PracticaTarde.Clases.Asignatura;
import com.meli.spring_day_2.PracticaTarde.Dto.DiplomaDto;

public class FacultadServices {

    public DiplomaDto sePuedeGraduar(Alumno alumno){
        DiplomaDto result = new DiplomaDto();
        float promedio = 0;

        for (Asignatura asignatura: alumno.getAsignaturaList()){
            promedio += asignatura.getNota();
        }

        result.setPromedio(promedio / alumno.getAsignaturaList().size());

        if(result.getPromedio() >= 9){
            result.setMsg("Felicitaciones!!! Te has graduado con Honores");
        }else{
            result.setMsg("Que bien, te has graduado!");
        }

        result.setAlumno(alumno);

        return result;
    }
}
