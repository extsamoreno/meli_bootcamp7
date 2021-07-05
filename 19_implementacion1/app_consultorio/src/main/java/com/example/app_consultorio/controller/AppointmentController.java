package com.example.app_consultorio.controller;

import com.example.app_consultorio.dto.AppointmentDTO;
import com.example.app_consultorio.dto.DentistDTO;
import com.example.app_consultorio.dto.PatientDTO;
import com.example.app_consultorio.model.Appointment;
import com.example.app_consultorio.model.Patient;
import com.example.app_consultorio.service.AppointmentService;
import com.example.app_consultorio.service.IAppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/app")
public class AppointmentController {

    IAppointmentService appointmentService;

    @PostMapping("/create")
    public String createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.createAppointment(appointmentDTO);
        return "Appointment created";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
        return "Appointment deleted";
    }

    @PutMapping("/update")
    public String updateAppointment(@RequestBody Appointment appointment) {
        appointmentService.updateAppointment(appointment);
        return "Appointment updated";
    }

    @GetMapping("/getAll")
    public List<AppointmentDTO> getAllAppointment() {
        return appointmentService.findAllAppointments();
    }

    // 3 - Listar todos los turnos con cierto estado
    @GetMapping("/findAppByStatus/{status}")
    public List<AppointmentDTO> findAppointmentsByStatus(@PathVariable String status) {
        return appointmentService.findAppointmentsByStatus(status);
    }

    // 4 - Listar todos los turnos con estado pendiente de un dia
    @GetMapping("/findAppByDateAndPendiente/{date}")
    public List<AppointmentDTO> findAppointmentsByDateAndPendiente(@PathVariable String date) {
        return appointmentService.findAppointmentsByDateAndPendiente(date);
    }

    // 5 - Listar la agenda de un dentista
    @GetMapping("/findAppByDentistId/{dentistId}")
    public List<AppointmentDTO> findAppointmentsByDentistId(@PathVariable Long dentistId) {
        return appointmentService.findAppointmentsByDentistId(dentistId);
    }
}
