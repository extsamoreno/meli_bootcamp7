package com.exercise.starwars.controllers;

import com.exercise.starwars.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.starwars.repository.Character;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    IStarWarsService starWarsService;

    @GetMapping("/{name}")
    public ResponseEntity<List<Character>> getCharacter (@PathVariable String name) {
        return new ResponseEntity<>(starWarsService.findCharacters(name), HttpStatus.OK);
    }

}
