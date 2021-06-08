package com.example.demo.starwars.service;

import com.example.demo.starwars.service.dto.CharacterDTO;
import org.springframework.stereotype.Service;

@Service
public interface ICharacterService {
    CharacterDTO getCharacterStarWars(String word);
}
