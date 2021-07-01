package com.example.muelitas.controller;

import com.example.muelitas.dto.AppointmentDTO;
import com.example.muelitas.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<AppointmentDTO>> findAllAppointments() {
        return new ResponseEntity<>(appointmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAppointmentsByDoctor")
    public ResponseEntity<List<AppointmentDTO>> findAllDoctorAppointments(@RequestParam String idDoctor) {
        return new ResponseEntity<>(appointmentService.findAllByDoctor(idDoctor), HttpStatus.OK);
    }

    @GetMapping("/getCancelledAppointments")
    public ResponseEntity<List<AppointmentDTO>> findAllCancelledAppointments() {
        return new ResponseEntity<>(appointmentService.findAllCancelled(), HttpStatus.OK);
    }

    @GetMapping("/getActiveAppointments")
    public ResponseEntity<List<AppointmentDTO>> findAllActiveAppointments() {
        return new ResponseEntity<>(appointmentService.findAllActive(), HttpStatus.OK);
    }
}
