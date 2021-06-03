package com.ejercitacion.ejercitacion.starwars.controller;

import com.ejercitacion.ejercitacion.starwars.dto.StarWarsCharacterDTO;
import com.ejercitacion.ejercitacion.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping("/{name}")
    public ResponseEntity<List<StarWarsCharacterDTO>> getCharactersByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getCharactersByName(name));
    }
}
