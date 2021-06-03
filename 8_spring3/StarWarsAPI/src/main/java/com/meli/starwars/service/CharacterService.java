package com.meli.starwars.service;

import com.meli.starwars.repository.Character;
import com.meli.starwars.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService implements ICharacterService{

    @Autowired
    ICharacterRepository iCharacterRepository;

    @Override
    public List<Character> getMatchedCharacters(String name) {
        List<Character> finalList= new ArrayList<>();
        List<Character> list= iCharacterRepository.getCharacters();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().contains(name)) finalList.add(list.get(i));
        }

        return finalList;
    }
}
