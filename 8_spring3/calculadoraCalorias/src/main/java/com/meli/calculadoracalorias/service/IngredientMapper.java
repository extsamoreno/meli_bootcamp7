package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.domain.Ingredient;
import com.meli.calculadoracalorias.service.dto.IngredientDTO;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper implements IGenericMapper<Ingredient, IngredientDTO, Object> {
    @Override
    public IngredientDTO toDto(Ingredient model) {
        return new IngredientDTO(model.getName(), model.getCalories());
    }

    @Override
    public Ingredient toModel(IngredientDTO dto) {
        //dto.getCalories()
        return new Ingredient(dto.getName(), dto.getCalories(), 0);
    }

    @Override
    public Object toDtoResponse(Ingredient model) {
        return null;
    }
}
