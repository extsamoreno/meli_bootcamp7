package com.implementacion.hibernate2.controller;

import com.implementacion.hibernate2.controller.dto.dentists.DentistDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientListDetailsDTO;
import com.implementacion.hibernate2.controller.dto.patients.PatientsListDTO;
import com.implementacion.hibernate2.controller.dto.patients.request.NewPatientDTO;
import com.implementacion.hibernate2.model.service.patients.IPatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Create Patient
    @PostMapping("/new-patient")
    @ResponseStatus(HttpStatus.OK)
    public void addNewPatient(@RequestBody NewPatientDTO newPatientDTO) {
        patientService.insertNewPatient(newPatientDTO);
    }

    // Get Patient By name
    @GetMapping("/get-patient-by-name/{name}")
    public ResponseEntity<PatientDTO> getPatientByName(@PathVariable String name){
        return new ResponseEntity<>(patientService.getPatientByName( name ), HttpStatus.OK);
    }

    // Get All Patient
    @GetMapping("/list")
    public ResponseEntity<PatientsListDTO> getAllPatient(){
        return new ResponseEntity<>(patientService.getAllPatient(), HttpStatus.OK);
    }

}
