package com.example.implclase2.controller;

import com.example.implclase2.model.dto.RequestCreatePatientDTO;
import com.example.implclase2.model.entity.Patient;
import com.example.implclase2.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    IPatientService iPatientService;

    @PostMapping("/createPatient")
    public ResponseEntity<String> newPatientRequest(@Valid @RequestBody RequestCreatePatientDTO patient)
    {
        return new ResponseEntity<>(iPatientService.createPatient(patient), HttpStatus.CREATED);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Patient>> listAllPatients()
    {
        return new ResponseEntity<>(iPatientService.getAllPatients(), HttpStatus.OK);
    }
}
