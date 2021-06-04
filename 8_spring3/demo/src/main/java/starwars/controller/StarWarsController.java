package starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import starwars.entity.MovieCharacter;
import starwars.service.IStarWarsService;
import starwars.service.dto.MovieCharacterDTO;
import starwars.service.mapper.MovieCharacterMapper;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    IStarWarsService iStarWarsService;


    @GetMapping("/find/{name}")
    public ResponseEntity<List<MovieCharacterDTO>> findCharacter(@PathVariable String name){
        return new ResponseEntity(MovieCharacterMapper.toDTOList(iStarWarsService.getCharacterByName(name)), HttpStatus.OK);
    }
}
