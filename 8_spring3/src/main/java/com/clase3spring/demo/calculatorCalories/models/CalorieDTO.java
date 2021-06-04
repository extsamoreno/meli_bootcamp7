package com.clase3spring.demo.calculatorCalories.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalorieDTO {
    private String name;
    private int calories;
}
