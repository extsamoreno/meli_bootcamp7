package com.example.exercises.Controllers;

import com.example.exercises.Models.Student;
import com.example.exercises.Service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ex3")
public class DiplomaController {

    @Autowired
    private DiplomaService service;

    @PostMapping("/generateDiploma")
    public ResponseEntity<?> generateDiploma(@RequestBody Student student) {
        return new ResponseEntity<>(service.getDiploma(student), HttpStatus.OK);
    }
}
