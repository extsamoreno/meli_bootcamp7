package com.example.mongodbexample.controller;

import com.example.mongodbexample.domain.Schedule;
import com.example.mongodbexample.dto.ScheduleDoctorDto;
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
    public List<Schedule> getAllSchedules() {
        return  scheduleService.findAllSchedules();
    }

    @GetMapping(value = "/doctor")
    public List<ScheduleDoctorDto> getSchedulesByDoctor(@Nullable @RequestParam String lastName) {
        return  scheduleService.findSchedulesByDoctor(lastName);
    }

    @GetMapping()
    public List<Schedule> getSchedulesByStatus(@Nullable @RequestParam String status) {
        return  scheduleService.getSchedulesByStatus(status);
    }

    @PostMapping
    public Schedule saveSchedule(@RequestBody Schedule schedule){
        return scheduleService.saveSchedule(schedule);
    }
}
