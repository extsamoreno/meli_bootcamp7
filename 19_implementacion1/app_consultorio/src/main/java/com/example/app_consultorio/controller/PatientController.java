package com.example.app_consultorio.controller;

import com.example.app_consultorio.dto.PatientDTO;
import com.example.app_consultorio.model.Patient;
import com.example.app_consultorio.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/patient")
public class PatientController {

    IPatientService patientService;

    @PostMapping("/create")
    public String createPatient(@RequestBody Patient patient) {
        patientService.createPatient(patient);
        return "Patient created";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return "Patient deleted";
    }

    @PutMapping("/update")
    public String updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
        return "Patient updated";
    }

    @GetMapping("/getAll")
    public List<PatientDTO> getAllPatient() {
        return patientService.findAllPatients();
    }

    // 1- Listar todos los pacientes de un día de todos los dentistas
    @GetMapping("/getPatientsbyDate/{date}")
    public List<PatientDTO> getAllPatientsbyDate(@PathVariable String date) {
        return patientService.findAllPatientsByDate(date);
    }
}
