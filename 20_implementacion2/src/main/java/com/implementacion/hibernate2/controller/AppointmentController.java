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

    // Ejercicio 3
    // Listar todos los turnos con estado finalizado
    @GetMapping("/list-By-Status")
    public ResponseEntity<List<AppointmentDTO>> listAppointmentsByStatus(@RequestParam(defaultValue = "Finalizado") String status){
        return new ResponseEntity<>(appointmentService.listAllAppointmentsByStatus(status), HttpStatus.OK);
    }

    // Ejercicio 4
    // Listar todos los turnos con estado pendiente de un día
    @GetMapping("/list-By-Status-And-Date")
    public ResponseEntity<List<AppointmentDTO>> listAppointmentsByStatusAndDate(@RequestParam(defaultValue = "Finalizado") String status, @RequestParam(defaultValue = "2021-06-01") String date){
        return new ResponseEntity<>(appointmentService.listAllAppointmentsByStatusAndDate(status, date), HttpStatus.OK);
    }

}
