package com.example.AppConsultorioMySQL.controllers;

import com.example.AppConsultorioMySQL.models.entities.Schedule;
import com.example.AppConsultorioMySQL.services.IScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {
    private IScheduleService scheduleService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Schedule schedule){
        return new ResponseEntity<String>(scheduleService.createSchedule(schedule), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody Schedule schedule){
        return new ResponseEntity<String>(scheduleService.updateSchedule(schedule), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity<String>(scheduleService.deleteSchedule(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Schedule>> getAll(){
        return new ResponseEntity<>(scheduleService.findAllSchedules(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Schedule> getById(@PathVariable Long id){
        return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);
    }
}
