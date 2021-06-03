package clase8.spring3.ejercicio2.repository;

import clase8.spring3.ejercicio2.domain.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> getCharacterByName(String name);
}
