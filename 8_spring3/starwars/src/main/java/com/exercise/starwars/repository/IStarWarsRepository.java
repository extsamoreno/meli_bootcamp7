package com.exercise.starwars.repository;

import java.util.List;

public interface IStarWarsRepository {

    List<Character> findCharacterByName(String name);
}
