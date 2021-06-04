package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.service.dto.IngredientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService implements IIngredientService{

    @Override
    public List<IngredientDTO> getAll() {
        return new GenericLoader<List<IngredientDTO>>().loadData("classpath:food.json");
    }
}
