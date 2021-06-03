package com.example.demo.controller;

import com.example.demo.DTO.Personaje;
import com.example.demo.services.IStarWarsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {

    @Autowired
    IStarWarsServices starWarsServices;

    @GetMapping("/consultarPersonaje/{name}")
    public ResponseEntity<List<Personaje>> consultarPersonajes(@PathVariable String name){

        return new ResponseEntity<>( starWarsServices.consultarPersonajes(name), HttpStatus.OK);
    }


}
