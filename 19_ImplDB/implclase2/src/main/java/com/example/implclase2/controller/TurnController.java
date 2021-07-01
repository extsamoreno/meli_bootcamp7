package com.example.implclase2.controller;

import com.example.implclase2.model.dto.RequestCreateTurnDTO;
import com.example.implclase2.model.entity.Turn;
import com.example.implclase2.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turn")
public class TurnController {

    @Autowired
    ITurnService iTurnService;

    @PostMapping("/create")
    public ResponseEntity<String> newTurnRequest(@RequestBody RequestCreateTurnDTO turn)
    {
        return new ResponseEntity<>(iTurnService.createTurn(turn), HttpStatus.CREATED);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Turn>> listAllTurns()
    {
        return new ResponseEntity<>(iTurnService.getAllTurns(), HttpStatus.OK);
    }

    @GetMapping("/{patName}")
    public ResponseEntity<List<Turn>> listPatientTurns(@PathVariable("patName") String name)
    {
        return new ResponseEntity<>(iTurnService.getPatientTurns(name), HttpStatus.OK);
    }
}
