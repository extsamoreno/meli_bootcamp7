package clase8.spring3.ejercicio2.controller;

import clase8.spring3.ejercicio2.domain.Character;
import clase8.spring3.ejercicio2.service.IStarwarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarwarsController {

    @Autowired
    IStarwarsService iStarwarsService;

    @GetMapping("/{name}")
    public ResponseEntity<List<Character>> getCharacter(@PathVariable String name){
        return new ResponseEntity<>(iStarwarsService.findCharactersByName(name), HttpStatus.OK);
    }
}
