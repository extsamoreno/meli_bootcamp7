package com.example.dentaloffice.controller;

import com.example.dentaloffice.model.dto.request.CreateTurnDTO;
import com.example.dentaloffice.model.dto.response.TurnDTO;
import com.example.dentaloffice.service.ITurnService;
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
    public ResponseEntity<String> newTurnRequest(@RequestBody CreateTurnDTO turn)
    {
        return new ResponseEntity<>(iTurnService.createTurn(turn), HttpStatus.CREATED);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<TurnDTO>> listAllTurns()
    {
        return new ResponseEntity<>(iTurnService.getAllTurnsResponse(), HttpStatus.OK);
    }

    @GetMapping("/{patName}")
    public ResponseEntity<List<TurnDTO>> listPatientTurns(@PathVariable("patName") String name)
    {
        return new ResponseEntity<>(iTurnService.getPatientTurns(name), HttpStatus.OK);
    }

    // add update turn, cancel turn, get turn per day or month
}
