package com.spring2.ejercicios.diploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring2.ejercicios.casa.ModelHouse;
import com.spring2.ejercicios.casa.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataInput;

@RestController
@RequestMapping("/diploma")
public class diplomaController {

    @PostMapping("/imprimir")
    public ResponseEntity<DiplomaDTO> getDatosAlumno(@RequestBody Alumno datosAlumno) {

        Alumno alumno = new Alumno();
        alumno.setNombre(datosAlumno.getNombre());
        alumno.setMaterias(datosAlumno.getMaterias());
        String mensaje = "Certificado que pasó por acá";
        String nombre = alumno.getNombre();
        double promedio = alumno.promedio();
        String felicitaciones = alumno.promedioAlto();

        DiplomaDTO diploma = new DiplomaDTO(mensaje, nombre,promedio, felicitaciones);

        return new ResponseEntity<>(diploma, HttpStatus.OK);
    }
}
