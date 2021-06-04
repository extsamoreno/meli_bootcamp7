package com.spring8tarde.demo.Model.Mapper;

import com.spring8tarde.demo.Model.CharacterStar;
import com.spring8tarde.demo.Model.DTO.CharacterDTOOUT;

public class CharacterMapper {

    public static CharacterDTOOUT toCharOUT(CharacterStar character){
        CharacterDTOOUT characterDTOOUT = new CharacterDTOOUT(character.getName(), character.getHeight(), character.getMass(),
                character.getHair_color(), character.getSkin_color(), character.getEye_color(), character.getBirth_year(),
                character.getGender(),character.getHomeworld(), character.getSpecies());
        return characterDTOOUT;
    }
}
