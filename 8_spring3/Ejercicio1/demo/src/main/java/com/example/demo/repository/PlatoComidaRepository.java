package com.example.demo.repository;

import com.example.demo.DTO.IngredienteDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoComidaRepository implements IPlatoComidaRepository{

    @Override
    public IngredienteDTO buscarIngredienteBD(String name) {
        List<IngredienteDTO> ingredienteDTO = null;
        ingredienteDTO = LoadDataBase();
        IngredienteDTO result = null;
        if (ingredienteDTO != null) {
            Optional<IngredienteDTO> item = ingredienteDTO.stream()
                    .filter(ingrediente -> ingrediente.getName().equals(name))
                    .findFirst();
            if (item.isPresent())
                result = item.get();
        }
        return result;
    }

    private List<IngredienteDTO> LoadDataBase() {
        File file = null;
        String fuenteArchivo = "src/main/java/com/example/demo/repository/food.json";
        try {
            file = ResourceUtils.getFile(fuenteArchivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<>() {};
        List<IngredienteDTO> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS;
    }

}
