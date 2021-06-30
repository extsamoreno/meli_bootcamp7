package com.meli.consultory.controllers;

import com.meli.consultory.models.Patient;
import com.meli.consultory.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    @PostMapping ("/create")
    public String createPatient(@RequestBody Patient patient) {
        patientService.createPatient(patient);
        return "Se creo nuevo Paciente";
    }

    @GetMapping ("/listAllPatients")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @GetMapping ("{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @GetMapping ("/update")
    public String updatePatient(Patient patient) {
        patientService.updatePatient(patient);
        return "Paciente Actualizado";
    }

    @GetMapping ("/delete")
    public String deletePatient(Patient patient) {
        patientService.deletePatient(patient);
        return "Paciente Eliminado";
    }
}
