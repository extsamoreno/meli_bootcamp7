package com.example.muelitas.controller;

import com.example.muelitas.dto.PatientDTO;
import com.example.muelitas.dto.ResponseDTO;
import com.example.muelitas.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createPatient(@RequestBody PatientDTO newPatient) {
        return new ResponseEntity<>(patientService.createPatient(newPatient), HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<PatientDTO> readPatient(@RequestParam Long idPatient) {
        return new ResponseEntity<>(patientService.readPatient(idPatient), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updatePatient(@RequestBody PatientDTO updatedPatient) {
        return new ResponseEntity<>(patientService.updatePatient(updatedPatient), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deletePatient(@RequestParam Long idPatient) {
        return new ResponseEntity<>(patientService.deletePatient(idPatient), HttpStatus.OK);
    }
}
