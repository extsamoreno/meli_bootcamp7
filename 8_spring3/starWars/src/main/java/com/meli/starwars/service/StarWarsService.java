package com.meli.starwars.service;

import com.meli.starwars.domain.Character;
import com.meli.starwars.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {

    @Autowired
    ICharacterRepository characterRepository;


    @Override
    public List<Character> getCharactersByName(String name) {
        return characterRepository.findCharactersByNameContaining(name);
    }

}
