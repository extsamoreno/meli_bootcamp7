package com.ejercitacion.ejercitacion.calories.dto;

public class CaloriesDTO {

    private String name;
    private Integer calories;

    public CaloriesDTO(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public CaloriesDTO() {
    }

    public String getName() {
        return name;
    }

    public CaloriesDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCalories() {
        return calories;
    }

    public CaloriesDTO setCalories(Integer calories) {
        this.calories = calories;
        return this;
    }
}
