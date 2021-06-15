package com.obtenerdiploma.validaciones.Service;

import com.obtenerdiploma.validaciones.Dto.DiplomaDTO;
import com.obtenerdiploma.validaciones.Dto.DiplomaFelicitacionDTO;
import com.obtenerdiploma.validaciones.Dto.DiplomaStandarDTO;
import com.obtenerdiploma.validaciones.Model.Alumno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public  class DiplomaService implements IDiplomaService{


    public double calcularPromedio(Alumno alumno){

        double promedio = 0;
        double sumaNotas = 0;
        int cantAsignturas = alumno.getAsignaturas().size();

        for (int i = 0; i < alumno.getAsignaturas().size(); i++) {
            sumaNotas = sumaNotas + alumno.getAsignaturas().get(i).getNota();
        }

        promedio = sumaNotas / cantAsignturas;
        return promedio;
    }


        public DiplomaDTO entregarDiploma (Alumno alumno){
        double promedio= calcularPromedio(alumno);
            if( promedio > 9){
                DiplomaFelicitacionDTO diplomaFelicitacion = new DiplomaFelicitacionDTO();

                diplomaFelicitacion.setNombreAlumno(alumno.getNombre());
                diplomaFelicitacion.setPromedio(promedio);

                return diplomaFelicitacion;
            } else {
                DiplomaStandarDTO diplomaStandar = new DiplomaStandarDTO();

                diplomaStandar.setNombreAlumno(alumno.getNombre());
                diplomaStandar.setPromedio(promedio);

                return diplomaStandar;
            }
        }





}
