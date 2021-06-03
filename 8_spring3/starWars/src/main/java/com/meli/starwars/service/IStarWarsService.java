package com.meli.starwars.service;

import com.meli.starwars.domain.Character;

import java.util.List;


public interface IStarWarsService {
    public List<Character> getCharactersByName(String name);
}
