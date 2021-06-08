package com.example.demo.starwars.service;

import com.example.demo.starwars.repository.CharacterRepository;
import com.example.demo.starwars.service.dto.CharacterDTO;
import org.springframework.stereotype.Service;

@Service
public class CharacterService implements ICharacterService{

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public CharacterDTO getCharacterStarWars(String word) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setListCharacters(characterRepository.getCharacter(word));
        return characterDTO;

    }
}
