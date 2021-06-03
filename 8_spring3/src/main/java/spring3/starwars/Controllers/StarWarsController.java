package spring3.starwars.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring3.starwars.Models.Entities.SWCharacter;
import spring3.starwars.Services.Interfaces.ISWCharacterService;

import java.util.List;

@RestController
@RequestMapping("")
public class StarWarsController {
    ISWCharacterService iSWCharacterService;

    public StarWarsController(ISWCharacterService iSWCharacterService) {
        this.iSWCharacterService = iSWCharacterService;
    }

    @GetMapping("/getCharacterByName/{name}")
    public ResponseEntity<List<SWCharacter>> getCharacterByName(@PathVariable String name){
        return new ResponseEntity<>(iSWCharacterService.findCharByName(name), HttpStatus.OK);
    }
}
