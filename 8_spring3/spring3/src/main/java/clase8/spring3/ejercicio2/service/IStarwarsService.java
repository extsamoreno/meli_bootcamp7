package clase8.spring3.ejercicio2.service;

import clase8.spring3.ejercicio2.domain.Character;

import java.util.List;

public interface IStarwarsService {
    List<Character> findCharactersByName(String name);
}
