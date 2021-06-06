package com.spring3.starwars.controller;

import com.spring3.starwars.model.Character;
import com.spring3.starwars.service.CharacterService;
import com.spring3.starwars.service.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")

public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/character")
    public ResponseEntity<List<CharacterDTO>> getCharacters(@RequestParam String name) {
        List<CharacterDTO> allCharacters = characterService.getCharacters(name);
        return new ResponseEntity<List<CharacterDTO>>(allCharacters, HttpStatus.OK);
    }
}
