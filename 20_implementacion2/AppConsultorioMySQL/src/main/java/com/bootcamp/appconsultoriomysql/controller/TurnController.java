package com.bootcamp.appconsultoriomysql.controller;

import com.bootcamp.appconsultoriomysql.dto.RegisterTurnDTO;
import com.bootcamp.appconsultoriomysql.dto.TurnDTO;
import com.bootcamp.appconsultoriomysql.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/turns")
public class TurnController {

    @Autowired
    private ITurnService turnService;

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<TurnDTO> getByid(@PathVariable("id") Long id) {
        return new ResponseEntity<>(turnService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/register-turn")
    public ResponseEntity<Void> registerTurn(@RequestBody RegisterTurnDTO turnDTO) {
        turnService.registerTurn(turnDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete-by-id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        turnService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-all-finalized")
    public ResponseEntity<Set<TurnDTO>> getAllFinalized() {
        return new ResponseEntity<>(turnService.findAllFinalized(), HttpStatus.OK);
    }

    @GetMapping("/get-all-earring-on-day")
    public ResponseEntity<Set<TurnDTO>> findAllEarringOnDay(
            @RequestParam("day") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate day) {
        return new ResponseEntity<>(turnService.findAllEarringOnDay(day), HttpStatus.OK);
    }

    @GetMapping("/get-all-reprogrammed")
    public ResponseEntity<Set<TurnDTO>> findAllReprogrammed() {
        return new ResponseEntity<>(turnService.findAllReprogrammed(), HttpStatus.OK);
    }

}
