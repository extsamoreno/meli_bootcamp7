package com.spring8tarde.demo.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring8tarde.demo.Model.CharacterStar;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class CharacterRepository implements ICharacterRepository{

    @Override
    public ArrayList<CharacterStar> getCharacterByName(String name) throws IOException {

        ArrayList<CharacterStar> CharacterData = loadData();
        ArrayList<CharacterStar> listCharacterByName = new ArrayList<>();

        for (CharacterStar character: CharacterData) {
            if(character.getName().contains(name)){
                listCharacterByName.add(character);
            }
        }
        return listCharacterByName;
    }

    static ArrayList<CharacterStar> loadData() throws IOException {
        File file = null;
        try{
            file = ResourceUtils.getFile("src/main/resources/StarData.json");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<CharacterStar> listIngredient = objectMapper.readValue(file, new TypeReference<ArrayList<CharacterStar>>() {});
        return listIngredient;
    }
}
