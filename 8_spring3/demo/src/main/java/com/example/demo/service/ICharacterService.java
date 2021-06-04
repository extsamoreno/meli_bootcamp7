package com.example.demo.service;

import com.example.demo.dto.CharactersDTO;

public interface ICharacterService {
    public CharactersDTO getCharacters(String name);
}
