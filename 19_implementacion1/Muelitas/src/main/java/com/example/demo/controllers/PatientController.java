package com.example.demo.controllers;


import com.example.demo.model.*;
import com.example.demo.repositories.IConsultoryRepository;
import com.example.demo.services.Interface.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("patient")
@AllArgsConstructor


public class PatientController {

    private IPatientService iPatientService;
    private IAppointmentsService iAppointmentsService;
    private IBossesService iBossesService;
    private IConsultoryService iConsultoryService;
    private IDentistService iDentistService;
    private ISheduleService iSheduleService;
    private IDentistandBossService iDentistandBossService;

    @PostMapping("/create")
    public String createPatient(@RequestBody Patient patient){
        iPatientService.createPatient(patient);
        return "Se creo el estudiante";
    }

    @GetMapping("/createdent_boss/{id_dentis}/{id_boss}")
    public String createPatient(@PathVariable Integer id_dentis,@PathVariable Integer id_boss){
        iDentistandBossService.createDentistandBoss(id_dentis,id_boss);
        return "Se creo la relación";
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


    @PostMapping("/createshedules")
    public String createshedule( @RequestBody Shedule shedule){
        iSheduleService.createShedule(shedule);
        return "Se creo el shedule";
    }


    @PostMapping("/createconsultory")
    public String createconsultory( @RequestBody Consultory consultory){
        iConsultoryService.createConsultory(consultory);
        return "Se creo el consultory";
    }

    @PostMapping("/createbosses")
    public String createboss( @RequestBody Boss boos){
        iBossesService.createBoss(boos);
        return "Se creo el boos";
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
}
