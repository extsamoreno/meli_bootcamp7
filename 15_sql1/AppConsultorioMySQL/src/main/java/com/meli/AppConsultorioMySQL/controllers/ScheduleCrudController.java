package com.meli.AppConsultorioMySQL.controllers;

import com.meli.AppConsultorioMySQL.dtos.DentistDto;
import com.meli.AppConsultorioMySQL.dtos.ScheduleDto;
import com.meli.AppConsultorioMySQL.repositories.entities.ScheduleEntity;
import com.meli.AppConsultorioMySQL.services.IScheduleCrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/schedule")
public class ScheduleCrudController {

    private IScheduleCrudService scheduleService;

    @PostMapping("/addone")
    public ResponseEntity<String> addOne(@RequestBody ScheduleEntity schedule){
        return new ResponseEntity<String>(scheduleService.addOne(schedule), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<ScheduleDto> getById(@RequestParam("id") Long id){
        return new ResponseEntity<ScheduleDto>(scheduleService.getById(id), HttpStatus.OK);
    }
}
