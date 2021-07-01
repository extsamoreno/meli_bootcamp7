package com.bootcamp.appconsultoriomysql.controller;

import com.bootcamp.appconsultoriomysql.model.Professional;
import com.bootcamp.appconsultoriomysql.service.IProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {

    @Autowired
    private IProfessionalService professionalService;

    @GetMapping("/get-all-with-more-than-two-turns-on-day")
    public ResponseEntity<Set<Professional>> findAllWithMoreThanTwoTurnsOnDay(
            @RequestParam("day") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate day) {

        return new ResponseEntity<>(professionalService.findAllWithMoreThanTwoTurnsOnDay(day.atStartOfDay()),
                HttpStatus.OK);
    }

}
