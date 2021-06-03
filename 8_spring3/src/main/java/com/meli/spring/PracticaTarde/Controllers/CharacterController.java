package com.meli.spring.PracticaTarde.Controllers;

import com.meli.spring.PracticaTarde.Dto.CharacterDto;
import com.meli.spring.PracticaTarde.Services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/search/starwars/character/contains/{chunkName}")
    public List<CharacterDto> findAll(@PathVariable String chunkName){
        return characterService.findMatches(chunkName);
    }
}
