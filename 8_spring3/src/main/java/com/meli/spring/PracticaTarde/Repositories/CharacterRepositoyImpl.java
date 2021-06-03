package com.meli.spring.PracticaTarde.Repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.spring.PracticaTarde.Classes.CharacterSW;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CharacterRepositoyImpl implements  CharacterRepository{

    @Override
    public List<CharacterSW> findAll() {
        List<CharacterSW> characterSWList = loadDataBase();

        return characterSWList;
    }

    private List<CharacterSW> loadDataBase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<CharacterSW>> typeDef = new TypeReference<>(){};
        List<CharacterSW> characterSWList = null;
        try{
            characterSWList = om.readValue(file,typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characterSWList;
    }
}
