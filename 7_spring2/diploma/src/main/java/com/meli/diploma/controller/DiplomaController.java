package com.meli.diploma.controller;

import com.meli.diploma.domain.Student;
import com.meli.diploma.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiplomaController {
    @Autowired
    DiplomaService service;

    @PostMapping("/generateDiploma")
    public ResponseEntity<?> generateDiploma(@RequestBody Student student) {
        return new ResponseEntity<>(service.getDiploma(student),HttpStatus.OK);
    }
}
