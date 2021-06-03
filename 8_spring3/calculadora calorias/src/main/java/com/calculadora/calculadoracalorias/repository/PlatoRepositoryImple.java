package com.calculadora.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class PlatoRepositoryImple implements PlatoRepository {
    HashMap<String, Integer> ingredientes = new HashMap<>();

    public void obtenerIngredientes(){
        List<IngredienteRepository> ingredientesbd = cargarBaseDeDatos();
        for (int i = 0; i < ingredientesbd.size(); i++) {
            ingredientes.put(ingredientesbd.get(i).getName(),ingredientesbd.get(i).getCalories());
        }
    }

    private List<IngredienteRepository> cargarBaseDeDatos() {
        File baseDeDatos = null;
        try {
            baseDeDatos = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteRepository>> typeReference = new TypeReference<>() {};
        List<IngredienteRepository> ingredientesRepositories = null;
        try{
            ingredientesRepositories = objectMapper.readValue(baseDeDatos, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }

        return ingredientesRepositories;
    }


}


