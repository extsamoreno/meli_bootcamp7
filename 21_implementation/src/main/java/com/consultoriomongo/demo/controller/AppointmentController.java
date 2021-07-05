package com.consultoriomongo.demo.controller;

import com.consultoriomongo.demo.model.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AppointmentController {

    IAppointmentService service;

    @GetMapping("get/all/appointment")
    public List<Appointment> getAllAppointment(){
        return service.getAllAppointments();
    }
}
