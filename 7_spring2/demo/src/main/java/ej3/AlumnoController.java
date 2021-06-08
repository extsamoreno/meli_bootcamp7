package ej3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlumnoController {

    @PostMapping("/diploma")
    public ResponseEntity<DiplomaDTO> generarDiploma(@RequestBody Alumno alumno){
        return new ResponseEntity<>(alumno.generarDiploma(),HttpStatus.OK);
    }
}
