package com.meli.starwars.service;

import com.meli.starwars.repository.Character;

import java.util.List;

public interface ICharacterService {
    public List<Character> getMatchedCharacters(String name);
}
