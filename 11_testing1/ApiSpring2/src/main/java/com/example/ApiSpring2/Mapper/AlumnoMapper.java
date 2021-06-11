package com.example.ApiSpring2.Mapper;

import com.example.ApiSpring2.dtos.AlumnoDTO;
import com.example.ApiSpring2.entities.Alumno;

public class AlumnoMapper {
    public static AlumnoDTO toDto(Alumno alumno) {
        return new AlumnoDTO(alumno.getNombre(),alumno.getAsignaturas());
    }
}
