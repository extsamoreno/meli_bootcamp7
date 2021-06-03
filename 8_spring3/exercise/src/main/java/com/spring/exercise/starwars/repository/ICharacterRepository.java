package com.spring.exercise.starwars.repository;

import com.spring.exercise.starwars.model.CharacterSW;

import java.util.List;

public interface ICharacterRepository {
    List<CharacterSW> getCharacterByName(String name);
}