package com.example.food.services.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsDTO {
    private String name;
    private Integer quant;
    private double calories;
}
