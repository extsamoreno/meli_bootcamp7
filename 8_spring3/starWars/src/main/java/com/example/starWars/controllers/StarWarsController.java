package com.example.starWars.controllers;

import com.example.starWars.services.IStarWarsService;
import com.example.starWars.services.dtos.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/swapi")
public class StarWarsController {

    @Autowired
    private IStarWarsService starWarsService;

    @GetMapping("/character/{name}")
    public ResponseEntity<List<CharacterDTO>> getCharacters(@PathVariable String name) {
        List<CharacterDTO> characters = starWarsService.getCharacters(name);

        HttpStatus statusCode = characters.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT;

        return new ResponseEntity<>(characters, statusCode);
    }
}
