package com.ejercicio._spring2.ej3.controller;

import com.ejercicio._spring2.ej3.dto.DiplomaDTO;
import com.ejercicio._spring2.ej3.dto.StudentDTO;
import com.ejercicio._spring2.ej3.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DiplomaController {

    @Autowired
    DiplomaService diplomaService;

    @PostMapping("/diploma")
    public ResponseEntity<DiplomaDTO> getDiploma(@Valid @RequestBody StudentDTO s) {
        DiplomaDTO diploma = diplomaService.getDiploma(s);
        return new ResponseEntity<>(diploma, HttpStatus.OK);
    }

}
