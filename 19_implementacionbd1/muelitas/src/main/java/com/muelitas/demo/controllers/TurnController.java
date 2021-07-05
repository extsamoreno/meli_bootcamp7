package com.muelitas.demo.controllers;

import com.muelitas.demo.dtos.TurnDTO;
import com.muelitas.demo.services.ITurnService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/turns")
@AllArgsConstructor
public class TurnController {

    private ITurnService turnService;

    @PostMapping
    public ResponseEntity<?> addNewTurn(@RequestBody @Valid TurnDTO  turn){
        turnService.addNewTurn(turn);
        return ResponseEntity.ok(null);
    }

    @GetMapping("{id}")
    public ResponseEntity<TurnDTO> getTurnById(Long id){
        return ResponseEntity.ok(turnService.findTurnById(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<TurnDTO>> getAllTurns(){
        return ResponseEntity.ok(turnService.findAllTurns());
    }

    @PutMapping
    public ResponseEntity<TurnDTO> updateTurn(@RequestBody @Valid TurnDTO turn){
        return ResponseEntity.ok(turnService.updateTurn(turn));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTurnById(){
        return ResponseEntity.ok(null);
    }
}
