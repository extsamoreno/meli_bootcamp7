package com.spring3.starwars.service;

import com.spring3.starwars.model.Character;
import com.spring3.starwars.repository.CharacterRepository;
import com.spring3.starwars.service.dto.CharacterDTO;
import com.spring3.starwars.service.mapper.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> getCharacters(String name) {
        List<Character> charactersFound = characterRepository.findCharacterByName(name);
        List<CharacterDTO> charactersFoundDto = charactersFound.stream()
                .map(CharacterMapper::toDto).collect(Collectors.toList());
                //.map(character -> CharacterMapper.toDto(character)).collect(Collectors.toList());
        return charactersFoundDto;
    }
}
