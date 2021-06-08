package com.example.demo.calculadora.service;

import com.example.demo.calculadora.Dish;
import com.example.demo.calculadora.repository.Ingredients;
import com.example.demo.calculadora.repository.IngredientsRepository;
import com.example.demo.calculadora.service.dto.DishDTO;
import com.example.demo.calculadora.service.dto.IngredientsDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DishService implements IDishService{
    private final IngredientsRepository ingredientsRepository;

    public DishService(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public DishDTO totalCalories(Dish dish) {
        DishDTO dishDTO = new DishDTO();
        dishDTO.setName(dish.getName());
        int sum =0;
        for (int i=0; i<dish.getListIngredients().size();i++){
            String nameIngredients = dish.getListIngredients().get(i).getName();
            int weight= ingredientsRepository.getCalories(nameIngredients);
            sum += weight;
        }
        dishDTO.setCalories(sum);
        return dishDTO;
    }

    @Override
    public DishDTO ingredientsCalories(Dish dish) {
        ArrayList<Ingredients> arrayList = new ArrayList<>();
        for (int i=0; i<dish.getListIngredients().size();i++){
            String nameIngredients = dish.getListIngredients().get(i).getName();
            int calories= ingredientsRepository.getCalories(nameIngredients);
            Ingredients ingredients = new Ingredients();
            ingredients.setName(nameIngredients);
            ingredients.setCalories(calories);
            arrayList.add(ingredients);
        }
        DishDTO dishDTO = new DishDTO();
        int calories = this.totalCalories(dish).getCalories();
        dishDTO.setCalories(calories);
        dishDTO.setName(dish.getName());
        dishDTO.setArrayList(arrayList);
        return dishDTO;

    }

    @Override
    public IngredientsDTO moreCalories(Dish dish) {
        int sumCalories = 0;
        IngredientsDTO ingredientsDTO = new IngredientsDTO();
        for (int i =0;i<dish.getListIngredients().size();i++) {
            String nameIngredients = dish.getListIngredients().get(i).getName();
            int calories= ingredientsRepository.getCalories(nameIngredients);
            if (sumCalories<calories) {
                sumCalories=calories;
                ingredientsDTO.setCalories(sumCalories);
                ingredientsDTO.setName(nameIngredients);
            }
        }
        return ingredientsDTO;
    }


}
