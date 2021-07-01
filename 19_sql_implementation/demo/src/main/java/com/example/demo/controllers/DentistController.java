package com.example.demo.controllers;

import com.example.demo.exceptions.DentistNotFoundException;
import com.example.demo.model.Dentist;
import com.example.demo.services.IDentistService;
import com.example.demo.services.dtos.AppointmentDTO;
import com.example.demo.services.dtos.DentistDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dentists")
@AllArgsConstructor
public class DentistController {

    IDentistService iDentistService;

    @PostMapping("/create")
    public ResponseEntity<String> createDentist(@RequestBody Dentist dentist) {
        iDentistService.createDentist(dentist);
        return new ResponseEntity<>("Dentist created correctly", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable Long id) {
        iDentistService.deleteDentistById(id);
        return new ResponseEntity<>("Dentist deleted correctly",HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DentistDTO> getDentistById(@PathVariable Long id ) throws DentistNotFoundException {
        return new ResponseEntity<>(iDentistService.findDentistById(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateDentist(@RequestBody Dentist dentist) {
        iDentistService.updateDentist(dentist);
        return new ResponseEntity<>("Dentist updated correctly",HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Dentist>> getAllDentist() {
        return new ResponseEntity<>(iDentistService.findAllDentists(),HttpStatus.OK);
    }

    @GetMapping("/busy")
    public ResponseEntity<List<DentistDTO>> getDentistWithMoreTowAppoiments(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return new ResponseEntity<>(iDentistService.getDentistWithMoreTowAppoiments(date),HttpStatus.OK);
    }

    @GetMapping("/dairy/{id}")
    public ResponseEntity<List<AppointmentDTO>> getDentistDairy(@PathVariable Long id ) throws DentistNotFoundException {
        return new ResponseEntity<>(iDentistService.getDentistDairy(id),HttpStatus.OK);
    }

}