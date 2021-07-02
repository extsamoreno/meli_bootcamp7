package com.implementacion.hibernate2.controller;

import com.implementacion.hibernate2.controller.dto.appointments.AppointmentDTO;
import com.implementacion.hibernate2.controller.dto.dentists.DentistAndTurnsListDTO;
import com.implementacion.hibernate2.model.service.appointments.IAppointmentService;
import com.implementacion.hibernate2.model.service.dentists.IDentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<AppointmentDTO>> listDentistsWithNTurnsByDate(@RequestParam(defaultValue = "Finalizado") String status){
        return new ResponseEntity<>(appointmentService.listAllAppointmentsByStatus(status), HttpStatus.OK);
    }

}
