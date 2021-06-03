package com.meli.caloria.service;

import com.meli.caloria.repository.Ingredient;
import com.meli.caloria.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService implements IIngredientService{
    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getIngredients() {
        return ingredientRepository.getIngredientList();
    }
}
