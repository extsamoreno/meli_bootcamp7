package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.service.dto.IngredientDTO;

import java.util.List;

public interface IIngredientService {
    List<IngredientDTO> getAll();
}
