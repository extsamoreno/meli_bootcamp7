package com.example.APIProduct.services;

import com.example.APIProduct.repository.Food;
import com.example.APIProduct.repository.IFoodRepository;
import com.example.APIProduct.repository.Ingredient;
import com.example.APIProduct.services.dto.FoodResponseDTO;
import com.example.APIProduct.services.dto.IngredientDTO;
import com.example.APIProduct.services.mapper.IngredientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class FoodServiceImple implements  IFoodService{

    @Autowired
    IFoodRepository iFoodRepository;



    @Override
    public FoodResponseDTO getTotalCalories(Food food) {

        System.out.println(food.getListIngredient());
        List<Ingredient> listIngredients = food.getListIngredient();
        List<IngredientDTO> listIngredientDTO = null;

        for(Ingredient ing: listIngredients){
            System.out.println(iFoodRepository.getByName(ing.getName()).getCalories());
            System.out.println(IngredientMapper.toDTO(ing, iFoodRepository.getByName(ing.getName()).getCalories()));
            IngredientDTO aux = IngredientMapper.toDTO(ing, iFoodRepository.getByName(ing.getName()).getCalories());
            listIngredientDTO.add(aux);
        }
        System.out.println(listIngredientDTO);

        //FoodResponseDTO foodResult = new FoodResponseDTO(food.getName(),TotalCalories(listIngredientDTO),listIngredientDTO,maxCalories(listIngredientDTO));
        FoodResponseDTO foodResult = new FoodResponseDTO();
        return foodResult;
    }
    public IngredientDTO maxCalories(List<IngredientDTO> list){
        IngredientDTO result=null;
        int aux=0;
        for(IngredientDTO ing: list){
            if(ing.getCalories()>aux){
                result = ing;
            }
        }
        return result;
    }

    public int TotalCalories(List<IngredientDTO> list){
        int sumCalories=0;
        for (IngredientDTO ing: list) {
            sumCalories+= ing.getCalories();
        }
        return sumCalories;
    }
}
