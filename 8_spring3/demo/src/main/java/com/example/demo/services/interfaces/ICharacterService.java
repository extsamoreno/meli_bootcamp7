package com.example.demo.services.interfaces;

import com.example.demo.DTO.CharacterDTO;
import com.example.demo.DTO.ResponseCharacterDTO;

public interface ICharacterService {

    ResponseCharacterDTO getAllCharactersByName(CharacterDTO characterDTO);
}