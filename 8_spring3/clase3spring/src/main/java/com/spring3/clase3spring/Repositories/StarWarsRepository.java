package com.spring3.clase3spring.Repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring3.clase3spring.Entities.CaloriesDTO;
import com.spring3.clase3spring.Entities.CharacterSW;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepository implements IStarWarsRepository{

    @Override
    public List<CharacterSW> findByName(String name) {
        List<CharacterSW> characters = loadDatase();
        List<CharacterSW> result = new ArrayList<>();
        if (characters != null){

            for (CharacterSW c: characters) {
                if(c.getName().contains(name)){
                    result.add(c);
                }

            }

            /*Optional<List<CharacterSW>> item = characters.stream()
                    .filter(x -> x.getName().contains(name)).collect(Collectors.toList());
            if(item.isPresent())
                result.add(item.get());

             */
        }
        return result;
    }

    private List<CharacterSW> loadDatase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterSW>> typeRef = new TypeReference<>() {};
        List<CharacterSW> characterSW = null;

        try {
            characterSW = objectMapper.readValue(file, typeRef);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return characterSW;
    }


}
