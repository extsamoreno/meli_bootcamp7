package com.example.AppConsultorioMySQL.controllers;

import com.example.AppConsultorioMySQL.Exceptions.TurnNotFoundException;
import com.example.AppConsultorioMySQL.dtos.TurnDTO;
import com.example.AppConsultorioMySQL.services.ITurnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turn")
@AllArgsConstructor
public class TurnController {
    ITurnService turnService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody TurnDTO turn){
        return new ResponseEntity<String>(turnService.createTurn(turn), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody TurnDTO turn) throws TurnNotFoundException {
        return new ResponseEntity<String>(turnService.updateTurn(turn), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws TurnNotFoundException {
        return new ResponseEntity<String>(turnService.deleteTurn(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TurnDTO>> getAll(){
        return new ResponseEntity<>(turnService.findAllTurns(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<TurnDTO> getById(@PathVariable Long id) throws TurnNotFoundException {
        return new ResponseEntity<>(turnService.findTurnById(id), HttpStatus.OK);
    }

    @GetMapping("/listTurnsStateEnd")
    public ResponseEntity<List<TurnDTO>> listTurnsStateEnd (){
        return new ResponseEntity<>(turnService.listTurnsStateEnd(), HttpStatus.OK);
    }

    @GetMapping("/listTurnsStatePendingByDate/{date}")
    public ResponseEntity<List<TurnDTO>> listTurnsStatePendingByDate (@PathVariable String date){
        LocalDate localDate = LocalDate.parse(date);

        return new ResponseEntity<>(turnService.listTurnsStatePendingByDate(localDate), HttpStatus.OK);
    }
}
