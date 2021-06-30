package com.meli.consultory.controllers;

import com.meli.consultory.models.Patient;
import com.meli.consultory.models.Professional;
import com.meli.consultory.services.PatientService;
import com.meli.consultory.services.ProfessionalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professional")
public class ProfessionalController {

    private ProfessionalService professionalService;

    @PostMapping("/create")
    public String createProfessional(@RequestBody Professional professional) {
        professionalService.createProfessional(professional);
        return "Se creo nuevo Profesional";
    }

    @GetMapping("/listAllProfessionals")
    public List<Professional> getAllProfessionals() {
        return professionalService.findAll();
    }

    @GetMapping ("{id}")
    public Optional<Professional> getProfessionalById(@PathVariable Long id) {
        return professionalService.findById(id);
    }

    @GetMapping ("/update")
    public String updateProfessional(Professional professional) {
        professionalService.updateProfessional(professional);
        return "Profesional Actualizado";
    }

    @GetMapping ("/delete")
    public String deleteProfessional(Professional professional) {
        professionalService.deleteProfessional(professional);
        return "Profesional Eliminado";
    }
}
