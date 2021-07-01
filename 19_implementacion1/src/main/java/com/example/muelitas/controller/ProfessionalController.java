package com.example.muelitas.controller;

import com.example.muelitas.dto.ProfessionalDTO;
import com.example.muelitas.dto.ResponseDTO;
import com.example.muelitas.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professional")
public class ProfessionalController {

    @Autowired
    ProfessionalService professionalService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createProfessional(@RequestBody ProfessionalDTO newProfessional) {
        return new ResponseEntity<>(professionalService.createProfessional(newProfessional), HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<ProfessionalDTO> readPatient(@RequestParam Long idProfessional) {
        return new ResponseEntity<>(professionalService.readProfessional(idProfessional), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updatePatient(@RequestBody ProfessionalDTO updatedProfessional) {
        return new ResponseEntity<>(professionalService.updateProfessional(updatedProfessional), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteProfessional(@RequestParam Long idProfessional) {
        return new ResponseEntity<>(professionalService.deleteProfessional(idProfessional), HttpStatus.OK);
    }
}
