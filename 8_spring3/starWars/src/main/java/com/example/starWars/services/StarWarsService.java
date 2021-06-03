package com.example.starWars.services;

import com.example.starWars.repositories.IStarWarsRepository;
import com.example.starWars.services.dtos.CharacterDTO;
import com.example.starWars.services.entities.CharacterEnt;
import com.example.starWars.services.mappers.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService implements IStarWarsService{

    @Autowired
    public IStarWarsRepository starWarsRepository;

    @Override
    public List<CharacterDTO> getCharacters(String name) {
        List<CharacterEnt> characterList = starWarsRepository.loadDatabase();

        List<CharacterDTO> results = new ArrayList<>();

        for (CharacterEnt character :
                characterList) {

            if (character.getName().contains(name))
                results.add(CharacterMapper.mapToDTO(character));
        }

        return results;
    }
}
