package com.clase3spring.demo.calculatorCalories.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    private String name;
    private Integer weight;
}
