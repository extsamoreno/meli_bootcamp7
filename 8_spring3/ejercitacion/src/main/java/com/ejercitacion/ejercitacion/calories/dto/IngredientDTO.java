package com.ejercitacion.ejercitacion.calories.dto;

public class IngredientDTO {

    private String name;
    private Integer weight;

    public IngredientDTO(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public IngredientDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
