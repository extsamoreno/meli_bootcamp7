package com.example.muelitas.controller;

import com.example.muelitas.dto.AppointmentDTO;
import com.example.muelitas.dto.ResponseDTO;
import com.example.muelitas.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
