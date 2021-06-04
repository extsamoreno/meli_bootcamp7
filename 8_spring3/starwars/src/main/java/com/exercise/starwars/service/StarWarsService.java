package com.exercise.starwars.service;

import com.exercise.starwars.repository.Character;
import com.exercise.starwars.repository.IStarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {

    @Autowired
    IStarWarsRepository starWarsRepository;

    @Override
    public List<Character> findCharacters(String name) {
        return starWarsRepository.findCharacterByName(name);
    }


}
