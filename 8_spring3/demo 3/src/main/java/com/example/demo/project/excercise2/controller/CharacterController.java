package com.example.demo.project.excercise2.controller;

import com.example.demo.project.excercise2.repository.entities.CharacterSWListDTO;
import com.example.demo.project.excercise2.service.ICharacterService;
import com.example.demo.project.excercise2.service.dto.NameOfCharacterListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    ICharacterService iCharacterService;


    @GetMapping("/{word}")
    public ResponseEntity<NameOfCharacterListDTO> getMatchName(@PathVariable String word){

        return new ResponseEntity<NameOfCharacterListDTO>(iCharacterService.getCharacterNameByName(word), HttpStatus.OK);

    }
}

