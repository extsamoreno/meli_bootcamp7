package com.spring3.demo.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring3.demo.Objects.DTO.IngredientDTO;
import com.spring3.demo.Objects.Ingredient;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


@org.springframework.stereotype.Repository
public class Repository implements IRepository {

    static ArrayList<Ingredient> foodData;

    static {
        try {
            foodData = loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ingredient getIngredientByName(String name) throws IOException {
        Ingredient ingredient = null;
        if (foodData != null) {
            Optional<Ingredient> item =
                    foodData.stream().filter(
                            ingredient1 -> ingredient1.getName().equals(name)).findFirst();

            if (item.isPresent())
                ingredient = item.get();
        }
        return ingredient;
    }

    /* Example:
        String jsonCarArray = "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});
    */

    static ArrayList<Ingredient> loadData() throws IOException {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/food.json");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Ingredient> listIngredient = objectMapper.readValue(file, new TypeReference<ArrayList<Ingredient>>() {
        });
        return listIngredient;
    }


}
