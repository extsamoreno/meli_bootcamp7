package com.example.CalCalculator.project.Controllers;

import com.example.CalCalculator.project.Service.dto.CharacterDTO;
import com.example.CalCalculator.project.Service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    ICharacterService iCharacterService;

    @GetMapping("/character/{name}")
    public ResponseEntity<List<CharacterDTO>> getByName(@PathVariable String name){

        return new ResponseEntity<>(iCharacterService.getByName(name), HttpStatus.OK);
    }
}
