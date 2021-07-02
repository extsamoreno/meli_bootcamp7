package com.example.AppConsultorioMySQL.controllers;
import com.example.AppConsultorioMySQL.Exceptions.PatientNotFoundException;
import com.example.AppConsultorioMySQL.dtos.PatientDTO;
import com.example.AppConsultorioMySQL.services.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {
    IPatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody PatientDTO patient){
        return new ResponseEntity<String>(patientService.createPatient(patient), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody PatientDTO patient) throws PatientNotFoundException {
        return new ResponseEntity<String>(patientService.updatePatient(patient), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws PatientNotFoundException {
        return new ResponseEntity<String>(patientService.deletePatient(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PatientDTO>> getAll(){
        return new ResponseEntity<>(patientService.findAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PatientDTO> getById(@PathVariable Long id) throws PatientNotFoundException {
        return new ResponseEntity<>(patientService.findPatientById(id), HttpStatus.OK);
    }

    @GetMapping("/listPatientsByDate/{date}")
    public ResponseEntity<List<PatientDTO>> listPatientsByDate (@PathVariable String date){
        LocalDate localDate = LocalDate.parse(date);

        return new ResponseEntity<>(patientService.listPatientsByDate(localDate), HttpStatus.OK);
    }
}
