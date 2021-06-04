package com.exercise.starwars.service;
import com.exercise.starwars.repository.Character;
import java.util.List;

public interface IStarWarsService {

    List<Character> findCharacters(String name);

}
