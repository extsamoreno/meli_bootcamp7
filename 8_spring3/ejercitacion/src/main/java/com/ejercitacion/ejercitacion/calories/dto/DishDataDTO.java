package com.ejercitacion.ejercitacion.calories.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DishDataDTO {

    @JsonProperty("total_calories")
    private Integer totalCalories;
    @JsonProperty("ingredients_calories")
    private List<com.ejercitacion.ejercitacion.calories.dto.CaloriesDTO> ingredientsCalories;
    @JsonProperty("highest_calories_ingredient")
    private com.ejercitacion.ejercitacion.calories.dto.CaloriesDTO highestCaloriesIngredient;

    public DishDataDTO(Integer totalCalories, List<com.ejercitacion.ejercitacion.calories.dto.CaloriesDTO> ingredientsCalories, com.ejercitacion.ejercitacion.calories.dto.CaloriesDTO highestCaloriesIngredient) {
        this.totalCalories = totalCalories;
        this.ingredientsCalories = ingredientsCalories;
        this.highestCaloriesIngredient = highestCaloriesIngredient;
    }

    public DishDataDTO() {
    }

    public Integer getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(Integer totalCalories) {
        this.totalCalories = totalCalories;
    }

    public List<com.ejercitacion.ejercitacion.calories.dto.CaloriesDTO> getIngredientsCalories() {
        return ingredientsCalories;
    }

    public void setIngredientsCalories(List<com.ejercitacion.ejercitacion.calories.dto.CaloriesDTO> ingredientsCalories) {
        this.ingredientsCalories = ingredientsCalories;
    }

    public com.ejercitacion.ejercitacion.calories.dto.CaloriesDTO getHighestCaloriesIngredient() {
        return highestCaloriesIngredient;
    }

    public void setHighestCaloriesIngredient(com.ejercitacion.ejercitacion.calories.dto.CaloriesDTO highestCaloriesIngredient) {
        this.highestCaloriesIngredient = highestCaloriesIngredient;
    }
}
