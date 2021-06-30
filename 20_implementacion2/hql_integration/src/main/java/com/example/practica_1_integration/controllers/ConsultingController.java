package com.example.practica_1_integration.controllers;

import com.example.practica_1_integration.dtos.ProfessionalDTO;
import com.example.practica_1_integration.dtos.ProfessionalPatientDTO;
import com.example.practica_1_integration.dtos.TestDTO;
import com.example.practica_1_integration.models.Appointment;
import com.example.practica_1_integration.models.Professional;
import com.example.practica_1_integration.services.IConsultingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    @GetMapping("/patientForDay")
    public List<Professional> findPatientForDay(@RequestParam String date) {
        LocalDateTime dt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return iConsultingService.findPatientForDay(dt);
    }

    @GetMapping("/professionalMore2AppForDay")
    public List<ProfessionalDTO> findProfWithMore2AppForDay(@RequestParam String date) {
        LocalDateTime dt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return iConsultingService.findProfessionalWithMoreThan2AppointmentsForDay(dt);
    }
}
