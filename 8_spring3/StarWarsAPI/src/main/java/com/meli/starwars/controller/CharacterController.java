package com.meli.starwars.controller;

import com.meli.starwars.repository.Character;
import com.meli.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    ICharacterService iCharacterService;

    @GetMapping("/{name}")
    public ResponseEntity<List<Character>> getMatches(@PathVariable String name){
        return new ResponseEntity<>(iCharacterService.getMatchedCharacters(name), HttpStatus.OK);
    }
}
