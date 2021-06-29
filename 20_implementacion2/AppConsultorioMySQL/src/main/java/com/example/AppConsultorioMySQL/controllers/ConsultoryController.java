package com.example.AppConsultorioMySQL.controllers;

import com.example.AppConsultorioMySQL.models.entities.Dentist;
import com.example.AppConsultorioMySQL.models.entities.Turn;
import com.example.AppConsultorioMySQL.services.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentist")
@AllArgsConstructor
public class ConsultoryController {
    private ITurnService turnService;
    private IDentistService dentistService;
    private IScheduleService scheduleService;
    private IPatientService patienteService;

    @PostMapping("/add")
    public ResponseEntity<String> addDentist(@RequestBody Dentist dentist){
        return new ResponseEntity<String>(dentistService.addDentist(dentist), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateDentist(@RequestBody Dentist dentist){
        return new ResponseEntity<String>(dentistService.updateDentist(dentist), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable Long id){
        return new ResponseEntity<String>(dentistService.deleteDentist(id), HttpStatus.OK);
    }
}
