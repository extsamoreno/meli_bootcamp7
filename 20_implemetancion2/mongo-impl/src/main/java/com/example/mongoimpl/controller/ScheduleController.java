package com.example.mongoimpl.controller;

import com.example.mongoimpl.dto.ScheduleDoctorDTO;
import com.example.mongoimpl.model.Schedule;
import com.example.mongoimpl.service.ScheduleService;
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

    @GetMapping("/all")
    public List<Schedule> getAllSchedules() {
        return scheduleService.findAllSchedules();
    }

    @GetMapping("/doctor")
    public List<ScheduleDoctorDTO> getSchedulesByDoctor(@Nullable @RequestParam String lastName) {
        return scheduleService.findSchedulesByDoctor(lastName);
    }

    @GetMapping()
    public List<Schedule> getSchedulesByStatus(@Nullable @RequestParam String status) {
        return scheduleService.getSchedulesByStatus(status);
    }

    @PostMapping("/save")
    public Schedule saveSchedule(@RequestBody Schedule schedule){
        return scheduleService.saveSchedule(schedule);
    }
}