package com.meli.spring_day_2.PracticaTarde.Controllers;

import com.meli.spring_day_2.PracticaTarde.Clases.Alumno;
import com.meli.spring_day_2.PracticaTarde.Dto.DiplomaDto;
import com.meli.spring_day_2.PracticaTarde.Services.FacultadServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacultadController {

    FacultadServices fs = new FacultadServices();

    @PostMapping("/graduarse")
    public ResponseEntity<DiplomaDto> graduarAlumno(@RequestBody Alumno alumno){
        DiplomaDto result = fs.sePuedeGraduar(alumno);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
