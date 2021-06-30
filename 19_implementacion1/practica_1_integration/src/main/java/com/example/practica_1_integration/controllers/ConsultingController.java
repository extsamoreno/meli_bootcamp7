package com.example.practica_1_integration.controllers;

import com.example.practica_1_integration.models.Appointment;
import com.example.practica_1_integration.services.IConsultingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulting")
@AllArgsConstructor
public class ConsultingController {

    private final IConsultingService iConsultingService;

    @PostMapping("/create/appointment")
    public String createAppointment(@RequestBody Appointment appointment){
        iConsultingService.createAppointment(appointment);
        return "Se creo la cita";
    }
}
