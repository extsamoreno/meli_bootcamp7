package com.spring3.spring3.PracticoTarde.Controller;

import com.spring3.spring3.PracticoTarde.DTO.CharacterDTO;
import com.spring3.spring3.PracticoTarde.Service.ISWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SW")
public class StarWarsController {
    @Autowired
    ISWService iswService;

    @GetMapping("/getCharacter/{name}")
    public ResponseEntity<List<CharacterDTO>> getCharactersByName(@PathVariable String name) {
        return new ResponseEntity<>(iswService.findByName(name), HttpStatus.OK);
    }
}
