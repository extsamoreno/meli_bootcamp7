package com.meli.caloria.service;

import com.meli.caloria.repository.Dish;
import com.meli.caloria.repository.Ingredient;
import com.meli.caloria.repository.IngredientRepository;
import com.meli.caloria.service.dto.DishDTO;
import com.meli.caloria.service.dto.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService implements IDishService{
    @Autowired
    public IngredientRepository ingredientRepository;

    @Override
    public DishDTO calcularCaloriasTotales(Dish dish) {
        List<IngredientDTO> listDish= dish.getIngredientes();

        double calorias=0;
        for (int i = 0; i < listDish.size(); i++) {
            calorias+=((ingredientRepository.getIngredientByName(listDish.get(i).getName()).getCalories()/100)*listDish.get(i).getWeight());
        }
        return new DishDTO(dish.getNombre(),calorias);
    }

    @Override
    public List<Ingredient> imprimirCaloriasPorIngrediente(Dish dish){
        List<IngredientDTO> listDish=dish.getIngredientes();
        List<Ingredient> finalList=new ArrayList<>();
        for (int i = 0; i < listDish.size(); i++) {
            finalList.add(ingredientRepository.getIngredientByName(listDish.get(i).getName()));
        }
        return finalList;
    }

    @Override
    public Ingredient calcularIngredienteMasCalorico(Dish dish) {
        List<IngredientDTO> listDish=dish.getIngredientes();
        double caloriasMax=0;
        Ingredient max= null;
        for (int i = 0; i < listDish.size(); i++) {
            if(ingredientRepository.getIngredientByName(listDish.get(i).getName()).getCalories()>caloriasMax){
                caloriasMax=ingredientRepository.getIngredientByName(listDish.get(i).getName()).getCalories();
                max=ingredientRepository.getIngredientByName(listDish.get(i).getName());
            }
        }
        return max;
    }
}
