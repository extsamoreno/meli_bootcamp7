package com.obtenerDiploma;

import com.models.Alumno;
import com.models.Diploma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObtenerDiplomaController {

    @PostMapping("/obtenerDiploma")
    public ResponseEntity<Diploma> obtenerDiploma (@RequestBody Alumno alumno){
        return (new ResponseEntity<>(PromedioService.calcularPromedio(alumno), HttpStatus.OK));
    }
}
