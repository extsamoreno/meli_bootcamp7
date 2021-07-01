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
public class DentistController {

    IAppoimentService iAppoimentService;

    /*
     * Listar dentistas con más de dos appoiments
     * */
    @GetMapping("/FindDentistWithMore2Appoiments/{date}")
    public List<DentistCountDates> findDentistWithMore2Appoiments(@PathVariable String date){
        return iAppoimentService.findDentistsByMore2App(date);
    }

    /*
    * Listar la agenda de un dentista
     * */
    @GetMapping("/FindDentistApp/{name}")
    public DentistAppDTO findAllAppByDentistName(@PathVariable String name){
        return iAppoimentService.findDentistAppByName(name);
    }


}
