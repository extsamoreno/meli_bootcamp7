package com.muelitas.demo.controllers;

import com.muelitas.demo.dtos.PatientDTO;
import com.muelitas.demo.exceptions.BadRequestException;
import com.muelitas.demo.services.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientController {

    private IPatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> addNewPatient(@RequestBody @Valid PatientDTO patient){
        patientService.savePatient(patient);
        return ResponseEntity.ok(null);
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) throws BadRequestException {
        return ResponseEntity.ok(patientService.findPatientById(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PutMapping
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody  @Valid PatientDTO patient) throws BadRequestException {
        return ResponseEntity.ok(patientService.updatePatient(patient));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PatientDTO> deletePatientById(@PathVariable Long id) throws BadRequestException {
        patientService.deletePatientById(id);
        return ResponseEntity.ok(null);
    }

}
