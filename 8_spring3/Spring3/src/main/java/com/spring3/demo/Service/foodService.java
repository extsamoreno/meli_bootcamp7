package com.spring3.demo.Service;


import com.spring3.demo.Objects.DTO.IngredientInput;
import com.spring3.demo.Objects.Ingredient;
import com.spring3.demo.Repository.IRepository;
import com.spring3.demo.Objects.DTO.DishDTO;
import com.spring3.demo.Objects.DTO.IngredientDTO;
import com.spring3.demo.Objects.Mapper.IngredientMapper;
import com.spring3.demo.Objects.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

@Service
public class foodService implements IfoodService {

    static ArrayList<Ingredient> foodList;

    @Autowired
    IRepository iRepository;

    @Override
    public DishDTO getfood(Dish dish) throws IOException {
        DishDTO dishDTO = new DishDTO();

        ArrayList<Ingredient> listIngredient = new ArrayList<>();

        for (IngredientInput ing: dish.getIngredientInputs()) {
            Ingredient ingredient = iRepository.getIngredientByName(ing.getName());
            float calorias = ingredient.getCalories() * (ing.getWeight() / 100);
            listIngredient.add(new Ingredient(ingredient.getName(),calorias));
        }

        IngredientDTO mostCalories = IngredientMapper.toIngredientDTO(mostCaloriesIngredient(listIngredient));
        dishDTO.setMostCaloriesIngredient(mostCalories);

        float totalCalories = totalCalories(listIngredient);
        dishDTO.setTotalCalories(totalCalories);

        // Ingredientes to DTO
        dishDTO.setListIngredients(toDTO(listIngredient));
        return dishDTO;
    }

    @Override
    public ArrayList<DishDTO> getListFood(ArrayList<Dish> listDish) throws IOException {
        ArrayList<DishDTO> listDTO = new ArrayList<>();

        for (Dish dish: listDish) {
            listDTO.add(getfood(dish));
        }
        return listDTO;
    }

    public ArrayList<IngredientDTO> toDTO(ArrayList<Ingredient> ingredients){
        ArrayList<IngredientDTO> listDTO = new ArrayList<>();
        ingredients.forEach(ingredient -> listDTO.add(IngredientMapper.toIngredientDTO(ingredient)));
        return listDTO;
    }

    public float totalCalories(ArrayList<Ingredient> ingredients){
        return (float) ingredients.stream().mapToDouble(Ingredient::getCalories).sum();
    }

    public Ingredient mostCaloriesIngredient(ArrayList<Ingredient> ingredients){
        return ingredients.stream().max(Comparator.comparing(Ingredient::getCalories)).get();
    }

}
