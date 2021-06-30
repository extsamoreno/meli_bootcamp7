package com.meli.consultory.controllers;

import com.meli.consultory.models.Turn;
import com.meli.consultory.services.TurnService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turn")
public class TurnController {

    private TurnService turnService;

    @PostMapping("/create")
    public String createTurn(@RequestBody Turn turn) {
        turnService.createTurn(turn);
        return "Se creo nuevo Turno";
    }

    @GetMapping("/listAllTurns")
    public List<Turn> getAllTurns() {
        return turnService.findAll();
    }

    @GetMapping ("{id}")
    public Optional<Turn> getTurnById(@PathVariable Long id) {
        return turnService.findById(id);
    }

    @GetMapping ("/update")
    public String updateTurn(Turn turn) {
        turnService.updateTurn(turn);
        return "Turno Actualizado";
    }

    @GetMapping ("/delete")
    public String deleteTurn(Turn turn) {
        turnService.deleteTurn(turn);
        return "Turno Eliminado";
    }
}
