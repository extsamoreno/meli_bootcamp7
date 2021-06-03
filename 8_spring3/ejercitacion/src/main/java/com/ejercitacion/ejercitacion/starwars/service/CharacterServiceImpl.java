package com.ejercitacion.ejercitacion.starwars.service;

import com.ejercitacion.ejercitacion.starwars.dto.StarWarsCharacterDTO;
import com.ejercitacion.ejercitacion.starwars.entity.StarWarsCharacter;
import com.ejercitacion.ejercitacion.starwars.repository.CharacterRepository;
import com.ejercitacion.ejercitacion.starwars.repository.CharacterRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository repository;

    public List<StarWarsCharacterDTO> getCharactersByName(String name) {
        List<StarWarsCharacter> characters =  repository.getCharactersByName(name);
        List<StarWarsCharacterDTO> charactersDTO = new ArrayList<>();
        for (StarWarsCharacter character : characters) {
           charactersDTO.add(CharacterMapper.toDTO(character));
        }
        return charactersDTO;
    }
}
