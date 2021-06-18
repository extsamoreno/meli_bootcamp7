package com.example.validaciones.Service;

import com.example.validaciones.dtos.AlumnoDTO;
import com.example.validaciones.dtos.DiplomaDTO;

public interface IDiplomaService {
    public DiplomaDTO getDiplomaById(Integer id);

    DiplomaDTO getDiploma(AlumnoDTO alumno);
}
