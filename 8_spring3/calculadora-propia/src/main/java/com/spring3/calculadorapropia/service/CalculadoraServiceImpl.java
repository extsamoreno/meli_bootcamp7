package com.spring3.calculadorapropia.service;

import com.spring3.calculadorapropia.repository.CalculadoraRepository;
import com.spring3.calculadorapropia.service.dtos.FoodRequestDTO;
import com.spring3.calculadorapropia.service.dtos.IngredientRequestDTO;
import com.spring3.calculadorapropia.service.dtos.FoodResponseDTO;
import com.spring3.calculadorapropia.service.dtos.IngredientResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

    @Autowired
    private CalculadoraRepository calculadoraRepository;

    @Override
    public FoodResponseDTO getCalories(FoodRequestDTO foodRequestDTO) {
        int suma = 0;
        ArrayList<IngredientRequestDTO> ingredientsPerFood = foodRequestDTO.getIngredients();
        for (int i = 0; i < ingredientsPerFood.size(); i++) {
            int calories = calculadoraRepository.findIngredientByName(ingredientsPerFood.get(i).getName()).getCalories();
            suma += calories * ingredientsPerFood.get(i).getWeight();
        }
        return new FoodResponseDTO(foodRequestDTO.getName(), suma);
    }

    @Override
    public HashMap<String, Integer> getIngredients(FoodRequestDTO foodRequestDTO) {
        HashMap<String, Integer> caloriesPerIngredient = new HashMap<String, Integer>();
        ArrayList<IngredientRequestDTO> ingredientsPerFood = foodRequestDTO.getIngredients();
        for (int i = 0; i < ingredientsPerFood.size(); i++) {
            String name = ingredientsPerFood.get(i).getName();
            Integer calories = calculadoraRepository.findIngredientByName(name).getCalories();
            Integer weight = ingredientsPerFood.get(i).getWeight();
            caloriesPerIngredient.put(name, calories * weight);
        }
        return caloriesPerIngredient;
    }

    @Override
    public IngredientResponseDTO getFatestIngredient(FoodRequestDTO foodRequestDTO) {
        ArrayList<IngredientRequestDTO> ingredientsPerFood = foodRequestDTO.getIngredients();
        String name = foodRequestDTO.getIngredients().get(0).getName();
        int calories = calculadoraRepository.findIngredientByName(name).getCalories();
        for (int i = 1; i < ingredientsPerFood.size(); i++) {
            if(calculadoraRepository.findIngredientByName(foodRequestDTO.getIngredients().get(i).getName()).getCalories() > calories) {
                name = foodRequestDTO.getIngredients().get(i).getName();
                calories = calculadoraRepository.findIngredientByName(name).getCalories();
            }
        }
        return new IngredientResponseDTO(name, calories);

}}


