package com.meli.Muelitas.controller;

import com.meli.Muelitas.model.DTO.ProfessionalAppointmentsDTO;
import com.meli.Muelitas.model.DTO.ProfessionalDTO;
import com.meli.Muelitas.service.IProfessionalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/professionals")
@AllArgsConstructor
public class ProfessionalController {

    IProfessionalService iProfessionalService;

    @GetMapping("/three-appointments-on-date/{date}")
    public List<ProfessionalDTO> getDentistTwoApoointment(@PathVariable String date) throws ParseException {
        List<ProfessionalDTO> response = iProfessionalService.getProfessionalTwoApoointment(date);
        return response;
    }

    @GetMapping("/schedule/{idDentist}")
    public List<ProfessionalAppointmentsDTO> getScheduleByDentist(@PathVariable Long idDentist) throws ParseException {
        List<ProfessionalAppointmentsDTO> response = iProfessionalService.getScheduleByDentist(idDentist);
        return response;
    }

}
