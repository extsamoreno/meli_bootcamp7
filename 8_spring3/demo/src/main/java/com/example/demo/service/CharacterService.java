package com.example.demo.service;

import com.example.demo.domains.Character;
import com.example.demo.dto.CharactersDTO;
import com.example.demo.repository.ICharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService implements ICharacterService{

    @Autowired
    ICharactersRepository charactersRepository;

    @Override
    public CharactersDTO getCharacters(String name){

        List<String> list = new ArrayList<>();
        List<Character> characters = charactersRepository.getByName(name);
        System.out.println("characters = " + characters.toString());
        for (Character c : characters){
            list.add(c.getName());
        }

        System.out.println("list = " +list.toString());

        return new CharactersDTO(list);
    }

}
