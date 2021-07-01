package com.meli.consultorio.controller;

import com.meli.consultorio.dto.response.PatientResponse;
import com.meli.consultorio.model.Patient;
import com.meli.consultorio.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/muelitas/patient")
public class PatientController {
    @Autowired
    IPatientService iPatientService;

    @PostMapping("/crear")
    public ResponseEntity<?> savePatient(@RequestBody Patient patient){
        iPatientService.savePatient(patient);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatient(@PathVariable("id") Integer id){
        PatientResponse patientResponse = iPatientService.getPatient(id);
        return new ResponseEntity<>(patientResponse,HttpStatus.OK);
    }
}
