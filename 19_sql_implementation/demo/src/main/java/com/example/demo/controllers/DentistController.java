package com.example.demo.controllers;

import com.example.demo.model.Dentist;
import com.example.demo.services.IDentistService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dentists")
@AllArgsConstructor
public class DentistController {

    IDentistService iDentistService;

    @PostMapping("/create")
    public String createDentist(@RequestBody Dentist dentist) {
        iDentistService.createDentist(dentist);
        return "Dentist created correctly";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDentist(@PathVariable Long id) {
        iDentistService.deleteDentistById(id);
        return "Dentist deleted correctly";
    }

    @PutMapping("/update")
    public String updateDentist(@RequestBody Dentist dentist) {
        iDentistService.updateDentist(dentist);
        return "Dentist updated correctly";
    }

    @GetMapping("/getAll")
    public List<Dentist> getAllDentist() {
        return iDentistService.findAllDentists();
    }
}