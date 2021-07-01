package com.implementacion.hibernate2.controller;

import com.implementacion.hibernate2.controller.dto.PatientsListDTO;
import com.implementacion.hibernate2.model.service.patients.IPatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final IPatientService patientService;

    public PatientController(IPatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/{date}")
    public ResponseEntity<PatientsListDTO> listPatientsByDate(@PathVariable String date){
        return new ResponseEntity<>(patientService.listAllPatientsByDate(date), HttpStatus.OK);
    }
}
