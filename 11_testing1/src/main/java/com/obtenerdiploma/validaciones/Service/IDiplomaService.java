package com.obtenerdiploma.validaciones.Service;

import com.obtenerdiploma.validaciones.Dto.DiplomaDTO;
import com.obtenerdiploma.validaciones.Model.Alumno;

public interface IDiplomaService {

     double calcularPromedio(Alumno alumno);
     DiplomaDTO entregarDiploma (Alumno alumno);
}
