package com.spring8tarde.demo.Service;

import com.spring8tarde.demo.Model.DTO.CharacterDTOIN;
import com.spring8tarde.demo.Model.DTO.CharacterDTOOUT;

import java.io.IOException;
import java.util.ArrayList;

public interface ICharacterService {

    ArrayList<CharacterDTOOUT> getCharacter(CharacterDTOIN characterDTOIN) throws IOException;
}
