package com.example.muelitas.controller;

import com.example.muelitas.dto.AppointmentDTO;
import com.example.muelitas.dto.PatientDTO;
import com.example.muelitas.dto.ProfessionalDTO;
import com.example.muelitas.dto.ResponseDTO;
import com.example.muelitas.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAppointment(@RequestBody AppointmentDTO newAppointment) {
        return new ResponseEntity<>(appointmentService.createAppointment(newAppointment), HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<AppointmentDTO> readAppointment(@RequestParam Long idAppointment) {
        return new ResponseEntity<>(appointmentService.readAppointment(idAppointment), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAppointment(@RequestBody AppointmentDTO updatedAppointment) {
        return new ResponseEntity<>(appointmentService.updateAppointment(updatedAppointment), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAppointment(@RequestParam Long idAppointment) {
        return new ResponseEntity<>(appointmentService.deleteAppointment(idAppointment), HttpStatus.OK);
    }

    @GetMapping("/findAllDatePatients")
    public ResponseEntity<List<PatientDTO>> findAllPatientsByDate(@RequestParam String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return new ResponseEntity<>(appointmentService.findAllPatientsByDate(localDateTime), HttpStatus.OK);
    }

    @GetMapping("/findAllProfessionalsWithMoreThanTwoAppointments")
    public ResponseEntity<List<ProfessionalDTO>> findAllProfessionalsWithMoreThanTwoAppointmentsByDate(@RequestParam String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return new ResponseEntity<>(appointmentService.findAllProfessionalsWithMoreThanTwoAppointmentsByDate(localDateTime), HttpStatus.OK);
    }

    @GetMapping("/findAllAppointmentsWithStateFinalizado")
    public ResponseEntity<List<AppointmentDTO>> findAllAppointmentsWithStateFinalizado() {
        return new ResponseEntity<>(appointmentService.findAllAppointmentsWithStateFinalizado(), HttpStatus.OK);
    }

    @GetMapping("/findAllAppointmentsWithStatePendienteOfOneDay")
    public ResponseEntity<List<AppointmentDTO>> findAllAppointmentsWithStatePendienteOfOneDay() {
        return new ResponseEntity<>(appointmentService.findAllAppointmentsWithStatePendienteAndADay(), HttpStatus.OK);
    }

    @GetMapping("/findAllProfessionalAppointments")
    public ResponseEntity<List<AppointmentDTO>> findAllProfessionalAppointments(@RequestParam Long idProfessional) {
        return new ResponseEntity<>(appointmentService.findAllProfessionalAppointments(idProfessional), HttpStatus.OK);
    }

    @GetMapping("/findAllProfessionalAppointmentsWithStateReprogramado")
    public ResponseEntity<List<AppointmentDTO>> findAllProfessionalAppointmentsWithStateReprogramado(@RequestParam Long idProfessional) {
        return new ResponseEntity<>(appointmentService.findAllProfessionalAppointmentsWithStateReprogramado(idProfessional), HttpStatus.OK);
    }

    @GetMapping("/findAllAppointmentsWithStateReprogramado")
    public ResponseEntity<List<AppointmentDTO>> findAllAppointmentsWithStateReprogramado() {
        return new ResponseEntity<>(appointmentService.findAllAppointmentsWithStateReprogramado(), HttpStatus.OK);
    }
}
