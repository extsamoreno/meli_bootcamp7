package com.meli.AppConsultorioMySQL.controllers;

import com.meli.AppConsultorioMySQL.models.PatientEntity;
import com.meli.AppConsultorioMySQL.service.IPtientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
@AllArgsConstructor
public class ConsultorController {

    private IPtientService iPtientService;

    @PostMapping("/create")
    public String createStudent(@RequestBody PatientEntity patientEntity){
        iPtientService.createPatient(patientEntity);
        return "Se creo el estudiante";
    }
}
