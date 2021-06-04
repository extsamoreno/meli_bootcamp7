package com.clase3spring.demo.starwars.repositories.mappers;

import com.clase3spring.demo.starwars.models.CharacterDTO;
import com.clase3spring.demo.starwars.repositories.entities.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterMapper {

    public static ArrayList<CharacterDTO> characterToDTO(List<Character> chList){
        ArrayList<CharacterDTO> charactersDTO = new ArrayList<CharacterDTO>();
        for (Character ch: chList) {
            CharacterDTO chDTo = new CharacterDTO();
            chDTo.setName(ch.getName());
            chDTo.setBirthYear(ch.getBirth_year());
            chDTo.setEyeColor(ch.getEye_color());
            chDTo.setGender(ch.getGender());
            chDTo.setHeight(ch.getHeight());
            chDTo.setHomeworld(ch.getHomeworld());
            chDTo.setMass(ch.getMass());
            chDTo.setHairColor(ch.getHair_color());
            chDTo.setSpecies(ch.getSpecies());
            chDTo.setSkinColor(ch.getSkin_color());
            charactersDTO.add(chDTo);
        }

        return charactersDTO;
    }
}
