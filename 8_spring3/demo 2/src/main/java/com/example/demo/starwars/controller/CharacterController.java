package com.example.demo.starwars.controller;

import com.example.demo.starwars.service.ICharacterService;
import com.example.demo.starwars.service.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    ICharacterService iCharacterService;
    @GetMapping("/starwars/{word}")
    public ResponseEntity<CharacterDTO> calculateCalories (@PathVariable String word) {
        return new ResponseEntity<CharacterDTO>(iCharacterService.getCharacterStarWars(word), HttpStatus.OK);
    }

}
