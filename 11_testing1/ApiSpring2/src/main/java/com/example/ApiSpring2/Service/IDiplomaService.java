package com.example.ApiSpring2.Service;

import com.example.ApiSpring2.dtos.AlumnoDTO;
import com.example.ApiSpring2.dtos.DiplomaDTO;

public interface IDiplomaService {
    public DiplomaDTO getDiplomaById(Integer id);

    DiplomaDTO getDiploma(AlumnoDTO alumno);
}
