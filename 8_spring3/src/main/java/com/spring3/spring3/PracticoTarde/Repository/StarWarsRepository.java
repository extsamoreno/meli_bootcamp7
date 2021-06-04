package com.spring3.spring3.PracticoTarde.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring3.spring3.PracticoTarde.Classes.SWCharacter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class StarWarsRepository implements IStarWarsRepository {
    @Override
    public List<SWCharacter> findAll() {
        return this.loadDataBase();
    }

    private List<SWCharacter> loadDataBase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<SWCharacter>> typeDef = new TypeReference<>(){};
        List<SWCharacter> swCharacters = null;
        try{
            swCharacters = om.readValue(file,typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return swCharacters;
    }
}
