package com.example.springclase2.controllers;

import com.example.springclase2.dto.DiplomaDTO;
import com.example.springclase2.dto.Student;
import com.example.springclase2.services.DiplomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diploma")
public class DiplomaExerciseController {

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody Student student)
    {

        return new ResponseEntity<>("Estudiante guardado...", HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<DiplomaDTO> getDiploma()
    {
        DiplomaDTO diploma = DiplomaService.buildDiploma(student);
        return new ResponseEntity<>(diploma, HttpStatus.OK);
    }
}
