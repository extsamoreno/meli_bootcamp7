package boorcamp.spring.dos.demo.controller;


import boorcamp.spring.dos.demo.entidades.Diploma;
import boorcamp.spring.dos.demo.entidades.Estudiante;
import boorcamp.spring.dos.demo.services.DiplomaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estudiante")
public class DiplomaController {

    @Autowired
    DiplomaServices diplomaServices;

    @PostMapping("diploma")
    public ResponseEntity<Diploma> getDiploma(@RequestBody Estudiante estudiante){
        return new ResponseEntity<>(diplomaServices.getDiploma(estudiante), HttpStatus.OK);
    }




}
