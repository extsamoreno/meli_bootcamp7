package com.example.mongodbexample.controller;

import com.example.mongodbexample.domain.Turns;
import com.example.mongodbexample.service.TurnsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/dentist")

public class TurnsController {

    private final TurnsService turnsService;

    public TurnsController(TurnsService turnsService) {
        this.turnsService = turnsService;
    }


    @GetMapping(value = "/lists")
    public List<Turns> getAllBooks() {
        return turnsService.findAllTurns();
    }


    @GetMapping("/listsDentistAppon/{name}")
    public List<Turns>  listsStatusPending(@PathVariable String name){
        return turnsService.listsAgenda(name);
    }

    @GetMapping("/listsAgendaBystatus/{status}")
    public List<Turns>  listsAgendaBystatus(@PathVariable String status){
        return turnsService.listsAgendaBystatus(status);
    }

}
