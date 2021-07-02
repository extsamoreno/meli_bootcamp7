package com.meli.consultorio.controllers;

import com.meli.consultorio.models.dtos.AppointmentDTO;
import com.meli.consultorio.models.dtos.DentistDTO;
import com.meli.consultorio.models.dtos.PatientDTO;
import com.meli.consultorio.services.appointment.IAppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    //Listar la agenda de un dentista
    @GetMapping("/getDentistAppointments/{id}")
    public Set<AppointmentDTO> getDentistAppointments(@PathVariable Long id) {
        return iAppointmentService.findAppointmentByDentistId(id);
    }

    @GetMapping("/getPatientAppointments/{id}")
    public Set<AppointmentDTO> getPatientAppointments(@PathVariable Long id) {
        return iAppointmentService.findAppointmentByPatientId(id);
    }

    //Listar todos los pacientes de un día de todos los dentistas.
    @GetMapping("/getDentistPatients")
    public Set<PatientDTO> getDentistPatients(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        return iAppointmentService.findPatientsByDate(date);
    }

    //Listar todos los dentistas que tengan más de dos turnos en una fecha
    @GetMapping("/getDentistByAppointment")
    public Set<DentistDTO> getDentistByAppointment(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        return iAppointmentService.findDentistByAppointments(date);
    }

    //Listar todos los turnos con estado finalizado
    @GetMapping("/getFinalizedAppointments")
    public Set<AppointmentDTO> getFinalizedAppointments() {
        return iAppointmentService.findFinalizedAppointments();
    }

    //Listar todos los turnos con estado pendiente de un día
    @GetMapping("/getPendingAppointments")
    public Set<AppointmentDTO> getPendingAppointments(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        return iAppointmentService.findPendingAppointmentsByDate(date);
    }

    //Listar todos los turnos que fueron reprogramados de un dentista (extra)
    @GetMapping("/getRescheduleAppointmentsByDentist/{id}")
    public Set<AppointmentDTO> getRescheduleAppointmentsByDentist(@PathVariable Long id) {
        return iAppointmentService.findRescheduleAppointmentsByDentistId(id);
    }

    //Listar todos los turnos que fueron reprogramados. (extra)
    @GetMapping("/getRescheduleAppointments")
    public Set<AppointmentDTO> getRescheduleAppointments() {
        return iAppointmentService.findRescheduleAppointments();
    }
}
