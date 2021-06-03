package com.meli.starwars.service;

import com.meli.starwars.domain.Character;
import com.meli.starwars.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {

    @Autowired
    ICharacterRepository iCharacterRepository;

    @Override
    public List<Character> findCharactersByName(String name) {
        return iCharacterRepository.getCharacterByName(name);
    }
}
