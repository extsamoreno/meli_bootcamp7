package com.example.demo.controller;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.entity.Dentist;
import com.example.demo.entity.Schedule;
import com.example.demo.service.IDentistService;
import com.example.demo.service.IScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {

    IScheduleService scheduleService;

    @PostMapping("/add")
    public ResponseEntity<String> addSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return new ResponseEntity<>(scheduleService.addSchedule(scheduleDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ScheduleDTO> getSchedule(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.retrieveSchedule(id), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return new ResponseEntity<>(scheduleService.updateSchedule(scheduleDTO), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.deleteSchedule(id), HttpStatus.OK);
    }
}
