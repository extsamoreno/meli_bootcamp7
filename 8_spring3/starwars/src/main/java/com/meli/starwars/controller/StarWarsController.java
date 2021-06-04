package com.meli.starwars.controller;

import com.meli.starwars.dto.MovieCharacterDTO;
import com.meli.starwars.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    IStarWarsService starWarsService;

    @PostMapping("/byname/{name}")
    public ResponseEntity<List<MovieCharacterDTO>> characterByName(@PathVariable String name) {
        return new ResponseEntity<>(starWarsService.getCharactersByName(name), HttpStatus.OK);
    }

}
