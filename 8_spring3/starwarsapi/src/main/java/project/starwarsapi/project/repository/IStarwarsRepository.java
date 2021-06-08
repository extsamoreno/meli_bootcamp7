package project.starwarsapi.project.repository;

import org.springframework.stereotype.Repository;
import project.starwarsapi.project.service.DTO.StarwarsResponseDTO;

import java.util.ArrayList;


public interface IStarwarsRepository {
    public ArrayList<StarwarsCharacter> getCharactersByName (String name);
}
