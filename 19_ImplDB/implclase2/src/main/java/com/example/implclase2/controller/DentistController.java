package com.example.implclase2.controller;

import com.example.implclase2.model.dto.RequestCreateDentistDTO;
import com.example.implclase2.model.entity.Dentist;
import com.example.implclase2.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    IDentistService iDentistService;

    @PostMapping("/createDentist")
    public ResponseEntity<String> newDentistRequest(@Valid @RequestBody RequestCreateDentistDTO patient) {
        return new ResponseEntity<>(iDentistService.createDentist(patient), HttpStatus.CREATED);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Dentist>> listAllDentists()
    {
        return new ResponseEntity<>(iDentistService.getAllDentists(), HttpStatus.OK);
    }
}
