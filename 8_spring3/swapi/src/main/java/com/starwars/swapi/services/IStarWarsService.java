package com.starwars.swapi.services;

import com.starwars.swapi.services.dtos.CharacterDTO;
import com.starwars.swapi.services.entity.Character;
import java.util.List;

public interface IStarWarsService {
    List<CharacterDTO> getCharacters(String name);
}
