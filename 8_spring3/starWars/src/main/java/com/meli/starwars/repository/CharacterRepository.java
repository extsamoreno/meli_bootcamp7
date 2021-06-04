package com.meli.starwars.repository;

import com.meli.starwars.domain.Character;
import com.meli.starwars.service.GenericLoader;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository {

    @Override
    public List<Character> findCharactersByNameContaining(String name) {

        List<Character> characters = null;
        characters = loadDatabase();

        List<Character> filteredChar = null;
        if (characters != null) {
            filteredChar = characters
                    .stream()
                    .filter(c -> nameContaining(c, name))
                    .collect(Collectors.toList());

        }
        return filteredChar;
    }

    @Override
    public List<Character> getAll() {
        return loadDatabase();
    }

    private boolean nameContaining(Character c, String name) {
        return c.getName()
                .toLowerCase()
                .contains(name.toLowerCase());
    }


    private List<Character> loadDatabase() {
        return new GenericLoader<List<Character>>().loadData("classpath:starwars.json");
    }


}
