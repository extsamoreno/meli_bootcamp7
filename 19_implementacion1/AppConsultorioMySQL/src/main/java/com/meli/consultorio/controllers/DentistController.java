package com.meli.consultorio.controllers;

import com.meli.consultorio.models.Dentist;
import com.meli.consultorio.models.dtos.DentistDTO;
import com.meli.consultorio.services.dentist.IDentistService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dentists")
@AllArgsConstructor
public class DentistController {

    IDentistService iDentistService;

    @PostMapping("/create")
    public String createDentist(@RequestBody DentistDTO dentist) {
        iDentistService.createDentist(dentist);
        return "Dentist created correctly";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDentist(@PathVariable Long id) {
        iDentistService.deleteDentistById(id);
        return "Dentist deleted correctly";
    }

    @PutMapping("/update")
    public String updateDentist(@RequestBody DentistDTO dentist) {
        iDentistService.updateDentist(dentist);
        return "Dentist updated correctly";
    }

    @GetMapping("/getAll")
    public List<DentistDTO> getAllDentist() {
        return iDentistService.findAllDentists();
    }

    @GetMapping("/getDentist/{id}")
    public DentistDTO getDentist(@PathVariable Long id) { return iDentistService.findDentistById(id); }
}
