package com.spring.exercise.starwars.service;

import com.spring.exercise.starwars.model.CharacterSW;

import java.util.List;

public interface ICharacterService {
    List<CharacterSW> findCharactersByName(String name);
}
