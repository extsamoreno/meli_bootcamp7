package com.spring3.ejercicios.starwars.controller;

import com.spring3.ejercicios.starwars.service.IStarWarsService;
import com.spring3.ejercicios.starwars.service.dto.NamesCharactersSWDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    IStarWarsService iStarWarsService;

    @GetMapping("/{name}")
    public ResponseEntity<NamesCharactersSWDTO> getCharacterSW(@PathVariable String name){
        return new ResponseEntity(iStarWarsService.mapper(name), HttpStatus.OK);
    }

}
