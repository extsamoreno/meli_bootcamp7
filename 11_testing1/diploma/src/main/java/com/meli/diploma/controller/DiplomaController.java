package com.meli.diploma.controller;

import com.meli.diploma.dto.StudentDTO;
import com.meli.diploma.service.IDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DiplomaController {

    @Autowired
    private IDiplomaService diplomaService;

    @PostMapping("/generateDiplomaStudent")
    public ResponseEntity<?> generateDiplomaStudent(@Valid @RequestBody StudentDTO student) {
        return new ResponseEntity<>(diplomaService.getDiplomaStudent(student), HttpStatus.OK);
    }

}
