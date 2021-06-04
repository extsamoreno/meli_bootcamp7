package com.example.APIProduct.repository;

import com.example.APIProduct.services.dto.IngredientDTO;
import org.springframework.stereotype.Repository;


public interface IFoodRepository {
    Ingredient getByName(String name);
}
