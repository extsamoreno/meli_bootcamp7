package com.consultorio.AppConsultorioMySQL.controllers;

import com.consultorio.AppConsultorioMySQL.model.Dentist;
import com.consultorio.AppConsultorioMySQL.service.IDentistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dentist")
@AllArgsConstructor
public class DentistController {
    @Autowired
    IDentistService iDentistService;

    @PostMapping("/add")
    public ResponseEntity<String> addDentist (@RequestBody Dentist dentist) {
        iDentistService.createDentist(dentist);
        return new ResponseEntity<String>("Se añadió el dentista "+dentist.getName(),HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<String> updateDentist (@RequestBody Dentist dentist) {
        iDentistService.updateDentist(dentist);
        return new ResponseEntity<String>("Se actualizó información del dentista "+dentist.getName(),HttpStatus.OK);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteDentist (@RequestBody Dentist dentist) {
        iDentistService.deleteDentist(dentist);
        return new ResponseEntity<String>("Se eliminó información del dentista "+dentist.getName(),HttpStatus.OK);
    }
}
