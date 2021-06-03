package com.ejercitacion.ejercitacion.calories.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DishDTO {

    private String name;
    @JsonProperty("ingredients")
    private List<IngredientDTO> ingredientDTOS;

    public DishDTO(String name, List<com.ejercitacion.ejercitacion.calories.dto.IngredientDTO> ingredientDTOS) {
        this.name = name;
        this.ingredientDTOS = ingredientDTOS;
    }

    public DishDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.ejercitacion.ejercitacion.calories.dto.IngredientDTO> getIngredientes() {
        return ingredientDTOS;
    }

    public void setIngredientes(List<com.ejercitacion.ejercitacion.calories.dto.IngredientDTO> ingredientDTOS) {
        this.ingredientDTOS = ingredientDTOS;
    }
}
