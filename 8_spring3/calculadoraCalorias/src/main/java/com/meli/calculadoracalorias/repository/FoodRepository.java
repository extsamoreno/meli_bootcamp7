package com.meli.calculadoracalorias.repository;

import com.meli.calculadoracalorias.service.IIngredientService;
import com.meli.calculadoracalorias.service.dto.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepository implements IFoodRepository {

    @Autowired
    IIngredientService ingredientService;

    @Override
    public IngredientDTO findIngredientByName(String name) {
        List<IngredientDTO> ingredientsDto = null;
        ingredientsDto = ingredientService.getAllInDto();
        IngredientDTO ingredient = null;
        if (ingredientsDto != null) {
            Optional<IngredientDTO> item = ingredientsDto.stream().filter(i -> i.getName().equals(name)).findFirst();
            if (item.isPresent()) ingredient = item.get();
        }
        return ingredient;
    }
}
