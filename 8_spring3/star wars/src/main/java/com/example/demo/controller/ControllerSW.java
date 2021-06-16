package com.example.demo.controller;

import com.example.demo.repository.IStarWarsRepo;
import com.example.demo.service.IService;
import com.example.demo.service.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerSW {

    @Autowired
    IService serviceSW;

    @GetMapping("/characters/{name}")
    public ResponseEntity<?> getChars(@PathVariable String name){
        List<CharacterDTO> characters = serviceSW.getCharacters(name);

        HttpStatus statusCode = characters.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT;

        return new ResponseEntity<>(characters, statusCode);
    }
}
