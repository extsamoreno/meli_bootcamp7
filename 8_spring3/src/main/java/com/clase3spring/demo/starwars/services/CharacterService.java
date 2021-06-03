package com.clase3spring.demo.starwars.services;

import com.clase3spring.demo.starwars.models.CharacterDTO;
import com.clase3spring.demo.starwars.repositories.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private ICharacterRepository characterRepository;

    @Override
    public ArrayList<CharacterDTO> findByName(String name) {
        return characterRepository.findByName(name);
    }
}
