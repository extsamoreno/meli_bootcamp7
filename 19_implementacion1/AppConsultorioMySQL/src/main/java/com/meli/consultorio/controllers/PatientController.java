package com.meli.consultorio.controllers;

import com.meli.consultorio.models.dtos.PatientDTO;
import com.meli.consultorio.services.patient.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("patients")
@AllArgsConstructor
public class PatientController {

    IPatientService iPatientService;

    @PostMapping("/create")
    public String createPatient(@RequestBody PatientDTO patientDTO) {
        iPatientService.createPatient(patientDTO);
        return "Patient created correctly";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        iPatientService.deletePatientById(id);
        return "Patient deleted correctly";
    }

    @PutMapping("/update")
    public String updatePatient(@RequestBody PatientDTO patientDTO) {
        iPatientService.updatePatient(patientDTO);
        return "Patient updated correctly";
    }

    @GetMapping("/getAll")
    public Set<PatientDTO> getAllPatients() { return iPatientService.findAllPatient(); }

    @GetMapping("/getPatient/{id}")
    public PatientDTO getPatient(@PathVariable Long id) { return iPatientService.findPatientById(id); }
}
