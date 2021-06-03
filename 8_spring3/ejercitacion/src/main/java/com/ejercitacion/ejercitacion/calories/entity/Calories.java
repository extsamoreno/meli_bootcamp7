package com.ejercitacion.ejercitacion.calories.entity;

public class Calories {

    private String name;
    private Integer calories;

    public Calories(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public Calories() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
