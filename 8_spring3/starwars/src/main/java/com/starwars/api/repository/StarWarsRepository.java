package com.starwars.api.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.api.dto.CaracterResponseDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class StarWarsRepository {
    public List<CaracterResponseDTO> loadData(){

        File dataBase = null;
        try {
            dataBase = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CaracterResponseDTO>> typeReference = new TypeReference<>() {};
        List<CaracterResponseDTO> starWarsCaracters = null;
        try{
            starWarsCaracters = objectMapper.readValue(dataBase, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }
        return starWarsCaracters;
    }
}
