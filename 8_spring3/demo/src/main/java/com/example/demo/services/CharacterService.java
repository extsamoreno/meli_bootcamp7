package com.example.demo.services;

import com.example.demo.DTO.CharacterDTO;
import com.example.demo.classes.Character;
import com.example.demo.DTO.ResponseCharacterDTO;
import com.example.demo.repositories.interfaces.ICharacterRepository;
import com.example.demo.services.interfaces.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    ICharacterRepository iCharacterRepository;

    @Override
    public ResponseCharacterDTO getAllCharactersByName(CharacterDTO characterDTO) {
        ResponseCharacterDTO responseCharacterDTO = new ResponseCharacterDTO();
        List<Character> characterList = iCharacterRepository.findCharacterByPortionName(characterDTO.getName());
        if(characterList != null) {
            for(Character c : characterList) {
                responseCharacterDTO.getListOfCharacters().add(c.getName());
            }
        }
        return responseCharacterDTO;
    }
}