package com.meli.caloriescalculator.entity;

import lombok.Data;

import java.util.List;

@Data
public class Dish {

    private String name;
    private List<Ingredient> ingredientList;

}
