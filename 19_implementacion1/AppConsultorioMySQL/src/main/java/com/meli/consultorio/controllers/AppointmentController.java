package com.meli.consultorio.controllers;

import com.meli.consultorio.models.dtos.AppointmentDTO;
import com.meli.consultorio.services.appointment.IAppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("appointments")
@AllArgsConstructor
public class AppointmentController {

    IAppointmentService iAppointmentService;

    @PostMapping("/create")
    public String createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        iAppointmentService.createAppointment(appointmentDTO);
        return "Appointment created correctly";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        iAppointmentService.deleteAppointmentById(id);
        return "Appointment deleted correctly";
    }

    @PutMapping("/update")
    public String updateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        iAppointmentService.updateAppointment(appointmentDTO);
        return "Appointment updated correctly";
    }

    @GetMapping("/getAll")
    public Set<AppointmentDTO> getAllAppointments() {
        return iAppointmentService.findAllAppointments();
    }

    @GetMapping("/getAppointment/{id}")
    public AppointmentDTO getAppointment(@PathVariable Long id) {
        return iAppointmentService.findAppointmentById(id);
    }

    @GetMapping("/getDentistAppointments/{id}")
    public Set<AppointmentDTO> getDentistAppointments(@PathVariable Long id) {
        return iAppointmentService.findAppointmentByDentistId(id);
    }

    @GetMapping("/getPatientAppointments/{id}")
    public Set<AppointmentDTO> getPatientAppointments(@PathVariable Long id) {
        return iAppointmentService.findAppointmentByPatientId(id);
    }
}
