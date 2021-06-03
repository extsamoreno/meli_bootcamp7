package com.calculadoras.calculadoras.controllers;
import com.calculadoras.calculadoras.entity.Alumno;
import com.calculadoras.calculadoras.helpers.AlumnoHelper;
import com.calculadoras.calculadoras.mapper.DiplomaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @PostMapping("/obtenerdiploma")
    public ResponseEntity<DiplomaDTO> getDiploma(@RequestBody Alumno alumno){
        return new ResponseEntity<>(
                new DiplomaDTO(
                        AlumnoHelper.getMensaje(
                                AlumnoHelper.getPromedio(alumno.getAsignaturasAprobadas())
                        ),
                        AlumnoHelper.getPromedio(alumno.getAsignaturasAprobadas()),
                        alumno), HttpStatus.OK);
    }

}
