package com.meli.AppConsultorioMySQL.controllers;
import com.meli.AppConsultorioMySQL.models.DTO.Schedule.ScheduleDTO;
import com.meli.AppConsultorioMySQL.models.DTO.Schedule.ScheduleRequestDTO;
import com.meli.AppConsultorioMySQL.models.DTO.Schedule.ScheduleResponseDTO;
import com.meli.AppConsultorioMySQL.service.IScheduleService;
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
    public ResponseEntity<String> addSchedule(@RequestBody ScheduleRequestDTO scheduleRequestDTO) {
        return new ResponseEntity<>(scheduleService.addSchedule(scheduleRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ScheduleResponseDTO> getSchedule(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.retrieveSchedule(id), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateSchedule(@RequestBody ScheduleResponseDTO scheduleResponseDTO) {
        return new ResponseEntity<>(scheduleService.updateSchedule(scheduleResponseDTO), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.deleteSchedule(id), HttpStatus.OK);
    }
}