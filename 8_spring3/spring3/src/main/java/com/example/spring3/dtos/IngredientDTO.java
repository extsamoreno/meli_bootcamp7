package com.example.spring3.dtos;

import lombok.*;

@Data
@AllArgsConstructor
public class IngredientDTO {
    private String name;
    private double weight; // in gr
}
