package com.spring3.clase3spring.Controllers;

import com.spring3.clase3spring.Entities.CharacterSW;
import com.spring3.clase3spring.Services.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    IStarWarsService iStarWarsService;

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<CharacterSW>> findByName(@PathVariable() String name){
        return new ResponseEntity<>(iStarWarsService.findByName(name), HttpStatus.OK);
    }
}
