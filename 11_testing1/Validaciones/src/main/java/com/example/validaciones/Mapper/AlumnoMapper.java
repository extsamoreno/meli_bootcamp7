package com.example.validaciones.Mapper;

import com.example.validaciones.dtos.AlumnoDTO;
import com.example.validaciones.entities.Alumno;

public class AlumnoMapper {
    public static AlumnoDTO toDto(Alumno alumno) {
        return new AlumnoDTO(alumno.getNombre(),alumno.getAsignaturas());
    }
}
