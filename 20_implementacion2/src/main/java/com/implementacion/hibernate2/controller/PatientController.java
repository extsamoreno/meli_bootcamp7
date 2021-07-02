package com.implementacion.hibernate2.controller;

import com.implementacion.hibernate2.controller.dto.patients.PatientListDetailsDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientsListDTO;
import com.implementacion.hibernate2.model.service.patients.IPatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final IPatientService patientService;

    // Inyeccion de dependencia a traves del constructor
    public PatientController(IPatientService patientService){
        this.patientService = patientService;
    }


    // EJERCICIO 1
    // Listar todos los pacientes de un día de todos los dentistas.
    @GetMapping("/{date}")
    public ResponseEntity<PatientsListDTO> listPatientsByDate(@PathVariable String date){
        return new ResponseEntity<>(patientService.listAllPatientsByDate(date), HttpStatus.OK);
    }


    @GetMapping("/details/{date}")
    public ResponseEntity<PatientListDetailsDTO> listPatientsByDateDetails(@PathVariable String date){
        return new ResponseEntity<>(patientService.listAllPatientsDetailsByDate(date), HttpStatus.OK);
    }

}
