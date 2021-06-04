package starwars.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import starwars.Service.IStarWarsService;


import java.util.List;

@RestController
public class ControllerStarWars {

    @Autowired
    IStarWarsService starwarsService;

    @GetMapping("/findCharacters/{character}")
    public ResponseEntity<List<String>> findCharacters(@PathVariable String character){
        return new ResponseEntity<List<String>>(starwarsService.findCharacters(character), HttpStatus.OK);
    }


}
