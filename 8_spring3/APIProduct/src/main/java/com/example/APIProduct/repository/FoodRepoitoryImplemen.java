package com.example.APIProduct.repository;

import org.springframework.stereotype.Repository;

@Repository
public class FoodRepoitoryImplemen implements IFoodRepository {

    @Override
    public Ingredient getById(Integer id) {
        return new Ingredient("onion", 100);
    }
}
