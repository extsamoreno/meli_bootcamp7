package com.example.CalCalculator.project.Repository;

import com.example.CalCalculator.project.Entities.Character;
import com.example.CalCalculator.project.Service.dto.CharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CharacterRepository implements ICharacterRepository {

    @Override
    public List<CharacterDTO> getByName(String name){

        List<CharacterDTO> output = new ArrayList<>();
        List<Character> characters = this.loadDataBase();

        for (int i = 0; i < characters.size(); i++) {
            if(characters.get(i).getName().contains(name)){
                output.add(new CharacterDTO(characters.get(i).getName()));
            }
        }

        return output;

    }


    private List<Character> loadDataBase(){

        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<Character> character = null;
        try{
            character = objectMapper.readValue(file, typeRef);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return character;
    }
}
