package com.example.AppConsultorioMySQL.controllers;

import com.example.AppConsultorioMySQL.Exceptions.ScheduleNotFoundException;
import com.example.AppConsultorioMySQL.dtos.ScheduleDTO;
import com.example.AppConsultorioMySQL.services.IScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {
    IScheduleService scheduleService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ScheduleDTO schedule){
        return new ResponseEntity<String>(scheduleService.createSchedule(schedule), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody ScheduleDTO schedule) throws ScheduleNotFoundException {
        return new ResponseEntity<String>(scheduleService.updateSchedule(schedule), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ScheduleNotFoundException {
        return new ResponseEntity<String>(scheduleService.deleteSchedule(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ScheduleDTO>> getAll(){
        return new ResponseEntity<>(scheduleService.findAllSchedules(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ScheduleDTO> getById(@PathVariable Long id) throws ScheduleNotFoundException {
        return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);
    }

    @GetMapping("/listScheduleByDentist/{date}/{dentist_id}")
    public ResponseEntity<List<ScheduleDTO>> listScheduleByDentist (@PathVariable String date, @PathVariable Long dentist_id){
        LocalDate localDate = LocalDate.parse(date);

        return new ResponseEntity<>(scheduleService.listScheduleByDentist(localDate,dentist_id), HttpStatus.OK);
    }
}
