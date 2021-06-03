package com.starWars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {

    @Autowired
    iStarWarsService iStarWarsService;

    @GetMapping("/starWars/{word}")
    public ResponseEntity<List<CharacterDTO>> getCharactersByName (@PathVariable String word){
        return (new ResponseEntity<>(iStarWarsService.getCharactersByName(word), HttpStatus.OK));
    }
}
