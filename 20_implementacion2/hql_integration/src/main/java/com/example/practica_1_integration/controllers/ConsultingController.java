package com.example.practica_1_integration.controllers;

import com.example.practica_1_integration.dtos.AppointmentDTO;
import com.example.practica_1_integration.dtos.ProfessionalDTO;
import com.example.practica_1_integration.dtos.ProfessionalPatientDTO;
import com.example.practica_1_integration.models.Appointment;
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
    public List<ProfessionalPatientDTO> findPatientForDay(@RequestParam String date) {
        LocalDateTime dt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return iConsultingService.findPatientForDay(dt);
    }

    @GetMapping("/professionalMore2AppForDay")
    public List<ProfessionalDTO> findProfWithMore2AppForDay(@RequestParam String date) {
        LocalDateTime dt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return iConsultingService.findProfessionalWithMoreThan2AppointmentsForDay(dt);
    }

    @GetMapping("/appointment/finished")
    public List<AppointmentDTO> findFinishedAppointments() {
        return iConsultingService.findFinishedAppointments();
    }

    @GetMapping("/appointment/pending")
    public List<AppointmentDTO> findFinishedAppointments(@RequestParam String date) {
        LocalDateTime dt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return iConsultingService.findPendingAppointmentByDate(dt);
    }

    @GetMapping("/appointment/professional/{id}")
    public List<AppointmentDTO> findAppointmentsByProfessional(@PathVariable int id) {
        return iConsultingService.findAppointmentsByProfessional(id);
    }

    @GetMapping("/appointment/delayed/{id}")
    public List<AppointmentDTO> findDelayedAppointmentsByProfessional(@PathVariable int id) {
        return iConsultingService.findDelayedAppointmentsByProfessional(id);
    }

    @GetMapping("/appointment/delayed")
    public List<AppointmentDTO> findDelayedAppointments() {
        return iConsultingService.findDelayedAppointments();
    }
}
