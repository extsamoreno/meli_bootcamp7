package com.meli.AppConsultorioMySQL.controllers;

import com.meli.AppConsultorioMySQL.models.DTO.DentistDTO;
import com.meli.AppConsultorioMySQL.models.DTO.PatientDTO;
import com.meli.AppConsultorioMySQL.models.Patient;
import com.meli.AppConsultorioMySQL.service.IDentistService;
import com.meli.AppConsultorioMySQL.service.IPtientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("patient")
@AllArgsConstructor
public class ConsultorController {

    private IPtientService iPtientService;
    private IDentistService iDentistService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Patient patient){
        iPtientService.createPatient(patient);
        return "Se creo el estudiante";
    }

    @GetMapping("/all_patients/{date}")
    public List<PatientDTO> getAllPatientsByDate(@PathVariable String date) throws ParseException {
        List<PatientDTO> response = iPtientService.getAllPatientsByDate(date);
        return response;
    }
    @GetMapping("/all_dentist/{date}")
    public List<DentistDTO> getDentistTwoApoointment(@PathVariable String date) throws ParseException {
        List<DentistDTO> response = iDentistService.getDentistTwoApoointment(date);
        return response;
    }
}
