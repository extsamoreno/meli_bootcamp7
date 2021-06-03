package com.spring.exercise.food.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Dish {
    private String name;
    private List<Ingredient> ingredients;
}
