package com.example.dentaloffice.controller;

import com.example.dentaloffice.model.dto.request.CreatePatientDTO;
import com.example.dentaloffice.model.dto.response.PatientDTO;
import com.example.dentaloffice.service.IPatientService;
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
    public ResponseEntity<String> newPatientRequest(@Valid @RequestBody CreatePatientDTO patient)
    {
        return new ResponseEntity<>(iPatientService.createPatient(patient), HttpStatus.CREATED);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<PatientDTO>> listAllPatients()
    {
        return new ResponseEntity<>(iPatientService.getAllPatients(), HttpStatus.OK);
    }

    //add delete and get patient
}
