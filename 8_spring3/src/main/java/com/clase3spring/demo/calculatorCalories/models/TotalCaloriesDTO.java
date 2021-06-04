package com.clase3spring.demo.calculatorCalories.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalCaloriesDTO {
    private Meal meal;
    private Integer result;
}
