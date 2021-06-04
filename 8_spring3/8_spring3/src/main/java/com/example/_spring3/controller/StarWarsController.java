package com.example._spring3.controller;

import com.example._spring3.dto.CharacterDTO;
import com.example._spring3.entity.MovieCharacter;
import com.example._spring3.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/StarWars")
public class StarWarsController {

    @Autowired
    IStarWarsService iStarWarsService;

    @GetMapping("/Find/{name}")
    public ResponseEntity<List<MovieCharacter>> findCharacter(@PathVariable String name){
        return new ResponseEntity(iStarWarsService.getCharacterByName(name), HttpStatus.OK);
    }
}
