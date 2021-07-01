package com.example.demo.controllers;

import com.example.demo.exceptions.AppoimentNotFoundException;
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
    public ResponseEntity<String> addAppointment(@RequestBody Appointment appointment){
        return new ResponseEntity<String>(appoimentService.addApoiment(appointment), HttpStatus.OK);
    }

    @GetMapping("/pending/date")
    public ResponseEntity<List<AppointmentDTO>> appoimentPendingByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        return new ResponseEntity<>(appoimentService.appoimentPendingByDate(date), HttpStatus.OK);
    }


    @PostMapping("/reschedule/{id}")
    public ResponseEntity<String> reprogrametAppointment(@RequestBody Appointment appointment,@PathVariable(name = "id") Long idPastAppointment) throws AppoimentNotFoundException {
        return new ResponseEntity<String>(appoimentService.reprogrametAppointment(appointment,idPastAppointment), HttpStatus.OK);
    }

    @GetMapping("/reschedule/{id}")
    public ResponseEntity<List<AppointmentDTO>> getReprogrametAppointmentByDentist(@PathVariable(name = "id") Long idDenticst)  {
        return new ResponseEntity<>(appoimentService.getReprogrametAppointmentByDoctorId(idDenticst), HttpStatus.OK);
    }

    @GetMapping("/reschedule")
    public ResponseEntity<List<AppointmentDTO>> getReprogrametAppointment()  {
        return new ResponseEntity<>(appoimentService.getReprogrametAppointment(), HttpStatus.OK);
    }
}
