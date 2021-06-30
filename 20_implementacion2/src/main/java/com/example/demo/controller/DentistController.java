package com.example.demo.controller;

import com.example.demo.dto.DentistDTO;
import com.example.demo.entity.Dentist;
import com.example.demo.service.IDentistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentist")
@AllArgsConstructor
public class DentistController {

    IDentistService dentistService;

    @GetMapping("/get/{id}")
    public ResponseEntity<DentistDTO> getDentist(@PathVariable Long id) {
        return new ResponseEntity<>(dentistService.retrieveDentist(id), HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDentist(@RequestBody Dentist dentist) {
        return new ResponseEntity<>(dentistService.addDentist(dentist), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateDentist(@RequestBody Dentist dentist) {
        return new ResponseEntity<>(dentistService.updateDentist(dentist), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable Long id) {
        return new ResponseEntity<>(dentistService.deleteDentist(id), HttpStatus.OK);
    }
}