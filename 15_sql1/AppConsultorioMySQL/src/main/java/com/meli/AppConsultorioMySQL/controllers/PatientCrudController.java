package com.meli.AppConsultorioMySQL.controllers;

import com.meli.AppConsultorioMySQL.repositories.entities.PatientEntity;
import com.meli.AppConsultorioMySQL.services.IPatientCrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientCrudController {

    private IPatientCrudService patientService;

    @PostMapping("/addone")
    public ResponseEntity<String> addOne(@RequestBody PatientEntity patient){
        return new ResponseEntity<String>(patientService.addOne(patient), HttpStatus.OK);
    }

}
