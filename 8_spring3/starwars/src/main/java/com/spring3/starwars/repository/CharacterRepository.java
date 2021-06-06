package com.spring3.starwars.repository;

import com.spring3.starwars.model.Character;

import java.util.List;

public interface CharacterRepository {
    List<Character> findCharacterByName (String name);
}
