package com.example.demo.repository;

import com.example.demo.service.DTO.IngredientsDTO;

public interface IIngredientsRepository {
    public IngredientsDTO findCalorias(Ingredients ingredient);
}
