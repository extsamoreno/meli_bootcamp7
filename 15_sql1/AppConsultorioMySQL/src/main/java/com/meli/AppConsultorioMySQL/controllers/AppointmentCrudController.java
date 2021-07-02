package com.meli.AppConsultorioMySQL.controllers;

import com.meli.AppConsultorioMySQL.dtos.AppointmentDto;
import com.meli.AppConsultorioMySQL.repositories.entities.AppointmentEntity;
import com.meli.AppConsultorioMySQL.services.IAppointmentCrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/appointment")
public class AppointmentCrudController {

    private IAppointmentCrudService appointmentService;

    @PostMapping("/addone")
    public ResponseEntity<String> addOne(@RequestBody AppointmentEntity appointment){
        return new ResponseEntity<String>(appointmentService.addOne(appointment), HttpStatus.OK);
    }

    @GetMapping("/getbyid")
    public  ResponseEntity<AppointmentDto> getById(@RequestParam("id") Long id){
        return new ResponseEntity<AppointmentDto>(appointmentService.getById(id), HttpStatus.OK);
    }


    @GetMapping("/getbyday")
    public  ResponseEntity<List<AppointmentDto>> getByDay(@RequestParam("day") int day, @RequestParam("month") int month, @RequestParam("year") int year){
        return new ResponseEntity<List<AppointmentDto>>(appointmentService.getByDay(day, month, year), HttpStatus.OK);
    }
}
