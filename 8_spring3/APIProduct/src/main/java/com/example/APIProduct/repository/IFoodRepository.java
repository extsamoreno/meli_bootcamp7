package com.example.APIProduct.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepository {
    Ingredient getById(Integer id);
}
