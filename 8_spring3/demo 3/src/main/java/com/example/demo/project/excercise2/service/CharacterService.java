package com.example.demo.project.excercise2.service;

import com.example.demo.project.excercise2.repository.ICharacterRepository;
import com.example.demo.project.excercise2.repository.entities.CharacterSW;
import com.example.demo.project.excercise2.repository.entities.CharacterSWListDTO;
import com.example.demo.project.excercise2.service.dto.NameOfCharacterListDTO;
import com.example.demo.project.excercise2.service.mapper.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    //Tengo que crear una instancia del repositorio para levantar los nombres de los personajes con la palabra que me pasaron
    @Autowired
    ICharacterRepository iCharacterRepository;

    @Override
    public NameOfCharacterListDTO getCharacterNameByName(String word) {
        return CharacterMapper.toDTO(getCharacterByName(word));
    }

    @Override
    public CharacterSWListDTO getCharacterByName(String word) {
        List<CharacterSW> characterSWList = new ArrayList<CharacterSW>();
        CharacterSWListDTO characterSWListDTO = new CharacterSWListDTO();

        characterSWList = wordMatcher(iCharacterRepository.getCharacterList(), word);

        characterSWListDTO.setCharacterSWList(characterSWList);

        return characterSWListDTO;
    }

    private List<CharacterSW> wordMatcher(List<CharacterSW> loadDatabase, String word) {

        List<CharacterSW> characterSWListAux = new ArrayList<CharacterSW>();
        for(CharacterSW c: loadDatabase){
            if(c.getName().contains(word)){
                characterSWListAux.add(c);
            }
        }

        return characterSWListAux;
    }
}
