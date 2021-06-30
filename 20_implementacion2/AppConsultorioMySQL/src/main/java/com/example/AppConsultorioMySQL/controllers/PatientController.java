package com.example.AppConsultorioMySQL.controllers;
import com.example.AppConsultorioMySQL.models.entities.Patient;
import com.example.AppConsultorioMySQL.services.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {
    private IPatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Patient patient){
        return new ResponseEntity<String>(patientService.createPatient(patient), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody Patient patient){
        return new ResponseEntity<String>(patientService.updatePatient(patient), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity<String>(patientService.deletePatient(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Patient>> getAll(){
        return new ResponseEntity<>(patientService.findAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id){
        return new ResponseEntity<>(patientService.findPatientById(id), HttpStatus.OK);
    }
}
