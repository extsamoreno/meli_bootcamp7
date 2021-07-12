package com.meli.AppConsultorioMySQL.controllers;

import com.meli.AppConsultorioMySQL.models.DTO.DentistDTO;
import com.meli.AppConsultorioMySQL.models.DTO.DentistFullDTO;
import com.meli.AppConsultorioMySQL.models.Dentist;
import com.meli.AppConsultorioMySQL.service.IDentistService;
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
    public ResponseEntity<DentistFullDTO> getDentist(@PathVariable Long id) {
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