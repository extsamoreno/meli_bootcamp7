package com.meli.starwars.controller;

import com.meli.starwars.domain.Character;
import com.meli.starwars.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/star-wars")
public class StarWarsController {

    @Autowired
    IStarWarsService starWarsService;

    @PostMapping("/by-name/{name}")
    public ResponseEntity<List<Character>> characterByName(@PathVariable String name) {
        return new ResponseEntity<>(starWarsService.getCharactersByName(name), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Character>> getAll() {
        return new ResponseEntity<>(starWarsService.getAll(), HttpStatus.OK);
    }


}