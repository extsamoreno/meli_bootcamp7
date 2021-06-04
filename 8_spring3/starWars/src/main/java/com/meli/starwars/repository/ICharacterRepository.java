package com.meli.starwars.repository;

import com.meli.starwars.domain.Character;

import java.util.List;

public interface ICharacterRepository {
    public List<Character> findCharactersByNameContaining(String name);
    List<Character> getAll();
}
