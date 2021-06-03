package com.spring.exercise.starwars.service;

import com.spring.exercise.starwars.model.CharacterSW;
import com.spring.exercise.starwars.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    ICharacterRepository iCharacterRepository;

    @Override
    public List<CharacterSW> findCharactersByName(String name) {
        return iCharacterRepository.getCharacterByName(name);
    }
}
