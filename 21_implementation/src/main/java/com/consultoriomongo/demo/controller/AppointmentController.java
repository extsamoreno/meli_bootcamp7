package com.consultoriomongo.demo.controller;

import com.consultoriomongo.demo.model.Appointment;
import com.consultoriomongo.demo.service.IAppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("get/appointment/{name}")
    public List<Appointment> getAllAppointmentByDoctor(@PathVariable String name){
        return service.getAllAppointmentsByDoctor(name);
    }

    @GetMapping("get/status/{status}")
    public List<Appointment> getAppointmentByStatus(@PathVariable String status){
        return service.getAppointmentByStatus(status);
    }

}
