package com.meli.consultorio.controllers;

import com.meli.consultorio.models.dtos.ScheduleDTO;
import com.meli.consultorio.services.schedule.IScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @DeleteMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        iScheduleService.deleteScheduleById(id);
        return "Schedule deleted correctly";
    }

    @PutMapping("/update")
    public String updateSchedule(@RequestBody ScheduleDTO schedule) {
        iScheduleService.updateSchedule(schedule);
        return "Schedule updated correctly";
    }

    @GetMapping("/getAll")
    public Set<ScheduleDTO> getAllSchedules() {
        return iScheduleService.findAllSchedules();
    }

    @GetMapping("/getSchedule/{id}")
    public ScheduleDTO getScheudle(@PathVariable Long id) {
        return iScheduleService.findScheduleById(id);
    }

    @GetMapping("/getDentistSchedules/{id}")
    public Set<ScheduleDTO> getDentistSchedules(@PathVariable Long id) {
        return iScheduleService.findDentistScheduleByDentistId(id);
    }
}
