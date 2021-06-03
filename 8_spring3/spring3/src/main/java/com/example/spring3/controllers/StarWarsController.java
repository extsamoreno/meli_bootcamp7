package com.example.spring3.controllers;

import com.example.spring3.dtos.CharacterDTO;
import com.example.spring3.dtos.ResponseCharacterDTO;
import com.example.spring3.services.interfaces.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starWars")
public class StarWarsController {

    @Autowired
    ICharacterService iCharacterService;

    @PostMapping("/character/findByName")
    public ResponseEntity<ResponseCharacterDTO> getAllCharacters(@RequestBody CharacterDTO characterDTO) {
        return new ResponseEntity(iCharacterService.getAllCharactersByName(characterDTO), HttpStatus.OK);
    }
}
