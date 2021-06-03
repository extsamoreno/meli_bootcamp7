package com.example.spring3.services.interfaces;

import com.example.spring3.dtos.CharacterDTO;
import com.example.spring3.dtos.ResponseCharacterDTO;

public interface ICharacterService {

    ResponseCharacterDTO getAllCharactersByName(CharacterDTO characterDTO);
}
