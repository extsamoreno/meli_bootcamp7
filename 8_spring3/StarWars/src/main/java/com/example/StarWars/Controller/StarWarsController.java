package com.example.StarWars.Controller;

import com.example.StarWars.Domain.CharacterDTO;
import com.example.StarWars.Services.iStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    iStarWarsService iSTService;

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> getCHbyName(@PathVariable String name){
        return (new ResponseEntity<>(iSTService.findCHbyName(name), HttpStatus.OK));
    }
}
