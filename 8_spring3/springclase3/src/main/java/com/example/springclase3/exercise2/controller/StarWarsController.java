package com.example.springclase3.exercise2.controller;

import com.example.springclase3.exercise2.repository.CharacterSW;
import com.example.springclase3.exercise2.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    IStarWarsService iStarWarsService;

    @GetMapping("/{word}")
    public ResponseEntity<ArrayList<String>> getCharacterMatching(@PathVariable String word){
        return new ResponseEntity<>(iStarWarsService.getCharacterDTO(word), HttpStatus.OK);
    }

}
