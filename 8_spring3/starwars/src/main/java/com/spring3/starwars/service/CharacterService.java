package com.spring3.starwars.service;

import com.spring3.starwars.model.Character;
import com.spring3.starwars.service.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    public List<CharacterDTO> getCharacters(String name);
}
