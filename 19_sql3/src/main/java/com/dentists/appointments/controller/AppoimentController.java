package com.dentists.appointments.controller;

import com.dentists.appointments.model.DTO.AppDTOByDate;
import com.dentists.appointments.model.Appointment;
import com.dentists.appointments.service.IAppoimentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class AppoimentController {

    IAppoimentService iAppoimentService;

    @PostMapping("/create")
    public String createAppoiment(@RequestBody Appointment appointment){
        iAppoimentService.save(appointment);
        return "Created "+ appointment.getDate();
    }

    /*
    * Listar todos los pacientes de un día de todos los dentistas.
    * */
    @GetMapping("/FindAllPatientsByDentId/{date}")
    public List<AppDTOByDate> createAppoiment(@PathVariable String date){
        return iAppoimentService.findAllByDate(date);
    }


}
