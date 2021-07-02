package com.example.AppConsultorioMySQL.controllers;

import com.example.AppConsultorioMySQL.Exceptions.DentistNotFoundException;
import com.example.AppConsultorioMySQL.dtos.DentistDTO;
import com.example.AppConsultorioMySQL.services.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dentist")
@AllArgsConstructor
public class DentistController {
    IDentistService dentistService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody DentistDTO dentist){
        return new ResponseEntity<String>(dentistService.createDentist(dentist), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody DentistDTO dentist) throws DentistNotFoundException {
        return new ResponseEntity<String>(dentistService.updateDentist(dentist), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws DentistNotFoundException {
        return new ResponseEntity<String>(dentistService.deleteDentist(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DentistDTO>> getAll(){
        return new ResponseEntity<>(dentistService.findAllDentists(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DentistDTO> getById(@PathVariable Long id) throws DentistNotFoundException {
        return new ResponseEntity<>(dentistService.findDentistById(id), HttpStatus.OK);
    }

    @GetMapping("/listDentistMoreThan2TurnsByDate/{date}")
    public ResponseEntity<List<DentistDTO>> listDentistMoreThan2TurnsByDate (@PathVariable String date){
        LocalDate localDate = LocalDate.parse(date);

        return new ResponseEntity<>(dentistService.listDentistMoreThan2TurnsByDate(localDate), HttpStatus.OK);
    }
}
