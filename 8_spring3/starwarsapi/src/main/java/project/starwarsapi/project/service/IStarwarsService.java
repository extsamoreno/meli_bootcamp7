package project.starwarsapi.project.service;

import org.springframework.stereotype.Service;
import project.starwarsapi.project.repository.StarwarsCharacter;
import project.starwarsapi.project.service.DTO.StarwarsRequestDTO;
import project.starwarsapi.project.service.DTO.StarwarsResponseDTO;

import java.util.ArrayList;


public interface IStarwarsService {
    public StarwarsResponseDTO getCharacters (StarwarsRequestDTO starwarsRequestDTO);
}
