package com.example.mongodbexample.controller;

import com.example.mongodbexample.domain.Schedule;
import com.example.mongodbexample.service.ScheduleService;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(value = "/all")
    public List<Schedule> getAllSchedules(@Nullable @RequestParam String doctor) {
        return doctor == null ? scheduleService.findAllSchedules() : scheduleService.findSchedulesByDoctor(doctor);
    }

    @PostMapping
    public Schedule saveSchedule(@RequestBody Schedule schedule){
        return scheduleService.saveSchedule(schedule);
    }
}
