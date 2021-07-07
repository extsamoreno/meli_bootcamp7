package com.meli.muelitas.controller;

import com.meli.muelitas.dto.PatientDTO;
import com.meli.muelitas.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @PostMapping("/newPatient")
    ResponseEntity<Void> createPatient(@RequestBody PatientDTO patientDTO) {
        patientService.createPatient(patientDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<PatientDTO>> getPatientList() {
        return new ResponseEntity<>(patientService.getPatientList(), HttpStatus.OK);
    }

    @GetMapping("/patientNit/{nit}")
    ResponseEntity<PatientDTO> getPatientByNit(@PathVariable String nit) {
        return new ResponseEntity<>(patientService.getPatientByNit(nit), HttpStatus.OK);
    }

    @GetMapping("/patientName/{name}")
    ResponseEntity<PatientDTO> getPatientByName(@PathVariable String name) {
        return new ResponseEntity<>(patientService.getPatientByName(name), HttpStatus.OK);
    }

    @GetMapping("/patientId/{id}")
    ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
    }


}
