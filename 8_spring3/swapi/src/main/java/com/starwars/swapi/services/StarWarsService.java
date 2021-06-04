package com.starwars.swapi.services;


import com.starwars.swapi.repositories.IStarWarsRepository;
import com.starwars.swapi.services.dtos.CharacterDTO;
import com.starwars.swapi.services.entity.Character;
import com.starwars.swapi.services.mappers.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {

    @Autowired
    public IStarWarsRepository starWarsRepository;

    @Override
    public List<CharacterDTO> getCharacters(String name) {
        List<Character> characterList = starWarsRepository.getCharactersByName(name);

        return CharacterMapper.mapListToDTOs(characterList);
    }
}
