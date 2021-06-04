package com.clase3spring.demo.starwars.controllers;

import com.clase3spring.demo.starwars.models.CharacterDTO;
import com.clase3spring.demo.starwars.services.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    private ICharacterService characterService;

    @GetMapping
    public ResponseEntity<ArrayList<CharacterDTO>> getByName(@RequestParam String name){
        return new ResponseEntity<ArrayList<CharacterDTO>>(characterService.findByName(name), HttpStatus.OK);
    }
}
