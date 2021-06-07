package com.example.demo.project.excercise2.service;

import com.example.demo.project.excercise2.repository.entities.CharacterSWListDTO;
import com.example.demo.project.excercise2.service.dto.NameOfCharacterListDTO;

public interface ICharacterService {
    CharacterSWListDTO getCharacterByName(String word);
    NameOfCharacterListDTO getCharacterNameByName(String word);
}
