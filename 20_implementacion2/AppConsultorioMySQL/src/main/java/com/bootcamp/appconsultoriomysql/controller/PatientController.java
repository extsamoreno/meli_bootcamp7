package com.bootcamp.appconsultoriomysql.controller;

import com.bootcamp.appconsultoriomysql.dto.PatientDTO;
import com.bootcamp.appconsultoriomysql.model.Patient;
import com.bootcamp.appconsultoriomysql.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<Patient> create(@RequestBody PatientDTO patientDTO) {
        return new ResponseEntity<>(patientService.create(patientDTO), HttpStatus.OK);
    }

    @GetMapping("/get-patients-by-day")
    public ResponseEntity<Set<Patient>> getAllByTurnsInDay(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        System.out.println(date);

        return new ResponseEntity<>(patientService.findAllByTurnsInDay(date.atStartOfDay()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(patientService.findById(id).get(), HttpStatus.OK);
    }


}
