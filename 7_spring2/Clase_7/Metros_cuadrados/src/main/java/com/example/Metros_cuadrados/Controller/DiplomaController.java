package com.example.Metros_cuadrados.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/diploma")
public class DiplomaController {

    @PostMapping("/obtenerDiploma")
    public ResponseEntity<DiplomaDTO> devolverMetrosCuadradosPorHabitacion(@RequestBody Alumno alumno){
        double promedio = 0;
        double sumaNotas = 0;
        int cantAsignturas = alumno.getAsignaturas().size();

        for (int i = 0; i < alumno.getAsignaturas().size(); i++) {
            sumaNotas = sumaNotas + alumno.getAsignaturas().get(i).getNota();
        }

        promedio = sumaNotas / cantAsignturas;

        if( promedio > 9){
            DiplomaFelicitacionDTO diplomaFelicitacion = new DiplomaFelicitacionDTO();

            diplomaFelicitacion.setNombreAlumno(alumno.getNombre());
            diplomaFelicitacion.setPromedio(promedio);

            return new ResponseEntity<>(diplomaFelicitacion, HttpStatus.OK);
        } else {
            DiplomaStandarDTO diplomaStandar = new DiplomaStandarDTO();

            diplomaStandar.setNombreAlumno(alumno.getNombre());
            diplomaStandar.setPromedio(promedio);

            return new ResponseEntity<>(diplomaStandar, HttpStatus.OK);
        }
    }

}