package com.example.spring3.services;

import com.example.spring3.dtos.CharacterDTO;
import com.example.spring3.classes.Character;
import com.example.spring3.dtos.ResponseCharacterDTO;
import com.example.spring3.repositories.interfaces.ICharacterRepository;
import com.example.spring3.services.interfaces.ICharacterService;
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
