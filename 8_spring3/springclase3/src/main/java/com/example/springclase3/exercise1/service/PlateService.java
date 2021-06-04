package com.example.springclase3.exercise1.service;

import com.example.springclase3.exercise1.repository.*;
import com.example.springclase3.exercise1.service.dto.*;
import com.example.springclase3.exercise1.service.mapper.PlateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class PlateService implements IPlateService {
    @Autowired
    IPlateRepository iPlateRepository;
    @Autowired
    IIngredientRepository iIngredientRepository;

    private HashMap<String, Plate> plateDict = new HashMap<>();

    @Override
    public String savePlate(InputPlate inputPlate) {

        ArrayList<Ingredient> plateIngredients= new ArrayList<>();

        for (InputIngredient inputIngredient :
                inputPlate.getPlateIngredients()) {
            Ingredient ingredient =
                    new Ingredient(inputIngredient.getName(), inputIngredient.getWeight(),
                            iIngredientRepository.findIngredientCalories(inputIngredient));
            plateIngredients.add(ingredient);
        }

        this.plateDict.put(inputPlate.getName(),
                new Plate(inputPlate.getName(), plateIngredients, calculatePlateCalories(plateIngredients)));
        return "Plate saved...";
    }

    private Integer calculatePlateCalories(ArrayList<Ingredient> plateIngredients){
        Integer calories = 0;
        for (Ingredient ing :
                plateIngredients) {
            calories += ing.getCalories() * ing.getWeight();
        }
        return calories;
    }

    @Override
    public CaloriesPlateDTO getPlateCalorieDTO(String plateName) {
        return null;
    }

    @Override
    public PlateCalorieIngredientsDTO getPlateIngredientsCalorieDTO(String plateName) {
        return null;
    }
//-----
    @Override
    public IngredientDTO getMostCalorieIngredientDTO(String plateName) {
        return PlateMapper.toDTO(getMostCalorieIngredient(getPlateByName(plateName)));
    }

    private Integer calorieIngrInPlate(Ingredient ingredient){
        return ingredient.getCalories() * ingredient.getWeight();
    }

    @Override
    public Ingredient getMostCalorieIngredient(Plate plate) {

        Ingredient candidate = plate.getIngredients().get(0);
        for (Ingredient ing :
                plate.getIngredients()) {
            if (calorieIngrInPlate(ing) > calorieIngrInPlate(candidate)){
                candidate = ing;
            }
        }

        return candidate;
    }

    @Override
    public Plate getPlateByName(String plateName) {
        return plateDict.get(plateName);
    }
//-------
    @Override
    public ArrayList<Ingredient> getPlateIngredients(InputPlate inputPlate) {
        return null;
    }

    @Override
    public Integer getPlateCalories(Plate plate) {
        return null;
    }


}
