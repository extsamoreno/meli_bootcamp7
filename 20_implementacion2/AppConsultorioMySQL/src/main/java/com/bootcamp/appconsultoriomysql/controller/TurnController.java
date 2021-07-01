package com.bootcamp.appconsultoriomysql.controller;

import com.bootcamp.appconsultoriomysql.model.Turn;
import com.bootcamp.appconsultoriomysql.service.ITurnService;
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
@RequestMapping("/turns")
public class TurnController {

    @Autowired
    private ITurnService turnService;

    @GetMapping("/get-all-finalized")
    public ResponseEntity<Set<Turn>> getAllFinalized() {
        return new ResponseEntity<>(turnService.findAllFinalized(), HttpStatus.OK);
    }

    @GetMapping("/get-all-earring-on-day")
    public ResponseEntity<Set<Turn>> findAllEarringOnDay(
            @RequestParam("day") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate day) {
        return new ResponseEntity<>(turnService.findAllEarringOnDay(day), HttpStatus.OK);
    }
}
