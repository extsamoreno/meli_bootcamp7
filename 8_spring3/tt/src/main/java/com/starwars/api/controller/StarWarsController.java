package com.starwars.api.controller;

import com.starwars.api.dto.MovieCharacterDTO;
import com.starwars.api.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StarWarsController {

    @Autowired
    private StarWarsService starWarsService;

    @GetMapping("/getMovieCharacter/{name}")
    public ResponseEntity<List<MovieCharacterDTO>> getMovieCharacters(@PathVariable String name){

        return new ResponseEntity<>(starWarsService.getMovieCharacters(name), HttpStatus.OK);
    }
}
