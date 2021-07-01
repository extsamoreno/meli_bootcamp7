package com.meli.consultorio.controller;

import com.meli.consultorio.dto.response.ProfessionalResponse;
import com.meli.consultorio.model.Professional;
import com.meli.consultorio.service.IPatientService;
import com.meli.consultorio.service.IProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/muelitas/professional")
public class ProfessionalController {
    @Autowired
    IProfessionalService iProfessionalService;

    @PostMapping("/crear")
    public ResponseEntity<?> saveProfessional(@RequestBody Professional professional){
        iProfessionalService.saveProfessional(professional);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalResponse> getProfessional(@PathVariable("id") Integer id){

        return new ResponseEntity<>(iProfessionalService.getProfessional(id),HttpStatus.OK);
    }
}
