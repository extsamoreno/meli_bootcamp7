package com.meli.claseSpring2.web.controller;

import com.meli.claseSpring2.web.dto.AlumnoDTO;
import com.meli.claseSpring2.web.response.DiplomaResponse;
import com.meli.claseSpring2.web.services.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumno")
public class promedioController {

    @PostMapping("/crear")
    public ResponseEntity<AlumnoDTO> crearAlumno(@RequestBody AlumnoDTO alumno){
        AlumnoService.guardarAlumno(alumno);
        return new ResponseEntity<>(alumno,HttpStatus.CREATED);
    }


    @GetMapping("/diploma/{nombre}")
    public ResponseEntity<DiplomaResponse> generarDiploma(@PathVariable String nombre){
        double promedio = AlumnoService.calcularPromedio(nombre);
        String mensaje = "diploma otorgado por cursar";
        if(promedio>9){
            mensaje = "QUE GRANDE, SOS UN RE CAPO";
        }
        return new ResponseEntity<>(new DiplomaResponse(nombre,mensaje,promedio), HttpStatus.OK);
    }

}
