package com.meli.AppConsultorioMySQL.controllers;

import com.meli.AppConsultorioMySQL.dtos.DentistDto;
import com.meli.AppConsultorioMySQL.repositories.entities.DentistEntity;
import com.meli.AppConsultorioMySQL.repositories.entities.PatientEntity;
import com.meli.AppConsultorioMySQL.services.IDentistCrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/dentist")
public class DentistCrudController {

    private IDentistCrudService dentistService;

    @PostMapping("/addone")
    public ResponseEntity<String> addOne(@RequestBody DentistEntity dentist){
        return new ResponseEntity<String>(dentistService.addOne(dentist), HttpStatus.OK);
    }

    @GetMapping("/get")
    public  ResponseEntity<DentistDto> getById(@RequestParam("id") Long id){
        return new ResponseEntity<DentistDto>(dentistService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public  ResponseEntity<List<DentistDto>> getById(){
        return new ResponseEntity<List<DentistDto>>(dentistService.getAll(), HttpStatus.OK);
    }
}
