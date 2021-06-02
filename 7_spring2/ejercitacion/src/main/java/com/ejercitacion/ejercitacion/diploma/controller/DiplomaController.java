package com.ejercitacion.ejercitacion.diploma.controller;

import com.ejercitacion.ejercitacion.diploma.model.Alumn;
import com.ejercitacion.ejercitacion.diploma.model.Diploma;
import com.ejercitacion.ejercitacion.diploma.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/generator")
public class DiplomaController {

    @Autowired
    private DiplomaService diplomaService;

    @PostMapping("/diploma")
    public ResponseEntity<Diploma> generateDiploma(@RequestBody Alumn alumn) {
        return ResponseEntity.ok(diplomaService.generateDiploma(alumn));
    }
}
