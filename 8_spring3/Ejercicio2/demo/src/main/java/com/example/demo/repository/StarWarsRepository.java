package com.example.demo.repository;

import com.example.demo.DTO.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class StarWarsRepository implements  IStarWarsRepository{

    @Override
    public List<Personaje> consultarPersonajes(String name) {
        List<Personaje> personaje = null;
        personaje = LoadDataBase();
        Personaje result = null;
        List<Personaje> item = new ArrayList<>();
        if (personaje != null) {
            for (Personaje personajeLista:personaje) {
                if(personajeLista.getName().contains(name)){
                    item.add(personajeLista);
                }
            }
        }
        return item;
    }

    private List<Personaje> LoadDataBase() {
        File file = null;
        String fuenteArchivo = "src/main/java/com/example/demo/repository/starwars.json";
        try {
            file = ResourceUtils.getFile(fuenteArchivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS;
    }
}
