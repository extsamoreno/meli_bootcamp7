package com.meli.Muelitas.controller;

import com.meli.Muelitas.model.DTO.PatientDTO;
import com.meli.Muelitas.model.Patient;
import com.meli.Muelitas.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    IPatientService iPatientService;

    @GetMapping("/appointment-on-date/{date}")
    public List<PatientDTO> getAllPatientsByDate(@PathVariable String date) throws ParseException {
        List<PatientDTO> response = iPatientService.getAllPatientsByDate(date);
        return response;
    }
}
