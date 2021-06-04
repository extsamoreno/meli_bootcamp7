package com.meli.API_star_wars.controller;

import com.meli.API_star_wars.service.ServiceImpl;
import com.meli.API_star_wars.service.dto.CharacterResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/sw")
public class StarWarsController {
    @Autowired
    private ServiceImpl service;

    @GetMapping("/")
        public ResponseEntity<String> getMain() {
            String message = "Welcome to the API Star Wars";
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }

    @GetMapping("/{name}")
    public ResponseEntity<ArrayList<CharacterResDTO>> getAllCharacterWhit(@PathVariable String name) {
        ArrayList<CharacterResDTO> characterResDTOArrayList = service.returnCharaterResDTO(name);
        if (characterResDTOArrayList.size() > 0) {
            return new ResponseEntity<>(service.returnCharaterResDTO(name), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
