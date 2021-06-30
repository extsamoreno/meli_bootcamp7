package com.example.AppConsultorioMySQL.controllers;

import com.example.AppConsultorioMySQL.models.entities.Turn;
import com.example.AppConsultorioMySQL.services.IScheduleService;
import com.example.AppConsultorioMySQL.services.ITurnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turn")
@AllArgsConstructor
public class TurnController {
    private ITurnService turnService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Turn turn){
        return new ResponseEntity<String>(turnService.createTurn(turn), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody Turn turn){
        return new ResponseEntity<String>(turnService.updateTurn(turn), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity<String>(turnService.deleteTurn(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Turn>> getAll(){
        return new ResponseEntity<>(turnService.findAllTurns(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Turn> getById(@PathVariable Long id){
        return new ResponseEntity<>(turnService.findTurnById(id), HttpStatus.OK);
    }
}
