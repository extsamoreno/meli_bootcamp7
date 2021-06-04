package com.meli.starwars.service;

import com.meli.starwars.domain.Character;
import com.meli.starwars.service.mapper.CharacterDTO;

import java.util.List;


public interface IStarWarsService {
    public List<CharacterDTO> getCharactersByName(String name);
}
