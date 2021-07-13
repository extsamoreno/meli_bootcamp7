package com.example.dentaloffice.controller;

import com.example.dentaloffice.model.dto.request.CreateDentistDTO;
import com.example.dentaloffice.model.dto.response.DentistDTO;
import com.example.dentaloffice.service.IDentistService;
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
    public ResponseEntity<String> newDentistRequest(@Valid @RequestBody CreateDentistDTO patient) {
        return new ResponseEntity<>(iDentistService.createDentist(patient), HttpStatus.CREATED);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<DentistDTO>> listAllDentists()
    {
        return new ResponseEntity<>(iDentistService.getAllDentists(), HttpStatus.OK);
    }

    //add delete and get dentist
}
