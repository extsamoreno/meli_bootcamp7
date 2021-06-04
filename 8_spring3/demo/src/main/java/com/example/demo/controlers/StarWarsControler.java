package com.example.demo.controlers;

import com.example.demo.dto.CharactersDTO;
import com.example.demo.service.CharacterService;
import com.example.demo.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/starwars")
public class StarWarsControler {

    @Autowired
    private ICharacterService characterService;

    @GetMapping("/")
    public String status(){
        final String pong = "pong";
        return pong;
    }

    @GetMapping("/characters")
    public ResponseEntity<CharactersDTO> getCharacters(@RequestParam("name") String name) {
        return new ResponseEntity<>(characterService.getCharacters(name), HttpStatus.OK);
    }
}
