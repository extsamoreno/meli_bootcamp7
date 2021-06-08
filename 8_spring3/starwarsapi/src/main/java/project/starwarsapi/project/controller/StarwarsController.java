package project.starwarsapi.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.starwarsapi.project.service.DTO.StarwarsRequestDTO;
import project.starwarsapi.project.service.DTO.StarwarsResponseDTO;
import project.starwarsapi.project.service.IStarwarsService;

@RestController
public class StarwarsController {

    @Autowired
    IStarwarsService iStarwarsService;
    @PostMapping("/send")
    public ResponseEntity<StarwarsResponseDTO> getCharacters (@RequestBody StarwarsRequestDTO starwarsRequestDTO)
    {
        return new ResponseEntity<>(iStarwarsService.getCharacters(starwarsRequestDTO), HttpStatus.OK);
    }

}
