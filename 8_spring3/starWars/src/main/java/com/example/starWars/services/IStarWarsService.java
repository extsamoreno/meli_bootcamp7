package com.example.starWars.services;

import com.example.starWars.services.dtos.CharacterDTO;

import java.util.List;

public interface IStarWarsService {
    List<CharacterDTO> getCharacters(String name);
}
