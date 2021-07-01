package com.dentists.appointments.controller;

import com.dentists.appointments.model.DTO.*;
import com.dentists.appointments.model.Appointment;
import com.dentists.appointments.model.Status;
import com.dentists.appointments.service.IAppoimentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AppoimentController {

    IAppoimentService iAppoimentService;

    @PostMapping("/create")
    public String createAppoiment(@RequestBody Appointment appointment){
        iAppoimentService.save(appointment);
        return "Created "+ appointment.getDate();
    }

    /*
    * Listar todos los pacientes de un día de todos los dentistas.
    * */
    @GetMapping("/FindAllPatientsByDentId/{date}")
    public List<AppDTOByDate> createAppoiment(@PathVariable String date){
        return iAppoimentService.findAllByDate(date);
    }

    /*
     * Listar dentistas con más de dos appoiments
     * */
    @GetMapping("/FindDentistWithMore2Appoiments/{date}")
    public List<DentistCountDates> findDentistWithMore2Appoiments(@PathVariable String date){
        return iAppoimentService.findDentistsByMore2App(date);
    }

    @PostMapping("/reprogramarCita")
    public void reprogramarCita(@RequestBody AppReproRequests app){
        iAppoimentService.reprogramar(app);
    }


    @PostMapping("/findAllApp/")
    public List<Appointment> findAllApp(){
        return iAppoimentService.findAll();
    }

    @PostMapping("/editStatusAppoiment/")
    public void editStatusApp(@RequestBody AppEditStatusDateRequest app){
        iAppoimentService.editApp(app);
    }

    /*
    * Listar todos los turnos con estado finalizado
     * */
    @GetMapping("/all/app/statusend")
    public List<AppointmentDTO> findyAllStatusEnd(){
        return iAppoimentService.findAllStatus(Status.END);
    }

    /*
    * Listar todos los turnos con estado pendiente de un día
     * */


}
