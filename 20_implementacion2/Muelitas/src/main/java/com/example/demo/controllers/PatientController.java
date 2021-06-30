package com.example.demo.controllers;


import com.example.demo.model.*;
import com.example.demo.services.Interface.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("patient")
@AllArgsConstructor


public class PatientController {

    private IPatientService iPatientService;
    private IAppointmentsService iAppointmentsService;
    private IDentistService iDentistService;

    @PostMapping("/create")
    public String createPatient(@RequestBody Patient patient){
        iPatientService.createPatient(patient);
        return "Se creo el estudiante";
    }



    @PostMapping("/delete")
    public String deletePatient(@RequestBody Patient patient){
        iPatientService.deleteStudent(patient);
        return "Se elimino el pacientre";
    }

    @PostMapping("/update")
    public String updatePatient(@RequestBody Patient patient){
        iPatientService.updateStudent(patient);
        return "Se actualizo el pacientre";
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Patient>> listPatient(@PathVariable Integer id){
        return new ResponseEntity<>(iPatientService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Patient>> listPatients(){
        System.out.println("Hola");
        return new ResponseEntity<>(iPatientService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/createapponitments")
    public String createappointe( @RequestBody Appointment appointment){
        iAppointmentsService.createAppointment(appointment);
        return "Se creo el appointment";
    }

    @PostMapping("/createdentist")
    public String createdentist( @RequestBody Dentist dentist){
        iDentistService.createDentist(dentist);
        return "Se creo el dentist";
    }


    @GetMapping("/listsAppointment")
    public ResponseEntity<List<Appointment>> listAppointments(){
        return new ResponseEntity<>(iAppointmentsService.listAppointment(), HttpStatus.OK);
    }

    @GetMapping("/listsDentistAppointment")
    public ResponseEntity<List<Map<String, Object>>> listsDentistAppointment(){
        return new ResponseEntity<>(iAppointmentsService.listDentistAppointments(), HttpStatus.OK);
    }

    @GetMapping("/listsStatusFinish")
    public ResponseEntity<List<Map<String, Object>>> listsStatusFinish(){
        return new ResponseEntity<>(iAppointmentsService.listsStatusFinish(), HttpStatus.OK);
    }

    @GetMapping("/listsStatusPending/{fecha}")
    public ResponseEntity<List<Map<String, Object>>> listsStatusPending(@PathVariable Date fecha){
        return new ResponseEntity<>(iAppointmentsService.listsStatusPending(fecha), HttpStatus.OK);
    }

    @GetMapping("/listsDentistAppon/{id}")
    public ResponseEntity<List<Map<String, Object>>> listsStatusPending(@PathVariable Integer id){
        return new ResponseEntity<>(iAppointmentsService.listsAgenda(id), HttpStatus.OK);
    }



    @GetMapping("/listsDentistReShedule/{id}")
    public ResponseEntity<List<Map<String, Object>>> listsDentistReShedule(@PathVariable Integer id){
        return new ResponseEntity<>(iAppointmentsService.listsresheduleDentist(id), HttpStatus.OK);
    }

    @GetMapping("/listsReShedule")
    public ResponseEntity<List<Map<String, Object>>> listsReShedule(){
        return new ResponseEntity<>(iAppointmentsService.listsreshedule(), HttpStatus.OK);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

    }

}
