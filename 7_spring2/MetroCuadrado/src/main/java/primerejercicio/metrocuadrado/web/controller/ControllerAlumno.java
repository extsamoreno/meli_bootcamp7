package primerejercicio.metrocuadrado.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import primerejercicio.metrocuadrado.web.DTO.Alumno;
import primerejercicio.metrocuadrado.web.DTO.DiplomaDTO;
import primerejercicio.metrocuadrado.web.service.ServiceAlumno;

@RestController
@RequestMapping("/alumno")
public class ControllerAlumno {

    @Autowired
    private ServiceAlumno serviceAlumno;

    @PostMapping("/save")
    public ResponseEntity<Alumno> save(@RequestBody Alumno alumno){
        return new ResponseEntity<>(serviceAlumno.guardarAlumno(alumno) , HttpStatus.CREATED);
    }

    @GetMapping("/diploma")
    public ResponseEntity<DiplomaDTO> getDiploma(){
        return new ResponseEntity<>(serviceAlumno.obtenerDiploma(), HttpStatus.OK);
    }

}
