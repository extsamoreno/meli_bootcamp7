package com.example.app_consultorio.controller;

import com.example.app_consultorio.model.Dentist;
import com.example.app_consultorio.service.IDentistService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DentistController {

    IDentistService iDentistService;

    @PostMapping("/create")
    public String createDentist(@RequestBody Dentist dentist) {
        iDentistService.createDentist(dentist);
        return "Dentist created";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDentist(@PathVariable Long id) {
        iDentistService.deleteDentistById(id);
        return "Dentist deleted";
    }

    @PutMapping("/update")
    public String updateDentist(@RequestBody Dentist dentist) {
        iDentistService.updateDentist(dentist);
        return "Dentist updated";
    }

    @GetMapping("/getAll")
    public List<Dentist> getAllDentist() {
        return iDentistService.findAllDentists();
    }
}
