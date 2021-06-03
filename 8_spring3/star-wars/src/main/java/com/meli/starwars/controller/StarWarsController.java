package com.meli.starwars.controller;

import com.meli.starwars.service.IStarWarsService;
import com.meli.starwars.domain.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/star-wars")
public class StarWarsController {
    @Autowired
    IStarWarsService iStarWarsService;

    @GetMapping("/{name}")
    public ResponseEntity<List<Character>> getCharacter(@PathVariable String name){
        return new ResponseEntity<>(iStarWarsService.findCharactersByName(name), HttpStatus.OK);
    }
}
