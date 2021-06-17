package com.ejercicio._spring2.ej3.service;

import com.ejercicio._spring2.ej3.dto.DiplomaDTO;
import com.ejercicio._spring2.ej3.dto.StudentDTO;

public interface IDiplomaService {
    public DiplomaDTO getDiploma(StudentDTO student);
}
