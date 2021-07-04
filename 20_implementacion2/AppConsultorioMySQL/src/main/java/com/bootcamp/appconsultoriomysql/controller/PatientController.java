package com.bootcamp.appconsultoriomysql.controller;

import com.bootcamp.appconsultoriomysql.dto.PatientDTO;
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

    @GetMapping("/get-patients-by-day")
    public ResponseEntity<Set<PatientDTO>> getAllByTurnsInDay(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        return new ResponseEntity<>(patientService.findAllByTurnsInDay(date.atStartOfDay()), HttpStatus.OK);
    }
}
