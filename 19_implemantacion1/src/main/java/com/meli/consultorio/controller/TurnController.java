package com.meli.consultorio.controller;

import com.meli.consultorio.dto.response.TurnResponse;
import com.meli.consultorio.model.Turn;
import com.meli.consultorio.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/muelitas/turn")
public class TurnController {
    @Autowired
    ITurnService iTurnService;
    @GetMapping("/{id}")
    public ResponseEntity<TurnResponse> getSchedule(@PathVariable("id") Integer id){
        return new ResponseEntity<>(iTurnService.getTurn(id), HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<?> saveSchedule(@RequestBody Turn turn){
        iTurnService.saveTurn(turn);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
