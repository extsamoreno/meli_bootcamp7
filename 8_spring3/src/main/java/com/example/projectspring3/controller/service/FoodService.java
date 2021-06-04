package com.example.projectspring3.controller.service;

import com.example.projectspring3.controller.repository.Dish;
import com.example.projectspring3.controller.repository.IFoodService;
import com.example.projectspring3.controller.repository.IIngredientsRepository;
import com.example.projectspring3.controller.repository.Ingredients;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class FoodService implements IFoodService {
    @Autowired
    IIngredientsRepository iIngredientsRepository;

    List<Dish> listaDish = new ArrayList<>();


    @Override
    public void saveDish(Dish dish){
        listaDish.add(dish);
    }


    @Override
    public int getCalDish(Dish dish) {

        int calorias=0;
        String ingredientes = "Ajos";
        for(Ingredients ingredients:dish.getListaIngredientes()){
            ingredientes = ingredients.getName();
            calorias = calorias + iIngredientsRepository.findCaloriesByName(ingredientes).getCalories();
        }
        return calorias;
    }

    @Override
    public Dish getDishByName(String name) {
        Dish resultado = null;
        for(Dish dish:listaDish){
            if(dish.getName().equals(name)){
                resultado = dish;
                break;
            }
        }
        return resultado;
    }

    @Override
    public List<CaloriesResponse> getCalIngredients(Dish dish) {

        List<CaloriesResponse> listaCalorias = new ArrayList<>();
        for(Ingredients ingredients:dish.getListaIngredientes()){
            listaCalorias.add(new CaloriesResponse(ingredients.getName(),iIngredientsRepository.findCaloriesByName(ingredients.getName()).getCalories()));
        }
        return listaCalorias;
    }

    @Override
    public CaloriesDTO getMaxIngredients(Dish dish) {
        CaloriesDTO maxIngredientsCalories = new CaloriesDTO();
        int maxCalories = 0;
        for(Ingredients ingredients:dish.getListaIngredientes()){
            CaloriesDTO caloriesDTO = iIngredientsRepository.findCaloriesByName(ingredients.getName());
            if(caloriesDTO.getCalories()>maxCalories){
                maxCalories = caloriesDTO.getCalories();
                maxIngredientsCalories = caloriesDTO;
            }
        }
        return maxIngredientsCalories;
    }


}
