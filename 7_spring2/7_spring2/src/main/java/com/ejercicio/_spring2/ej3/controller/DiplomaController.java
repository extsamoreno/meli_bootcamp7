package com.ejercicio._spring2.ej3.controller;

import com.ejercicio._spring2.ej3.dto.DiplomaDTO;
import com.ejercicio._spring2.ej3.dto.StudentDTO;
import com.ejercicio._spring2.ej3.service.DiplomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DiplomaController {


    @PostMapping("/alumno")
    public ResponseEntity<DiplomaDTO> obtenerDiploma(@RequestBody StudentDTO s) {
        DiplomaService service = new DiplomaService();
        DiplomaDTO diploma = service.obtenerDiploma(s);
        return new ResponseEntity<>(diploma, HttpStatus.OK);
    }

}
