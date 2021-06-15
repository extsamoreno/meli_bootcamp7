package com.ejercitacion.ejercitacion.diploma.controller;

import com.ejercitacion.ejercitacion.diploma.model.Student;
import com.ejercitacion.ejercitacion.diploma.model.Diploma;
import com.ejercitacion.ejercitacion.diploma.service.DiplomaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/generator")
public class DiplomaController {

    @Autowired
    private DiplomaServiceImpl diplomaService;

    @PostMapping("/diploma")
    public ResponseEntity<Diploma> generateDiploma(@Valid @RequestBody Student student) {
        return ResponseEntity.ok(diplomaService.generateDiploma(student));
    }
}
