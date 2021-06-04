package com.spring8tarde.demo.Service;

import com.spring8tarde.demo.Model.CharacterStar;
import com.spring8tarde.demo.Model.DTO.CharacterDTOIN;
import com.spring8tarde.demo.Model.DTO.CharacterDTOOUT;
import com.spring8tarde.demo.Model.Mapper.CharacterMapper;
import com.spring8tarde.demo.Repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class CharacterService implements ICharacterService{

    @Autowired
    ICharacterRepository iCharacterRepository;

    @Override
    public ArrayList<CharacterDTOOUT> getCharacter(CharacterDTOIN characterDTOIN) throws IOException {
        return converCharacterToDTO(iCharacterRepository.getCharacterByName(characterDTOIN.getName()));
    }

    static ArrayList<CharacterDTOOUT> converCharacterToDTO(ArrayList<CharacterStar> charactersList){
        ArrayList<CharacterDTOOUT> charterout = new ArrayList<>();
        for (CharacterStar character: charactersList) {
            charterout.add(CharacterMapper.toCharOUT(character));
        }
        return charterout;
    }

}
