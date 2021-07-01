package com.example.demo.controllers;

import com.example.demo.model.Appointment;
import com.example.demo.services.dtos.AppointmentDTO;
import com.example.demo.services.IAppoimentService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appoiment")
@AllArgsConstructor
public class AppoinmentController {


    IAppoimentService appoimentService;

    @GetMapping("/date")
    public ResponseEntity<List<AppointmentDTO>> getAppoimentsByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        return new ResponseEntity<>(appoimentService.getAppoimentsByDate(date), HttpStatus.OK);
    }

    @GetMapping("/finalized")
    public ResponseEntity<List<AppointmentDTO>> getFinalizedAppointment(){
        return new ResponseEntity<>(appoimentService.getFinalizedAppointment(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addApoiment(@RequestBody Appointment appointment){
        return new ResponseEntity<String>(appoimentService.addApoiment(appointment), HttpStatus.OK);
    }

    @GetMapping("/pending/date")
    public ResponseEntity<List<AppointmentDTO>> AppoimentPendingByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        return new ResponseEntity<>(appoimentService.AppoimentPendingByDate(date), HttpStatus.OK);
    }


}
