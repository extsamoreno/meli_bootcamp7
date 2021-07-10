package com.appconsultorio.appconsultorio.controller;

import com.appconsultorio.appconsultorio.dtos.request.PatientDTO;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Patient;
import com.appconsultorio.appconsultorio.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("patient")
@AllArgsConstructor
public class PatientController {

    IPatientService iPatientService;

    /**
     * Listar todos los dentistas que tengan más de dos turnos en una fecha
     */
    @GetMapping("/findpatientbydatefordentists")
    public ResponseEntity<List<Patient>> getPatientByDateForDentists(@RequestParam String date){
        LocalDateTime dt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return new ResponseEntity<>(iPatientService.getPatientByDateForDentists(dt), HttpStatus.OK);
    }


    @PostMapping("/create")
    public String loadPatient(@RequestBody PatientDTO patientDTO){
        iPatientService.createPatient(patientDTO);
        return "Paciente creado correctamente";
    }

    @PostMapping("/edit")
    public String editPatient(@RequestBody PatientDTO patientDTO){
        iPatientService.updatePatient(patientDTO);
        return "Paciente editado correctamente";
    }

    @PostMapping("/remove")
    public String removePatient(@RequestParam int id){
        iPatientService.removePatient(id);
        return "Paciente eliminado correctamente";
    }

    @GetMapping("/getall")
    public List<Patient> getPatients(){
        return iPatientService.getPatient();
    }
}

