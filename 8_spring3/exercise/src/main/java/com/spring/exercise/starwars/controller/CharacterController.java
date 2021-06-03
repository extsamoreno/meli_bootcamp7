package com.spring.exercise.starwars.controller;

import com.spring.exercise.starwars.model.CharacterSW;
import com.spring.exercise.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class CharacterController {

    @Autowired
    ICharacterService iCharacterService;

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterSW>> getCharacter(@PathVariable String name){
        return new ResponseEntity<>(iCharacterService.findCharactersByName(name), HttpStatus.OK);
    }
}
