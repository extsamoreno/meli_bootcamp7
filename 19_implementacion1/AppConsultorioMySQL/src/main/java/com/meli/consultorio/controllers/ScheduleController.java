package com.meli.consultorio.controllers;

import com.meli.consultorio.models.dtos.ScheduleDTO;
import com.meli.consultorio.services.schedule.IScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("schedules")
@AllArgsConstructor
public class ScheduleController {

    IScheduleService iScheduleService;

    @PostMapping("/create")
    public String createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        iScheduleService.createSchedule(scheduleDTO);
        return "Schedule created correctly";
    }
}
