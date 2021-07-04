package com.bootcamp.appconsultoriomysql.controller;

import com.bootcamp.appconsultoriomysql.dto.ProfessionalDTO;
import com.bootcamp.appconsultoriomysql.dto.TurnDTO;
import com.bootcamp.appconsultoriomysql.service.IProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {

    @Autowired
    private IProfessionalService professionalService;

    @GetMapping("/get-all-with-more-than-two-turns-on-day")
    public ResponseEntity<Set<ProfessionalDTO>> findAllWithMoreThanTwoTurnsOnDay(
            @RequestParam("day") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate day) {

        return new ResponseEntity<>(professionalService.findAllWithMoreThanTwoTurnsOnDay(day.atStartOfDay()),
                HttpStatus.OK);
    }

    @GetMapping("/get-schedule/{id}")
    public ResponseEntity<Set<TurnDTO>> getSchedule(@PathVariable Long id) {
        return new ResponseEntity<>(professionalService.getSchedule(id), HttpStatus.OK);
    }

    @GetMapping("/get-reprogrammed-turns/{id}")
    public ResponseEntity<Set<TurnDTO>> getReprogrammedTurns(@PathVariable Long id) {
        return new ResponseEntity<>(professionalService.getReprogrammedTurns(id), HttpStatus.OK);
    }

}
