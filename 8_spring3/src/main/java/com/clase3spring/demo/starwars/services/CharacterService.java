package com.clase3spring.demo.starwars.services;

import com.clase3spring.demo.starwars.models.CharacterDTO;
import com.clase3spring.demo.starwars.repositories.ICharacterRepository;
import com.clase3spring.demo.starwars.repositories.mappers.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clase3spring.demo.starwars.repositories.entities.Character;
import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private ICharacterRepository characterRepository;

    @Override
    public ArrayList<CharacterDTO> findByName(String name) {
        List<Character> ch = characterRepository.findByName(name);
        return CharacterMapper.characterToDTO(ch);
    }
}
