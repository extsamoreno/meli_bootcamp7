package com.dentists.appointments.controller;

import com.dentists.appointments.model.Appointment;
import com.dentists.appointments.service.IAppoimentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AppoimentController {

    IAppoimentService iAppoimentService;

    @PostMapping("/create")
    public String createAppoiment(@RequestBody Appointment appointment){
        iAppoimentService.save(appointment);
        return "Created "+ appointment.getStartTime();
    }

}
